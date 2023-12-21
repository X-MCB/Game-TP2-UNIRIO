import java.util.Random;
import java.util.Scanner;

public class ObstaculoGigante extends Obstaculos{
    public ObstaculoGigante(String nome, int vida) {
        super(nome, vida);
    }

    Scanner teclado = new Scanner(System.in);
    public void interageComPersonagem(Personagens personagem) {
        System.out.println("Um Gigante aparece!!\n");
        System.out.println("Para escapar desse obstaculo voce deve derrotar o Gigante em uma batalha.\n");
        System.out.println("A batalha contra o Gigante se inicia!\n");
        Random random = new Random();

        while (personagem.vida > 0 && vida > 0) {
            int dado = personagem.jogaDado();
            String enter;
            System.out.println("APERTE 'ENTER' PARA LANCAR OS DADOS:");
            teclado.nextLine();
            int dadoGigante = random.nextInt(6) + 1;
            System.out.println("Personagem lançou o dado e tirou: " + dado);
            System.out.println("Gigante lançou o dado e tirou: " + dadoGigante);

            int danoPersonagem = dado * 10;
            int danoGigante = dadoGigante * 10;

            if (personagem instanceof Blue) {
                personagem.poderEspecial();
                Random blue = new Random();
                int poderBlue;
                poderBlue = blue.nextInt(2);
                if (poderBlue == 1) {
                    danoGigante /= 2;
                    personagem.reduzVida(danoGigante);
                    System.out.println("Blue sofreu dano reduzido pela metade!");
                } else if (poderBlue == 0) {
                    personagem.reduzVida(danoGigante);
                    System.out.println("Blue sofreu o dano todo!");
                }
            }
            if (personagem instanceof Red) {
                int resposta;
                System.out.println("Gostaria de Jogar o dado novamente?\n1-Sim\n2-Nao");
                resposta = teclado.nextInt();
                teclado.nextLine();
                personagem.reduzVida(danoGigante);
                if(resposta == 1){
                    System.out.println("APERTE 'ENTER' PARA LANCAR OS DADOS:");
                    enter = teclado.nextLine();
                    personagem.jogaDado();
                    dado = personagem.jogaDado();
                    System.out.println("Red lançou o dado novamente e tirou: " + dado);}
                danoPersonagem = dado * 10;
            }

            vida -= danoPersonagem;

            System.out.println("Voce causou " + danoPersonagem + " de dano no Gigante");
            System.out.println("Gigante causou " + danoGigante + " em voce\n");

            System.out.println("Vida: " + personagem.vida);
            System.out.println("Vida do Gigante: " + vida);
        }
 }
}
