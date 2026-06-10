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
        return new Island("Shells Town", marinheiros, helmeppo, morgan, zoro);
    }

    
}
