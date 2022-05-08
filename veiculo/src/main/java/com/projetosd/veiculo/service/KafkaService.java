package com.projetosd.veiculo.service;

import com.projetosd.veiculo.config.kafka.ProducerConfig;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class KafkaService {
    @Value("${spring.enviroment.id}")
    private String VEICULO_ID;

    private final ProducerConfig kafkaProducerConfig;

    public void createMensagem(String key, String topic, String message){

        Future<RecordMetadata> send = kafkaProducerConfig
                .producerFactory()
                .createProducer()
                .send(new ProducerRecord<>(topic, key, message));
    }
    @PostConstruct
    public void init(){
        System.out.println("iniciado o listenner com"+VEICULO_ID);
        createMensagem("equipamento "+VEICULO_ID, "novo-veiculo", VEICULO_ID);
    }
}