/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Conexion;
import static Controlador.Conexion.getConection;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class LoginFrame extends JFrame implements ActionListener {

    //panel de vista principal login
    private LoginPanel loginPanel;
    //panel de crear usuario
    private CreateUser createUserPanel;
    //panel de vista al ingresar luego del login
    private MainPanel mainPanel;

    public static int validador = 0;

    //clase principal donde se observa el login
    public LoginFrame() throws HeadlessException {

        loginPanel = new LoginPanel();
        loginPanel.setLayout(null);

        createUserPanel = new CreateUser();
        createUserPanel.setLayout(null);

        mainPanel = new MainPanel();
        mainPanel.setLayout(null);
        //tamaño y posición de la ventan
        setBounds(500, 100, 300, 500);
        //permite activar la visualización de la ventana
        setVisible(true);
        //inserción del panel en la ventana
        setContentPane(loginPanel);
        //titulo de la ventan
        setTitle("Login");
        //bloquea el escalamiento de la ventana
        setResizable(false);
        //al presionar en la X se desactiva la compilación
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        useButton();
    }

    public void useButton() {
        loginPanel.Login.addActionListener(this);
        loginPanel.CreateUser.addActionListener(this);
        createUserPanel.back.addActionListener(this);
        mainPanel.exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginPanel.Login)) {
            btnLogin(e);
        } else {
            if (e.getSource().equals(loginPanel.CreateUser)) {
                setContentPane(createUserPanel);
                revalidate();
            } else {
                if (e.getSource().equals(createUserPanel.back) || e.getSource().equals(mainPanel.exit)) {
                    setContentPane(loginPanel);
                    revalidate();
                }
            }
        }
    }

    public void btnLogin(java.awt.event.ActionEvent evt) {

        Connection conexion = null;
        try {
            conexion = getConection();

            Conexion.ps = conexion.prepareStatement("SELECT `USER`, `PASSWORD` FROM login WHERE `USER` = ? AND `PASSWORD` = ?");
            Conexion.ps.setString(1, LoginPanel.User.getText());
            Conexion.ps.setString(2, loginPanel.password.getText());

            Conexion.resultado = Conexion.ps.executeQuery();

            if (Conexion.resultado.next()) {
                setContentPane(mainPanel);
                revalidate();
            } else {
                JOptionPane.showMessageDialog(null, "Por favor verifique los datos");
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
