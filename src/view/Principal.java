package view;

import javax.swing.JOptionPane;

import br.com.serialexperimentscarina.filaobject.FilaObject;
import controller.OperacaoController;
import model.Cliente;

public class Principal {

	public static void main(String[] args) {
		OperacaoController operacao = new OperacaoController();
		FilaObject fila = new FilaObject();
		String input;
		
		for (int i = 1; i <= 20; i++) {
			Cliente cliente = new Cliente();
			input = JOptionPane.showInputDialog("Digite o nome do cliente #" + i + ":", "");
			if (input == null) {
				JOptionPane.showMessageDialog(null, "Encerrando.");
				break;
			} 
			cliente.nome = input;
			do {
				input = JOptionPane.showInputDialog("Digite a quantidade de peças do cliente #" + i + ":", "");
				if (input == null) {
					JOptionPane.showMessageDialog(null, "Encerrando.");
					System.exit(0);
				} else {
					try {
						cliente.quantPecas = Integer.parseInt(input);
					} catch (NumberFormatException e) {
						cliente.quantPecas = 0;
					}
					if (cliente.quantPecas < 20 || cliente.quantPecas > 50) {
						JOptionPane.showMessageDialog(null, "Quantidade inválida, tente novamente");
					}
				}
			} while (cliente.quantPecas < 20 || cliente.quantPecas > 50);
			do {
				input = JOptionPane.showInputDialog("Digite o valor das peças do cliente #" + i + ":", "");
				if (input == null) {
					JOptionPane.showMessageDialog(null, "Encerrando.");
					System.exit(0);
				} else {
					try {
						cliente.valorPecas = Float.parseFloat(input);
						} catch (NumberFormatException e) {
							cliente.valorPecas = 0;
						}
						if (cliente.valorPecas < 500 || cliente.valorPecas > 100000) {
							JOptionPane.showMessageDialog(null, "Valor inválido, tente novamente");
						}
				}
			} while (cliente.valorPecas < 500 || cliente.valorPecas > 100000);
			fila.insert(cliente);
		}
		
		try {
			operacao.caixa(fila);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
