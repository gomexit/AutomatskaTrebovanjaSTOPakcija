/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.eclipse.persistence.config.QueryHints;

/**
 * FXML Controller class
 *
 * @author bojan
 */
public class FXMLRadnjeController implements Initializable {

   private EntityManager em;
   ObservableList<BVMpAkcRadnje> MPO_data;
   ObservableList<BMpAkcRadnje> MPO2_data;
   
   @FXML Button btn_stampaj_excel;
   
   @FXML TableView tbl_radnje;
    TableColumn<BVMpAkcRadnje,String>  MPO_ORGJED;
    TableColumn<BVMpAkcRadnje,String>  MPO_ORGJED_NAZIV;
    TableColumn<BVMpAkcRadnje,String>  MPO_AKC_TREB;
    TableColumn<BVMpAkcRadnje,String>  MPO_AKC_TREB_VIK;
    TableColumn<BVMpAkcRadnje,Short>  MPO_STOP_DAN_PRVO_PUNJENJE;
    TableColumn<BVMpAkcRadnje,Short>  MPO_STOP_DAN_PRVA_DOPUNA;
    TableColumn<BVMpAkcRadnje,String>  MPO_DC  ;
    TableColumn<BVMpAkcRadnje,Short>  MPO_PRVA_PRVO_PUNJ_RDC;
    TableColumn<BVMpAkcRadnje,Short>  MPO_PRVA_DOP_RDC;
    TableColumn<BVMpAkcRadnje,Short>  MPO_RAZVOZ1;
    TableColumn<BVMpAkcRadnje,Short>  MPO_RAZVOZ2;
    TableColumn<BVMpAkcRadnje,Short>  MPO_RAZVOZ3;
   
   @FXML TextField cmb_izm_orgjed;
   @FXML ComboBox cmb_izm_akc_treb;
   @FXML ComboBox cmb_izm_akc_treb_VIK;
   @FXML ComboBox cmb_izm_stop_prvo_punj;
   @FXML ComboBox cmb_izm_stop_prva_dop;
   @FXML ComboBox cmb_izm_dc;
   @FXML ComboBox cmb_izm_stop_prvooo_rdc;
   @FXML ComboBox cmb_izm_stop_prvo_punj_rdc;
   @FXML ComboBox cmb_izm_razvoz1;
   @FXML ComboBox cmb_izm_razvoz2;
   @FXML ComboBox cmb_izm_razvoz3;
   
   @FXML TextField cmb_add_orgjed;
   @FXML ComboBox cmb_add_akc_treb;
   @FXML ComboBox cmb_add_akc_treb_VIK;
   @FXML ComboBox cmb_add_stop_prvo_punj;
   @FXML ComboBox cmb_add_stop_prva_dop;
   @FXML ComboBox cmb_add_dc;
   @FXML ComboBox cmb_add_stop_prvooo_rdc; //ovo je prvo punjenje
   @FXML ComboBox cmb_add_stop_prvo_punj_rdc; //ovo je u stvari prva dopuna
   @FXML ComboBox cmb_add_razvoz1;
   @FXML ComboBox cmb_add_razvoz2;
   @FXML ComboBox cmb_add_razvoz3;
   
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();     
           popuniInicijalno();
           
