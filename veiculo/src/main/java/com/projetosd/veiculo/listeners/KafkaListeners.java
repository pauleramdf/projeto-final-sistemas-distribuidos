package com.projetosd.veiculo.listeners;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class KafkaListeners {
    @Value("${spring.enviroment.id}")
    private String VEICULO_ID;

    private Logger log = Logger.getLogger(KafkaListeners.class.getName());

    @KafkaListener(id = "mensagemdireta", topics = "mensagem-direta-#{'${VEICULO_ID:1}'}", groupId = "veiculos")
    public void mensagemDireta(ConsumerRecord<String, String> record){
        log.info("chegou mensagem direta");
        System.out.println(record.key());
        System.out.println("chegou a mensagem: " + record.value());
    }

    @KafkaListener(id = "alerta", topics = "alerta",groupId = "veiculos")
    public void alerta(@Payload String message){
        System.out.println("alerta: " +message);
    }
}
