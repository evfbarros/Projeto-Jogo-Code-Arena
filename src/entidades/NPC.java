package entidades;

public class NPC extends Character {
    public NPC(String nome, int vida, int stamina , int ataque , int defesa , int velocidade){
        super(vida, stamina, ataque, defesa, velocidade);
    }

    @Override
    public void atacar(Character alvo) {
        
    }
    @Override
    public void defender() {
    }

}