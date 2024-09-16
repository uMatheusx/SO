package com.work.so.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BCP {
    private String nome;
    private Integer pc;
    private Integer estado;
    private Integer prioridade;
    private Integer creditos;
    private Integer registradorX;
    private Integer registradorY;
    private ArrayList<String> codigo;

    public BCP(ArrayList<String> arquivo, int prioridade) {
        this.pc = 1;
        this.estado = SO.pronto; 
        this.prioridade = prioridade;
        this.creditos = prioridade;
        this.registradorX = 0;
        this.registradorY = 0;
        this.nome = arquivo.get(0);
        arquivo.remove(0); 
        this.codigo = arquivo;
    }

    public void imprimirAtributos() {
        System.out.println("Nome: " + nome);
        System.out.println("PC: " + pc);
        System.out.println("Estado: " + estado);
        System.out.println("Prioridade: " + prioridade);
        System.out.println("Créditos: " + creditos);
        System.out.println("Registrador X: " + registradorX);
        System.out.println("Registrador Y: " + registradorY);
        System.out.println("Código: " + codigo);
        System.out.println();
    }


}


