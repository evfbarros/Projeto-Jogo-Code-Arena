package world;

import java.util.ArrayList;

import entities.CharacterCreator;
import entities.CrewMember;
import entities.Enemy;
import entities.NPC;
import java.util.HashMap;
import java.util.Map;
import logic.quiz.Difficulty;

public class IslandCreator {
    private static Map<Difficulty, Integer> criarDistribuicao(int facil, int medio, int dificil) {
        Map<Difficulty, Integer> distribuicao = new HashMap<>();

        distribuicao.put(Difficulty.FACIL, facil);
        distribuicao.put(Difficulty.MEDIO, medio);
        distribuicao.put(Difficulty.DIFICIL, dificil);

        return distribuicao;
    }
    public static Island criarShellsTown(){
        ArrayList<NPC> marinheiros = new ArrayList<>();
        marinheiros.add(CharacterCreator.marinheirosShellsTown("Recruta da Marinha"));
        marinheiros.add(CharacterCreator.marinheirosShellsTown("Soldado da Base"));
        Enemy morgan = CharacterCreator.personagemCapitaoMorgan();
        Enemy helmeppo = CharacterCreator.personagemHelmeppo();
        CrewMember zoro = CharacterCreator.personagemZoro();
        return new Island("Shells Town",marinheiros, helmeppo, morgan, zoro,criarDistribuicao(70, 30, 0));
    }
    public static Island criarOrangeTown(){
        ArrayList<NPC> piratasBuggy = new ArrayList<>();
        piratasBuggy.add(CharacterCreator.piratasBuggy("Espadachim do Circo"));
        piratasBuggy.add(CharacterCreator.piratasBuggy("Pirata Malabarista"));
        Enemy mohji = CharacterCreator.personagemMohji();
        Enemy buggy = CharacterCreator.personagemBuggy();
        CrewMember nami = CharacterCreator.personagemNami();
        return new Island("Orange Town", piratasBuggy, mohji, buggy, nami,criarDistribuicao(50, 40, 10));
    }
    public static Island criarSyrupVillage() {
        ArrayList<NPC> piratasGato = new ArrayList<>();
        piratasGato.add(CharacterCreator.piratasGatoPreto("Assassino Felino"));
        piratasGato.add(CharacterCreator.piratasGatoPreto("Caçador Silencioso"));
        Enemy jango = CharacterCreator.personagemJango();
        Enemy kuro = CharacterCreator.personagemCapitaoKuro();
        CrewMember usopp = CharacterCreator.personagemUsopp();
        return new Island("Vila Syrup", piratasGato, jango,kuro,usopp,criarDistribuicao(40, 40, 20));
    }
    public static Island criarBaratie(){
        ArrayList<NPC> piratasKrieg = new ArrayList<>();
        piratasKrieg.add(CharacterCreator.piratasKrieg("Soldado Blindado"));
        piratasKrieg.add(CharacterCreator.piratasKrieg("Veterano da Guerra"));
        Enemy donKrieg = CharacterCreator.personagemDonKrieg();
        Enemy gin = CharacterCreator.personagemGin();
        CrewMember sanji = CharacterCreator.personagemSanji();
        return new Island("Baratie", piratasKrieg, gin, donKrieg, sanji,criarDistribuicao(25, 45, 30));
    }
    public static Island criarArlongPark(){
        ArrayList<NPC> piratasArlong = new ArrayList<>();
        piratasArlong.add(CharacterCreator.piratarArlong("Guerreiro Homem-Peixe"));
        piratasArlong.add(CharacterCreator.piratarArlong("Caçador Abissal"));
        Enemy hatchan = CharacterCreator.personagemHatchan();
        Enemy arlong = CharacterCreator.personagemArlong();
        CrewMember nami = CharacterCreator.personagemNami();
        return new Island("Arlong Park", piratasArlong, hatchan, arlong, nami,criarDistribuicao(10, 40, 50));
    }
}
