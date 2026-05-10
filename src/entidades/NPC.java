package entidades;

public class NPC extends Character {
    public NPC(String nome, int vida, int stamina , int ataque , int defesa , int velocidade){
        super(nome, vida, stamina, ataque, defesa, velocidade);
    }

    @Override
    public int atacar(Character alvo) {
        int dano = 10;
        return dano;
        //provisorio so para nao da o erro do metodo nao ta compativel com o da classe mae
    }
    @Override
    public void defender() {
    }

}