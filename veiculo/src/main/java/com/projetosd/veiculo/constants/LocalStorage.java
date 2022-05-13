package com.projetosd.veiculo.constants;

import com.projetosd.veiculo.model.Veiculo;
import lombok.Getter;
import lombok.Setter;

public class LocalStorage {
    private static Veiculo veiculo;
    private static boolean veiculoAtivo;

    public static Veiculo getVeiculo() {
        if(veiculo == null){
            return new Veiculo();
        }
        return veiculo;
    }

    public static void setVeiculo(Veiculo veiculo) {
        LocalStorage.veiculo = veiculo;
    }

    public static boolean isVeiculoAtivo() {
        return veiculoAtivo;
    }

    public static void setVeiculoAtivo(boolean veiculoAtivo) {
        LocalStorage.veiculoAtivo = veiculoAtivo;
    }
}
