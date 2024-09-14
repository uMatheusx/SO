package com.work.so.atvd_so;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.work.so.model.TabelaModel;

@SpringBootApplication
public class AtvdSoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtvdSoApplication.class, args);
		var teste = new TabelaModel();
		teste.gerarColunas("Nome", "Idade", "Sexo");
		teste.adicionarLinha("Matheus", "19", "Masculino");
		teste.imprimirTabela();
	}
}
