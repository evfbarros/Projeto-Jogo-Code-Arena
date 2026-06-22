package entities.ability;

import java.util.Random;

public class JangoHypnosisAbility implements CombatAbility {

    private Random random = new Random();

    @Override
    public int modificarDano(int danoBase, int rodada) {
        return danoBase;
    }

    @Override
    public int modificarDanoRecebido(int danoBase, int rodada) {
        // 30% de chance de hipnotizar o atacante e evitar o dano
        if (random.nextInt(100) < 30) {
            return 0;
        }

        return danoBase;
    }
}