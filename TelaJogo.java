
import java.awt.*;
import javax.swing.*;

public class TelaJogo {

    static class PainelFloresta extends JPanel {

    private Image fundo;

    public PainelFloresta() {
        fundo = new ImageIcon("imagens/floresta_sombria.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(fundo, 0, 0, getWidth(), getHeight(), this);
    }
}

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // ====================================
            // JANELA PRINCIPAL
            // ====================================

            JFrame janela = new JFrame("Mystic Quest - RPG Medieval");

            janela.setSize(900, 600);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setLocationRelativeTo(null);

            // CORES DO JOGO
            Color fundoEscuro = new Color(25, 30, 25);
            Color fundoFloresta = new Color(20, 45, 30);
            Color dourado = new Color(212, 175, 55);

            // ====================================
            // TELA INICIAL
            // ====================================

            JPanel painelInicial = new JPanel(
                new GridLayout(2, 1, 0, 30)
            );

            painelInicial.setBackground(fundoEscuro);

            JLabel titulo = new JLabel(
                "MYSTIC QUEST",
                SwingConstants.CENTER
            );

            titulo.setForeground(dourado);
            titulo.setFont(new Font("Serif", Font.BOLD, 48));

            JButton botaoIniciar = new JButton(
                "INICIAR AVENTURA"
            );

            botaoIniciar.setBackground(new Color(139, 105, 20));
            botaoIniciar.setForeground(Color.WHITE);
            botaoIniciar.setFont(
                new Font("Serif", Font.BOLD, 22)
            );

            botaoIniciar.setPreferredSize(
                new Dimension(280, 60)
            );

