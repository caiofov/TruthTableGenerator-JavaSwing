import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class TelaValoracao extends JFrame{
	Tabela tabela;
  TabelaDisplay tabelaDisplay;
  String expressao;
  boolean tabelaSalva = false; //diz se a tabela já foi salva (para controlar se o popup aparece ou nao)
  JPanel body, bodyPreTabela, bodyPosTabela;

  TelaValoracao(Tabela tabela){
		this.tabela = tabela;
    this.setTitle(medidas.nome);
    this.setSize(medidas.larguraJanela, medidas.alturaJanela);
    this.setLocation(medidas.localXJanela, medidas.localYJanela);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new BoxLayout (getContentPane(), BoxLayout.Y_AXIS));
    JLabel titulo = new JLabel("Tabela \n");
    
    this.body = new JPanel();
    this.bodyPreTabela = new JPanel();
    this.bodyPosTabela = new JPanel();
    
    this.addTextos(tabela.getExpressaoCompleta().getExpressaoString());
    this.addTabela(tabela);
    this.addBotoes();

    this.body.setLayout(new BoxLayout (this.body, BoxLayout.Y_AXIS));

    this.add(titulo);
    this.add(this.body);
    this.add(new Footer());
    
    this.setVisible(true);
  }
  
  void addTextos(String expressao){
    this.bodyPreTabela.setLayout(new BoxLayout (this.bodyPreTabela, BoxLayout.Y_AXIS));
    this.bodyPreTabela.add(new JLabel("Expressao: " + expressao));
    this.bodyPreTabela.add(new JLabel("Tabela: "));

    this.body.add(this.bodyPreTabela);
  }

  void addTabela(Tabela tabela){
    this.tabelaDisplay = new TabelaDisplay(tabela); 

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
        tabelaSalva = true; //indica que salvou a tabela

        // Salva tabela em tabelasSalvas.txt
				SalvarTabela slv = new SalvarTabela(tabela);
				slv.salvarTab();
      }
  
    });

    this.bodyPosTabela.add(bVoltar);
    this.bodyPosTabela.add(bSalvar);
    this.body.add(bodyPosTabela);
  }

  private void mostrarLayout(){
    this.bodyPreTabela.setBorder(BorderFactory.createTitledBorder("Pre Tabela"));
    this.bodyPreTabela.setBorder(BorderFactory.createTitledBorder("Pos Tabela"));
  }
}