package entities;

public class NPC extends Character {
    public NPC(String nome, int vida, int stamina , int ataque , int defesa , int velocidade){
        super(nome, vida, stamina, ataque, defesa, velocidade);
    }

    @Override
    public int atacar(Character alvo) {
        int danoAtaque = ataque;
        return danoAtaque;
    }
    
    @Override
    public void defender() {
    }

}