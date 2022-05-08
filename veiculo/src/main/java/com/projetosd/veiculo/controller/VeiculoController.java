package com.projetosd.veiculo.controller;

import com.projetosd.veiculo.model.Mensagem;
import com.projetosd.veiculo.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculo")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping("/parada")
    public ResponseEntity<?> paradaProgramada(@RequestBody Mensagem mensagem){
        return new ResponseEntity(veiculoService.paradaProgramada(mensagem), HttpStatus.OK);
    }

    @PostMapping("/alerta")
    public ResponseEntity<?> enviarAlerta(@RequestBody Mensagem mensagem){
        return new ResponseEntity(veiculoService.alerta(mensagem), HttpStatus.OK);
    }

    @PostMapping("/mensagem_central")
    public ResponseEntity<?> mensagemCentral(@RequestBody Mensagem mensagem){
        return new ResponseEntity(veiculoService.mensagemCentral(mensagem), HttpStatus.OK);
    }

    @PostMapping("/mensagem_direta")
    public ResponseEntity<?> mensagemDireta(@RequestBody Mensagem mensagem){
        return new ResponseEntity(veiculoService.mensagemDireta(mensagem), HttpStatus.OK);
    }

    @PostMapping("/informar_posicao")
    public ResponseEntity<?> informarPosicao(@RequestBody Mensagem mensagem){
        return new ResponseEntity(veiculoService.informarPosicao(mensagem), HttpStatus.OK);
    }

}
