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

    public ArrayList<CrewMember> getTripulacao() {
        return tripulacao;
    }

    public CrewMember getPersonagemAtual() {
        return personagemAtual;
    }

    public void setPersonagemAtual(CrewMember personagemAtual) {
        this.personagemAtual = personagemAtual;
    }

}
