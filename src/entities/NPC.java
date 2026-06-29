package entities;

public class NPC extends Character {
    public NPC(String nome, int vida, int stamina, int ataque, int defesa, int velocidade, double xpConcedido) {
        super(nome, vida, stamina, ataque, defesa, velocidade, xpConcedido);
    }

    @Override
    public int atacar(int indiceAtaque, Character alvo) {
        int danoAtaque = ataque;
        return danoAtaque;
    }

    @Override
    public int defender(int dano) {
        dano = dano - (defesa / 4);
        return dano;
        
    }

}