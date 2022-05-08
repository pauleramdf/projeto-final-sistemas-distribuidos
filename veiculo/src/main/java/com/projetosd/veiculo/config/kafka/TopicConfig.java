package com.projetosd.veiculo.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {
    @Value("${spring.enviroment.id}")
    private String VEICULO_ID;

    @Bean
    public NewTopic alertTopic() {
        return TopicBuilder.name("alerta")
                .build();
    }

    @Bean
    public NewTopic directTopic() {
        return TopicBuilder.name("mensagem-direta-" + VEICULO_ID)
                .build();
    }

    @Bean
    public NewTopic paradaTopic() {
        return TopicBuilder.name("parada")
                .build();
    }

    @Bean
    public NewTopic posicaoTopic() {
        return TopicBuilder.name("posicao")
                .build();
    }
}