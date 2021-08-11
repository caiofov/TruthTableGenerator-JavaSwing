class Variavel extends Elemento{
  Variavel(String nome){
    this.nome = nome;
  }
  Variavel(String nome, int idx){
    this.nome = nome;
    this.indexTabela = idx;
  }

  int getIndexTabela(){
    return this.indexTabela;
  }
}