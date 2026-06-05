package logic.game;

import java.util.ArrayList;

import entities.Character;
import logic.quiz.Question;
import logic.quiz.QuestionManager;
import screens.BattleScreen;
import screens.QuestionScreen;

public class GameManager {
    private Character pJogador;
    private Character pInimigo;
    private QuestionManager gerenciadorPergunta;
    private BattleScreen battleScreen;
    private QuestionScreen questionScreen;
    private ArrayList<Question> perguntasUsadas = new ArrayList<>();

    public GameManager(Character pJogador, Character pInimigo, QuestionManager gerenciadorPergunta, BattleScreen battleScreen, QuestionScreen questionScreen) {
        this.pJogador = pJogador;
        this.pInimigo = pInimigo;
        this.gerenciadorPergunta = gerenciadorPergunta;
        this.battleScreen = battleScreen;
        this.questionScreen = questionScreen;
    }

    public void iniciarJogo() {
        int rodada = 1;

        while (pJogador.estaVivo() && pInimigo.estaVivo()) {

           Question questaoAtual;

            // Loop até achar uma pergunta que ainda não foi usada
            do {
                questaoAtual = gerenciadorPergunta.questaoSorteada();
            } while (perguntasUsadas.contains(questaoAtual));
            // Marca a pergunta como usada
            perguntasUsadas.add(questaoAtual);

            battleScreen.exibirRodada(rodada);

            questionScreen.mostrarQuestao(questaoAtual);
            String resposta = questionScreen.leituraRespostaValida(questaoAtual);

            boolean resultado = questaoAtual.verificarResposta(resposta);

            if (resultado){
                int dano = pJogador.atacar(pInimigo);
                pInimigo.receberDano(dano);
                battleScreen.resultadoRodada(rodada, true, pJogador.getNome(), dano);
            } else {
                int dano = pInimigo.atacar(pJogador);
                pJogador.receberDano(dano);
                battleScreen.resultadoRodada(rodada, false, pInimigo.getNome(), dano);
            }

            battleScreen.atributosBatalha(pJogador.getNome(), pJogador.getVida(), pInimigo.getNome(), pInimigo.getVida());
            battleScreen.esperarEnter();
            battleScreen.limparTerminal();

            rodada++;
        }

        boolean resultadoBatalha = pJogador.estaVivo();

        if (resultadoBatalha) {
            battleScreen.resultadoBatalha(true, pJogador.getNome());
        } else {
            battleScreen.resultadoBatalha(false, pInimigo.getNome());
        }
    }
}