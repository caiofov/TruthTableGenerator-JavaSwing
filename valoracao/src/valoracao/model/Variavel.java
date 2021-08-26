package valoracao.model;

import java.io.Serializable;

public class Variavel extends Elemento implements Serializable {
  public Variavel(String nome){
    this.nome = nome;
  }
  public Variavel(String nome, int idx){
    this.nome = nome;
    this.indexTabela = idx;
  }

  public int getIndexTabela(){
    return this.indexTabela;
  }
}