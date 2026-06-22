package entities.ability;

public class HatchanSixSwordAbility implements CombatAbility {

    @Override
    public int modificarDano(int danoBase, int rodada) {
        return danoBase;
    }

    @Override
    public int ataquesExtras(int rodada) {

        if (rodada % 3 == 0) {
            return 2;
        }

        return 1;
    }
}