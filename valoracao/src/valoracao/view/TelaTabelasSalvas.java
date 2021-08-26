package valoracao.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

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
        
    
        bVoltar.addActionListener(new ActionListener() {
    
            public void actionPerformed(ActionEvent e){
                new TelaInicial();
                dispose();
                System.out.println("Retornando ao início...");
                //ao clicar, volta para a tela de início
            }
        });
        this.bodyPosTabelas.add(bVoltar);
        
        if(this.leitor.getLista().size() > 0){ //se houver tabelas salvas
            this.addBotaoExcluir(); //adiciona o botão de excluir tabelas
        }
    }

    public void exibirTabelas() {
        ArrayList<Tabela> listaTabelas = leitor.getLista();
        int count=1;

        if(listaTabelas.size()==0){
          this.bodyTabelasPanel.add(new JLabel("Não há tabelas a exibir"));
        }
        else{
          for (Tabela tabela : listaTabelas) {
            System.out.println(" - - - Tabela "+ count +" :");
            tabela.mostrar();
            
            int tam = tabela.getCabecalho().size();
            String expressao = tabela.getCabecalho().get(tam - 1).getNome();
            TabelaDisplay tabView = new TabelaDisplay(tabela, "Tabela "+ count + " : " + expressao);

            int tabHeight = tabela.ndois * 27;
            if (tabHeight > 200){tabHeight = 200;}
            tabView.setPreferredSize(new Dimension(250, tabHeight));
            this.bodyTabelasPanel.add(tabView);

            count++;
          }
        }
        
        
    }

    private void addBotaoExcluir(){
        Botao bExcluirTabela = new Botao("Excluir Tabela");

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
                    TelaTabelasSalvas.this.dispose();
                    new TelaTabelasSalvas();
                }
            }
        });

        this.bodyPosTabelas.add(bExcluirTabela);
    }

    private void mostrarLayout(){ //para testes
        this.bodyTabelasScroll.setBorder(BorderFactory.createTitledBorder("Tabelas"));
        this.bodyPosTabelas.setBorder(BorderFactory.createTitledBorder("Pos tabelas"));
        this.mostrarLayoutPrincipal();
    }
}
