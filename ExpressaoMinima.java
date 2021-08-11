import java.util.ArrayList;
import java.util.Collections;

class ExpressaoMinima extends Elemento{
  boolean resolvido = false; //indica se a expressão mínima já foi resolvida
  ArrayList<Elemento> elementos = new ArrayList<Elemento>();
  Elemento operador, var1, var2;

  ExpressaoMinima(){}
  ExpressaoMinima(ArrayList<Elemento> elementos){
    this.setAtributos(elementos);
  }
  ExpressaoMinima(String nome){
    this.nome = nome;
  }
  ExpressaoMinima(String nome, int idx){
    this.nome = nome;
    this.indexTabela = idx;
  }

  void setAtributos(ArrayList<Elemento> elementos){
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

  void setResolvido(){
    this.resolvido = true;
  }
  boolean isResolvido(){
    return this.resolvido;
  }

}