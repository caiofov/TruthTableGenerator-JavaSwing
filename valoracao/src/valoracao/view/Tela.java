package valoracao.view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tela extends JFrame{
    // JPanel footer = new Footer();
    JPanel header = new JPanel();
    JPanel body = new JPanel();
    JLabel titulo = new JLabel();

    public Tela(){
        this.setTitle(medidas.nome);
        this.setSize(medidas.larguraJanela, medidas.alturaJanela);
        this.setLocation(medidas.localXJanela, medidas.localYJanela);
        this.setLayout(new BoxLayout (getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setTitulo(String texto){
        this.titulo.setText(texto);
        this.titulo.setFont(medidas.fonteTitulos);
        this.titulo.setAlignmentX(CENTER_ALIGNMENT);
        this.titulo.setForeground(medidas.corTitulo); 
        this.header.add(titulo);
        
    }

    public void mostrarLayoutPrincipal(){ //para testes
        this.body.setBorder(BorderFactory.createTitledBorder("Body"));
        this.header.setBorder(BorderFactory.createTitledBorder("Header"));
    }
}
