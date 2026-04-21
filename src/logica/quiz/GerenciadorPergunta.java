package logica.quiz;
import java.util.Random;
import java.util.ArrayList;

public class GerenciadorPergunta{
    private ArrayList<Questao> listaQuestoes;
    private Random sorteio = new Random();

    public GerenciadorPergunta(ArrayList<Questao> listaQuestoes){
        this.listaQuestoes = listaQuestoes;
    }   

    public int questaoSorteada(){
        int tamanhoLista = listaQuestoes.size();
        return sorteio.nextInt(tamanhoLista);
    }


}
