package logica.quiz;
import java.util.Random;
import java.util.ArrayList;

public class GerenciadorPergunta{
    private ArrayList<Questao> listaQuestoes;
    private Random sorteio = new Random();
    private Questao questaoAtual;

    public GerenciadorPergunta(ArrayList<Questao> listaQuestoes){
        this.listaQuestoes = listaQuestoes;
    }   

    public Questao questaoSorteada(){
        int indiceQuestao = sorteio.nextInt(listaQuestoes.size());
        questaoAtual = listaQuestoes.get(indiceQuestao);
        return questaoAtual;
        
    }

    public Questao getQuestaoAtual(){
        return questaoAtual;
    }
}

