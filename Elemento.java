import java.util.ArrayList;
import java.util.Collections;
import java.io.Serializable;

public class Elemento implements Serializable { //essa classe sera basicamente os caracteres da expressao completa

  String nome = ""; //versão em string do elemento
  //ExpressaoCompleta expressao;
  Tabela tabela; //de qual tabela é o elemento
  int indexTabela; //a qual coluna da tabela o elemento se refere
  ArrayList<Integer> valores = new ArrayList<Integer>(); //valores na tabela de cada variavel ou expressao

  Elemento(){
  }

  void setNome(String nome){
    this.nome = nome;
  }
  String getNome(){
    return this.nome;
  }
  
  void setIndexTabela(int idx){
    this.indexTabela = idx;
  }

  int getIndexTabela(){
    return this.indexTabela;
  }

  void adicionarNaTabela(){
    this.tabela.adicionarElemento(this);
  }

  void setValores(ArrayList valores){
    this.valores = valores;
  }
  void addValor(int valor){
    this.valores.add(valor);
  }

  ArrayList getValores(){
    return this.valores;
  }
}