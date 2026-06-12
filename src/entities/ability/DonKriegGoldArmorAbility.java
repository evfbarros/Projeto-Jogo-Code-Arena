package entities.ability;

public class DonKriegGoldArmorAbility implements CombatAbility {

    @Override
    public int modificarDano(int danoBase, int rodada) {
        return danoBase; // não altera o ataque
    }

    @Override
    public int modificarDanoRecebido(int danoBase, int rodada) {
        if (rodada % 2 == 0) {// A cada 2 rodadas recebe um dano pela metade
            return danoBase / 2;
        }
        return danoBase;
    }
}
