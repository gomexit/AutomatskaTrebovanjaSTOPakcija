/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.eclipse.persistence.config.QueryHints;

/**
 * FXML Controller class
 *
 * @author laki
 */
public class FXMLIzuzeciIzAsortimana implements Initializable {

     private EntityManager em;
   
     
     
     
     
     
     
    @Override
       public void initialize(URL url, ResourceBundle rb) {
        this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager(); 
    
        prikaziAkcije2Maska();
        
      // prikaziTabeluArtikliOrgjedIskljuceni();
   
       }
       @FXML ComboBox cmb_popuni_orgjed;
       @FXML ComboBox cmb_odabir_tipa_reklame;
       @FXML ComboBox cmb_odabir_artikla;
       @FXML TextArea txt_opis;
       @FXML TextField              txt_koeficijent;
       @FXML TextField txt_tip_reklame;
       
       //DODAJ MP AKC MARKETING
     @FXML TextField txt_mp_akc_marketing_artikal;
     @FXML TextField txt_mp_akc_marketing_koeficijent;
     @FXML TextField txt_mp_akc_tip_reklame;
     @FXML TextField txt_mp_akc_marketing_opis;
     
         //izmeni podatke MP AKC MARKETING
     @FXML TextField txt_edit_mp_akc_marketing_artikal;
     @FXML TextField txt_edit_mp_akc_marketing_koeficijent;
     @FXML TextField txt_edit_mp_akc_tip_reklame;
     @FXML TextField txt_edit_mp_akc_marketing_opis;
     
    //Podaci za tabelu tip reklame 2 tab
    
  
            
            TableColumn<BMpAkcTipReklame,String> AKC_TIP_REKLAME_NAZIV;
           
       
            ObservableList<BMpAkcTipReklame> AKC_TIP_REKLAME_data;
       
     
    //Podaci za tabelu lista akcija 1 tab
    
    @FXML   TableView tbl_lista_akcija; 
            
            TableColumn<BMpAkcije,Integer> AK_ID;
            TableColumn<BMpAkcije,String> AK_TIP_AKCIJE;
            TableColumn<BMpAkcije,Date> AK_DATUM_OD;
            TableColumn<BMpAkcije,Date> AK_DATUM_DO;
            TableColumn<BMpAkcije,String> AK_STATUS;
       
            ObservableList<BMpAkcije> AK_data;
            
            
            
            @FXML TableView tbl_V_pregled_ARIOJ; 
            
            TableColumn<BVMpAkcAriojIskljizAkc,Integer> ARIOJ_ID;
            TableColumn<BVMpAkcAriojIskljizAkc,Long> ARIOJ_ARTIKAL;
            TableColumn<BVMpAkcAriojIskljizAkc,String> ARIOJ_NAZIV_ARTIKLA;
            TableColumn<BVMpAkcAriojIskljizAkc,String> ARIOJ_ORGJED;
            TableColumn<BVMpAkcAriojIskljizAkc,String> ARIOJ_NAZIV_ORGJED;
       
            ObservableList<BVMpAkcAriojIskljizAkc> ARIOJ_data;
      
            
            
