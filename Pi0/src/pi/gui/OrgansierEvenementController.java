/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.gui;

import pi.gui.FXMLDocumentController;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pi.entities.Evenement;

/**
 * FXML Controller class
 *
 * @author 21655
 */
public class OrgansierEvenementController implements Initializable {

       @FXML
    private Label label1;

    @FXML
    private Button btn_ut;

    @FXML
    private Button btn_emp;

    @FXML
    private Button btn_dep;

    @FXML
    private Button btn_res;

    @FXML
    private Button btn_ev;

    @FXML
    private Button btn_stg;

    @FXML
    private Button btn_dec;

    @FXML
    private Label nom_ev;

    @FXML
    private Label date_ev;

    @FXML
    private Label resp;

    @FXML
    private Label desc;

    @FXML
    private TextField txtN;

    @FXML
    private TextField respo;

    @FXML
    private TextField descr;

    @FXML
    private DatePicker dateE;

    @FXML
    private Label nbp;

    @FXML
    private TextField nbr;

    @FXML
    private Button btn_va;

    @FXML
    private Button btn_an;

    @FXML
    private Label nbp1;

    @FXML
    private Label nbp11;

    @FXML
    private TextField iduser;

    @FXML
    private TextField etat;
    @FXML
    private TextField kkktf;
    @FXML
    private Button btn_va1;
    
   
    
 

  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML
  public void retour(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root = loader.load();
            FXMLDocumentController apc = loader.getController();
            btn_an.getScene().setRoot(root);
            
        } catch (IOException ex) {
            Logger.getLogger(OrgansierEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
  }
   @FXML
    private void ajout(ActionEvent event) throws SQLException, IOException {
          
              
                    
              java.sql.Date dn = java.sql.Date.valueOf(dateE.getValue()); 
              String l = kkktf.getText();
              String ida = iduser.getText();
              String nn = txtN.getText();
              String pp = respo.getText();
              String log = descr.getText();  
              String rr = nbr.getText();
              String mail = etat.getText();
             
         
              EvenementCRUD ad = new EvenementCRUD();
              Evenement a = new Evenement (l,nn,dn,pp,log,ida,rr,mail);
              ad.Organiser(a);

             
    }   

    @FXML
    private void modif(ActionEvent event) {
                
              java.sql.Date dn = java.sql.Date.valueOf(dateE.getValue()); 
              String l = kkktf.getText();
              String ida = iduser.getText();
              String nn = txtN.getText();
              String pp = respo.getText();
              String log = descr.getText();  
              String rr = nbr.getText();
              String mail = etat.getText();
             
            
         
              EvenementCRUD ad = new EvenementCRUD();
              Evenement a = new Evenement (l,nn,dn,pp,log,ida,rr,mail);
              ad.update(a);
              System.out.println("fffffffffffffffff");
    }
   
}
