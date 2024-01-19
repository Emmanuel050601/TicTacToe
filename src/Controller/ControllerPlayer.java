package Controller;

import static Controller.ButtonController.setModo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author luisb
 */

public class ControllerPlayer implements ActionListener{
    
    private final JRadioButtonMenuItem single, multiplayer;
    
    public ControllerPlayer (JRadioButtonMenuItem single, 
                            JRadioButtonMenuItem multiplayer){
        this.single = single;
        this.multiplayer = multiplayer;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String ex = e.getActionCommand();
        if(ex.equals("1 Jugador")){
            single.setSelected(true);
            multiplayer.setSelected(false);
            setModo(1);
        }else{
            multiplayer.setSelected(true);
            single.setSelected(false);
            setModo(2);
        } 
    }
}
