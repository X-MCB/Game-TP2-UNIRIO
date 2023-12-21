public interface Personagem {
    public abstract String contarHistoria();
    public abstract void poderEspecial();
    public abstract void adicionarItem(Item item);
    public abstract String nomeItem();
    public abstract int jogaDado();
    public abstract void usarItem(Personagens personagem);
    public abstract void reduzVida(int dano);
    public abstract void aumentaVida(int cura);
}


       