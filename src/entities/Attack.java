package entities;

public class Attack {
    private String nome;
    private int poder;
    private int usosMaximos;
    private int usosRestantes;

    public Attack(String nome, int poder, int usosMaximos) {
        this.nome = nome;
        this.poder = poder;
        this.usosMaximos = usosMaximos;
        this.usosRestantes = usosMaximos;
    }

    // Calcula o dano causado pelo ataque
    public int calcularDano(Character atacante, Character defensor) {

        // Fórmula:
        // dano = poder do ataque + metade do ataque do atacante - 1/4 da defesa do
        // defensor
        int dano = poder + (atacante.getAtaque() / 2) - (defensor.getDefesa() / 4);

        // Garante que todo ataque cause pelo menos 10 de dano
        if (dano < 10) {
            dano = 10;
        }

        return dano;
    }

    // Verifica se o ataque ainda pode ser usado
    public boolean podeUsar() {
        return usosRestantes > 0;
    }

    // Reduz a quantidade de usos restantes do ataque
    public void usar() {
        if (podeUsar()) {
            usosRestantes--;
        }
    }

    public void resetarAtaque(){
        usosRestantes = usosMaximos;
    }
    
    public String getNome() {
        return nome;
    }

    public int getPoder() {
        return poder;
    }

    public int getUsosMaximos() {
        return usosMaximos;
    }

    public int getUsosRestantes() {
        return usosRestantes;
    }
}