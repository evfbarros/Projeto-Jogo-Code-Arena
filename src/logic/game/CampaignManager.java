package logic.game;

import java.util.ArrayList;

import entities.CrewMember;
import entities.Enemy;
import entities.NPC;
import entities.Player;
import entities.Character;
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
    private BattleScreen battleScreen;
    private ArrayList<Question> perguntasUsadasNaCampanha = new ArrayList<>();
    private Stats stats = new Stats();

    public CampaignManager(Player jogador, QuestionManager gerenciadorPergunta, GameScreen gameScreen,
            BattleScreen battleScreen) {
        this.jogador = jogador;
        this.gerenciadorPergunta = gerenciadorPergunta;
        this.gameScreen = gameScreen;
        this.battleScreen = battleScreen;
    }

    public void iniciarCampanha() {
        ArrayList<Island> ilhas = criarRotaCampanha();

        for (Island ilha : ilhas) {
            gameScreen.exibirIlhaAtual(ilha.getNome());

            if (ilha.getNome().equalsIgnoreCase("Baratie")) {
                removerNamiAntesDeBaratie();
            }

            boolean primeiraBatalha = true;

            for (NPC npc : ilha.getInimigos()) {
                if (!primeiraBatalha) {
                    battleScreen.novoInimigo(npc.getNome());
                }
                boolean venceuInimigos = iniciarBatalha(npc, ilha, primeiraBatalha);
                primeiraBatalha = false;

                if (!venceuInimigos) {
                    gameScreen.campanhaEncerrada(npc.getNome(), stats);
                    return;
                }
            }

            if (ilha.getMiniBoss() != null) {
                battleScreen.novoInimigo(ilha.getMiniBoss().getNome());
                boolean venceuMiniBoss = iniciarBatalha(ilha.getMiniBoss(), ilha, primeiraBatalha);
                primeiraBatalha = false;

                if (!venceuMiniBoss) {
                    gameScreen.campanhaEncerrada(ilha.getMiniBoss().getNome(), stats);
                    return;
                }
            }

            if (ilha.getBoss() != null) {
                battleScreen.novoInimigo(ilha.getBoss().getNome());
                boolean venceuBoss = iniciarBatalha(ilha.getBoss(), ilha, true);

                if (!venceuBoss) {
                    gameScreen.campanhaEncerrada(ilha.getBoss().getNome(), stats);
                    return;
                }
            }

            if (ilha.getRecompensa() != null) {
                jogador.desbloquearPersonagem(ilha.getRecompensa());
                gameScreen.personagemEntrou(ilha.getRecompensa());
                battleScreen.esperarEnter();
                battleScreen.limparTerminal();
            }
        }

        gameScreen.campanhaFinalizada(stats);

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

    private boolean iniciarBatalha(Character inimigo, Island ilha, boolean selecionar) {
        BattleScreen battleScreen = new BattleScreen();
        QuestionScreen questionScreen = new QuestionScreen();
        CharacterSelectionScreen selectionScreen = new CharacterSelectionScreen();

        GameManager gameManager = new GameManager(jogador, inimigo, gerenciadorPergunta, battleScreen, questionScreen,
                selectionScreen,
                ilha.getDistribuicaoPerguntas(), perguntasUsadasNaCampanha, selecionar, stats);

        boolean venceu = gameManager.iniciarJogo();

        // return gameManager.iniciarJogo();
        return venceu;
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