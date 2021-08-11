import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

//definindo estilo para os nossos botoes
class Botao extends JButton{
  
  Botao(String label){
    
    this.setText(label);

    this.setBackground(medidas.corCinza);
    this.setForeground(medidas.corBranca);

    this.setBorderPainted(false); //tira a borda
    this.setFocusPainted(false); //tira a marcação de foco padrão
    
    this.addMouseListener(new MouseAdapter() {

      //quando o mouse estiver por cima, irá mudar a cor
      public void mouseEntered(MouseEvent evt) {
        setBackground(medidas.corBranca);
        setForeground(medidas.corPreta);
        new Cursor(Cursor.HAND_CURSOR);

        // setBorderPainted(true); //adicionar borda
        // setBorder(new LineBorder(medidas.corPreta)); 
        // setContentAreaFilled(true); //quando adiciona a borda, ele reduz o tamanho da caixa do botão. Precisamos chamar esse método para isso não acontecer

        //falta:
        //ver se é possível efeito de sombra
        //pode mudar o mouse para a mãozinha
      }
     
      //quando o mouse sair, volta para as configurações iniciais
      public void mouseExited(MouseEvent evt) {
        setBackground(medidas.corCinza);
        setForeground(medidas.corBranca);
        setBorderPainted(false);
      }
    });
  }
  
}