import java.io.*;
import java.util.ArrayList;

public class LeTabelas {

	ArrayList<Tabela> listaTabs = new ArrayList<Tabela>();

	void leTabs () {
		File arquivo = new File ("tabelasSalvas.txt");
		FileInputStream fis = null;
		ObjectInputStream in = null;
		Tabela iTab = null;

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
				iTab = (Tabela) in.readObject();
			} catch (EOFException e) {
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
			listaTabs.add(iTab);
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
}