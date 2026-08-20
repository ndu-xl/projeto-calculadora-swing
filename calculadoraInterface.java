package projetoCalculadoraInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class calculadoraInterface {
	//variaveis estáticas para a interação com o botão
	static String txt1 = "";
	static String txt2 = "";
	static Double number1 = 0.0;
	static Double number2 = 0.0;
	static Double result = 0.0;
	static String resultado = "";
	static String operador = "";

	static void main(String args[]) {
		//atribuição de Objetos
		InterfaceCalculadora interfaceCalculadora = new InterfaceCalculadora();
		JFrame janela = new JFrame();
		JPanel visor = new JPanel();
		JLabel digitos = new JLabel("0");
		JPanel botoes = new JPanel();
		//array da criação dos botões for
		String[] numeros = {
				"7", "8", "9", "÷",
				"4", "5", "6", "×",
				"1", "2", "3", "-",
				"C", "0", "=", "+"
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
				JButton botaoClicavel = (JButton) e.getSource();
				String botaoValor = botaoClicavel.getText();
				//inserindo valores
				if (digitos.getText().equals("0")) {
					digitos.setText(botaoValor);
				} else {
					digitos.setText(digitos.getText() + botaoValor);
				}
				//apagando valores
				if (botaoValor.equals("C")) {
					digitos.setText("0");
				}

				//seleção de operadores
				else if (botaoValor.equals("+")) {
					txt1 = digitos.getText();
					txt1 = txt1.replaceAll("[+]", "");
					number1 = Double.parseDouble(txt1);
					operador = "+";
					digitos.setText("0");
				} else if (botaoValor.equals("-")) {
					txt1 = digitos.getText();
					txt1 = txt1.replaceAll("[-]", "");
					number1 = Double.parseDouble(txt1);
					operador = "-";
					digitos.setText("0");
				} else if (botaoValor.equals("×")) {
					txt1 = digitos.getText();
					txt1 = txt1.replaceAll("[×]", "");
					number1 = Double.parseDouble(txt1);
					operador = "*";
					digitos.setText("0");
				} else if (botaoValor.equals("÷")) {
					txt1 = digitos.getText();
					txt1 = txt1.replaceAll("[÷]", "");
					number1 = Double.parseDouble(txt1);
					operador = "/";
					digitos.setText("0");
				}

				//impressão de resultado
				else if (botaoValor.equals("=")) {
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
					resultado = String.format("%.2f", result).replace(",", ".");
					digitos.setText(resultado);
				}
			};
			botao.addActionListener(digitar);
		}
		interfaceCalculadora.interfaceCalculadora(botoes, janela, visor, digitos);
	}
}