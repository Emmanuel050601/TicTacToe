package Controller;

import static Controller.ButtonController.setJugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author luisb
 */

public class ControllerOptions implements ActionListener{
    private JButton cas1, cas2, cas3;
    private JButton cas4, cas5, cas6;
    private JButton cas7, cas8, cas9;
    private JLabel turno;

    public ControllerOptions(){}
    
    public ControllerOptions(JButton cas1, JButton cas2, JButton cas3, 
                             JButton cas4, JButton cas5, JButton cas6, 
                             JButton cas7, JButton cas8, JButton cas9, 
                             JLabel turno) {
        this.cas1 = cas1;
        this.cas2 = cas2;
        this.cas3 = cas3;
        this.cas4 = cas4;
        this.cas5 = cas5;
        this.cas6 = cas6;
        this.cas7 = cas7;
        this.cas8 = cas8;
        this.cas9 = cas9;
        this.turno = turno;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String ex = e.getActionCommand();
        if(ex.equals("Acerca de")) acerca();
        else if(ex.equals("Reiniciar")) reiniciar();
        else salir();
    }
    
    private void acerca(){
        JOptionPane.showMessageDialog(null,
                                      "Jueguito creado por El mero mero.",
                                      "Acerca de",
                                      JOptionPane.INFORMATION_MESSAGE);        
    }
    
    private void salir(){ System.exit(0); }
    
    protected void reiniciar(){
        cas1.setText("");
        cas2.setText("");
        cas3.setText("");
        cas4.setText("");
        cas5.setText("");
        cas6.setText("");
        cas7.setText("");
        cas8.setText("");
        cas9.setText("");
        turno.setText("Es turno de X");
        setJugador(1);
    }
}
