package Clases;

import Clases.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cris Castro
 */
public class Producto {
    public static void add(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
}
 public int id, cantidad;
  public String nombre, categoria, cocina, descripcion, unidad;


    public Producto(int id, int cantidad, String nombre, String categoria, String cocina, String descripcion, String unidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.cocina = cocina;
        this.descripcion = descripcion;
        this.unidad = unidad;
    }
    
      public Producto(String nombre, int cantidad, String categoria, String cocina, String descripcion, String unidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.cocina = cocina;
        this.descripcion = descripcion;
        this.unidad = unidad;
    }

         public static void Producto() {
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String tipo) {
        this.categoria = categoria;
    }

    public String getCocina() {
        return cocina;
    }

    public void setCocina(String cocina) {
        this.cocina = cocina;
    }
    
     public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
     public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad  = unidad;
    }
      
    
    public boolean guardar(){
        try{ 
             Conexion conexion = new Conexion();
            Connection con = conexion.con;
            //Connection con = Conexion.getConexion();
            String sql = "INSERT INTO productos (nombre, cantidad, categoria, cocina, descripcion, unidad_medida) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nombre);
                 ps.setInt(2, cantidad);
                  ps.setString(3, categoria);
                   ps.setString(4, cocina);
                   ps.setString(5, descripcion);
                   ps.setString(6, unidad);
                   
                   ps.executeUpdate();
                   
                   return true;
                   }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guardar" +e.getMessage());
            return false;
        
        }}

   

    
    
    
    
}
