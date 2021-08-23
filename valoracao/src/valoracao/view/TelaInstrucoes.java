package valoracao.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.BoxLayout;


public class TelaInstrucoes extends Tela {
    
    
    public TelaInstrucoes(){
        this.setTitulo("Instruções");
        
        this.body.setLayout(new BoxLayout (this.body, BoxLayout.Y_AXIS));

        
        this.adicionarInstrucoes();
        this.adicionarBotoes();

        this.add(this.header);
        this.add(this.body);
        this.add(this.footer);

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

        this.body.add(bVoltar);
    }

    public void adicionarInstrucoes(){
        this.body.add(new JLabel("1. Insira a expressão desejada na página inicial"));
        this.body.add(new JLabel("2. Submeta a expressão para gerar a tabela"));
        this.body.add(new JLabel("3. Você tem a  possibilidade de salvar a tabela gerada clicando na opção “salvar”"));
        this.body.add(new JLabel("4. Para inserir uma nova expressão, clique em “voltar”"));
        this.body.add(new JLabel("5. Caso a expressão seja inválida, verifique se ela segue o padrão de expressões lógicas"));
    }
}
