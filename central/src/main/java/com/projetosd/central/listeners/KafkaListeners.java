package com.projetosd.central.listeners;

import com.projetosd.central.constants.LocalStorage;
import com.projetosd.veiculo.model.Veiculo;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Map;
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
    public void alerta(String message){
        log.info("alerta " + message);
    }

    @KafkaListener(id = "parada", topics = "parada",groupId = "central")
    public void paradaProgramada(String message){
        log.info("parada " + message);
    }

    @KafkaListener(id = "novo-veiculo", topics = "novo-veiculo",groupId = "central", containerFactory = "kafkaListenerVeiculoFactory")
    public void novoVeiculo(Veiculo veiculo){
        log.info("novo veiculo cadastrado: " + veiculo.toString());
        Map<Integer, Veiculo> map = LocalStorage.getVeiculosCadastrados();
        map.put(veiculo.getId(), veiculo);
        LocalStorage.setVeiculosCadastrados(map);
    }

    @KafkaListener(id = "posicao", topics = "posicao",groupId = "central", containerFactory = "kafkaListenerVeiculoFactory")
    public void posicao(@Payload Veiculo veiculo){
        Map<Integer, Veiculo> map = LocalStorage.getVeiculosCadastrados();
        map.put(veiculo.getId(), veiculo);
        LocalStorage.setVeiculosCadastrados(map);
        log.info(veiculo.toString());
    }
}
