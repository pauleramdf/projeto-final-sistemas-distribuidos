package com.projetosd.central.service;

import com.projetosd.central.model.Mensagem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CentralService {

    private final KafkaService kafkaService;
    public String enviarMensagem(Mensagem mensagem) {
        kafkaService.createMensagem("central","mensagem-direta-"+mensagem.getDestino(),mensagem.getMensagem());
        return "enviado";
    }

    public String alerta(Mensagem mensagem) {
        kafkaService.createMensagem(UUID.randomUUID().toString(),"alerta", mensagem.getMensagem());
        return "enviado";
    }
}
