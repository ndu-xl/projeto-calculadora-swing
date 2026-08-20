package projetoCalculadoraInterface;

import javax.swing.*;
import java.awt.*;

public class InterfaceCalculadora {
    public void interfaceCalculadora(JPanel botoes, JFrame janela, JPanel visor, JLabel digitos) {
        //personalização do Layout
        botoes.setLayout(new GridLayout(4, 4));
        janela.setLayout(new BorderLayout());
        visor.setLayout(new GridLayout());

        //personalização dos botões
        janela.setTitle("Calculadora");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(330, 540);
        janela.getContentPane().setBackground(Color.decode("#cfcfcf"));
        janela.setLocationRelativeTo(null);
        digitos.setFont(new Font("0", 1 , 50));
        visor.setPreferredSize(new Dimension(350,170));
        visor.setBackground(Color.decode("#FFFFFF"));
        visor.setBorder(BorderFactory.createLineBorder(Color.decode("#cfcfcf"), 5));

        //adição dos botões a janela
        visor.add(digitos);
        janela.add(botoes, BorderLayout.CENTER);
        janela.add(visor, BorderLayout.NORTH);
        janela.setVisible(true);
    }
}
