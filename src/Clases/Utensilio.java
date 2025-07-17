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

    public static void add(Utensilio utensilio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  public int id, cantidad, fkcocina;
  public String nombre, tipo, descripcion;


    public Utensilio(int id, int cantidad, String nombre, String tipo, int fkcocina, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.fkcocina = fkcocina;
        this.descripcion = descripcion;
    }
    
      public Utensilio(String nombre, int cantidad, String tipo, int fkcocina, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.fkcocina = fkcocina;
        this.descripcion = descripcion;
    }

         public static void Utensilio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFkcocina() {
        return fkcocina;
    }

    public void setFkcocina(int fkcocina) {
        this.fkcocina = fkcocina;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
      
    
    public boolean guardar(){
        try{ 
             Conexion conexion = new Conexion();
            Connection con = conexion.con;
            //Connection con = Conexion.getConexion();
            String sql = "INSERT INTO utensilios (nombre_utensilio, cantidad, tipo, fkcocina, descripcion) VALUES (?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nombre);
                 ps.setInt(2, cantidad);
                  ps.setString(3, tipo);
                   ps.setInt(4, fkcocina);
                   ps.setString(5, descripcion);
                   
                   ps.executeUpdate();
                   
                   return true;
                   }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guardar" +e.getMessage());
            return false;
        
        }}

   

    
    
    
    
}
