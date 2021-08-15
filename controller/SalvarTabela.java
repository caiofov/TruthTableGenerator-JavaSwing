package valoracao.controller;
import valoracao.model.*;
import valoracao.view.*;


import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import valoracao.model.Tabela;


public class SalvarTabela {

	public Tabela tab;

	public SalvarTabela (Tabela tab) {
		this.tab = tab;
	}

	public void salvarTab () {
		// Criando/abrindo o arquivo:
		File arquivo = new File ("./tabelasSalvas.bin");
		boolean append = arquivo.exists();
		FileOutputStream fos = null;
		AppendableObjectOutputStream out = null;

		try {
			fos = new FileOutputStream(arquivo, append);
			out = new AppendableObjectOutputStream(fos, append);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Escrevendo no arquivo:
		try {
			out.writeObject(tab);
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

class AppendableObjectOutputStream extends ObjectOutputStream {

	private boolean append;
	private boolean initialized;
	private DataOutputStream dout;

	protected AppendableObjectOutputStream(boolean append) throws IOException, SecurityException {
		super();
		this.append = append;
		this.initialized = true;
	}

	public AppendableObjectOutputStream(OutputStream out, boolean append) throws IOException {
		super(out);
		this.append = append;
		this.initialized = true;
		this.dout = new DataOutputStream(out);
		this.writeStreamHeader();
	}

	@Override
	protected void writeStreamHeader() throws IOException {
		if (!this.initialized || this.append) return;
		if (dout != null) {
			dout.writeShort(STREAM_MAGIC);
			dout.writeShort(STREAM_VERSION);
		}
	}

}