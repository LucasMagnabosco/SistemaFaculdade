package model;

import java.io.Serializable;

import java.util.ArrayList;

public class Dados implements Serializable{

	private static final long serialVersionUID = 10L;
	
	private ArrayList<Pesquisador> pesquisadores = new ArrayList<>();
	private Pesquisador pesquisador;

	private ArrayList<Projeto> projetos = new ArrayList<>();
	private Projeto projeto;

	private ArrayList<Artigo> artigos = new ArrayList<>();
	private Artigo artigo;
	
	private ArrayList<Instituicao> instituicoes = new ArrayList<>();
	

	public void carregaDados() {

		pesquisador = new Pesquisador("Marcos", "psicologia", "ufrgs");
		pesquisadores.add(pesquisador);
		pesquisador = new Pesquisador("Maria", "Educacao fisica", "ucs");
		pesquisadores.add(pesquisador);
		pesquisador = new Pesquisador("João", "Medicina", "ufsm");
		pesquisadores.add(pesquisador);
		pesquisador = new Pesquisador("José", "Anatomia", "ufrgs");
		pesquisadores.add(pesquisador);
		pesquisador = new Pesquisador("Marta", "Psicanalise", "ufsm");
		pesquisadores.add(pesquisador);
		pesquisador = new Pesquisador("Jorge", "Matematica", "ufrgs");
		pesquisadores.add(pesquisador);
		pesquisador = new Pesquisador("Jader", "Computacao", "pucrs");
		pesquisadores.add(pesquisador);
		pesquisador = new Pesquisador("Matheus", "Engenharia", "unicamp");
		pesquisadores.add(pesquisador);
		pesquisador = new Pesquisador("Gabriel", "Sistemas embarcados", "usp");
		pesquisadores.add(pesquisador);
		pesquisador = new Pesquisador("Daniel", "Pedagogia", "usp");
		pesquisadores.add(pesquisador);

		projeto = new Projeto("Matematica aplicada",
				"o projeto tem por objetivo o uso prático de conhecimentos matemáticos", "20/09/2015", "20/10/2016");
		projetos.add(projeto);
		projeto = new Projeto("Aplicativo móvel para gerenciamento de tarefas",
				"Este projeto envolve o desenvolvimento de um aplicativo móvel que permitirá aos usuários gerenciar suas tarefas diárias de forma eficiente.",
				"19/03/2020", "25/12/2022");
		projetos.add(projeto);
		projeto = new Projeto("Desenho e implementação de um sistema de irrigação",
				" projeto tem como objetivo criar um sistema de irrigação inteligente", "11/03/2010", "23/05/2011");
		projetos.add(projeto);
		projeto = new Projeto("Desenvolvimento de um protótipo de robô de limpeza",
				"projeto envolve a criação de um protótipo de robô autônomo que possa navegar pela casa e realizar tarefas",
				"10/10/2020", "15/07/2023");
		projetos.add(projeto);
		projeto = new Projeto("Análise da eficácia de diferentes métodos de ensino",
				"Este projeto tem como objetivo avaliar a eficácia de diferentes métodos de ensino", "10/02/1990",
				"20/12/1990");
		projetos.add(projeto);

		artigo = new Artigo("Explorando a relação entre a microbiota intestinal e a depressão em humanos", 2020,
				"Science Magazine");
		artigos.add(artigo);
		artigo = new Artigo("Avaliando o impacto da tecnologia na comunicação interpessoal", 2015, "Science Magazine");
		artigos.add(artigo);
		artigo = new Artigo(
				"Estudo da eficácia de diferentes protocolos de treinamento de resistência na hipertrofia muscular",
				2010, "Science Magazine");
		artigos.add(artigo);
		artigo = new Artigo("Análise da qualidade do ar e sua relação com a saúde respiratória em uma cidade urbana",
				2010, "Science Magazine");
		artigos.add(artigo);
		artigo = new Artigo("Investigando os efeitos do estresse na tomada de decisões em situações de incerteza", 1995,
				"Science Magazine");
		artigos.add(artigo);

		artigos.get(0).addPesquisador(pesquisadores.get(3));
		artigos.get(1).addPesquisador(pesquisadores.get(0));
		artigos.get(2).addPesquisador(pesquisadores.get(1));
		artigos.get(3).addPesquisador(pesquisadores.get(2));
		artigos.get(4).addPesquisador(pesquisadores.get(4));

		projetos.get(0).addPesquisador(pesquisadores.get(5));
		projetos.get(1).addPesquisador(pesquisadores.get(6));
		projetos.get(2).addPesquisador(pesquisadores.get(7));
		projetos.get(3).addPesquisador(pesquisadores.get(8));
		projetos.get(4).addPesquisador(pesquisadores.get(9));

		pesquisadores.get(5).addProjeto(projetos.get(0));
		pesquisadores.get(6).addProjeto(projetos.get(1));
		pesquisadores.get(7).addProjeto(projetos.get(2));
		pesquisadores.get(8).addProjeto(projetos.get(3));
		pesquisadores.get(9).addProjeto(projetos.get(4));

	}

	public ArrayList<Pesquisador> getPesquisadores() {
		return pesquisadores;
	}

	public ArrayList<Projeto> getProjetos() {
		return projetos;
	}

	public ArrayList<Artigo> getArtigos() {
		return artigos;
	}

	public void addPesquisador(Pesquisador p) {
		pesquisadores.add(p);
	}
	public void addArtigo(Artigo a) {
		artigos.add(a);
	}
	public void addProjeto(Projeto p) {
		projetos.add(p);
	}
	
	public Pesquisador getPesq(int i) {
		return pesquisadores.get(i);
	}
	
	public Artigo getArt(int i) {
		return artigos.get(i);
	}
	public Projeto getProj(int i) {
		return projetos.get(i);
	}
	public Instituicao getInsti(int i) {
		return instituicoes.get(i);
	}

	public ArrayList<Instituicao> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(ArrayList<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}
	
	public void addInstituicoes(Instituicao i) {
		instituicoes.add(i);
	}
}
