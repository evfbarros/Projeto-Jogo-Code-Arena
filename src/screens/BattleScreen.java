package screens;

import java.util.*;
import entities.Attack;

public class BattleScreen {
    private Scanner leitor = new Scanner(System.in);
    private void separador() {
        System.out.println("\n========================================");
    }

    private void linha() {
        System.out.println("----------------------------------------");
    }

    public void exibirRodada(int rodada) {
        separador();
        System.out.println("              RODADA " + rodada);
        separador();
    }

    public void resultadoRodada(int rodada, boolean resultado, String nomePersonagem,int dano, String ataqueInimigo, String respostaCorreta) {
        System.out.println("\n=====================================");
        System.out.println("           RESULTADO RODADA " + rodada);
        System.out.println("=====================================");

        if (resultado) {
            System.out.println("Status: resposta correta!");
            System.out.println("Dano causado: " + dano);
        } else {
            System.out.println("Status: resposta errada.");
            System.out.println("Resposta correta: " + respostaCorreta);
            System.out.println(nomePersonagem + " usou: " + ataqueInimigo);
            System.out.println("Dano recebido: " + dano);
        }

        System.out.println("=====================================");
    }
    public void atributosBatalha(String nomeJogador, int vidaJogador, String nomeInimigo, int vidaInimigo) {
        linha();
        System.out.println("STATUS DA BATALHA");
        linha();
        System.out.println(nomeJogador + " | Vida: " + vidaJogador);
        System.out.println(nomeInimigo + " | Vida: " + vidaInimigo);
        linha();
}

    public void resultadoBatalha(boolean resultadoBatalha, String nomeGanhador) {
        separador();
        System.out.println("              FIM DA BATALHA");
        separador();

        if (resultadoBatalha) {
            System.out.println("Parabens, voce venceu!");
        } else {
            System.out.println("Infelizmente voce foi derrotado.");
        }

        System.out.println("Vencedor: " + nomeGanhador);
        separador();
    }

    public void upouNivel(String nomeJogador, int nivelPersonagem) {
        System.out.println("Parabens " + nomeJogador + ". Nivel do personagem: " + nivelPersonagem);
    }

    public void exibirAtaques(ArrayList<Attack> listaAtaque) {
        linha();
        System.out.println("ATAQUES DISPONIVEIS");
        linha();

        for (int i = 0; i < listaAtaque.size(); i++) {
            Attack ataque = listaAtaque.get(i);
            System.out.println(i + " - " + ataque.getNome()+ " | Poder: " + ataque.getPoder()+ " | Usos: " + ataque.getUsosRestantes() + "/" 
                                + ataque.getUsosMaximos());
        }

        linha();
    }

    // vai retronar o indice do ataque escolhido
    public int escolherAtaque() {
        System.out.print("Escolha seu ataque (0 a 2): ");
        int escolha = -1;
        

        while (escolha < 0 || escolha > 2) {
            try{
                escolha = leitor.nextInt();
                leitor.nextLine();
                if(escolha < 0 || escolha > 2){
                    escolha = -1;
                    System.out.print("Escolha um ataque valido (0 a 2): ");
                }
            } catch (InputMismatchException e){
                System.out.print("Escolha um ataque valido (0 a 2): ");
                leitor.nextLine();
            }
        }
        return escolha;
    }

    public int defender(int defesasRestantes, int defesasMaximas, int desviosRestantes, int desviosMaximos) {
        System.out.println("[0] Defender | Usos: " + defesasRestantes + "/" + defesasMaximas);
        System.out.println("[1] Desviar  | Usos: " + desviosRestantes + "/" + desviosMaximos);
        System.out.println("[2] Aceitar o ataque");
        System.out.println("----------------------------------------");
        System.out.print("Escolha uma opcao: ");
        int escolha = -1;

        while (escolha < 0 || escolha > 2) {
            try{
                escolha = leitor.nextInt();
                leitor.nextLine();
                if(escolha < 0 || escolha > 2){
                    escolha = -1;
                    System.out.print("Escolha uma opcao valida (0 ou 2): ");
                }
            } catch (InputMismatchException e){
                System.out.print("Escolha uma opçao valida (0 ou 2): ");
                leitor.nextLine();
            }
        }
        return escolha;
    }

    public void desviou(){
        System.out.println("Voce conseguiu desviar e nao tomou nenhum dano.");
    }

    public void naoDesviou(){
        System.out.println("Voce falhou em desviar e tomou o dano completo.");
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
        System.out.println();
        linha();
        System.out.println("              SUA ACAO");
        linha();
        System.out.println("[0] Responder normalmente");
        System.out.println("[1] Usar habilidade especial");
        linha();
        System.out.print("Escolha uma opcao: ");

        int escolha = -1;

        while (escolha < 0 || escolha > 1) {
            try{
                escolha = leitor.nextInt();
                leitor.nextLine();
                if(escolha < 0 || escolha > 1){
                    escolha = -1;
                    System.out.print("Escolha uma opcao valida (0 ou 1): ");
                }
            } catch (InputMismatchException e){
                System.out.print("Escolha uma opçao valida (0 ou 1): ");
                leitor.nextLine();
            }
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
    }
    public void respostaCorretaEscolhaAtaque() {
        System.out.println("\nVoce acertou a questao, parabens!");
        System.out.println("Escolha uma opcao de ataque:");
    }

    public void respostaErradaEscolhaDefesa() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("          RESPOSTA INCORRETA");
        System.out.println("========================================");
        System.out.println();
        System.out.println("O inimigo preparou um ataque!");
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("          ESCOLHA SUA DEFESA");
        System.out.println("----------------------------------------");
    }

    public void inimigoDesviou(String nomeInimigo) {
        System.out.println(nomeInimigo + " desviou do ataque!");
    }
}