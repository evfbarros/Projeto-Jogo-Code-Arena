package entities.ability;

import java.util.Random;

public class BuggyDodgeAbility implements CombatAbility {

    private Random random = new Random();

    @Override
    public int modificarDano(int danoBase, int rodada) {
        // 40% de chance de esquivar
        if (random.nextInt(100) < 40) {
            return 0; // dano esquivado
        }
        return danoBase;
    }
}
