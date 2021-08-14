import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class TelaValoracao extends Tela{
  TabelaDisplay tabelaDisplay;
  Tabela tabelaAtual;
  String expressao;
  boolean tabelaSalva = false; //diz se a tabela já foi salva (para controlar se o popup aparece ou nao)
  JPanel body, bodyPreTabela, bodyPosTabela;

  TelaValoracao(Tabela tabela){

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

    this.add(titulo);
    this.add(this.body);
    this.add(new Footer());
    
    this.setVisible(true);
  }
  
  void addTextos(String expressao){
    this.bodyPreTabela.setLayout(new BoxLayout (this.bodyPreTabela, BoxLayout.Y_AXIS));
    
    JLabel texto1 = new JLabel("Expressao: " + expressao);
    JLabel texto2 = new JLabel("Tabela: ");
    texto1.setFont(medidas.fonteTextos);
    texto2.setFont(medidas.fonteTextos);

    this.bodyPreTabela.add(texto1);
    this.bodyPreTabela.add(texto2);
    this.bodyPreTabela.setAlignmentX(LEFT_ALIGNMENT);
    
    this.body.add(bodyPreTabela);
  }

  void addTabela(){
    this.tabelaDisplay = new TabelaDisplay(this.tabelaAtual); 

    this.tabelaDisplay.setPreferredSize(new Dimension(medidas.larguraTabelaPrincipal, medidas.alturaTabelaPrincipal)); //setta as dimensões do scrollpane, onde está a tabela

    this.body.add(this.tabelaDisplay);
  }

  void addBotoes(){
    Botao bVoltar = new Botao("Voltar");
    
    bVoltar.addActionListener(new ActionListener() {
    
      public void actionPerformed(ActionEvent e){
        TelaInicial inicio = new TelaInicial();
        dispose();
        System.out.println("Retornando ao início...");
        //ao clicar, volta para a tela de início

        if(!tabelaSalva){
          //adicionar popup
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

      }
  
    });

    this.bodyPosTabela.add(bVoltar);
    this.bodyPosTabela.add(bSalvar);

    this.body.add(bodyPosTabela);
  }

  private void mostrarLayout(){
    this.bodyPreTabela.setBorder(BorderFactory.createTitledBorder("Pre Tabela"));
    this.bodyPosTabela.setBorder(BorderFactory.createTitledBorder("Pos Tabela"));
    this.mostrarLayoutPrincipal();
  }
}