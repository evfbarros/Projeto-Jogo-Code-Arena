package logica.jogo;

import logica.quiz.GerenciadorPergunta;
import entidades.Character;
import java.util.Scanner;
import logica.quiz.Questao;

public class GerenciadorJogo {
    private Character personagemJogador;
    private Character personagemInimigo;
    private GerenciadorPergunta gerenciador;
    private Scanner leitor = new Scanner(System.in);

    public GerenciadorJogo(Character personagemJogador, Character personagemInimigo, GerenciadorPergunta gerenciador){
        this.personagemJogador = personagemJogador;
        this.personagemInimigo = personagemInimigo;
        this.gerenciador = gerenciador;
    }

    public void iniciarJogo(){
        int rodada = 1;
        
        while(personagemJogador.estaVivo() == true && personagemInimigo.estaVivo() == true){

            Questao questaoAtual = gerenciador.questaoSorteada();
            
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