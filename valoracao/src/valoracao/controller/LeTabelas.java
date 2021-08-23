package valoracao.controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import valoracao.model.Tabela;

public class LeTabelas {

	// Atributos:
	public ArrayList<Tabela> listaTabs = new ArrayList<Tabela>();
	
	public LeTabelas() {
		File arquivo = new File("data/tabelasSalvas.bin");
		FileInputStream fis = null;
		ObjectInputStream in = null;
		Tabela atual = null;

		// Abrindo o arquivo:
		try {
			fis = new FileInputStream(arquivo);
			in = new ObjectInputStream(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Lendo o arquivo:
		while (true) {
			try {
				atual = (Tabela) in.readObject();
				if (atual == null) {
					break;
				}
				this.listaTabs.add(atual);
			} catch (EOFException e) {
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Fechando o arquivo:
		try {
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Retorna uma lista com as tabelas salvas
	public ArrayList<Tabela> getLista () {
		return this.listaTabs;
	}

	// Atribui a lista de tabelas
  public void setListaTabs(ArrayList<Tabela> listaTabs) {
    this.listaTabs = listaTabs;
  }
}