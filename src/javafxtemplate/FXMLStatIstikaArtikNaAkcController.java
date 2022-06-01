/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.IOException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.apache.poi.ss.usermodel.ErrorConstants;
import org.eclipse.persistence.config.QueryHints;

/**
 * FXML Controller class
 *
 * @author laki
 */
public class FXMLStatIstikaArtikNaAkcController implements Initializable {

    @FXML ComboBox cmb_artikal_na_akc_izv;
    @FXML TextField txt_id;
    @FXML TextField txt_sifra;
    @FXML TextField txt_naziv;
    @FXML TableView tblGrupisano;
    @FXML TableView tblArtikliIzAkcije;
    
    ObservableList<BVMpAkcNazivVredX15> GR_data;
    
       TableColumn<BVMpAkcNazivVredX15,String>     GR_NAZIV;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> GR_VRED1;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> GR_VRED2;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> GR_VRED3;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> GR_VRED4;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> GR_VRED5;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> GR_VRED6;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> GR_VRED7;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> GR_VRED8;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> GR_VRED9;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> GR_VRED10;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> GR_VRED11;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> GR_VRED12;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> GR_VRED13;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> GR_VRED14;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> GR_VRED15;
    
    
    
    ObservableList<BVMpAkcNazivVredX15> Art_data; 
         TableColumn<BVMpAkcNazivVredX15,String>     Art_NAZIV;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> Art_VRED1;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> Art_VRED2;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> Art_VRED3;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> Art_VRED4;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> Art_VRED5;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> Art_VRED6;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> Art_VRED7;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> Art_VRED8;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> Art_VRED9;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> Art_VRED10;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> Art_VRED11;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> Art_VRED12;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> Art_VRED13;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> Art_VRED14;
       TableColumn<BVMpAkcNazivVredX15,BigDecimal> Art_VRED15;
  
    
    private EntityManager em;

  
    @Override
   public void initialize(URL url, ResourceBundle rb) {
         this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();  
         
         txt_id.setText(JavaFXTemplate.param2_id_artikla);
         txt_sifra.setText(JavaFXTemplate.param2_sifra_artikla);  
         txt_naziv.setText(JavaFXTemplate.param2_naziv_artikla);
         
         if (!"".equals(JavaFXTemplate.param2_id_artikla)){    pozoviIzvGrupisano();}
         JavaFXTemplate.param2_id_artikla="";
          JavaFXTemplate.param2_sifra_artikla="";
          JavaFXTemplate.param2_naziv_artikla="";
         
          //menjanjem selektovanog reda u donjoj tabeli prikazujem ostale artikle iz iste rg
              tblGrupisano.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tblGrupisano.getSelectionModel().getSelectedItem() != null) 
        {    
          
           TableView.TableViewSelectionModel selectionModel = tblGrupisano.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);

           
           List<BVMpAkcNazVred> selected = selectionModel.getSelectedItems();
           //System.out.println(AR_data.get(tblARTIKLI.getSelectionModel().getSelectedIndex()).getBroj());
          prikaziIsteArtikleIzAkcije();
        
           
        
         }
         }
     });
    
}

   @FXML
    public void pozoviMaskuAkcije() throws IOException {
        JavaFXTemplate.showAkcije();
    }
    
   
   // POPUNJAVA GORNJU TABELU SA Artiklima IZ PRETRAGE
