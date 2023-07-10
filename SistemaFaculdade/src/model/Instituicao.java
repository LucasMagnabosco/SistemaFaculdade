package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Instituicao implements Serializable{

	
	private static final long serialVersionUID = 1233L;
	private String nome;
	private String cnpj;
	
	private ArrayList<Financiamento> fs = new ArrayList<>();

	public Instituicao(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public ArrayList<Financiamento> getF() {
		return fs;
	}
	public void setF(ArrayList<Financiamento> f) {
		this.fs = f;
	}
	public void addFinanciamento(Financiamento f) {
		fs.add(f);
	}
	
	
}
