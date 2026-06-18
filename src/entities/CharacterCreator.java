package entities;

import java.util.*;
//Criacao inicial dos personagens principais, ver possiveis alteracoes diante da mecanica
//do jogo e da dificuldade de enfrentar os inimigos

import entities.ability.ArlongFishmanhAbility;
import entities.ability.BuggyDodgeAbility;
import entities.ability.DonKriegGoldArmorAbility;
import entities.ability.KuroDoubleAttackAbility;
import entities.ability.LuffyGuessAbility;
import entities.ability.MorganAxeHandAbility;
import entities.ability.NamiNavigatorAbility;
import entities.ability.SanjiCookAbility;
import entities.ability.UsoppLieAbility;
import entities.ability.ZoroCutAbility;

public class CharacterCreator {

    // ERSONAGENS JOGAVEIS
    public static CrewMember personagemLuffy() {
        ArrayList<Attack> ataquesLuffy = new ArrayList<>();
        ataquesLuffy.add(new Attack("Gomu Gomu no Pistol", 50, 5));
        ataquesLuffy.add(new Attack("Gomu Gomu no Gatling", 75, 3));
        ataquesLuffy.add(new Attack("Gomu Gomu no Ono", 100, 1));
        return new CrewMember("Luffy", 250, 150, 100, 100, 100, 0, new LuffyGuessAbility(), ataquesLuffy);
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
        return new CrewMember("Zoro", 300, 100, 150, 150, 100, 0,  new ZoroCutAbility(), ataquesZoro);
    }

    //vida alta, stamina normal, ataque alto, defesa alta, velocidade normal
    //maior vida, atk e defesa
    public static CrewMember personagemSanji() {
        ArrayList<Attack> ataquesSanji = new ArrayList<>();
        ataquesSanji.add(new Attack("Collier Shoot", 50, 5));
        ataquesSanji.add(new Attack("Mouton Shot", 75, 3));
        ataquesSanji.add(new Attack("Concassé", 100, 1));
        return new CrewMember("Sanji", 250, 150, 100, 150, 100, 0, new SanjiCookAbility(), ataquesSanji);
    }

    //vida normal, stamina alta, ataque normal, defesa alta, velocidade normal
    //maior stamina e defesa
    public static CrewMember personagemNami() {
        ArrayList<Attack> ataquesNami = new ArrayList<>();
        ataquesNami.add(new Attack("Nami Punch", 50, 5));
        ataquesNami.add(new Attack("Bo Staff Strike", 75, 3));
        ataquesNami.add(new Attack("Nami Kick", 100, 1));
        return new CrewMember("Nami", 200, 100, 100, 100, 150, 0, new NamiNavigatorAbility(), ataquesNami);
    }

    //vida normal, stamina normal, ataque normal, defesa normal, velocidade alta
    //maior velocidade
    public static CrewMember personagemUsopp() {
        ArrayList<Attack> ataquesUsopp = new ArrayList<>();
        ataquesUsopp.add(new Attack("Tamago Boshi (Egg Star)", 50, 5));
        ataquesUsopp.add(new Attack("Tabasco Boshi (Tabasco Star)", 75, 3));
        ataquesUsopp.add(new Attack("Usopp Hammer", 100, 1));
        return new CrewMember("Usopp", 150, 200, 50, 150, 200, 0, new UsoppLieAbility(), ataquesUsopp);
    }
    //vida baixa, stamina alta, ataque baixo, defesa alta, velocidade alta
    //maior stamina e velocidade

    //PERSONAGENS BOSS
    public static Enemy personagemCapitaoMorgan() {
        ArrayList<Attack> ataquesCapitaoMorgan = new ArrayList<>();
        ataquesCapitaoMorgan.add(new Attack("Axe Slash", 50, 0));
        ataquesCapitaoMorgan.add(new Attack("Execution Chop", 75, 0));
        ataquesCapitaoMorgan.add(new Attack("Iron Justice Smash", 100, 0));
        return new Enemy("Capitão Morgan", 350, 200, 250, 200, 100, 100, new MorganAxeHandAbility(), ataquesCapitaoMorgan);
    }
    //primeiro boss, mais facil, so tem mais atk

    public static Enemy personagemBuggy() {
        ArrayList<Attack> ataquesBuggy = new ArrayList<>();
        ataquesBuggy.add(new Attack("Bara Bara Festival", 50, 0));
        ataquesBuggy.add(new Attack("Bara Bara Rush", 75, 0));
        ataquesBuggy.add(new Attack("Buggy Ball", 100, 0));
        return new Enemy("Buggy", 450, 250, 200, 300, 150, 150, new BuggyDodgeAbility(), ataquesBuggy);
    }
    //segundo boss, mais vida, mais stamina, mais defesa e velocidade

    public static Enemy personagemCapitaoKuro() {
        ArrayList<Attack> ataquesCapitaoKuro = new ArrayList<>();
        ataquesCapitaoKuro.add(new Attack("Cat Claw Combo", 50, 0));
        ataquesCapitaoKuro.add(new Attack("Shakushi", 75, 0));
        ataquesCapitaoKuro.add(new Attack("Deadly Shakushi", 100, 0));
        return new Enemy("Capitão Kuro", 500, 300, 250, 300, 200, 200, new KuroDoubleAttackAbility(), ataquesCapitaoKuro);
    }
    //mais vida, stamina, atk e velocidade

    public static Enemy personagemDonKrieg() {
        ArrayList<Attack> ataquesDonKrieg = new ArrayList<>();
        ataquesDonKrieg.add(new Attack("Explosive Spear", 50, 0));
        ataquesDonKrieg.add(new Attack("MH5 Poison Gas", 75, 0));
        ataquesDonKrieg.add(new Attack("Battle Spear Barrage", 100, 0));
        return new Enemy("Don Krieg", 600, 250, 300, 300, 100, 250, new DonKriegGoldArmorAbility(), ataquesDonKrieg);
    }
    //mais tank, mais vida, atk e defesa

    public static Enemy personagemArlong() {
        ArrayList<Attack> ataquesArlong = new ArrayList<>();
        ataquesArlong.add(new Attack("Shark on Darts", 75, 0));
        ataquesArlong.add(new Attack("Kiribachi Drill", 100, 0));
        ataquesArlong.add(new Attack("Samehada Punch", 125, 0));
        return new Enemy("Arlong", 800, 400, 400, 350, 300, 400, new ArlongFishmanhAbility(), ataquesArlong);
    }
    //boss final

    public static Enemy personagemHelmeppo() {
        ArrayList<Attack> ataquesHelmeppo = new ArrayList<>();
        ataquesHelmeppo.add(new Attack("Arrogant Slap", 25, 5));
        ataquesHelmeppo.add(new Attack("Stick Strike", 50, 5));
        ataquesHelmeppo.add(new Attack("Marine Backup", 75, 5));
        return new Enemy(null, 0, 0, 0, 0, 0, 25, null, ataquesHelmeppo);
    }
    // miniboss 1
}
