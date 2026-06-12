package entities.ability;

public class MorganAxeHandAbility implements CombatAbility {

    @Override
    public int modificarDano(int danoBase, int rodada) {
        if (rodada % 2 == 0) { // ideia é ele dar dano dobrado a cada 2 rodadas, em rodadas pares
            return danoBase * 2;
        }
        return danoBase;
    }
}
