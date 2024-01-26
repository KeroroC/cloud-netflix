package com.keroro;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangpeng
 * @since 2024年01月26日 16:39
 */
@RestController
@EnableBinding(Source.class)
public class MessageController {

    private final Source source;

    public MessageController(Source source) {
        this.source = source;
    }

    @GetMapping("send")
    public void sendMessage(String msg) {
        source.output().send(MessageBuilder.withPayload(msg).build());
    }
}
