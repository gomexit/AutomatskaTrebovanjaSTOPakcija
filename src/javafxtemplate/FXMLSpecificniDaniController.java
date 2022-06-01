/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.math.BigDecimal;
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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.swing.JOptionPane;
import org.eclipse.persistence.config.QueryHints;


/**
 * FXML Controller class
 *
 * @author bojan
 */
public class FXMLSpecificniDaniController implements Initializable {

    
//prvi tab
    @FXML TableView tblSD;
    @FXML TableColumn<BMpAkcSpecificniDani,Date> SD_DATUM;
    @FXML TableColumn<BMpAkcSpecificniDani,BigDecimal> SD_KOEF_PREHRANA;
    @FXML TableColumn<BMpAkcSpecificniDani,BigDecimal> SD_KOEF_NEPREHRANA;    
    
    @FXML TextField txt_add_koef_prehrana;
    @FXML TextField txt_add_koef_neprehrana;
    @FXML DatePicker dp_add_datum;   
    
    @FXML TextField txt_edit_koef_prehrana;
    @FXML TextField txt_edit_koef_neprehrana;
    @FXML DatePicker dp_edit_datum;
    
    
    
//drugi tab
    @FXML TableView tblSD_OJ;
    @FXML TableColumn<BVMpAkcSpecificniDaniOj,Date> SD_OJ_DATUM;
    @FXML TableColumn<BVMpAkcSpecificniDaniOj,BigDecimal> SD_OJ_KOEF_PREHRANA;
    @FXML TableColumn<BVMpAkcSpecificniDaniOj,BigDecimal> SD_OJ_KOEF_NEPREHRANA;
    @FXML TableColumn<BVMpAkcSpecificniDaniOj,String> SD_OJ_KOEF_ORGJED;
    @FXML TableColumn<BVMpAkcSpecificniDaniOj,String> SD_OJ_KOEF_NAZIV;
    
    @FXML TextField txt2_add_koef_prehrana;
    @FXML TextField txt2_add_koef_neprehrana;
    @FXML TextField txt2_add_oj_sifra;
    @FXML TextField txt2_add_oj_naziv;
    @FXML DatePicker dp2_add_datum; 
    
//treci tab
    @FXML TableView tblSD_RG;
    @FXML TableColumn<BVMpAkcSpecificniDaniRg,Date> SD_RG_DATUM;
    @FXML TableColumn<BVMpAkcSpecificniDaniRg,BigDecimal> SD_RG_KOEF;
    @FXML TableColumn<BVMpAkcSpecificniDaniRg,String> SD_RG_RG;
    @FXML TableColumn<BVMpAkcSpecificniDaniRg,String> SD_RG_NAZIV_RG;
    @FXML TableColumn<BVMpAkcSpecificniDaniRg,String> SD_RG_NAZIV_NAGRUPE; 
    
    @FXML TextField txt3_add_koef;
    @FXML TextField txt3_add_rg_sifra;
    @FXML TextField txt3_add_rg_naziv;
    @FXML DatePicker dp3_add_datum; 
    @FXML DatePicker dp_datum_od;
    @FXML DatePicker dp_datum_do;
    
 //cetvrti tab   
  @FXML TableView tblSD_RGOJ;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,Date> SD_RGOJ_DATUM;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,BigDecimal> SD_RGOJ_KOEF;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,String> SD_RGOJ_RG;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,String> SD_RGOJ_NAZIV_RG;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,String> SD_RGOJ_OJ; 
    @FXML TableColumn<BVMpAkcSpecDanRgOj,String> SD_RGOJ_OJ_NAZIV;
    
    @FXML TextField txt4_add_koef;
    @FXML TextField txt4_add_rg_sifra;
    @FXML TextField txt4_add_rg_naziv;
    @FXML DatePicker dp4_add_datum; 
    @FXML TextField txt4_add_oj;
    @FXML TextField txt4_add_oj_naziv;
    
    
  //peti tab   
    @FXML TableView tblSD_ART;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,Date> SD_ART_DATUM;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,BigDecimal> SD_ART_KOEF;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,Long> SD_ART_ART;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,String> SD_ART_SIFRA;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,String> SD_ART_NAZIV;
    
    @FXML TextField txt5_add_koef;
    @FXML TextField txt5_add_art_art;
    @FXML TextField txt5_add_naziv;
    @FXML DatePicker dp5_add_datum; 
    @FXML DatePicker dp5_add_datum_od;
    
 //spisak radnji   
    @FXML TableView tbl_spisak_OJ;
    @FXML TableColumn<BVMpAkcRadnje,String> SD_SPISAK_OJ_ORGJED;
    @FXML TableColumn<BVMpAkcRadnje,String> SD_SPISAK_OJ_NAZIV;
    @FXML TextField txt_pretraga_OJ;
    
     //spisak radnji za cetvrti_tab   
    @FXML TableView tbl_spisak_OJ4;
    @FXML TableColumn<BVMpAkcRadnje,String> SD_SPISAK_OJ4_ORGJED;
    @FXML TableColumn<BVMpAkcRadnje,String> SD_SPISAK_OJ4_NAZIV;
    @FXML TextField txt_pretraga_OJ4;
    
    
 //spisak robnih grupa   
    @FXML TableView tbl_spisak_RG;
    @FXML TableColumn<BVMpAkcRgSifarnik,String> SD_SPISAK_RG_SIFRA;
    @FXML TableColumn<BVMpAkcRgSifarnik,String> SD_SPISAK_RG_NAZIV;
    @FXML TableColumn<BVMpAkcRgSifarnik,String> SD_SPISAK_RG_NAZIV_NADGRUPE1;
    @FXML TextField txt_pretraga_RG;   
    
