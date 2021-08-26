package valoracao.view;

import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import valoracao.model.Elemento;
import valoracao.model.Tabela;
import valoracao.view.LabelPadrao;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class TabelaDisplay extends JPanel{
  public Tabela tabela;
  public JTable display;
  public String[] cabecalho;
  public Integer[][] linhas;
  public JLabel titulo;
  public JScrollPane body;


  public TabelaDisplay(){}
  public TabelaDisplay(Tabela tabela){
    this.setTabela(tabela);
    this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
    this.add(this.body);
  }

  public TabelaDisplay(Tabela tabela, String titulo){
    this.setTitulo(titulo);
    this.setTabela(tabela);
    this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
    this.body.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    this.add(this.body);

  }

  public TabelaDisplay(Integer[][] linhas, String[] cabecalho){
    this.setCabecalho(cabecalho);
    this.setLinhas(linhas);
    this.setDisplay();

  }

  public void setTabela(Tabela tabela){
    this.tabela = tabela;
    this.transformarArrayList();
    this.setDisplay();
  }

  public void setCabecalho(String[] dados){
    this.cabecalho = dados;
  }
  public void setLinhas(Integer[][] dados){
    this.linhas = dados;
  }
  public void setDisplay(){
    this.setDisplay(this.linhas, this.cabecalho);
  }
  public void setDisplay(Integer[][] linhas, String[] cabecalho){
    this.display = new JTable(linhas,cabecalho){
      public boolean isCellEditable(int row, int column) {return false;}; //remove a possibilidade de editar a tabela
    };
    this.display.setRowSelectionAllowed(false); //remove a possibilidade de selecionar as células
    // this.display.setFillsViewportHeight(false); //preenche todo o container
    
    this.body = new JScrollPane(this.display); //adiciona a tabela ao JScrollPane
  }

  public void setTitulo(String tit){
    this.titulo = new LabelPadrao(tit);
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