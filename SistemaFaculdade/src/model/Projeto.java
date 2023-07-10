package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Projeto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 15L;
	private String titulo;
	private String descricao;
	private String dataInicio;
	private String dataFinal;
	
	private ArrayList<Pesquisador> pesquisadores = new ArrayList<>();
	private ArrayList<Financiamento> financiamentos = new ArrayList<>();

	public Projeto(String titulo, String descricao, String dataini, String datafim) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataInicio = dataini;
		this.dataFinal = datafim;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public void addPesquisador(Pesquisador pesquisador) {
		pesquisadores.add(pesquisador); 
	}
	
	public ArrayList<Pesquisador> ListarPesquisadores() {
		return pesquisadores;
	}
	public void addFinanci(Financiamento f) {
		financiamentos.add(f);
	}
	public ArrayList<Financiamento> getFinanciamento(){
		return financiamentos;
	}
	
	public boolean Data() {
		Calendar calendario = Calendar.getInstance(); // design pattern
		int diaF = calendario.get(Calendar.DATE);
		int mesF = calendario.get(Calendar.MONTH) + 1;
		int anoF = calendario.get(Calendar.YEAR);
		
		String[] aux = dataFinal.split("/");
        int D = Integer.parseInt(aux[0]);
        int M = Integer.parseInt(aux[1]);
        int A = Integer.parseInt(aux[2]);
        
        if((anoF < A )|| (anoF == A && mesF < M )|| (anoF == A && mesF == M && diaF < D)) {
        	return false;
        }
        return true;
	}
}
