/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.GUI;

import com.personas.AdmVotacion;
import com.personas.Estudiante;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathaneidelman
 */
public class FrameCrearVotacion extends javax.swing.JFrame {
    private final FrameAdminVotacion padre;

    /**
     * Creates new form vwCrearVotacion
     */
    public FrameCrearVotacion(FrameAdminVotacion padre) {
        this.padre = padre;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtInicio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFin = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Crear una votacion.");

        jLabel2.setText("Nombre de la votacion");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha de inicio:");

        txtInicio.setText("mm/dd/yyyy");
        txtInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInicioActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha de finalizacion:");

        txtFin.setText("mm/dd/yyyy");
        txtFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFinActionPerformed(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(txtFin))))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInicioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            
            
            String nombre = txtNombre.getText();
            if("".equals(nombre) || nombre == null){
                JOptionPane.showMessageDialog(null, "El nombre no puede ser"
                        + " vacio", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try{
                validarFecha(txtInicio.getText());
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Formato de fecha de inicio invalido.", "Error", JOptionPane.ERROR_MESSAGE);
                setTextFechaInicio();
                return;
            }
            
            try{
                validarFecha(txtFin.getText());
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Formato de fecha de finalizacion invalido.", "Error", JOptionPane.ERROR_MESSAGE);
                setTextFechaFin();
                return;
            }
            Date fechaIni = new Date(txtInicio.getText());
            Date fechaFin = new Date(txtFin.getText());
            padre.getAdmin().IniciarVotacion(fechaIni, fechaFin, txtNombre.getText());
            padre.updateTablaVotaciones();
            setVisible(false);
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(FrameCrearVotacion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFinActionPerformed

    public boolean isNumeric(String str)  
{  
  try  
  {  
    double d = Double.parseDouble(str);  
  }  
  catch(NumberFormatException nfe)  
  {  
    return false;  
  }  
  return true;  
}
    
    public void validarFecha(String fecha) throws Exception{
        
        if(fecha.length() < 10){
            throw new Exception("Formato de fecha invalido.");
        }
        
        String dia, mes, anio;
        String primerSlash, segundoSlash;
        mes = fecha.substring(0, 2);
        dia = fecha.substring(3, 5);
        anio = fecha.substring(6);
        int ndia, nmes, nanio;
        ndia = Integer.parseInt(dia);
        nmes = Integer.parseInt(mes);
        nanio = Integer.parseInt(anio);
        primerSlash = fecha.substring(2, 3);
        segundoSlash = fecha.substring(5, 6);
        if(!isNumeric(mes)){
            throw new Exception("Formato de fecha invalido.");
        }else if(!isNumeric(dia)){
            throw new Exception("Formato de fecha invalido.");
        }else if(!isNumeric(anio)){
            throw new Exception("Formato de fecha invalido.");
        }else if(!primerSlash.equals("/")){
            throw new Exception("Formato de fecha invalido.");
        }else if(!segundoSlash.equals("/")){
            throw new Exception("Formato de fecha invalido.");
        }else if(ndia > 31 || ndia < 0){
            throw new Exception("Formato de fecha invalido.");
        }else if(nmes > 12 || nmes < 0){
            throw new Exception("Formato de fecha invalido.");
        }else if(nanio > 9999 || nanio < 2013){
            throw new Exception("Formato de fecha invalido.");
        }
    }
    
    public void setTextFechaFin(){
        txtFin.setText("mm/dd/yyyy");
    }
    
    public void setTextFechaInicio(){
        txtInicio.setText("mm/dd/yyyy");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtFin;
    private javax.swing.JTextField txtInicio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
