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
public class FXMLMpAkcMarketingController implements Initializable {

     private EntityManager em;
   
     
     
     
     
     
     
    @Override
       public void initialize(URL url, ResourceBundle rb) {
        this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager(); 
    
        prikaziAkcije2Maska();
        prikaziTipReklame();
        listaSvihTipovaReklama();
   
       }
      
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
    
    @FXML   TableView tbl_akc_tip_reklame; 
            
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
       
       
     // Podaci za tabelu akcije marketing (view)  1 tab
      @FXML   TableView tbl_v_akc_marketing; 
            
            TableColumn<BVMpAkcMarketing,Integer> AKC_MARK_ID;
            TableColumn<BVMpAkcMarketing,Long> AKC_MARK_ARTIKAL;
            TableColumn<BVMpAkcMarketing,String> AKC_MARK_NAZIV;
            TableColumn<BVMpAkcMarketing,BigDecimal> AKC_MARK_KOEFICIJENT;
            TableColumn<BVMpAkcMarketing,String> AKC_MARK_TIP_REKLAME;
            TableColumn<BVMpAkcMarketing,String> AKC_MARK_OPIS;
       
            ObservableList<BVMpAkcMarketing> AKC_MARKETING_data;


            
             public void prikaziTipReklame() {
           em.clear();
        List<BMpAkcTipReklame>  results =  em.createNamedQuery("BMpAkcTipReklame.findAll").getResultList();
          
        
          AKC_TIP_REKLAME_data = FXCollections.observableArrayList(results);
          
           
          AKC_TIP_REKLAME_NAZIV=new TableColumn ("NAZIV");
          AKC_TIP_REKLAME_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          
        
          
          tbl_akc_tip_reklame.getColumns().setAll(AKC_TIP_REKLAME_NAZIV);
     
          tbl_akc_tip_reklame.setItems(AKC_TIP_REKLAME_data);
          
            
             }
            
            
            
            
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
          
         prikaziViewAkcMarketing();
         popuniArtikalUComboBox();
         prikaziTipReklame();
        
        }
         }
     });
          
          TextFormatKlasa tc = new TextFormatKlasa();
        tc.postaviDecimalFormat(txt_koeficijent);
      
      }


 
   public void prikaziViewAkcMarketing() {
           em.clear();
       List<BVMpAkcMarketing>  results =  em.createNamedQuery("BVMpAkcMarketing.findById")
                .setParameter("id",AK_data.get(tbl_lista_akcija.getSelectionModel().getSelectedIndex()).getId())
              
               .setHint(QueryHints.MAINTAIN_CACHE, "false")
               .getResultList();    
                
          AKC_MARKETING_data = FXCollections.observableArrayList(results);
          
           
          AKC_MARK_ID=new TableColumn ("ID");
          AKC_MARK_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
          
          AKC_MARK_ARTIKAL=new TableColumn ("ARTIKAL");
          AKC_MARK_ARTIKAL.setCellValueFactory(new PropertyValueFactory<>("artikal"));
          
          AKC_MARK_NAZIV=new TableColumn ("NAZIV");
          AKC_MARK_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv")); 
          
          AKC_MARK_KOEFICIJENT=new TableColumn ("KOEFICIJENT");
          AKC_MARK_KOEFICIJENT.setCellValueFactory(new PropertyValueFactory<>("koeficijent")); 
          
          AKC_MARK_TIP_REKLAME=new TableColumn ("TIP_REKLAME");
          AKC_MARK_TIP_REKLAME.setCellValueFactory(new PropertyValueFactory<>("tipReklame"));
          
          AKC_MARK_OPIS=new TableColumn ("OPIS");
          AKC_MARK_OPIS.setCellValueFactory(new PropertyValueFactory<>("opis"));
          
        
          
          tbl_v_akc_marketing.getColumns().setAll(AKC_MARK_ID,AKC_MARK_ARTIKAL, AKC_MARK_NAZIV,AKC_MARK_KOEFICIJENT,AKC_MARK_TIP_REKLAME,AKC_MARK_OPIS);
     
          tbl_v_akc_marketing.setItems(AKC_MARKETING_data);
      
   }


// METODA KOJA DODAJE TIP REKLAME 2 TAB TABELA
    public void dodajAkcTipReklame()  {
          try {
                    em.clear();
                    em.getTransaction().begin();

                    BMpAkcTipReklame b = new BMpAkcTipReklame();

                    b.setNaziv(txt_tip_reklame.getText());
                 
                    em.persist(b);
                    em.getTransaction().commit();
                    prikaziTipReklame();
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Stavke grupe");
                    alert1.setHeaderText("Stavke grupe - unos");
                    alert1.setContentText("Uneli ste novu stavku za selektovanu grupu");
                    alert1.showAndWait();
            
           
            
                    
             
                    txt_tip_reklame.clear();
                    
                    prikaziTipReklame();
        } catch (Exception e) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error info");
            alert1.setHeaderText("ERROR");
            alert1.setContentText("Doslo je do greške. "+e.getMessage());
            alert1.showAndWait();
        }
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
      
      
      
      
      
      
      
      public void listaSvihTipovaReklama() {
       em.clear();
          List<String>  results =  em.createNamedQuery("BMpAkcTipReklame.pozovi")
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                  .getResultList();
       
        
       ObservableList obList3 = FXCollections.observableList(results);
         
        cmb_odabir_tipa_reklame.getItems().clear();
        cmb_odabir_tipa_reklame.setItems( obList3);
        cmb_odabir_tipa_reklame.getSelectionModel().select(0);
       prikaziTipReklame();
     }
      




