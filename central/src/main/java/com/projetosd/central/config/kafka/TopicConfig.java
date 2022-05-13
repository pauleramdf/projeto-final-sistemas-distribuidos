package com.projetosd.central.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Bean
    public NewTopic alertTopic() {
        return TopicBuilder.name("alerta")
                .build();
    }

    @Bean
    public NewTopic posicaoTopic() {
        return TopicBuilder.name("mensagem-central")
                .build();
    }
}