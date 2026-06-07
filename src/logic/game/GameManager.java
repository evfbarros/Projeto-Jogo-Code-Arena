package logic.game;

import java.util.ArrayList;

import entities.Character;
import entities.CrewMember;
import logic.quiz.Question;
import logic.quiz.QuestionManager;
import screens.BattleScreen;
import screens.QuestionScreen;
import entities.Player;

public class GameManager {
    private Player pJogador;
    private Character pInimigo;
    private QuestionManager gerenciadorPergunta;
    private BattleScreen battleScreen;
    private QuestionScreen questionScreen;
    private ArrayList<Question> perguntasUsadas = new ArrayList<>();

    public GameManager(Player pJogador, Character pInimigo, QuestionManager gerenciadorPergunta, BattleScreen battleScreen, QuestionScreen questionScreen) {
        this.pJogador = pJogador;
        this.pInimigo = pInimigo;
        this.gerenciadorPergunta = gerenciadorPergunta;
        this.battleScreen = battleScreen;
        this.questionScreen = questionScreen;
    }

    public void iniciarJogo() {
        int rodada = 1;

        while (pJogador.getPersonagemAtual().estaVivo() && pInimigo.estaVivo()) {
            CrewMember personagemPlayer = pJogador.getPersonagemAtual();
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
                int dano = personagemPlayer.atacar(pInimigo);
                pInimigo.receberDano(dano);
                battleScreen.resultadoRodada(rodada, true, personagemPlayer.getNome(), dano);
                
                //xp aleatorio apenas p teste, dps vamos implementar um sistema mais completo para o ganho de xp
                boolean upou = pJogador.ganharXP(25);

                if(upou){
                    battleScreen.upouNivel(personagemPlayer.getNome(), pJogador.getNivelAtual());
                }

            } else {
                int dano = pInimigo.atacar(personagemPlayer);
                personagemPlayer.receberDano(dano);
                battleScreen.resultadoRodada(rodada, false, pInimigo.getNome(), dano);
            }

            battleScreen.atributosBatalha(personagemPlayer.getNome(), personagemPlayer.getVida(), pInimigo.getNome(), pInimigo.getVida());
            battleScreen.esperarEnter();
            battleScreen.limparTerminal();

            rodada++;
        }

        boolean resultadoBatalha = pJogador.getPersonagemAtual().estaVivo();

        if (resultadoBatalha) {
            battleScreen.resultadoBatalha(true, pJogador.getPersonagemAtual().getNome());
        } else {
            battleScreen.resultadoBatalha(false, pInimigo.getNome());
        }
    }
}