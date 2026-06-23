package entities;

import java.util.ArrayList;

import entities.ability.CombatAbility;
import exceptions.DesvioIndisponivelException;

public class Enemy extends Character {
     private CombatAbility habilidadeCombate;
     private ArrayList<Attack> listaAtaque;
     private int ataqueUsado;

     public Enemy(String nome, int vida, int stamina, int ataque, int defesa, int velocidade, double xpConcedido,
               CombatAbility habilidadeCombate, ArrayList<Attack> listaAtaque) {
          super(nome, vida, stamina, ataque, defesa, velocidade, xpConcedido);
          this.habilidadeCombate = habilidadeCombate;
          this.listaAtaque = listaAtaque;
     }

     @Override
     public int atacar(int indiceAtaque, Character alvo) {
          int indiceSorteado = sorteioAtaque();

          for(int i = 0; i < listaAtaque.size(); i++){
               int indiceAtual = (indiceSorteado + i) % listaAtaque.size();
               Attack ataqueEscolhido = listaAtaque.get(indiceAtual);

               if(ataqueEscolhido.podeUsar()){
                    ataqueEscolhido.usar();
                    ataqueUsado = indiceAtual;
                    return ataqueEscolhido.calcularDano(this, alvo);
               }
          }
          
          return 25;
          //nesse metodo apenas ignorei o parametro indiceAtaque
     }

     public int sorteioAtaque(){
          double sorteio = Math.random();
          int indiceAtaque; // nao e escolhido, na verdade e o sorteado pq o enemy nao vai escolher de fato

          if(sorteio <= 0.45){
               indiceAtaque = 0;
          } else if(sorteio > 0.45 && sorteio <= 0.75){
               indiceAtaque = 1;
          } else {
               indiceAtaque = 2;
          }

          return indiceAtaque;
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

     public int getAtaqueUsado(){
          return ataqueUsado;
     }
}