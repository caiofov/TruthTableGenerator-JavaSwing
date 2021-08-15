package valoracao.view;

import javax.swing.*;
import java.awt.*;

interface medidas{
  //constantes de medidas para as telas
  
  //dimensões dos elementos
  //janela
  int larguraJanela = 600; //1200
  int alturaJanela = 350; //650
  //tabela da tela de valoração
  int larguraTabelaPrincipal = 230;
  int alturaTabelaPrincipal = 100;

  //posição de quando é aberto uma janela
  int localXJanela = 50;
  int localYJanela = 50;

  //nome para os frames
  String nome = "Trabalho Final";

  //cores
  Color corCinza = new Color(124,124,124);
  Color corBranca = new Color(255,255,255);
  Color corPreta = new Color(37,37,37);

  //fontes
  Font fonteTitulos = new Font("Verdana", Font.BOLD, 23);
  Font fonteTextos = new Font("Arial", Font.PLAIN, 20);
  Font fonteBotoes = new Font("Verdana", Font.PLAIN, 18);
}