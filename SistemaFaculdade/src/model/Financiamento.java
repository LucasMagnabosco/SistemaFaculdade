package model;

import java.io.Serializable;

public class Financiamento implements Serializable{


	private static final long serialVersionUID = 568L;
	
	double valor;
	String descricao;
	
	public Financiamento(String descricao, double valor) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
