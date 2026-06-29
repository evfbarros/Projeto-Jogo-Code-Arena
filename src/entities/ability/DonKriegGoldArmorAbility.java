package entities.ability;

public class DonKriegGoldArmorAbility implements CombatAbility {

    @Override
    public int modificarDano(int danoBase, int rodada) {
        return danoBase; 
    }

    @Override
    public int modificarDanoRecebido(int danoBase, int rodada) {
        if (rodada % 2 == 0) {
            return danoBase / 2;
        }
        return danoBase;
    }
    @Override
    public String getNome() {
        return "Armadura Dourada";
    }

    @Override
    public String getDescricao() {
        return "Don Krieg usa sua armadura para reduzir pela metade o dano recebido em rodadas pares.";
    }
}
