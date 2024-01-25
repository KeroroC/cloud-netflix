package com.keroro;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wangpeng
 * @since 2024年01月26日 00:25
 */
@RunWith(SpringRunner.class)
@EnableBinding({SinkApplicationTest.SinkSender.class})
public class SinkApplicationTest {

    @Autowired
    private SinkSender sinkSender;

    @Test
    public void sinkSenderTest() {
        sinkSender.output().send(MessageBuilder.withPayload("produce a message: hello world").build());
    }

    public interface SinkSender {
        String OUTPUT = "input";

        @Output(SinkSender.OUTPUT)
        MessageChannel output();
    }
}
