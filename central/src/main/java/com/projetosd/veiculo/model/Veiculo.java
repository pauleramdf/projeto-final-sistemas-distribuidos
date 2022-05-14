package com.projetosd.veiculo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    private Integer id;
    private Double posicaoX;
    private Double posicaoY;
    private Integer velocidade;

    @Override
    public String toString(){
        return String.format("Veiculo %s na posição (%s,%s) com velocidade %s", id, posicaoX, posicaoY, velocidade);
    }
}