package com.projetosd.central.constants;

import com.projetosd.veiculo.model.Veiculo;

import java.util.HashMap;
import java.util.Map;

public class LocalStorage {
    private static Map<Integer, Veiculo> veiculosCadastrados;

    public static Map<Integer, Veiculo> getVeiculosCadastrados() {
        if(veiculosCadastrados == null){
            return new HashMap<>();
        }
        return veiculosCadastrados;
    }

    public static void setVeiculosCadastrados(Map<Integer, Veiculo> veiculosCadastrados) {
        LocalStorage.veiculosCadastrados = veiculosCadastrados;
    }
}
