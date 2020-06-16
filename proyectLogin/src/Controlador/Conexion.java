/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class Conexion {

    public static final String URL = "jdbc:mysql://localhost:3306/login";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "";

    public static PreparedStatement ps;
    public static ResultSet resultado;

    public static Connection getConection() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("conexión exitosa");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conexion;
    }

}