@FXML
     public void pozoviIzvGrupisano() {
          

               
    
         
         
         
                   
             em.clear();
          
         
         List<BVMpAkcNazivVredX15>  results =   em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,"
                 + "vred5,vred6,vred7,vred8,vred9,vred10,vred11,vred12,vred13,vred14,vred15\n" +
"from table(" +
"bojanivetic.b_mp_akc_artikal_istorijski" +
" ("+txt_id.getText()+"))", BVMpAkcNazivVredX15.class)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList(); 
     
        
  
          GR_data = FXCollections.observableArrayList(results);
          
          
           
          GR_NAZIV=new TableColumn ("naziv");
          GR_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          GR_NAZIV.setPrefWidth(315);
          
          GR_VRED1=new TableColumn ("Prodaja");
          GR_VRED1.setCellValueFactory(new PropertyValueFactory<>("vred1"));
          GR_VRED1.setPrefWidth(90);
          
          GR_VRED2=new TableColumn ("Zaliha");
          GR_VRED2.setCellValueFactory(new PropertyValueFactory<>("vred2"));
          GR_VRED2.setPrefWidth(90);
          
          GR_VRED3=new TableColumn ("Prodaja_din");
          GR_VRED3.setCellValueFactory(new PropertyValueFactory<>("vred3"));
          GR_VRED3.setPrefWidth(110);
          
          GR_VRED4=new TableColumn ("Preporucena");
          GR_VRED4.setCellValueFactory(new PropertyValueFactory<>("vred4"));
          GR_VRED4.setPrefWidth(95);
          
          GR_VRED5=new TableColumn ("KO");
          GR_VRED5.setCellValueFactory(new PropertyValueFactory<>("vred5"));
          GR_VRED5.setPrefWidth(65);
          
          GR_VRED6=new TableColumn ("Nule");
          GR_VRED6.setCellValueFactory(new PropertyValueFactory<>("vred6"));
          GR_VRED6.setPrefWidth(65);
          
          GR_VRED7=new TableColumn ("Proc_OOS");
          GR_VRED7.setCellValueFactory(new PropertyValueFactory<>("vred7"));
          GR_VRED7.setPrefWidth(90);
          
          GR_VRED8=new TableColumn ("% ostvarenja");
          GR_VRED8.setCellValueFactory(new PropertyValueFactory<>("vred8"));
          GR_VRED8.setPrefWidth(120);
          
          GR_VRED9=new TableColumn ("Neispor sa VP");
          GR_VRED9.setCellValueFactory(new PropertyValueFactory<>("vred9"));
          GR_VRED9.setPrefWidth(100);
          
        
          
          
             tblGrupisano.getColumns().setAll(GR_NAZIV,GR_VRED1,GR_VRED2,GR_VRED3,GR_VRED4,GR_VRED5,GR_VRED6,GR_VRED7,GR_VRED8,GR_VRED9);
          //   tblGrupisano.getColumns().setAll(GR_NAZIV);
          
         
          
          tblGrupisano.setItems(GR_data);
          
          
       
                
     }
     
     

      // POPUNJAVA DONJU TABELU SA SVIM ARTIKLIMA IZ SELEKTOVANE RG
     public void prikaziIsteArtikleIzAkcije() {
    
           if ((txt_id.getText().trim().length() != 0  ))
       {
         
         
         
        em.clear();
        List<BVMpAkcNazivVredX15>  results =  em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,"
                 + "vred5,vred6,vred7,vred8,vred9,vred10,vred11,vred12,vred13,vred14,vred15\n" +
"from table(   " +
"bojanivetic.b_mp_akc_analiza_art_rg" +
" ("+GR_data.get(tblGrupisano.getSelectionModel().getSelectedIndex()).getVred14()+"," +
                txt_id.getText()
                +") )", BVMpAkcNazivVredX15.class)
               
            //   .setParameter("vred14",GR_data.get(tblArtikliIzAkcije.getSelectionModel().getSelectedIndex()).getVred14())
            //data.get(tabela.getSelectionModel().getSelectedIndex()).getId();   
               .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();     
         
        Art_data = FXCollections.observableArrayList(results);
          
          
           
          Art_NAZIV=new TableColumn ("naziv");
          Art_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          Art_NAZIV.setPrefWidth(315);
          
          Art_VRED1=new TableColumn ("Prodaja");
          Art_VRED1.setCellValueFactory(new PropertyValueFactory<>("vred1"));
          Art_VRED1.setPrefWidth(90);
          
          Art_VRED2=new TableColumn ("Zaliha");
          Art_VRED2.setCellValueFactory(new PropertyValueFactory<>("vred2"));
          Art_VRED2.setPrefWidth(90);
          
          Art_VRED3=new TableColumn ("Prodaja_din");
          Art_VRED3.setCellValueFactory(new PropertyValueFactory<>("vred3"));
          Art_VRED3.setPrefWidth(110);
          
          Art_VRED4=new TableColumn ("Preporucena");
          Art_VRED4.setCellValueFactory(new PropertyValueFactory<>("vred4"));
          Art_VRED4.setPrefWidth(95);
          
          Art_VRED5=new TableColumn ("KO");
          Art_VRED5.setCellValueFactory(new PropertyValueFactory<>("vred5"));
          Art_VRED5.setPrefWidth(65);
          
          Art_VRED6=new TableColumn ("Nule");
          Art_VRED6.setCellValueFactory(new PropertyValueFactory<>("vred6"));
          Art_VRED6.setPrefWidth(65);
          
          Art_VRED7=new TableColumn ("Proc_OOS");
          Art_VRED7.setCellValueFactory(new PropertyValueFactory<>("vred7"));
          Art_VRED7.setPrefWidth(90);
          
          Art_VRED8=new TableColumn ("% ostvarenja");
          Art_VRED8.setCellValueFactory(new PropertyValueFactory<>("vred8"));
          Art_VRED8.setPrefWidth(120);
          
          Art_VRED9=new TableColumn ("Neispor sa VP");
          Art_VRED9.setCellValueFactory(new PropertyValueFactory<>("vred9"));
          Art_VRED9.setPrefWidth(100);
          
          Art_VRED14=new TableColumn ("Id");
          Art_VRED14.setCellValueFactory(new PropertyValueFactory<>("vred14"));
          Art_VRED14.setPrefWidth(100);
          
          
             tblArtikliIzAkcije.getColumns().setAll(Art_NAZIV,Art_VRED1,Art_VRED2,Art_VRED3,Art_VRED4,Art_VRED5,Art_VRED6,Art_VRED7,Art_VRED8,Art_VRED9);
          //   tblGrupisano.getColumns().setAll(GR_NAZIV);
          
         
          
          tblArtikliIzAkcije.setItems(Art_data);
          
        
}
     
     else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PAŽNJA!");
            alert.setHeaderText("Greška!");
            alert.setContentText("Proverite da li ste uneli podatke u ID polje!");
            alert.showAndWait();  
       }
     
}
}
