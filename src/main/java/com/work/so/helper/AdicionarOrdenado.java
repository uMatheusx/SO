package com.work.so.helper;

import java.util.LinkedList;

import com.work.so.model.BCP;

public class AdicionarOrdenado {
    public static void adicionarOrdenado(LinkedList<BCP> lista, BCP processo) {
        int index = 0;

        while (index < lista.size() && lista.get(index).getCreditos() > processo.getCreditos()) {
            index++;
        }
        // Insere o novo valor na posição correta
        lista.add(index, processo);
    }
}
