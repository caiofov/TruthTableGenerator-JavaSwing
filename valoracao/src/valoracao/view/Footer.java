package valoracao.view;

import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Footer extends JPanel {
    JLabel ccLabel, ufcLabel;
    
    
    public Footer(){
        
        //redimensionando imagem UFC
        ImageIcon ufcIcon = new ImageIcon("./assets/ufchorizontal.png");
        Image ufcImg = ufcIcon.getImage();
        Image newUfcImg = ufcImg.getScaledInstance(200, 50,  java.awt.Image.SCALE_SMOOTH);
        ufcIcon = new ImageIcon(newUfcImg);
        
        //redimensionando imagem CC
        ImageIcon ccIcon = new ImageIcon("img/cc.png");
        Image ccImg = ccIcon.getImage();
        Image newCcImg = ccImg.getScaledInstance(200, 50,  java.awt.Image.SCALE_SMOOTH);
        ccIcon = new ImageIcon(newCcImg);
        
        //criando os labels com as imagens
        this.ccLabel = new JLabel(ccIcon);
        this.ufcLabel = new JLabel(ufcIcon);

        //adicionando no footer
        this.add(ufcLabel);
        this.add(ccLabel);
        
        //alguns ajustes de posição de tamanho
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));

        
        //para testes:
        //this.setBorder(BorderFactory.createTitledBorder("Footer"));
         

        
    }
    
}