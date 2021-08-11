import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class TelaValoracao extends JFrame{
  TabelaDisplay tabelaDisplay;
  String expressao;
  boolean tabelaSalva = false; //diz se a tabela já foi salva (para controlar se o popup aparece ou nao)


  TelaValoracao(Tabela tabela){
    this.setTitle(medidas.nome);
    this.setSize(medidas.larguraJanela, medidas.alturaJanela);
    this.setLocation(medidas.localXJanela, medidas.localYJanela);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new FlowLayout());
    JLabel titulo = new JLabel("Tabela \n");
    
    this.add(titulo);
    
    this.addTextos(tabela.getExpressaoCompleta().getExpressaoString());
    this.addTabela(tabela);
    this.addBotoes();
    this.setVisible(true);
  }
  
  void addTextos(String expressao){
    this.add(new JLabel("Expressao: "));
    this.add(new JLabel(expressao));
    this.add(new JLabel("Tabela: "));
  }

  void addTabela(Tabela tabela){
    this.tabelaDisplay = new TabelaDisplay(tabela); 

    this.tabelaDisplay.setPreferredSize(new Dimension(medidas.larguraTabelaPrincipal, medidas.alturaTabelaPrincipal)); //setta as dimensões do scrollpane, onde está a tabela

    this.add(this.tabelaDisplay);
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

        //falta: mecanismo de salvar
				// salvarTabela();
      }
  
    });

    this.add(bVoltar);
    this.add(bSalvar);
  }
}