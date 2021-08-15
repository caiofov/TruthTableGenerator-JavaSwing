package valoracao.controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class LeTabelas {

	ArrayList<Tabela> listaTabs = new ArrayList<Tabela>();

	LeTabelas () {
		File arquivo = new File("tabelasSalvas.bin");
		FileInputStream fis = null;
		ObjectInputStream in = null;

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
				this.listaTabs.add((Tabela) in.readObject());
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

	ArrayList<Tabela> getLista () {
		return this.listaTabs;
	}

  public void setListaTabs(ArrayList<Tabela> listaTabs) {
    this.listaTabs = listaTabs;
  }
        
}