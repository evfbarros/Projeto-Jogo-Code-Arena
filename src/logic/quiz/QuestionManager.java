package logic.quiz;
import java.util.Random;
import java.util.ArrayList;

public class QuestionManager{
    private ArrayList<Question> listaQuestoes;
    private Random sorteio = new Random();
    private Question questaoAtual;

    public QuestionManager(ArrayList<Question> listaQuestoes){
        this.listaQuestoes = listaQuestoes;
    }   

    public Question questaoSorteada(){
        int indiceQuestao = sorteio.nextInt(listaQuestoes.size());
        questaoAtual = listaQuestoes.get(indiceQuestao);
        return questaoAtual;
        
    }

    public Question getQuestaoAtual(){
        return questaoAtual;
    }
}

