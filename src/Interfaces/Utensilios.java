/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Cocina;
import Clases.Conexion;
import Clases.Utensilio;
import Interfaces.NuevoUtensilio;
import static java.awt.SystemColor.menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cris Castro
 */
public final class Utensilios extends javax.swing.JFrame {
    
    private static  java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Utensilios.class.getName());
    
    

    /**
     * Creates new form Utensilios
     */
    public Utensilios() {
        initComponents();
      cargarUtensilio();
   }
   // private javax.swing.JTable tabla_uten;
    public void cargarUtensilio(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Tipo");
        modelo.addColumn("Cocina");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Acciones");
        modelo.addColumn("Acciones");
        try{
            Conexion conexion = new Conexion();
            Connection con = conexion.con;
           //SELECT * FROM Utensilios
            String sql = "SELECT u.*, c.nombre AS nom_cocina FROM utensilios u INNER JOIN cocina c ON u.fkcocina = c.id_cocina";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet datos = ps.executeQuery();
            ArrayList<Utensilio> Utensilios = new ArrayList<>();
            
            while(datos.next()){
                int id = datos.getInt("id_utensilio");
                String nombre = datos.getString("nombre_utensilio");
                int cantidad = datos.getInt("cantidad");
                String tipo = datos.getString("tipo");
                int fkcocina = datos.getInt("fkcocina");
                String descripcion = datos.getString("descripcion");
                String nom_cocina = datos.getString("nom_cocina");
                         Cocina cocina = new Cocina(fkcocina, nom_cocina);
                         Utensilio uten = new Utensilio(id, nombre, cantidad, tipo, fkcocina, descripcion);
                
                    modelo.addRow(new Object []{
                    uten.getId(),
                    uten.getNombre(),
                    uten.getCantidad(),
                    uten.getTipo(),
                    nom_cocina,
                    uten.getDescripcion(),
                    "Editar",
                    "Eliminar",
                    });
}
                    datos.close();
                tabla_uten.setModel(modelo);
                
                //
                
                //menu = new JPopupMenu();
                //JMenuItem itemEditar = new JMenuItem("Editar");
                //JMenuItem itemEliminar = new JMenuItem("Eliminar");
                //menu.add(ItemEditar);
                //menu.add(ItemEliminar);
                
                //tabla_uten.addMouseListener(new java.awt.event.MouseAdapter(){
                   // public void mousePressed(java.awt.event.MouseEvent evt){
                        //if (evt.isPopupTrigger() || evt.getButton() == java.awt.event.MouseEvent.BUTTON3){
                          //  int fila = tabla_uten.rowAtPoint(evt.getPoint());
                            //if (fila >= 0){
                              ////menu.show(tabla_uten, evt,getX(), evt.getY());
                            //}
                        //}
              //      }
                    
                //}
                        
                       // public void mouseReleased(java.awt.event.MouseEvent){
                        //mousePressed(evt);

                        //}
                        //));

                        //Editar
                //      int fila = tabla_uten.getSelectedRow();
                  //      if fila >= ){
                    //        Utensilio u = Utensilios.get(fila);
                      //      new NuevoUtensilio(u).setVisible(true);

//}
//};//));

                        //Eliminar

  //                      itemEliminar.addActionListener(e ->{
    //                    int fila = tabla_uten.getSelectedRow();
      //                    Utensilio u = Utensilios.get(fila);
        //                    int respuesta JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar el utensilio?", "Sí", JOptionPane.YES_NO_OPTION );
          //                  if (respuesta == JOption.YES_OPTION){
            //                try{
              //                  PreparedStatement ps2 con.prepareStatement("DELETE FROM utensilios WHERE id=?");
                //                ps2.setInt(1, u.getId());
                  //              ps2.executeUpdate();
                    //            cargarUtensilio();
                      //          }catch(Exception e2){
                        //        JOptionPane.showMessageDialog(null,"Error al guradar"+e2.getMessage());
//}
//}
//}
//});
                //
                
                        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al cargar los datos" +e.getMessage());
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_uten = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        btnMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenu.setText("Menú principal");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("UTENSILIOS");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMenu)
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMenu)
                            .addComponent(jButton2))
                        .addContainerGap())))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Agregar ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabla_uten.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Cantidad", "Tipo", "Cocina", "Descripción"
            }
        ));
        jScrollPane1.setViewportView(tabla_uten);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      FormularioUtensilio formulario = new FormularioUtensilio();
      formulario.setVisible(true);
      this.setVisible(false);
        

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
MenuPrincipal menu = new MenuPrincipal();
      menu.setVisible(true);
      this.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
Funciones func = new Funciones();
      func.setVisible(true);
      this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Utensilios().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_uten;
    // End of variables declaration//GEN-END:variables

    boolean guardar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
