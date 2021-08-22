package valoracao.view;

import java.awt.Color;
import java.awt.Font;

interface medidas{
  //constantes de medidas para as telas
  
  //dimensões dos elementos
  //janela
  public int larguraJanela = 1200;
  public int alturaJanela = 650; 
  //tabela da tela de valoração
  public int larguraTabelaPrincipal = 230;
  public int alturaTabelaPrincipal = 100;

  //posição de quando é aberto uma janela
  public int localXJanela = 50;
  public int localYJanela = 50;

  //nome para os frames
  public String nome = "Trabalho Final";

  //cores
  public Color corCinza = new Color(124,124,124);
  public Color corBranca = new Color(255,255,255);
  public Color corPreta = new Color(37,37,37);

  //fontes
  public Font fonteTitulos = new Font("Verdana", Font.BOLD, 23);
  public Font fonteTextos = new Font("Arial", Font.PLAIN, 20);
  public Font fonteBotoes = new Font("Verdana", Font.PLAIN, 18);
}