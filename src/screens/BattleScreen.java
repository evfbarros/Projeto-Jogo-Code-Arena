package screens;
import java.util.*;

public class BattleScreen {
    private Scanner leitor = new Scanner(System.in);

    public void exibirRodada(int rodada) {
        System.out.println("    -----RODADA " + rodada + "-----    ");
    }

    public void resultadoRodada(int rodada, boolean resultado, String nomePersonagem, int dano) {
        System.out.println("\n----------RESULTADO RODADA " + rodada + "----------");
        if (resultado) {
            System.out.println("          Resposta correta");
            System.out.println("          Voce causou " + dano + " de dano");
        } else {
            System.out.println("          Resposta errada");
            System.out.println("          Voce recebeu " + dano + " de dano");
        }
    }

    public void atributosBatalha(String nomeJogador, int vidaJogador, String nomeInimigo, int vidaInimigo){
        System.out.println("          Vida " + nomeJogador + ": " + vidaJogador);
        System.out.println("          Vida " + nomeInimigo + ": " + vidaInimigo);
        System.out.println("-------------------------------------");
    }

    public void resultadoBatalha(boolean resultadoBatalha, String nomeGanhador){
        if (resultadoBatalha){
            System.out.println("-----FIM DE JOGO-----");
            System.out.println("\nPARABENS, VOCE VENCEU");
            System.out.println( nomeGanhador + " FOI O VENCEDOR DA BATALHA");
            System.out.println("\n---------------------");
        } else {
            System.out.println("-----------FIM DE JOGO----------");
            System.out.println("\nINFELIZMENTE VOCE FOI DERROTADO");
            System.out.println( nomeGanhador + " FOI O VENCEDOR DA BATALHA");
            System.out.println("\n--------------------------------");
        }
    }

    public void esperarEnter() {
        System.out.print("\nPressione enter para continuar: ");
        leitor.nextLine();
    }

    public void limparTerminal() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
}