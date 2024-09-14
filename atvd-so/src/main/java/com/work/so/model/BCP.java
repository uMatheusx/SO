package com.work.so.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BCP {
    private String nome;
    private Integer pc;
    private Integer estado;
    private Integer prioridade;
    private Integer creditos;
    private Integer registradorX;
    private Integer registradorY;
    private ArrayList<String> codigo;
}   
