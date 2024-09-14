package com.work.so.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeituraTxt {

    public ArrayList<String> lePrograma(String caminhoArquivo) {

        ArrayList<String> programa = new ArrayList<>();
        String filePath = caminhoArquivo; // Caminho do arquivo


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                    programa.add(line); 
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        programa.removeFirst(); // Remove a linha do título 
        return programa;
    }
}
