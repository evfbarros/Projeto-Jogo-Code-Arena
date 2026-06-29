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
        if (random.nextInt(100) < 30) {
            return 0;
        }
        return danoBase;
    }
    @Override
    public String getNome() {
        return "Corpo Bara Bara";
    }

    @Override
    public String getDescricao() {
        return "Buggy tem chance de separar o corpo e desviar completamente do dano recebido.";
    }
}
