package com.work.so.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.work.so.helper.AdicionarOrdenado;
import com.work.so.helper.ContaArquivos;
import com.work.so.model.BCP;
import com.work.so.model.LoggerModel;
import com.work.so.model.SO;

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

        while(!tabelaProcesos.isEmpty()){
            // nota: fazer um for na lista de bloqueados somando 1 no atributo countBloqueado (se for 2, zerar o atributo e desbloquar o processo)
            
            if(processosProntos.isEmpty()){
               //tratamento pra quando a lista de processos prontos estiver vazia
            }

            else {
                if(processosProntos.getFirst().getCreditos() == 0){
                    //tratamento pra quando todos da lista de processos prontos terem 0 créditos
                }
                
                for (Iterator<BCP> iterator = processosBloqueados.iterator(); iterator.hasNext();) {
                    BCP processo = iterator.next();
                    if (processo.diminuirTempoBloqueado() == -1) {
                        iterator.remove();  // Usa o iterador para remover o processo de forma segura
                        processosProntos.add(processo);
                    }
                }

                /* a partir daqui começa a executar o primeiro da lista */
                
                int estadoAtual = -1; 
                BCP processoExecutando = processosProntos.removeFirst();
                processoExecutando.setEstado(SO.executando);
                processoExecutando.setCreditos(processoExecutando.getCreditos() - 1);
                    
                //loop de execução
                for(int q = 0; q < quantum; q++){
                    
                    estadoAtual = processoExecutando.executaInstrucao(Log);
        
                    if(estadoAtual == SO.bloqueado){
                        processosBloqueados.add(processoExecutando);
                        //precisa ver como contar o tempo na lista de bloqueados
                        break;
                    }
        
                    if(estadoAtual == SO.finalizado){
                        tabelaProcesos.remove(processoExecutando);
                        break;
                    }
                }
        
                if(estadoAtual == SO.executando){
                    AdicionarOrdenado.adicionarOrdenado(processosProntos, processoExecutando);
                }        
            }
        }
    }
}
