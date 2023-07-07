package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Artigo;
import model.Dados;
import model.Persistencia;
import model.Pesquisador;
import model.Projeto;

public class InterfaceDeUsuario{
	
	private Pesquisador pesquisador;
	private Projeto projeto;
	private Artigo artigo;

	private Scanner entrada = new Scanner(System.in);

	Dados dados = new Dados();
	Persistencia persist = new Persistencia();
	
	String nome;
	int opcao;
	
		public void menuPrincipal() {
			
			if(persist.recuperaDados()!=null) {
				
				dados = persist.recuperaDados();
			}
			if(dados.getPesquisadores().size()==0) {
				dados.carregaDados();	
			}
			String nome;
			int opcao;

			System.out.println();
			System.out.println("0. Sair.");
			System.out.println("1. Cadastrar pesquisador.");
			System.out.println("2. Cadastrar projeto.");
			System.out.println("3. Cadastrar artigo.");
			System.out.println("4. Listar pesquisadores de uma universidade.");
			System.out.println("5. Listar autores de um artigo.");
			System.out.println("6. Listar projetos de um autor.");
			System.out.println("7. Listar projetos ja finalizados.");
			
			opcao = entrada.nextInt();

			while(opcao != 0) {
				switch(opcao) {
				case 1:
					entrada.nextLine();
					System.out.println("Nome do pesquisador: ");
					nome  = entrada.nextLine();

					System.out.println("Area de estudo do pesquisador: ");
					String area = entrada.nextLine();

					System.out.println("Universidade do pesquisador: ");
					String universidade = entrada.nextLine();
					
					pesquisador = new Pesquisador(nome, area, universidade);
					dados.addPesquisador(pesquisador);
					
					System.out.println("Cadastro feito com sucesso !!!");

					break;

				case 2:
                    entrada.nextLine();
                    System.out.println("Digite o Titulo do projeto:");
                    String titulo = entrada.nextLine();

                    System.out.println("Digite a descricao do projeto:");
                    String descricao = entrada.nextLine();

                    System.out.println("Digite a data de inicio:");
                    String dataini = entrada.nextLine();

                    System.out.println("Digite a data final:");
                    String datafim = entrada.nextLine();

                    projeto = new Projeto(titulo, descricao, dataini, datafim);

                    boolean verificar = true;
                    while(verificar){
                        System.out.println("Quem participou do Projeto: ");
                        nome = entrada.nextLine();
                        for(int j=0 ; j<dados.getPesquisadores().size() ; j++) {
                            if(nome.equalsIgnoreCase(dados.getPesq(j).getNome())) {
                                projeto.addPesquisador(dados.getPesq(j));
                                dados.getPesq(j).addProjeto(projeto);
                            }
                        }
                        System.out.println("Quer adicionar outro autor ?\nS-sim\nN-nao");
                        char SouN;
                        SouN = entrada.next().charAt(0);
                        if(SouN == 'n' || SouN == 'N'){
                            verificar = false;
                        }
                        entrada.nextLine();
                    }
                    verificar = true;
                    dados.addProjeto(projeto);
                    
                    System.out.println("Projeto cadastrado com sucesso !!!");
                    
                    break;
                    
				case 3:
                    entrada.nextLine();
                    System.out.println("Digite o Titulo do artigo:");
                    titulo = entrada.nextLine();

                    System.out.println("Digite o ano que o artigo foi feito:");
                    int ano = entrada.nextInt();

                    entrada.nextLine();
                    System.out.println("Digite o Titulo da revista:");
                    String tituloRevista = entrada.nextLine();

                    artigo = new Artigo(titulo, ano, tituloRevista);

                    verificar = true;
                    while(verificar){
                        System.out.println("Quem participou do Artigo: ");
                        nome = entrada.nextLine();
                        for(int j=0 ; j<dados.getPesquisadores().size(); j++) {
                            if(nome.equalsIgnoreCase(dados.getPesq(j).getNome())) {
                                artigo.addPesquisador(dados.getPesq(j));
                                dados.getPesq(j).addArtigo(artigo);
                                break;
                            }
                        }
                        System.out.println("Quer adicionar outro autor ?");
                        char SouN;
                        SouN = entrada.next().charAt(0);
                        if(SouN == 'n' || SouN == 'N'){
                            verificar = false;
                        }
                        entrada.nextLine();
                    }
                    verificar = true;
                    dados.addArtigo(artigo);
                    
                    System.out.println("Artigo cadastrado com sucesso !!!");

                    break;

				case 4:
                    entrada.nextLine();
                    System.out.println("Digite o nome da Universidade:");
                    nome = entrada.nextLine();
                    System.out.println();
                    System.out.println("Lista de pesquisadores da universidade "+nome+".");
                    for(int i=0 ; i<dados.getPesquisadores().size() ; i++) {
                        if(nome.equalsIgnoreCase(dados.getPesq(i).getUniversidade())) {
                        	System.out.println();
                            System.out.println("Nome: " + dados.getPesq(i).getNome());
                            System.out.println("Area: " + dados.getPesq(i).getArea());
                        }
                    }

                    break;

				case 5:
					entrada.nextLine();
					System.out.println("Digite o Titulo do artigo:");
					nome = entrada.nextLine();
					
					ArrayList<Pesquisador> p = null;

					System.out.println();
					System.out.println("Lista de autores do Artigo "+nome+".");
					
					for(int i=0 ; i<dados.getArtigos().size() ; i++) {
						if(nome.equalsIgnoreCase(dados.getArt(i).getTitulo())) {
							p = dados.getArt(i).mostrarAutores();
							break;
						}
					}
					for(int i=0 ; i<p.size() ; i++) {
						System.out.println("Nome: "+p.get(i).getNome()+".");
						System.out.println("Area: "+p.get(i).getArea()+".");
						System.out.println("Universidade: "+p.get(i).getUniversidade()+".");
						System.out.println();
					}

				break;

				case 6:
	                entrada.nextLine();
	                System.out.println("Qual o nome do autor que deseja ?");
	                nome = entrada.nextLine();
	                ArrayList<String> resp = null;

	                for(int i=0 ; i<dados.getPesquisadores().size() ; i++){
	                    if(nome.equalsIgnoreCase(dados.getPesq(i).getNome())){
	                        resp = dados.getPesq(i).ListarProjetos();
	                    }
	                }
	                System.out.println("Projetos de " + nome + ":");
	                for(String i : resp){
	                    System.out.println(i);
	                }
	            break;

				case 7:
					entrada.nextLine();
					for(int i=0 ; i<dados.getProjetos().size() ; i++) {
						if(dados.getProj(i).Data()) {
							ArrayList<Pesquisador> pe = dados.getProj(i).ListarPesquisadores();
							System.out.println("Projeto: " + dados.getProj(i).getTitulo() + ":");
							for(Pesquisador k:pe) {
								System.out.println("Nome: "+k.getNome()+".");
								System.out.println("Area: "+k.getArea()+".");
								System.out.println("Universidade: "+k.getUniversidade()+".");
								System.out.println();
							}
						}
					}
				
				break;


			}
			System.out.println("0. Sair.");
			System.out.println("1. Cadastrar pesquisador.");
			System.out.println("2. Cadastrar projeto.");
			System.out.println("3. Cadastrar artigo.");
			System.out.println("4. Listar pesquisadores de uma universidade.");
			System.out.println("5. Listar autores de um artigo.");
			System.out.println("6. Listar projetos de um autor.");
			System.out.println("7. Listar projetos ja finalizados.");
				
			opcao = entrada.nextInt();
		}
	
		persist.salvaDados(dados);
		System.out.println("Fim do programa."); 
			    
	}
		
}