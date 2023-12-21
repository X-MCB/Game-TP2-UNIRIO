import java.util.Random;
public final class Red extends Personagens{

    private String historia;
    private String poderEspecial;
    private Item item;

    Random random = new Random();

    public Red(String nome, int idade, int vida) {
        super(nome, idade, vida);
    }

    @Override
    public String contarHistoria() {
        return "Nome: " + getNome() + "\n" + "Idade: " + getIdade() + "\n" + "Vida: " + getVida() + "\n" + "Historia: É um jovem explorador, destemido, e com uma persistência acima do normal.\nEm um determinado dia estava estudando antigas ruínas de uma caverna misteriosa com seu amigo Blue.\nDe repente, ouviu um barulho estrondoso de algo se partindo e foi pego no meio de um desabamento que o separou de seu amigo.\nAo acordar desnorteado em um local desconhecido, decide procurar por seu amigo Blue para escaparem do local.\n";
    }

    @Override
    public void poderEspecial() {
        System.out.println("Red pode lancar o dado duas vezes.");
    }

    public void adicionarItem(Item item){
        this.item = item;
    }

    public String nomeItem() {
        return item.getNome();
    }

    public int jogaDado(){
        return random.nextInt(6) + 1;
    }

    public void usarItem(Personagens personagem){
        item.usar(personagem);
    }
    public int jogaDado(int x){
        return random.nextInt(6) + 1;
    }

    public void reduzVida(int dano){
        this.vida = vida - dano;
    }

    public void aumentaVida(int cura){
        this.vida = vida + cura;

        if(vida > 100)
            this.vida = 100;
    }
}
