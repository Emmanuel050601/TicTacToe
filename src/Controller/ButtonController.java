package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author luisb
 */

public class ButtonController implements ActionListener{
    
    private static int jugador;
    private static int modo;
    private static JButton cas1, cas2, cas3;
    private static JButton cas4, cas5, cas6;
    private static JButton cas7, cas8, cas9;
    private static JLabel juega;
    private String c1, c2, c3, c4, c5, c6, c7, c8, c9;
    private int estado;
    private String mensaje;
    private Random r;
    private boolean valido;
    
    public ButtonController(JButton cas1, JButton cas2, JButton cas3, 
                             JButton cas4, JButton cas5, JButton cas6, 
                             JButton cas7, JButton cas8, JButton cas9, 
                             JLabel juega) {
        this.cas1 = cas1;
        this.cas2 = cas2;
        this.cas3 = cas3;
        this.cas4 = cas4;
        this.cas5 = cas5;
        this.cas6 = cas6;
        this.cas7 = cas7;
        this.cas8 = cas8;
        this.cas9 = cas9;
        this.juega = juega;
        modo = 1;
        r = new Random();
        jugador = 1;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        accion(boton);   
    }
    
    private void accion(JButton boton){
        if (boton.getText().isEmpty()) {
            if (jugador == 1) {
                boton.setForeground(Color.blue);
                boton.setText("X");
                if (modo == 2) {
                    jugador = 2;
                    juega.setText("Es turno de O");
                }
            }else{
                boton.setForeground(Color.red);
                boton.setText("O");
                juega.setText("Es turno de X");
                jugador = 1;
            }
            estado=comprobarEstado();
            if (modo ==1 && estado==0) {
                jugadaOrdenador();
                estado=comprobarEstado();
            }
            if (estado != 0) finalizarPartida();
        }else
            JOptionPane.showMessageDialog(null,
                                         "Ya hay una ficha en esta casilla.",
                                         "Jugada no valida",
                                         JOptionPane.WARNING_MESSAGE);
    }    
    
    private void textoBotones(){
        c1 = cas1.getText();
        c2 = cas2.getText();
        c3 = cas3.getText();
        c4 = cas4.getText();
        c5 = cas5.getText();
        c6 = cas6.getText();
        c7 = cas7.getText();
        c8 = cas8.getText();
        c9 = cas9.getText();        
    }
    
    private int comprobarEstado() {
        textoBotones();
        if(c1.equals("X") && c2.equals("X") && c3.equals("X") ||
           c4.equals("X") && c5.equals("X") && c6.equals("X") ||
           c7.equals("X") && c8.equals("X") && c9.equals("X") ||  
           c1.equals("X") && c4.equals("X") && c7.equals("X") ||  
           c2.equals("X") && c5.equals("X") && c8.equals("X") || 
           c3.equals("X") && c6.equals("X") && c9.equals("X") || 
           c1.equals("X") && c5.equals("X") && c9.equals("X") || 
           c3.equals("X") && c5.equals("X") && c7.equals("X"))
            return 1;
        else if(c1.equals("O") && c2.equals("O") && c3.equals("O") ||
                c4.equals("O") && c5.equals("O") && c6.equals("O") ||
                c7.equals("O") && c8.equals("O") && c9.equals("O") ||  
                c1.equals("O") && c4.equals("O") && c7.equals("O") ||  
                c2.equals("O") && c5.equals("O") && c8.equals("O") || 
                c3.equals("O") && c6.equals("O") && c9.equals("O") || 
                c1.equals("O") && c5.equals("O") && c9.equals("O") || 
                c3.equals("O") && c5.equals("O") && c7.equals("O"))
            return 2;
        if (c1.isEmpty() || c2.isEmpty() || c3.isEmpty() ||
            c4.isEmpty() || c5.isEmpty() || c6.isEmpty() ||
            c7.isEmpty() || c8.isEmpty() || c9.isEmpty())
            return 0;
        
        return 3;
    }
    
    private void modificaOrd(JButton boton){
        boton.setForeground(Color.red);
        boton.setText("O");
        valido=true;
    }
    
    public void jugadaOrdenador() {
        textoBotones();
        valido=false;
        do {
            switch(r.nextInt(9)) {
                case 1: if (c1.isEmpty()) modificaOrd(cas1); break;
                case 2: if (c2.isEmpty()) modificaOrd(cas2); break;
                case 3: if (c3.isEmpty()) modificaOrd(cas3); break;
                case 4: if (c4.isEmpty()) modificaOrd(cas4); break;
                case 5: if (c5.isEmpty()) modificaOrd(cas5); break;
                case 6: if (c6.isEmpty()) modificaOrd(cas6); break;
                case 7: if (c7.isEmpty()) modificaOrd(cas7); break;
                case 8: if (c8.isEmpty()) modificaOrd(cas8); break;
                case 9: if (c9.isEmpty()) modificaOrd(cas9); break;
            }
        }while(!valido);
    }
    
    private void finalizarPartida() {
        switch(estado) {
            case 1: mensaje="El jugador X gana la partida!"; break;
            case 2: mensaje="El jugador O gana la partida!"; break;
            case 3: mensaje="Partida en tablas!"; break;
        }
        int respuesta = JOptionPane.showConfirmDialog(null,
                        mensaje + "\n¿Quiere jugar de nuevo?", "Fin de partida",
                        JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_NO_OPTION) reiniciar();
        else System.exit(0);
    }
    
    public static void setModo(int m){
        modo = m;
        reiniciar();
    }
    
    protected static void setJugador(int j){
        jugador = j;
    }
    
    private static void reiniciar(){
        jugador = 1;
        new ControllerOptions(cas1, cas2, cas3, cas4, cas5, 
                              cas6, cas7, cas8, cas9, juega).reiniciar();
    }
}
