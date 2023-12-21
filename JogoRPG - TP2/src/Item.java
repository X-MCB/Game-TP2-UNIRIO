public class Item {
    private String nome;
    private String efeito;

    private boolean usado;

    public Item(String nome, String efeito) {
        this.nome = nome;
        this.efeito = efeito;
        this.usado = usado;
    }

    public String getNome() {
        return nome;
    }

    public String getEfeito() {
        return efeito;
    }

    public boolean isUsado(){
        return usado;
    }


    public void usar(Personagens personagem) {
        switch (nome) {
            case "Poção Simples":
                personagem.aumentaVida(50);
                System.out.println("Poção simples utilizada! Ganhou 50 de vida!\nVida atual: " + personagem.vida);
                System.out.println("\n");
                break;
            case "Super Poção":
                double y = (100 - personagem.vida) * 0.75;
                int x = (int) y;
                personagem.aumentaVida(x);
                System.out.println("Poção 75 utilizada! Ganhou "+ x +" de vida!\n Vida atual: " + personagem.vida);
                System.out.println("\n");
                break;
            case "Mega Poção":
                personagem.aumentaVida(personagem.vida);
                System.out.println("Poção dupla utilizada! Vida multiplicada por 2!\nVida atual: " + personagem.vida);
                System.out.println("\n");
                break;
            default:
                System.out.println("Item desconhecido.");
                break;
        }
    }

}

