package Clases;


import Clases.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click pnbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cris Castro
 */
public class Utensilio {

   // public static void addItem(Utensilio utensilio) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    private int id;
    private String nombre;
    private int cantidad;
    private String tipo;
    private String cocina;


    public Utensilio(int id,String nombre, int cantidad, String tipo, String cocina) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.cocina = cocina;
    }

   // public Utensilio(int id, String nombre, String tipo, String cocina) {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}

    //public Utensilio(String nombre, int cantidad, String tipo, String cocina) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}
    
    
        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCocina() {
        return cocina;
    }

    public void setCocina(String cocina) {
        this.cocina = cocina;
    }
    
    public boolean guardar(){
        try{ 
             Conexion conexion = new Conexion();
            Connection con = conexion.con;
            //Connection con = Conexion.getConexion();
            String sql = "INSERT INTO utensilios (nombre, cantidad, tipo, cocina) VALUES (?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nombre);
                 ps.setInt(2, cantidad);
                  ps.setString(3, tipo);
                   ps.setString(4, cocina);
                   
                   ps.executeUpdate();
                   
                   return true;
                   }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guardar" +e.getMessage());
            return false;
        
        }}

    @Override
    public String toString() {
        return nombre.toString();
    }

    
    
    
    
}
