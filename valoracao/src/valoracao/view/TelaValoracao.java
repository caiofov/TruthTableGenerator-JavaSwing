package valoracao.view;

import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

import valoracao.controller.SalvarTabela;
import valoracao.view.TabelaDisplay;
import valoracao.model.Tabela;





class TelaValoracao extends Tela{
  TabelaDisplay tabelaDisplay;
  static JScrollPane tabelaScroll;
  Tabela tabelaAtual;

  String expressao;
  boolean tabelaSalva = false; //diz se a tabela já foi salva (para controlar se o popup aparece ou nao)
  JPanel body;
  JPanel bodyPreTabela;
  JPanel bodyPosTabela;
  
  
  public TelaValoracao(Tabela tabela){

    this.setLayout(new BoxLayout (getContentPane(), BoxLayout.Y_AXIS));
    this.setTitulo("Tabela");
    

    this.tabelaAtual = tabela;
    
    this.body = new JPanel();
    this.bodyPreTabela = new JPanel();
    this.bodyPosTabela = new JPanel();
    
    this.addTextos(tabela.getExpressaoCompleta().getExpressaoString());
    this.addTabela();
    this.addBotoes();

    this.body.setLayout(new BoxLayout (this.body, BoxLayout.Y_AXIS));

    this.add(this.header);
    this.add(this.body);
    
    this.setVisible(true);
  }
  
  public void addTextos(String expressao){
    this.bodyPreTabela.setLayout(new BoxLayout (this.bodyPreTabela, BoxLayout.Y_AXIS));
    
    LabelPadrao texto1 = new LabelPadrao("Expressao: " + expressao);
    LabelPadrao texto2 = new LabelPadrao("Tabela: ");
    texto1.setFont(medidas.fonteTextos);
    texto2.setFont(medidas.fonteTextos);

    this.bodyPreTabela.add(texto1);
    this.bodyPreTabela.add(texto2);
    this.bodyPreTabela.setAlignmentX(LEFT_ALIGNMENT);
    
    this.body.add(bodyPreTabela);
  }

  public void addTabela(){
    this.tabelaDisplay = new TabelaDisplay(this.tabelaAtual);
    this.tabelaScroll = this.tabelaDisplay.body;

    this.body.add(this.tabelaScroll);
  }

  public void addBotoes(){
    Botao bVoltar = new Botao("Voltar");
    
    bVoltar.addActionListener(new ActionListener() {
        
      @Override
      public void actionPerformed(ActionEvent e){
        
        if(tabelaSalva == false){
            Object[] options = { "Continuar", "Cancelar" };
            int retorno_popup = JOptionPane.showOptionDialog(null, "Você não salvou a sua tabela. Ao prosseguir, você perderá todos os dados inseridos. \nDeseja continuar mesmo assim?", "Atenção!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (retorno_popup == 0){
                new TelaInicial();
                dispose();
                System.out.println("Retornando ao início...");
                //ao clicar, volta para a tela de início
            }
        }
        else{
            new TelaInicial();
            dispose();
            System.out.println("Retornando ao início...");
        }
      }
  
    });


    Botao bSalvar = new Botao("Salvar");
   
    bSalvar.addActionListener(new ActionListener() {
    
      public void actionPerformed(ActionEvent e){
        System.out.println("Salvando tabela...");
        
        SalvarTabela salvar = new SalvarTabela(tabelaAtual);
        salvar.salvarTab();
        tabelaSalva = true; //indica que salvou a tabela
        JOptionPane.showMessageDialog(null, "Sua tabela foi salva com sucesso!", "Salvo!", JOptionPane.INFORMATION_MESSAGE);

      }
  
    });

    Botao bBaixar = new Botao("Baixar");

    bBaixar.addActionListener(new ActionListener() {
    
      public void actionPerformed(ActionEvent e){

        JScrollPane scrollSalvar = tabelaScroll;
        
        salvarImagem(scrollSalvar);

        JOptionPane.showMessageDialog(null, "Download concluído.", "Concluído!", JOptionPane.INFORMATION_MESSAGE);

      }
  
    });

    this.bodyPosTabela.add(bVoltar);
    this.bodyPosTabela.add(bSalvar);
    this.bodyPosTabela.add(bBaixar);

    this.body.add(bodyPosTabela);
  }
  private void salvarImagem(JScrollPane componente) {
    try {
      BufferedImage imagem = new BufferedImage(componente.getWidth(), componente.getHeight(), BufferedImage.TYPE_INT_RGB);
      componente.paintAll(imagem.getGraphics());
      ImageIO.write(imagem, "png", new File ("data/Tabela.png"));
    } 
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void mostrarLayout(){
    this.bodyPreTabela.setBorder(BorderFactory.createTitledBorder("Pre Tabela"));
    this.bodyPosTabela.setBorder(BorderFactory.createTitledBorder("Pos Tabela"));
    this.mostrarLayoutPrincipal();
  }
}