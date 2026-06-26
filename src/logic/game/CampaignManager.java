package logic.game;

import java.util.ArrayList;

import entities.CrewMember;
import entities.Enemy;
import entities.Player;
import logic.quiz.QuestionManager;
import screens.BattleScreen;
import screens.CharacterSelectionScreen;
import screens.GameScreen;
import screens.QuestionScreen;
import world.Island;
import world.IslandCreator;
import logic.quiz.Question;

public class CampaignManager {

    private Player jogador;
    private QuestionManager gerenciadorPergunta;
    private GameScreen gameScreen;
    private ArrayList<Question> perguntasUsadasNaCampanha = new ArrayList<>();

    public CampaignManager(Player jogador, QuestionManager gerenciadorPergunta, GameScreen gameScreen) {
        this.jogador = jogador;
        this.gerenciadorPergunta = gerenciadorPergunta;
        this.gameScreen = gameScreen;
    }

    public void iniciarCampanha() {
        ArrayList<Island> ilhas = criarRotaCampanha();

        for (Island ilha : ilhas) {
            gameScreen.exibirIlhaAtual(ilha.getNome());

            if (ilha.getNome().equalsIgnoreCase("Baratie")) {
                removerNamiAntesDeBaratie();
            }

            if (ilha.getMiniBoss() != null) {
                boolean venceuMiniBoss = iniciarBatalha(ilha.getMiniBoss(), ilha);

                if (!venceuMiniBoss) {
                    gameScreen.campanhaEncerrada(ilha.getMiniBoss().getNome());
                    return;
                }
            }

            if (ilha.getBoss() != null) {
                boolean venceuBoss = iniciarBatalha(ilha.getBoss(), ilha);

                if (!venceuBoss) {
                    gameScreen.campanhaEncerrada(ilha.getBoss().getNome());
                    return;
                }
            }

            if (ilha.getRecompensa() != null) {
                jogador.desbloquearPersonagem(ilha.getRecompensa());
                gameScreen.personagemEntrou(ilha.getRecompensa());
            }
        }

        gameScreen.campanhaFinalizada();
    }

    private ArrayList<Island> criarRotaCampanha() {
        ArrayList<Island> ilhas = new ArrayList<>();

        ilhas.add(IslandCreator.criarShellsTown());
        ilhas.add(IslandCreator.criarOrangeTown());
        ilhas.add(IslandCreator.criarSyrupVillage());
        ilhas.add(IslandCreator.criarBaratie());
        ilhas.add(IslandCreator.criarArlongPark());

        return ilhas;
    }

    private boolean iniciarBatalha(Enemy inimigo, Island ilha) {
        BattleScreen battleScreen = new BattleScreen();
        QuestionScreen questionScreen = new QuestionScreen();
        CharacterSelectionScreen selectionScreen = new CharacterSelectionScreen();

        GameManager gameManager = new GameManager(jogador,inimigo,gerenciadorPergunta,battleScreen,questionScreen,selectionScreen,ilha.getDistribuicaoPerguntas()
                                                ,perguntasUsadasNaCampanha);

        return gameManager.iniciarJogo();
    }

    private void removerNamiAntesDeBaratie() {
        CrewMember nami = null;

        for (CrewMember personagem : jogador.getTripulacao()) {
            if (personagem.getNome().equalsIgnoreCase("Nami")) {
                nami = personagem;
                break;
            }
        }

        if (nami != null) {
            jogador.removerPersonagem(nami);
            gameScreen.namiSaiu();
        }
    }
}