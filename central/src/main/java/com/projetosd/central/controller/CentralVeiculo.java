package com.projetosd.central.controller;

import com.projetosd.central.constants.LocalStorage;
import com.projetosd.central.model.Mensagem;
import com.projetosd.central.service.CentralService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/central")
@RequiredArgsConstructor
public class CentralVeiculo {

    private final CentralService centralService;

    @PostMapping("/mensagem_direta")
    public ResponseEntity<?> enviarMensagem(@RequestBody Mensagem mensagem){
        return new ResponseEntity(centralService.enviarMensagem(mensagem), HttpStatus.OK);
    }

    @PostMapping("/alerta")
    public ResponseEntity<?> enviarAlerta(@RequestBody Mensagem mensagem){
        return new ResponseEntity(centralService.alerta(mensagem), HttpStatus.OK);
    }

    @GetMapping("/veiculos")
    public ResponseEntity<?> veiculos(){
        System.out.println(LocalStorage.getVeiculosCadastrados());
        return new ResponseEntity<>(LocalStorage.getVeiculosCadastrados(), HttpStatus.OK);
    }
}