     //spisak robnih grupa   za cetvrti tab
    @FXML TableView tbl_spisak_RG4;
    @FXML TableColumn<BVMpAkcRgSifarnik,String> SD_SPISAK_RG4_SIFRA;
    @FXML TableColumn<BVMpAkcRgSifarnik,String> SD_SPISAK_RG4_NAZIV;
    @FXML TableColumn<BVMpAkcRgSifarnik,String> SD_SPISAK_RG4_NAZIV_NADGRUPE1;
    @FXML TextField txt_pretraga_RG4; 
     //ObservableList<BVMpAkcRgSifarnik> RG_spisak_data;
    
    //spisak artikala
    @FXML TableView tbl_artikli;
    @FXML TextField txt_search_artikli;
    @FXML TableColumn<BVMpAkcArtikli,BigDecimal>  AR_ID;
    @FXML TableColumn<BVMpAkcArtikli,String> AR_SIFRA;
    @FXML TableColumn<BVMpAkcArtikli,String> AR_NAZIV;
    @FXML TableColumn<BVMpAkcArtikli,String>  AR_RG;
    
    
     private EntityManager em;
     ObservableList<BMpAkcSpecificniDani> SD_data;
     ObservableList<BVMpAkcSpecificniDaniOj> SD_OJ_data;
     ObservableList<BVMpAkcSpecificniDaniRg> SD_RG_data;
     ObservableList<BVMpAkcSpecDanRgOj> SD_RGOJ_data;
     ObservableList<BVMpAkcSpecDaniArt> SD_ART_data;
     ObservableList<BVMpAkcArtikli> AR_data;
     ObservableList<BVMpAkcRadnje> OJ_spisak_data; ObservableList<BVMpAkcRadnje> OJ4_spisak_data;
     ObservableList<BVMpAkcRgSifarnik> RG_spisak_data; ObservableList<BVMpAkcRgSifarnik> RG4_spisak_data;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
        popuniInicijalno();
        popuniInicijalno2();
        popuniInicijalno3(); 
        popuniInicijalno4(); 
        popuniInicijalno5();
        
        
          tblSD.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
          if(tblSD.getSelectionModel().getSelectedItem() != null) 
        {    
          
           TableView.TableViewSelectionModel selectionModel = tblSD.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);
           
           txt_edit_koef_prehrana.setText(SD_data.get(tblSD.getSelectionModel().getSelectedIndex()).getKoefPrehrana().toString() );
           txt_edit_koef_neprehrana.setText(SD_data.get(tblSD.getSelectionModel().getSelectedIndex()).getKoefNeprehrana().toString() );
           
