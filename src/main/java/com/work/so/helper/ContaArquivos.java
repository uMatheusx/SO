package com.work.so.helper;

import java.io.File;

public class ContaArquivos {
    public static int ContaArquivos (String caminhoPasta){

        File pasta = new File(caminhoPasta);

        if (pasta.exists() && pasta.isDirectory()) {
            File[] arquivos = pasta.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
            int quantidadeArquivos = (arquivos != null) ? arquivos.length : 0;
            return quantidadeArquivos;

        } else {
            System.out.println("O caminho especificado não é uma pasta válida.");
            return -1;
        }
    }
}
