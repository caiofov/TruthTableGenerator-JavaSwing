package valoracao.model;

interface operadores{
  //essa interface apenas guarda umas constantes

  Operador OR = new Operador("+", true);
  Operador AND = new Operador("*", true);
  Operador XOR = new Operador("%", true);
  Operador IMP = new Operador(">", true);
  //Operador NOT = new Operador("¬", true);
  Operador NAND = new Operador("^", true);
  Operador NOR = new Operador("´", true);

  Operador ABRIR = new Operador("(",false);
  Operador FECHAR = new Operador(")",false);
}