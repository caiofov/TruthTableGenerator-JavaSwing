import java.util.ArrayList;
import java.util.Collections;
import java.io.Serializable;

public class ExpressaoCompleta implements Serializable {
  String expressaoString; //expressao no formato de string
 
  char[] expressaoCharArray; //expressao como vetor
 
  ArrayList<Elemento> elementos = new ArrayList<Elemento>();
  ArrayList<String> variaveisString = new ArrayList<String>();
  ArrayList<Elemento> variaveis = new ArrayList<Elemento>();


  ExpressaoCompleta(){
  }

  ExpressaoCompleta(String exp){
    this.setExpressao(exp);
    this.setElementos();
  }

  void setExpressao(String exp){
    this.expressaoString = exp;
    this.tratarExpressao();
    this.expressaoCharArray = exp.toCharArray();
  }


  void setElementos(){ //pega apenas as variáveis da expressão
    
    for(char c : this.expressaoCharArray){
      String s = String.valueOf(c);
      boolean isLetra = this.isLetra(c);
      
      if (isLetra && !this.variaveisString.contains(s)){
        Elemento novaVariavel = new Variavel(s);
        this.elementos.add(novaVariavel);
        this.variaveis.add(novaVariavel);

        //this.variaveisString.add(s);
        
      }
      
      else if(!isLetra){
        //não consegui fazer o switch
        if (s.equals('(')){
          this.elementos.add(operadores.ABRIR);
        }
        else if (s.equals(')')){
          this.elementos.add(operadores.FECHAR);
        }
        else if (s.equals('*')){
          this.elementos.add(operadores.AND);
        }
        else if (s.equals('+')){
          this.elementos.add(operadores.OR);
        }
        // else if (s.equals('¬')){
        //   this.elementos.add(operadores.NOT);
        // }
      }
    }


    // Collections.sort(this.variaveisString, String.CASE_INSENSITIVE_ORDER); //organiza em ordem alfabética - não sei se vai ser necessário
  }



  ArrayList<Elemento> getVariaveis(){
    return this.variaveis;
  }
  ArrayList<Elemento> getElementos(){
    return this.elementos;
  }

  String getExpressaoString(){
    return this.expressaoString;
  }
  char[] getExpressaoCharArray(){
    return this.expressaoCharArray;
  }



  private boolean isLetra(char c){
    //considerando todas as letras maiusculas ja
    return (c>='A' && c<='Z');
  }


  //FALTA FAZER - - -- -
  boolean isValida(){ //verifica se a expressão é válida
    return true;
  }
  void tratarExpressao(){ //trata a expressão, trocando os caracteres necessários
    this.expressaoString.toUpperCase(); //deixa todos os caracteres maiúsculos
  }
  //faz a expressão posfixa (não é pra receber a expressão, é pra fazer mesmo) --> COMO ESTÁ AGORA É SÓ PRA TESTE
  // void setExpressaoPosfixa(ArrayList<Elemento> pos){
  //   this.expressaoPosfixa = pos;
  // }

}