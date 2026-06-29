package entities;

import java.util.*;
import entities.ability.*;


public class CharacterCreator {

    public static CrewMember personagemLuffy() {
        ArrayList<Attack> ataquesLuffy = new ArrayList<>();
        ataquesLuffy.add(new Attack("Gomu Gomu no Pistol", 50, 5));
        ataquesLuffy.add(new Attack("Gomu Gomu no Gatling", 75, 3));
        ataquesLuffy.add(new Attack("Gomu Gomu no Ono", 100, 1));
        CrewMember luffy = new CrewMember("Luffy", 280, 180, 120, 95, 100, 0, new LuffyGuessAbility(), ataquesLuffy);
        luffy.setFalaEntrada("Eu vou te derrotar e vou ser o Rei dos Piratas!");
        return luffy;
    }

    public static CrewMember personagemZoro() {
        ArrayList<Attack> ataquesZoro = new ArrayList<>();
        ataquesZoro.add(new Attack("Oni Giri", 50, 5));
        ataquesZoro.add(new Attack("Tora Gari", 75, 3));
        ataquesZoro.add(new Attack("Santoryu Ougi: Sanzen Sekai", 100, 1));
        CrewMember zoro = new CrewMember("Zoro", 300, 160, 140, 85, 95, 0,  new ZoroCutAbility(), ataquesZoro);
        zoro.setFalaEntrada("Nao importa quem esteja no caminho. Eu vou cortar qualquer obstaculo, saiba que eu serei o maior espadachim do mundo.");
        return zoro;
    }

    public static CrewMember personagemSanji() {
        ArrayList<Attack> ataquesSanji = new ArrayList<>();
        ataquesSanji.add(new Attack("Collier Shoot", 50, 5));
        ataquesSanji.add(new Attack("Mouton Shot", 75, 3));
        ataquesSanji.add(new Attack("Concassé", 100, 1));
        CrewMember sanji = new CrewMember("Sanji", 270, 180, 125, 100, 115, 0, new SanjiCookAbility(), ataquesSanji);
        sanji.setFalaEntrada("Eu nao perdoo quem machuca uma dama. Eu sou o cozinheiro do amor que vai achar o All Blue.");
        return sanji;
    }

    public static CrewMember personagemNami() {
        ArrayList<Attack> ataquesNami = new ArrayList<>();
        ataquesNami.add(new Attack("Nami Punch", 50, 5));
        ataquesNami.add(new Attack("Bo Staff Strike", 75, 3));
        ataquesNami.add(new Attack("Nami Kick", 100, 1));
        CrewMember nami = new CrewMember("Nami", 220, 190, 110, 75, 135, 0, new NamiNavigatorAbility(), ataquesNami);
        nami.setFalaEntrada("Eu conheco estes mares melhor do que voce imagina. Saiba que eu sou a navegadora que vai desenhar o mapa-mundi");
        return nami;
    }

    public static CrewMember personagemUsopp() {
        ArrayList<Attack> ataquesUsopp = new ArrayList<>();
        ataquesUsopp.add(new Attack("Tamago Boshi (Egg Star)", 50, 5));
        ataquesUsopp.add(new Attack("Tabasco Boshi (Tabasco Star)", 75, 3));
        ataquesUsopp.add(new Attack("Usopp Hammer", 100, 1));
        CrewMember usopp = new CrewMember("Usopp", 210, 210, 115, 80, 145, 0, new UsoppLieAbility(), ataquesUsopp);
        usopp.setFalaEntrada("Tremam diante do grande Capitao Usopp! Sou um bravo guerreiro do mar");
        return usopp;
    }

