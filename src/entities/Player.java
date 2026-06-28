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
        int nivelMedio = calcularNivelMedioTripulacao();
        novoPersonagem.ajustarNivelInicial(nivelMedio);
        tripulacao.add(novoPersonagem);
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
    public ArrayList<CrewMember> distribuirXPParaTripulacao(double xpRecebido) {
        ArrayList<CrewMember> personagensQueUparam = new ArrayList<>();
        for (CrewMember personagem : tripulacao) {
            boolean upou = personagem.ganharXP(xpRecebido);
            if (upou) {
            personagensQueUparam.add(personagem);
            }
        }
        return personagensQueUparam;
    }
    private int calcularNivelMedioTripulacao() {
        int somaNiveis = 0;
        for (CrewMember personagem : tripulacao) {
            somaNiveis += personagem.getNivelAtual();
        }
    return somaNiveis / tripulacao.size();
    }
}
