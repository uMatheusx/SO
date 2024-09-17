        package com.work.so.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.work.so.service.LeituraTxt;
import com.work.so.service.Tabela;

        public class LoggerModel {

            LeituraTxt leitor = new LeituraTxt(); 

            private List<String> Log;  // usada para guardar todas as logs do projeto

            private final Tabela tabela;

            public LoggerModel() {
                tabela = new Tabela();
                tabela.gerarColunas("Tipo Log", "Mensagem Log");
                tabela.adicionarLinha("LOAD", "Carregando ");
                tabela.adicionarLinha("EXEC", "Executando ");
                tabela.adicionarLinha("INTE", "Interrompendo ");
                tabela.adicionarLinha("E/S", "E/S iniciada em ");
                tabela.adicionarLinha("END", "Terminado ");
                this.Log = new ArrayList<>();
            }

                    // Método para logs normais
            public void GerarLog(String tipoLog, String nomeArq) {
                Map<String, List<String>> dadosTabela = tabela.getTabela();

                List<String> tiposLog = dadosTabela.get("Tipo Log");
                List<String> mensagensLog = dadosTabela.get("Mensagem Log");

                int index = tiposLog.indexOf(tipoLog);

                if (index != -1) {
                    String mensagemFinal = mensagensLog.get(index) + nomeArq;
                    Log.add(mensagemFinal);
                    System.out.println(mensagemFinal);
                } else {
                    System.out.println("Tipo de log não encontrado.");
                }
            }

            // Sobrecarga para tipo de log "END" com 2 parâmetros adicionais
            public void GerarLog(String tipoLog, String nomeArq, Integer registradorX, Integer registradorY) {
                if ("END".equals(tipoLog)) {
                    String mensagem = nomeArq + " terminado. X=" + registradorX + ". Y=" + registradorY;
                    Log.add(mensagem);
                    System.out.println(mensagem);
                } else {
                    GerarLog(tipoLog, nomeArq); 
                }
            }

            // Sobrecarga para tipo de log "INTE" com 1 parâmetro adicional
            public void GerarLog(String tipoLog, String nomeArq, String instrucoes) {
                if ("INTE".equals(tipoLog)) {
                    String mensagem = "Interrompendo " + nomeArq + " após " + instrucoes + " instrucoes";
                    Log.add(mensagem);
                    System.out.println(mensagem);
                } else {
                    GerarLog(tipoLog, nomeArq); 
                }
            }

            public void RelatorioLog() {
                Integer quantum = leitor.leQuantum("src/main/java/com/work/so/codigos/quantum.txt");
                String filePath = String.format("src/main/java/com/work/so/logs/log%02d.txt", quantum);

                File diretorio = new File("src/main/java/com/work/so/logs");
                if (!diretorio.exists()) {
                    diretorio.mkdirs();
                }

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    writer.write("====================================");
                    writer.newLine();
                    writer.write("         RELATÓRIO DE LOGS          ");
                    writer.newLine();
                    writer.write("====================================");
                    writer.newLine();

                    if (Log.isEmpty()) {
                        writer.write("Nenhum log disponível.");
                    } else {
                        for (String s : Log) {
                            writer.write(s);
                            writer.newLine();
                        }
                    }

                    writer.write("====================================");
                    writer.newLine();
                    
                    System.out.println("Relatório gerado com sucesso: " + filePath);
                } catch (IOException e) {
                    System.out.println("Erro ao gerar o relatório: " + e.getMessage());
                }
            }
            
    }
