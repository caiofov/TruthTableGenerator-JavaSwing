package valoracao.model;
import valoracao.controller.*;
import valoracao.view.*;

import java.util.ArrayList;
import java.io.Serializable;

public class Elemento implements Serializable { //essa classe sera basicamente os caracteres da expressao completa

  public String nome = ""; //versão em string do elemento
  //ExpressaoCompleta expressao;
  public Tabela tabela; //de qual tabela é o elemento
  public int indexTabela; //a qual coluna da tabela o elemento se refere
  public ArrayList<Integer> valores = new ArrayList<Integer>(); //valores na tabela de cada variavel ou expressao

  public Elemento(){
  }

  public void setNome(String nome){
    this.nome = nome;
  }
  public String getNome(){
    return this.nome;
  }
  
  public void setIndexTabela(int idx){
    this.indexTabela = idx;
  }

  public int getIndexTabela(){
    return this.indexTabela;
  }

  public void adicionarNaTabela(){
    this.tabela.adicionarElemento(this);
  }

  public void setValores(ArrayList valores){
    this.valores = valores;
  }
  public void addValor(int valor){
    this.valores.add(valor);
  }

  public ArrayList getValores(){
    return this.valores;
  }
}