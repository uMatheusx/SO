package com.work.so.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tabela {
    
    private final Map<String, List<String>> tabela = new HashMap<>();
    
    public void gerarColunas(String... colunas) {
        for (String coluna : colunas) {
            tabela.put(coluna, new ArrayList<>()); 
        }
    }
    
    public void adicionarLinha(String... valores) {
        if (valores.length != tabela.size()) {
            throw new IllegalArgumentException("Número de valores não corresponde ao número de colunas." + tabela);
        }
        
        int i = 0;
        for (String chave : tabela.keySet()) {
            tabela.get(chave).add(valores[i]);
            i++;
        }
    }
    
    public void imprimirTabela() {
        for (String coluna : tabela.keySet()) {
            System.out.printf("%-15s", coluna);
        }
        System.out.println();
        
        int linhas = tabela.values().iterator().next().size();
        
        // Imprime os dados da tabela
        for (int i = 0; i < linhas; i++) {
            for (String coluna : tabela.keySet()) {
                System.out.printf("%-15s", tabela.get(coluna).get(i));
            }
            System.out.println();
        }
    }
}
