package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistencia {

	public void salvaDados(Dados data) {
		ObjectOutputStream escreve;
		try {
			escreve = new ObjectOutputStream(new FileOutputStream("dados.obj"));
			escreve.writeObject(data);
			escreve.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Dados recuperaDados() {
		try {
			ObjectInputStream leitor = new ObjectInputStream(new FileInputStream("dados.obj"));
			Dados data = (Dados) leitor.readObject();
			leitor.close();
			return data;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
