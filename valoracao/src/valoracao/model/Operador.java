package valoracao.model;

public class Operador extends Elemento{
  boolean operacao; //indica se é um operador mesmo (true) ou só parenteses (false)
  
  Operador(String nome, boolean operacao){
    this.nome = nome;
    this.operacao = operacao;
  }
}