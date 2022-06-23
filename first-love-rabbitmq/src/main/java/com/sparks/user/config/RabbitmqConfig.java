package com.sparks.user.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static com.sparks.common.constant.RabbitmqConstant.*;

/**
 * @author peng.zhou
 * @date Created in 2022/5/12 15:38
 */
@Slf4j
@Configuration
public class RabbitmqConfig {

    /**
     * 测试普通交换机
     *
     * @return 普通交换机
     */
    @Bean
    DirectExchange testExchange() {
        return ExchangeBuilder
                .directExchange(TEST_DIRECT_EXCHANGE)
                .build();
    }

    @Bean
    Queue testQueue() {
        return QueueBuilder
                .durable(TEST_DIRECT_QUEUE)
                .build();
    }

    @Bean
    Binding testBinding(DirectExchange testExchange, Queue testQueue) {
        return BindingBuilder
                .bind(testQueue)
                .to(testExchange)
                .with(TEST_DIRECT_ROUTING_KEY);
    }


    /**
     * topic模式
     *
     * @return
     */
    @Bean
    TopicExchange topicExchange() {
        return ExchangeBuilder
                .topicExchange(TEST_TOPIC_EXCHANGE)
                .build();
    }

    @Bean
    Queue topicQueue() {
        return QueueBuilder
                .durable(TEST_TOPIC_QUEUE)
                .build();
    }

    @Bean
    Binding topicBinding(Queue topicQueue, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(topicQueue)
                .to(topicExchange)
                .with(TEST_TOPIC_ROUTING_KEY);
    }

    /**
     * 采用DLX死信队列，实现延时队列
     * 分为两种设置延时时间的方式：
     * 1、直接为接受队列设置延时时间
     * 局限性：一个队列只能设置一个固定的延时，意味着根据业务不同，需要不同的延时时，需要新增不同的队列
     * 2、为具体的某一条消息增加延时属性
     * 局限性：将延时的颗粒度精细化到了具体的某一条消息体，但是由于队列先进先出的特性，会导致延时阻塞。
     * 例如，消息a，延时30分钟，消息b，延时10分钟；以a，b的顺序，在10点先后写入队列。而直到10点30，队列才能检测到消息a超时，放入死信队列；紧接着才能去判断消息b。
     * 此时就会导致，消息b，其实时在10点30的时候才转入死信队列。而按照需要消息b，应该在10点10的时候，放入死信队列。此种情况，即为延时阻塞。
     * <p>
     * 以上两种设置延时，同时使用时，较小的延时，将被率先检测到，率先执行。
     *
     * @return
     */
    @Bean
    DirectExchange delayExchange() {
        return ExchangeBuilder
                .directExchange(DELAY_EXCHANGE)
                .build();
    }

    @Bean
    Queue delayQueue() {
        return QueueBuilder
                .durable(DELAY_QUEUE)
                // 设置队列有效期，即延时时限
//                .withArgument("x-message-ttl", 6000)
                // 设置死信转发交换机
                .withArgument("x-dead-letter-exchange", DLX_EXCHANGE)
                // 设置死信路由
                .withArgument("x-dead-letter-routing-key", DLX_ROUTING_KEY)
                .build();
    }

    @Bean
    Binding delayBinding(Queue delayQueue, DirectExchange delayExchange) {
        return BindingBuilder
                .bind(delayQueue)
                .to(delayExchange)
                .with(DELAY_ROUTING_KEY);
    }

    @Bean
    DirectExchange dlxExchange() {
        return ExchangeBuilder
                .directExchange(DLX_EXCHANGE)
                .build();
    }

    @Bean
    Queue dlxQueue() {
        return QueueBuilder
                .durable(DLX_QUEUE)
                .build();
    }

    @Bean
    Binding dlxBinding(Queue dlxQueue, DirectExchange dlxExchange) {
        return BindingBuilder
                .bind(dlxQueue)
                .to(dlxExchange)
                .with(DLX_ROUTING_KEY);
    }

    /**
     * 采用rabbitmq的延时插件实现延时队列
     * <p>
     * 业务原理：延时插件可将交换机设置为延时交换机。当消息由生产者发送者延时交换机中
     * 延时交换机可根据消息携带的延时时限来判断消息是否到期，一旦到期则将消息按照路由，投递到队列中，最后按照先进先出的顺序，以此消费。
     * <p>
     * 对比DLX、TTL实现的优势：在保证了将延时时限具体颗粒度细化到单一消息本身的基础之上，又通过交换机与队列分离的方式，将延时动作置于交换机层面处理，
     * 从而避免了延时阻塞。
     *
     * @return
     */
    @Bean
    CustomExchange delayPluginExchange() {
        Map<String, Object> arguments = new HashMap<>(1);
        arguments.put("x-delayed-type", "direct");
        // 声明自定义队列，延时队列类型为 x-delayed-message 再指定延时队列采用的 x-delay-type 为 direct
        return new CustomExchange(DELAY_PLUGIN_EXCHANGE, "x-delayed-message", true, false, arguments);
    }

    @Bean
    Queue delayPluginQueue() {
        return QueueBuilder
                .durable(DELAY_PLUGIN_QUEUE)
                .build();
    }

    @Bean
    Binding delayPluginBinding(Queue delayPluginQueue, CustomExchange delayPluginExchange) {
        return BindingBuilder
                .bind(delayPluginQueue)
                .to(delayPluginExchange)
                .with(DELAY_PLUGIN_ROUTING_KEY)
                .noargs();
    }

}
