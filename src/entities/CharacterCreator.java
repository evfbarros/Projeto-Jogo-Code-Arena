package entities;

import java.util.*;
//Criacao inicial dos personagens principais, ver possiveis alteracoes diante da mecanica
//do jogo e da dificuldade de enfrentar os inimigos
import entities.ability.*;


public class CharacterCreator {

    // ERSONAGENS JOGAVEIS
    public static CrewMember personagemLuffy() {
        ArrayList<Attack> ataquesLuffy = new ArrayList<>();
        ataquesLuffy.add(new Attack("Gomu Gomu no Pistol", 50, 5));
        ataquesLuffy.add(new Attack("Gomu Gomu no Gatling", 75, 3));
        ataquesLuffy.add(new Attack("Gomu Gomu no Ono", 100, 1));
        return new CrewMember("Luffy", 280, 180, 120, 95, 100, 0, new LuffyGuessAbility(), ataquesLuffy);
    }

    //criacao dos ataques esta basica ainda, ver melhor quando for testando e
    //balanceando
    //vida normal, stamina alta, ataque normal, defesa normal, velocidade normal
    //maior stamina
    public static CrewMember personagemZoro() {
        ArrayList<Attack> ataquesZoro = new ArrayList<>();
        ataquesZoro.add(new Attack("Oni Giri", 50, 5));
        ataquesZoro.add(new Attack("Tora Gari", 75, 3));
        ataquesZoro.add(new Attack("Santoryu Ougi: Sanzen Sekai", 100, 1));
        return new CrewMember("Zoro", 300, 160, 140, 85, 95, 0,  new ZoroCutAbility(), ataquesZoro);
    }

    //vida alta, stamina normal, ataque alto, defesa alta, velocidade normal
    //maior vida, atk e defesa
    public static CrewMember personagemSanji() {
        ArrayList<Attack> ataquesSanji = new ArrayList<>();
        ataquesSanji.add(new Attack("Collier Shoot", 50, 5));
        ataquesSanji.add(new Attack("Mouton Shot", 75, 3));
        ataquesSanji.add(new Attack("Concassé", 100, 1));
        return new CrewMember("Sanji", 270, 180, 125, 100, 115, 0, new SanjiCookAbility(), ataquesSanji);
    }

    //vida normal, stamina alta, ataque normal, defesa alta, velocidade normal
    //maior stamina e defesa
    public static CrewMember personagemNami() {
        ArrayList<Attack> ataquesNami = new ArrayList<>();
        ataquesNami.add(new Attack("Nami Punch", 50, 5));
        ataquesNami.add(new Attack("Bo Staff Strike", 75, 3));
        ataquesNami.add(new Attack("Nami Kick", 100, 1));
        return new CrewMember("Nami", 220, 190, 110, 75, 135, 0, new NamiNavigatorAbility(), ataquesNami);
    }

    //vida normal, stamina normal, ataque normal, defesa normal, velocidade alta
    //maior velocidade
    public static CrewMember personagemUsopp() {
        ArrayList<Attack> ataquesUsopp = new ArrayList<>();
        ataquesUsopp.add(new Attack("Tamago Boshi (Egg Star)", 50, 5));
        ataquesUsopp.add(new Attack("Tabasco Boshi (Tabasco Star)", 75, 3));
        ataquesUsopp.add(new Attack("Usopp Hammer", 100, 1));
        return new CrewMember("Usopp", 210, 210, 115, 80, 145, 0, new UsoppLieAbility(), ataquesUsopp);
    }
    //vida baixa, stamina alta, ataque baixo, defesa alta, velocidade alta
    //maior stamina e velocidade

    //PERSONAGENS BOSS
    public static Enemy personagemCapitaoMorgan() {
        ArrayList<Attack> ataquesCapitaoMorgan = new ArrayList<>();
        ataquesCapitaoMorgan.add(new Attack("Axe Slash", 50, 5));
        ataquesCapitaoMorgan.add(new Attack("Execution Chop", 75, 3));
        ataquesCapitaoMorgan.add(new Attack("Iron Justice Smash", 100, 2));
        return new Enemy("Capitão Morgan", 340, 180, 115, 90, 80, 120, new MorganAxeHandAbility(), ataquesCapitaoMorgan);
    }
    //primeiro boss, mais facil, so tem mais atk

    public static Enemy personagemBuggy() {
        ArrayList<Attack> ataquesBuggy = new ArrayList<>();
        ataquesBuggy.add(new Attack("Bara Bara Festival", 50, 5));
        ataquesBuggy.add(new Attack("Bara Bara Rush", 75, 3));
        ataquesBuggy.add(new Attack("Buggy Ball", 100, 2));
        return new Enemy("Buggy", 400, 200, 135, 105, 130, 160, new BuggyDodgeAbility(), ataquesBuggy);
    }

