package logic.game;

import java.util.Scanner;

import entities.Character;
import logic.quiz.Question;
import logic.quiz.QuestionManager;

public class GameManager {
    private Character personagemJogador;
    private Character personagemInimigo;
    private QuestionManager gerenciador;
    private Scanner leitor = new Scanner(System.in);

    public GameManager(Character personagemJogador, Character personagemInimigo, QuestionManager gerenciador){
        this.personagemJogador = personagemJogador;
        this.personagemInimigo = personagemInimigo;
        this.gerenciador = gerenciador;
    }
    private void esperarEnter(){
        System.out.println("\nPressione enter para continuar ");
        leitor.nextLine();
    }

    private void limparTerminal() {
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

    public void iniciarJogo(){
        int rodada = 1;
        
        while(personagemJogador.estaVivo() == true && personagemInimigo.estaVivo() == true){

            Question questaoAtual = gerenciador.questaoSorteada();
            
            System.out.println("    -----RODADA " + rodada + "-----    "); 
            questaoAtual.mostrarQuestao();

            String resposta ;
            do {
                resposta = leitor.nextLine();
                if (!questaoAtual.validarResposta(resposta)) {
                    System.out.print("Resposta invalida. Tente novamente: ");
                }
            } while (!questaoAtual.validarResposta(resposta));


            if(questaoAtual.verificarResposta(resposta)){
                System.out.println("\n----------Resultado rodada " +rodada+ "----------");
                System.out.println("          Resposta correta");
                int dano = personagemJogador.atacar(personagemInimigo);
                personagemInimigo.receberDano(dano);
                //sistema de batalha bem basico, ainda falta implementar o sistema de verdade
            } else {
                System.out.println("\n----------Resultado rodada " +rodada+ "----------");
                System.out.println("          Resposta errada");
                int dano = personagemInimigo.atacar(personagemJogador);
                personagemJogador.receberDano(dano);
            }

            System.out.println("          Vida jogador: " + personagemJogador.getVida());
            System.out.println("          Vida inimigo: " +personagemInimigo.getVida());
            System.out.println("-------------------------------------");
 
            esperarEnter(); // Espera o cara dá enter para mudar de rodada

            limparTerminal(); // Limpa o terminal entre rodadas

            rodada++;
        }

        if(personagemJogador.estaVivo()){
            System.out.println("Parabens, voce venceu");
            System.out.println(personagemJogador.getNome() + " foi o ganhador da batalha");
        } else if(personagemInimigo.estaVivo()){
            System.out.println("Voce foi derrotado");
            System.out.println(personagemInimigo.getNome() + " foi o ganhador da batalha");
        }
    }

    
}