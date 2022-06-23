package com.sparks.user.compent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.sparks.common.constant.RabbitmqConstant.DELAY_PLUGIN_QUEUE;

/**
 * @author peng.zhou
 * @date Created in 2022/5/12 17:51
 */
@Slf4j
@Component
@RabbitListener(queues = DELAY_PLUGIN_QUEUE)
public class DelayConsumer {

    @RabbitHandler
    public void handle(String message) {
        log.info("{}, 消费时间：{}", message, System.currentTimeMillis());
    }

}
