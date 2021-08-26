package valoracao.view;

import java.awt.Color;
import java.awt.Font;

interface medidas{
  //constantes de medidas para as telas
  
  //dimensões dos elementos
  //janela
  public int larguraJanela = 600;
  public int alturaJanela = 350; 
  //tabela da tela de valoração
  public int larguraTabelaPrincipal = 230;
  public int alturaTabelaPrincipal = 100;

  //posição de quando é aberto uma janela
  public int localXJanela = 400;
  public int localYJanela = 200;

  //nome para os frames
  public String nome = "Trabalho Final";

  //cores
  public Color corTexto = new Color(38,1,1); //cor dos textos (primária)
  public Color corTitulo = new Color(191,54,4); //cor dos títulos de cada janela
  public Color corBotaoTexto = new Color(38,1,1); //cor do texto do botão em estado normal
  public Color corBotaoFundo = new Color(217, 123, 41); //cor do fundo do botão em estado normal
  public Color corBotaoFundoHover = new Color(242, 158, 109); //cor do fundo do botão qunado houver "hover"
  public Color corBotaoTextoHover = new Color(38,1,1); //cor do texto do botão qunado houver "hover"

  //fontes
  public Font fonteTitulos = new Font("Verdana", Font.BOLD, 23);
  public Font fonteTextos = new Font("Arial", Font.PLAIN, 18);
  public Font fonteBotoes = new Font("Courier", Font.PLAIN, 14);
}