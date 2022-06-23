package com.sparks.user.compent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.sparks.common.constant.RabbitmqConstant.TEST_TOPIC_QUEUE;

/**
 * @author peng.zhou
 * @date Created in 2022/5/12 17:51
 */
@Slf4j
@Component
public class Topic2Consumer {

    @RabbitListener(queues = TEST_TOPIC_QUEUE)
    public void handle(String message) {
        log.info("String2:{}", message);
    }

}
