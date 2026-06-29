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

    public int calcularDano(Character atacante, Character defensor) {

        int dano = poder + (atacante.getAtaque() / 2) - (defensor.getDefesa() / 4);
        if (dano < 30) {
            dano = 30;
        }

        return dano;
    }
    public boolean podeUsar() {
        return usosRestantes > 0;
    }
    public void usar() {
        if (podeUsar()) {
            usosRestantes--;
        }
    }

    public void resetarAtaque() {
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