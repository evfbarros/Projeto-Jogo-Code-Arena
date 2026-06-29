package entities;

import java.util.*;

import entities.ability.SpecialAbility;
import exceptions.AtaqueIndisponivelException;
import exceptions.AtaqueInvalidoException;
import exceptions.DefesaIndisponivelException;
import exceptions.DesvioIndisponivelException;

public class CrewMember extends Character {
    private SpecialAbility habilidadeEspecial;
    private ArrayList<Attack> listaAtaque;
    private int nivelAtual = 1;
    private double xpAtual = 0;
    private double xpUparNivel = 100;
    private int defesasMaximas;
    private int defesasRestantes;
    private int desviosMaximos;
    private int desviosRestantes;
    private int ataqueEscolhido;

    public CrewMember(String nome, int vida, int stamina, int ataque, int defesa, int velocidade, double xpConcedido,
            SpecialAbility habilidadeEspecial, ArrayList<Attack> listaAtaque) {
        super(nome, vida, stamina, ataque, defesa, velocidade, xpConcedido);
        this.habilidadeEspecial = habilidadeEspecial;
        this.listaAtaque = listaAtaque;
        this.defesasMaximas = 3;
        this.defesasRestantes = this.defesasMaximas;
        this.desviosMaximos = 2;
        this.desviosRestantes = this.desviosMaximos;
    }

    @Override
    public int atacar(int indiceAtaque, Character alvo) throws AtaqueInvalidoException, AtaqueIndisponivelException {
        if (indiceAtaque < 0 || indiceAtaque >= listaAtaque.size()) {
            throw new AtaqueInvalidoException(" Escolha um ataque valido.");
        }

        Attack ataqueEscolhido = listaAtaque.get(indiceAtaque);

        if (!ataqueEscolhido.podeUsar()) {
            throw new AtaqueIndisponivelException(" Ataque indisponivel, escolha outro.");
        }

        int dano = ataqueEscolhido.calcularDano(this, alvo);
        ataqueEscolhido.usar();
        return dano;
    }

    public void resetarAtaques() {
        for (Attack a : listaAtaque) {
            a.resetarAtaque();
        }
    }

    public boolean desviou() throws DesvioIndisponivelException {
        if (!podeDesviar()) {
            throw new DesvioIndisponivelException("Voce nao pode desviar no momento");
        }
        double desvio = (double) velocidade / (velocidade + 150);
        double chance = Math.random();

        usarDesvio();
        return desvio > chance;
    }

    public boolean podeDesviar() {
        return desviosRestantes > 0;
    }

    public void usarDesvio() {
        if (podeDesviar()) {
            desviosRestantes--;
        }
    }

    public void resetarDesvios() {
        desviosRestantes = desviosMaximos;
    }

    @Override
    public int defender(int dano) throws DefesaIndisponivelException {

        if (!podeDefender()) {
            throw new DefesaIndisponivelException("Voce nao pode defender no momento");
        }

        dano = dano - (defesa / 2);
        if (dano < 10) {
            dano = 10;
        }
        usarDefesa();
        return dano;

    }

    public boolean podeDefender() {
        return defesasRestantes > 0;
    }

    public void usarDefesa() {
        if (podeDefender()) {
            defesasRestantes--;
        }
    }

    public void resetarDefesa() {
        defesasRestantes = defesasMaximas;
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
        uparAtributos();
    }

    // o aumento em porcentagem ainda nao e o definitivo pq temos que testar no
    // jogo, entoa so coloquei vlaores aleatorios
    public void uparAtributos() {
        vidaMaxima = ((int) (vidaMaxima * 1.15));
        vida = vidaMaxima;

        ataque = ((int) (ataque * 1.12));

        defesa = ((int) (defesa * 1.10));

        staminaMaxima = ((int) (staminaMaxima * 1.10));
        stamina = staminaMaxima;

        velocidade = ((int) (velocidade * 1.08));
    }

    public void ajustarNivelInicial(int nivelDesejado) {
        while (nivelAtual < nivelDesejado) {
            nivelAtual++;
            xpUparNivel *= 1.5;
            uparAtributos();
        }
        xpAtual = 0;
    } // ideia é que o personagem já entre no nível médio da equipe

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

    public int getDefesasRestantes() {
        return defesasRestantes;
    }

    public void setDefesasRestantes(int defesasRestantes) {
        this.defesasRestantes = defesasRestantes;
    }

    public int getDefesasMaximas() {
        return defesasMaximas;
    }

    public void setDefesasMaximas(int defesasMaximas) {
        this.defesasMaximas = defesasMaximas;
    }

    public int getDesviosMaximos() {
        return desviosMaximos;
    }

    public void setDesviosMaximos(int desviosMaximos) {
        this.desviosMaximos = desviosMaximos;
    }

    public int getDesviosRestantes() {
        return desviosRestantes;
    }

    public void setDesviosRestantes(int desviosRestantes) {
        this.desviosRestantes = desviosRestantes;
    }

    public int getAtaqueEscolhido() {
        return ataqueEscolhido;
    }
}