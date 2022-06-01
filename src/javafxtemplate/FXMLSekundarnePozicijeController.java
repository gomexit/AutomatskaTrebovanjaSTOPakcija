/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


/**
 *
 * @author bojan
 */
public class FXMLSekundarnePozicijeController implements Initializable {

     ObservableList<BMpAkcije> AK_data;
     
     private EntityManager em;
    
    @FXML     TableView tbl_lista_akcija; 
            TableColumn<BMpAkcije,Integer> ID;
            TableColumn<BMpAkcije,String> TIP_AKCIJE;
            TableColumn<BMpAkcije,Date> DATUM_OD;
            TableColumn<BMpAkcije,Date> DATUM_DO;
            TableColumn<BMpAkcije,String> STATUS;
            
            
   ObservableList<BVMpAkcSekundarnePozicije> SP_data;         
   @FXML     TableView tbl_sek_poz; 
             TableColumn<BVMpAkcSekundarnePozicije,Long> SP_ID;
             TableColumn<BVMpAkcSekundarnePozicije,Long> SP_ID_AKCIJE;
             TableColumn<BVMpAkcSekundarnePozicije,String> SP_ID_KAMPANJE;
             TableColumn<BVMpAkcSekundarnePozicije,Long> SP_ATIKAL;
             TableColumn<BVMpAkcSekundarnePozicije,String> SP_SIFRA;
             TableColumn<BVMpAkcSekundarnePozicije,String> SP_NAZIV;
             TableColumn<BVMpAkcSekundarnePozicije,String> SP_OJ;
             TableColumn<BVMpAkcSekundarnePozicije,String> SP_OJ_NAZIV;
             TableColumn<BVMpAkcSekundarnePozicije,BigDecimal> SP_KOLICINA;
             
             
             
             
             
             @FXML TextField txt_add_artikal_id;
             @FXML TextField txt_add_artikal_sifra_art;
             @FXML TextField txt_add_artikal_naziv;
             @FXML TextField txt_add_id_akcije;
             @FXML TextField txt_add_id_kampanje;
             @FXML TextField txt_add_sifra_oj;
             @FXML TextField txt_add_sifra_naziv;
             @FXML TextField txt_add_kolicina;
             
             
                     
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
        prikaziAkcije();
    }
    
      public void prikaziAkcije() {
           em.clear();
        List<BMpAkcije>  results =  em.createNamedQuery("BMpAkcije.findAll").getResultList();
           AK_data = FXCollections.observableArrayList(results);
          
           
          ID=new TableColumn ("ID");
          ID.setCellValueFactory(new PropertyValueFactory<BMpAkcije,Integer>("id"));
          
          TIP_AKCIJE=new TableColumn ("TIP_AKCIJE");
          TIP_AKCIJE.setCellValueFactory(new PropertyValueFactory<BMpAkcije,String>("tipAkcije"));
          
          DATUM_OD=new TableColumn ("DATUM_OD");
          DATUM_OD.setCellValueFactory(new PropertyValueFactory<BMpAkcije,Date>("datumOd")); 
          
          DATUM_DO=new TableColumn ("DATUM_DO");
          DATUM_DO.setCellValueFactory(new PropertyValueFactory<BMpAkcije,Date>("datumDo")); 
          
          STATUS=new TableColumn ("STATUS");
          STATUS.setCellValueFactory(new PropertyValueFactory<BMpAkcije,String>("status"));
          
        
          
          tbl_lista_akcija.getColumns().setAll(ID, TIP_AKCIJE,DATUM_OD,DATUM_DO,STATUS);
     
          tbl_lista_akcija.setItems(AK_data);
          
           tbl_lista_akcija.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tbl_lista_akcija.getSelectionModel().getSelectedItem() != null) 
        {    
          
           TableView.TableViewSelectionModel selectionModel = tbl_lista_akcija.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);
          
           List<BMpAkcije> selected = selectionModel.getSelectedItems();
          prikaziSekundarne();
         
           
         }
         }
     });
          
           /*
                @FXML TextField txt_add_artikal_id;
             @FXML TextField txt_add_artikal_sifra_art;
             @FXML TextField txt_add_artikal_naziv;
             @FXML TextField txt_add_id_akcije;
             @FXML TextField txt_add_id_kampanje;
             @FXML TextField txt_add_sifra_oj;
             @FXML TextField txt_add_sifra_naziv;
             @FXML TextField txt_add_kolicina;
           
           */
          
      }
     
      
      public void prikaziSekundarne() {
           em.clear();
        List<BVMpAkcSekundarnePozicije>  results =  em.createNamedQuery("BVMpAkcSekundarnePozicije.findById")
                .setParameter("id", AK_data.get(tbl_lista_akcija.getSelectionModel().getSelectedIndex()).getId())
                .getResultList();
           SP_data = FXCollections.observableArrayList(results);
          
           
          SP_ID=new TableColumn ("ID");
          SP_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
          
          SP_ID_AKCIJE=new TableColumn ("id akcije");
          SP_ID_AKCIJE.setCellValueFactory(new PropertyValueFactory<>("idAkcije"));
          
          SP_ID_KAMPANJE=new TableColumn ("id kampanje");
          SP_ID_KAMPANJE.setCellValueFactory(new PropertyValueFactory<>("idKampanje"));
          
          SP_ATIKAL=new TableColumn ("id artikla");
          SP_ATIKAL.setCellValueFactory(new PropertyValueFactory<>("artikal"));
          
          SP_SIFRA=new TableColumn ("šifra art");
          SP_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          
          SP_NAZIV=new TableColumn ("artikal");
          SP_NAZIV.setCellValueFactory(new PropertyValueFactory<>("nazivArtikla"));
          
          SP_OJ=new TableColumn ("oj");
          SP_OJ.setCellValueFactory(new PropertyValueFactory<>("orgjed"));
          
          SP_OJ_NAZIV=new TableColumn ("naziv OJ");
          SP_OJ_NAZIV.setCellValueFactory(new PropertyValueFactory<>("nazivOj"));
          
          SP_KOLICINA=new TableColumn ("kolicina");
          SP_KOLICINA.setCellValueFactory(new PropertyValueFactory<>("kolicina"));
          
        
          
          tbl_sek_poz.getColumns().setAll(SP_ID_AKCIJE,SP_ID_KAMPANJE,SP_ATIKAL,SP_SIFRA,SP_NAZIV,SP_OJ,SP_OJ_NAZIV,SP_KOLICINA);
     
          tbl_sek_poz.setItems(SP_data);
           }
          /*
                 
   ObservableList<BVMpAkcSekundarnePozicije> SP_data;         
   @FXML     TableView tbl_sek_poz; 
             TableColumn<BVMpAkcSekundarnePozicije,Long> SP_ID;
             TableColumn<BVMpAkcSekundarnePozicije,Long> SP_ID_AKCIJE;
             TableColumn<BVMpAkcSekundarnePozicije,String> SP_ID_KAMPANJE;
             TableColumn<BVMpAkcSekundarnePozicije,Long> SP_ATIKAL;
             TableColumn<BVMpAkcSekundarnePozicije,String> SP_SIFRA;
             TableColumn<BVMpAkcSekundarnePozicije,String> SP_NAZIV;
             TableColumn<BVMpAkcSekundarnePozicije,String> SP_OJ;
             TableColumn<BVMpAkcSekundarnePozicije,String> SP_OJ_NAZIV;
          */
     
}
