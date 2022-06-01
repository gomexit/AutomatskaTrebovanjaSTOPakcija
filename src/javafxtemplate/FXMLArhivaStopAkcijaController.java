/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.eclipse.persistence.config.QueryHints;

/**
 * FXML Controller class
 *
 * @author controling
 */

public class FXMLArhivaStopAkcijaController implements Initializable {

  @FXML
  TableView tbl_stop_akcije;

  @FXML
  TableView tbl_prikaz_artikla;
  
  private EntityManager em;
  
   ObservableList<BMpAkcije> data; 
    @FXML     TableColumn<BMpAkcije,Integer> ID;
    @FXML     TableColumn<BMpAkcije,String> TIP_AKCIJE;
    @FXML     TableColumn<BMpAkcije,Date> DATUM_OD;
    @FXML     TableColumn<BMpAkcije,Date> DATUM_DO;
    @FXML     TableColumn<BMpAkcije,String> STATUS;
    @FXML     TableColumn<BMpAkcije,String> KOMENTAR; 

    
    ObservableList<BVMpAkcArtikStop> ART_STOP_data;
       
   TableColumn<BVMpAkcArtikStop,String> ART_STOP_ARTIKAL;
   TableColumn<BVMpAkcArtikStop,String> ART_STOP_SIFRA;    
   TableColumn<BVMpAkcArtikStop,String> ART_STOP_NAZIV;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
        popuniInicijalno();
        
        
        tbl_stop_akcije.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tbl_stop_akcije.getSelectionModel().getSelectedItem() != null) 
        {    
          
           TableView.TableViewSelectionModel selectionModel = tbl_stop_akcije.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);

         prikaziArtikleStop(data.get(tbl_stop_akcije.getSelectionModel().getSelectedIndex()).getId());
         
         }
         }
     });
        
        
        
        
       
    }    
    
    
        private void popuniInicijalno() {
        
         
        
        em.clear();
         List<BMpAkcije>  results =  em.createNamedQuery("BMpAkcije.findAll").getResultList();
           data = FXCollections.observableArrayList(results);
          
           
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
          
          KOMENTAR=new TableColumn ("KOMENTAR");
          KOMENTAR.setCellValueFactory(new PropertyValueFactory<BMpAkcije,String>("komentar"));
          
          tbl_stop_akcije.getColumns().setAll(ID, TIP_AKCIJE,DATUM_OD,DATUM_DO,STATUS,KOMENTAR);
          tbl_stop_akcije.setItems(data);
        }
        
        public void prikaziArtikleStop(Integer i)
      {
          
            em.clear();
         List<BVMpAkcArtikStop>  results2 =  em.createNamedQuery("BVMpAkcArtikStop.findByIdAkcije")
                  .setParameter("idAkcije", i)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList();
         

         
         
          ART_STOP_data = FXCollections.observableArrayList(results2);
          
          ART_STOP_ARTIKAL=new TableColumn ("artikal");
          ART_STOP_ARTIKAL.setCellValueFactory(new PropertyValueFactory<>("artikal"));
          
          ART_STOP_SIFRA=new TableColumn ("sifra artikla");
          ART_STOP_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          
                   
          ART_STOP_NAZIV=new TableColumn ("naziv artikla");
          ART_STOP_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          
          
          tbl_prikaz_artikla.getColumns().setAll(ART_STOP_ARTIKAL,ART_STOP_SIFRA,ART_STOP_NAZIV);
     
          tbl_prikaz_artikla.setItems(ART_STOP_data);
          
          
          
          

      }
        
}
