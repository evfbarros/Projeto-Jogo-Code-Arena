package entities;

import java.util.ArrayList;

public class Player {
    private CrewMember personagemAtual;
    private int nivelAtual = 1;
    private double xpAtual = 0;
    private double xpUparNivel = 100;
    private ArrayList<CrewMember> tripulacao = new ArrayList<>();

    public Player(CrewMember personagemAtual) {
        this.personagemAtual = personagemAtual;
        this.tripulacao.add(personagemAtual);
    }

    public void desbloquearPersonagem(CrewMember novoPersonagem) {
        tripulacao.add(novoPersonagem);
        System.out.println(novoPersonagem.getNome() + " entrou para a tripulacao!");
    }

    public ArrayList<CrewMember> getTripulacao() {
        return tripulacao;
    }

    public boolean ganharXP(double xpRecebido) {
        xpAtual += xpRecebido;

        boolean upou = false;
        while (xpAtual >= xpUparNivel) {
            uparNivel();
            upou = true;
        }
        return upou;
    }

    public void uparNivel() {
        xpAtual = xpAtual - xpUparNivel;
        nivelAtual += 1;
        xpUparNivel *= 1.5;
        personagemAtual.uparAtributos();
    }

    public CrewMember getPersonagemAtual() {
        return personagemAtual;
    }

    public void setPersonagemAtual(CrewMember personagemAtual) {
        this.personagemAtual = personagemAtual;
    }

    public int getNivelAtual() {
        return nivelAtual;
    }

    public void setNivelAtual(int nivelAtual) {
        this.nivelAtual = nivelAtual;
    }

    public double getXpAtual() {
        return xpAtual;
    }

    public void setXpAtual(double xpAtual) {
        this.xpAtual = xpAtual;
    }

    public double getXpUparNivel() {
        return xpUparNivel;
    }

    public void setXpUparNivel(double xpUparNivel) {
        this.xpUparNivel = xpUparNivel;
    }
}
