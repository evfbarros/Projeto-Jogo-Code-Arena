package entities;

import java.util.ArrayList;

public class Player {
    private CrewMember personagemAtual;
    private ArrayList<CrewMember> tripulacao = new ArrayList<>();

    public Player(CrewMember personagemAtual) {
        this.personagemAtual = personagemAtual;
        this.tripulacao.add(personagemAtual);
    }

    public void desbloquearPersonagem(CrewMember novoPersonagem) {
        tripulacao.add(novoPersonagem);
        System.out.println(novoPersonagem.getNome() + " entrou para a tripulacao!");
    }

    public CrewMember selecionarPersonagem(int indicePersonagem){
        CrewMember personagemSelecionado = tripulacao.get(indicePersonagem);
        setPersonagemAtual(personagemSelecionado);
        return personagemSelecionado;
    }

    public void removerPersonagem(CrewMember personagem) {
        tripulacao.remove(personagem);
        if (personagemAtual == personagem && !tripulacao.isEmpty()) {
            personagemAtual = tripulacao.get(0);
        }
    }
    // Adicionei esse método por conta da Nami

    public ArrayList<CrewMember> getTripulacao() {
        return tripulacao;
    }

    public CrewMember getPersonagemAtual() {
        return personagemAtual;
    }

    public void setPersonagemAtual(CrewMember personagemAtual) {
        this.personagemAtual = personagemAtual;
    }
    public void resetarStaminaTripulacao() {
        for (CrewMember personagem : tripulacao) {
            personagem.recuperarStamina(personagem.getStaminaMaxima());
        }
    }
}
