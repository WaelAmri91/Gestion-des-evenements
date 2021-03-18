/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.gui;

import pi.entities.Evenement;
import pi.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class EvenementCRUD {
    
    private static EvenementCRUD instance;
        Connection cnx;
        Statement ste;
        ResultSet rs;

    public EvenementCRUD()  {
        cnx = MyConnection.getInstance().getConnection();
         try {
             ste = cnx.createStatement();
         } catch (SQLException ex) {
             Logger.getLogger(EvenementCRUD.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
     public static EvenementCRUD getInstance(){
        if(instance==null) 
           instance=new EvenementCRUD();
           return instance;
    }
    
     public void Organiser(Evenement a) throws SQLException {

        String sql = "INSERT INTO evenement (`nom_evenement`,`date_evenement`,`responsable`,`description`,`id_user`,`nbr_place`,`etat`) VALUES ( '" + a.getNom() + "','"+a.getDate()+"','"+a.getResponsable()+"','"+a.getDescription()+"','"+a.getId_user()+"','"+a.getNbr_place()+"','"+a.getEtat()+"')";
        ste.executeUpdate(sql);
            System.out.println("evenement ajoutes");
 
    }
     
     public ObservableList<Evenement> displayAll() 
     {
        String req="select * from evenement";
        ObservableList<Evenement> list=FXCollections.observableArrayList();       
        
        try {
            rs=ste.executeQuery(req);
            while(rs.next()){
                Evenement p=new Evenement();
                
               
                p.setNom(rs.getString(2));
                p.setDate(rs.getDate(3));
                p.setNbr_place(rs.getString(7));
                p.setDescription(rs.getString(5));

                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }


     public void delete(String id) throws SQLException {
        PreparedStatement pre = cnx.prepareStatement("Delete from evenement where nom_evenement= ?");
        pre.setString(1,id);
        pre.executeUpdate();
    }

    private Evenement displayById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean update(Evenement p) {
        String qry = "UPDATE evenement SET date_evenement = '"+p.getDate()+"', responsable = '"+p.getResponsable()+"',description = '"+p.getDescription()+"',nbr_place = '"+p.getNbr_place()+"' WHERE nom_evenement = '"+p.getNom()+"'";
        
        try {
            if (ste.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

 
    
     
}


