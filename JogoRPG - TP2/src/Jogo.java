import java.util.Scanner;
import java.util.*;

public class Jogo {
    public static void main(String[] args) {
       Scanner teclado = new Scanner(System.in);

      try {
          Personagens red = new Red("Red", 17, 100);
          Personagens blue = new Blue("Blue", 19, 100);

          System.out.println("PERSONAGENS:\n");
          System.out.println(red.contarHistoria());
          System.out.println(blue.contarHistoria());

          System.out.println("Escolha um dos personagens: ");
          System.out.println("1. " + red.getNome());
          System.out.println("2. " + blue.getNome());

          System.out.print("Sua escolha: ");
          int escolha = teclado.nextInt();
          Personagens personagemPrincipal;

          if (escolha == 1) {
              personagemPrincipal = red;
          } else if (escolha == 2) {
              personagemPrincipal = blue;
          } else {
              throw new EscolhaInvalidaException("Digite um número valido (1 ou 2) para selecionar o personagem");
          }
          System.out.println("\nPersonagem: " + personagemPrincipal.getNome() + "!");
          System.out.println("Característica: Vida");
          System.out.print("Poder Especial: ");
          personagemPrincipal.poderEspecial();

          System.out.println("\nINFORMACOES: ");


          System.out.println("\nLocal: Ruínas Desconhecidas");
          System.out.println("Objetivo: Escapar das ruínas e encontrar o seu amigo.");
          System.out.println("Contexto: Após o acidente sofrido, " + personagemPrincipal.getNome() + " tem que encontrar seu amigo "
                  + (personagemPrincipal == red ? blue.getNome() : red.getNome()) + " para escaparem juntos.");


          System.out.println("\nEscolha um dos itens achados nas ruínas para adicionar ao seu inventário: ");
          System.out.println("1. Poção simples: Recupera 50 de vida");
          System.out.println("2. Super Poção: Recupera 75% da vida perdida");
          System.out.println("3. Mega Poção: Duplica a vida atual");

          escolha = teclado.nextInt();
          Item itemEscolhido = null;

          switch (escolha) {
              case 1:
                  itemEscolhido = new Item("Poção Simples", "Recupera 50 de vida");
                  break;
              case 2:
                  itemEscolhido = new Item("Super Poção", "Recupera 75% da vida perdida");
                  personagemPrincipal.vida /= 2;
                  break;
              case 3:
                  itemEscolhido = new Item("Mega Poção", "Duplica a vida atual");
                  break;
              default:
                  throw new EscolhaInvalidaException("Digite um número válido (1, 2 ou 3) para selecionar o item.");
          }

          personagemPrincipal.adicionarItem(itemEscolhido);
          ObstaculoRochasDesabando obstaculo1 = new ObstaculoRochasDesabando("Rochas Desabando", 0);
          ObstaculoGoblin obstaculo2 = new ObstaculoGoblin("Goblin", 100);
          ObstaculoGigante obstaculo3 = new ObstaculoGigante("Gigante", 200);

          System.out.println("\nInventário de " + personagemPrincipal.getNome() + ": " + itemEscolhido.getNome());
          System.out.println("\n" + personagemPrincipal.getNome() + " Comecará a sua jornada para escapar das ruínas");
          System.out.println("Ao comecar sua fuga " + personagemPrincipal.getNome() + " encontra um obstáculo\n");

          obstaculo1.interageComPersonagem(personagemPrincipal);
          if (personagemPrincipal.getVida() > 0) {
              System.out.println("Parabéns!!!\nVoce conseguiu desviar de todas as rochas que estavam desabando e avanca em sua fuga!!!");
              System.out.println("\nApós escapar das rochas " + personagemPrincipal.getNome() + " continua a sua jornada " + "\nMais adiante no caminho " + personagemPrincipal.getNome() + " encontra outro obstáculo\n");
          } else {
              System.out.println("Sua vida foi reduzida a zero e você morreu, seu amigo conseguiu vencer as rochas e te alcançar.\nMas enquanto tentava te soltar dos escombros foi pego em outro deslizamento de rochas \n e também morreu.");
              System.out.println("FIM DE JOGO");
              return;
          }
          boolean usouitem = false;
          int x;
          do{
              System.out.println("\nDeseja utilizar seu item " + personagemPrincipal.nomeItem() + "? \n 1. Sim \n 2. Não");
              x = teclado.nextInt();
              teclado.nextLine();
              if(x == 1){
                  personagemPrincipal.usarItem(personagemPrincipal);
                  usouitem = true;
              }else if(x != 1 && x != 2)
                  throw new EscolhaInvalidaException("Digite um número valido (1 ou 2) para selecionar o item");
          }while(x != 1 && x != 2);

          obstaculo2.interageComPersonagem(personagemPrincipal);
          if (personagemPrincipal.getVida() > 0) {
              System.out.println("Parabéns!!!\nVoce venceu o Goblin e avanca na sua fuga!\n");
              System.out.println("Após derrotar o Goblin nosso herói caminhas para o final das ruínas\nQuando estava prestes a sair, um último inimigo surge");
          } else {
              System.out.println("Sua vida foi reduzida a zero e você morreu.\nSeu amigo conseguiu escapar das rochas e te alcançar.\nMas foi encurralado pelo Goblin e também pereceu.");
              System.out.println("FIM DE JOGO");
              return;
          }

          if(!usouitem){
              do{
                  System.out.println("Deseja utilizar seu item " + personagemPrincipal.nomeItem() + "? \n 1. Sim \n 2. Não");
                  x = teclado.nextInt();
                  teclado.nextLine();
                  if(x == 1){
                      personagemPrincipal.usarItem(personagemPrincipal);
                      usouitem = true;
                  }else if(x != 1 && x != 2)
                      throw new EscolhaInvalidaException("Digite um número valido (1 ou 2) para selecionar o item");
              }while(x != 1 && x != 2);
          }
          System.out.println("\n");
          obstaculo3.interageComPersonagem(personagemPrincipal);
          if (personagemPrincipal.getVida() > 0) {
              System.out.println("PARABÉNS" + personagemPrincipal.getNome() + "você conseguiu vencer todos obstáculos e se encontrou com seu amigo.\n Juntos conseguiram escapar das ruínas, da caverna, e estão livres!\n");
          } else {
              System.out.println("Sua vida foi reduzida a zero e você morreu, seu amigo conseguiu vencer os obstáculos e te alcançar.\nMas foi encurralado pelo Gigante e também pereceu.");
              System.out.println("FIM DE JOGO");
          }
      }catch (EscolhaInvalidaException e) {
          System.out.println("Erro: " + e.getMessage());
      } catch (Exception e) {
          System.out.println("Ocorreu um erro durante a execucao do jogo: " + e.getMessage());
          e.printStackTrace();
      }
    }
}