package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Pesquisador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String nome;
	private String area;
	private String universidade;

	private ArrayList<Projeto> projetos = new ArrayList<>();

	private ArrayList<Artigo> artigos = new ArrayList<>();
	
	private ArrayList<Financiamento> financiamentos = new ArrayList<>();

	public String getUniversidade() {
		return universidade;
	}

	public void setUniversidade(String universidade) {
		this.universidade = universidade;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void addProjeto(Projeto projeto) {
		projetos.add(projeto);
	}

	public void addArtigo(Artigo artigo) {
		artigos.add(artigo);
	}
	public void addFinanciamneto(Financiamento f) {
		financiamentos.add(f);
	}

	public Pesquisador(String nome, String area, String universidade) {
		this.nome = nome;
		this.area = area;
		this.universidade = universidade;
	}
	
	public ArrayList<String> ListarProjetos() {
		ArrayList<String> retorno = new ArrayList<>();
		
		for(int i=0 ; i<projetos.size() ; i++) {
			retorno.add(projetos.get(i).getTitulo());
		}
		return retorno;
	}
}
