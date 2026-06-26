package logic.game;

import java.util.ArrayList;

import entities.Character;
import entities.CrewMember;
import entities.Enemy;
import logic.quiz.Question;
import logic.quiz.QuestionManager;
import screens.BattleScreen;
import screens.CharacterSelectionScreen;
import screens.QuestionScreen;
import entities.Player;
import entities.ability.SpecialAbility;
import exceptions.AtaqueIndisponivelException;
import exceptions.AtaqueInvalidoException;
import exceptions.DefesaIndisponivelException;
import exceptions.DesvioIndisponivelException;
import java.util.Map;
import logic.quiz.Difficulty;

public class GameManager {
    private Player pJogador;
    private Character pInimigo;
    private QuestionManager gerenciadorPergunta;
    private BattleScreen battleScreen;
    private QuestionScreen questionScreen;
    private CharacterSelectionScreen selectionScreen;
    private ArrayList<Question> perguntasUsadas;
    private static final int CUSTO_HABILIDADE_ESPECIAL = 100;
    private Map<Difficulty, Integer> distribuicaoPerguntas;

    public GameManager(Player pJogador, Character pInimigo, QuestionManager gerenciadorPergunta,
            BattleScreen battleScreen, QuestionScreen questionScreen, CharacterSelectionScreen selectionScreen,
            Map<Difficulty, Integer> distribuicaoPerguntas,ArrayList<Question> perguntasUsadas) {
        this.pJogador = pJogador;
        this.pInimigo = pInimigo;
        this.gerenciadorPergunta = gerenciadorPergunta;
        this.battleScreen = battleScreen;
        this.questionScreen = questionScreen;
        this.selectionScreen = selectionScreen;
        this.distribuicaoPerguntas = distribuicaoPerguntas;
        this.perguntasUsadas = perguntasUsadas;
    }
        private boolean tentarUsarHabilidadeEspecial(CrewMember personagemPlayer, Question questaoAtual) {//Modifiquei esse método para integrar todas as habilidades especiais
            if (personagemPlayer.getStamina() < CUSTO_HABILIDADE_ESPECIAL) {
                battleScreen.staminaInsuficiente();
                questionScreen.mostrarQuestao(questaoAtual);
                String resposta = questionScreen.leituraRespostaValida(questaoAtual);
                return questaoAtual.verificarResposta(resposta);
                }

            SpecialAbility habilidadeEspecial = personagemPlayer.getHabilidadeEspecial();

            personagemPlayer.gastarStamina(CUSTO_HABILIDADE_ESPECIAL);

            if (personagemPlayer.getNome().equalsIgnoreCase("Zoro")) {
                boolean funcionou = habilidadeEspecial.usar(personagemPlayer, questaoAtual, "");

                if (funcionou) {
                    battleScreen.habilidadeUsada(personagemPlayer.getNome());
                } else {
                    battleScreen.habilidadeNaoAplicavel();
                }

                questionScreen.mostrarQuestao(questaoAtual);
                String resposta = questionScreen.leituraRespostaValida(questaoAtual);
                return questaoAtual.verificarResposta(resposta);
            }

            if (personagemPlayer.getNome().equalsIgnoreCase("Sanji")) {
                habilidadeEspecial.usar(personagemPlayer, questaoAtual, "");
                battleScreen.habilidadeUsada(personagemPlayer.getNome());

                questionScreen.mostrarQuestao(questaoAtual);
                String resposta = questionScreen.leituraRespostaValida(questaoAtual);
                return questaoAtual.verificarResposta(resposta);
            }

            if (personagemPlayer.getNome().equalsIgnoreCase("Usopp")) {
                questionScreen.mostrarQuestao(questaoAtual);
                String resposta = questionScreen.leituraRespostaValida(questaoAtual);

                battleScreen.habilidadeUsada(personagemPlayer.getNome());
                return habilidadeEspecial.usar(personagemPlayer, questaoAtual, resposta);
            }

            boolean habilidadeFuncionou = habilidadeEspecial.usar(personagemPlayer, questaoAtual, "");

            if (habilidadeFuncionou) {
                battleScreen.habilidadeUsada(personagemPlayer.getNome());
                return true;
            }

            battleScreen.habilidadeNaoAplicavel();
            battleScreen.responderNormalmente();

            questionScreen.mostrarQuestao(questaoAtual);
            String respostaNormal = questionScreen.leituraRespostaValida(questaoAtual);

            return questaoAtual.verificarResposta(respostaNormal);
        }
    public boolean iniciarJogo() { //Troquei por boolean para facilitar a integrar
        int rodada = 1;

        selectionScreen.exibirPersonagens(pJogador.getTripulacao());
        int escolha = selectionScreen.escolhaPersonagem(pJogador.getTripulacao());
        pJogador.selecionarPersonagem(escolha);

        CrewMember personagemEscolhido = pJogador.getPersonagemAtual(); // Tem que se recuperar entre 2 ilhas
        personagemEscolhido.resetarAtaques();
        personagemEscolhido.resetarDefesa();
        personagemEscolhido.resetarDesvios();
        personagemEscolhido.recuperarVida(personagemEscolhido.getVidaMaxima());
        personagemEscolhido.recuperarStamina(personagemEscolhido.getStaminaMaxima());
        
        while (pJogador.getPersonagemAtual().estaVivo() && pInimigo.estaVivo()) {
            CrewMember personagemPlayer = pJogador.getPersonagemAtual();
            Question questaoAtual;

            questaoAtual = gerenciadorPergunta.questaoSorteadaPorDistribuicao(distribuicaoPerguntas,perguntasUsadas);

            perguntasUsadas.add(questaoAtual);

            battleScreen.exibirRodada(rodada);
            battleScreen.atributosBatalha(personagemPlayer.getNome(),personagemPlayer.getVida(),pInimigo.getNome(),pInimigo.getVida());
            questionScreen.mostrarQuestao(questaoAtual);
            boolean resultado;
            int escolhaAcao = battleScreen.escolherAcaoEspecialOuResponder();

            switch (escolhaAcao) {
                case 1:
                    resultado = tentarUsarHabilidadeEspecial(personagemPlayer, questaoAtual);
                    break;

                case 0:
                default:
                    questionScreen.pedirResposta();
                    String resposta = questionScreen.leituraRespostaValida(questaoAtual);
                    resultado = questaoAtual.verificarResposta(resposta);
                    break;
                }

            if (resultado) {
                battleScreen.respostaCorretaEscolhaAtaque();
                battleScreen.exibirAtaques(personagemPlayer.getListaAtaque());
                int escolhaAtaque = battleScreen.escolherAtaque();
                int dano = -1;

                while (dano < 0) {
                    try{
                        dano = personagemPlayer.atacar(escolhaAtaque, pInimigo);
                    } catch (AtaqueInvalidoException e){
                        System.out.println("Erro : " + e.getMessage());
                        battleScreen.exibirAtaques(personagemPlayer.getListaAtaque());
                        escolhaAtaque = battleScreen.escolherAtaque();
                    } catch (AtaqueIndisponivelException e){
                        System.out.println("Erro: " + e.getMessage());
                        battleScreen.exibirAtaques(personagemPlayer.getListaAtaque());
                        escolhaAtaque = battleScreen.escolherAtaque();
                    }
                    // battleScreen.ataqueIndisponivel(); nao vai precisar
                }

                if (pInimigo instanceof Enemy) {
                    Enemy inimigo = (Enemy) pInimigo;
                    dano = inimigo.getComAbility().modificarDanoRecebido(dano, rodada);
                } // Isso é especificamente para a habilidade do Don Krieg que é defensiva
                pInimigo.receberDano(dano);
                if(!pInimigo.estaVivo()){
                    boolean upou = personagemPlayer.ganharXP(pInimigo.getXpConcedido());
                    if (upou) {
                        battleScreen.upouNivel(personagemPlayer.getNome(), personagemPlayer.getNivelAtual());
                    }
                }
                battleScreen.resultadoRodada(rodada,true,personagemPlayer.getNome(),dano,null
                                            ,questionScreen.obterRespostaCorreta(questaoAtual));

            } else {
                int quantidadeAtaques = 1; // Por padrão, o inimigo ataca apenas uma vez

                if (pInimigo instanceof Enemy) { // Verifica se o inimigo é um objeto da classe Enemy
                    Enemy inimigo = (Enemy) pInimigo; // Converte Character para Enemy
                    quantidadeAtaques = inimigo.getComAbility().ataquesExtras(rodada); // Verifica ataques extras
                }

                int danoTotal = 0; // Guarda a soma dos danos da rodada

                String ataqueInimigo = ""; 

                for (int i = 0; i < quantidadeAtaques; i++) { // Repete de acordo com a quantidade de ataques
                    int dano = 0;
                    try{
                        dano = pInimigo.atacar(0, personagemPlayer); // Calcula o dano base
                        Enemy inimigo = (Enemy) pInimigo;
                        ataqueInimigo = inimigo.getListaAtaque().get(inimigo.getAtaqueUsado()).getNome();
                    } catch (AtaqueInvalidoException e){
                        System.out.println("Erro : " + e.getMessage());
                    } catch (AtaqueIndisponivelException e){
                        System.out.println("Erro " + e.getMessage());
                    }
                    
                    int danoAntesHabilidade = dano;

                    if (pInimigo instanceof Enemy) {
                        Enemy inimigo = (Enemy) pInimigo;
                        dano = inimigo.getComAbility().modificarDanoRecebido(dano, rodada);
                    }

                    if (danoAntesHabilidade > 0 && dano == 0) {
                        battleScreen.inimigoDesviou(pInimigo.getNome());
                    }

                    danoTotal += dano; // Soma ao dano total
                }
                battleScreen.respostaErradaEscolhaDefesa();
                int defender = battleScreen.defender(personagemPlayer.getDefesasRestantes(), personagemPlayer.getDefesasMaximas(),
                 personagemPlayer.getDesviosRestantes(), personagemPlayer.getDesviosMaximos()); // Pergunta se o jogador quer defender

                if (defender == 0) { // Se escolher defender
                    try{ 
                        danoTotal = personagemPlayer.defender(danoTotal); // Reduz o dano
                        personagemPlayer.receberDano(danoTotal);
                    } catch (DefesaIndisponivelException e){
                        System.out.println("Erro: " + e.getMessage());
                        personagemPlayer.receberDano(danoTotal);
                    }
                } else if (defender == 1){
                    try{
                        boolean desviou = personagemPlayer.desviou();
                    if(desviou){
                        battleScreen.desviou(); // toma 0 de dano
                        danoTotal = 0;
                    } else {
                        personagemPlayer.receberDano(danoTotal);   
                        battleScreen.naoDesviou(); // vai tomar o dano completo pq falhou em desviar
                    }
                    } catch (DesvioIndisponivelException e){
                        System.out.println("Erro: " + e.getMessage());
                        personagemPlayer.receberDano(danoTotal);
                    }
                } else {
                    personagemPlayer.receberDano(danoTotal); // Aplica o dano final
                }   

               battleScreen.resultadoRodada(rodada,false,pInimigo.getNome(),danoTotal,ataqueInimigo
                                            ,questionScreen.obterRespostaCorreta(questaoAtual));
            }
            battleScreen.atributosBatalha(personagemPlayer.getNome(), personagemPlayer.getVida(), pInimigo.getNome(),
                    pInimigo.getVida());
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
        return resultadoBatalha;
    }
}