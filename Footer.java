
import javax.swing.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;

public class Footer extends JPanel {
    JLabel ccLabel, ufcLabel;
    
    
    Footer(){
        
        //redimensionando imagem UFC
        ImageIcon ufcIcon = new ImageIcon("img/ufchorizontal.png");
        Image ufcImg = ufcIcon.getImage();
        Image newUfcImg = ufcImg.getScaledInstance(120, 30,  java.awt.Image.SCALE_SMOOTH);
        ufcIcon = new ImageIcon(newUfcImg);
        
        //redimensionando imagem CC
        ImageIcon ccIcon = new ImageIcon("img/cc.png");
        Image ccImg = ccIcon.getImage();
        Image newCcImg = ccImg.getScaledInstance(120, 30,  java.awt.Image.SCALE_SMOOTH);
        ccIcon = new ImageIcon(newCcImg);
        
        //criando os labels com as imagens
        this.ccLabel = new JLabel(ccIcon);
        this.ufcLabel = new JLabel(ufcIcon);
        
        //adicionando no footer
        this.add(ufcLabel);
        this.add(ccLabel);
        
        //alguns ajustes de posição de tamanho
        this.setPreferredSize(new Dimension(-1, 0));
        this.setLocation(0,medidas.alturaJanela+500);
        
        //para testes:
        // this.setBorder(BorderFactory.createTitledBorder("Footer"));
         

        
    }
    
}
