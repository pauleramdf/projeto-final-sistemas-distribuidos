package com.projetosd.veiculo.service;

import com.projetosd.veiculo.constants.LocalStorage;
import com.projetosd.veiculo.model.Mensagem;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class VeiculoService {
    @Value("${spring.enviroment.id}")
    private String VEICULO_ID;

    private final KafkaService kafkaService;

    public String mensagemDireta(Mensagem mensagem){
        System.out.println("enviando <" + mensagem.getMensagem()+"> para: "+mensagem.getDestino());
        String key = UUID.randomUUID().toString();
        kafkaService.createMensagem(key,"mensagem-direta-" +mensagem.getDestino(),mensagem.getMensagem());
        return "enviado";
    }

    public String mensagemCentral(Mensagem mensagem) {
        System.out.println("enviando <" + mensagem.getMensagem()+"> para: central");
        String key = UUID.randomUUID().toString();
        kafkaService.createMensagem(key,"mensagem-central", mensagem.getMensagem());
        return "enviado";
    }

    public String alerta(Mensagem mensagem) {
        System.out.println("enviando alerta <" + mensagem.getMensagem()+"> para todos");
        String key = UUID.randomUUID().toString();
        kafkaService.createMensagem(key,"alerta", mensagem.getMensagem());
        return "enviado";
    }

    public String paradaProgramada(Mensagem mensagem) {
//        String key = UUID.randomUUID().toString();
        LocalStorage.setVeiculoAtivo(false);
        kafkaService.createMensagem(VEICULO_ID, "parada", mensagem.getMensagem());
        CompletableFuture.delayedExecutor(mensagem.getTempoParada(), TimeUnit.SECONDS).execute(() -> {
            LocalStorage.setVeiculoAtivo(true);
        });
        return "enviado";
    }

    public String informarPosicao(Mensagem mensagem){
        kafkaService.createMensagem(VEICULO_ID, "posicao", mensagem.getMensagem());
        return "enviado";
    }
}
