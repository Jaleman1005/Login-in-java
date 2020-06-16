/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jorge
 */
public class MainPanel extends JPanel{
    //label de mensaje al ingresar
    private JLabel message;
    //boton de salir
    public static JButton exit;
    
    public MainPanel() {
        //inicialización de variables
        message = new JLabel("Congratulation");
        
        exit = new JButton("Exit");
        //ajuste de posición, tamaño y fuente del label
        message.setBounds(70, 90, 200, 30);
        message.setFont(new Font("Verdana", Font.BOLD, 17));
        //ajuste de tamaño y posición del boton de salida
        exit.setBounds(70, 300, 150, 30);
        exit.setBackground(Color.red);
        exit.setForeground(Color.white);
        //agregar los objetos al panel
        add(message);
        add(exit);
    }
}
