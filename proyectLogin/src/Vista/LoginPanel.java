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
import javax.swing.JTextField;

/**
 *
 * @author jorge
 */
public class LoginPanel extends JPanel {

    //campos de texto para login
    public static JTextField User, password;
    //botones de ingreso o crear usuario
    public static JButton Login, CreateUser;
    //titulo Login
    private JLabel Title;

    public LoginPanel() {
        //inicialización de variables
        User = new JTextField();
        password = new JTextField();

        Login = new JButton("Login");
        CreateUser = new JButton("Create user");

        Title = new JLabel("Login");
        //ajustes del titulo
        Title.setBounds(95, 80, 200, 40);
        Title.setForeground(Color.black);
        Title.setBackground(Color.GRAY);
        Title.setFont(new Font("Verdana", Font.BOLD, 30));
        //asignación y ajuste de tamaño y posición de los campos de texto
        User.setBounds(30, 150, 220, 30);
        password.setBounds(30, 200, 220, 30);
        //asigniacion y ajuste de tamaño y posición de los botones
        Login.setBounds(70, 250, 150, 30);
        Login.setBackground(Color.blue);
        Login.setForeground(Color.white);
        CreateUser.setBounds(70, 300, 150, 30);
        CreateUser.setBackground(Color.green);
        CreateUser.setForeground(Color.white);
        //agregar los objetos al panel
        add(Title);
        add(User);
        add(password);
        add(Login);
        add(CreateUser);
    }
}
