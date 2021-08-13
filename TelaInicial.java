import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TelaInicial extends JFrame{
  JTextField input;
  JPanel header, body, bodyTop, bodyLeft, bodyRight, bodyBottom;

  TelaInicial(){
    this.setTitle(medidas.nome);
    this.setSize(medidas.larguraJanela, medidas.alturaJanela);
    this.setLocation(medidas.localXJanela, medidas.localYJanela);
    this.setLayout(new BoxLayout (getContentPane(), BoxLayout.Y_AXIS));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.header = new JPanel();
    this.body = new JPanel();

    this.bodyTop = new JPanel();
    this.bodyBottom = new JPanel();
    this.bodyLeft = new JPanel();
    this.bodyRight = new JPanel();

    JLabel titulo = new JLabel("Valoração de Fórmulas Lógicas \n");
    titulo.setFont(medidas.fonteTitulos);
    this.header.add(titulo);

    this.input = new JTextField("Insira", 20);
    this.input.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    this.add(this.header);
    this.setBody();

    // this.mostrarLayout(); //para testes
    
    
    this.add(this.body);
    this.add(new Footer());
    
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

    bSubmeter.addActionListener(new ActionListener() {
      
      public void actionPerformed(ActionEvent e){
        
        ExpressaoCompleta expressao = new ExpressaoCompleta(input.getText());
        Tabela tabela = new Tabela(expressao);
        
        new Resolver(expressao, tabela);
        TelaValoracao valoracao = new TelaValoracao(tabela);
        dispose();
        System.out.println("Submetendo a expressão...");
        //existe a opção de colocar uma barra de progresso também
      }

      
    
    });

    bTabelasSalvas.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        System.out.println("Carregando tabelas salvas...");
        //existe a opção de colocar uma barra de progresso também
      }
    
    });
    
    bInstrucoes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        System.out.println("Indo para instruções...");
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
    this.body.setLayout(new BoxLayout (this.body, BoxLayout.Y_AXIS));
    this.body.setAlignmentX(Component.CENTER_ALIGNMENT);
  }


  private void mostrarLayout(){
    this.bodyLeft.setBorder(BorderFactory.createTitledBorder("Body Left"));
    this.bodyRight.setBorder(BorderFactory.createTitledBorder("Body Right"));
    this.bodyTop.setBorder(BorderFactory.createTitledBorder("Body Top"));
    this.bodyBottom.setBorder(BorderFactory.createTitledBorder("Body Bottom"));
    this.body.setBorder(BorderFactory.createTitledBorder("Body"));
    this.header.setBorder(BorderFactory.createTitledBorder("Header"));
  }

}