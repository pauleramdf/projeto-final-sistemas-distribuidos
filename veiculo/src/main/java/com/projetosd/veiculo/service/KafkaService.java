package com.projetosd.veiculo.service;

import com.projetosd.veiculo.config.kafka.ProducerConfig;
import com.projetosd.veiculo.listeners.KafkaListeners;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.Future;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class KafkaService {
    @Value("${spring.enviroment.id}")
    private String VEICULO_ID;

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
    @PostConstruct
    public void init(){
        createMensagem("equipamento "+VEICULO_ID, "novo-veiculo", VEICULO_ID);
    }
}