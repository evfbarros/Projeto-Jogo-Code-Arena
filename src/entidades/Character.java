package entidades;

public abstract class Character {
    int vida ;
    int stamina;
    int ataque;
    int defesa;
    int velocidade;
    HabilidadeEspecial habilidadeEspecial;

    public abstract void atacar();
    public abstract void defender();
    public void caminhar(){

    }
}