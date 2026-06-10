package screens;

import java.util.*;
import entities.Attack;

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

    public void atributosBatalha(String nomeJogador, int vidaJogador, String nomeInimigo, int vidaInimigo) {
        System.out.println("          Vida " + nomeJogador + ": " + vidaJogador);
        System.out.println("          Vida " + nomeInimigo + ": " + vidaInimigo);
        System.out.println("-------------------------------------");
    }

    public void resultadoBatalha(boolean resultadoBatalha, String nomeGanhador) {
        if (resultadoBatalha) {
            System.out.println("-----FIM DE JOGO-----");
            System.out.println("\nPARABENS, VOCE VENCEU");
            System.out.println(nomeGanhador + " FOI O VENCEDOR DA BATALHA");
            System.out.println("\n---------------------");
        } else {
            System.out.println("-----------FIM DE JOGO----------");
            System.out.println("\nINFELIZMENTE VOCE FOI DERROTADO");
            System.out.println(nomeGanhador + " FOI O VENCEDOR DA BATALHA");
            System.out.println("\n--------------------------------");
        }
    }

    public void upouNivel(String nomeJogador, int nivelPersonagem) {
        System.out.println("Parabens " + nomeJogador + ". Nivel do personagem: " + nivelPersonagem);
    }

    public void exibirAtaques(ArrayList<Attack> listaAtaque) {
        System.out.println("\nLista de Ataques: ");
        for (int i = 0; i < listaAtaque.size(); i++) {
            Attack ataque = listaAtaque.get(i);
            System.out.println(i + " - " + ataque.getNome() + " | Poder: " + ataque.getPoder() + " | Usos: "
                    + ataque.getUsosRestantes() + "/" + ataque.getUsosMaximos());
        }
    }

    // vai retronar o indice do ataque escolhido
    public int escolherAtaque() {
        System.out.print("Escolha seu ataque (0 a 2): ");
        int escolha = leitor.nextInt();
        leitor.nextLine();
        while (escolha < 0 || escolha > 2) {
            System.out.println("Escolha um indice entre 0 e 2: ");
            escolha = leitor.nextInt();
            leitor.nextLine();
        }
        return escolha;
    }

    public void ataqueIndisponivel() {
        System.out.println("\nAtaque indisponivel, tente outro");
    }

    public int defender() {
        System.out.println("\n0 - Defender");
        System.out.println("1 - Ignorar");
        System.out.print("Defender ou ignorar (0 ou 1): ");
        int escolha = leitor.nextInt();
        leitor.nextLine();
        while (escolha < 0 || escolha > 1) {
            System.out.println("Escolha uma opcao valida: ");
            escolha = leitor.nextInt();
            leitor.nextLine();
        }
        return escolha;
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

    public int escolherAcaoEspecialOuResponder() {
        System.out.println("\nO que deseja fazer?");
        System.out.println("0 - Responder normalmente");
        System.out.println("1 - Usar habilidade especial");
        System.out.print("Escolha: ");

        int escolha = leitor.nextInt();
        leitor.nextLine();

        while (escolha < 0 || escolha > 1) {
            System.out.print("Escolha uma opcao valida: ");
            escolha = leitor.nextInt();
            leitor.nextLine();
    }

        return escolha;
    }

    public void staminaInsuficiente() {
        System.out.println("Stamina insuficiente para usar habilidade especial.");
    }

    public void habilidadeUsada(String nome) {
        System.out.println(nome + " usou sua habilidade especial!");
    }

    public void habilidadeNaoAplicavel() {
        System.out.println("Essa habilidade nao pode ser usada nesta questao.");
    }
    public void responderNormalmente() {
        System.out.println("Voce devera responder a questao normalmente.");
        System.out.println("Escolha:");
    }
    public void respostaCorretaEscolhaAtaque() {
        System.out.println("\nVoce acertou a questao, parabens!");
        System.out.println("Escolha uma opcao de ataque:");
    }

    public void respostaErradaEscolhaDefesa() {
        System.out.println("\nVoce errou a questao, que pena!");
        System.out.println("Escolha uma opcao de defesa:");
    }
}