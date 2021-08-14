import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class TelaTabelasSalvas extends Tela {
    JPanel bodyPosTabelas = new JPanel();
    JPanel bodyTabelas = new JPanel();
    
    
    TelaTabelasSalvas(){
        this.setTitulo("Tabelas Salvas");
        
        this.exibirTabelas();
        this.adicionarBotoes();
        
        this.body.add(this.bodyTabelas);
        this.body.add(this.bodyPosTabelas);
        
        this.add(this.header);
        this.add(this.body);
        this.add(this.footer);
        
        this.mostrarLayout(); //para testes

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
                //abrir popup
                System.out.println("Abrindo opções de exclusão de tabela...");
            }
        });

        this.bodyPosTabelas.add(bVoltar);
        this.bodyPosTabelas.add(bExcluirTabela);
        
    }

    void exibirTabelas(){
        LeTabelas leitor = new LeTabelas();
        ArrayList<Tabela> listaTabelas = leitor.getLista();

        for (Tabela tabela : listaTabelas) {
            TabelaDisplay tabView = new TabelaDisplay(tabela);
            this.bodyTabelas.add(tabView);
            System.out.println(tabView.cabecalho); //não está printando o cabecalho
        }
        

    }

    void mostrarLayout(){
        this.bodyTabelas.setBorder(BorderFactory.createTitledBorder("Tabelas"));
        this.bodyPosTabelas.setBorder(BorderFactory.createTitledBorder("Pos tabelas"));
        this.mostrarLayoutPrincipal();
    }

}
