package entities;

//Criacao inicial dos personagens principais, ver possiveis alteracoes diante da mecanica
// do jogo e da dificuldade de enfrentar os inimigos

public class CharacterCreator {

    //PERSONAGENS JOGAVEIS
    public static CrewMember personagemLuffy(){
        return new CrewMember("Luffy", 250, 150, 100, 100, 100, new LuffyGuessAbility());
    }
    //vida normal, stamina alta, ataque normal, defesa normal, velocidade normal
    //maior stamina
    public static CrewMember personagemZoro(){
        return new CrewMember("Zoro", 300, 100, 150, 150, 100, new ZoroCutAbility());
    }
    //vida alta, stamina normal, ataque alto, defesa alta, velocidade normal
    //maior vida, atk e defesa
    public static CrewMember personagemSanji(){
        return new CrewMember("Sanji", 250, 150, 100, 150, 100, new SanjiCookAbility());
    }
    //vida normal, stamina alta, ataque normal, defesa alta, velocidade normal
    //maior stamina e defesa
    public static CrewMember personagemNami(){
        return new CrewMember("Nami", 200, 100, 100, 100, 150, null);
    }
    //vida normal, stamina normal, ataque normal, defesa normal, velocidade alta
    //maior velocidade
    public static CrewMember personagemUsopp(){
        return new CrewMember("Usopp", 150, 200, 50, 150, 200, null);
    }
    //vida baixa, stamina alta, ataque baixo, defesa alta, velocidade alta
    //maior stamina e velocidade


    //PERSONAGENS BOSS
    public static Enemy personagemCapitaoMorgan(){
        return new Enemy("Capitão Morgan", 350, 200, 250, 200, 100, null);
    }
    //primeiro boss, mais facil, so tem mais atk

    public static Enemy personagemBuggy(){
        return new Enemy("Buggy", 450, 250, 200, 300, 150, null);
    }
    //segundo boss, mais vida, mais stamina, mais defesa e velocidade

    public static Enemy personagemCapitaoKuro(){
        return new Enemy("Capitão Kuro", 500, 300, 250, 300, 200, null);
    }
    //mais vida, stamina, atk e velocidade

    public static Enemy personagemDonKrieg(){
        return new Enemy("Don Krieg", 600, 250, 300, 300, 100, null);
    }
    //mais tank, mais vida, atk e defesa

    public static Enemy personagemArlong(){
        return new Enemy("Arlong", 800, 400, 400, 350, 300, null);
    }
    //boss final
}
