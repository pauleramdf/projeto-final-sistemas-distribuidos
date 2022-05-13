package com.projetosd.veiculo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Mensagem {
    private String mensagem;
    private String destino;
    private Integer tempoParada;
}
