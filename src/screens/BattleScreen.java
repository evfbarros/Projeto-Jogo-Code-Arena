package screens;

import java.util.*;
import entities.Attack;

public class BattleScreen {
    private Scanner leitor = new Scanner(System.in);
    private void separador() {
        System.out.println("========================================");
    }

    private void linha() {
        System.out.println("────────────────────────────────────────");
    }

    //vou repetir e
    public void exibirRodada(int rodada) {
        //separador();
        linha();
        System.out.println("              RODADA " + rodada);
        linha();
        //separador();
    }

    public void resultadoRodada(int rodada, boolean resultado,String nomePersonagem,int dano, String ataque, String respostaCorreta) {
        linha();
        System.out.println("         RESULTADO RODADA " + rodada);
        linha();

        if (resultado) {
            System.out.println("Status: Resposta correta");
            System.out.println(nomePersonagem + " usou: " + ataque);
            System.out.println("Dano causado: " + dano);
        } else {
            System.out.println("Status: Resposta errada");
            System.out.println("Resposta correta: " + respostaCorreta);
            System.out.println(nomePersonagem + " usou: " + ataque);
            System.out.println("Dano recebido: " + dano);
        }

        linha();
    }
    public void atributosBatalha(String nomeJogador, int vidaJogador, int vidaMaximaJogador, String nomeInimigo, int vidaInimigo, int vidaMaximaInimigo) {
        System.out.println(nomeJogador + "  " + vidaJogador + "/" + vidaMaximaJogador + " HP");
        System.out.println(nomeInimigo + "  " + vidaInimigo + "/" + vidaMaximaInimigo + " HP");
        linha();
}

    public void novaBatalha(String personagemPlayer, String personagemInimigo){
        linha();
        System.out.println("     UMA NOVA BATALHA FOI INICIADA");
        System.out.println("      " + personagemPlayer.toUpperCase() + " VS " + personagemInimigo.toUpperCase());
        linha();
        System.out.println();
    }

    public void resultadoBatalha(boolean resultadoBatalha, String nomeGanhador) {
        System.out.println("──────────────────────────────────────────────────");
        System.out.println("          FIM DA BATALHA");

        if (resultadoBatalha) {
            System.out.println("          PARABÉNS, VOCÊ VENCEU!");
        } else {
            System.out.println("          INFELIZMENTE VOCÊ FOI DERROTADO.");
        }

        System.out.println("          VENCEDOR: " + nomeGanhador.toUpperCase());
        System.out.println("──────────────────────────────────────────────────");
    }

    public void upouNivel(String nomeJogador, int nivelPersonagem) {
        cabecalho(" Parabéns. " + nomeJogador + " subiu de nível\n Nível: " + nivelPersonagem);
    }

    public void atributosJogador(String nomeJogador, int vida, int ataque, int defesa, int stamina){
        System.out.println(" Atributos " +nomeJogador);
        System.out.println(" Vida: " + vida + "\n Ataque : " + ataque + "\n Defesa: " + defesa + "\n Stamina: " + stamina);
        linha();
    }

    public void exibirAtaques(ArrayList<Attack> listaAtaque) {
        System.out.println("────────────────────────────────────────");
        System.out.println("──────────────────────────────────────────────────");

        for (int i = 0; i < listaAtaque.size(); i++) {
            Attack ataque = listaAtaque.get(i);
            System.out.println(i + " - " + ataque.getNome()+ " | Poder: " + ataque.getPoder()+ " | Usos: " + ataque.getUsosRestantes() + "/" 
                                + ataque.getUsosMaximos());
        }

        System.out.println("──────────────────────────────────────────────────");
    }

    public int escolherAtaque() {
        System.out.print("  -> ");
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
        linha();
        System.out.print("  -> ");
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
        System.out.println("              SUA AÇÃO");
        linha();
        System.out.println("[0] Responder normalmente");
        System.out.println("[1] Usar habilidade especial");
        linha();
        System.out.print("  -> ");

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
        linha();
        System.out.println("Stamina insuficiente para usar habilidade \n" + "especial.");
    }

    public void habilidadeUsada(String mensagem) {
        linha();
        System.out.println(mensagem);
    }

    public void habilidadeDeuRuim(String mensagem){
        linha();
        System.out.println(mensagem);
        linha();
    }

    public void habilidadeNaoAplicavel() {
        linha();
        System.out.println("Habilidade indisponível para essa pergunta.");
        System.out.println("Responda a questão normalmente.");
        linha();
    }

    public void respostaCorretaEscolhaAtaque() {
        System.out.println();
        linha();
        System.out.println(" Resposta Correta. Escolha seu ataque:");
    }

    public void respostaErradaEscolhaDefesa() {
        System.out.println();
        linha();
        System.out.println(" Resposta Incorreta. O inimigo ataca!");
        linha();
        System.out.println("          ESCOLHA SUA DEFESA");
        linha();
    }

    public void inimigoDesviou(String nomeInimigo) {
        System.out.println(nomeInimigo + " desviou do ataque!");
    }

    public void inimigoDerrotado(String nomeInimigo){
        linha();
        System.out.println(" Você derrotou " + nomeInimigo);
        linha();
    }

    public void novoInimigo(String nomeInimigo){
        System.out.println("────────────────────────────────────────────");
        System.out.println(" Um novo inimigo aparece: " + nomeInimigo);
        System.out.println("────────────────────────────────────────────");
    }

    public void cabecalho(String texto) {
        int largura = 40;
        String linha = "═".repeat(largura);
        int espacos = (largura - texto.length()) / 2;
        String padding = " ".repeat(Math.max(0, espacos));
        System.out.println(linha);
        System.out.println(padding + texto);
        System.out.println(linha);
    }

    //vou acabar repetindo metodos como o cabecalho, linha e separador em outras classes sem fazer do jeito certo, mas e so pq eu ja comecei assim
    //e como e coisa de terminal, nao to dando tanta imortancia, depois eu ajeito
}