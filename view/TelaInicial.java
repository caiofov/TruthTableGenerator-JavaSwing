package valoracao.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.BorderFactory;


class TelaInicial extends Tela{
  JTextField input;
  JPanel bodyTop, bodyLeft, bodyRight, bodyBottom;

  TelaInicial(){
    this.bodyTop = new JPanel();
    this.bodyBottom = new JPanel();
    this.bodyLeft = new JPanel();
    this.bodyRight = new JPanel();

    this.setTitulo("Valoração de Fórmulas Lógicas");
    this.input = new JTextField("Insira", 20);
    this.input.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    this.add(this.header);
    this.setBody();
    this.add(this.body);
    this.add(this.footer);

    this.mostrarLayout(); //para testes
    
    
    
    // this.pack();
    this.setVisible(true);
  }

  void setBody(){
    Botao bSubmeter = new Botao("Submeter");
    Botao bTabelasSalvas = new Botao("Minhas tabelas");
    Botao bInstrucoes = new Botao("Instruções");
    
    bSubmeter.setAlignmentX(Component.CENTER_ALIGNMENT);
    bTabelasSalvas.setAlignmentX(Component.CENTER_ALIGNMENT);
    bInstrucoes.setAlignmentX(Component.CENTER_ALIGNMENT);

    bSubmeter.addActionListener(new ActionListener() { //se o botao for pressionado
      
      public void actionPerformed(ActionEvent e){
        
        ExpressaoCompleta expressao = new ExpressaoCompleta(input.getText());
        
        // if(!(expressao.isValida())){ //caso a expressao não seja válida
        //   input.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        //   //FALTA: adicionar mensagem de erro embaixo do input
        // }
        // else{ //caso a expressão seja válida
          Tabela tabela = new Tabela(expressao);
        
          new Resolver(expressao, tabela);
          new TelaValoracao(tabela); //abre a tela de valoração
          dispose();
          System.out.println("Submetendo a expressão...");
          //existe a opção de colocar uma barra de progresso também
        // }
      }
    });

    bTabelasSalvas.addActionListener(new ActionListener() { //se o botao for pressionado
      public void actionPerformed(ActionEvent e){
        System.out.println("Carregando tabelas salvas...");
        new TelaTabelasSalvas(); //abre a tela de tabelas salvas
        dispose();
      }
    
    });
    
    bInstrucoes.addActionListener(new ActionListener() { //se o botao for pressionado
      public void actionPerformed(ActionEvent e){
        System.out.println("Indo para instruções...");
        new TelaInstrucoes(); //abre a tela de instruções
        dispose();
        //existe a opção de colocar uma barra de progresso também
      }
    
    });

    //BODY LEFT - -
    JPanel inputPanel = new JPanel();
    inputPanel.add(this.input);
    // this.input.setPreferredSize( new Dimension( 200, 24 ) );
    // inputPanel.setBorder(BorderFactory.createTitledBorder("input panel"));
    
    this.bodyLeft.setLayout(new BoxLayout (this.bodyLeft, BoxLayout.Y_AXIS));
    // this.bodyLeft.add(this.input);
    this.bodyLeft.add(inputPanel);
    this.bodyLeft.add(bSubmeter);
    this.bodyLeft.setAlignmentX(Component.LEFT_ALIGNMENT);
    

    //BODY RIGHT - - 
    JLabel textBodyRight = new JLabel("Ver tabelas salvas");
    textBodyRight.setFont(medidas.fonteTextos);
    textBodyRight.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    this.bodyRight.add(textBodyRight);
    this.bodyRight.add(bTabelasSalvas);
    this.bodyRight.setLayout(new BoxLayout (this.bodyRight, BoxLayout.Y_AXIS));
    this.bodyRight.setAlignmentX(Component.RIGHT_ALIGNMENT);
    
    // BODY BOTTOM - - - -
    JLabel textBodyBottom = new JLabel("Em dúvida? Veja como funciona!");
    textBodyBottom.setAlignmentX(Component.CENTER_ALIGNMENT);
    textBodyBottom.setFont(medidas.fonteTextos);
    this.bodyBottom.add(textBodyBottom);
    this.bodyBottom.add(bInstrucoes);
    this.bodyBottom.setLayout(new BoxLayout (this.bodyBottom, BoxLayout.Y_AXIS));
    this.bodyBottom.setAlignmentX(Component.CENTER_ALIGNMENT);

    // BODY TOP - - - -
    this.bodyTop.add(this.bodyLeft);
    this.bodyTop.add(this.bodyRight);
    this.bodyTop.setLayout(new BoxLayout (this.bodyTop, BoxLayout.X_AXIS));
    this.bodyTop.setAlignmentX(Component.CENTER_ALIGNMENT);
   
    //BODY - - 
    this.body.add(this.bodyTop);
    this.body.add(this.bodyBottom);
    this.body.setLayout(new BoxLayout (this.body, BoxLayout.Y_AXIS));
    this.body.setAlignmentX(Component.CENTER_ALIGNMENT);
  }


  private void mostrarLayout(){
    this.bodyLeft.setBorder(BorderFactory.createTitledBorder("Body Left"));
    this.bodyRight.setBorder(BorderFactory.createTitledBorder("Body Right"));
    this.bodyTop.setBorder(BorderFactory.createTitledBorder("Body Top"));
    this.bodyBottom.setBorder(BorderFactory.createTitledBorder("Body Bottom"));
    this.mostrarLayoutPrincipal();
  }

}