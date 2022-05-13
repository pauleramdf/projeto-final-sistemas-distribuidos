package com.projetosd.central.listeners;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class KafkaListeners {
    private Logger log = Logger.getLogger(KafkaListeners.class.getName());

    @KafkaListener(id = "mensagem-central", topics = "mensagem-central", groupId = "central")
    public void mensagemDireta(ConsumerRecord<String, String> record){
        log.info("chegou mensagem direta " + record.value());
    }

    @KafkaListener(id = "alerta", topics = "alerta",groupId = "central")
    public void alerta(@Payload String message){
        log.info("alerta " + message);
    }

    @KafkaListener(id = "parada", topics = "parada",groupId = "central")
    public void paradaProgramada(@Payload String message){
        log.info("parada " + message);
    }

    @KafkaListener(id = "posicao", topics = "posicao",groupId = "central")
    public void posicao(@Payload String message){
        log.info("posicao " + message);
    }
}