           Date input = SD_data.get( tblSD.getSelectionModel().getSelectedIndex()).getDatum2();
           LocalDate datee = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
           dp_edit_datum.setValue(datee);
           
        
         }
         }
     });
          
          
        // TODO
    }    

    private void popuniInicijalno() {
          
        em.clear();
        List<BMpAkcSpecificniDani>  results =  em.createNamedQuery("BMpAkcSpecificniDani.findAll")
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
           SD_data = FXCollections.observableArrayList(results);
  
           tblSD.getColumns().setAll(SD_KOEF_PREHRANA);
        
          SD_DATUM=new TableColumn ("datum");
          SD_DATUM.setCellValueFactory(new PropertyValueFactory<BMpAkcSpecificniDani,Date>("datum"));
          
          SD_KOEF_PREHRANA=new TableColumn ("koef prehrana");
          SD_KOEF_PREHRANA.setCellValueFactory(new PropertyValueFactory<>("koefPrehrana"));
          
          SD_KOEF_NEPREHRANA=new TableColumn ("koef neprehrana");
          SD_KOEF_NEPREHRANA.setCellValueFactory(new PropertyValueFactory<>("koefNeprehrana"));
         
           
         tblSD.getColumns().setAll(SD_DATUM, SD_KOEF_PREHRANA,SD_KOEF_NEPREHRANA);
           
          tblSD.setItems(SD_data);
    }
    
    //popuni inicijalno i specificne dane po OJ
    private void popuniInicijalno2() {
          
        em.clear();
        List<BVMpAkcSpecificniDaniOj>  results =  em.createNamedQuery("BVMpAkcSpecificniDaniOj.findAll")
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
           SD_OJ_data = FXCollections.observableArrayList(results);
  
          
        
          SD_OJ_DATUM=new TableColumn ("datum");
          SD_OJ_DATUM.setCellValueFactory(new PropertyValueFactory<BVMpAkcSpecificniDaniOj,Date>("datum"));
          
          SD_OJ_KOEF_PREHRANA=new TableColumn ("koef prehrana");
          SD_OJ_KOEF_PREHRANA.setCellValueFactory(new PropertyValueFactory<>("koefPrehrana"));
          
          SD_OJ_KOEF_NEPREHRANA=new TableColumn ("koef neprehrana");
          SD_OJ_KOEF_NEPREHRANA.setCellValueFactory(new PropertyValueFactory<>("koefNeprehrana"));
          
       //   @FXML TableColumn<BVMpAkcSpecificniDaniOj,String> SD_OJ_KOEF_ORGJED;
   // @FXML TableColumn<BVMpAkcSpecificniDaniOj,String> SD_OJ_KOEF_NAZIV;
          SD_OJ_KOEF_ORGJED=new TableColumn ("orgjed");
          SD_OJ_KOEF_ORGJED.setCellValueFactory(new PropertyValueFactory<>("orgjed"));
          
          SD_OJ_KOEF_NAZIV=new TableColumn ("naziv OJ");
          SD_OJ_KOEF_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          tblSD_OJ.getColumns().setAll(SD_OJ_DATUM, SD_OJ_KOEF_PREHRANA,SD_OJ_KOEF_NEPREHRANA,SD_OJ_KOEF_ORGJED,SD_OJ_KOEF_NAZIV);
           
          tblSD_OJ.setItems(SD_OJ_data);
    }
    
     private void popuniInicijalno3() {
          
        em.clear();
        List<BVMpAkcSpecificniDaniRg>  results =  em.createNamedQuery("BVMpAkcSpecificniDaniRg.findAll")
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
           SD_RG_data = FXCollections.observableArrayList(results);
  
          
        
          SD_RG_DATUM=new TableColumn ("datum");
          SD_RG_DATUM.setCellValueFactory(new PropertyValueFactory<BVMpAkcSpecificniDaniRg,Date>("datum"));
          
          SD_RG_KOEF=new TableColumn ("koeficijent");
          SD_RG_KOEF.setCellValueFactory(new PropertyValueFactory<>("koef"));
          
          SD_RG_RG=new TableColumn ("RG");
          SD_RG_RG.setCellValueFactory(new PropertyValueFactory<>("rg"));
   
          SD_RG_NAZIV_RG=new TableColumn ("naziv RG");
          SD_RG_NAZIV_RG.setCellValueFactory(new PropertyValueFactory<>("nazivRobneGrupe"));
          
          SD_RG_NAZIV_NAGRUPE=new TableColumn ("naziv nadgrupe");
          SD_RG_NAZIV_NAGRUPE.setCellValueFactory(new PropertyValueFactory<>("nazivNadgrupe1"));
          
          tblSD_RG.getColumns().setAll(SD_RG_DATUM,SD_RG_KOEF,SD_RG_RG,SD_RG_NAZIV_RG,SD_RG_NAZIV_NAGRUPE);
           
          tblSD_RG.setItems(SD_RG_data);
    }
    
    @FXML
    public void dodajSpecificniDan() {
         try {
            em.clear();
            em.getTransaction().begin();
            BMpAkcSpecificniDani b = new BMpAkcSpecificniDani();
            b.setDatum(java.sql.Date.valueOf(dp_add_datum.getValue()));
            b.setKoefNeprehrana(new BigDecimal(txt_add_koef_neprehrana.getText()));
            b.setKoefPrehrana(new BigDecimal(txt_add_koef_prehrana.getText()));
            em.persist(b);
            em.getTransaction().commit();
            // JOptionPane.showMessageDialog(null, "Uneli ste novi specificni dan");
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Specificni dani -info");
            alert1.setHeaderText("Specificni dani - unos");
            alert1.setContentText("Uneli ste novi specificni dan");
            alert1.showAndWait();
            txt_add_koef_neprehrana.setText("");
            txt_add_koef_prehrana.setText("");
            popuniInicijalno();            
        } catch (Exception e) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error info");
            alert1.setHeaderText("Specificni dani - unos");
            alert1.setContentText("Doslo je do greske. "+e.getMessage());
            alert1.showAndWait();
        }
    
    }
    
    
     @FXML
    public void dodajSpecificniDanOJ() {
         try {
            em.clear();
            em.getTransaction().begin();
            BMpAkcSpecificniDaniOj b = new BMpAkcSpecificniDaniOj();
            //b.set(java.sql.Date.valueOf(dp2_add_datum.getValue()));
            b.setKoefNeprehrana(new BigDecimal(txt2_add_koef_neprehrana.getText()));
            b.setKoefPrehrana(new BigDecimal(txt2_add_koef_prehrana.getText()));
            
            BMpAkcSpecificniDaniOjPK c = new BMpAkcSpecificniDaniOjPK();
            c.setDatum(java.sql.Date.valueOf(dp2_add_datum.getValue()));
            c.setOrgjed(txt2_add_oj_sifra.getText());
            
            b.setBMpAkcSpecificniDaniOjPK(c);
            
            em.persist(b);
            em.getTransaction().commit();
            // JOptionPane.showMessageDialog(null, "Uneli ste novi specificni dan");
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Specificni dani -info");
            alert1.setHeaderText("Specificni dani - unos");
            alert1.setContentText("Uneli ste novi specificni dan za OJ");
            alert1.showAndWait();
            txt2_add_koef_neprehrana.setText("");
            txt2_add_koef_prehrana.setText("");
            txt2_add_oj_sifra.setText("");
            txt2_add_oj_naziv.setText("");
            popuniInicijalno2();            
        } catch (Exception e) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error info");
            alert1.setHeaderText("Specificni dani - unos");
            alert1.setContentText("Doslo je do greske. "+e.getMessage());
            alert1.showAndWait();
        }
    
    }
    
    
    @FXML 
    public void izmeniSpecificniDan(){
        
             if ((tblSD.getSelectionModel().getSelectedIndex()>-1)  )
       {
              em.getTransaction().begin();
             
       List<BMpAkcSpecificniDani> b  =  em.createNamedQuery( "BMpAkcSpecificniDani.findByDatum")
               .setParameter("datum", SD_data.get(tblSD.getSelectionModel().getSelectedIndex()).getDatum2())
               .setHint(QueryHints.MAINTAIN_CACHE, "false")
               .getResultList();

       if (!b.isEmpty())
       {
           b.get(0).setKoefNeprehrana(new BigDecimal(txt_edit_koef_neprehrana.getText()));
           b.get(0).setKoefPrehrana(new BigDecimal(txt_edit_koef_prehrana.getText()));
           em.getTransaction().commit();
       }
        popuniInicijalno();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Izmena vrednosti!");
            alert.setContentText("Izmenili ste vrednosti"); 
            alert.showAndWait();  
       }
       else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Greska!");
            alert.setContentText("Proverite podatke"); 
            alert.showAndWait();  
       }
    }
    
    
    @FXML
    public void obrisiSpecificniDan() {
            if ((tblSD.getSelectionModel().getSelectedIndex()>-1)  )
       {
              em.getTransaction().begin();
             
       List<BMpAkcSpecificniDani> b  =  em.createNamedQuery( "BMpAkcSpecificniDani.findByDatum")
               .setParameter("datum", SD_data.get(tblSD.getSelectionModel().getSelectedIndex()).getDatum2())
               .getResultList();

       if (!b.isEmpty())
       {
              em.remove(b.get(0));
              em.getTransaction().commit();
       }
        popuniInicijalno();
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Brisanje specificnog dana");
            alert.setContentText("Obrisali ste specificni dan!!");
            alert.showAndWait();  
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
    public void obrisiSpecificniDanOJ() {
            if ((tblSD_OJ.getSelectionModel().getSelectedIndex()>-1)  )
       {
              em.getTransaction().begin();
             
       List<BMpAkcSpecificniDaniOj> b  =  em.createNamedQuery( "BMpAkcSpecificniDaniOj.findByDatumOJ")
               .setParameter("datum", SD_OJ_data.get(tblSD_OJ.getSelectionModel().getSelectedIndex()).getDatum2())
               .setParameter("orgjed", SD_OJ_data.get(tblSD_OJ.getSelectionModel().getSelectedIndex()).getOrgjed())
               .getResultList();

       if (!b.isEmpty())
       {
              em.remove(b.get(0));
              em.getTransaction().commit();
       }
        popuniInicijalno2();
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Brisanje specificnog dana za oj");
            alert.setContentText("Obrisali ste specificni dan za konkretan oj!!");
            alert.showAndWait();  
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
    public void obrisiSpecificniDanRG() {
        /*
         @FXML TableView tblSD_RG;
    @FXML TableColumn<BVMpAkcSpecificniDaniRg,Date> SD_RG_DATUM;
    @FXML TableColumn<BVMpAkcSpecificniDaniRg,BigDecimal> SD_RG_KOEF;
    @FXML TableColumn<BVMpAkcSpecificniDaniRg,String> SD_RG_RG;
    @FXML TableColumn<BVMpAkcSpecificniDaniRg,String> SD_RG_NAZIV_RG;
    @FXML TableColumn<BVMpAkcSpecificniDaniRg,String> SD_RG_NAZIV_NAGRUPE; 
        */
        
        
            if ((tblSD_RG.getSelectionModel().getSelectedIndex()>-1)  )
       {
              em.getTransaction().begin();
             
       List<BMpAkcSpecificniDaniRg> b  =  em.createNamedQuery( "BMpAkcSpecificniDaniRg.findByDatumRG")
               .setParameter("datum", SD_RG_data.get(tblSD_RG.getSelectionModel().getSelectedIndex()).getDatum2())
               .setParameter("rg", SD_RG_data.get(tblSD_RG.getSelectionModel().getSelectedIndex()).getRg())
               .getResultList();

       if (!b.isEmpty())
       {
              em.remove(b.get(0));
              em.getTransaction().commit();
       }
        popuniInicijalno3();
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Brisanje specificnog dana za rg");
            alert.setContentText("Obrisali ste specificni dan za konkretnu rg!!");
            alert.showAndWait();  
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
    private void odaberiOJ() {
          
        
        String v_param="%"+txt_pretraga_OJ.getText()+"%";
         if (!"".equals(txt_pretraga_OJ.getText())) v_param=v_param.toUpperCase();
        em.clear();
        List<BVMpAkcRadnje>  results =  em.createNamedQuery("BVMpAkcRadnje.findByNaziv2")
                .setParameter("naziv", v_param)
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
           OJ_spisak_data = FXCollections.observableArrayList(results);
  
          
        
           
          SD_SPISAK_OJ_ORGJED=new TableColumn ("sifra");
          SD_SPISAK_OJ_ORGJED.setCellValueFactory(new PropertyValueFactory<>("orgjed"));
          
          SD_SPISAK_OJ_NAZIV=new TableColumn ("naziv OJ");
          SD_SPISAK_OJ_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
   
          
          tbl_spisak_OJ.getColumns().setAll(SD_SPISAK_OJ_ORGJED,SD_SPISAK_OJ_NAZIV);
           
          tbl_spisak_OJ.setItems(OJ_spisak_data);
          
   
    }
    
    
    
    
    @FXML
    public void odabirOJ() {
        if(tbl_spisak_OJ.getSelectionModel().getSelectedItem() != null) 
            
        {
           txt2_add_oj_sifra.setText(OJ_spisak_data.get(tbl_spisak_OJ.getSelectionModel().getSelectedIndex()).getOrgjed());
           txt2_add_oj_naziv.setText(OJ_spisak_data.get(tbl_spisak_OJ.getSelectionModel().getSelectedIndex()).getNaziv());
           //SD_data.get(tblSD.getSelectionModel().getSelectedIndex()).getKoefPrehrana().toString()
            
        }
            
    }
    
    @FXML
    public void dodajSpecDanRG () {
        
         try {
            em.clear();
            em.getTransaction().begin();
            BMpAkcSpecificniDaniRg b = new BMpAkcSpecificniDaniRg();
            //b.set(java.sql.Date.valueOf(dp2_add_datum.getValue()));
            b.setKoef(new BigDecimal(txt3_add_koef.getText()));
          
            
            BMpAkcSpecificniDaniRgPK c = new BMpAkcSpecificniDaniRgPK();
            c.setDatum(java.sql.Date.valueOf(dp3_add_datum.getValue()));
            c.setRg(txt3_add_rg_sifra.getText());
            
            b.setBMpAkcSpecificniDaniRgPK(c);
            
            em.persist(b);
            em.getTransaction().commit();
            // JOptionPane.showMessageDialog(null, "Uneli ste novi specificni dan");
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Specificni dani -info");
            alert1.setHeaderText("Specificni dani - unos");
            alert1.setContentText("Uneli ste novi specificni dan za RG");
            alert1.showAndWait();
       //     txt3_add_koef.setText("");
        //    txt3_add_rg_naziv.setText("");
        //    txt3_add_rg_sifra.setText("");
            
            popuniInicijalno3();            
        } catch (Exception e) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error info");
            alert1.setHeaderText("Specificni dani - unos");
            alert1.setContentText("Doslo je do greske. "+e.getMessage());
            alert1.showAndWait();
        }
     
    }
    
    @FXML
    public void pretragaRG() {
        /*
            @FXML TableView tbl_spisak_RG;
    @FXML TableColumn<BVMpAkcRgSifarnik,String> SD_SPISAK_RG_SIFRA;
    @FXML TableColumn<BVMpAkcRgSifarnik,String> SD_SPISAK_RG_NAZIV;
    @FXML TableColumn<BVMpAkcRgSifarnik,String> SD_SPISAK_RG_NAZIV_NADGRUPE1;
    @FXML TextField txt_pretraga_RG;    
     //ObservableList<BVMpAkcRgSifarnik> RG_spisak_data;
        "BVMpAkcRgSifarnik.findByNaziv2"
        */
        
        
        String v_param="%"+txt_pretraga_RG.getText()+"%";
         if (!"".equals(txt_pretraga_RG.getText())) v_param=v_param.toUpperCase();
        em.clear();
        List<BVMpAkcRgSifarnik>  results =  em.createNamedQuery("BVMpAkcRgSifarnik.findByNaziv2")
                .setParameter("naziv", v_param)
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
           RG_spisak_data = FXCollections.observableArrayList(results);
  
          
        
           
          SD_SPISAK_RG_SIFRA=new TableColumn ("sifra");
          SD_SPISAK_RG_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          
          SD_SPISAK_RG_NAZIV=new TableColumn ("naziv RG");
          SD_SPISAK_RG_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
   
          SD_SPISAK_RG_NAZIV_NADGRUPE1=new TableColumn ("naziv nagrupe");
          SD_SPISAK_RG_NAZIV_NADGRUPE1.setCellValueFactory(new PropertyValueFactory<>("nazivNadgrupe1"));
          
          tbl_spisak_RG.getColumns().setAll(SD_SPISAK_RG_SIFRA,SD_SPISAK_RG_NAZIV,SD_SPISAK_RG_NAZIV_NADGRUPE1);
           
          tbl_spisak_RG.setItems(RG_spisak_data);
          
   
    }
    
        @FXML
    public void odabirRG() {
        if(tbl_spisak_RG.getSelectionModel().getSelectedItem() != null) 
            
        {
           txt3_add_rg_sifra.setText(RG_spisak_data.get(tbl_spisak_RG.getSelectionModel().getSelectedIndex()).getSifra());
           txt3_add_rg_naziv.setText(RG_spisak_data.get(tbl_spisak_RG.getSelectionModel().getSelectedIndex()).getNaziv());
           //SD_data.get(tblSD.getSelectionModel().getSelectedIndex()).getKoefPrehrana().toString()
            
        }
            
    }
    
    
    public void popuniInicijalno4() {
           em.clear();
        List<BVMpAkcSpecDanRgOj>  results =  em.createNamedQuery("BVMpAkcSpecDanRgOj.findAll")
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
           SD_RGOJ_data = FXCollections.observableArrayList(results);
  
          
        
          SD_RGOJ_DATUM=new TableColumn ("datum");
          SD_RGOJ_DATUM.setCellValueFactory(new PropertyValueFactory<>("datum"));
          
          SD_RGOJ_KOEF=new TableColumn ("koeficijent");
          SD_RGOJ_KOEF.setCellValueFactory(new PropertyValueFactory<>("koef"));
          
          SD_RGOJ_RG=new TableColumn ("RG");
          SD_RGOJ_RG.setCellValueFactory(new PropertyValueFactory<>("rg"));
   
          SD_RGOJ_NAZIV_RG=new TableColumn ("naziv RG");
          SD_RGOJ_NAZIV_RG.setCellValueFactory(new PropertyValueFactory<>("robnaGrupa"));
          
          SD_RGOJ_OJ=new TableColumn ("OJ");
          SD_RGOJ_OJ.setCellValueFactory(new PropertyValueFactory<>("oj"));
          
          SD_RGOJ_OJ_NAZIV=new TableColumn ("naziv OJ");
          SD_RGOJ_OJ_NAZIV.setCellValueFactory(new PropertyValueFactory<>("nazivOj"));
          
          tblSD_RGOJ.getColumns().setAll(SD_RGOJ_DATUM,SD_RGOJ_KOEF,SD_RGOJ_RG,SD_RGOJ_NAZIV_RG,SD_RGOJ_OJ,SD_RGOJ_OJ_NAZIV);
           
          tblSD_RGOJ.setItems(SD_RGOJ_data);
        
        /*
         @FXML TableView tblSD_RGOJ;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,Date> SD_RGOJ_DATUM;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,BigDecimal> SD_RGOJ_KOEF;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,String> SD_RGOJ_RG;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,String> SD_RGOJ_NAZIV_RG;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,String> SD_RGOJ_OJ; 
    @FXML TableColumn<BVMpAkcSpecDanRgOj,String> SD_RGOJ_OJ_NAZIV;
        */
    }
    
    
     @FXML
    private void odaberiOJ4() {
          
        
        String v_param="%"+txt_pretraga_OJ4.getText()+"%";
         if (!"".equals(txt_pretraga_OJ4.getText())) v_param=v_param.toUpperCase();
        em.clear();
        List<BVMpAkcRadnje>  results =  em.createNamedQuery("BVMpAkcRadnje.findByNaziv2")
                .setParameter("naziv", v_param)
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
           OJ4_spisak_data = FXCollections.observableArrayList(results);
  
          
        
           
          SD_SPISAK_OJ4_ORGJED=new TableColumn ("sifra");
          SD_SPISAK_OJ4_ORGJED.setCellValueFactory(new PropertyValueFactory<>("orgjed"));
          
          SD_SPISAK_OJ4_NAZIV=new TableColumn ("naziv OJ");
          SD_SPISAK_OJ4_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
   
          
          tbl_spisak_OJ4.getColumns().setAll(SD_SPISAK_OJ4_ORGJED,SD_SPISAK_OJ4_NAZIV);
           
          tbl_spisak_OJ4.setItems(OJ4_spisak_data);
          
   
    }
    
    /*
    @FXML TextField txt4_add_koef;
    @FXML TextField txt4_add_rg_sifra;
    @FXML TextField txt4_add_rg_naziv;
    @FXML DatePicker dp4_add_datum; 
    @FXML TextField txt4_add_oj;
    @FXML TextField txt4_add_oj_naziv;
    */
    
       @FXML
    public void odabirOJ4() {
        if(tbl_spisak_OJ4.getSelectionModel().getSelectedItem() != null) 
            
        {
           txt4_add_oj.setText(OJ4_spisak_data.get(tbl_spisak_OJ4.getSelectionModel().getSelectedIndex()).getOrgjed());
           txt4_add_oj_naziv.setText(OJ4_spisak_data.get(tbl_spisak_OJ4.getSelectionModel().getSelectedIndex()).getNaziv());
           //SD_data.get(tblSD.getSelectionModel().getSelectedIndex()).getKoefPrehrana().toString()
            
        }
            
    }
    
    
     @FXML
    public void pretragaRG4() {
        /*
            @FXML TableView tbl_spisak_RG;
    @FXML TableColumn<BVMpAkcRgSifarnik,String> SD_SPISAK_RG_SIFRA;
    @FXML TableColumn<BVMpAkcRgSifarnik,String> SD_SPISAK_RG_NAZIV;
    @FXML TableColumn<BVMpAkcRgSifarnik,String> SD_SPISAK_RG_NAZIV_NADGRUPE1;
    @FXML TextField txt_pretraga_RG;    
     //ObservableList<BVMpAkcRgSifarnik> RG_spisak_data;
        "BVMpAkcRgSifarnik.findByNaziv2"
        */
        
        
        String v_param="%"+txt_pretraga_RG4.getText()+"%";
         if (!"".equals(txt_pretraga_RG4.getText())) v_param=v_param.toUpperCase();
        em.clear();
        List<BVMpAkcRgSifarnik>  results =  em.createNamedQuery("BVMpAkcRgSifarnik.findByNaziv2")
                .setParameter("naziv", v_param)
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
           RG4_spisak_data = FXCollections.observableArrayList(results);
  
          
        
           
          SD_SPISAK_RG4_SIFRA=new TableColumn ("sifra");
          SD_SPISAK_RG4_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          
          SD_SPISAK_RG4_NAZIV=new TableColumn ("naziv RG");
          SD_SPISAK_RG4_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
   
          SD_SPISAK_RG4_NAZIV_NADGRUPE1=new TableColumn ("naziv nagrupe");
          SD_SPISAK_RG4_NAZIV_NADGRUPE1.setCellValueFactory(new PropertyValueFactory<>("nazivNadgrupe1"));
          
          tbl_spisak_RG4.getColumns().setAll(SD_SPISAK_RG4_SIFRA,SD_SPISAK_RG4_NAZIV,SD_SPISAK_RG4_NAZIV_NADGRUPE1);
           
          tbl_spisak_RG4.setItems(RG4_spisak_data);
          
   
    }
    
    
       public void odabirRG4() {
        if(tbl_spisak_RG4.getSelectionModel().getSelectedItem() != null) 
            
        {
           txt4_add_rg_sifra.setText(RG4_spisak_data.get(tbl_spisak_RG4.getSelectionModel().getSelectedIndex()).getSifra());
           txt4_add_rg_naziv.setText(RG4_spisak_data.get(tbl_spisak_RG4.getSelectionModel().getSelectedIndex()).getNaziv());
           //SD_data.get(tblSD.getSelectionModel().getSelectedIndex()).getKoefPrehrana().toString()
            
        }
            
    }
       
       
        @FXML
    public void dodajSpecDanRGOJ () {
        
         try {
            em.clear();
            em.getTransaction().begin();
            BMpAkcSpecificniDaniRgOj b = new BMpAkcSpecificniDaniRgOj();
            //b.set(java.sql.Date.valueOf(dp2_add_datum.getValue()));
            b.setKoef(new BigDecimal(txt4_add_koef.getText()));
          
            
            BMpAkcSpecificniDaniRgOjPK c = new BMpAkcSpecificniDaniRgOjPK();
            c.setDatum(java.sql.Date.valueOf(dp4_add_datum.getValue()));
            c.setRg(txt4_add_rg_sifra.getText());
            c.setOj(txt4_add_oj.getText());
            
            b.setBMpAkcSpecificniDaniRgOjPK(c);
            
            em.persist(b);
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Specificni dani -info");
            alert1.setHeaderText("Specificni dani - unos");
            alert1.setContentText("Uneli ste novi specificni dan za odabranu RG i OJ");
            alert1.showAndWait();
            em.getTransaction().commit();
            // JOptionPane.showMessageDialog(null, "Uneli ste novi specificni dan");
            
       //     txt3_add_koef.setText("");
        //    txt3_add_rg_naziv.setText("");
        //    txt3_add_rg_sifra.setText("");
            
            popuniInicijalno4();            
        } catch (Exception e) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error info");
            alert1.setHeaderText("Specificni dani Rg i OJ- unos");
            alert1.setContentText("Doslo je do greske. "+e.getMessage());
            alert1.showAndWait();
        }
     
    }
    
    
     @FXML
    public void obrisiSpecificniDanRGOJ() {
        /*
         @FXML TableView tblSD_RG;
    @FXML TableColumn<BVMpAkcSpecificniDaniRg,Date> SD_RG_DATUM;
    @FXML TableColumn<BVMpAkcSpecificniDaniRg,BigDecimal> SD_RG_KOEF;
    @FXML TableColumn<BVMpAkcSpecificniDaniRg,String> SD_RG_RG;
    @FXML TableColumn<BVMpAkcSpecificniDaniRg,String> SD_RG_NAZIV_RG;
    @FXML TableColumn<BVMpAkcSpecificniDaniRg,String> SD_RG_NAZIV_NAGRUPE; 
        */
        
        
            if ((tblSD_RGOJ.getSelectionModel().getSelectedIndex()>-1)  )
       {
              em.getTransaction().begin();
             
       List<BMpAkcSpecificniDaniRgOj> b  =  em.createNamedQuery( "BMpAkcSpecificniDaniRgOj.findByDatumRGOJ")
               .setParameter("datum", SD_RGOJ_data.get(tblSD_RGOJ.getSelectionModel().getSelectedIndex()).getDatum2())
               .setParameter("rg", SD_RGOJ_data.get(tblSD_RGOJ.getSelectionModel().getSelectedIndex()).getRg())
               .setParameter("oj", SD_RGOJ_data.get(tblSD_RGOJ.getSelectionModel().getSelectedIndex()).getOj())
               .getResultList();

       if (!b.isEmpty())
       {
              em.remove(b.get(0));
              em.getTransaction().commit();
       }
        popuniInicijalno4();
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Brisanje specificnog dana za rg i OJ");
            alert.setContentText("Obrisali ste specificni dan za konkretnu rg i OJ!!");
            alert.showAndWait();  
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
    
    public void popuniInicijalno5() {
        
         em.clear();
        List<BVMpAkcSpecDaniArt>  results =  em.createNamedQuery("BVMpAkcSpecDaniArt.findAll")
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
           SD_ART_data = FXCollections.observableArrayList(results);
  
          
        
          SD_ART_DATUM=new TableColumn ("datum");
          SD_ART_DATUM.setCellValueFactory(new PropertyValueFactory<>("datum"));
          
          SD_ART_KOEF=new TableColumn ("koeficijent");
          SD_ART_KOEF.setCellValueFactory(new PropertyValueFactory<>("koef"));
          
          SD_ART_ART=new TableColumn ("id");
          SD_ART_ART.setCellValueFactory(new PropertyValueFactory<>("artikal"));
   
          SD_ART_SIFRA=new TableColumn ("šifra");
          SD_ART_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          
          SD_ART_NAZIV=new TableColumn ("naziv");
          SD_ART_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
         
          
          tblSD_ART.getColumns().setAll(SD_ART_DATUM,SD_ART_KOEF,SD_ART_ART,SD_ART_SIFRA,SD_ART_NAZIV);
           
          tblSD_ART.setItems(SD_ART_data);
        
        /*
         @FXML TableView tblSD_ART;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,Date> SD_ART_DATUM;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,BigDecimal> SD_ART_KOEF;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,Long> SD_ART_ART;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,String> SD_ART_SIFRA;
    @FXML TableColumn<BVMpAkcSpecDanRgOj,String> SD_ART_NAZIV;
        */
    }
    
    
    @FXML
   public void pretraziArtikle() {

       
         String v_param="%"+txt_search_artikli.getText()+"%";
          if (!"".equals(txt_search_artikli.getText())) v_param=v_param.toUpperCase();
         
         
        em.clear();
        List<BVMpAkcArtikli>  results =  em.createNamedQuery("BVMpAkcArtikli.findPretraga")
                .setParameter("naziv", v_param)
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
          AR_data = FXCollections.observableArrayList(results);
  
                  
          AR_ID=new TableColumn ("id artikla");
          AR_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
          
          AR_SIFRA=new TableColumn ("sifra artikla");
          AR_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          
          AR_NAZIV=new TableColumn ("naziv artikla");
          AR_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          AR_RG=new TableColumn ("robna grupa");
          AR_RG.setCellValueFactory(new PropertyValueFactory<>("robnagrupa"));
          
         
           
         tbl_artikli.getColumns().setAll(AR_ID,AR_SIFRA,AR_NAZIV,AR_RG);
         tbl_artikli.setItems(AR_data);
   }
   
   @FXML
   public void odaberiArtikal() {
       
       
           
       txt5_add_art_art.setText(String.valueOf(AR_data.get(tbl_artikli.getSelectionModel().getSelectedIndex()).getId())  );
       txt5_add_naziv.setText(AR_data.get(tbl_artikli.getSelectionModel().getSelectedIndex()).getNaziv());
       /*
          @FXML TextField txt5_add_koef;
    @FXML TextField txt5_add_art_art;
    @FXML TextField txt5_add_naziv;
    @FXML DatePicker dp5_add_datum; 
       */
   }
   
     @FXML
    public void dodajSpecDanART () {
        
            
         em.getTransaction().begin();
        StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mp_akc_unos_spec_dan_art_per");
        
        storedprocedure1.registerStoredProcedureParameter("p_datum_od", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_datum_od",  Date.from(dp5_add_datum_od.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
      
        storedprocedure1.registerStoredProcedureParameter("p_datum_do", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_datum_do",  Date.from(dp5_add_datum.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
      
        storedprocedure1.registerStoredProcedureParameter("p_koef", BigDecimal.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_koef", new BigDecimal(txt5_add_koef.getText()));
        
        storedprocedure1.registerStoredProcedureParameter("p_artikal", Long.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_artikal", Long.valueOf(txt5_add_art_art.getText()));
        
       /* 
        
        storedprocedure1.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
        storedprocedure1.registerStoredProcedureParameter("p_orgjed", String.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_orgjed", RD_data.get(tblRazvozDopuna.getSelectionModel().getSelectedIndex()).getOrgjed());
        
        storedprocedure1.registerStoredProcedureParameter("p_broj_dopune", Integer.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_broj_dopune", RD_data.get(tblRazvozDopuna.getSelectionModel().getSelectedIndex()).getBrojDopune());
        
        storedprocedure1.registerStoredProcedureParameter("p_magacin", String.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_magacin", RD_data.get(tblRazvozDopuna.getSelectionModel().getSelectedIndex()).getMagacin());
        
        storedprocedure1.registerStoredProcedureParameter("p_datum", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_datum",  Date.from(unosDatum.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
      
        storedprocedure1.registerStoredProcedureParameter("p_poc_datum_projekcije", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_poc_datum_projekcije",Date.from(unosDatumOd.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    
        storedprocedure1.registerStoredProcedureParameter("p_kraj_datum_projekcije", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_kraj_datum_projekcije",Date.from(unosDatumDo.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        
        storedprocedure1.registerStoredProcedureParameter("p_poruka", String.class, ParameterMode.OUT);
       */
        storedprocedure1.execute();

       // String poruka=(String)storedprocedure1.getOutputParameterValue("p_poruka");
        em.getTransaction().commit();
        
       // int xx=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
      //  listaRazvozaDopuna(xx);
         popuniInicijalno5();   
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Masovni unos specificnih dana po artiklu");
               alert.setHeaderText("info o masovnom unosu spec dana po artiklua");
               alert.setContentText("Unli ste specificne dane");
               alert.showAndWait(); 
        
        
       /* 
         try {
            em.clear();
            em.getTransaction().begin();
            BMpAkcSpecificniDaniArt b = new BMpAkcSpecificniDaniArt();
            //b.set(java.sql.Date.valueOf(dp2_add_datum.getValue()));
            b.setKoef(new BigDecimal(txt5_add_koef.getText()));
          
            
            BMpAkcSpecificniDaniArtPK c = new BMpAkcSpecificniDaniArtPK();
            c.setDatum(java.sql.Date.valueOf(dp5_add_datum.getValue()));
            c.setArtikal(Long.valueOf(txt5_add_art_art.getText()) );
            
            
            b.setBMpAkcSpecificniDaniArtPK(c);
            
            em.persist(b);
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Specificni dani -info");
            alert1.setHeaderText("Specificni dani - unos");
            alert1.setContentText("Uneli ste novi specificni dan za odabran artikal");
            alert1.showAndWait();
            em.getTransaction().commit();
            // JOptionPane.showMessageDialog(null, "Uneli ste novi specificni dan");
            
       //     txt3_add_koef.setText("");
        //    txt3_add_rg_naziv.setText("");
        //    txt3_add_rg_sifra.setText("");
            
            popuniInicijalno5();            
        } catch (Exception e) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error info");
            alert1.setHeaderText("Specificni dani -  Artikli- unos");
            alert1.setContentText("Doslo je do greske. "+e.getMessage());
            alert1.showAndWait();
        }
     */
    }
    
     @FXML
    public void obrisiSpecificniDanART() {
        
        
            if ((tblSD_ART.getSelectionModel().getSelectedIndex()>-1)  )
       {
              em.getTransaction().begin();
             
       List<BMpAkcSpecificniDaniArt> b  =  em.createNamedQuery( "BMpAkcSpecificniDaniArt.findByDatumART")
               .setParameter("datum", SD_ART_data.get(tblSD_ART.getSelectionModel().getSelectedIndex()).getDatum2())
               .setParameter("artikal", SD_ART_data.get(tblSD_ART.getSelectionModel().getSelectedIndex()).getArtikal())
              
               .getResultList();

       if (!b.isEmpty())
       {
              em.remove(b.get(0));
              em.getTransaction().commit();
       }
        popuniInicijalno5();
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Brisanje specificnog dana za artikal");
            alert.setContentText("Obrisali ste specificni dan za selektovani artikal i dan!!");
            alert.showAndWait();  
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
    // stara metoda je dodajSpecDanRG
    public void novaProceduraZaUnosKoefPoDanima ()
    {
      if (!txt3_add_koef.getText().equals("") && !txt3_add_rg_sifra.getText().equals(""))
      {
        
        em.getTransaction().begin();
         
         
        StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.B_MP_AKC_SPEC_DANI_DODAJ_KOEF");
        
        storedprocedure1.registerStoredProcedureParameter("p_datum_od", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_datum_od",  Date.from(dp_datum_od.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
      
        storedprocedure1.registerStoredProcedureParameter("p_datum_do", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_datum_do",  Date.from(dp_datum_do.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
      
        storedprocedure1.registerStoredProcedureParameter("p_koefcijent", BigDecimal.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_koefcijent", new BigDecimal(txt3_add_koef.getText()));
        
        storedprocedure1.registerStoredProcedureParameter("p_robna_grupa", String.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_robna_grupa", txt3_add_rg_sifra.getText());
        
        storedprocedure1.registerStoredProcedureParameter("p_info", String.class, ParameterMode.OUT);
        
       
        
        storedprocedure1.execute();

         String poruka =(String)storedprocedure1.getOutputParameterValue("p_info");
        
        em.getTransaction().commit();
        
        
        
        
        if (poruka.equals("DA"))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFO");
            alert.setHeaderText("Info o masovnom unosu koeficijenta robne grupe po danima");
            alert.setContentText("Uspešno.");
            alert.showAndWait(); 
        }
        else if (poruka.equals("NE"))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greška");
            alert.setHeaderText("Koeficijenti nisu uneti.");
            alert.setContentText("Proverite da li su podaci dobri i pokušajte opet.");
            alert.showAndWait(); 
        }
      }
      else
      {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greška");
            alert.setHeaderText("Nisu popunjena sva polja.");
            alert.setContentText("Proverite da li su podaci uneti i pokušajte opet.");
            alert.showAndWait();   
      }
      
    }
}
