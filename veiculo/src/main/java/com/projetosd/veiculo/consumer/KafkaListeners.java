package com.projetosd.veiculo.consumer;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@EnableKafka
@RequiredArgsConstructor
public class KafkaListeners {
    @Value("${spring.enviroment.id}")
    private String VEICULO_ID;

    private Logger log = Logger.getLogger(KafkaListeners.class.getName());

    @KafkaListener(topics = "mensagem-direta-#{'${VEICULO_ID:1}'}", groupId = "group1")
    public void mensagemDireta(ConsumerRecord<String, String> record){
        log.info("chegou mensagem direta");
        System.out.println(record.key());
        System.out.println("chegou a mensagem: " + record.value());
    }

    @KafkaListener(topics = "alerta",groupId = "group1")
    public void alerta(ConsumerRecord<String, String> record){
        System.out.println("listener");
    }
}