 public void prikaziAkcije2Maska() {
           em.clear();
        List<BMpAkcije>  results =  em.createNamedQuery("BMpAkcije.findAll").getResultList();
          
        
          AK_data = FXCollections.observableArrayList(results);
          
           
          AK_ID=new TableColumn ("ID");
          AK_ID.setCellValueFactory(new PropertyValueFactory<BMpAkcije,Integer>("id"));
          
          AK_TIP_AKCIJE=new TableColumn ("TIP_AKCIJE");
          AK_TIP_AKCIJE.setCellValueFactory(new PropertyValueFactory<BMpAkcije,String>("tipAkcije"));
          
          AK_DATUM_OD=new TableColumn ("DATUM_OD");
          AK_DATUM_OD.setCellValueFactory(new PropertyValueFactory<BMpAkcije,Date>("datumOd")); 
          
          AK_DATUM_DO=new TableColumn ("DATUM_DO");
          AK_DATUM_DO.setCellValueFactory(new PropertyValueFactory<BMpAkcije,Date>("datumDo")); 
          
          AK_STATUS=new TableColumn ("STATUS");
          AK_STATUS.setCellValueFactory(new PropertyValueFactory<BMpAkcije,String>("status"));
          
        
          
          tbl_lista_akcija.getColumns().setAll(AK_ID, AK_TIP_AKCIJE,AK_DATUM_OD,AK_DATUM_DO,AK_STATUS);
     
          tbl_lista_akcija.setItems(AK_data);
          
           
          
       
        
          
          tbl_lista_akcija.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
       
        if(tbl_lista_akcija.getSelectionModel().getSelectedItem() != null) 
        {    
          
           TableView.TableViewSelectionModel selectionModel = tbl_lista_akcija.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);
          
           List<BMpAkcije> selected = selectionModel.getSelectedItems();
          
            prikaziTabeluArtikliOrgjedIskljuceni();
            popuniArtikalUComboBox();
            popuniMpoUComboBox();
        
        }
         }
     });
          
       
      
      }


      
      
      
      
      
      
      
      
      
      
      
      public void popuniArtikalUComboBox () {
         
         List<BVMpAkcNazVred>  listRadnje =   em.createNativeQuery("SELECT NAZIV,VREDNOST,rownum as broj\n" +
"FROM (\n" +

"    select distinct ar.naziv, ar.id AS VREDNOST\n" +
"    from b_mp_akcije_prepor_kol a, b_mp_akcije_stavke_asw asw, iis.artikli ar\n" +
"    where a.id_akcije=asw.id_akcije\n" +
"    and ar.id=a.artikal\n" +
"    and a.id_kampanje=asw.id_kampanje\n" +
"    and asw.id="+AK_data.get(tbl_lista_akcija.getSelectionModel().getSelectedIndex()).getId()  +"\n" +
"    order by 1\n" +
"    ) EE", BVMpAkcNazVred.class)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                   .getResultList(); 
        
        
          //  List<String> listRadnje = new ArrayList<String>();
        ObservableList obList3 = FXCollections.observableList(listRadnje);
        cmb_odabir_artikla.getItems().clear();

         List<String> listMPO2= new ArrayList<String>(); 
        for ( BVMpAkcNazVred ob :listRadnje)
        {
          listMPO2.add(ob.getNaziv());
        }
      //  ObservableList obList = FXCollections.observableList(listStatus);
          cmb_odabir_artikla.setItems(FXCollections.observableList(listMPO2));
    
      }
      
      
      





 public void popuniMpoUComboBox () {
         
         List<BVMpAkcNazVred>  listRadnje =   em.createNativeQuery("SELECT NAZIV,VREDNOST,rownum as broj\n" +
"FROM (\n" +
"\n" +
"    select distinct oj.naziv, oj.SIFRA AS VREDNOST\n" +
"    from b_mp_akcije_prepor_kol a, b_mp_akcije_stavke_asw asw, IIS.ORGJED oj\n" +
"    where a.id_akcije=asw.id_akcije\n" +
"    and oj.SIFRA=a.ORGJED\n" +
"    and a.id_kampanje=asw.id_kampanje\n" +
"    and asw.id="+AK_data.get(tbl_lista_akcija.getSelectionModel().getSelectedIndex()).getId()  +"\n" +
"    order by 1\n" +
"    ) EE", BVMpAkcNazVred.class)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList(); 
        
        
          //  List<String> listRadnje = new ArrayList<String>();
        ObservableList obList3 = FXCollections.observableList(listRadnje);
        cmb_popuni_orgjed.getItems().clear();

         List<String> listMPO2= new ArrayList<String>(); 
        for ( BVMpAkcNazVred ob :listRadnje)
        {
          listMPO2.add(ob.getNaziv());
        }
      //  ObservableList obList = FXCollections.observableList(listStatus);
          cmb_popuni_orgjed.setItems(FXCollections.observableList(listMPO2));
    
      }

     @FXML 
     public void IzbaciIzAsortArtikOrgjed () {
         
          em.clear();
      
         
      if (tbl_lista_akcija.getSelectionModel().getSelectedItem() != null) {      
         
     
         if(!AK_data.get(tbl_lista_akcija.getSelectionModel().getSelectedIndex()).getStatus().equals("Z")
                )    
                           
          if ( proveriPodatke().equals("OK"))
                            {
                                                


                                                                            

                                                              em.getTransaction().begin();
                                                              StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mp_akc_unos_arioj");

                                                              storedprocedure1.registerStoredProcedureParameter("P_ID", Integer.class, ParameterMode.IN);
                                                              storedprocedure1.setParameter("P_ID",AK_data.get(tbl_lista_akcija.getSelectionModel().getSelectedIndex()).getId());

                                                             

                                                              storedprocedure1.registerStoredProcedureParameter("P_NAZIV_ARTIKLA", String.class, ParameterMode.IN);
                                                              storedprocedure1.setParameter("P_NAZIV_ARTIKLA",cmb_odabir_artikla.getValue());

                                                              storedprocedure1.registerStoredProcedureParameter("P_NAZIV_ORGJED", String.class, ParameterMode.IN);
                                                              storedprocedure1.setParameter("P_NAZIV_ORGJED",cmb_popuni_orgjed.getValue());

                                                   


                                                              storedprocedure1.execute();
                                                              em.getTransaction().commit();
                                                             
                                                               prikaziTabeluArtikliOrgjedIskljuceni();
                                                           
                                                              Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                                              alert1.setTitle("Information Dialog");
                                                              alert1.setHeaderText("Unos rucne korekcije!");
                                                              alert1.setContentText("Uneli ste rucnu korekciiju");
                                                              alert1.showAndWait();
                                                              prikaziTabeluArtikliOrgjedIskljuceni();
                                                           
                                                            

                                                  
                            }
                         
                             else
                        {
                               Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                     alert1.setTitle("Information Dialog");
                                     alert1.setHeaderText("Greska!");
                                     alert1.setContentText(proveriPodatke());
                                     alert1.showAndWait(); 
                        }
                         
                 else
            {
               Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                     alert1.setTitle("Information Dialog");
                     alert1.setHeaderText("Greska!");
                     alert1.setContentText("Možete ručno korigovati samo akciju koja nije zatvorena!");
                     alert1.showAndWait();  
            }
          
       }
     
        
        else {
                                                              Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                                              alert1.setTitle("Information Dialog");
                                                              alert1.setHeaderText("Greska!");
                                                              alert1.setContentText("Prvo selektujte artikal");
                                                              alert1.showAndWait();
                                                          }     
        
       
         
     }



        public String proveriPodatke() {
         
         
         String v_a="OK";
         
         
        
        
        
        
         
         if (cmb_odabir_artikla.getSelectionModel().getSelectedIndex()==-1) v_a=" Niste selektovali artikal";
         if (cmb_popuni_orgjed.getSelectionModel().getSelectedIndex()==-1) v_a=" Niste selektovali Orgjed";
         
         
         return v_a;
     }
 
        
        public void prikaziTabeluArtikliOrgjedIskljuceni() {
           em.clear();
        List<BVMpAkcAriojIskljizAkc>  results =  em.createNamedQuery("BVMpAkcAriojIskljizAkc.findById")
              .setParameter("id", AK_data.get(tbl_lista_akcija.getSelectionModel().getSelectedIndex()).getId())
              .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
                
                
          ARIOJ_data = FXCollections.observableArrayList(results);
          
           
          ARIOJ_ID=new TableColumn ("ID");
          ARIOJ_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
          
          ARIOJ_ARTIKAL=new TableColumn ("ARTIKAL");
          ARIOJ_ARTIKAL.setCellValueFactory(new PropertyValueFactory<>("artikal"));
          
          ARIOJ_NAZIV_ARTIKLA=new TableColumn ("NAZIV_ARTIKLA");
          ARIOJ_NAZIV_ARTIKLA.setCellValueFactory(new PropertyValueFactory<>("nazivArtikla")); 
          
          ARIOJ_ORGJED=new TableColumn ("ORGJED");
          ARIOJ_ORGJED.setCellValueFactory(new PropertyValueFactory<>("orgjed")); 
          
          ARIOJ_NAZIV_ORGJED=new TableColumn ("NAZIV_ORGJED");
          ARIOJ_NAZIV_ORGJED.setCellValueFactory(new PropertyValueFactory<>("nazivOrgjed"));
          
        
          
          tbl_V_pregled_ARIOJ.getColumns().setAll(ARIOJ_ID, ARIOJ_ARTIKAL,ARIOJ_NAZIV_ARTIKLA,ARIOJ_ORGJED,ARIOJ_NAZIV_ORGJED);
     
          tbl_V_pregled_ARIOJ.setItems(ARIOJ_data);
         
}

