package logica.quiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CarregadorQuestoesGoogleSheets {

    public static ArrayList<Questao> carregar(String linkCsv) {
        ArrayList<Questao> questoes = new ArrayList<>();

        try {
            // Cria uma URL a partir do link CSV publicado do Google Sheets
            URL url = new URL(linkCsv);

            // Abre o arquivo CSV online e prepara a leitura linha por linha
            BufferedReader leitor = new BufferedReader(
                new InputStreamReader(url.openStream(), StandardCharsets.UTF_8)
            );

            String linha;
            boolean primeiraLinha = true;

            while ((linha = leitor.readLine()) != null) {

                // Ignora a primeira linha, que contém os nomes das colunas
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                // Divide a linha em colunas usando a vírgula como separador
                String[] colunas = linha.split(",", -1);

                // Lê os dados principais da questão
                String tipo = colunas[0].trim().toUpperCase();
                String categoria = colunas[1].trim();

                // Converte o texto da planilha para o enum Dificuldade
                Dificuldade dificuldade = Dificuldade.valueOf(
                    colunas[2].trim().toUpperCase()
                );

                String enunciado = colunas[3].trim();

                // Decide qual tipo de questão será criado
                switch (tipo) {

                    case "MULTIPLA":
                        ArrayList<String> alternativas = new ArrayList<>();

                        // Monta as alternativas de A até E
                        alternativas.add("A) " + colunas[4].trim());
                        alternativas.add("B) " + colunas[5].trim());
                        alternativas.add("C) " + colunas[6].trim());
                        alternativas.add("D) " + colunas[7].trim());
                        alternativas.add("E) " + colunas[8].trim());

                        // Lê o gabarito como letra e converte para índice
                        // Exemplo: A = 0, B = 1, C = 2...
                        char letraGabarito = colunas[9].trim().toUpperCase().charAt(0);
                        int indiceGabarito = letraGabarito - 'A';

                        questoes.add(
                            new QuestaoMultiplaEscolha(
                                enunciado,
                                dificuldade,
                                categoria,
                                alternativas,
                                indiceGabarito
                            )
                        );
                        break;

                    case "VOF":
                        // Na planilha, VOF usa:
                        // altA = V, altB = F, gabarito = A ou B
                        char gabaritoLetra = colunas[9].trim().toUpperCase().charAt(0);

                        char gabaritoVF;

                        if (gabaritoLetra == 'A') {
                            gabaritoVF = 'V';
                        } else {
                            gabaritoVF = 'F';
                        }

                        questoes.add(
                            new QuestaoVerdadeiroFalso(
                                enunciado,
                                dificuldade,
                                categoria,
                                gabaritoVF
                            )
                        );
                        break;

                    default:
                        System.out.println("Tipo de questão inválido: " + tipo);
                        break;
                }
            }

            leitor.close();

        } catch (Exception e) {
            System.out.println("Erro ao carregar questões: " + e.getMessage());
        }

        return questoes;
    }
}
