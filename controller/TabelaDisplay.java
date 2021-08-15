package valoracao.controller;

import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

class TabelaDisplay extends JPanel{
  Tabela tabela;
  JTable display;
  String[] cabecalho;
  Integer[][] linhas;
  JLabel titulo;
  JScrollPane body;


  TabelaDisplay(){}
  TabelaDisplay(Tabela tabela){
    this.setTabela(tabela);
    this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
    this.add(this.body);
  }

  TabelaDisplay(Tabela tabela, String titulo){
    this.setTitulo(titulo);
    this.setTabela(tabela);
    this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
    this.add(this.body);

  }

  TabelaDisplay(Integer[][] linhas, String[] cabecalho){
    this.setCabecalho(cabecalho);
    this.setLinhas(linhas);
    this.setDisplay();

  }

  void setTabela(Tabela tabela){
    this.tabela = tabela;
    this.transformarArrayList();
    this.setDisplay();
  }

  void setCabecalho(String[] dados){
    this.cabecalho = dados;
  }
  void setLinhas(Integer[][] dados){
    this.linhas = dados;
  }
  void setDisplay(){
    this.setDisplay(this.linhas, this.cabecalho);
  }
  void setDisplay(Integer[][] linhas, String[] cabecalho){
    this.display = new JTable(linhas,cabecalho){
      public boolean isCellEditable(int row, int column) {return false;}; //remove a possibilidade de editar a tabela
    };
    this.display.setRowSelectionAllowed(false); //remove a possibilidade de selecionar as células
    // this.display.setFillsViewportHeight(true); //preenche todo o container
    
    this.body = new JScrollPane(this.display); //adiciona a tabela ao JScrollPane
  }

  void setTitulo(String tit){
    this.titulo = new JLabel(tit);
    this.add(this.titulo);
  }


  private void transformarArrayList(){
    //a tabela só recebe array (não arraylist). Portanto, deveremos passar todas as informações do arraylist para um array.
    ArrayList<Elemento> cabecalho = this.tabela.getCabecalho();
    String[] cabecalhoArray = new String[cabecalho.size()]; 

    ArrayList<ArrayList> colunas = this.tabela.getCorpo();
    //teremos que inverter o formato que criamos da tabela para o JTable. Cada "subarray" é uma linha e não uma coluna.
    ArrayList<ArrayList> linhas = this.transpor(colunas);

    Integer[][] linhasArray = new Integer[linhas.size()][cabecalho.size()];



    int indexCabecalho = 0; //variavel que será incrementada
    for(Elemento x:cabecalho){
      cabecalhoArray[indexCabecalho] = cabecalho.get(indexCabecalho).getNome();
      indexCabecalho++;
    }

    //variaveis que serão incrementadas
    int indexArrayListLinhas = 0; //se refere aos arraylists dentro de "linhas"
    
    for(ArrayList<Integer> a: linhas){
      int indexIntLinhas = 0; //se refere aos inteiros (0 e 1) dentro dos arraylists dentro de "linhas"
      for(int i: a){
        linhasArray[indexArrayListLinhas][indexIntLinhas] = i;
        indexIntLinhas++;
      }
      indexArrayListLinhas++;
    }
    this.setCabecalho(cabecalhoArray);
    this.setLinhas(linhasArray);
  }


  private ArrayList<ArrayList> transpor(ArrayList<ArrayList> lista){ //fonte: https://stackoverflow.com/questions/2941997/how-to-transpose-listlist
    ArrayList<ArrayList> ret = new ArrayList<ArrayList>();
        final int N = lista.get(0).size();
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> col = new ArrayList<Integer>();
            for (ArrayList<Integer> row : lista) {
                col.add(row.get(i));
            }
            ret.add(col);
        }
        return ret;
  }

}