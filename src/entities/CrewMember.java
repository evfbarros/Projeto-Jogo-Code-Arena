package entities;

public class CrewMember extends Character {
    private SpecialAbility habilidadeEspecial;

    public CrewMember(String nome, int vida, int stamina , int ataque , int defesa , int velocidade, SpecialAbility habilidadeEspecial){
        super(nome, vida, stamina, ataque, defesa, velocidade);
        this.habilidadeEspecial = habilidadeEspecial;
    }

    @Override
    public int atacar(Character alvo) {
        int danoAtaque = ataque;
        return danoAtaque;
    }

    @Override
    public void defender() {
    }

    public SpecialAbility getHabilidadeEspecial() {
        return habilidadeEspecial;
    }

    public void setHabilidadeEspecial(SpecialAbility habilidadeEspecial) {
        this.habilidadeEspecial = habilidadeEspecial;
    }
}