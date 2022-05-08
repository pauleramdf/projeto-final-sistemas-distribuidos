package com.projetosd.veiculo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Veiculo {

    private Long id;
    private String posicao;
    private Double velocidade;

}
