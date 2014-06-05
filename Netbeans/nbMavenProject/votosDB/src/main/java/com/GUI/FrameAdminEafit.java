/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.GUI;

import com.personas.AdmEafit;
import com.universidad.Carrera;
import com.universidad.Escuela;
import com.universidad.UniversidadEafit;
import com.votosdb.DBOps;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 */
public class FrameAdminEafit extends javax.swing.JFrame {

    private final AdmEafit adminLogedIn;
    
    /**
     * Creates new form FrameAdminEafit
     * @param admEafit El admin que esta logeado
     */
    public FrameAdminEafit(AdmEafit admEafit) {
        initComponents();
        adminLogedIn = admEafit;
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlEscuelas = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listEscuelas = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        AgregarEscuela = new javax.swing.JButton();
        EliminarEscuela = new javax.swing.JButton();
        Escuela = new javax.swing.JButton();
        pnlCarreras = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCarreras = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        butAgregarCarrera = new javax.swing.JButton();
        pnlEstudiantes = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        btnAgregarEstudiante = new javax.swing.JButton();
        btnRetirarEstudiante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AdminEafit");
        setResizable(false);

        listEscuelas.setModel(arrayToListModel(getListEscuelas()));
        listEscuelas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listEscuelas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        AgregarEscuela.setText("Agregar Escuela");
        AgregarEscuela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarEscuelaActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarEscuela);

