package View;

import Controller.ButtonController;
import Controller.ControllerOptions;
import Controller.ControllerPlayer;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.BOLD;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author luisb
 */

public class GUI {
   private final JFrame ventana;
   private final JPanel panel;
   private final JLabel titulo1, juega;
   private final JButton cas1, cas2, cas3;
   private final JButton cas4, cas5, cas6;
   private final JButton cas7, cas8, cas9;
   private final JMenuBar menuGral;
   private final JMenu menuPartida, menuOpciones;
   private final JRadioButtonMenuItem single, multiplayer;
   private final JMenuItem btnAcerca, btnReiniciar, btnSalir;
   private final ControllerPlayer modo;
   private final ButtonController juego;
   
   public GUI(){
       ventana = new JFrame("TIC TAC TOE");
       panel = new JPanel ();
       titulo1 = new JLabel("TIC-TAC-TOE");
       juega = new JLabel("Es turno de X");
       cas1 = new JButton();
       cas2 = new JButton();
       cas3 = new JButton();
       cas4 = new JButton();
       cas5 = new JButton();
       cas6 = new JButton();
       cas7 = new JButton();
       cas8 = new JButton();
       cas9 = new JButton();
       menuGral = new JMenuBar();
       menuPartida = new JMenu("Partida");
       menuOpciones = new JMenu("Opciones");
       single = new JRadioButtonMenuItem("1 Jugador");
       multiplayer = new JRadioButtonMenuItem("2 Jugadores");
       btnAcerca = new JMenuItem ("Acerca de");
       btnReiniciar = new JMenuItem ("Reiniciar");
       btnSalir = new JMenuItem("Salir");
       modo = new ControllerPlayer(single, multiplayer);
       juego = new ButtonController(cas1, cas2, cas3,cas4, cas5, cas6,
                                    cas7, cas8, cas9, juega);
   }
   
   private void configuraVentana(){
       ventana.setSize(350, 450);
       ventana.setLocationRelativeTo(null);
       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   private void configuraPanel(){
       panel.setBounds(0, 0, 150, 150);
       panel.setBackground(new Color(70,130,180));
       panel.setLayout(null);
       titulo1.setBounds(105, 20, 120, 80);
       titulo1.setFont(new Font("TIMES NEW ROMAN", BOLD, 18));
       juega.setBounds(120, 60, 100,40);
   }
   
   private void configuraBtnMenu(){
       single.setIcon(new ImageIcon("src/Icon/Male.png"));
       multiplayer.setIcon(new ImageIcon("src/Icon/People.png"));
       btnAcerca.setIcon(new ImageIcon("src/Icon/About.png"));
       btnReiniciar.setIcon(new ImageIcon("src/Icon/Refresh.png"));
       btnSalir.setIcon(new ImageIcon("src/Icon/Exit.png"));
       single.setSelected(true);
       single.addActionListener(modo);
       multiplayer.addActionListener(modo);
       btnAcerca.addActionListener(new ControllerOptions());
       btnReiniciar.addActionListener(new ControllerOptions(cas1, cas2, cas3,
                                                        cas4, cas5, cas6, cas7, 
                                                        cas8, cas9,juega));
       btnSalir.addActionListener(new ControllerOptions());
   }
   
   private void configuraMenu(){
       configuraBtnMenu();
       menuGral.setBounds(0,0,350,30);
       menuPartida.setIcon(new ImageIcon("src/Icon/Component.png"));
       menuOpciones.setIcon(new ImageIcon("src/Icon/Application.png"));
       menuPartida.add(single);
       menuPartida.add(multiplayer);
       menuOpciones.add(btnAcerca);
       menuOpciones.add(btnReiniciar);
       menuOpciones.add(btnSalir);
       menuGral.add(menuPartida);
       menuGral.add(menuOpciones);
   }
   
   private void posicionBtn(){     
       cas1.setBounds(70,110,60,60);
       cas2.setBounds(135,110,60,60);
       cas3.setBounds(200,110,60,60);
       cas4.setBounds(70,175,60,60);
       cas5.setBounds(135,175,60,60);
       cas6.setBounds(200,175,60,60);
       cas7.setBounds(70,240,60,60);
       cas8.setBounds(135,240,60,60);
       cas9.setBounds(200,240,60,60);
   }
   
   private void accionesBtn(){
       cas1.addActionListener(juego);
       cas2.addActionListener(juego);
       cas3.addActionListener(juego);
       cas4.addActionListener(juego);
       cas5.addActionListener(juego);
       cas6.addActionListener(juego);
       cas7.addActionListener(juego);
       cas8.addActionListener(juego);
       cas9.addActionListener(juego);
   }
   
   private void tamañoBtn(){
       cas1.setFont(new Font("ARIAL", 1, 26));
       cas2.setFont(new Font("ARIAL", 1, 26));
       cas3.setFont(new Font("ARIAL", 1, 26));
       cas4.setFont(new Font("ARIAL", 1, 26));
       cas5.setFont(new Font("ARIAL", 1, 26));
       cas6.setFont(new Font("ARIAL", 1, 26));
       cas7.setFont(new Font("ARIAL", 1, 26));
       cas8.setFont(new Font("ARIAL", 1, 26));
       cas9.setFont(new Font("ARIAL", 1, 26));    
   }
   
   private void configuraBoton(){
       posicionBtn();
       accionesBtn();
       tamañoBtn();
   }
   
   private void agregarComponente(){
       panel.add(menuGral);
       panel.add(titulo1);
       panel.add(juega);
       panel.add(cas1);
       panel.add(cas2);
       panel.add(cas3);
       panel.add(cas4);
       panel.add(cas5);
       panel.add(cas6);
       panel.add(cas7);
       panel.add(cas8);
       panel.add(cas9);
       
       ventana.add(panel);
       ventana.setVisible(true);
   }
   
   public void run(){
       configuraVentana();
       configuraPanel();
       configuraMenu();
       configuraBoton();
       agregarComponente();
   }  
}