// Metoda koja poziva proceduru za popunjavanje vrednosti u VIEW tabelu MP AKC MARKETING
    @FXML 
     public void korigujVrednosti () {
         
          em.clear();
      /*  List<Integer>  results =  em.createNamedQuery("BMpAkcije.MaxIdZ")
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
        
        System.out.println(results.get(0));*/
         //nadji max id akcije i samo na njemu dozvoli rucnu izmenu kolicina
         
      if (tbl_lista_akcija.getSelectionModel().getSelectedItem() != null) {      
         
      //  if (results.get(0)==AK_data.get(tbl_lista_akcija.getSelectionModel().getSelectedIndex()).getId()) 
        if(!AK_data.get(tbl_lista_akcija.getSelectionModel().getSelectedIndex()).getStatus().equals("Z")
                ) 
        {
            
                            if ( proveriPodatke().equals("OK"))
                            {
         
                                                    try {



                                                                            

                                                              em.getTransaction().begin();
                                                              StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mp_akc_unos_marketing_artikl");

                                                              storedprocedure1.registerStoredProcedureParameter("P_ID", Integer.class, ParameterMode.IN);
                                                              storedprocedure1.setParameter("P_ID",AK_data.get(tbl_lista_akcija.getSelectionModel().getSelectedIndex()).getId());

                                                             

                                                              storedprocedure1.registerStoredProcedureParameter("P_NAZIV_ARTIKLA", String.class, ParameterMode.IN);
                                                              storedprocedure1.setParameter("P_NAZIV_ARTIKLA",cmb_odabir_artikla.getValue().toString());

                                                              storedprocedure1.registerStoredProcedureParameter("P_TIP_REKLAME", String.class, ParameterMode.IN);
                                                              storedprocedure1.setParameter("P_TIP_REKLAME",cmb_odabir_tipa_reklame.getValue().toString());

                                                              storedprocedure1.registerStoredProcedureParameter("P_KOEFICIJENT", BigDecimal.class, ParameterMode.IN);
                                                              storedprocedure1.setParameter("P_KOEFICIJENT", new BigDecimal(txt_koeficijent.getText()) );

                                                              storedprocedure1.registerStoredProcedureParameter("p_opis", String.class, ParameterMode.IN);
                                                              storedprocedure1.setParameter("p_opis", txt_opis.getText());


                                                              storedprocedure1.execute();
                                                              em.getTransaction().commit();
                                                              prikaziViewAkcMarketing();
                                                               
                                                              Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                                              alert1.setTitle("Information Dialog");
                                                              alert1.setHeaderText("Unos rucne korekcije!");
                                                              alert1.setContentText("Uneli ste rucnu korekciiju");
                                                              alert1.showAndWait();
                                                              
                                                              //cmb_odabir_artikla.getButtonCell().setText("");
                                                             // cmb_odabir_artikla.getButtonCell().setItem(null);
                                                              
                                                             // cmb_odabir_tipa_reklame.getButtonCell().setText("");
                                                              //cmb_odabir_tipa_reklame.getButtonCell().setItem(null);
                                                              txt_opis.clear();
                                                              txt_koeficijent.clear();

                                                  } catch (Exception e) {
                                                       Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                                              alert1.setTitle("Information Dialog");
                                                              alert1.setHeaderText("Greska!");
                                                              alert1.setContentText(e.getMessage());
                                                              alert1.showAndWait();
                                                  }
        
                            }
                             else
                        {
                               Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                     alert1.setTitle("Information Dialog");
                                     alert1.setHeaderText("Greska!");
                                     alert1.setContentText(proveriPodatke());
                                     alert1.showAndWait(); 
                        }
                 
        }              
            else
            {
               Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                     alert1.setTitle("Information Dialog");
                     alert1.setHeaderText("Greska!");
                     alert1.setContentText("Možete ručno korigovati samo akciju koja nije zatvorena!");
                     alert1.showAndWait();  
            }
           
       } else {
                                                              Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                                              alert1.setTitle("Information Dialog");
                                                              alert1.setHeaderText("Greska!");
                                                              alert1.setContentText("Prvo selektujte artikal");
                                                              alert1.showAndWait();
                                                          }     
        
       
         
     }


 public String proveriPodatke() {
         
         
         String v_a="OK";
         
         
        
        
        
         if ("".equals(txt_opis.getText())) v_a=" Unesite razloge korekcije u polju opis";
         if ("".equals(txt_koeficijent.getText())) v_a=" Niste odredili koeficijent";
         
         if (cmb_odabir_artikla.getSelectionModel().getSelectedIndex()==-1) v_a=" Niste selektovali artikal";
         if (cmb_odabir_tipa_reklame.getSelectionModel().getSelectedIndex()==-1) v_a=" Niste selektovali tip reklame";
         
         
         return v_a;
     }
   

}