    public static Enemy personagemCapitaoMorgan() {
        ArrayList<Attack> ataquesCapitaoMorgan = new ArrayList<>();
        ataquesCapitaoMorgan.add(new Attack("Axe Slash", 50, 5));
        ataquesCapitaoMorgan.add(new Attack("Execution Chop", 75, 3));
        ataquesCapitaoMorgan.add(new Attack("Iron Justice Smash", 100, 2));
        Enemy morgan = new Enemy("Capitão Morgan", 340, 180, 115, 90, 80, 120, new MorganAxeHandAbility(), ataquesCapitaoMorgan);
         morgan.setFalaEntrada("A justica da Marinha esmagara qualquer pirata que cruzar meu caminho!Eu sou a justica!");
        return morgan;
    }
    

    public static Enemy personagemBuggy() {
        ArrayList<Attack> ataquesBuggy = new ArrayList<>();
        ataquesBuggy.add(new Attack("Bara Bara Festival", 50, 5));
        ataquesBuggy.add(new Attack("Bara Bara Rush", 75, 3));
        ataquesBuggy.add(new Attack("Buggy Ball", 100, 2));
        Enemy buggy = new Enemy("Buggy", 400, 200, 135, 105, 130, 160, new BuggyDodgeAbility(), ataquesBuggy);
        buggy.setFalaEntrada("Quem ousa desafiar o grande e temido Capitao Buggy?");
        return buggy;
    }

    public static Enemy personagemCapitaoKuro() {
        ArrayList<Attack> ataquesCapitaoKuro = new ArrayList<>();
        ataquesCapitaoKuro.add(new Attack("Cat Claw Combo", 50, 5));
        ataquesCapitaoKuro.add(new Attack("Shakushi", 75, 3));
        ataquesCapitaoKuro.add(new Attack("Deadly Shakushi", 100, 2));
        Enemy kuro = new  Enemy("Capitão Kuro", 480, 220, 140, 105, 180, 200, new KuroDoubleAttackAbility(), ataquesCapitaoKuro);
        kuro.setFalaEntrada("Voce nao consegue acompanhar meus movimentos.");
        return kuro;
    }

    public static Enemy personagemDonKrieg() {
        ArrayList<Attack> ataquesDonKrieg = new ArrayList<>();
        ataquesDonKrieg.add(new Attack("Explosive Spear", 50, 5));
        ataquesDonKrieg.add(new Attack("Poison Gas Bomb", 75, 3));
        ataquesDonKrieg.add(new Attack("MH5", 100, 2));
        Enemy donKrieg = new Enemy("Don Krieg", 560, 220, 155, 125, 80, 260, new DonKriegGoldArmorAbility(), ataquesDonKrieg);
        donKrieg.setFalaEntrada("Com minha armadura e meu arsenal, nenhum pirata iniciante pode me vencer");
        return donKrieg;
    }

    public static Enemy personagemArlong() {
        ArrayList<Attack> ataquesArlong = new ArrayList<>();
        ataquesArlong.add(new Attack("Shark on Darts", 65, 5));
        ataquesArlong.add(new Attack("Kiribachi Drill", 90, 3));
        ataquesArlong.add(new Attack("Samehada Punch", 115, 2));
        Enemy arlong = new Enemy("Arlong", 700, 280, 170, 145, 165, 400, new ArlongFishmanhAbility(), ataquesArlong);
        arlong.setFalaEntrada("Este mar pertence aos homens-peixe. Humanos jamais ficarao acima de mim!");
        return arlong;
    }