              tbl_radnje.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tbl_radnje.getSelectionModel().getSelectedItem() != null) 
        {    
          
           TableView.TableViewSelectionModel selectionModel = tbl_radnje.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);
           
           cmb_izm_akc_treb.getSelectionModel().select(MPO_data.get(tbl_radnje.getSelectionModel().getSelectedIndex()).getAkcijskoTrebovanje() );
           cmb_izm_akc_treb_VIK.getSelectionModel().select(MPO_data.get(tbl_radnje.getSelectionModel().getSelectedIndex()).getAkcijskoTrebovanjeVik());
           cmb_izm_dc.getSelectionModel().select(MPO_data.get(tbl_radnje.getSelectionModel().getSelectedIndex()).getDc() );
           cmb_izm_orgjed.setText(MPO_data.get(tbl_radnje.getSelectionModel().getSelectedIndex()).getOrgjed() );
           cmb_izm_razvoz1.getSelectionModel().select(MPO_data.get(tbl_radnje.getSelectionModel().getSelectedIndex()).getRazvoz1() );
           cmb_izm_razvoz2.getSelectionModel().select(MPO_data.get(tbl_radnje.getSelectionModel().getSelectedIndex()).getRazvoz2() );
           cmb_izm_razvoz3.getSelectionModel().select(MPO_data.get(tbl_radnje.getSelectionModel().getSelectedIndex()).getRazvoz3());
           cmb_izm_stop_prva_dop.getSelectionModel().select(MPO_data.get(tbl_radnje.getSelectionModel().getSelectedIndex()).getStopDanZaPrvuDopunu() );
           cmb_izm_stop_prvo_punj.getSelectionModel().select(MPO_data.get(tbl_radnje.getSelectionModel().getSelectedIndex()).getStopDanZaPrvoPunjenje() );
           cmb_izm_stop_prvooo_rdc.getSelectionModel().select(MPO_data.get(tbl_radnje.getSelectionModel().getSelectedIndex()).getStopDanZaPrvoPunjenjeRdc()) ;
           cmb_izm_stop_prvo_punj_rdc.getSelectionModel().select(MPO_data.get(tbl_radnje.getSelectionModel().getSelectedIndex()).getStopDanZaPrvuDopunuRdc() );
           
        }
         }
     });
    }    

    private void popuniInicijalno() {
      popuniRadnje() ;
      popuniComboBoxove();
      
      
    }

    private void popuniRadnje() {
        
         
        em.clear();
        List<BVMpAkcRadnje>  results =  em.createNamedQuery("BVMpAkcRadnje.findAll")
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
           MPO_data = FXCollections.observableArrayList(results);
  
                  
          MPO_ORGJED=new TableColumn ("orgjed");
          MPO_ORGJED.setCellValueFactory(new PropertyValueFactory<>("orgjed"));
          
          MPO_ORGJED_NAZIV=new TableColumn ("orgjed naziv");
          MPO_ORGJED_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          MPO_AKC_TREB=new TableColumn ("akc treb");
          MPO_AKC_TREB.setCellValueFactory(new PropertyValueFactory<>("akcijskoTrebovanje"));
          
          MPO_AKC_TREB_VIK=new TableColumn ("akc treb VIK");
          MPO_AKC_TREB_VIK.setCellValueFactory(new PropertyValueFactory<>("akcijskoTrebovanjeVik"));
          
          MPO_STOP_DAN_PRVO_PUNJENJE=new TableColumn ("STOP prvo punj");
          MPO_STOP_DAN_PRVO_PUNJENJE.setCellValueFactory(new PropertyValueFactory<>("stopDanZaPrvoPunjenje"));
          
          MPO_STOP_DAN_PRVA_DOPUNA=new TableColumn ("STOP prva dop");
          MPO_STOP_DAN_PRVA_DOPUNA.setCellValueFactory(new PropertyValueFactory<>("stopDanZaPrvuDopunu"));
          
          MPO_DC=new TableColumn ("DC");
          MPO_DC.setCellValueFactory(new PropertyValueFactory<>("dc"));
          
          MPO_PRVA_PRVO_PUNJ_RDC=new TableColumn ("STOP RDC prvo punjenje");
          MPO_PRVA_PRVO_PUNJ_RDC.setCellValueFactory(new PropertyValueFactory<>("stopDanZaPrvoPunjenjeRdc"));
          
          MPO_PRVA_DOP_RDC=new TableColumn ("STOP RDC prva dop");
          MPO_PRVA_DOP_RDC.setCellValueFactory(new PropertyValueFactory<>("stopDanZaPrvuDopunuRdc"));
          
          MPO_RAZVOZ1=new TableColumn ("razvoz 1");
          MPO_RAZVOZ1.setCellValueFactory(new PropertyValueFactory<>("razvoz1"));
          
          MPO_RAZVOZ2=new TableColumn ("razvoz 2");
          MPO_RAZVOZ2.setCellValueFactory(new PropertyValueFactory<>("razvoz2"));
          
          MPO_RAZVOZ3=new TableColumn ("razvoz 3");
          MPO_RAZVOZ3.setCellValueFactory(new PropertyValueFactory<>("razvoz3"));
          
         
           
         tbl_radnje.getColumns().setAll(MPO_ORGJED,MPO_ORGJED_NAZIV,MPO_AKC_TREB,MPO_AKC_TREB_VIK,MPO_STOP_DAN_PRVO_PUNJENJE,MPO_STOP_DAN_PRVA_DOPUNA,
                 MPO_DC,MPO_PRVA_PRVO_PUNJ_RDC,MPO_PRVA_DOP_RDC,MPO_RAZVOZ1,MPO_RAZVOZ2,MPO_RAZVOZ3);
           
          tbl_radnje.setItems(MPO_data);

    }

    private void popuniComboBoxove() {
          List<String> listaDana = new ArrayList<String>();
        listaDana.add("1");
        listaDana.add("2");  
        listaDana.add("3");
        listaDana.add("4");
        listaDana.add("5");
        listaDana.add("6");
        listaDana.add("7");
        listaDana.add("");
        ObservableList obList = FXCollections.observableList(listaDana);
         
        cmb_izm_stop_prvo_punj.getItems().clear();
        cmb_izm_stop_prvo_punj.setItems(obList);
        
        cmb_izm_stop_prva_dop.getItems().clear();
        cmb_izm_stop_prva_dop.setItems(obList);
        
        cmb_izm_stop_prvo_punj_rdc.getItems().clear();
        cmb_izm_stop_prvo_punj_rdc.setItems(obList);
        
        cmb_izm_razvoz1.getItems().clear();
        cmb_izm_razvoz1.setItems(obList);
        
        cmb_izm_razvoz2.getItems().clear();
        cmb_izm_razvoz2.setItems(obList);
        
        cmb_izm_razvoz3.getItems().clear();
        cmb_izm_razvoz3.setItems(obList);
        
                
        cmb_add_stop_prvo_punj.getItems().clear();
        cmb_add_stop_prvo_punj.setItems(obList);
        
        cmb_add_stop_prva_dop.getItems().clear();
        cmb_add_stop_prva_dop.setItems(obList);
        
        
                
        cmb_add_stop_prvooo_rdc.getItems().clear();
        cmb_add_stop_prvooo_rdc.setItems(obList);
                
        cmb_izm_stop_prvooo_rdc.getItems().clear();
        cmb_izm_stop_prvooo_rdc.setItems(obList);
        
        cmb_add_stop_prvo_punj_rdc.getItems().clear();
        cmb_add_stop_prvo_punj_rdc.setItems(obList);
        
        cmb_add_razvoz1.getItems().clear();
        cmb_add_razvoz1.setItems(obList);
        
        cmb_add_razvoz2.getItems().clear();
        cmb_add_razvoz2.setItems(obList);
        
        cmb_add_razvoz3.getItems().clear();
        cmb_add_razvoz3.setItems(obList);
        
        
         List<String> listaAkcTreb = new ArrayList<String>();
        listaAkcTreb.add("DA");
        listaAkcTreb.add("NE");  
      
        ObservableList obList2 = FXCollections.observableList(listaAkcTreb);
         
        cmb_izm_akc_treb.getItems().clear();
        cmb_izm_akc_treb.setItems(obList2);
        
        cmb_add_akc_treb.getItems().clear();
        cmb_add_akc_treb.setItems(obList2);
        
        cmb_izm_akc_treb_VIK.getItems().clear();
        cmb_izm_akc_treb_VIK.setItems(obList2);
        
        cmb_add_akc_treb_VIK.getItems().clear();
        cmb_add_akc_treb_VIK.setItems(obList2);
        
        
        
          List<String> listaDC = new ArrayList<String>();
        listaDC.add("131");
        listaDC.add("139");  
      
        ObservableList obList3 = FXCollections.observableList(listaDC);
         
        cmb_izm_dc.getItems().clear();
        cmb_izm_dc.setItems(obList3);
        
        cmb_add_dc.getItems().clear();
        cmb_add_dc.setItems(obList3);
       

    }
    
    @FXML
    public void  unesiObjekat() {
        
         try {
            em.clear();
            em.getTransaction().begin();
            BMpAkcRadnje b = new BMpAkcRadnje();

            b.setAkcijskoTrebovanje(cmb_add_akc_treb.getValue().toString());
            b.setAkcijskoTrebovanjeVik(cmb_add_akc_treb_VIK.getValue().toString());
            b.setDc(cmb_add_dc.getValue().toString());
            b.setOrgjed(cmb_add_orgjed.getText());
           if ((cmb_add_razvoz1.getValue() !=  "") && (cmb_add_razvoz1.getValue() !=  null))
               b.setRazvoz1(Short.parseShort(cmb_add_razvoz1.getValue().toString()));
           else b.setRazvoz1(null);
           
           if ((cmb_add_razvoz2.getValue() !=  "") && (cmb_add_razvoz2.getValue() !=  null)) 
            b.setRazvoz2(Short.parseShort(cmb_add_razvoz2.getValue().toString()));  else b.setRazvoz2(null);
           
           if ((cmb_add_razvoz3.getValue() !=  "")  &&(cmb_add_razvoz3.getValue() !=  null) )
            b.setRazvoz3(Short.parseShort(cmb_add_razvoz3.getValue().toString())); else b.setRazvoz3(null);
           
            if ((cmb_add_stop_prvo_punj.getValue() !=  "") && (cmb_add_stop_prvo_punj.getValue() !=  null))
            b.setStopDanZaPrvoPunjenje(Short.parseShort(cmb_add_stop_prvo_punj.getValue().toString())); else b.setStopDanZaPrvoPunjenje(null);
          
             if ((cmb_add_stop_prva_dop.getValue() !=  "") && (cmb_add_stop_prva_dop.getValue() != null))
            b.setStopDanZaPrvuDopunu(Short.parseShort(cmb_add_stop_prva_dop.getValue().toString())); else b.setStopDanZaPrvuDopunu(null);
           
               if( (cmb_add_stop_prvooo_rdc.getValue() !=  "") &&(cmb_add_stop_prvooo_rdc.getValue() !=  null))
            b.setStopDanZaPrvoPunjenjeRdc(Short.parseShort(cmb_add_stop_prvooo_rdc.getValue().toString())); else b.setStopDanZaPrvoPunjenjeRdc(null);
               
              if( (cmb_add_stop_prvo_punj_rdc.getValue() !=  "") &&(cmb_add_stop_prvo_punj_rdc.getValue() !=  null))
            b.setStopDanZaPrvuDopunuRdc(Short.parseShort(cmb_add_stop_prvo_punj_rdc.getValue().toString())); else b.setStopDanZaPrvuDopunuRdc(null);
  
            
            em.persist(b);
            em.getTransaction().commit();
            // JOptionPane.showMessageDialog(null, "Uneli ste novi specificni dan");
            popuniRadnje() ;
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Unos nove radnje ");
            alert1.setHeaderText("Nova radnja- unos");
            alert1.setContentText("Uneli ste novu radnju");
            alert1.showAndWait();
            
           
            
            
            popuniInicijalno();            
        } catch (Exception e) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error info");
            alert1.setHeaderText("Nova radnja- unos");
            alert1.setContentText("Doslo je do greske. "+e.getMessage());
            alert1.showAndWait();
            em.getTransaction().rollback();
        }
    }
    
    @FXML
    public void izmeniObjekat() {
         if ((tbl_radnje.getSelectionModel().getSelectedIndex()>-1)  )
       {
              em.getTransaction().begin();
             
       List<BMpAkcRadnje> b  =  em.createNamedQuery("BMpAkcRadnje.findByOrgjed")
               .setParameter("orgjed", MPO_data.get(tbl_radnje.getSelectionModel().getSelectedIndex()).getOrgjed())
                // .setHint(QueryHints.MAINTAIN_CACHE, "false")
               .getResultList();

       
                if (!b.isEmpty())
                {
                 //   b.get(0).setKoefNeprehrana(new BigDecimal(txt_edit_koef_neprehrana.getText()));
                   try {
                       
                         b.get(0).setAkcijskoTrebovanje(cmb_izm_akc_treb.getValue().toString());
                         b.get(0).setAkcijskoTrebovanjeVik(cmb_izm_akc_treb_VIK.getValue().toString());
                         b.get(0).setDc(cmb_izm_dc.getValue().toString());
                         
                   if ((cmb_izm_razvoz1.getValue() !=  "") &&    (cmb_izm_razvoz1.getValue() !=  null))
                       b.get(0).setRazvoz1(Short.parseShort(cmb_izm_razvoz1.getValue().toString()));
                   else  b.get(0).setRazvoz1(null);                 
                   
                    if ((cmb_izm_razvoz2.getValue() !=  "") && (cmb_izm_razvoz2.getValue() !=  null) )
                         b.get(0).setRazvoz2(Short.parseShort(cmb_izm_razvoz2.getValue().toString()));
                    else  b.get(0).setRazvoz2(null);         
                      
                    if ((cmb_izm_razvoz3.getValue() != "") && (cmb_izm_razvoz3.getValue() != null))  
                         b.get(0).setRazvoz3(Short.parseShort(cmb_izm_razvoz3.getValue().toString()));
                         else  b.get(0).setRazvoz3(null);  
                     
                    if ((cmb_izm_stop_prvo_punj.getValue() != "")  && (cmb_izm_stop_prvo_punj.getValue() != null)  )
                         b.get(0).setStopDanZaPrvoPunjenje(Short.parseShort(cmb_izm_stop_prvo_punj.getValue().toString()));
                        else  b.get(0).setStopDanZaPrvoPunjenje(null);
                  
                     if ((cmb_izm_stop_prva_dop.getValue() !=  "")  && (cmb_izm_stop_prva_dop.getValue() !=  null))  
                         b.get(0).setStopDanZaPrvuDopunu(Short.parseShort(cmb_izm_stop_prva_dop.getValue().toString()));
                         else  b.get(0).setStopDanZaPrvuDopunu(null);
                     
                     
                      if ((cmb_izm_stop_prvooo_rdc.getValue() !=  "")  && (cmb_izm_stop_prvooo_rdc.getValue() !=  null)  )
                         b.get(0).setStopDanZaPrvoPunjenjeRdc(Short.parseShort(cmb_izm_stop_prvooo_rdc.getValue().toString()));
                         else  b.get(0).setStopDanZaPrvoPunjenjeRdc(null);
                    
                      if ((cmb_izm_stop_prvo_punj_rdc.getValue() !=  "")  && (cmb_izm_stop_prvo_punj_rdc.getValue() !=  null)  )
                         b.get(0).setStopDanZaPrvuDopunuRdc(Short.parseShort(cmb_izm_stop_prvo_punj_rdc.getValue().toString()));
                         else  b.get(0).setStopDanZaPrvuDopunuRdc(null);
                       
                       
                     em.getTransaction().commit();
                     
                     popuniRadnje() ;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                     alert.setTitle("Information Dialog");
                     alert.setHeaderText("Izmena vrednosti!");
                     alert.setContentText("Izmenili ste vrednosti o mp objektu"); 
                     alert.showAndWait();
                    
                   }
                   catch (Exception e) {
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
                     alert.setTitle("Information Error");
                     alert.setHeaderText("Greska u izmeni");
                     alert.setContentText("Doslo je do greske prilikom pokusaja izmene.  "+e.getMessage()); 
                     alert.showAndWait();
                     em.getTransaction().rollback();
                   }
               
                   
                }
      
              
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
  
    public void excelStampa()
    {
        
        
          
                    em.clear();
        List<BVMpAkcRadnje>  results =  em.createNamedQuery("BVMpAkcRadnje.findAll")
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
          
          
   try {       
               
    Workbook wb = new HSSFWorkbook();
    CreationHelper createhelper = wb.getCreationHelper();
    Sheet sheet = wb.createSheet("stavke dokumenta");
    Row row = null;
    Cell cell = null;
    
    //kreiraj zaglavlje dokument
    row = sheet.createRow(0);
            
            cell = row.createCell(0);
            cell.setCellValue((String) "ORGJED");
            cell = row.createCell(1);
            cell.setCellValue((String) "ORGJED_NAZIV");
            cell = row.createCell(2);
            cell.setCellValue((String) "AKC_TREB");
            cell = row.createCell(3);
            cell.setCellValue((String) "AKC_TREB_VIK");
             cell = row.createCell(4);
            cell.setCellValue((String) "STOP_PRVO_PUNJ");
            cell = row.createCell(5);
            cell.setCellValue((String) "STOP_PRVA_DOP");
            cell = row.createCell(6);
            cell.setCellValue((String) "DC");
            cell = row.createCell(7);
            cell.setCellValue((String) "STOP_RDC_PRVO_PUNJ");
            cell = row.createCell(8);
            cell.setCellValue((String) "STOP_RDC_PRVA_DOP");
            cell = row.createCell(9);
            cell.setCellValue((String) "RAZVOZ_1");
            cell = row.createCell(10);
            cell.setCellValue((String) "RAZVOZ_2");
            cell = row.createCell(11);
            cell.setCellValue((String) "RAZVOZ_3");
            
        
    //kraj kreiranja zaglavlja
    
    for (int i=0;i<results.size();i++) {
        row = sheet.createRow(i+1); 
             
            cell = row.createCell(0);
            cell.setCellValue((String) results.get(i).getOrgjed());
           
            cell = row.createCell(1);
            cell.setCellValue((String) results.get(i).getNaziv()); 
            cell = row.createCell(2);
            cell.setCellValue((String) results.get(i).getAkcijskoTrebovanje()); 
            cell = row.createCell(3);
            cell.setCellValue((String) results.get(i).getAkcijskoTrebovanjeVik()); 
            cell = row.createCell(4);
            cell.setCellValue((String) results.get(i).getStopDanZaPrvoPunjenje().toString()); 
            cell = row.createCell(5);
            cell.setCellValue((String) results.get(i).getStopDanZaPrvuDopunu().toString()); 
            cell = row.createCell(6);
            cell.setCellValue((String) results.get(i).getDc());
            cell = row.createCell(7);
            cell.setCellValue((String) results.get(i).getStopDanZaPrvoPunjenjeRdc().toString());
             cell = row.createCell(8);
            cell.setCellValue((String) results.get(i).getStopDanZaPrvuDopunuRdc().toString());
            cell = row.createCell(9);
            cell.setCellValue((String) results.get(i).getRazvoz1().toString());
            cell = row.createCell(10);
            cell.setCellValue((String) results.get(i).getRazvoz2().toString());
             cell = row.createCell(11);
             if ( results.get(i).getRazvoz3() != null)
             {
               cell.setCellValue((String) results.get(i).getRazvoz3().toString());
             }
             else
             {
              cell.setCellValue((String)"/");   
             }
            
          
    }
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
Date date = new Date();
System.out.println(dateFormat.format(date)); 
  String v_ime_fajla="LIST MPO OBJEKATA  "+dateFormat.format(date)+".xls";
    
    FileOutputStream out = new FileOutputStream(v_ime_fajla);
    wb.write(out);
    out.close();
       Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Izvoz u Excel");
            alert1.setHeaderText("Uspešno");
            alert1.setContentText("Broj exportovanih slogova je: "+results.size());
            alert1.showAndWait();
         System.out.println("Broj slogova je : "+results.size());
} catch (FileNotFoundException ex) {
    Logger.getLogger(FXMLRadnjeController.class.getName()).log(Level.SEVERE, null, ex);
} catch (IOException ex) {
    Logger.getLogger(FXMLRadnjeController.class.getName()).log(Level.SEVERE, null, ex);
}
   
        
        
        
    }
    
}
