/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Conexion;
import java.sql.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jorge
 */
public class CreateUser extends JPanel {

    //cuadros de texto
    private JTextField name, lastName, user, password;
    //botones
    private JButton create;
    public static JButton back;
    //tutilo principal
    private JLabel Title;
    //titulo de los cuadros de texto
    private JLabel nameLabel, lastNameLabel, userLabel, passwordLabel;

    public CreateUser() {
        //inicializacion de variables
        Title = new JLabel("Create user");
        nameLabel = new JLabel("Name");
        lastNameLabel = new JLabel("last name");
        userLabel = new JLabel("user");
        passwordLabel = new JLabel("password");

        name = new JTextField();
        lastName = new JTextField();
        user = new JTextField();
        password = new JTextField();

        create = new JButton("Create");
        back = new JButton("Back");
        //asignación de hubicación de los componentes
        Title.setBounds(75, 40, 200, 40);
        nameLabel.setBounds(30, 70, 200, 40);
        lastNameLabel.setBounds(30, 120, 200, 40);
        userLabel.setBounds(30, 170, 200, 40);
        passwordLabel.setBounds(30, 220, 200, 40);
        //cambio de color de letra, fuente y tamaño
        Title.setForeground(Color.black);
        Title.setBackground(Color.GRAY);
        Title.setFont(new Font("Verdana", Font.BOLD, 20));
        //asignar posición y tamaño de los campos de texto
        name.setBounds(30, 100, 220, 30);
        lastName.setBounds(30, 150, 220, 30);
        user.setBounds(30, 200, 220, 30);
        password.setBounds(30, 250, 220, 30);
        //asignación de tamaños y posición de los botones
        create.setBounds(70, 300, 150, 30);
        create.setBackground(Color.blue);
        create.setForeground(Color.white);
        back.setBounds(70, 350, 150, 30);
        back.setBackground(Color.red);
        back.setForeground(Color.white);
        //agregar los objetos al panel
        add(Title);
        add(nameLabel);
        add(lastNameLabel);
        add(userLabel);
        add(passwordLabel);

        add(name);
        add(lastName);
        add(user);
        add(password);

        add(create);
        add(back);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnGuardarActionPerformance(e);
            }
        });
    }

    private void cleanTextBox() {
        name.setText(null);
        lastName.setText(null);
        user.setText(null);
        password.setText(null);
    }

    public void btnGuardarActionPerformance(java.awt.event.ActionEvent evt) {

        Connection conexion = null;

        try {

            conexion = Conexion.getConection();
            Conexion.ps = conexion.prepareStatement("SELECT `USER` FROM login WHERE `USER` = ?");
            Conexion.ps.setString(1, user.getText());
            Conexion.resultado = Conexion.ps.executeQuery();

            if (Conexion.resultado.next()) {
                JOptionPane.showMessageDialog(null, "Por favor verifique los datos");
            } else {
                Conexion.ps = conexion.prepareStatement("INSERT INTO login(`USER`, `PASSWORD`, `NAME`, `LAST NAME`) VALUES (?,?,?,?)");
                Conexion.ps.setString(1, user.getText());
                Conexion.ps.setString(2, password.getText());
                Conexion.ps.setString(3, name.getText());
                Conexion.ps.setString(4, lastName.getText());

                int resp = Conexion.ps.executeUpdate();
                if (resp > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
                    LoginFrame.validador = 2;
                    cleanTextBox();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor revise sus datos");
                }
            }

            conexion.close();

        } catch (Exception e) {

            System.out.println(e);

        }

    }
}