        EliminarEscuela.setText("Eliminar Escuela");
        EliminarEscuela.setToolTipText("Eliminar la escuela seleccionada");
        EliminarEscuela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarEscuelaActionPerformed(evt);
            }
        });
        jPanel1.add(EliminarEscuela);

        Escuela.setText("Modificar Registro");
        Escuela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EscuelaActionPerformed(evt);
            }
        });
        jPanel1.add(Escuela);

        javax.swing.GroupLayout pnlEscuelasLayout = new javax.swing.GroupLayout(pnlEscuelas);
        pnlEscuelas.setLayout(pnlEscuelasLayout);
        pnlEscuelasLayout.setHorizontalGroup(
            pnlEscuelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEscuelasLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEscuelasLayout.setVerticalGroup(
            pnlEscuelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlEscuelasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Escuelas", pnlEscuelas);

        tableCarreras.setModel(ConstruirTablaCarreras());
        jScrollPane1.setViewportView(tableCarreras);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));

        butAgregarCarrera.setText("Agregar Carrera");
        butAgregarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAgregarCarreraActionPerformed(evt);
            }
        });
        jPanel7.add(butAgregarCarrera);

        javax.swing.GroupLayout pnlCarrerasLayout = new javax.swing.GroupLayout(pnlCarreras);
        pnlCarreras.setLayout(pnlCarrerasLayout);
        pnlCarrerasLayout.setHorizontalGroup(
            pnlCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarrerasLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCarrerasLayout.setVerticalGroup(
            pnlCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Carreras", pnlCarreras);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Correo", "Codigo"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));

        btnAgregarEstudiante.setText("Agregar Estudiante");
        btnAgregarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEstudianteActionPerformed(evt);
            }
        });
        jPanel10.add(btnAgregarEstudiante);

        btnRetirarEstudiante.setText("Retirar Estudiante");
        btnRetirarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarEstudianteActionPerformed(evt);
            }
        });
        jPanel10.add(btnRetirarEstudiante);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlEstudiantesLayout = new javax.swing.GroupLayout(pnlEstudiantes);
        pnlEstudiantes.setLayout(pnlEstudiantesLayout);
        pnlEstudiantesLayout.setHorizontalGroup(
            pnlEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstudiantesLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        pnlEstudiantesLayout.setVerticalGroup(
            pnlEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Estudiantes", pnlEstudiantes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarEscuelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarEscuelaActionPerformed
        String nombre = JOptionPane.showInputDialog("Nombre de la escuela a ingresar:");
        if(nombre == null) return;
        if(nombre.equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese un nombre para "
                    + "la escuela", "Error ingresando Escuela", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            ArrayList<Escuela> list;
            list = UniversidadEafit.getINSTANCE().getEscuelas();
            Escuela[] escuelas = new Escuela[list.size()];
            list.toArray(escuelas);
            for (Escuela e : escuelas) {
                if(e.getNombre().equals(nombre)){//si el nombre dado ya existe
                    //no se puede ingresar escuelas con el mismo nombre
                    JOptionPane.showMessageDialog(null, "No se pudo ingresar "
                            + "la Escuela: \"" +nombre+ "\", ya existe "
                            + "una escuela con el mismo nombre.", 
                            "Error ingresando Escuela",
                            JOptionPane.ERROR_MESSAGE);
                    
                    return;
                }
            }
            
            adminLogedIn.IngresarEscuela(nombre);
            ActualizarListaEscuelas();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e, "Error Ingresando Escuela", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Se ingreso la escuela: \"" + nombre + "\" exitosamente.");
    }//GEN-LAST:event_AgregarEscuelaActionPerformed

    private void butAgregarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAgregarCarreraActionPerformed
        try {
            //obtener las carreras
            ArrayList<Escuela> list;
            list = UniversidadEafit.getINSTANCE().getEscuelas();
            if(list.isEmpty()){
                JOptionPane.showMessageDialog(null, "No hay ninguna escuela",
                        "Error ingresando carrera", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Object[] possibleValues = new Object[list.size()];
            for (int i = 0; i < list.size(); i++) {
                possibleValues[i] = list.get(i).getNombre();
            }
            
            Object selectedValue = JOptionPane.showInputDialog(null,
                    "A cual escuela pertenece la carrera a ingresar",
                    "Ingresar Carrera",
                    JOptionPane.INFORMATION_MESSAGE, null,
                    possibleValues, possibleValues[0]);
            
            if(selectedValue != null){//si no cancelo la operacion
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre"
                        + " de la carrera");
                if(nombre != null){
                    //si no cancelo la operacion
                    adminLogedIn.IngresarCarrera(nombre, 
                            new Escuela((String) selectedValue));
                }
            }
            
            UpdateTablaCarreras();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error ingresando carrera",
                    "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FrameAdminEafit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex,
                    "Error ingresando carrera", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butAgregarCarreraActionPerformed

    private void btnAgregarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEstudianteActionPerformed
        //mostrar el panel como un modal que bloquea el input hasta que lo resuelva
        RegistroUsaurio registro = new RegistroUsaurio(this, true);
        registro.setVisible(true);
        
        while(registro.getReturnStatus() == -1) ;//esperar a que solucione el modal
        
        if(registro.getReturnStatus() == 1){
            try {
                String codigo = JOptionPane.showInputDialog("Ingrese codigo del estudiante");
                
                //se cancelo la operacion
                if(codigo == null){
                    return;
                }
                
                String nombre = registro.getNombre();
                String correo = registro.getCorreo();
                String password = registro.getPassword();
                registro.clearPassword();
                
                ArrayList<Carrera> list = UniversidadEafit.getINSTANCE().getCarreras();
                
                if(list.isEmpty()){ //si no hay carreras
                    JOptionPane.showMessageDialog(null, "No se encuentra "
                            + "ninguna Carrera, se requiere almenos una para "
                            + "ingresar un estudiante", "ERROR!!", 
                            JOptionPane.ERROR_MESSAGE);
                }
                
                Object[] possibleValues = new Object[list.size()];
                
                for (int i = 0; i < possibleValues.length; i++) {
                    possibleValues[i] = list.get(i).getNombre();
                }
                
                Object selectedValue = JOptionPane.showInputDialog(null,
                        "A cual escuela pertenece la carrera a ingresar",
                        "Ingresar Carrera",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        possibleValues, possibleValues[0]);
                
                if(selectedValue == null){//si cancelo la operacion
                    return;
                }
                
                Carrera carrera = new Carrera(selectedValue.toString());
                
                adminLogedIn.IngresarEstudiante(nombre, correo, password, 
                        codigo, carrera);
                
                JOptionPane.showMessageDialog(null, "Estudiante ingresado exitosamente");
            } catch (Exception ex) {
                Logger.getLogger(FrameAdminEafit.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error ingresando "
                        + "estudiante", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAgregarEstudianteActionPerformed

    private void EliminarEscuelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarEscuelaActionPerformed
        if(listEscuelas.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "No hay escuela seleccionada. "
                    + "Debe seleccionar una escuela para eliminarla.", 
                    "Error Eliminando Escuela", JOptionPane.ERROR_MESSAGE);
        } else {
            EliminarEscuela(listEscuelas.getSelectedIndex());
        }
    }//GEN-LAST:event_EliminarEscuelaActionPerformed

    private void EscuelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EscuelaActionPerformed
        if(listEscuelas.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "No hay escuela seleccionada. "
                    + "Debe seleccionar una escuela para cambiarle el nombre.", 
                    "Error Modificando Escuela", JOptionPane.ERROR_MESSAGE);
        } else {
            ModificarEscuela(listEscuelas.getSelectedIndex());
        }
    }//GEN-LAST:event_EscuelaActionPerformed

    private void btnRetirarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetirarEstudianteActionPerformed

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
            java.util.logging.Logger.getLogger(FrameAdminEafit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameAdminEafit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameAdminEafit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAdminEafit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmEafit admEafit = new AdmEafit();//for testing
                
                new FrameAdminEafit(admEafit).setVisible(true);
            }
        });
    }
    
    /**
     * Obtiene la lista de escuelas que estan en la BD y retorna un arreglo con 
     * los nombres de estas
     * @return Un arreglo con los nombres de todas las escuelas en la BD
     */
    public String[] getListEscuelas(){
        try {
            ArrayList<Escuela> list = UniversidadEafit.getINSTANCE().getEscuelas();
            Escuela[] escuelas = new Escuela[list.size()];
            list.toArray(escuelas);
            String[] names = new String[escuelas.length];
            for (int i = 0; i < names.length; i++){
                names[i] = escuelas[i].getNombre();
            }
            
            return names;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    /**
     * convierte un arreglo de strings en un objeto ListModel
     * @param arr arreglo a convertir.
     * @return Un modelo de lista con los contenidos del arreglo
     */
    public ListModel arrayToListModel(String[] arr){
        DefaultListModel list = new DefaultListModel();
        for (String string : arr) {
            list.addElement(string);
        }
        
        return list;
    }
    
    /**
     * Elimina la escuela en la posicion dada de la lista
     * @param index indice de la lista a eliminar.
     */
    private void EliminarEscuela(int index) {
        String name = listEscuelas.getModel().getElementAt(index).toString();
        
        
        //Eliminar la escuela de la BDs
        try {
            adminLogedIn.RetirarEscuela(new Escuela(name));
            
            ActualizarListaEscuelas();
            
            JOptionPane.showMessageDialog(null, "Se elimino la escuela \"" +name+ "\".");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error Eliminando Escuela", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void ModificarEscuela(int index) {
        String nombreOld = listEscuelas.getModel().getElementAt(index).toString();
        String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la escuela");
        if(nombre == null) return;
        if(nombre.equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese un nombre para "
                    + "la escuela", "Error ingresando Escuela", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            Connection c = DBOps.getInstance().ConnectDB();
            Statement stm = c.createStatement();
            
            String sql = "UPDATE ESCUELA SET NOMBRE = '" +nombre+ 
                    "' WHERE NOMBRE = '" +nombreOld+ "'";
            
            stm.executeUpdate(sql);
            
            ActualizarListaEscuelas();
            
            JOptionPane.showMessageDialog(null, "Se cambio el nombre de la "
                    + "escuela \"" +nombreOld+ "\" a \"" +nombre+ "\"");
            
            stm.close();
            c.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error Modificando Escuela", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Actualiza el contenido de la lista
     */
    public void ActualizarListaEscuelas(){
        listEscuelas.setModel(arrayToListModel(getListEscuelas()));
    }
    
    /**
     * Obtener la tabla con la informacion de todas las carreras
     * @return El tableModel con las carreras en la BDs
     * @throws SQLException 
     */
    public TableModel ConstruirTablaCarreras() {
        try {
            Object[] columnNames = {"Nombre", "Escuela"};
            DefaultTableModel table = new DefaultTableModel(columnNames, 0);
            
            ArrayList<Escuela> escuelas;
            escuelas = UniversidadEafit.getINSTANCE().getEscuelas();
            
            for (Escuela escuela : escuelas) {
                for (Carrera carrera : escuela.getCarreras()) {
                    String[] str = new String[2];
                    str[0] = carrera.getNombre();
                    str[1] = escuela.getNombre();
                    table.addRow(str);
                }
            }
            
            return table;
        } catch (SQLException ex) {
            Logger.getLogger(FrameAdminEafit.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            return new DefaultTableModel();
        }
    }
    
    public void UpdateTablaCarreras(){
        tableCarreras.setModel(ConstruirTablaCarreras());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarEscuela;
    private javax.swing.JButton EliminarEscuela;
    private javax.swing.JButton Escuela;
    private javax.swing.JButton btnAgregarEstudiante;
    private javax.swing.JButton btnRetirarEstudiante;
    private javax.swing.JButton butAgregarCarrera;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JList listEscuelas;
    private javax.swing.JPanel pnlCarreras;
    private javax.swing.JPanel pnlEscuelas;
    private javax.swing.JPanel pnlEstudiantes;
    private javax.swing.JTable tableCarreras;
    // End of variables declaration//GEN-END:variables

}
