package com.work.so.helper;

import java.util.LinkedList;

import com.work.so.model.BCP;
import com.work.so.model.SO;

public class AdicionarOrdenado {
    public static void adicionarOrdenado(LinkedList<BCP> lista, BCP processo) {
        int index = 0;

        if (processo.getEstado() == SO.executando){
            while (index < lista.size() && lista.get(index).getCreditos() > processo.getCreditos()) {
                index++;
            }
        } else{
            while (index < lista.size() && lista.get(index).getCreditos() >= processo.getCreditos()) {
                index++;
            }
        }
        
        // Insere o novo valor na posição correta
        lista.add(index, processo);
    }
}

