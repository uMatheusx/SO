package com.work.so;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.work.so.model.BCP;
import com.work.so.service.LeituraTxt;

@SpringBootApplication
public class AtvdSoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AtvdSoApplication.class, args);
        
        LeituraTxt leitor = new LeituraTxt();    

        /*le e armazena o quantum*/
        int quantum = leitor.leQuantum("src/main/java/com/work/so/codigos/quantum.txt");
        System.out.println("Quantum:" + quantum); //só pra teste
        System.out.println();

        /*le e armazena as prioridades*/
        ArrayList<Integer> prioridades = new ArrayList<Integer>();
        prioridades = leitor.lePrioridades("src/main/java/com/work/so/codigos/prioridades.txt");  
        
        /*le os arquivos programas e cria os processos (BCPs) */
        ArrayList<String> arquivo = new ArrayList<String>();

        // fiz um por um porque não achei outro jeito, se alguém souber vai ser melhor
        arquivo = leitor.lePrograma("src/main/java/com/work/so/codigos/01.txt");
        BCP processo1 = new BCP(arquivo, prioridades.get(0));
        processo1.imprimirAtributos(); //só pra teste

        arquivo = leitor.lePrograma("src/main/java/com/work/so/codigos/02.txt");
        BCP processo2 = new BCP(arquivo, prioridades.get(1));
        processo2.imprimirAtributos(); //só pra teste

        arquivo = leitor.lePrograma("src/main/java/com/work/so/codigos/03.txt");
        BCP processo3 = new BCP(arquivo, prioridades.get(2));
        processo3.imprimirAtributos(); //só pra teste

        arquivo = leitor.lePrograma("src/main/java/com/work/so/codigos/04.txt");
        BCP processo4 = new BCP(arquivo, prioridades.get(3));
        processo4.imprimirAtributos(); //só pra teste

        arquivo = leitor.lePrograma("src/main/java/com/work/so/codigos/05.txt");
        BCP processo5 = new BCP(arquivo, prioridades.get(4));
        processo5.imprimirAtributos(); //só pra teste

        arquivo = leitor.lePrograma("src/main/java/com/work/so/codigos/06.txt");
        BCP processo6 = new BCP(arquivo, prioridades.get(5));
        processo6.imprimirAtributos(); //só pra teste

        arquivo = leitor.lePrograma("src/main/java/com/work/so/codigos/07.txt");
        BCP processo7 = new BCP(arquivo, prioridades.get(6));
        processo7.imprimirAtributos(); //só pra teste

        arquivo = leitor.lePrograma("src/main/java/com/work/so/codigos/08.txt");
        BCP processo8 = new BCP(arquivo, prioridades.get(7));
        processo8.imprimirAtributos(); //só pra teste

        arquivo = leitor.lePrograma("src/main/java/com/work/so/codigos/09.txt");
        BCP processo9 = new BCP(arquivo, prioridades.get(8));
        processo9.imprimirAtributos(); //só pra teste

        arquivo = leitor.lePrograma("src/main/java/com/work/so/codigos/10.txt");
        BCP processo10 = new BCP(arquivo, prioridades.get(9));
        processo10.imprimirAtributos(); //só pra teste
    }
}
