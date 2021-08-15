package valoracao.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


public class TelaTabelasSalvas extends Tela {
    JPanel bodyPosTabelas = new JPanel();
    JPanel bodyTabelasPanel = new JPanel();
    JScrollPane bodyTabelasScroll = new JScrollPane();
    LeTabelas leitor = new LeTabelas();
    
    
    TelaTabelasSalvas(){
        this.setTitulo("Tabelas Salvas");
        
        this.exibirTabelas();
        this.adicionarBotoes();
        
        this.bodyTabelasScroll.getViewport().add(bodyTabelasPanel);

        this.body.add(this.bodyTabelasScroll);
        this.body.add(this.bodyPosTabelas);
        
        this.add(this.header);
        this.add(this.body);
        this.add(this.footer);
        
        this.mostrarLayout(); //para testes
        this.body.setLayout(new BoxLayout(this.body, BoxLayout.Y_AXIS ));
        this.setVisible(true);
    }

    
    
    void adicionarBotoes(){
        Botao bVoltar = new Botao("Voltar");
        Botao bExcluirTabela = new Botao("Excluir Tabela");
    
        bVoltar.addActionListener(new ActionListener() {
    
            public void actionPerformed(ActionEvent e){
                TelaInicial inicio = new TelaInicial();
                dispose();
                System.out.println("Retornando ao início...");
                //ao clicar, volta para a tela de início
            }
        });

        bExcluirTabela.addActionListener(new ActionListener() {
    
            public void actionPerformed(ActionEvent e){
                //LeTabelas leitor = new LeTabelas();
                
                String num_tabela = (String)JOptionPane.showInputDialog(null, "Qual tabela deseja excluir? ", "Excluir Tabela", JOptionPane.QUESTION_MESSAGE, null, null, "Digite o número da tabela");
                int x = Integer.parseInt(num_tabela);
                leitor.getLista().remove(x);
                
                //TelaTabelasSalvas teste = new TelaTabelasSalvas();
                //exibirTabelas();
                //ArrayList<Tabela> x = leitor.getLista();
                //leitor.setListaTabs() = x.remove(num_tabela);
                
                System.out.println("Abrindo opções de exclusão de tabela...");
            }
        });

        this.bodyPosTabelas.add(bVoltar);
        this.bodyPosTabelas.add(bExcluirTabela);
        
    }

    void exibirTabelas() {

        //LeTabelas leitor = new LeTabelas();
        ArrayList<Tabela> listaTabelas = leitor.getLista();
        int count=1;
        
        for (Tabela tabela : listaTabelas) {
            TabelaDisplay tabView = new TabelaDisplay(tabela, "Tabela"+count);
            // JLabel tituloTabela = new JLabel("Tabela "+count);
            // JPane areaTabela
            // this.bodyTabelas.add(tituloTabela);
            this.bodyTabelasPanel.add(tabView);

            count++;
        }
        

    }

    void mostrarLayout(){
        this.bodyTabelasScroll.setBorder(BorderFactory.createTitledBorder("Tabelas"));
        this.bodyPosTabelas.setBorder(BorderFactory.createTitledBorder("Pos tabelas"));
        this.mostrarLayoutPrincipal();
    }

}
