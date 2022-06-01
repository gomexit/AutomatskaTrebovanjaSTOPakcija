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
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
import javax.persistence.StoredProcedureQuery;
import org.eclipse.persistence.config.QueryHints;

/**
 * FXML Controller class
 *
 * @author bojan
 */
public class FXMLRucnaKorekcijaKolController implements Initializable {
     
    private EntityManager em;
     ObservableList<BMpAkcije> AK_data;
     ObservableList<BVMpAkcRucneKorekcije> RK_data;
     
    
    @FXML     TableView tbl_lista_akcija; 
    @FXML     TableColumn<BMpAkcije,Integer> ID;
    @FXML     TableColumn<BMpAkcije,String> TIP_AKCIJE;
    @FXML     TableColumn<BMpAkcije,Date> DATUM_OD;
    @FXML     TableColumn<BMpAkcije,Date> DATUM_DO;
    @FXML     TableColumn<BMpAkcije,String> STATUS;
    @FXML     TableColumn<BMpAkcije,String> KOMENTAR;
    
    @FXML ComboBox cmb_odabir_mpo;
    @FXML ComboBox cmb_odabir_artikla;
    @FXML ComboBox cmb_odabir_tipa_korekcije;
    @FXML TextField txt_koeficijent;
    @FXML TextArea txt_opis;
    
