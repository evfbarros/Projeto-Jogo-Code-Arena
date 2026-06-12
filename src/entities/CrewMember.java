package entities;

import java.util.*;

import entities.ability.SpecialAbility;
import exceptions.AtaqueIndisponivelException;
import exceptions.AtaqueInvalidoException;

public class CrewMember extends Character {
    private SpecialAbility habilidadeEspecial;
    private ArrayList<Attack> listaAtaque;

    public CrewMember(String nome, int vida, int stamina, int ataque, int defesa, int velocidade,
            SpecialAbility habilidadeEspecial, ArrayList<Attack> listaAtaque) {
        super(nome, vida, stamina, ataque, defesa, velocidade);
        this.habilidadeEspecial = habilidadeEspecial;
        this.listaAtaque = listaAtaque;
    }

    @Override
    public int atacar(int indiceAtaque, Character alvo) throws AtaqueInvalidoException, AtaqueIndisponivelException {
        if(indiceAtaque < 0 || indiceAtaque >= listaAtaque.size()){
            throw new AtaqueInvalidoException(" Escolha um ataque valido.");
        }
        
        Attack ataqueEscolhido = listaAtaque.get(indiceAtaque);

        if(!ataqueEscolhido.podeUsar()){
            throw new AtaqueIndisponivelException(" Ataque indisponivel, escolha outro.");
        }
        
        int dano = ataqueEscolhido.calcularDano(this, alvo);
            ataqueEscolhido.usar();
            return dano;
    }

    //ver se vou criar outra classe abstrata para crewmember e enemy herdarem pq ta tndo codigo replicado
    @Override
    public int defender(int dano) {
        dano = dano - (defesa / 2);
        if (dano < 10) {
            dano = 10;
        }
        return dano;
    }

    //o aumento em porcentagem ainda nao e o definitivo pq temos que testar no
    //jogo, entoa so coloquei vlaores aleatorios
    public void uparAtributos() {
        ataque = ((int) (ataque * 1.2));
        defesa = ((int) (defesa * 1.3));
        staminaMaxima = ((int) (staminaMaxima * 1.2));
        stamina = staminaMaxima;
        vidaMaxima = ((int) (vidaMaxima * 1.2));
        vida = vidaMaxima;
        velocidade = ((int) (velocidade * 1.3));
    }

    public SpecialAbility getHabilidadeEspecial() {
        return habilidadeEspecial;
    }

    public void setHabilidadeEspecial(SpecialAbility habilidadeEspecial) {
        this.habilidadeEspecial = habilidadeEspecial;
    }

    public ArrayList<Attack> getListaAtaque() {
        return listaAtaque;
    }

    public void setListaAtaque(ArrayList<Attack> listaAtaque) {
        this.listaAtaque = listaAtaque;
    }
}