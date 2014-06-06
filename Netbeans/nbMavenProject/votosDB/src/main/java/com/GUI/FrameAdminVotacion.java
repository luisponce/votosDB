/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.GUI;

import com.personas.AdmVotacion;
import com.universidad.Carrera;
import com.universidad.UniversidadEafit;
import com.votosdb.DBOps;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jonathaneidelman
 */
public class FrameAdminVotacion extends javax.swing.JFrame {

    private final AdmVotacion adminLogedIn;
    
    
    public FrameAdminVotacion(AdmVotacion adminVotacion) {
        initComponents();
        adminLogedIn = adminVotacion;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVotaciones = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnCrearVotacion = new javax.swing.JButton();
        btnCandidatos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCandidatos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblVotaciones.setModel(buildTable());
        jScrollPane1.setViewportView(tblVotaciones);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnCrearVotacion.setText("Crear Votacion");
        btnCrearVotacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearVotacionActionPerformed(evt);
            }
        });
        jPanel3.add(btnCrearVotacion);

        btnCandidatos.setText("Añadir Candidatos");
        jPanel3.add(btnCandidatos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Votaciones", jPanel1);

        tblCandidatos.setModel(buildTableCandidatos());
        jScrollPane2.setViewportView(tblCandidatos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Candidatos", jPanel2);

        jMenu1.setText("Opciones");

        jMenuItem1.setText("Agregar Admin");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Eliminar Admin");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Log Out");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearVotacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearVotacionActionPerformed
        FrameCrearVotacion ventana = new FrameCrearVotacion(this);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnCrearVotacionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        RegistroUsaurio registro = new RegistroUsaurio(this, true);
        registro.setVisible(true);
        
        while(registro.getReturnStatus() == -1) ;//esperar a que solucione el modal
        
        if(registro.getReturnStatus() == 1){
            try {
                
                String nombre = registro.getNombre();
                String correo = registro.getCorreo();
                String password = registro.getPassword();
                registro.clearPassword();
                if(nombre.equals("")){
                    JOptionPane.showMessageDialog(null, "El nombre no puede ser vacio", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                    Connection c = DBOps.getInstance().ConnectDB();
                    Statement stm = c.createStatement();
                    String sql = "Insert into USUARIO (NOMBRE, CORREO, PASSWORD) "
                        + "values ('" + nombre + "', '" 
                        +  correo + "', '" + password + "' );";
                    stm.execute(sql);
                    sql = "Insert into ADMIN (ID, TIPO) values (last_insert_rowid(), " + 0 + ")";
                    stm.execute(sql);
                    stm.close();
                    c.close();
                    JOptionPane.showMessageDialog(null, "Admin de votacion"
                        + " ingresado exitosamente");
                
                
            } catch (Exception ex) {
                Logger.getLogger(FrameAdminEafit.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error ingresando "
                        + "Admin de votacion", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            String eliminado =  JOptionPane.showInputDialog("Ingrese el nombre del admin a eliminar.");
            Connection c = DBOps.getInstance().ConnectDB();
            Statement stm = c.createStatement();
            String sql = "Select ID from USUARIO where NOMBRE =" + "'" +  eliminado + "'";
            /*ResultSet res = stm.executeQuery(sql);
            res.next();
            String sql2 = "Select TIPO from ADMIN where ID =" + "(Select ID from USUARIO where NOMBRE =" + "'" +  eliminado + "')";
            ResultSet res2 = stm.executeQuery(sql2);
            res2.next();
            String sql3 = "Select * from ADMIN where ID = " + "(Select ID from USUARIO where NOMBRE =" + "'" +  eliminado + "')";
            ResultSet res3 = stm.executeQuery(sql3);
            res3.next();
            if(res.getString("ID").equals("")){
                JOptionPane.showMessageDialog(null, "No existe ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }else if(res3.getString("ID").equals("")){
                JOptionPane.showMessageDialog(null, "El usuario ingresado no es un admin.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }else if(!"0".equals(res2.getString("TIPO"))){
                JOptionPane.showMessageDialog(null, "Solo puede eliminar admins de su tipo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            */ //este pedazo no funciona... hay que validar porque sino trataria de eliminar un usuario que no es admin.
            sql = "Delete from ADMIN where ID = (Select ID from"
                    + " USUARIO where NOMBRE=" + "'" + eliminado + "'" + ");" +
                    "Delete from USUARIO where NOMBRE =" + "'" +  eliminado + "'";
            stm.executeUpdate(sql);
            stm.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(FrameAdminVotacion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el admin", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameAdminVotacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameAdminVotacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameAdminVotacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAdminVotacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmVotacion admin = new AdmVotacion(); //para pruebas, provisional!!!
                new FrameAdminVotacion(admin).setVisible(true);
                
            }
        });
    }
    
    public TableModel buildTable() {
        try {
            DefaultTableModel tabla = new DefaultTableModel();
            tabla.addColumn("Nombre");
            tabla.addColumn("Fecha Inicio");
            tabla.addColumn("Fecha fin");
            
            //meter todas las votaciones en la tabla.
            Connection c = DBOps.getInstance().ConnectDB();
            Statement stm = c.createStatement();
            String sql = "Select * from VOTACION";
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                String nombre = res.getString("NOMBRE");
                String f1 = res.getString("FECHA_INICIO");
                String f2 = res.getString("FECHA_FIN");
                Object[] arreglo = {nombre, f1.substring(0, 11) +
                        f1.substring(f1.length() - 4), f2.substring(0, 11) +
                        f2.substring(f2.length() - 4)};
                tabla.addRow(arreglo);
            }
            
            return tabla;
        } catch (SQLException ex) {
            Logger.getLogger(FrameAdminVotacion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error obteniendo informacion"
                    + " de votaciones", null, JOptionPane.ERROR_MESSAGE);
            return new DefaultTableModel();
        }
        
    }
    
    public String obtenerCandidato(int id, Connection c) throws SQLException{
       
        
        Statement stm = c.createStatement();
        
        String sql = "Select NOMBRE from USUARIO where ID =" + id;
        ResultSet res = stm.executeQuery(sql);
        String ans = res.getString(1);
        stm.close();
        //c.close();
        return ans;
    }
    
    public String obtenerVotacion(int id, Connection c) throws SQLException{
        Statement stm = c.createStatement();
        
        String sql = "Select NOMBRE from VOTACION where ID =" + id;
        ResultSet res = stm.executeQuery(sql);
        String ans = res.getString(1);
        stm.close();
        //c.close();
        return ans;
    }
    
    public TableModel buildTableCandidatos() {
        try {
            DefaultTableModel tabla = new DefaultTableModel();
            tabla.addColumn("Candidato");
            tabla.addColumn("Votacion");
            
            //meter todas las votaciones en la tabla.
            Connection c = DBOps.getInstance().ConnectDB();
            Statement stm = c.createStatement();
            String sql = "Select * from CANDIDATO";
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                String idcandidato = res.getString("CANDIDATO");
                String idvotacion = res.getString("VOTACION");
                Object[] arreglo = {obtenerCandidato(Integer.parseInt(idcandidato), c), obtenerVotacion(Integer.parseInt(idvotacion), c)};
                tabla.addRow(arreglo);
            }
            stm.close();
            c.close();
            return tabla;
        } catch (SQLException ex) {
            Logger.getLogger(FrameAdminVotacion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error obteniendo informacion"
                    + " de votaciones", null, JOptionPane.ERROR_MESSAGE);
            return new DefaultTableModel();
        }
        
    }
    
    public void updateTablaCandidatos(){
        tblCandidatos.setModel(buildTableCandidatos());
    }
    
    public void updateTablaVotaciones() {
        tblVotaciones.setModel(buildTable());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCandidatos;
    private javax.swing.JButton btnCrearVotacion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblCandidatos;
    private javax.swing.JTable tblVotaciones;
    // End of variables declaration//GEN-END:variables
}
