package entidades;

public class Tripulante extends Character {
    public Tripulante(String nome, int vida, int stamina , int ataque , int defesa , int velocidade, HabilidadeEspecial habilidadeEspecial){
        super(vida, stamina, ataque, defesa, velocidade);
    }

    @Override
    public void atacar(Character alvo) {
    }

    @Override
    public void defender() {
    }
}