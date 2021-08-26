package valoracao.view;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JPanel;

import valoracao.view.LabelPadrao;


public class TelaInstrucoes extends Tela {
    JPanel bodyTop = new JPanel();
    JPanel bodyBottom = new JPanel();
    public TelaInstrucoes(){
        this.setTitulo("Instruções");
        
        this.adicionarInstrucoes();
        this.adicionarBotoes();

        this.bodyTop.setLayout(new BoxLayout (this.bodyTop, BoxLayout.Y_AXIS));
        this.bodyBottom.setLayout(new BoxLayout (this.bodyBottom, BoxLayout.Y_AXIS));
        this.bodyTop.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.bodyBottom.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        this.body.add(this.bodyTop);
        this.body.add(this.bodyBottom);
        // this.body.setLayout(new BoxLayout (this.body, BoxLayout.Y_AXIS));
        // this.body.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.add(this.header);
        // this.add(this.body);
        this.add(bodyTop);
        this.add(bodyBottom);

        this.setVisible(true);

        // mostrarLayout();

    }

    public void adicionarBotoes(){
        Botao bVoltar = new Botao("Voltar");
        // bVoltar.setAlignmentX(Component.LEFT_ALIGNMENT);
        bVoltar.addActionListener(new ActionListener() {
    
            public void actionPerformed(ActionEvent e){
                new TelaInicial();
                dispose();
                System.out.println("Retornando ao início...");
                //ao clicar, volta para a tela de início
            }
        });

        this.bodyBottom.add(bVoltar);
    }

    public void adicionarInstrucoes(){
        //organizar em um array faz com que uma possível substituição de alguma instrução seja feita mais facilmente
        ArrayList<String> instrucoes = new ArrayList<String>();
        
        //agora, adicionar as instruções ao array
        instrucoes.add(new String("Insira a expressão desejada na página inicial"));
        instrucoes.add(new String("Submeta a expressão para gerar a tabela"));
        instrucoes.add(new String("Você tem a  possibilidade de salvar a tabela gerada clicando na opção “salvar”"));
        instrucoes.add(new String("Para inserir uma nova expressão, clique em “voltar”"));
        instrucoes.add(new String("Caso a expressão seja inválida, verifique se ela segue o padrão de expressões lógicas"));
    
        
        int count = 1; //número de cada instrução
        
        for (String inst : instrucoes) {
            LabelPadrao instrucao = new LabelPadrao("<html><font color='#731702'><b>"+count+" - </b></font>"+inst+"</html>");
            // instrucao.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.bodyTop.add(instrucao);
            this.bodyTop.add(Box.createRigidArea(new Dimension(0, 8))); //espaçamento entre as instruções
            count++;
        }
    }

    private void mostrarLayout(){
        this.mostrarLayoutPrincipal();
        this.bodyBottom.setBorder(BorderFactory.createTitledBorder("Body Bottom"));
        this.bodyTop.setBorder(BorderFactory.createTitledBorder("Body Top"));
    }
}
