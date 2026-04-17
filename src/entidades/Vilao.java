package entidades;

public class Vilao extends Character {
     public Vilao(String nome, int vida, int stamina , int ataque , int defesa , int velocidade, HabilidadeEspecial habilidadeEspecial){
        super(vida, stamina, ataque, defesa, velocidade);
     }

    @Override
    public void atacar(Character alvo) {
    }

    @Override
    public void defender() {
    }
}