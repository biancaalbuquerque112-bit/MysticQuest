
import java.util.Scanner;

public class MysticQuest {

    public static void main(String[] args) {

        System.out.println("Bem-vindo ao Mystic Quest!");

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o nome do aventureiro: ");
        String nome = entrada.nextLine();

        Jogador jogador1 = new Jogador();

        jogador1.nome = nome;
        jogador1.vida = 100;

        System.out.println("Aventura iniciada para: " + jogador1.nome);
        System.out.println("Vida do jogador: " + jogador1.vida);

        int vida = 100;
        int moedas = 0;
        int pocoes = 2;

        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Moedas: " + moedas);
        System.out.println("Poções disponíveis: " + pocoes);

        System.out.println("Você encontrou uma floresta misteriosa!");
        System.out.println("1 - Entrar na floresta");
        System.out.println("2 - Voltar para casa");

        int escolha = entrada.nextInt();

        if (escolha == 1) {

            System.out.println("Você entrou na floresta!");
            System.out.println("Um lobo selvagem apareceu!");

            int vidaLobo = 50;

            System.out.println("Vida do lobo: " + vidaLobo);
            System.out.println("O lobo atacou e causou 20 de dano!");

            jogador1.vida -= 20;
            vida = jogador1.vida;

            System.out.println("Vida restante: " + jogador1.vida);

            while (vidaLobo > 0 && vida > 0) {

                System.out.println("----------------------");
                System.out.println("O que deseja fazer?");
                System.out.println("Sua vida: " + vida);
                System.out.println("Vida do lobo: " + vidaLobo);
                System.out.println("Poções disponíveis: " + pocoes);
                System.out.println("----------------------");

                System.out.println("1 - Atacar o lobo");
                System.out.println("2 - Fugir");
                System.out.println("3 - Usar poção de cura");

                int acao = entrada.nextInt();

                if (acao == 1) {

                    System.out.println("Você atacou o lobo!");

                    vidaLobo -= 15;

                    if (vidaLobo <= 0) {

                        vidaLobo = 0;

                        System.out.println("Vida do lobo: " + vidaLobo);
                        System.out.println("Você derrotou o lobo!");

                        moedas += 30;

                        System.out.println("Você ganhou 30 moedas de ouro!");
                        System.out.println("Total de moedas: " + moedas);

                        break;
                    }

                    System.out.println("Vida restante do lobo: " + vidaLobo);
                    System.out.println("O lobo contra-atacou!");

                     jogador1.vida -= 15;
                     vida = jogador1.vida;

                    if (vida <= 0) {

                        vida = 0;

                        System.out.println("Sua vida chegou a zero!");
                        System.out.println("GAME OVER!");

                        break;
                    }

                    System.out.println("Vida atual: " + vida);

                } else if (acao == 2) {

                    System.out.println("Você conseguiu fugir!");
                    break;

                } else if (acao == 3) {

                    if (pocoes > 0) {

                        vida += 10;

                        if (vida > 100) {
                            vida = 100;
                        }

                        pocoes--;

                        System.out.println("Você bebeu uma poção de cura!");
                        System.out.println("Vida atual: " + vida);
                        System.out.println("Poções restantes: " + pocoes);

                    } else {

                        System.out.println("Você não possui mais poções!");
                    }

                } else {

                    System.out.println("Opção inválida!");
                }
            }

        } else if (escolha == 2) {

            System.out.println("Você decidiu voltar para casa!");

        } else {

            System.out.println("Opção inválida!");
        }

        System.out.println("Fim do jogo!");

        entrada.close();
    }
}
