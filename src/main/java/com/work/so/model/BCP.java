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
    private Integer tempoBloqueado;
    private boolean executando;
    private Integer instrucoes;

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
        this.tempoBloqueado = 0;
        this.executando = false;
        this.instrucoes = 0;
    }

    public Integer diminuirTempoBloqueado() {
        
        if (this.tempoBloqueado == 2) {
            this.tempoBloqueado = 0;
            return -1;
        }
        else{
            this.tempoBloqueado++;
            return 1;
        }
    }

    public Integer executaInstrucao(LoggerModel Log){   

        if(!executando) {
            executando = true;
            Log.GerarLog("EXEC", nome);
            instrucoes = 0;
        } 

        String instrucao = codigo.get(pc);
        pc++;

        instrucoes++;

        if(instrucao.equals("SAIDA")){
            estado = SO.finalizado;
            executando = false;
            Log.GerarLog("END", nome, registradorX, registradorY);
            instrucoes = 0; 
            return estado;
        }

        if(instrucao.equals("E/S")){
            estado = SO.bloqueado;
            executando = false;
            Log.GerarLog("E/S", nome);
            Log.GerarLog("INTE", nome, instrucoes);
            return estado;
        }

        if (instrucao.charAt(0) == 'X') {
            int valor = Integer.valueOf(instrucao.substring(2)); 
            registradorX = valor;
            return estado;
        }

        if(instrucao.charAt(0) == 'Y'){
            int valor = Integer.valueOf(instrucao.substring(2)); 
            registradorY = valor;
            return estado;
        }

        if(instrucao.equals("SAIDA")){
            estado = SO.finalizado;
            executando = false;
            Log.GerarLog("END", nome, registradorX, registradorY);
            return estado;
        }

        return estado;
    }

    public void restaurarCreditos (){
        this.creditos = this.prioridade; 
    }

    public void carregarProcessos(LoggerModel Log) {
        Log.GerarLog("LOAD", nome);
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


