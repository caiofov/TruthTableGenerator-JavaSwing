package valoracao.model;

import java.util.ArrayList;
import java.io.Serializable;

public class Tabela implements Serializable {
  ExpressaoCompleta expressaoCompleta; //a que expressão essa tabela está vinculada.
  int num_variaveis; //número de variáveis na tabela (as primeiras colunas)
  int ndois = 1; //2^n --> não consegui calcular com as operações do java

  ArrayList<ArrayList> corpo = new ArrayList<ArrayList>(); //onde ficarão os 0 e 1s
  ArrayList<Elemento> cabecalho = new ArrayList<Elemento>(); //cabeçalho: onde fica o "título" de cada coluna

  Tabela(ExpressaoCompleta exp){
    this.expressaoCompleta = exp;
    this.num_variaveis = this.expressaoCompleta.variaveis.size();
    this.setNdois(); 
    this.inicializarCorpo();
  }


 
  void setNdois(){ //calcula 2^n (não consegui fazer usando operação comum do java)
    for(int i=0; i < this.num_variaveis; i++){
      this.ndois = this.ndois*2;
    }
  }

  //inicializa a tabela
  void inicializarCorpo(){
    //adiciona as variáveis já como instância de Elemento ao "cabecalho" da tabela
    //adiciona um novo array no array do corpo para cada loop, ou seja, para cada variável
    for(Elemento var : this.expressaoCompleta.getVariaveis()){
      ArrayList<Integer> novoArray = new ArrayList<Integer>();
      this.corpo.add(novoArray);
      
      this.cabecalho.add(var);
    
    }
    
    //faz as combinações de 0 e 1 para cada coluna inicial (das variáveis) da tabela
    for (int i = 0; i < this.ndois; i++){ //linha = i
      int x = this.ndois;
      int bit, countColuna = 0; //bit = 0 ou 1 | coluna = countColuna

      while(x>1){
        bit = i/(x/2)%2;
        x = x/2;
        ArrayList<Integer> coluna = this.corpo.get(countColuna);
        coluna.add(i,bit);
        
        //agora, mexer nas variaveis
        Elemento var = this.cabecalho.get(countColuna);
        var.addValor(bit); //adiciona o valor
        var.setIndexTabela(countColuna); //setta o index,que será o número da coluna
        
        countColuna++; //incrementar a coluna

      }
      
    }

  }

  //adiciona elemento ao cabecalho da tabela
  void adicionarElemento(Elemento elemento){
    this.cabecalho.add(elemento);
  }
  //recebe um array de valores para adicionar ao corpo da tabela, junto com o índice correspondente à posição no cabecalho.
  void adicionarValores(ArrayList<Integer> valores, int idx){
    this.corpo.add(idx,valores);
  }


  //printa a tabela no prompt
  void mostrar(){

    System.out.println("TABELA - - - -");
    
    for(int n = 0; n < this.cabecalho.size(); n++){
      Elemento elm = cabecalho.get(n);
      System.out.println("--- "+elm.getNome()+" ---");

      ArrayList<Integer> coluna = this.corpo.get(n);
      for(int x = 0; x < coluna.size(); x++){
        System.out.println(coluna.get(x));
      }
    }
    
  }

  ArrayList<ArrayList> getCorpo(){
    return this.corpo;
  }
  ArrayList<Elemento> getCabecalho(){
    return this.cabecalho;
  }
  ExpressaoCompleta getExpressaoCompleta(){
    return this.expressaoCompleta;
  }

}