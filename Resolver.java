import java.util.ArrayList;
import java.util.Collections;

class Resolver{
  ExpressaoCompleta expressao; //recebe a expressao
  Tabela tabela; //recebe a tabela
  ArrayList<Elemento> elementos; //elementos da expressao
  

  Resolver(ExpressaoCompleta expressao, Tabela tabela){
    this.expressao = expressao;
    this.tabela = tabela;
    this.elementos = expressao.getElementos();
    
    this.resolver();
  }

	void resolver() {
		int nParenteses = 0, r, idx = 0;
		ArrayList<Character> exp = new ArrayList<Character>();
		ArrayList<Character> subexp = new ArrayList<Character>();
		ArrayList<Integer> valores = new ArrayList<Integer>();

		// Cria o elemento cabeçalho da tabela, que será a expressao completa e seus valores:
		Elemento expressaoComp = new Variavel(expressao.expressaoString, tabela.num_variaveis);
		this.tabela.adicionarElemento(expressaoComp);

		// Conta o numero de parenteses
		for (char elem : this.expressao.expressaoCharArray) {
			if (elem == ')') {
				nParenteses++;
			}
		}

		// INICIO do for das linhas:
		for (int l = 0; l < this.tabela.ndois; l++) {
			// Cria uma arraylist de caracteres da expressao:
			for (char elem : this.expressao.expressaoCharArray) {
				exp.add(elem);
			}

			// elimina os not's:

			// Resolve todas as expressoes dentro de parenteses:
			for (int n=0; n < nParenteses; n++) {
				// Descobre a sub-expressao:
				for (int e = 0; e < exp.size(); e++) {
					if (exp.get(e) == ')') {
						exp.remove(e);
						e--;
						while (exp.get(e) != '(') {
							subexp.add(0, exp.remove(e));
							e--;
						}
						exp.remove(e);
						idx = e;
						break;
					}
				}
				// Resolve a subexp:
				r = resultado(subexp, l);
				if (r == 1) {
					exp.add(idx, '1');
				}
				else if (r == 0){
					exp.add(idx, '0');
				}
				subexp.clear();
			}

			// resolver expressão sem parenteses:
			while (exp.size() > 2) {
				subexp.add(exp.remove(0));
				subexp.add(exp.remove(0));
				subexp.add(exp.remove(0));

				r = resultado(subexp, l);
				if (r == 1) {
					exp.add(0, '1');
				}
				else if (r == 0){
					exp.add(0, '0');
				}
				subexp.clear();
			}

			valores.add(exp.remove(0) - '0');
		} // FIM do for das linhas

		tabela.adicionarValores(valores, tabela.num_variaveis);
	}

	int resultado (ArrayList<Character> calculo, int linha) {
		int v1, v2, pos1 = 0, pos2 = 0;
		char op = calculo.get(1);

		if (calculo.get(0) == '0') {
			v1 = 0;
		} else if (calculo.get(0) == '1') {
			v1 = 1;
		} else {		
			String var1 = String.valueOf(calculo.get(0));
			for (Elemento elem : this.tabela.cabecalho) {
				if (elem.getNome().equals(var1)) {
					pos1 = elem.getIndexTabela();
				}
			}
			v1 = (int) this.tabela.corpo.get(pos1).get(linha);
		}

		if (calculo.get(2) == '0') {
			v2 = 0;
		} else if (calculo.get(2) == '1') {
			v2 = 1;
		} else {
			String var2 = String.valueOf(calculo.get(2));
			for (Elemento elem : this.tabela.cabecalho) {
				if (elem.getNome().equals(var2)) {
					pos2 = elem.getIndexTabela();
				}
			}
			v2 = (int) this.tabela.corpo.get(pos2).get(linha);
		}

		if (op == '+') {
			if (v1 == 1 || v2 == 1) {
				return 1;
			}
			else {
				return 0;
			} 
		}
		
		if (op == '*') {
			if (v1 == 1 && v2 == 1) {
				return 1;
			}
			else {
				return 0;
			} 
		}

		if (op == '%') {
			if ((v1 == 1 && v2 == 0) || (v1 == 0 && v2 == 1)) {
				return 1;
			}
			else {
				return 0;
			} 
		}

		if (op == '>') {
			if (v1 == 0 || (v1 == 1 && v2 == 1)) {
				return 1;
			}
			else {
				return 0;
			} 
		}

		if (op == '^') { // NAND
			if (v1 == 1 && v2 == 1) {
				return 0;
			}
			else {
				return 1;
			} 
		}

		if (op == '´') { // NOR
			if (v1 == 1 || v2 == 1) {
				return 0;
			}
			else {
				return 1;
			} 
		}

		return 0;
	}
}