package valoracao.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Box;

import valoracao.model.ExpressaoCompleta;
import valoracao.model.Resolver;
import valoracao.model.Tabela;
import valoracao.view.TelaValoracao;
import valoracao.view.LabelPadrao;


public class TelaInicial extends Tela{
  JPanel inputPanel = new JPanel();
  JTextField input;
  JPanel bodyTop, bodyLeft, bodyRight, bodyBottom;
  boolean temMensagemError = false;

  public TelaInicial(){
    this.bodyTop = new JPanel();
    this.bodyBottom = new JPanel();
    this.bodyLeft = new JPanel();
    this.bodyRight = new JPanel();

    this.setTitulo("Valoração de Fórmulas Lógicas");
    this.input = new JTextField("Insira", 20);
    this.input.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    this.add(this.header);
    this.setBody();
    // this.add(this.body);
    this.add(this.bodyTop);
    this.add(this.bodyBottom);
    

    // this.mostrarLayout(); //para testes
    
    this.setVisible(true);
  }

  public void setBody(){
    //criar botoes
    Botao bSubmeter = new Botao("Submeter");
    Botao bTabelasSalvas = new Botao("Minhas tabelas");
    Botao bInstrucoes = new Botao("Instruções");
    
    //alinhamentos dos botoes
    bSubmeter.setAlignmentX(Component.CENTER_ALIGNMENT);
    bTabelasSalvas.setAlignmentX(Component.CENTER_ALIGNMENT);
    bInstrucoes.setAlignmentX(Component.CENTER_ALIGNMENT);

    //BODY LEFT - -
    this.inputPanel.add(this.input); //o input precisa ficar dentro de um panel para ter um tamanho menor. Esse panel precisa ter Flow Layout para funcionar
    this.inputPanel.setPreferredSize(new Dimension(0,0)); //controla para o tamnho do panel não ficar muito grande
    
    this.bodyLeft.setLayout(new BoxLayout (this.bodyLeft, BoxLayout.Y_AXIS));
    this.bodyLeft.add(this.inputPanel);
    this.bodyLeft.add(bSubmeter);
    this.bodyLeft.setForeground(medidas.corTexto);

    //BODY RIGHT - - 
    LabelPadrao textBodyRight = new LabelPadrao("Ver tabelas salvas");
    textBodyRight.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    this.bodyRight.add(textBodyRight); //texto
    this.bodyRight.add(bTabelasSalvas); //botao
    this.bodyRight.setLayout(new BoxLayout (this.bodyRight, BoxLayout.Y_AXIS));
    
    // BODY BOTTOM - - - -
    LabelPadrao textBodyBottom = new LabelPadrao("Em dúvida? Veja como funciona!");
    textBodyBottom.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    this.bodyBottom.add(Box.createRigidArea(new Dimension(0, 60))); //distância de 60 pixels dos elementos acima
    this.bodyBottom.add(textBodyBottom); //texto
    this.bodyBottom.add(bInstrucoes); //botao
    this.bodyBottom.add(Box.createRigidArea(new Dimension(0, 20))); //distância de 20 pixels da borda de baixo
    
    this.bodyBottom.setLayout(new BoxLayout (this.bodyBottom, BoxLayout.Y_AXIS));
    this.bodyBottom.setAlignmentX(Component.CENTER_ALIGNMENT);

    // BODY TOP - - - -
    this.bodyTop.add(this.bodyLeft);
    this.bodyTop.add(this.bodyRight);
    this.bodyTop.add(Box.createRigidArea(new Dimension(80, 0))); //distância de 80px da borda direita
    this.bodyTop.setLayout(new BoxLayout (this.bodyTop, BoxLayout.X_AXIS));
    this.bodyTop.setAlignmentX(Component.CENTER_ALIGNMENT);

    // EVENTO DOS BOTOES - - -
    bSubmeter.addActionListener(new ActionListener() { //se o botao for pressionado
      public void actionPerformed(ActionEvent e){
        
        ExpressaoCompleta expressao = new ExpressaoCompleta(input.getText());
        
        if(!(expressao.isValida())){ //caso a expressao não seja válida
          input.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
          
          if (!(temMensagemError)){ //caso já não esteja exibindo uma mensagem de erro
            JLabel mensagemError = new JLabel("Insira uma expressão válida");
            mensagemError.setForeground(Color.RED);
            
            inputPanel.setPreferredSize(new Dimension(0,30)); //redimensiona o panel do input para não cortar a mensagem de erro
            inputPanel.add(mensagemError);
            temMensagemError = true;
          }
          //atualiza o panel
          inputPanel.revalidate();
          inputPanel.repaint();
          
        }
        else{ //caso a expressão seja válida
          Tabela tabela = new Tabela(expressao);
          
          Resolver resolver = new Resolver(expressao, tabela);
          TelaValoracao abrirValoracao = new TelaValoracao(tabela); //abre a tela de valoração
          dispose();
          System.out.println("Submetendo a expressão...");
          //existe a opção de colocar uma barra de progresso também
        }
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

    
  }


  private void mostrarLayout(){
    this.bodyLeft.setBorder(BorderFactory.createTitledBorder("Body Left"));
    this.bodyRight.setBorder(BorderFactory.createTitledBorder("Body Right"));
    this.bodyTop.setBorder(BorderFactory.createTitledBorder("Body Top"));
    this.bodyBottom.setBorder(BorderFactory.createTitledBorder("Body Bottom"));
    this.inputPanel.setBorder(BorderFactory.createTitledBorder("Input Panel"));
    this.mostrarLayoutPrincipal();
  }

}


























// package valoracao.view;

// import java.awt.Component;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.Color;

// import javax.swing.BorderFactory;
// import javax.swing.BoxLayout;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import javax.swing.JTextField;

// import valoracao.model.ExpressaoCompleta;
// import valoracao.model.Resolver;
// import valoracao.model.Tabela;
// import valoracao.view.TelaValoracao;
// import valoracao.view.LabelPadrao;


// public class TelaInicial extends Tela{
//   JTextField input;
//   JPanel bodyTop, bodyLeft, bodyRight, bodyBottom;
//   boolean temMensagemError = false;

//   public TelaInicial(){
//     this.bodyTop = new JPanel();
//     this.bodyBottom = new JPanel();
//     this.bodyLeft = new JPanel();
//     this.bodyRight = new JPanel();

//     this.setTitulo("Valoração de Fórmulas Lógicas");
//     this.input = new JTextField("Insira", 20);
//     this.input.setAlignmentX(Component.CENTER_ALIGNMENT);
    
//     this.add(this.header);
//     this.setBody();
//     this.add(this.body);

//     // this.mostrarLayout(); //para testes
    
//     this.setVisible(true);
//   }

//   public void setBody(){
//     Botao bSubmeter = new Botao("Submeter");
//     Botao bTabelasSalvas = new Botao("Minhas tabelas");
//     Botao bInstrucoes = new Botao("Instruções");
    
//     bSubmeter.setAlignmentX(Component.CENTER_ALIGNMENT);
//     bTabelasSalvas.setAlignmentX(Component.CENTER_ALIGNMENT);
//     bInstrucoes.setAlignmentX(Component.CENTER_ALIGNMENT);

//     //BODY LEFT - -
//     JPanel inputPanel = new JPanel();
//     inputPanel.add(this.input);
//     // this.input.setPreferredSize( new Dimension( 200, 24 ) );
//     // inputPanel.setBorder(BorderFactory.createTitledBorder("input panel"));
    
//     this.bodyLeft.setLayout(new BoxLayout (this.bodyLeft, BoxLayout.Y_AXIS));
//     // this.bodyLeft.add(this.input);
//     this.bodyLeft.add(inputPanel);
//     this.bodyLeft.add(bSubmeter);
//     this.bodyLeft.setAlignmentX(Component.LEFT_ALIGNMENT);
//     this.bodyLeft.setForeground(medidas.corTexto);
    

//     //BODY RIGHT - - 
//     LabelPadrao textBodyRight = new LabelPadrao("Ver tabelas salvas");
//     textBodyRight.setFont(medidas.fonteTextos);
//     textBodyRight.setAlignmentX(Component.CENTER_ALIGNMENT);
    
//     this.bodyRight.add(textBodyRight);
//     this.bodyRight.add(bTabelasSalvas);
//     this.bodyRight.setLayout(new BoxLayout (this.bodyRight, BoxLayout.Y_AXIS));
//     this.bodyRight.setAlignmentX(Component.RIGHT_ALIGNMENT);
    
//     // BODY BOTTOM - - - -
//     LabelPadrao textBodyBottom = new LabelPadrao("Em dúvida? Veja como funciona!");
//     textBodyBottom.setAlignmentX(Component.CENTER_ALIGNMENT);
//     textBodyBottom.setFont(medidas.fonteTextos);
//     this.bodyBottom.add(textBodyBottom);
//     this.bodyBottom.add(bInstrucoes);
//     this.bodyBottom.setLayout(new BoxLayout (this.bodyBottom, BoxLayout.Y_AXIS));
//     this.bodyBottom.setAlignmentX(Component.CENTER_ALIGNMENT);

//     // BODY TOP - - - -
//     this.bodyTop.add(this.bodyLeft);
//     this.bodyTop.add(this.bodyRight);
//     this.bodyTop.setLayout(new BoxLayout (this.bodyTop, BoxLayout.X_AXIS));
//     this.bodyTop.setAlignmentX(Component.CENTER_ALIGNMENT);
   
//     //BODY - - 
//     this.body.add(this.bodyTop);
//     this.body.add(this.bodyBottom);
//     this.body.setLayout(new BoxLayout (this.body, BoxLayout.Y_AXIS));
//     this.body.setAlignmentX(Component.CENTER_ALIGNMENT);

    
//     bSubmeter.addActionListener(new ActionListener() { //se o botao for pressionado
      
//       public void actionPerformed(ActionEvent e){
        
//         ExpressaoCompleta expressao = new ExpressaoCompleta(input.getText());
        
//         if(!(expressao.isValida())){ //caso a expressao não seja válida
//           input.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
          
//           if (!(temMensagemError)){
//             JLabel mensagemError = new JLabel("Insira uma expressão válida");
//             mensagemError.setForeground(Color.RED);
          
//             inputPanel.add(mensagemError);
//             temMensagemError = true;
//           }
//           inputPanel.revalidate();
//           inputPanel.repaint();
          
//         }
//         else{ //caso a expressão seja válida
//           Tabela tabela = new Tabela(expressao);
          
//           Resolver resolver = new Resolver(expressao, tabela);
//           TelaValoracao abrirValoracao = new TelaValoracao(tabela); //abre a tela de valoração
//           dispose();
//           System.out.println("Submetendo a expressão...");
//           //existe a opção de colocar uma barra de progresso também
//         }
//       }
//     });

//     bTabelasSalvas.addActionListener(new ActionListener() { //se o botao for pressionado
//       public void actionPerformed(ActionEvent e){
//         System.out.println("Carregando tabelas salvas...");
//         new TelaTabelasSalvas(); //abre a tela de tabelas salvas
//         dispose();
//       }
    
//     });
    
//     bInstrucoes.addActionListener(new ActionListener() { //se o botao for pressionado
//       public void actionPerformed(ActionEvent e){
//         System.out.println("Indo para instruções...");
//         new TelaInstrucoes(); //abre a tela de instruções
//         dispose();
//         //existe a opção de colocar uma barra de progresso também
//       }
    
//     });

    
//   }


//   private void mostrarLayout(){
//     this.bodyLeft.setBorder(BorderFactory.createTitledBorder("Body Left"));
//     this.bodyRight.setBorder(BorderFactory.createTitledBorder("Body Right"));
//     this.bodyTop.setBorder(BorderFactory.createTitledBorder("Body Top"));
//     this.bodyBottom.setBorder(BorderFactory.createTitledBorder("Body Bottom"));
//     this.mostrarLayoutPrincipal();
//   }

// }