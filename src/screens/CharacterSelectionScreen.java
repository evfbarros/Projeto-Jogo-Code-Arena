package screens;
import java.util.*;
import entities.CrewMember;

public class CharacterSelectionScreen {
    private Scanner leitor = new Scanner(System.in);

    public void exibirPersonagens(ArrayList<CrewMember> tripulacao){
        
        System.out.println("\nPERSONAGENS DISPONÍVEIS: ");
        System.out.println("══════════════════════════════════════════════════");
        for(int i = 0; i < tripulacao.size(); i++){
            CrewMember personagem = tripulacao.get(i);
            System.out.println(i + " - " +personagem.getNome() + " | Vida: " + personagem.getVidaMaxima() + " | Ataque : " 
            + personagem.getAtaque() + " | Defesa: " + personagem.getDefesa());
        }
        System.out.println("══════════════════════════════════════════════════");
    }
    
    public int escolhaPersonagem(ArrayList<CrewMember> tripulacao){
        int tamanhoTripulacao = tripulacao.size() - 1;
        System.out.print("FAÇA SUA ESCOLHA: (0 a " + tamanhoTripulacao + "): ");
        int escolha = -1;
        
        while(escolha < 0 || escolha > tamanhoTripulacao){
            try{
                escolha = leitor.nextInt();
                leitor.nextLine();
                if(escolha < 0 || escolha > tamanhoTripulacao){
                    escolha = -1;
                    System.out.print("Escolha um personagem disponível (0 a " + tamanhoTripulacao +  "): ");
                }
            } catch (InputMismatchException e){
                System.out.print("Escolha um personagem válido (0 a " + tamanhoTripulacao +  "): ");
                leitor.nextLine();
            }
        }
        return escolha;
    } 
}