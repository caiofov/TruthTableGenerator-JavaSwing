package valoracao.model;

import java.util.ArrayList;

public class ExpressaoMinima extends Elemento{
  public boolean resolvido = false; //indica se a expressão mínima já foi resolvida
  public ArrayList<Elemento> elementos = new ArrayList<Elemento>();
  public Elemento operador, var1, var2;

  public ExpressaoMinima(){}
  ExpressaoMinima(ArrayList<Elemento> elementos){
    this.setAtributos(elementos);
  }
  public ExpressaoMinima(String nome){
    this.nome = nome;
  }
  public ExpressaoMinima(String nome, int idx){
    this.nome = nome;
    this.indexTabela = idx;
  }

  public void setAtributos(ArrayList<Elemento> elementos){
    for(Elemento elm : elementos){
      this.nome = this.nome + elm.getNome();
      if(elm instanceof Operador){
        this.operador = elm;
      }
      else if(elm instanceof Variavel){
        if(this.var1 != null){
          this.var2 = elm;
        }
        else{
          this.var1 = elm;
        }
      }

    }
  }

  public void setResolvido(){
    this.resolvido = true;
  }
  public boolean isResolvido(){
    return this.resolvido;
  }

}