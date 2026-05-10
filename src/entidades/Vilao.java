package entidades;

public class Vilao extends Character {
   private HabilidadeEspecial habilidadeEspecial;

     public Vilao(String nome, int vida, int stamina , int ataque , int defesa , int velocidade, HabilidadeEspecial habilidadeEspecial){
        super(nome, vida, stamina, ataque, defesa, velocidade);
        this.habilidadeEspecial = habilidadeEspecial;
     }

    @Override
    public int atacar(Character alvo) {
      int dano = 10;
      return dano;
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
}