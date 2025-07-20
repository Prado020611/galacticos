
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.sql.*;
/**
 *
 * @author Cris Castro
 */
public class Conexion {

    public static Connection con() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public Conexion () {
    try {
    Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproyecto", "root", "");
        System.out.println("Conectado");
    } catch (Exception e){
        System.out.println("Error al conectar");// +e.getMessage());
    //con = null;
    }
    }
}

