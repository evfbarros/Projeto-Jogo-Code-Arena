package logic.quiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class GoogleSheetsQuestionLoader {

    public static ArrayList<Question> carregar(String linkCsv) {
        ArrayList<Question> questoes = new ArrayList<>();

        try {
            URL url = new URL(linkCsv);

            BufferedReader leitor = new BufferedReader(
                    new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));

            String linha;
            boolean primeiraLinha = true;

            while ((linha = leitor.readLine()) != null) {

                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] colunas = linha.split(",", -1);

                String tipo = colunas[0].trim().toUpperCase();
                String categoria = colunas[1].trim();

                Difficulty dificuldade = Difficulty.valueOf(colunas[2].trim().toUpperCase());

                String enunciado = colunas[3].trim();

                switch (tipo) {

                    case "MULTIPLA":
                        ArrayList<String> alternativas = new ArrayList<>();

                        alternativas.add("A) " + colunas[4].trim());
                        alternativas.add("B) " + colunas[5].trim());
                        alternativas.add("C) " + colunas[6].trim());
                        alternativas.add("D) " + colunas[7].trim());
                        alternativas.add("E) " + colunas[8].trim());

                        char letraGabarito = colunas[9].trim().toUpperCase().charAt(0);
                        int indiceGabarito = letraGabarito - 'A';

                        questoes.add(
                                new MultipleChoiceQuestion(
                                        enunciado,
                                        dificuldade,
                                        categoria,
                                        alternativas,
                                        indiceGabarito));
                        break;

                    case "VOF":
                        char gabaritoLetra = colunas[9].trim().toUpperCase().charAt(0);

                        char gabaritoVF;

                        if (gabaritoLetra == 'A') {
                            gabaritoVF = 'V';
                        } else {
                            gabaritoVF = 'F';
                        }

                        // talvez isso aquiu esteja errado

                        questoes.add(
                                new TrueFalseQuestion(
                                        enunciado,
                                        dificuldade,
                                        categoria,
                                        gabaritoVF));
                        break;

                    default:
                        System.out.println("Tipo de questão inválido: " + tipo);
                        break;
                }
            }

            leitor.close();

        } catch (Exception e) {
            // System.out.println("Erro ao carregar questões: " + e.getMessage());
            // isso aq so e p indicar o erro, quando tiver todas as questoes no banco vai
            // sumir
        }

        return questoes;
    }
}
