package com.projetosd.central;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CentralApplication {

    public static void main(String[] args) {
        SpringApplication.run(CentralApplication.class, args);
    }

}


//    Receber posição e velocidade dos veículos
//  Receber mensagem do veículo para a central de monitoramento
//         Receber alerta
//         Receber parada programada
//         Enviar mensagem para um veículo
//         Enviar alerta