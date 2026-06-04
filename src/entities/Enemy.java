package entities;

public class Enemy extends Character {
   private CombatAbility habilidadeCombate;

     public Enemy(String nome, int vida, int stamina , int ataque , int defesa , int velocidade, CombatAbility habilidadeCombate){
        super(nome, vida, stamina, ataque, defesa, velocidade);
        this.habilidadeCombate = habilidadeCombate;
     }

    @Override
    public int atacar(Character alvo) {
      int danoAtaque = ataque;
      return danoAtaque;
    }

    @Override
    public void defender() {
    }

   public CombatAbility getComAbility() {
      return habilidadeCombate;
    }

   public void setHabilidadeCombate(CombatAbility habilidadeCombate) {
      this.habilidadeCombate = habilidadeCombate;
    }
}