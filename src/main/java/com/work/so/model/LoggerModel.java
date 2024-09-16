        package com.work.so.model;

        import java.util.ArrayList;
import java.util.List;
import java.util.Map;

        import com.work.so.service.Tabela;

        public class LoggerModel {

            private ArrayList<String> Log;  // usada para guardar todas as logs do projeto

            private final Tabela tabela;

            public LoggerModel() {
                tabela = new Tabela();
                tabela.gerarColunas("Tipo Log", "Mensagem Log");
                tabela.adicionarLinha("LOAD", "Carregando ");
                tabela.adicionarLinha("EXEC", "Executando ");
                tabela.adicionarLinha("INTE", "Interrompendo ");
                tabela.adicionarLinha("E/S", "E/S iniciada em ");
                tabela.adicionarLinha("END", "Terminado ");
            }


            public void GerarLog(String tipoLog, String nomeArq) {
                // Acessa o mapa de colunas da tabela
                Map<String, List<String>> dadosTabela = tabela.getTabela();
        
                List<String> tiposLog = dadosTabela.get("Tipo Log");
                List<String> mensagensLog = dadosTabela.get("Mensagem Log");
        
                int index = tiposLog.indexOf(tipoLog);
                if (index != -1) {
                    String mensagemFinal = mensagensLog.get(index) + nomeArq;
                    System.out.println(mensagemFinal);
                } else {
                    System.out.println("Tipo de log não encontrado.");
                }
            }
        }
