package logic.game;

public class Stats {
    private int perguntasAcertadas;
    private int perguntasErradas;
    private int danoTotalCausado;
    private int danoTotalRecebido;
    private int rodadasJogadas;

    public void registrarAcerto() {
        perguntasAcertadas++;
    }

    public void registrarErro() {
        perguntasErradas++;
    }

    public void registrarDanoCausado(int dano) {
        danoTotalCausado += dano;
    }

    public void registrarDanoRecebido(int dano) {
        danoTotalRecebido += dano;
    }

    public void registrarRodada() {
        rodadasJogadas++;
    }

    public int getPerguntasAcertadas() {
        return perguntasAcertadas;
    }

    public int getPerguntasErradas() {
        return perguntasErradas;
    }

    public int getDanoTotalCausado() {
        return danoTotalCausado;
    }

    public int getDanoTotalRecebido() {
        return danoTotalRecebido;
    }

    public int getRodadasJogadas() {
        return rodadasJogadas;
    }
}