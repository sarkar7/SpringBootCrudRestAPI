package com.poc.crud.api.consumer.component;

import com.poc.crud.api.models.SystemMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageConsumer {

    @JmsListener(destination = "sarkar-queue")
    public void messageListener(SystemMessage systemMessage) {
        log.info("Message received! {}", systemMessage);
    }

}
