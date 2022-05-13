package com.projetosd.veiculo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Veiculo {

    private String posicao;
    private Integer velocidade;

    @Override
    public String toString(){
        return String.format("Veiculo na posição %s com velocidade %s", posicao, velocidade.toString());
    }
}
