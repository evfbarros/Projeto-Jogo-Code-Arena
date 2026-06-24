package entities.ability;

import java.util.Random;

public class BuggyDodgeAbility implements CombatAbility {

    private Random random = new Random();

    @Override
    public int modificarDano(int danoBase, int rodada) {
        return danoBase;
    }
    @Override
    public int modificarDanoRecebido(int danoBase, int rodada) {
        if (random.nextInt(100) < 40) {
            return 0;
        }
        return danoBase;
    }
}