@FXML
       public void obrisiIskljuceneArtikle() {
    
            
            if ((tbl_V_pregled_ARIOJ.getSelectionModel().getSelectedIndex()>-1)  )
       {
              em.getTransaction().begin();
             
       List<BMpAkcAriojIskljizAkc> b  =  em.createNamedQuery("BMpAkcAriojIskljizAkc.findBySve")
               .setParameter("id", ARIOJ_data.get(tbl_V_pregled_ARIOJ.getSelectionModel().getSelectedIndex()).getId())
               .setParameter("orgjed", ARIOJ_data.get(tbl_V_pregled_ARIOJ.getSelectionModel().getSelectedIndex()).getOrgjed())
               .setParameter("artikal", ARIOJ_data.get(tbl_V_pregled_ARIOJ.getSelectionModel().getSelectedIndex()).getArtikal())
               .getResultList();

       if (!b.isEmpty())
       {
              em.remove(b.get(0));
              em.getTransaction().commit();
         prikaziTabeluArtikliOrgjedIskljuceni();
       
       }
       
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Brisanje uspešno");
            alert.setContentText("Obrisali ste iskljucene artikle");
            alert.showAndWait();  
       prikaziTabeluArtikliOrgjedIskljuceni();
       }
       else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Greška!");
            alert.setContentText("Proverite da li ste selektovali red koji brišete!!");
            alert.showAndWait();  
       }
          
      
       }

}