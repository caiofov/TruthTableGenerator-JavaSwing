import java.io.*;
import java.awt.*;

public class SalvarTabela {

	void salvarTabela () {
		// Criando o arquivo:
		File arquivo = new File ("tabelasSalvas.txt");
		FileOutputStream fos = null;
		DataOutputStream out = null;

		try {
			fos = new FileOutputStream(arquivo);
			out = new DataOutputStream(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Escrevendo no arquivo:
		try {
			//out.writeDouble(random); //comentei so pq tava dando erro - caio
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Fechando o arquivo:
		try {
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}