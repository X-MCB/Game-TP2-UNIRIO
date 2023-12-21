public abstract class Obstaculos implements Obstaculo {
    protected String nome;
    protected int vida;

    public Obstaculos(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }

    public abstract void interageComPersonagem(Personagens personagem);

}