    public static Enemy personagemCapitaoKuro() {
        ArrayList<Attack> ataquesCapitaoKuro = new ArrayList<>();
        ataquesCapitaoKuro.add(new Attack("Cat Claw Combo", 50, 5));
        ataquesCapitaoKuro.add(new Attack("Shakushi", 75, 3));
        ataquesCapitaoKuro.add(new Attack("Deadly Shakushi", 100, 2));
        return new Enemy("Capitão Kuro", 480, 220, 140, 105, 180, 200, new KuroDoubleAttackAbility(), ataquesCapitaoKuro);
    }
    //mais vida, stamina, atk e velocidade

    public static Enemy personagemDonKrieg() {
        ArrayList<Attack> ataquesDonKrieg = new ArrayList<>();
        ataquesDonKrieg.add(new Attack("Explosive Spear", 50, 5));
        ataquesDonKrieg.add(new Attack("Poison Gas Bomb", 75, 3));
        ataquesDonKrieg.add(new Attack("MH5", 100, 2));
        return new Enemy("Don Krieg", 560, 220, 155, 125, 80, 260, new DonKriegGoldArmorAbility(), ataquesDonKrieg);
    }

    public static Enemy personagemArlong() {
        ArrayList<Attack> ataquesArlong = new ArrayList<>();
        ataquesArlong.add(new Attack("Shark on Darts", 65, 5));
        ataquesArlong.add(new Attack("Kiribachi Drill", 90, 3));
        ataquesArlong.add(new Attack("Samehada Punch", 115, 2));
        return new Enemy("Arlong", 700, 280, 170, 145, 165, 400, new ArlongFishmanhAbility(), ataquesArlong);
    }
    //boss final

    public static Enemy personagemHelmeppo() {
        ArrayList<Attack> ataquesHelmeppo = new ArrayList<>();
        ataquesHelmeppo.add(new Attack("Arrogant Slap", 45, 5));
        ataquesHelmeppo.add(new Attack("Stick Strike", 60, 4));
        ataquesHelmeppo.add(new Attack("Marine Backup", 80, 2));
        return new Enemy("Helmeppo", 240, 150, 80, 60, 80, 80, new DefaultCombatAbility(), ataquesHelmeppo);
    }
    // miniboss 1
    public static Enemy personagemMohji() {
        ArrayList<Attack> ataquesMohji = new ArrayList<>();
        ataquesMohji.add(new Attack("Whip Strike", 45, 5));
        ataquesMohji.add(new Attack("Richie's Attack", 65, 3));
        ataquesMohji.add(new Attack("Wild Charge", 85, 1));
        return new Enemy("Mohji", 300, 150, 95, 75, 90, 100, new DefaultCombatAbility(), ataquesMohji);
    }
    public static Enemy personagemJango() {
        ArrayList<Attack> ataquesJango = new ArrayList<>();
        ataquesJango.add(new Attack("Cutting Disc", 45, 5));
        ataquesJango.add(new Attack("Deceptive Step", 65, 3));
        ataquesJango.add(new Attack("Hypnotic Attack", 85, 1));
        return new Enemy("Jango", 340, 170, 105, 85, 140, 120, new JangoHypnosisAbility(), ataquesJango);
    } // miniboss 3
    public static Enemy personagemGin() {
        ArrayList<Attack> ataquesGin = new ArrayList<>();
        ataquesGin.add(new Attack("Tonfa Strike", 50, 5));
        ataquesGin.add(new Attack("Pearl Crusher", 75, 3));
        ataquesGin.add(new Attack("Demon Man Strike", 95, 2));
        return new Enemy("Gin", 400, 180, 120, 100, 145, 140, new DefaultCombatAbility(), ataquesGin);
    }// miniboss 4
    public static Enemy personagemHatchan() {
        ArrayList<Attack> ataquesHatchan = new ArrayList<>();
        ataquesHatchan.add(new Attack("Dual Sword Slash", 60, 5));
        ataquesHatchan.add(new Attack("Spinning Attack", 80, 3));
        ataquesHatchan.add(new Attack("Six-Sword Style", 105, 1));
        return new Enemy("Hatchan", 460, 200, 130, 115, 150, 170, new HatchanSixSwordAbility(), ataquesHatchan);
    } // miniboss 5

    public static NPC marinheirosShellsTown(String nome){
        return new NPC(nome, 150, 100, 45, 40, 70, 50);
    }

    public static NPC piratasBuggy(String nome){
        return new NPC(nome, 180, 100, 60, 55, 85, 50);
    }

    public static NPC piratasGatoPreto(String nome){
        return new NPC(nome, 210, 120, 70, 65, 105, 60);
    }

    public static NPC piratasKrieg(String nome){
        return new NPC(nome, 240, 130, 85, 80, 90, 70);
    }

    public static NPC piratarArlong(String nome){
        return new NPC(nome, 280, 140, 100, 90, 110, 80);
    }

}
