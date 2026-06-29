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
        if (random.nextInt(100) < 15) {
            return 0;
        }

        return danoBase;
    }
    @Override
    public String getNome() {
        return "Hipnose de Jango";
    }

    @Override
    public String getDescricao() {
        return "Jango pode hipnotizar o atacante e evitar completamente o dano recebido.";
    }
}