    public static Enemy personagemHelmeppo() {
        ArrayList<Attack> ataquesHelmeppo = new ArrayList<>();
        ataquesHelmeppo.add(new Attack("Arrogant Slap", 45, 5));
        ataquesHelmeppo.add(new Attack("Stick Strike", 60, 4));
        ataquesHelmeppo.add(new Attack("Marine Backup", 80, 2));
        Enemy helmeppo = new Enemy("Helmeppo", 240, 150, 80, 60, 80, 80, new DefaultCombatAbility(), ataquesHelmeppo);
        helmeppo.setFalaEntrada("Voce acha que pode desafiar o filho do Capitao Morgan?");
        return helmeppo;
}
    public static Enemy personagemMohji() {
        ArrayList<Attack> ataquesMohji = new ArrayList<>();
        ataquesMohji.add(new Attack("Whip Strike", 45, 5));
        ataquesMohji.add(new Attack("Richie's Attack", 65, 3));
        ataquesMohji.add(new Attack("Wild Charge", 85, 1));
        Enemy mohji = new Enemy("Mohji", 300, 150, 95, 75, 90, 100, new DefaultCombatAbility(), ataquesMohji);
        mohji.setFalaEntrada("Richie e eu vamos acabar com voce!");
        return mohji;
    }
    public static Enemy personagemJango() {
        ArrayList<Attack> ataquesJango = new ArrayList<>();
        ataquesJango.add(new Attack("Cutting Disc", 45, 5));
        ataquesJango.add(new Attack("Deceptive Step", 65, 3));
        ataquesJango.add(new Attack("Hypnotic Attack", 85, 1));
        Enemy jango = new Enemy("Jango", 340, 170, 105, 85, 140, 120, new JangoHypnosisAbility(), ataquesJango);
        jango.setFalaEntrada("Quando eu contar ate tres, voce ja estara derrotado.");
        return jango;
    } 
    public static Enemy personagemGin() {
        ArrayList<Attack> ataquesGin = new ArrayList<>();
        ataquesGin.add(new Attack("Tonfa Strike", 50, 5));
        ataquesGin.add(new Attack("Pearl Crusher", 75, 3));
        ataquesGin.add(new Attack("Demon Man Strike", 95, 2));
        Enemy gin = new Enemy("Gin", 400, 180, 120, 100, 145, 140, new DefaultCombatAbility(), ataquesGin);
        gin.setFalaEntrada("Eu respeito sua coragem, mas nao posso deixar voce passar.");
        return gin;
    }
    public static Enemy personagemHatchan() {
        ArrayList<Attack> ataquesHatchan = new ArrayList<>();
        ataquesHatchan.add(new Attack("Dual Sword Slash", 60, 5));
        ataquesHatchan.add(new Attack("Spinning Attack", 80, 3));
        ataquesHatchan.add(new Attack("Six-Sword Style", 105, 1));
        Enemy hatchan = new Enemy("Hatchan", 460, 200, 130, 115, 150, 170, new HatchanSixSwordAbility(), ataquesHatchan);
        hatchan.setFalaEntrada("Com seis espadas, eu consigo cortar qualquer caminho ate Arlong Park!");
        return hatchan;
    }

    public static NPC marinheirosShellsTown(String nome){
        NPC marinheiro = new NPC(nome, 150, 100, 45, 40, 70, 50);
        marinheiro.setFalaEntrada("Vou te capturar, seu pirata imundo!");
        return marinheiro;
    }

    public static NPC piratasBuggy(String nome){
        NPC pirataBuggy = new NPC(nome, 180, 100, 60, 55, 85, 50);
        pirataBuggy.setFalaEntrada("Ninguem passa pelo bando do Capitao Buggy!");
        return pirataBuggy;
    }

    public static NPC piratasGatoPreto(String nome){
        NPC pirataGatoPreto = new NPC(nome, 210, 120, 70, 65, 105, 60);
        pirataGatoPreto.setFalaEntrada("O bando do Gato Preto nao deixa intrusos escaparem.");
        return pirataGatoPreto;
    }

    public static NPC piratasKrieg(String nome){
        NPC pirataKrieg = new NPC(nome, 240, 130, 85, 80, 90, 70);
        pirataKrieg.setFalaEntrada("O bando do Don Krieg domina estes mares!");
        return pirataKrieg;
    }

    public static NPC piratarArlong(String nome){
        NPC pirataArlong = new NPC(nome, 280, 140, 100, 90, 110, 80);
        pirataArlong.setFalaEntrada("Humanos fracos nao deveriam se meter com os Piratas Arlong!");
        return pirataArlong;
    }

}
