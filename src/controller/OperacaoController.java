package controller;

import br.com.serialexperimentscarina.filaobject.FilaObject;
import model.Cliente;

public class OperacaoController {
	
	public void caixa(FilaObject fila) throws Exception {
		while (!fila.isEmpty()) {
			Cliente cliente = (Cliente) fila.remove();
			float valorCompra = cliente.quantPecas * cliente.valorPecas;
			
			System.out.println("Cliente: " + cliente.nome + ", total: R$" + String.format("%,.2f", valorCompra));
		}
	}

}
