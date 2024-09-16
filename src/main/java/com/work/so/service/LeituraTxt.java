package com.work.so.service;

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
                programa.add(line); // Adiciona a linha à ArrayList
            }
                
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return programa;
    }

    public Integer leQuantum(String caminhoArquivo) {
        
        Integer quantum = null; // Inicializa o quantum como null
        String filePath = caminhoArquivo; // Caminho do arquivo

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Lê a única linha do arquivo
            if (line != null) {
                quantum = Integer.parseInt(line); // Converte a linha para um inteiro
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter a linha para inteiro: " + e.getMessage());
        }

        return quantum; // Retorna o quantum ou null se houver erro
    }

    public ArrayList<Integer> lePrioridades(String caminhoArquivo) {
        
        ArrayList<Integer> prioridades = new ArrayList<>(); // Lista para armazenar os inteiros
        String filePath = caminhoArquivo; // Caminho do arquivo

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    prioridades.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter a linha para inteiro: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return prioridades; // Retorna a lista de números
    }
}