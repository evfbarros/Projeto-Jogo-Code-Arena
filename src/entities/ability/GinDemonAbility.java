package entities.ability;
public class GinDemonAbility implements CombatAbility {

    @Override
    public int modificarDano(int danoBase, int rodada) {

        if (rodada >= 3) {
            return danoBase + 40;
        }

        return danoBase;
    }
}