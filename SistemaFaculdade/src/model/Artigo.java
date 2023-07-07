package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Artigo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String titulo;

	private int ano;

	private String tituloRevista;

	private ArrayList<Pesquisador> pesquisadores = new ArrayList<>();

	public Artigo(String titulo, int ano, String tituloRevista) {

		this.titulo = titulo;

		this.ano = ano;

		this.tituloRevista = tituloRevista;

	}

	public String getTitulo() {

		return titulo;

	}

	public void setTitulo(String titulo) {

		this.titulo = titulo;

	}

	public int getAno() {

		return ano;

	}

	public void setAno(int ano) {

		this.ano = ano;

	}

	public String getTituloRevista() {

		return tituloRevista;

	}

	public void setTituloRevista(String tituloRevista) {

		this.tituloRevista = tituloRevista;

	}

	public void addPesquisador(Pesquisador pesquisador) {
		pesquisadores.add(pesquisador);
	}

	public ArrayList<Pesquisador> mostrarAutores() {
		return pesquisadores;
	}

}


