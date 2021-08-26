package valoracao.view;

import javax.swing.JLabel;

//Cria JLabel personalizado (fonte e cor)
public class LabelPadrao extends JLabel{
    LabelPadrao(String texto){
        this.setForeground(medidas.corTexto);
        this.setFont(medidas.fonteTextos);
        this.setText(texto);
    }
}
