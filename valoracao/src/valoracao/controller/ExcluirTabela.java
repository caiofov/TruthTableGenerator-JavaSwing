package valoracao.controller;
import valoracao.model.Tabela;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

public class ExcluirTabela {

	// Atributos:
	public ArrayList<Tabela> listaTabs;
	public int index;

	// Construtor:
	public ExcluirTabela (ArrayList<Tabela> lista, int i) {
		this.listaTabs = lista;
		this.index = i;
	}

	// Método que faz a exclusão da tabela do arquivo:
	public void excluirTab () {

		listaTabs.remove(index);

		// Abrindo o arquivo:
		File arquivo = new File ("valoracao/data/tabelasSalvas.bin");
		FileOutputStream fos = null;
		ObjectOutputStream out = null;

		try {
			fos = new FileOutputStream(arquivo);
			out = new ObjectOutputStream(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (out == null) {
			System.out.println("Path para o arquivo tabelasSalvas está incorreto!");
			return;
		}

		// Escrevendo no arquivo:
		ListIterator<Tabela> iter = listaTabs.listIterator();
		while (iter.hasNext()) {
			try {
				out.writeObject(iter.next());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Fechando o arquivo:
		try {
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}