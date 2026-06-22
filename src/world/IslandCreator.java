package world;

import java.util.ArrayList;

import entities.CharacterCreator;
import entities.CrewMember;
import entities.Enemy;
import entities.NPC;

public class IslandCreator {
    public static Island criarShellsTown(){
        ArrayList<NPC> marinheiros = new ArrayList<>();
        Enemy morgan = CharacterCreator.personagemCapitaoMorgan();
        Enemy helmeppo = CharacterCreator.personagemHelmeppo();
        CrewMember zoro = CharacterCreator.personagemZoro();
        return new Island("Shells Town",marinheiros, helmeppo, morgan, zoro);
    }
    public static Island criarOrangeTown(){
        ArrayList<NPC> piratasBuggy = new ArrayList<>();
        Enemy mohji = CharacterCreator.personagemMohji();
        Enemy buggy = CharacterCreator.personagemBuggy();
        CrewMember nami = CharacterCreator.personagemNami();
        return new Island("Orange Town", piratasBuggy, mohji, buggy, nami);
    }
    public static Island criarSyrupVillage() {
        ArrayList<NPC> piratasGato = new ArrayList<>();
        Enemy jango = CharacterCreator.personagemJango();
        Enemy kuro = CharacterCreator.personagemCapitaoKuro();
        CrewMember usopp = CharacterCreator.personagemUsopp();
        return new Island("Vila Syrup", piratasGato, jango,kuro,usopp);
    }
    public static Island criarBaratie(){
        ArrayList<NPC> piratasKrieg = new ArrayList<>();
        Enemy donKrieg = CharacterCreator.personagemDonKrieg();
        Enemy gin = CharacterCreator.personagemGin();
        CrewMember sanji = CharacterCreator.personagemSanji();
        return new Island("Baratie", piratasKrieg, gin, donKrieg, sanji);
    }
    public static Island criarArlongPark(){
        ArrayList<NPC> piratasArlong = new ArrayList<>();
        Enemy hatchan = CharacterCreator.personagemHatchan();
        Enemy arlong = CharacterCreator.personagemArlong();
        CrewMember nami = CharacterCreator.personagemNami();
        return new Island("Arlong Park", piratasArlong, hatchan, arlong, nami);
    }
}
