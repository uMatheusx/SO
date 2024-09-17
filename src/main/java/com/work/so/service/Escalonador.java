package com.work.so.service;

import java.util.ArrayList;
import java.util.LinkedList;

import com.work.so.helper.ContaArquivos;
import com.work.so.model.BCP;
import com.work.so.model.LoggerModel;

public class Escalonador {
    public static void run() throws Exception {
        LeituraTxt leitor = new LeituraTxt();  

		LinkedList<BCP> processosProntos = new LinkedList<>();

        LinkedList<BCP> processosBloqueados = new LinkedList<>();

        LinkedList<BCP> tabelaProcesos = new LinkedList<>();

        LoggerModel Log = new LoggerModel();  
		
        int quantum = leitor.leQuantum("src/main/java/com/work/so/codigos/quantum.txt");
        System.out.println("Quantum:" + quantum); //só pra teste
        System.out.println();

        ArrayList<Integer> prioridades = new ArrayList<Integer>();
        prioridades = leitor.lePrioridades("src/main/java/com/work/so/codigos/prioridades.txt");  
        
        ArrayList<String> arquivo = new ArrayList<String>();

        int quantidadeArquivos = ContaArquivos.ContaArquivos("src/main/java/com/work/so/codigos");

		for(int i = 1; i <= quantidadeArquivos - 2; i++) {
			String index = String.format("src/main/java/com/work/so/codigos/%02d.txt", i);
			arquivo = leitor.lePrograma(index);
			BCP processo = new BCP(arquivo, prioridades.get(i-1));
        	// processo.imprimirAtributos();
			processosProntos.add(processo);
            tabelaProcesos.add(processo);
		}

		processosProntos.sort((p1,p2) -> { return -1 * p1.getPrioridade().compareTo(p2.getPrioridade()); });

        
        for (BCP processo : processosProntos) {
            processo.carregarProcessos(Log); // Chama o método carregarProcessos de cada processo
        }
        
    
        Log.RelatorioLog();



    }
}
