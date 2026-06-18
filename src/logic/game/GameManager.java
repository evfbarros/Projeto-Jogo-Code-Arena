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

public class GameManager {
    private Player pJogador;
    private Character pInimigo;
    private QuestionManager gerenciadorPergunta;
    private BattleScreen battleScreen;
    private QuestionScreen questionScreen;
    private CharacterSelectionScreen selectionScreen;
    private ArrayList<Question> perguntasUsadas = new ArrayList<>();
    private static final int CUSTO_HABILIDADE_ESPECIAL = 100;

    public GameManager(Player pJogador, Character pInimigo, QuestionManager gerenciadorPergunta,
            BattleScreen battleScreen, QuestionScreen questionScreen, CharacterSelectionScreen selectionScreen) {
        this.pJogador = pJogador;
        this.pInimigo = pInimigo;
        this.gerenciadorPergunta = gerenciadorPergunta;
        this.battleScreen = battleScreen;
        this.questionScreen = questionScreen;
        this.selectionScreen = selectionScreen;
    }
        private boolean tentarUsarHabilidadeEspecial(CrewMember personagemPlayer, Question questaoAtual) {
            if (personagemPlayer.getStamina() < CUSTO_HABILIDADE_ESPECIAL) { // Verifica se há stamina suficiente
                battleScreen.staminaInsuficiente(); // Informa que a habilidade não pode ser usada
                questionScreen.mostrarQuestao(questaoAtual); // mostra a pergunta novamente
                String resposta = questionScreen.leituraRespostaValida(questaoAtual); // Permite responder normalmente
                return questaoAtual.verificarResposta(resposta); // Retorna se a resposta está correta
            }

            personagemPlayer.gastarStamina(CUSTO_HABILIDADE_ESPECIAL); // Consome a stamina da habilidade

            SpecialAbility habilidadeEspecial = personagemPlayer.getHabilidadeEspecial(); // Obtém a habilidade do personagem

            String resposta = ""; // Algumas habilidades não precisam de resposta digitada

            boolean habilidadeFuncionou = habilidadeEspecial.usar(personagemPlayer, questaoAtual, resposta); // Usa a habilidade

            if (habilidadeFuncionou) { // Se a habilidade funcionou
                battleScreen.habilidadeUsada(personagemPlayer.getNome()); // Exibe mensagem de sucesso
                return true; // Considera a questão correta
        }

        battleScreen.habilidadeNaoAplicavel(); // Avisa que a habilidade não funciona nessa questão
        battleScreen.responderNormalmente(); // Avisa que o jogador deverá responder normalmente

        questionScreen.mostrarQuestao(questaoAtual); // mostra a pergunta novamente

        String respostaNormal = questionScreen.leituraRespostaValida(questaoAtual); // Lê a resposta normal

        return questaoAtual.verificarResposta(respostaNormal); // Verifica se a resposta está correta
    }

    public void iniciarJogo() {
        int rodada = 1;

        selectionScreen.exibirPersonagens(pJogador.getTripulacao());
        int escolha = selectionScreen.escolhaPersonagem(pJogador.getTripulacao());
        pJogador.selecionarPersonagem(escolha);
        
        while (pJogador.getPersonagemAtual().estaVivo() && pInimigo.estaVivo()) {
            CrewMember personagemPlayer = pJogador.getPersonagemAtual();
            Question questaoAtual;

            //Loop até achar uma pergunta que ainda não foi usada
            do {
                questaoAtual = gerenciadorPergunta.questaoSorteada();
            } while (perguntasUsadas.contains(questaoAtual));
            //Marca a pergunta como usada
            perguntasUsadas.add(questaoAtual);

            battleScreen.exibirRodada(rodada);

            questionScreen.mostrarQuestao(questaoAtual);

            boolean resultado;
            int escolhaAcao = battleScreen.escolherAcaoEspecialOuResponder();

            switch (escolhaAcao) {
                case 1:
                    resultado = tentarUsarHabilidadeEspecial(personagemPlayer, questaoAtual);
                    break;

                case 0:
                default:
                    questionScreen.pedirResposta(); // mostra "Resposta: "
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
                battleScreen.resultadoRodada(rodada, true, personagemPlayer.getNome(), dano);

            } else {
                int quantidadeAtaques = 1; // Por padrão, o inimigo ataca apenas uma vez

                if (pInimigo instanceof Enemy) { // Verifica se o inimigo é um objeto da classe Enemy
                    Enemy inimigo = (Enemy) pInimigo; // Converte Character para Enemy
                    quantidadeAtaques = inimigo.getComAbility().ataquesExtras(rodada); // Verifica ataques extras
                }

                int danoTotal = 0; // Guarda a soma dos danos da rodada

                for (int i = 0; i < quantidadeAtaques; i++) { // Repete de acordo com a quantidade de ataques
                    int dano = 0;
                    
                    try{
                        dano = pInimigo.atacar(0, personagemPlayer); // Calcula o dano base
                    } catch (AtaqueInvalidoException e){
                        System.out.println("Erro : " + e.getMessage());
                    } catch (AtaqueIndisponivelException e){
                        System.out.println("Erro " + e.getMessage());
                    }
                    
                    if (pInimigo instanceof Enemy) { // Verifica se possui habilidade de combate
                        Enemy inimigo = (Enemy) pInimigo; // Converte para Enemy
                        dano = inimigo.getComAbility().modificarDano(dano, rodada); // Aplica habilidade ofensiva
                        }

                    danoTotal += dano; // Soma ao dano total
                }
                battleScreen.respostaErradaEscolhaDefesa();
                int defender = battleScreen.defender(personagemPlayer.getDefesasRestantes(), personagemPlayer.getDefesasMaximas(),
                 personagemPlayer.getDesviosRestantes(), personagemPlayer.getDesviosMaximos()); // Pergunta se o jogador quer defender

                if (defender == 0) { // Se escolher defender
                    try{ 
                        danoTotal = personagemPlayer.defender(danoTotal); // Reduz o dano
                        personagemPlayer.usarDefesa();
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
                        personagemPlayer.usarDesvio();
                    } else {
                        personagemPlayer.usarDesvio();
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

                battleScreen.resultadoRodada(rodada, false, pInimigo.getNome(), danoTotal); // Mostra resultado
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
    }
}