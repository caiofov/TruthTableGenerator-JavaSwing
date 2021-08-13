import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tela extends JFrame{
    JPanel footer = new Footer();
    JPanel header = new JPanel();
    JPanel body = new JPanel();
    JLabel titulo = new JLabel();

    Tela(){
        this.setTitle(medidas.nome);
        this.setSize(medidas.larguraJanela, medidas.alturaJanela);
        this.setLocation(medidas.localXJanela, medidas.localYJanela);
        this.setLayout(new BoxLayout (getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void setTitulo(String texto){
        this.titulo.setText(texto);
        titulo.setFont(medidas.fonteTitulos);
        this.header.add(titulo);    
    }
}
