import java.util.ArrayList;
import java.util.List;

public abstract class Personagens implements Personagem{
        protected String nome;
        protected int idade;
        protected int vida;


        public Personagens(String nome, int idade, int vida) {
            this.nome = nome;
            this.idade = idade;
            this.vida = vida;
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }

        public int getVida() {
            return vida;
        }

        public void setVida(int vida) {
            this.vida = vida;
        }

        public abstract String contarHistoria();
        public abstract void poderEspecial();
        public abstract void adicionarItem(Item item);
        public abstract String nomeItem();
        public abstract int jogaDado();
        public abstract void usarItem(Personagens personagem);
        public abstract void reduzVida(int dano);
        public abstract void aumentaVida(int cura);
}
