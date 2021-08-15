package valoracao.controller;
import valoracao.model.*;
import valoracao.view.*;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import valoracao.model.Tabela;


public class LeTabelas {

	public ArrayList<Tabela> listaTabs = new ArrayList<Tabela>();

	public LeTabelas () {
		File arquivo = new File("./tabelasSalvas.bin");
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

	public ArrayList<Tabela> getLista () {
		return this.listaTabs;
	}

  public void setListaTabs(ArrayList<Tabela> listaTabs) {
    this.listaTabs = listaTabs;
  }
        
}