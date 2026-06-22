package world;

import java.util.ArrayList;

import entities.CrewMember;
import entities.Enemy;
import entities.NPC;

public class Island {

    private String nome;
    private ArrayList<NPC> inimigos;
    private Enemy miniBoss;
    private Enemy boss;
    private CrewMember recompensa;

    public Island(String nome,ArrayList<NPC> inimigos,Enemy miniBoss,Enemy boss,CrewMember recompensa) {

        this.nome = nome;
        this.inimigos = inimigos;
        this.miniBoss = miniBoss;
        this.boss = boss;
        this.recompensa = recompensa;
    }


    public String getNome() {
        return nome;
    }

    public ArrayList<NPC> getInimigos() {
        return inimigos;
    }

    public Enemy getMiniBoss() {
        return miniBoss;
    }

    public Enemy getBoss() {
        return boss;
    }

    public CrewMember getRecompensa() {
        return recompensa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setInimigos(ArrayList<NPC> inimigos) {
        this.inimigos = inimigos;
    }

    public void setMiniBoss(Enemy miniBoss) {
        this.miniBoss = miniBoss;
    }

    public void setBoss(Enemy boss) {
        this.boss = boss;
    }

    public void setRecompensa(CrewMember recompensa) {
        this.recompensa = recompensa;
    }
}