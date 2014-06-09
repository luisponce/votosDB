/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.GUI.resultados;

import com.votacion.Votacion;
import com.votosdb.DBOps;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author luisponcedeleon
 */
public class FrameReporteVotacion extends JFrame{

    public FrameReporteVotacion(String nombre, String FechaI, String FechaF)
            throws HeadlessException {
        
        try {
            setLayout(new FlowLayout());
            setTitle("Reporte Votacion");
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            
            //panel titulo reporte
            PanelTituloReporte titulo;
            titulo = new PanelTituloReporte(nombre, FechaI, FechaF);
            panel.add(titulo);
            int idVotacion = Votacion.getIntByName(nombre);
            
            //obtener los candidatos de la votacion
            Connection c = DBOps.getInstance().ConnectDB();
            Statement stm = c.createStatement();
            
            String sql = "SELECT CANDIDATO FROM CANDIDATO "
                    + "WHERE VOTACION = "+idVotacion;
            ResultSet res = stm.executeQuery(sql);
            int numeroCandidato = 0;
            //por cada candidato
            while (res.next()){
                int idCandidato = res.getInt(1);
                
                //cuantos votos
                int votosCandidato = cuantosVotos(idVotacion, idCandidato);
                
                //info candidato
                String[] nombre_codigo = nombreYcodigo(idCandidato);
                String nombreC = nombre_codigo[0];
                String codigoC = nombre_codigo[1];
                
                
                //paneles resultado por cada candidato
                PanelResultadoCandidato pnlCandidato;
                pnlCandidato = new PanelResultadoCandidato(numeroCandidato,
                        nombreC, codigoC, votosCandidato);
                
                panel.add(pnlCandidato);
                
                numeroCandidato++;
            }
            
            add(panel);
            
            pack();
            
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(FrameReporteVotacion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error con la base de datos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private int cuantosVotos(int idVotacion, int idCandidato) throws SQLException{
        int votosCandidato;
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        String sql = "SELECT COUNT(*) FROM VOTO "
                + "WHERE VOTACION = "+idVotacion+" "
                + "AND SELECCION = "+idCandidato;
        ResultSet res2 = stm.executeQuery(sql);
        votosCandidato = res2.getInt(1);
        
        stm.close();
        return votosCandidato;
    }

    private String[] nombreYcodigo(int idCandidato) throws SQLException {
        Statement stm = DBOps.getInstance().ConnectDB().createStatement();
        
        String nombreC = "";
        String codigoC = "";
        String sql = "SELECT CODIGO, NOMBRE FROM ESTUDIANTE, USUARIO "
                + "WHERE ESTUDIANTE.ID = USUARIO.ID "
                + "AND ESTUDIANTE.ID = "+idCandidato;
        ResultSet res3 = stm.executeQuery(sql);
        nombreC = res3.getString(2);
        codigoC = res3.getString(1);
        String[] ans = {nombreC, codigoC};
        return ans;
    }
    
    
}
