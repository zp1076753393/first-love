package com.sparks.user.compent;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.sparks.common.constant.RabbitmqConstant.*;

/**
 * @author peng.zhou
 * @date Created in 2022/5/13 14:02
 */
@Component
public class TestProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendString() {
        for (int i = 0; i < 20; i++) {
            rabbitTemplate.convertAndSend(TEST_DIRECT_EXCHANGE, TEST_DIRECT_ROUTING_KEY + "11", "测试呢", new CorrelationData());
        }
    }

    public void sendInteger() {
        for (int i = 0; i < 20; i++) {
            rabbitTemplate.convertAndSend(TEST_DIRECT_EXCHANGE, TEST_DIRECT_ROUTING_KEY + "11", 1, new CorrelationData());
        }
    }

    public void sendTopic() {
        rabbitTemplate.convertAndSend(TEST_TOPIC_EXCHANGE, "topic.test", "topic", new CorrelationData());
    }

    public void sendDlx() {
        rabbitTemplate.convertAndSend(DELAY_EXCHANGE, DELAY_ROUTING_KEY
                , "dlx延时测试， 发送时间：" + System.currentTimeMillis()
                , new CorrelationData());
    }

    public void sendTtl() {
        rabbitTemplate.convertAndSend(DELAY_EXCHANGE, DELAY_ROUTING_KEY
                , "ttl延时测试， 发送时间：" + System.currentTimeMillis()
                // 设置消息有效期，即延时时限，10s
                , message -> {
                    message.getMessageProperties().setExpiration("10000");
                    return message;
                });
    }

    public void sendDelay() {
        rabbitTemplate.convertAndSend(DELAY_PLUGIN_EXCHANGE, DELAY_PLUGIN_ROUTING_KEY
                , "delay插件延时测试， 发送时间：" + System.currentTimeMillis()
                // 设置消息有效期，即延时时限，30s
                , message -> {
                    message.getMessageProperties().setHeader("x-delay", "30000");
                    return message;
                });
    }

}
