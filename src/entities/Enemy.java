package entities;

import java.util.ArrayList;

import entities.ability.CombatAbility;

public class Enemy extends Character {
     private CombatAbility habilidadeCombate;
     private ArrayList<Attack> listaAtaque;

     public Enemy(String nome, int vida, int stamina, int ataque, int defesa, int velocidade, double xpConcedido,
               CombatAbility habilidadeCombate, ArrayList<Attack> listaAtaque) {
          super(nome, vida, stamina, ataque, defesa, velocidade, xpConcedido);
          this.habilidadeCombate = habilidadeCombate;
          this.listaAtaque = listaAtaque;
     }

     @Override
     public int atacar(int indiceAtaque, Character alvo) {
          Attack ataqueEscolhido = listaAtaque.get(indiceAtaque);
          int dano = ataqueEscolhido.calcularDano(this, alvo);
          return dano;
     }

     @Override
     public int defender(int dano) {
          dano = dano - (defesa / 2);
          if (dano < 10) {
               dano = 10;
          }
          return dano;
     }

     public CombatAbility getComAbility() {
          return habilidadeCombate;
     }

     public void setHabilidadeCombate(CombatAbility habilidadeCombate) {
          this.habilidadeCombate = habilidadeCombate;
     }

     public ArrayList<Attack> getListaAtaque() {
          return listaAtaque;
     }

     public void setListaAtaque(ArrayList<Attack> listaAtaque) {
          this.listaAtaque = listaAtaque;
     }
}