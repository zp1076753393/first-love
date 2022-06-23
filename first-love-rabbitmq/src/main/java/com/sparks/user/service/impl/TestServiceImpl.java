package com.sparks.user.service.impl;

import com.sparks.user.compent.TestProducer;
import com.sparks.user.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author peng.zhou
 * @date Created in 2022/5/13 14:38
 */
@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    private TestProducer testProducer;

    @Override
    public void sendString() {
        testProducer.sendString();
    }

    @Override
    public void sendInteger() {
        testProducer.sendInteger();
    }

    @Override
    public void sendTopic() {
        testProducer.sendTopic();
    }

    @Override
    public void sendDlx() {
        testProducer.sendDlx();
    }

    @Override
    public void sendTtl() {
        testProducer.sendTtl();
    }

    @Override
    public void sendDelay() {
        testProducer.sendDelay();
    }
}
