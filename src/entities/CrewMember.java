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

     //o aumento em porcentagem ainda nao e o definitivo pq temos que testar no jogo, entoa so coloquei vlaores aleatorios
    public void uparAtributos(){
        ataque = ((int)(ataque * 1.2));
        defesa = ((int)(defesa * 1.3));
        staminaMaxima = ((int)(staminaMaxima * 1.2 ));
        stamina = staminaMaxima;
        vidaMaxima = ((int)(vidaMaxima * 1.2));
        vida = vidaMaxima;
        velocidade = ((int)(velocidade * 1.3));
    }

    public SpecialAbility getHabilidadeEspecial() {
        return habilidadeEspecial;
    }

    public void setHabilidadeEspecial(SpecialAbility habilidadeEspecial) {
        this.habilidadeEspecial = habilidadeEspecial;
    }
}