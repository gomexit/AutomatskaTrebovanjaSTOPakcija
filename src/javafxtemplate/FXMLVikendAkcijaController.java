/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import org.eclipse.persistence.config.QueryHints;

/**
 * FXML Controller class
 *
 * @author bojan
 */
public class FXMLVikendAkcijaController implements Initializable {

     private EntityManager em;
    
    
   @FXML  TableView tblListaAkcija;
    ObservableList<BMpvAkcije> AKC_data;
    TableColumn<BMpvAkcije,Long>  AKC_ID;
    TableColumn<BMpvAkcije,Date>  AKC_DATUM_OD;
    TableColumn<BMpvAkcije,Date>  AKC_DATUM_DO;
    TableColumn<BMpvAkcije,String>  AKC_STATUS;
    TableColumn<BMpvAkcije,String>  AKC_OPIS;
    
    @FXML DatePicker AKC_ADD_datum_od;
    @FXML DatePicker AKC_ADD_datum_do;
    @FXML TextField AKC_status;
    @FXML TextField AKC_opis;
    
    
   @FXML  TableView tblListaArtikala;
    ObservableList<BVMpvAkcijeArtikal> AR_data;
    TableColumn<BVMpvAkcijeArtikal,Long>  AR_ID;
    TableColumn<BVMpvAkcijeArtikal,Long>  AR_ARTIKAL;
    TableColumn<BVMpvAkcijeArtikal,String>  AR_SIFRA;
    TableColumn<BVMpvAkcijeArtikal,String>  AR_NAZIV;
    TableColumn<BVMpvAkcijeArtikal,String>  AR_CM;
    TableColumn<BVMpvAkcijeArtikal,String>  AR_ORGJED;
    TableColumn<BVMpvAkcijeArtikal,String>  AR_ORGJED_NAZIV;
    TableColumn<BVMpvAkcijeArtikal,BigDecimal>  AR_KOLICINA;
    
