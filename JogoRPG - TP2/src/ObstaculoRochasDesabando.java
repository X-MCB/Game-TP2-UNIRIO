import java.util.Random;
import java.util.Scanner;

public final class ObstaculoRochasDesabando extends Obstaculos {
    public ObstaculoRochasDesabando(String nome, int vida) {
        super(nome, vida);
    }

    Scanner teclado = new Scanner(System.in);

    @Override
    public void interageComPersonagem(Personagens personagem) {
        System.out.println("Rochas Desabando!");
        System.out.println("Para escapar desse obstaculo, você deve tirar 5 ou 6 no dado, a cada tentativa falha você perde 10 de vida.\n");
        Random random = new Random();



        boolean sucesso = false;

        while (!sucesso && personagem.vida > 0) {
            int dado = personagem.jogaDado();
            String enter;
            System.out.println("APERTE 'ENTER' PARA LANCAR OS DADOS:");
            teclado.nextLine();

            if (personagem instanceof Red) {
                int resposta;
                personagem.jogaDado();
                System.out.println("Red lançou o dado e tirou: " + dado);
                System.out.println(" ");
                System.out.println("Gostaria de Jogar o dado novamente?\n1-Sim\n2-Nao");
                resposta = teclado.nextInt();
                teclado.nextLine();
                if(resposta == 1){
                    System.out.println("APERTE 'ENTER' PARA LANCAR OS DADOS NOVAMENTE:");
                    enter = teclado.nextLine();
                personagem.jogaDado();
                dado = personagem.jogaDado();
                System.out.println("Red lançou o dado novamente e tirou: " + dado);}
            } else if (personagem instanceof Blue) {
                personagem.jogaDado();
                System.out.println("Blue lancou o dado e tirou: " + dado);
            }

            if (dado == 5 || dado == 6) {
                sucesso = true;
            } else {
                if (personagem instanceof Red) {
                    personagem.reduzVida(10);
                    System.out.println("Red sofreu dano das rochas!\nVida Restante: " + personagem.vida);
                }
                if (personagem instanceof Blue) {
                    Random blue = new Random();
                    int poderBlue;
                    poderBlue = blue.nextInt(2);
                    if (poderBlue == 1) {
                        personagem.reduzVida(5);
                        System.out.println("Blue sofreu reduzido pela metade dano!\nVida Restante: " + personagem.vida);
                    } else if(poderBlue == 0) {
                        personagem.reduzVida(10);
                        System.out.println("Blue sofreu o dano todo!\nVida restante: " + personagem.vida);
                    }
                }
            }
        }
   }
}
