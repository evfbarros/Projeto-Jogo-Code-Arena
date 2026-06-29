package entities.ability;

public class KuroDoubleAttackAbility implements CombatAbility {

    @Override
    public int modificarDano(int danoBase, int rodada) {
        return danoBase; // dano normal
    }

    @Override
    public int ataquesExtras(int rodada) {
        if (rodada % 2 == 0) {
            return 2; // ataca 2 vezes
        }
        return 1; // ataque normal
    }
    @Override
    public String getNome() {
        return "Passos Silenciosos";
    }

    @Override
    public String getDescricao() {
        return "Kuro se move em alta velocidade e realiza dois ataques em rodadas pares.";
    }
}