    @FXML Label lblUcitaniSlogovi;
    @FXML Label lblPrikazanoArtikala;
    
    

    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
          prikaziAkcije();
          
          
            tblListaAkcija.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tblListaAkcija.getSelectionModel().getSelectedItem() != null) 
        {    
          
           TableView.TableViewSelectionModel selectionModel = tblListaAkcija.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);
           prikaziArtikle(AKC_data.get(tblListaAkcija.getSelectionModel().getSelectedIndex()).getId().intValue());
           lblUcitaniSlogovi.setText("");
        
           
        }
         }
     });
            
    }   
    
    @FXML
    public void uvezi() throws FileNotFoundException, IOException{
        BufferedReader CSVFile = 
            new BufferedReader(new FileReader( "E:\\vikendd.csv"));

            String dataRow = CSVFile.readLine(); // Read first line.
            // The while checks to see if the data is null. If 
            // it is, we've hit the end of the file. If not, 
            // process the data.

            while (dataRow != null){
            String[] dataArray = dataRow.split(",");
            for (String item:dataArray) { 
            System.out.print(item + "\t"); 
            }
            System.out.println(); // Print the data line.
            dataRow = CSVFile.readLine(); // Read next line of data.
            }
            // Close the file once all data has been read.
            CSVFile.close();

            // End the printout with a blank line.
            System.out.println();
    }
    
    @FXML
    public void uvezi2() throws FileNotFoundException, IOException{
    
        
      String v_status_akcije;
        
            if ((tblListaAkcija.getSelectionModel().getSelectedIndex()>-1)  )
       {
           v_status_akcije=AKC_data.get(tblListaAkcija.getSelectionModel().getSelectedIndex()).getStatus();
         
           
         if (v_status_akcije.equals("P"))
         {  


//lblUcitaniSlogovi

    
        final FileChooser fileChooser = new FileChooser();
         FileChooser.ExtensionFilter extFilter = 
                        new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
         
                 fileChooser.getExtensionFilters().add(extFilter);
        
          File file = fileChooser.showOpenDialog(null);
                    if (file != null) {
                        //openFile(file);
                       System.out.println(file.getPath()); 
                       
                       BufferedReader CSVFile = 
                        new BufferedReader(new FileReader( file.getPath()));

                        String dataRow = CSVFile.readLine(); // Read first line.
                        // The while checks to see if the data is null. If 
                        // it is, we've hit the end of the file. If not, 
                        // process the data.
                        
                        //prvo ovrisi sve stavke
                  /*       em.getTransaction().begin();
                         StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mpv_obrisi_stavke");
        
             
                        storedprocedure1.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
                        storedprocedure1.setParameter("p_id",  AKC_data.get(tblListaAkcija.getSelectionModel().getSelectedIndex()).getId());


                        storedprocedure1.execute();
                        em.getTransaction().commit();*/
                        
                        //kraj brisanja svih stavki
                     int br_slogova=0;   
                        while (dataRow != null){
                            br_slogova++;
                        String[] dataArray = dataRow.split(",");
                       /* for (String item:dataArray) { 
                        System.out.print(item + "\t"); 
                        }*/
                        System.out.print(dataArray[0] + "\t"); 
                        System.out.print(dataArray[1] + "\t");
                        System.out.print(dataArray[2] + "\t");
                        
                        unosNovogArtikla( AKC_data.get(tblListaAkcija.getSelectionModel().getSelectedIndex()).getId().intValue(),
                                 /*String p_orgjed*/ dataArray[0],
                                 /*String p_sifra*/ dataArray[1],
                                 /*BigDecimal p_kolicina*/ new BigDecimal(dataArray[2])
                                 );
                        
                        System.out.println(); // Print the data line.
                        dataRow = CSVFile.readLine(); // Read next line of data.
                        }
                        lblUcitaniSlogovi.setText("Broj ucitanih slogova je: "+br_slogova);
                        // Close the file once all data has been read.
                        CSVFile.close();

                        // End the printout with a blank line.
                        System.out.println();
                       prikaziArtikle(AKC_data.get(tblListaAkcija.getSelectionModel().getSelectedIndex()).getId().intValue());
                       
                       
                       
                    }
                    
         

 }
         else
         {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Greska!");
            alert.setContentText("Akcija nije u statusu P");
            alert.showAndWait();
         }
       }
       else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Greska!");
            alert.setContentText("Proverite da li ste selektovali red koji brisete!!");
            alert.showAndWait();  
       }           
    } 
    
    @FXML
    public void obrisiArtikle (){
        
      String v_status_akcije;
        
            if ((tblListaAkcija.getSelectionModel().getSelectedIndex()>-1)  )
       {
           v_status_akcije=AKC_data.get(tblListaAkcija.getSelectionModel().getSelectedIndex()).getStatus();
         
           
         if (v_status_akcije.equals("P"))
         {  
    
            em.getTransaction().begin();
                         StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mpv_obrisi_stavke");
        
             
                        storedprocedure1.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
                        storedprocedure1.setParameter("p_id",  AKC_data.get(tblListaAkcija.getSelectionModel().getSelectedIndex()).getId());


                        storedprocedure1.execute();
                        em.getTransaction().commit();
                           prikaziArtikle(AKC_data.get(tblListaAkcija.getSelectionModel().getSelectedIndex()).getId().intValue());
                           
                           
             }
         else
         {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Greska!");
            alert.setContentText("Akcija nije u statusu P");
            alert.showAndWait();
         }
       }
       else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Greska!");
            alert.setContentText("Proverite da li ste selektovali red koji brisete!!");
            alert.showAndWait();  
       }               
                           
    }
    
    public void unosNovogArtikla(Integer p_id, String p_orgjed, String p_sifra,BigDecimal p_kolicina) {
          em.getTransaction().begin();
        StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mpv_insert_artikla");
        
             
        storedprocedure1.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_id",  p_id);
        
        storedprocedure1.registerStoredProcedureParameter("p_orgjed", String.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_orgjed",p_orgjed);
        
        storedprocedure1.registerStoredProcedureParameter("p_sifra", String.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_sifra", p_sifra);
        
        
        storedprocedure1.registerStoredProcedureParameter("p_kolicina", BigDecimal.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_kolicina", p_kolicina);
     
        storedprocedure1.execute();
        em.getTransaction().commit();
       /*  Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                     alert1.setTitle("Information Dialog");
                     alert1.setHeaderText("Insert sloga!");
                     alert1.setContentText("Dodali ste novu vikend akciju");
                     alert1.showAndWait();*/
        
       // prikaziAkcije();
    }
    
    
    public void prikaziAkcije() {
          
        em.clear();
         List<BMpvAkcije>  results =  em.createNamedQuery("BMpvAkcije.findAll").getResultList();
           AKC_data = FXCollections.observableArrayList(results);
          
           
          AKC_ID=new TableColumn ("ID");
          AKC_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
      
          
          AKC_DATUM_OD=new TableColumn ("DATUM_OD");
          AKC_DATUM_OD.setCellValueFactory(new PropertyValueFactory<>("datumOd")); 
          
          AKC_DATUM_DO=new TableColumn ("DATUM_DO");
          AKC_DATUM_DO.setCellValueFactory(new PropertyValueFactory<>("datumDo")); 
          
          AKC_STATUS=new TableColumn ("STATUS");
          AKC_STATUS.setCellValueFactory(new PropertyValueFactory<>("status"));
          
          AKC_OPIS=new TableColumn ("KOMENTAR");
          AKC_OPIS.setCellValueFactory(new PropertyValueFactory<>("opis"));
          
          tblListaAkcija.getColumns().setAll(AKC_ID,AKC_DATUM_OD,AKC_DATUM_DO,AKC_STATUS,AKC_OPIS);
          tblListaAkcija.setItems(AKC_data);
    }
    
    
  public void prikaziArtikle(Integer id_akc) {
 
      
        em.clear();
         List<BVMpvAkcijeArtikal>  results =  em.createNamedQuery("BVMpvAkcijeArtikal.findById")
                 .setParameter("id", id_akc)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList();
           AR_data = FXCollections.observableArrayList(results);
          lblPrikazanoArtikala.setText("Broj artikala u bazi je: "+results.size());   
           
          AR_ID=new TableColumn ("ID");
          AR_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
      
          
          AR_ARTIKAL=new TableColumn ("id artikla");
          AR_ARTIKAL.setCellValueFactory(new PropertyValueFactory<>("artikal")); 
          
          AR_SIFRA=new TableColumn ("šifra");
          AR_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra")); 
          
          AR_NAZIV=new TableColumn ("naziv");
          AR_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          AR_CM=new TableColumn ("CM");
          AR_CM.setCellValueFactory(new PropertyValueFactory<>("cm"));
          
          AR_ORGJED=new TableColumn ("orgjed");
          AR_ORGJED.setCellValueFactory(new PropertyValueFactory<>("orgjed"));
          
          AR_ORGJED_NAZIV=new TableColumn ("naziv OJ");
          AR_ORGJED_NAZIV.setCellValueFactory(new PropertyValueFactory<>("nazivOj"));
          
          AR_KOLICINA=new TableColumn ("količina");
          AR_KOLICINA.setCellValueFactory(new PropertyValueFactory<>("sredjenaKolicina"));
          
          tblListaArtikala.getColumns().setAll(AR_ID,AR_ARTIKAL,AR_SIFRA,AR_NAZIV,AR_CM,AR_ORGJED,AR_ORGJED_NAZIV,AR_KOLICINA);
          tblListaArtikala.setItems(AR_data);
  }
    
    @FXML
    public void unosNoveAkcije() {
          em.getTransaction().begin();
        StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mpv_unos_akcije");
        
       
       
        storedprocedure1.registerStoredProcedureParameter("p_datum_od", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_datum_od",  Date.from( AKC_ADD_datum_od.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        
        storedprocedure1.registerStoredProcedureParameter("p_datum_do", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_datum_do", Date.from( AKC_ADD_datum_do.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        
        storedprocedure1.registerStoredProcedureParameter("p_status", String.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_status", "P");
        
        
        storedprocedure1.registerStoredProcedureParameter("p_opis", String.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_opis", AKC_opis.getText());
     
        storedprocedure1.execute();
        em.getTransaction().commit();
         Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                     alert1.setTitle("Information Dialog");
                     alert1.setHeaderText("Insert sloga!");
                     alert1.setContentText("Dodali ste novu vikend akciju");
                     alert1.showAndWait();
        
        prikaziAkcije();
    }
   
    
    @FXML
    public void obrisiAkciju() {
        
        String v_status_akcije;
        
            if ((tblListaAkcija.getSelectionModel().getSelectedIndex()>-1)  )
       {
           v_status_akcije=AKC_data.get(tblListaAkcija.getSelectionModel().getSelectedIndex()).getStatus();
         
           
         if (v_status_akcije.equals("P"))
         {  
           em.getTransaction().begin();
             
             List<BMpvAkcije> b  =  em.createNamedQuery("BMpvAkcije.findById")
               .setParameter("id",AKC_data.get(tblListaAkcija.getSelectionModel().getSelectedIndex()).getId())
               .getResultList();

                    if (!b.isEmpty())
                    {
                           em.remove(b.get(0));
                           em.getTransaction().commit();
                    }
                     prikaziAkcije();

                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                         alert.setTitle("Information Dialog");
                         alert.setHeaderText("Brisanje akcije");
                         alert.setContentText("Obrisali ste akciju");
                         alert.showAndWait();  
         }
         else
         {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Greska!");
            alert.setContentText("Akcija nije u statusu P");
            alert.showAndWait();
         }
       }
       else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Greska!");
            alert.setContentText("Proverite da li ste selektovali red koji brisete!!");
            alert.showAndWait();  
       }
    }
    
    
     @FXML
    public void zatvoriAkciju() {
        
        String v_status_akcije;
        
            if ((tblListaAkcija.getSelectionModel().getSelectedIndex()>-1)  )
       {
           v_status_akcije=AKC_data.get(tblListaAkcija.getSelectionModel().getSelectedIndex()).getStatus();
         
           
         if (v_status_akcije.equals("P"))
              {   
             // prvo generisi matricu razvoza
             
              em.getTransaction().begin();
        StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mpv_akc_generisi_dopune");
        
        storedprocedure1.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_id", AKC_data.get(tblListaAkcija.getSelectionModel().getSelectedIndex()).getId());
        
        storedprocedure1.registerStoredProcedureParameter("p_datum_od", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_datum_od", AKC_data.get(tblListaAkcija.getSelectionModel().getSelectedIndex()).getDatumOd2());
        
        storedprocedure1.registerStoredProcedureParameter("p_datum_do", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_datum_do", AKC_data.get(tblListaAkcija.getSelectionModel().getSelectedIndex()).getDatumDo2());
        
        storedprocedure1.execute();
             //kraj generisanja matrice razvoza
             
       em.getTransaction().commit();
             
             
       
           em.getTransaction().begin();
             
             List<BMpvAkcije> b  =  em.createNamedQuery("BMpvAkcije.findById")
               .setParameter("id",AKC_data.get(tblListaAkcija.getSelectionModel().getSelectedIndex()).getId())
               .getResultList();

                    if (!b.isEmpty())
                    {
                         //  em.remove(b.get(0));
                        b.get(0).setStatus("Z");
                           em.getTransaction().commit();
                    }
                     prikaziAkcije();

                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                         alert.setTitle("Information Dialog");
                         alert.setHeaderText("Zatvaranje akcije");
                         alert.setContentText("Zatvorili ste akciju");
                         alert.showAndWait();  
         }
         else
         {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Greska!");
                alert.setContentText("Akcija nije u statusu P. Nije dozvoljeno menjanje");
                alert.showAndWait();
         }
       }
       else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Greska!");
            alert.setContentText("Proverite da li ste selektovali red koji brisete!!");
            alert.showAndWait();  
       }
    }
    
}
