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
        this.pc = 0;
        this.estado = SO.pronto; 
        this.prioridade = prioridade;
        this.creditos = prioridade;
        this.registradorX = 0;
        this.registradorY = 0;
        this.nome = arquivo.get(0);
        arquivo.remove(0); 
        this.codigo = arquivo;
    }

    public int executaInstrucao(){
        String instrucao = codigo.get(pc);
        pc++;

        if(instrucao.equals("E/S")){
            estado = SO.bloqueado;
            return estado;
        }

        if (instrucao.charAt(0) == 'X') {
            int valor = instrucao.charAt(2) - '0'; 
            registradorX = valor;
            return estado;
        }

        if(instrucao.charAt(0) == 'Y'){
            int valor = instrucao.charAt(2) - '0'; 
            registradorY = valor;
            return estado;
        }

        if(instrucao.equals("SAIDA")){
            estado = SO.finalizado;
            return estado;
        }

        return estado;
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


