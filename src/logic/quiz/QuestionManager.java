package logic.quiz;

import java.util.Random;
import java.util.ArrayList;
import java.util.Map;

public class QuestionManager {
    private ArrayList<Question> listaQuestoes;
    private Random sorteio = new Random();
    private Question questaoAtual;

    public QuestionManager(ArrayList<Question> listaQuestoes) {
        this.listaQuestoes = listaQuestoes;
    }

    public Question questaoSorteada() {
        int indiceQuestao = sorteio.nextInt(listaQuestoes.size());
        questaoAtual = listaQuestoes.get(indiceQuestao);
        return questaoAtual;

    }

    public Question getQuestaoAtual() {
        return questaoAtual;
    }
    public Question questaoSorteadaPorDistribuicao(Map<Difficulty, Integer> distribuicao,ArrayList<Question> perguntasUsadas) {

        Difficulty dificuldadeSorteada = sortearDificuldade(distribuicao);

        ArrayList<Question> questoesDisponiveis = filtrarQuestoesDisponiveis(dificuldadeSorteada,perguntasUsadas);

        if (questoesDisponiveis.isEmpty()) {
            questoesDisponiveis = filtrarTodasQuestoesDisponiveis(perguntasUsadas);
        }

        if (questoesDisponiveis.isEmpty()) {
            questoesDisponiveis = filtrarTodasQuestoesDisponiveis(perguntasUsadas);
        }

        int indiceQuestao = sorteio.nextInt(questoesDisponiveis.size());
        questaoAtual = questoesDisponiveis.get(indiceQuestao);

        return questaoAtual;
    }
    private Difficulty sortearDificuldade(Map<Difficulty, Integer> distribuicao) {
        int numero = sorteio.nextInt(100) + 1;

        int chanceFacil = distribuicao.getOrDefault(Difficulty.FACIL, 0);
        int chanceMedio = distribuicao.getOrDefault(Difficulty.MEDIO, 0);

        if (numero <= chanceFacil) {
            return Difficulty.FACIL;
        }

        if (numero <= chanceFacil + chanceMedio) {
            return Difficulty.MEDIO;
        }

        return Difficulty.DIFICIL;
    }
    private ArrayList<Question> filtrarQuestoesDisponiveis(Difficulty dificuldade,ArrayList<Question> perguntasUsadas) {
        ArrayList<Question> questoesDisponiveis = new ArrayList<>();

        for (Question questao : listaQuestoes) {
            if (questao.getDificuldade() == dificuldade && !perguntasUsadas.contains(questao)) {
                questoesDisponiveis.add(questao);
            }
        }

        return questoesDisponiveis;
    }
    private ArrayList<Question> filtrarTodasQuestoesDisponiveis(ArrayList<Question> perguntasUsadas) {
        ArrayList<Question> questoesDisponiveis = new ArrayList<>();

        for (Question questao : listaQuestoes) {
            if (!perguntasUsadas.contains(questao)) {
                questoesDisponiveis.add(questao);
            }
        }

        return questoesDisponiveis;
    }
}
