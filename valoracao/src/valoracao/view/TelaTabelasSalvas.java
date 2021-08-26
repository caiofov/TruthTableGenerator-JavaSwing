package valoracao.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import valoracao.controller.LeTabelas;
import valoracao.controller.ExcluirTabela;
import valoracao.view.TabelaDisplay;
import valoracao.model.Tabela;



public class TelaTabelasSalvas extends Tela {
    JPanel bodyPosTabelas = new JPanel();
    JPanel bodyTabelasPanel = new JPanel();
    JScrollPane bodyTabelasScroll = new JScrollPane();
    LeTabelas leitor = new LeTabelas();
    
    
    public TelaTabelasSalvas(){
        this.setTitulo("Tabelas Salvas");
        
        this.exibirTabelas();
        this.adicionarBotoes();
        
        this.bodyTabelasScroll.getViewport().add(bodyTabelasPanel);
        this.bodyTabelasScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        this.body.add(this.bodyTabelasScroll);
        this.body.add(this.bodyPosTabelas);
        
        this.add(this.header);
        this.add(this.body);
        
        this.body.setLayout(new BoxLayout(this.body, BoxLayout.Y_AXIS ));
        this.setVisible(true);
    }

    
    
    public void adicionarBotoes(){
        Botao bVoltar = new Botao("Voltar");
        Botao bExcluirTabela = new Botao("Excluir Tabela");
    
        bVoltar.addActionListener(new ActionListener() {
    
            public void actionPerformed(ActionEvent e){
                new TelaInicial();
                dispose();
                System.out.println("Retornando ao início...");
                //ao clicar, volta para a tela de início
            }
        });

        bExcluirTabela.addActionListener(new ActionListener() {
    
            public void actionPerformed(ActionEvent e){
                System.out.println("Abrindo opções de exclusão de tabela...");

				        ArrayList<Tabela> lista = leitor.getLista();
                
                String num_tabela = (String)JOptionPane.showInputDialog(null, "Qual tabela deseja excluir? ", "Excluir Tabela", JOptionPane.QUESTION_MESSAGE, null, null, "Digite o número da tabela");
                
                int x = Integer.parseInt(num_tabela) - 1;
                if(x < 0 || x > lista.size()-1){
                    System.out.println("Insira um número válido");
                    //Alterar a borda da caixa de input e adicionar a mensagem de erro
                }
                else{
                    ExcluirTabela exc = new ExcluirTabela(lista, x);
                
                    exc.excluirTab();
                    
                    // ATUALIZAR A TELA DE TABELAS SALVAS...
                    leitor = new LeTabelas();
                    //bodyTabelasPanel.revalidate();
                    //bodyTabelasPanel.repaint();
                    TelaTabelasSalvas.this.dispose();
                    new TelaTabelasSalvas();
                }
            }
        });

        this.bodyPosTabelas.add(bVoltar);
        this.bodyPosTabelas.add(bExcluirTabela);
        
    }

    public void exibirTabelas() {

        ArrayList<Tabela> listaTabelas = leitor.getLista();
        int count=1;

        if(listaTabelas.size()==0){
          this.bodyTabelasPanel.add(new JLabel("Não há tabelas a exibir"));
        }
        else{
          for (Tabela tabela : listaTabelas) {
            System.out.println(" - - - Tabela "+count+" :");
            tabela.mostrar();
            TabelaDisplay tabView = new TabelaDisplay(tabela, "Tabela "+count);

            this.bodyTabelasPanel.add(tabView);

            count++;
          }
        }
        
        
    }

    public void mostrarLayout(){
        this.bodyTabelasScroll.setBorder(BorderFactory.createTitledBorder("Tabelas"));
        this.bodyPosTabelas.setBorder(BorderFactory.createTitledBorder("Pos tabelas"));
        this.mostrarLayoutPrincipal();
    }

}
