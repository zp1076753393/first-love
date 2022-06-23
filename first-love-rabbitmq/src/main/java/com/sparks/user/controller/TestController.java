package com.sparks.user.controller;

import com.sparks.user.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author peng.zhou
 * @date Created in 2022/5/13 14:38
 */
@RequestMapping
@RestController
public class TestController {

    @Autowired
    private ITestService testService;

    @PostMapping("/test-string")
    Map<String, String> sendString() {
        testService.sendString();
        return null;
    }

    @PostMapping("/test-Integer")
    Map<String, String> sendInteger() {
        testService.sendInteger();
        return null;
    }

    @PostMapping("/topic")
    Map<String, String> sendTopic() {
        testService.sendTopic();
        return null;
    }

    @PostMapping("/dlx")
    Map<String, String> sendDlx() {
        testService.sendDlx();
        return null;
    }

    @PostMapping("/ttl")
    Map<String, String> sendTtl() {
        testService.sendTtl();
        return null;
    }

    @PostMapping("/delay")
    Map<String, String> sendDelay() {
        testService.sendDelay();
        return null;
    }

}
