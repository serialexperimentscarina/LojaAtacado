package model;

public class Cliente {

	public String nome;
	public int quantPecas;
	public float valorPecas;
	
	@Override
	public String toString() {
		return ("[Nome: " + nome + ", Quantidade de peças: " + quantPecas + ", Valor das peças: R$" + String.format("%,.2f", valorPecas) + "]");
	}
	
}
