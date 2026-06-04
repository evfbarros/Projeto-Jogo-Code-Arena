package entities;

public class MorganAxeHandAbility implements CombatAbility {

    @Override
    public int modificarDano(int danoBase, int rodada) {
        if (rodada % 2 == 0) {
            return danoBase * 2;
        }
        return danoBase;
    }
}
