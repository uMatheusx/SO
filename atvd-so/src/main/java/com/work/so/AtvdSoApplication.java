package com.work.so;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.work.so.service.LeituraTxt;
import com.work.so.service.Tabela;

@SpringBootApplication
public class AtvdSoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AtvdSoApplication.class, args);
		var teste = new Tabela();
		teste.gerarColunas("Nome", "Idade", "Sexo");
		teste.adicionarLinha("Matheus", "19", "Masculino");
		teste.imprimirTabela();
		LeituraTxt leitor = new LeituraTxt();
        ArrayList<String> programa = new ArrayList<String>();
        programa = leitor.lePrograma("atvd-so/src/main/java/com/work/so/codigos/01.txt");
	}
}
