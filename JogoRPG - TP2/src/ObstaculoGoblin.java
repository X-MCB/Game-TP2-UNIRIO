import java.util.Random;
import java.util.Scanner;

public class ObstaculoGoblin extends Obstaculos{

    public ObstaculoGoblin(String nome, int vida) {
        super(nome, vida);
    }

    Scanner teclado = new Scanner(System.in);

    @Override
    public void interageComPersonagem(Personagens personagem) {
        System.out.println("Um Goblin aparece!!!\n");
        System.out.println("Para escapar desse obstaculo, você deve derrotar o Goblin em uma batalha.\n");
        System.out.println("A batalha contra o Goblin se inicia!\n");
        Random random = new Random();


        while (personagem.vida > 0 && vida > 0) {
            int dado = personagem.jogaDado();
            String enter;
            System.out.println("APERTE 'ENTER' PARA LANCAR OS DADOS:");
            teclado.nextLine();
            int dadoGoblin = random.nextInt(6) + 1;
            System.out.println("Voce lançou o dado e tirou: " + dado);
            System.out.println("Goblin lançou o dado e tirou: " + dadoGoblin);

            int danoPersonagem = dado * 10;
            int danoGoblin = dadoGoblin * 10;

            if (personagem instanceof Blue) {
                Random blue = new Random();
                int poderBlue;
                poderBlue = blue.nextInt(2);
                if (poderBlue == 1) {
                    danoGoblin /= 2;
                    personagem.reduzVida(danoGoblin);
                    System.out.println("Blue sofreu dano reduzido pela metade!");
                } else if (poderBlue == 0) {
                    personagem.reduzVida(danoGoblin);
                }
            }
            if (personagem instanceof Red) {
                int resposta;
                System.out.println("\n");
                personagem.reduzVida(danoGoblin);
                personagem.poderEspecial();
                System.out.println("Gostaria de Jogar o dado novamente?\n1-Sim\n2-Nao");
                resposta = teclado.nextInt();
                teclado.nextLine();
                if(resposta == 1){
                    System.out.println("APERTE 'ENTER' PARA LANCAR OS DADOS:");
                    enter = teclado.nextLine();
                    personagem.jogaDado();
                    dado = personagem.jogaDado();
                    System.out.println("Red lançou o dado novamente e tirou: " + dado);}
                danoPersonagem = dado * 10;
            }

            vida -= danoPersonagem;

            System.out.println("Voce causou " + danoPersonagem + " de dano no Goblin!");
            System.out.println("Goblin causou " + danoGoblin + " em voce!\n");

            System.out.println("Vida Restante: " + personagem.vida);
            System.out.println("Vida do Goblin: " + vida);
            System.out.println("\n");
        }

}}
