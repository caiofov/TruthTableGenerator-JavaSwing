import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.util.ArrayList;

public class TelaInstrucoes extends Tela {
    
    
    TelaInstrucoes(){
        this.setTitulo("Instruções");
        
        this.adicionarInstrucoes();
        this.adicionarBotoes();

        this.add(this.header);
        this.add(this.body);
        this.add(this.footer);

        this.setVisible(true);

    }

    void adicionarBotoes(){
        Botao bVoltar = new Botao("Voltar");
        bVoltar.addActionListener(new ActionListener() {
    
            public void actionPerformed(ActionEvent e){
                TelaInicial inicio = new TelaInicial();
                dispose();
                System.out.println("Retornando ao início...");
                //ao clicar, volta para a tela de início
            }
        });

        this.body.add(bVoltar);
    }

    void adicionarInstrucoes(){
        JLabel instrucoes = new JLabel("1.Aaa\n2.bbbb\n3.ccc");
        this.body.add(instrucoes);
    }
}
