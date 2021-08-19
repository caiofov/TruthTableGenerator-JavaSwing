package valoracao.model;

import java.io.Serializable;

public class Variavel extends Elemento implements Serializable {
  Variavel(String nome){
    this.nome = nome;
  }
  Variavel(String nome, int idx){
    this.nome = nome;
    this.indexTabela = idx;
  }

  public int getIndexTabela(){
    return this.indexTabela;
  }
}