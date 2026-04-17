package entidades;

public abstract class Character {
    protected int vida ;
    protected int vidaMáxima;
    protected int stamina;
    protected int staminaMáxima;
    protected int ataque;
    protected int defesa;
    protected int velocidade;
    protected HabilidadeEspecial habilidadeEspecial;

    public Character(int vida, int stamina, int ataque, int defesa, int velocidade){
        this.vida = vida ;
        this.vidaMáxima = vida;
        this.stamina = stamina;
        this.staminaMáxima = stamina ;
        this.ataque = ataque;
        this.defesa= defesa;
        this.velocidade = velocidade ;
    }

    public abstract void atacar(Character alvo);
    public abstract void defender();

    public int receberDano(int dano) {
        if(dano >= vida){
            vida = 0;
        } else if( dano < vida){
            vida = vida - dano ;
        } 
        return vida;
    }

    public int recuperarVida(int vidaRecuperada){
        if((vida + vidaRecuperada) >= vidaMáxima) {
            vida = vidaMáxima;
        } else if((vida + vidaRecuperada) < vidaMáxima ) {
            vida = vida + vidaRecuperada;
        }
        return vida;
    }

    public int recuperarStamina(int staminaRecuperada) {
        if((stamina + staminaRecuperada) >= staminaMáxima){
            stamina = staminaMáxima ;
        } else if((stamina + staminaRecuperada) < staminaMáxima) {
            stamina = stamina + staminaRecuperada;
        }
        return stamina ;
    }

    public int gastarStamina(int staminaGasta) {
        if(staminaGasta >= stamina) {
            stamina = 0;
        } else if(staminaGasta < stamina) {
            stamina = stamina - staminaGasta ;
        }
        return stamina ;
    }

    public boolean estaVivo() {
        return vida > 0 ;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidaMáxima() {
        return vidaMáxima;
    }

    public void setVidaMáxima(int vidaMáxima) {
        this.vidaMáxima = vidaMáxima;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStaminaMáxima() {
        return staminaMáxima;
    }

    public void setStaminaMáxima(int staminaMáxima) {
        this.staminaMáxima = staminaMáxima;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public HabilidadeEspecial getHabilidadeEspecial() {
        return habilidadeEspecial;
    }

    public void setHabilidadeEspecial(HabilidadeEspecial habilidadeEspecial) {
        this.habilidadeEspecial = habilidadeEspecial;
    }
    
}