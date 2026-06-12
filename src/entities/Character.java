package entities;

import exceptions.AtaqueIndisponivelException;
import exceptions.AtaqueInvalidoException;

public abstract class Character {
    protected String nome;
    protected int vida;
    protected int vidaMaxima;
    protected int stamina;
    protected int staminaMaxima;
    protected int ataque;
    protected int defesa;
    protected int velocidade;

    public Character(String nome, int vida, int stamina, int ataque, int defesa, int velocidade) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.stamina = stamina;
        this.staminaMaxima = stamina;
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
    }

    public abstract int atacar(int escolhaAtaque, Character alvo) throws AtaqueInvalidoException, AtaqueIndisponivelException;

    public abstract int defender(int dano);

    public int receberDano(int dano) {
        if (dano >= vida) {
            vida = 0;
        } else if (dano < vida) {
            vida = vida - dano;
        }
        return vida;
    }

    public int recuperarVida(int vidaRecuperada) {
        if ((vida + vidaRecuperada) >= vidaMaxima) {
            vida = vidaMaxima;
        } else if ((vida + vidaRecuperada) < vidaMaxima) {
            vida = vida + vidaRecuperada;
        }
        return vida;
    }

    public int recuperarStamina(int staminaRecuperada) {
        if ((stamina + staminaRecuperada) >= staminaMaxima) {
            stamina = staminaMaxima;
        } else if ((stamina + staminaRecuperada) < staminaMaxima) {
            stamina = stamina + staminaRecuperada;
        }
        return stamina;
    }

    public int gastarStamina(int staminaGasta) {
        if (staminaGasta >= stamina) {
            stamina = 0;
        } else if (staminaGasta < stamina) {
            stamina = stamina - staminaGasta;
        }
        return stamina;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStaminaMaxima() {
        return staminaMaxima;
    }

    public void setStaminaMaxima(int staminaMaxima) {
        this.staminaMaxima = staminaMaxima;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}