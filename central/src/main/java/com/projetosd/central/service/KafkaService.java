package com.projetosd.central.service;

import com.projetosd.central.config.kafka.ProducerConfig;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class KafkaService {

    private final ProducerConfig kafkaProducerConfig;

    private Logger log = Logger.getLogger(KafkaService.class.getName());

    public void createMensagem(String key, String topic, String message){

        String info = String.format("criando mensagem %s no topico %s com a chave %s", message, topic, key);
        log.info(info);
        Future<RecordMetadata> send = kafkaProducerConfig
                .producerFactory()
                .createProducer()
                .send(new ProducerRecord<>(topic, key, message));
    }

}
