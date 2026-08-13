package projetoCalculadoraInterface.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class calculadoraInterface {
	//variaveis estáticas para a interação com o botão
	static String txt1 = "";
	static String txt2 = "";
	static Double number1 = 0.0;
	static Double number2 = 0.0;
	static Double result = 0.0;
	static String resultado = "";
	static String resultadoFinal = "";
	static String operador = "";
	public static void main (String args[]) {
	//atribuição das classes
	DecimalFormat formatador = new DecimalFormat("#.##");
	JFrame janela = new JFrame();
	JPanel visor = new JPanel();
	JLabel digitos = new JLabel("0");
	JPanel botoes = new JPanel();
	//array da criação dos botões for
	String[] numeros = {
		"7","8","9","÷",
		"4","5","6","×",
		"1","2","3","-",
		"C","0","=","+"
		};
	for (String texto : numeros) {
		JButton botao = new JButton(texto);
		//personalização da interface dos botões
		botao.setBorder(BorderFactory.createLineBorder(Color.decode("#cfcfcf"), 3));
		botao.setBackground(Color.decode("#a6a6a6"));
		botoes.add(botao);
		botao.setFont(new Font(texto, 1, 50));
		botao.setForeground(Color.decode("#ffffff"));
		ActionListener digitar = e -> {
			JButton botao2 = (JButton) e.getSource();
			//inserindo valores
			if (digitos.getText().equals("0")) {
				digitos.setText(botao2.getText());
			} else {
			digitos.setText(digitos.getText() + botao2.getText());
			}
			//apagando valores
			if (botao2.getText().equals("C")) {
				digitos.setText("0");
			}

			//seleção de operadores
			else if (botao2.getText().equals("+")) {
				txt1 = digitos.getText();
				txt1 = txt1.replaceAll("[+]", "");
				number1 = Double.parseDouble(txt1);
				operador = "+";
				digitos.setText("0");
			} else if (botao2.getText().equals("-")) {
				txt1 = digitos.getText();
				txt1 = txt1.replaceAll("[-]", "");
				number1 = Double.parseDouble(txt1);
				operador = "-";
				digitos.setText("0");
			} else if (botao2.getText().equals("×")) {
				txt1 = digitos.getText();
				txt1 = txt1.replaceAll("[×]", "");
				number1 = Double.parseDouble(txt1);
				operador = "*";
				digitos.setText("0");
			} else if (botao2.getText().equals("÷")) {
				txt1 = digitos.getText();
				txt1 = txt1.replaceAll("[÷]", "");
				number1 = Double.parseDouble(txt1);
				operador = "/";
				digitos.setText("0");
			} 
			
			//impressão de resultado
			else if (botao2.getText().equals("=")) {
				txt2 = digitos.getText();
				txt2 = txt2.replaceAll("[=]", "");
				number2 = Double.parseDouble(txt2);
				switch (operador) {
					case "+":
						result = number1 + number2;
						break;
					case "-":
						result = number1 - number2;
						break;
					case "*":
						result = number1 * number2;
						break;
					case "/":
						result = number1 / number2;
						break;
					default:
						break;
				}
				resultado = String.format("%.2f", result);
				digitos.setText(resultado);
		}
		};
		botao.addActionListener(digitar);
	}

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