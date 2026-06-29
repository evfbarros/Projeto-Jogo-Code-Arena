package entities.ability;

public class MorganAxeHandAbility implements CombatAbility {

    @Override
    public int modificarDano(int danoBase, int rodada) {
        if (rodada % 2 == 0) { // ideia é ele dar dano dobrado a cada 2 rodadas, em rodadas pares
            return danoBase * 2;
        }
        return danoBase;
    }
    @Override
    public String getNome() {
        return "Mao de Machado";
    }

    @Override
    public String getDescricao() {
        return "Morgan usa sua mao de machado para causar dano dobrado em rodadas pares.";
    }
}