     @FXML     TableView tbl_lista_korekcija; 
     @FXML   TableColumn<BVMpAkcRucneKorekcije,Integer> RK_ID;
     @FXML   TableColumn<BVMpAkcRucneKorekcije,Long> RK_ARTIKAL;
     @FXML   TableColumn<BVMpAkcRucneKorekcije,String> RK_NAZ_ARTIKAL;
     @FXML   TableColumn<BVMpAkcRucneKorekcije,String> RK_ORGJED;
     @FXML   TableColumn<BVMpAkcRucneKorekcije,String> RK_NAZ_OJ;
     @FXML   TableColumn<BVMpAkcRucneKorekcije,BigDecimal> RK_KOEFICIJENT;
     @FXML   TableColumn<BVMpAkcRucneKorekcije,String> RK_OPIS;
     @FXML   TableColumn<BVMpAkcRucneKorekcije,Long> RK_BROJ;
     @FXML   TableColumn<BVMpAkcRucneKorekcije,String> RK_TIP_KOREKCIJE;
     @FXML   TableColumn<BVMpAkcRucneKorekcije,BigDecimal> RK_TIP_KOLICINA;
    
     
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
        popuniInicijalno();
        popuniCMB();
    }    

    private void popuniInicijalno() {
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
          
          KOMENTAR=new TableColumn ("KOMENTAR");
          KOMENTAR.setCellValueFactory(new PropertyValueFactory<BMpAkcije,String>("komentar"));
          
          tbl_lista_akcija.getColumns().setAll(ID, TIP_AKCIJE,DATUM_OD,DATUM_DO,STATUS,KOMENTAR);
     
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
          popuniMPO ();
          popuniArtikal ();
          vratiRucneKorekcije();

           
         }
         }
     });
           
           
             TextFormatKlasa tc = new TextFormatKlasa();
        tc.postaviDecimalFormat(txt_koeficijent);
           
    }
    
    
    
    
    public void popuniCMB() {
        
       List<String> listStatus = new ArrayList<String>();
        listStatus.add("MNOZENJE");
        listStatus.add("SABIRANJE");               
        ObservableList obList = FXCollections.observableList(listStatus);
        cmb_odabir_tipa_korekcije.getItems().clear();
        cmb_odabir_tipa_korekcije.setItems(obList);
        
       
 
    }
    
    public void popuniMPO () {
         
         List<BVMpAkcNazVred>  listRadnje =   em.createNativeQuery("SELECT NAZIV,VREDNOST, rownum as BROJ\n" +
"FROM (\n" +
"    select ' SVI MP OBJEKTI' NAZIV,-1 AS VREDNOST FROM DUAL\n" +
"    UNION\n" +
"    select distinct oj.naziv, TO_NUMBER(OJ.SIFRA) AS VREDNOST\n" +
"    from b_mp_akcije_prepor_kol a, b_mp_akcije_stavke_asw asw, iis.orgjed oj\n" +
"    where a.id_akcije=asw.id_akcije\n" +
"    and oj.sifra=a.orgjed\n" +
"    and a.id_kampanje=asw.id_kampanje\n" +
"    and asw.id="+AK_data.get(tbl_lista_akcija.getSelectionModel().getSelectedIndex()).getId()  +"\n" +
"    order by 1\n" +
"    ) EE", BVMpAkcNazVred.class)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList(); 
        
        
          //  List<String> listRadnje = new ArrayList<String>();
        ObservableList obList3 = FXCollections.observableList(listRadnje);
        cmb_odabir_mpo.getItems().clear();

         List<String> listMPO2= new ArrayList<String>(); 
        for ( BVMpAkcNazVred ob :listRadnje)
        {
          listMPO2.add(ob.getNaziv());
        }
      //  ObservableList obList = FXCollections.observableList(listStatus);
          cmb_odabir_mpo.setItems(FXCollections.observableList(listMPO2));
    }
    
     public void popuniArtikal () {
         
         List<BVMpAkcNazVred>  listRadnje =   em.createNativeQuery("SELECT NAZIV,VREDNOST,rownum as broj\n" +
"FROM (\n" +
"    select ' SVI ARTIKLI' NAZIV,-1 AS VREDNOST FROM DUAL\n" +
"    UNION\n" +
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
     
     
     public void vratiRucneKorekcije() {
        
          em.clear();
        List<BVMpAkcRucneKorekcije>  results =  em.createNamedQuery("BVMpAkcRucneKorekcije.findById")
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .setParameter("id",AK_data.get(tbl_lista_akcija.getSelectionModel().getSelectedIndex()).getId() )
                .getResultList();
          RK_data = FXCollections.observableArrayList(results);
          
           
          RK_ID=new TableColumn ("id");
          RK_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
          
          RK_ARTIKAL=new TableColumn ("artikal");
          RK_ARTIKAL.setCellValueFactory(new PropertyValueFactory<>("artikal"));
          
          RK_NAZ_ARTIKAL=new TableColumn ("naziv_artikla");
          RK_NAZ_ARTIKAL.setCellValueFactory(new PropertyValueFactory<>("nazivArtikla"));
          
          RK_ORGJED=new TableColumn ("orgjed");
          RK_ORGJED.setCellValueFactory(new PropertyValueFactory<>("orgjed"));
          
          
          RK_NAZ_OJ=new TableColumn ("naziv_oj");
          RK_NAZ_OJ.setCellValueFactory(new PropertyValueFactory<>("nazivOj"));
          
          RK_TIP_KOREKCIJE=new TableColumn ("tip_korekcije");
          RK_TIP_KOREKCIJE.setCellValueFactory(new PropertyValueFactory<>("tipKorekcije"));
            
          RK_KOEFICIJENT=new TableColumn ("koeficijent");
          RK_KOEFICIJENT.setCellValueFactory(new PropertyValueFactory<>("koeficijent"));
          
          RK_OPIS=new TableColumn ("opis");
          RK_OPIS.setCellValueFactory(new PropertyValueFactory<>("opis"));
          
          RK_TIP_KOREKCIJE=new TableColumn ("tip_korekcije");
          RK_TIP_KOREKCIJE.setCellValueFactory(new PropertyValueFactory<>("tipKorekcije"));
          
          
          
          
          
          
          tbl_lista_korekcija.getColumns().setAll(RK_ID,RK_ARTIKAL,RK_NAZ_ARTIKAL,RK_ORGJED,RK_NAZ_OJ,RK_TIP_KOREKCIJE,RK_KOEFICIJENT,RK_OPIS);
     
          tbl_lista_korekcija.setItems(RK_data);
         

     }
     
     
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
                                                              StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mp_akc_rucna_korekcija");

                                                              storedprocedure1.registerStoredProcedureParameter("P_ID", Integer.class, ParameterMode.IN);
                                                              storedprocedure1.setParameter("P_ID",AK_data.get(tbl_lista_akcija.getSelectionModel().getSelectedIndex()).getId());

                                                              storedprocedure1.registerStoredProcedureParameter("P_RADNJA", String.class, ParameterMode.IN);
                                                              storedprocedure1.setParameter("P_RADNJA",cmb_odabir_mpo.getValue().toString());

                                                              storedprocedure1.registerStoredProcedureParameter("P_NAZIV_ARTIKLA", String.class, ParameterMode.IN);
                                                              storedprocedure1.setParameter("P_NAZIV_ARTIKLA",cmb_odabir_artikla.getValue().toString());

                                                              storedprocedure1.registerStoredProcedureParameter("P_TIP_KOREKCIJE", String.class, ParameterMode.IN);
                                                              storedprocedure1.setParameter("P_TIP_KOREKCIJE",cmb_odabir_tipa_korekcije.getValue().toString());

                                                              storedprocedure1.registerStoredProcedureParameter("P_KOEF", BigDecimal.class, ParameterMode.IN);
                                                              storedprocedure1.setParameter("P_KOEF", new BigDecimal(txt_koeficijent.getText()) );

                                                              storedprocedure1.registerStoredProcedureParameter("p_opis", String.class, ParameterMode.IN);
                                                              storedprocedure1.setParameter("p_opis", txt_opis.getText());


                                                              storedprocedure1.execute();
                                                              em.getTransaction().commit();
                                                              vratiRucneKorekcije();
                                                               Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                                              alert1.setTitle("Information Dialog");
                                                              alert1.setHeaderText("Unos rucne korekcije!");
                                                              alert1.setContentText("Uneli ste rucnu korekciiju");
                                                              alert1.showAndWait();
                                                         


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
                                                              alert1.setContentText("Prvo selektujte akciju");
                                                              alert1.showAndWait();
                                                          }     
        
       
         
     }
     
     
     public String proveriPodatke() {
         
         
         String v_a="OK";
         
         
        
        
        
         if ("".equals(txt_opis.getText())) v_a=" Unesite razloge korekcije u polju opis";
         if ("".equals(txt_koeficijent.getText())) v_a=" Niste odredili koeficijent";
         if (cmb_odabir_tipa_korekcije.getSelectionModel().getSelectedIndex()==-1) v_a=" Niste selektovali računsku operaciju"; 
         if (cmb_odabir_artikla.getSelectionModel().getSelectedIndex()==-1) v_a=" Niste selektovali radnju";
         if (cmb_odabir_mpo.getSelectionModel().getSelectedIndex()==-1) v_a=" Niste selektovali mpo";
         
         
         return v_a;
     }
    
}
