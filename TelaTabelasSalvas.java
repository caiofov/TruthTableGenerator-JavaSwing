import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaTabelasSalvas extends Tela {
    
    TelaTabelasSalvas(){
        this.setTitulo("Tabelas Salvas");
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
    }
}