            JPanel painelBotao = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 0, 40)
            );

            painelBotao.setBackground(fundoEscuro);
            painelBotao.add(botaoIniciar);

            painelInicial.add(titulo);
            painelInicial.add(painelBotao);

            janela.setContentPane(painelInicial);

            // ====================================
            // BOTAO INICIAR AVENTURA
            // ====================================

            botaoIniciar.addActionListener(eventoIniciar -> {

                // VIDA E MOEDAS
                final int[] vidaLobo = {50};
                final int[] vidaJogador = {80};
                final int[] moedas = {0};

                // ====================================
                // PAINEL DA FLORESTA
                // ====================================

                JPanel painelFloresta = new JPanel(
                    new GridLayout(5, 1, 0, 5)
                );

                painelFloresta.setBackground(fundoFloresta);

                // TITULO DA FLORESTA
                JLabel tituloFloresta = new JLabel(
                    "Você entrou na Floresta Misteriosa!",
                    SwingConstants.CENTER
                );

                tituloFloresta.setForeground(dourado);
                tituloFloresta.setFont(
                    new Font("Serif", Font.BOLD, 30)
                );

                painelFloresta.add(tituloFloresta);

                // ====================================
                // PERSONAGENS
                // ====================================

                JPanel painelPersonagens = new JPanel(
                    new FlowLayout(FlowLayout.CENTER, 80, 0)
                );

                painelPersonagens.setBackground(fundoFloresta);

                // AVENTUREIRA
                ImageIcon imagemAventureira = new ImageIcon(
                    "imagens/aventureira.png"
                );

                Image aventureiraRedimensionada =
                    imagemAventureira.getImage().getScaledInstance(
                        150, 150, Image.SCALE_SMOOTH
                    );

                JLabel personagemAventureira = new JLabel(
                    new ImageIcon(aventureiraRedimensionada)
                );

                // LOBO SELVAGEM
                ImageIcon imagemLobo = new ImageIcon(
                    "imagens/lobo.png"
                );

                Image loboRedimensionado =
                    imagemLobo.getImage().getScaledInstance(
                        110, 110, Image.SCALE_SMOOTH
                    );

                JLabel personagemLobo = new JLabel(
                    new ImageIcon(loboRedimensionado)
                );

                painelPersonagens.add(personagemAventureira);
                painelPersonagens.add(personagemLobo);

                painelFloresta.add(painelPersonagens);

                // ====================================
                // BARRA DE VIDA DO LOBO
                // ====================================

                JProgressBar barraVidaLobo =
                    new JProgressBar(0, 50);

                barraVidaLobo.setValue(vidaLobo[0]);
                barraVidaLobo.setStringPainted(true);
                barraVidaLobo.setString("Vida do lobo: 50/50");

                barraVidaLobo.setForeground(
                    new Color(170, 40, 40)
                );

                barraVidaLobo.setPreferredSize(
                    new Dimension(350, 30)
                );

                JPanel painelVidaLobo = new JPanel(
                    new FlowLayout(FlowLayout.CENTER, 0, 40)
                );

                painelVidaLobo.setBackground(fundoFloresta);
                painelVidaLobo.add(barraVidaLobo);

                painelFloresta.add(painelVidaLobo);

                // ====================================
                // BARRA DE VIDA DO JOGADOR
                // ====================================

                JProgressBar barraVidaJogador =
                    new JProgressBar(0, 100);

                barraVidaJogador.setValue(vidaJogador[0]);
                barraVidaJogador.setStringPainted(true);
                barraVidaJogador.setString("Sua vida: 80/100");

                barraVidaJogador.setForeground(
                    new Color(40, 150, 70)
                );

                barraVidaJogador.setPreferredSize(
                    new Dimension(350, 30)
                );

                JPanel painelVidaJogador = new JPanel(
                    new FlowLayout(FlowLayout.CENTER, 0, 40)
                );

                painelVidaJogador.setBackground(fundoFloresta);
                painelVidaJogador.add(barraVidaJogador);

                painelFloresta.add(painelVidaJogador);

                // ====================================
                // BOTAO ATACAR
                // ====================================

                JButton botaoAtacar = new JButton("⚔ ATACAR");

                botaoAtacar.setBackground(
                    new Color(139, 40, 40)
                );

                botaoAtacar.setForeground(Color.WHITE);
                botaoAtacar.setFont(
                    new Font("Serif", Font.BOLD, 22)
                );

                botaoAtacar.setPreferredSize(
                    new Dimension(220, 55)
                );

                JPanel painelCombate = new JPanel(
                    new FlowLayout(FlowLayout.CENTER, 0, 20)
                );

                painelCombate.setBackground(fundoFloresta);

                // ====================================
                // ACAO DO BOTAO ATACAR
                // ====================================

                botaoAtacar.addActionListener(eventoAtaque -> {

                    // O LOBO PERDE 15 DE VIDA
                    vidaLobo[0] -= 15;

                    // IMPEDE VIDA NEGATIVA
                    if (vidaLobo[0] < 0) {
                        vidaLobo[0] = 0;
                    }

                    // ATUALIZA A BARRA DO LOBO
                    barraVidaLobo.setValue(vidaLobo[0]);

                    barraVidaLobo.setString(
                        "Vida do lobo: " + vidaLobo[0] + "/50"
                    );

                    // ====================================
                    // VITORIA CONTRA O LOBO
                    // ====================================

                    if (vidaLobo[0] == 0) {

                        moedas[0] += 30;

                        JOptionPane.showMessageDialog(
                            janela,
                            "🏆 Você derrotou o lobo!\n"
                            + "Ganhou 30 moedas de ouro!\n"
                            + "Total de moedas: " + moedas[0],
                            "VITÓRIA!",
                            JOptionPane.INFORMATION_MESSAGE
                        );

                        botaoAtacar.setEnabled(false);
                    }

                });

                painelCombate.add(botaoAtacar);
                painelFloresta.add(painelCombate);

                // ====================================
                // MOSTRANDO A FLORESTA
                // ====================================

                janela.setContentPane(painelFloresta);

                janela.revalidate();
                janela.repaint();

            });

            // EXIBINDO A JANELA
            janela.setVisible(true);

        });
    }
}
