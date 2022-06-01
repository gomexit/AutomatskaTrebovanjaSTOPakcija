/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import org.eclipse.persistence.config.QueryHints;

/**
 * FXML Controller class
 *
 * @author ivan.babic
 */
public class FXMLPlanogramController implements Initializable {

    private EntityManager em;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
   
   // prikaziPlanogram () ;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    tbl_planogram.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
       @Override
       public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
            if(tbl_planogram.getSelectionModel().getSelectedItem() != null) 
            {    

               TableView.TableViewSelectionModel selectionModel = tbl_planogram.getSelectionModel();
               ObservableList selectedCells = selectionModel.getSelectedCells();
               TablePosition tablePosition = (TablePosition) selectedCells.get(0);
               Object val = tablePosition.getTableColumn().getCellData(newValue);
           
              txt_izmeni_artikal.setText(String.valueOf(planogramPretraga_data.get(tbl_planogram.getSelectionModel().getSelectedIndex()).getArtikalId()));
              txt_izmeni_grupa.setText(planogramPretraga_data.get(tbl_planogram.getSelectionModel().getSelectedIndex()).getGrupa());
              txt_izmeni_kolicina.setText(planogramPretraga_data.get(tbl_planogram.getSelectionModel().getSelectedIndex()).getKolicina().toString());
           
            
            }
             }
     });
    
    
                                txt_planogram_pretraga_naziv.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        if (keyEvent.getCode() == KeyCode.ENTER)  {
                            String text = txt_planogram_pretraga_naziv.getText();
                            
                                 pretragaPlanogram();
                           
                            
                        }
                    }
                });
                                
                                  txt_planogram_pretraga_sifra.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        if (keyEvent.getCode() == KeyCode.ENTER)  {
                            String text = txt_planogram_pretraga_sifra.getText();
                            
                                 pretragaPlanogram();
                           
                            
                        }
                    }
                });
    
    
    }    
    
      @FXML TableView tbl_planogram;
      @FXML TextField txt_planogram_pretraga_sifra;
      @FXML TextField txt_planogram_pretraga_naziv;
      
      
      
      @FXML TextField txt_izmeni_grupa;
      @FXML TextField txt_izmeni_artikal;
      @FXML TextField txt_izmeni_kolicina;
      
      
      @FXML TextField txt_dodaj_grupa;
      @FXML TextField txt_dodaj_artikal;
      @FXML TextField txt_dodaj_kolicina;
    
      @FXML Label br_redova;
    
      

    TableColumn <BVMpAkcPlanogramPretraga, String> planogramPretraga_grupa;
    TableColumn <BVMpAkcPlanogramPretraga, String> planogramPretraga_artikal_naziv;
    TableColumn <BVMpAkcPlanogramPretraga, BigDecimal> planogramPretraga_kolicina;
     TableColumn <BVMpAkcPlanogramPretraga, Long> planogramPretraga_artikal_id;
     TableColumn <BVMpAkcPlanogramPretraga, String> planogramPretraga_sifra;
   
   
   
    ObservableList<BVMpAkcPlanogramPretraga> planogramPretraga_data;
      
    
    
    
    
    
    
     public void pretragaPlanogram () {
             
             em.clear();
       
                   
              String v_a1= "%"+txt_planogram_pretraga_naziv.getText().toUpperCase() +"%";
              String v_a2= "%"+(txt_planogram_pretraga_sifra.getText()) +"%";
     
                   // System.out.println(Date.from(date_picker_prijava_datum.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
           
           List<BVMpAkcPlanogramPretraga>  results =  em.createNamedQuery("BVMpAkcPlanogramPretraga.find2parametara")
                   
                   
                  .setParameter("artikalNaziv",v_a1)
                   .setParameter("artikalSifra",v_a2)
                   
                                
               
                                
                 

                 
             
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
           
                    int i = results.size();
              
                
                    br_redova.setText( "Broj redova je :" +i); 
           
          
          planogramPretraga_data = FXCollections.observableArrayList(results);
                  
          planogramPretraga_artikal_id=new TableColumn ("ARTIKAL_ID");
          planogramPretraga_artikal_id.setCellValueFactory(new PropertyValueFactory<>("artikalId"));
          
          planogramPretraga_sifra=new TableColumn ("ARTIKAL_SIFRA");
          planogramPretraga_sifra.setCellValueFactory(new PropertyValueFactory<>("artikalSifra"));
          
           planogramPretraga_artikal_naziv=new TableColumn ("ARTIKAL_NAZIV");
          planogramPretraga_artikal_naziv.setCellValueFactory(new PropertyValueFactory<>("artikalNaziv"));
          
           planogramPretraga_grupa=new TableColumn ("GRUPA");
          planogramPretraga_grupa.setCellValueFactory(new PropertyValueFactory<>("grupa"));
          
           planogramPretraga_kolicina=new TableColumn ("KOLICINA");
          planogramPretraga_kolicina.setCellValueFactory(new PropertyValueFactory<>("kolicina"));

          
        

           
         tbl_planogram.getColumns().setAll(planogramPretraga_grupa,planogramPretraga_artikal_id,planogramPretraga_sifra,planogramPretraga_artikal_naziv,planogramPretraga_kolicina);
           
          tbl_planogram.setItems(planogramPretraga_data);
          
          
          /*
             txt_planogram_pretraga_naziv.clear();
             txt_planogram_pretraga_sifra.clear();
           */  
             txt_izmeni_artikal.clear();
             txt_izmeni_grupa.clear();
             txt_izmeni_kolicina.clear();
             
             
          
         
    

}
     
     public void prikaziPlanogram () {
             
             em.clear();
       
            
               
             
           List<BVMpAkcPlanogramPretraga>  results =  em.createNamedQuery("BVMpAkcPlanogramPretraga.findAll")
             
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
           
           
                    int i = results.size();
              
                
                    br_redova.setText( "Broj redova je :" +i); 
          
          planogramPretraga_data = FXCollections.observableArrayList(results);
                  
          planogramPretraga_artikal_id=new TableColumn ("ARTIKAL_ID");
          planogramPretraga_artikal_id.setCellValueFactory(new PropertyValueFactory<>("artikalId"));
          
           planogramPretraga_sifra=new TableColumn ("ARTIKAL_SIFRA");
          planogramPretraga_sifra.setCellValueFactory(new PropertyValueFactory<>("artikalSifra"));
          
          
           planogramPretraga_artikal_naziv=new TableColumn ("ARTIKAL_NAZIV");
          planogramPretraga_artikal_naziv.setCellValueFactory(new PropertyValueFactory<>("artikalNaziv"));
          
           planogramPretraga_grupa=new TableColumn ("GRUPA");
          planogramPretraga_grupa.setCellValueFactory(new PropertyValueFactory<>("grupa"));
          
           planogramPretraga_kolicina=new TableColumn ("KOLICINA");
          planogramPretraga_kolicina.setCellValueFactory(new PropertyValueFactory<>("kolicina"));

          
        

           
         tbl_planogram.getColumns().setAll(planogramPretraga_grupa,planogramPretraga_artikal_id,planogramPretraga_sifra,planogramPretraga_artikal_naziv,planogramPretraga_kolicina);
           
          tbl_planogram.setItems(planogramPretraga_data);
          
          
          
             
             
          
         
    

}
    
     public void unosNovogArtiklaPlanogram() {
             
                        
         em.getTransaction().begin();
        StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.B_MP_AKC_PLANOGRAM_UNOS");
        
          
         storedprocedure1.registerStoredProcedureParameter("P_GRUPA", String.class, ParameterMode.IN);
         storedprocedure1.setParameter("P_GRUPA",  txt_dodaj_grupa.getText().toUpperCase());
        
        
         storedprocedure1.registerStoredProcedureParameter("P_ARTIKAL", Long.class, ParameterMode.IN);
         storedprocedure1.setParameter("P_ARTIKAL", Long.valueOf(txt_dodaj_artikal.getText()));
        
         storedprocedure1.registerStoredProcedureParameter("P_KOLICINA", Long.class, ParameterMode.IN);
         storedprocedure1.setParameter("P_KOLICINA", Long.valueOf(txt_dodaj_kolicina.getText()));
        
     
         
             
         em.getTransaction().commit();
         storedprocedure1.execute();

        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Uneli ste stavku");
        alert1.setHeaderText("Stavka uspešno unešena!");

        alert1.showAndWait();
         
         
         txt_dodaj_grupa.clear();
         txt_dodaj_kolicina.clear();
         txt_dodaj_artikal.clear();
         
         
    }
     
     
      public void izmenaKolicineArtiklaPlanogram() {
             
                        
         em.getTransaction().begin();
        StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mp_akc_planogram_izmena");
        
        
         storedprocedure1.registerStoredProcedureParameter("p_kolicina", Long.class, ParameterMode.IN);
         storedprocedure1.setParameter("p_kolicina", Long.valueOf(txt_izmeni_kolicina.getText()));
        
  
         storedprocedure1.registerStoredProcedureParameter("p_artikal_id", Long.class, ParameterMode.IN);
         storedprocedure1.setParameter("p_artikal_id", Long.valueOf(txt_izmeni_artikal.getText()));
        
         storedprocedure1.registerStoredProcedureParameter("p_grupa", String.class, ParameterMode.IN);
         storedprocedure1.setParameter("p_grupa",  txt_izmeni_grupa.getText().toUpperCase());
        
     
         
             storedprocedure1.execute();
         em.getTransaction().commit();
         

        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Izmenili ste stavku");
        alert1.setHeaderText("Stavka uspešno izmenjena!");

        alert1.showAndWait();
         
         
         txt_izmeni_grupa.clear();
         txt_izmeni_kolicina.clear();
         txt_izmeni_artikal.clear();
         
         pretragaPlanogram ();
         
    }
     
      
      public void obrisStavkuPlanogram() {
             
        //if ((tbl_planogram.getSelectionModel().getSelectedIndex()>-1)  )
     //  {               
         em.getTransaction().begin();
        StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mp_akc_planogram_obrisi");
        
        
         storedprocedure1.registerStoredProcedureParameter("p_kolicina", Long.class, ParameterMode.IN);
         storedprocedure1.setParameter("p_kolicina", Long.valueOf(txt_izmeni_kolicina.getText()));
        
  
         storedprocedure1.registerStoredProcedureParameter("p_artikal_id", Long.class, ParameterMode.IN);
         storedprocedure1.setParameter("p_artikal_id", Long.valueOf(txt_izmeni_artikal.getText()));
        
         storedprocedure1.registerStoredProcedureParameter("p_grupa", String.class, ParameterMode.IN);
         storedprocedure1.setParameter("p_grupa",  txt_izmeni_grupa.getText().toUpperCase());
        
     
         
             storedprocedure1.execute();
             em.getTransaction().commit();
         

        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Obrisali ste stavku");
        alert1.setHeaderText("Stavka uspešno obrisana!");

        alert1.showAndWait();
         
         
         txt_izmeni_grupa.clear();
         txt_izmeni_kolicina.clear();
         txt_izmeni_artikal.clear();
         pretragaPlanogram ();
       }
    
/*
      else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Greška!");
            alert.setContentText("Proverite da li ste selektovali red koji brišete!!");
            alert.showAndWait();  
*/
       }
         
         
         
    
      
    

