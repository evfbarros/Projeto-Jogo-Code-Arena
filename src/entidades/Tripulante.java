package entidades;

public class Tripulante extends Character {
    private HabilidadeEspecial habilidadeEspecial;
    public Tripulante(String nome, int vida, int stamina , int ataque , int defesa , int velocidade, HabilidadeEspecial habilidadeEspecial){
        super(nome, vida, stamina, ataque, defesa, velocidade);
        this.habilidadeEspecial = habilidadeEspecial;
    }

    @Override
    public void atacar(Character alvo) {
    }

    @Override
    public void defender() {
    }

    public HabilidadeEspecial getHabilidadeEspecial() {
        return habilidadeEspecial;
    }

    public void setHabilidadeEspecial(HabilidadeEspecial habilidadeEspecial) {
        this.habilidadeEspecial = habilidadeEspecial;
    }

    // adicao dos get e set ded habilidadeEspecial
}