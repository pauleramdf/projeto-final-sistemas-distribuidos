package com.projetosd.veiculo.service;

import com.projetosd.veiculo.constants.LocalStorage;
import com.projetosd.veiculo.model.Veiculo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class GeneratePositions {
    private Random gerador = new Random();
    @Value("${spring.enviroment.id}")
    private String VEICULO_ID;

    private Logger log = Logger.getLogger(GeneratePositions.class.getName());

    private final KafkaService kafkaService;

    @PostConstruct
    public void init(){
        LocalStorage.setVeiculoAtivo(true);
    }

    @Scheduled(fixedRate = 5000L, initialDelay = 10000L)
    @PostConstruct
    public void posicaoVeiculo(){
        int velocidade = 0;
        Veiculo veiculo = LocalStorage.getVeiculo();
        if(LocalStorage.isVeiculoAtivo()){
            veiculo.setVelocidade(gerador.nextInt(100));
            int x = gerador.nextInt(-90,90);
            int y = gerador.nextInt(-180,180);
            veiculo.setPosicao("(lat: " +y+ ", lng: "+ x+")");
            log.info("veiculo em movimento");
            kafkaService.createMensagem(VEICULO_ID,"posicao",veiculo.toString());
        }
        else{
            veiculo.setVelocidade(0);
            log.info("veiculo parado");
            kafkaService.createMensagem(VEICULO_ID,"posicao",veiculo.toString());
        }
    }
}
