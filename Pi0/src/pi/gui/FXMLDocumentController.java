/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pi.entities.Evenement;

/**
 *
 * @author ASUS
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Label label1;
    @FXML
    private Button btn_org;
    @FXML
    private Button btn_sup;
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
    private TableColumn<Evenement, String> nom_ev;
    @FXML
    private TableColumn<Evenement, Date> date_ev;
    @FXML
    private TableColumn<Evenement, String> nbp;
    @FXML
    private TableColumn<Evenement, String> desc;
    @FXML
    private Button btn_mod;
    @FXML
    private Button btn_insc;
    @FXML
  private TableView<Evenement> tv;
    
    
    private ObservableList<Evenement> evenement=FXCollections.observableArrayList();
    @FXML
    private TextField lll;



    

       
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       getSelected(); 
  
        nom_ev.setCellValueFactory(new PropertyValueFactory<Evenement,String>("nom"));
       date_ev.setCellValueFactory(new PropertyValueFactory<Evenement,Date>("date"));
        nbp.setCellValueFactory(new PropertyValueFactory<Evenement,String>("nbr_place"));
        desc.setCellValueFactory(new PropertyValueFactory<Evenement,String>("description"));
         evenement = EvenementCRUD.getInstance().displayAll() ; 

       tv.setItems(evenement);

    }
    
    
      
        
        
        
      
        

   


   
      

   
//    @FXML
//    private void modifier(ActionEvent event) throws IOException {
//            
//       System.out.println("crud.Crud.Gestion_admidsdqsdqnsController.modifier()");
//        
//        
//         
//              java.sql.Date dn = java.sql.Date.valueOf(ddntf.getValue());        
//              String ida = idf.getText();
//              String nn = nomf.getText();
//              String pp = pref.getText();
//              String log = ltf.getText();  
//              String r = cbr.getValue();
//              String mail = emtf.getText();
//      
//              adminCRUD ad = new adminCRUD();
//              admin a = new admin (ida,log,nn,pp,mail,dn,r);
//              ad.update(a);
//             
//              main n = new main();
//              n.changeScene("Gestion_admins.fxml");
//    }
//
//    @FXML
//    private void gtedt(ActionEvent event) throws IOException {
//    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GestionEDT.fxml"));
//    Parent root = (Parent) fxmlLoader.load();
//    Scene scene = new Scene(root, 600, 65);
//    
//    }
//    
  
@FXML 
    public void formulaire(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OrgansierEvenement.fxml"));
        Parent root = loader.load();
        OrgansierEvenementController apc =loader.getController();
        btn_org.getScene().setRoot(root);
        
  }
    @FXML
    public void formulaire1(ActionEvent event) throws IOException, SQLException
    {
      EvenementCRUD ad = new EvenementCRUD();
       ad.delete(lll.getText());
        loadDataFromDatabase();
  }
    public void getSelected(){
        tv.setOnMouseClicked((MouseEvent event) -> {
        lll.setText(nom_ev.getCellData(tv.getSelectionModel().getSelectedIndex()));
        
    });
       
    }
    
   @FXML 
    public void formulaire2(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OrgansierEvenement.fxml"));
        Parent root = loader.load();
        OrgansierEvenementController apc =loader.getController();
        btn_mod.getScene().setRoot(root);
        
  }
    
  
       
    
    
        private void loadDataFromDatabase() {
              
        nom_ev.setCellValueFactory(new PropertyValueFactory<Evenement , String>("nom_evenement"));
        date_ev.setCellValueFactory(new PropertyValueFactory<Evenement , Date>("date_evenement"));
        nbp.setCellValueFactory(new PropertyValueFactory<Evenement , String>("nbr_place")); 
       desc.setCellValueFactory(new PropertyValueFactory<Evenement , String>("description"));

       
       evenement = EvenementCRUD.getInstance().displayAll();
       tv.setItems(evenement);
    }
    }
  
    



