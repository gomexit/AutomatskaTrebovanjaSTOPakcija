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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.TextAlignment;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.eclipse.persistence.config.QueryHints;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressIndicator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * FXML Controller class
 *
 * @author bojan
 */
public class FXMLPreglediAkcijaController implements Initializable {

    
      private EntityManager em;
     ObservableList<BMpAkcije> data; 
     ObservableList<BVMpAkcMatricaRazvozaDop> RD_data; 
     ObservableList<BVMpAkcNazivVredX7> PK_data; 
     ObservableList<BVMpAkcNazivVredX11> PK_data_korigovan; 
     ObservableList<BVMpAkcPreporKolTemp> PKT_data; 
     ObservableList<BVMpAkcDopunskaTrebovanja> DT_data;
     ObservableList<BVMpAkcRazvozPrvoPunj> RP_data;
     ObservableList<BVMpAkcNazivVredX7> AN_data;
     ObservableList<BVMpAkcNazivVredX7> OJ_data;
     ObservableList<BVMpAkcNazivVredX15> GR_data;
     ObservableList<BVMpAkcNazVred> AR_data;
     ObservableList<BVMpAkcNazVred> MPO_data;
     ObservableList<BVMpAkcNazivVredX7> UK_data;
     
     @FXML Label lblKo;
     @FXML Label lblProsOOS;
     @FXML Label lblZaliha;
     @FXML Label lblProdaja;
     @FXML Label lblRad;
     @FXML LineChart LineChart1;
     @FXML LineChart LineChart2;
     @FXML LineChart LineChart3;
     @FXML LineChart LineChart4;
     @FXML PieChart PieChart1;
     @FXML ProgressIndicator pi;
     
     @FXML LineChart LineChartKOpoOJTrend;
     @FXML LineChart LineChartOOSpoOJ;
     @FXML LineChart lineChartProdajaZalihaOJ;
     @FXML BarChart  BarChartPoredjenjeProdaje;
     @FXML BarChart  BarChartVrednostiZaliha;
     
 
     
     @FXML Label lbl2Prepor;
     @FXML Label lbl2Ostvar;
     @FXML Label lbl2Zaliha;
     @FXML Label lbl2Ko;
     @FXML Label lbl2Prodaja;
     @FXML Label lbl2Nule;
     
     
     @FXML Label lblProcOOSUK_A;
     @FXML Label lblZalihaUK_A;
     @FXML Label lblKoUK_A;
     @FXML Label lbl1ProdajaUK_A;
     
     @FXML Label lblProcOOSUK_R;
     @FXML Label lblZalihaUK_R;
     @FXML Label lblKoUK_R;
     @FXML Label lbl1ProdajaUK_R;
     

     
     
     @FXML TabPane tabPane;
     @FXML Tab tabArtikal;
     @FXML Tab tabOJ;
     @FXML Tab tabGrupisano;
     
          
    @FXML   TableView tabela;
    @FXML   TableView tblRazvozDopuna;    
    @FXML   TableView tblPreporKol; 
    @FXML   TableView tblPreporKolTemp; 
    @FXML   TableView tblDopunskaTrebovanja;
    @FXML   TableView tblProba;
    @FXML   TableView tblrazvozPrvoPunj;
    @FXML   TableView tblARTIKLI;  
    @FXML   TableView tblPoOJ;
    @FXML   TableView tblGrupisano;
    @FXML   TableView tblListaSvihMPO;
    @FXML Label lblOJ;
  
    
  //  @FXML TabPane tabPane;
    @FXML Tab tabAnalitika;
    
    //kolone za tabelu akcija
         TableColumn<BMpAkcije,Integer> ID;
         TableColumn<BMpAkcije,String> TIP_AKCIJE;
         TableColumn<BMpAkcije,Date> DATUM_OD;
         TableColumn<BMpAkcije,Date> DATUM_DO;
         TableColumn<BMpAkcije,String> STATUS;
         TableColumn<BMpAkcije,String> KOMENTAR;    
    
    //kolone za tabelu Matrica Razvoza - dopuna - PREFIX RD_
       TableColumn<BVMpAkcMatricaRazvozaDop,Integer> RD_ID;
       TableColumn<BVMpAkcMatricaRazvozaDop,Integer> RD_BROJ_DOPUNE;
       TableColumn<BVMpAkcMatricaRazvozaDop,String> RD_ORGJED;
       TableColumn<BVMpAkcMatricaRazvozaDop,String> RD_NAZIV_OJ;
       TableColumn<BVMpAkcMatricaRazvozaDop,String> RD_MAGACIN;
       TableColumn<BVMpAkcMatricaRazvozaDop,Date> RD_DATUM;
       TableColumn<BVMpAkcMatricaRazvozaDop,String> RD_DAN_U_NEDELJI;
       TableColumn<BVMpAkcMatricaRazvozaDop,String> RD_STATUS;
       TableColumn<BVMpAkcMatricaRazvozaDop,Date> RD_POC_DATUM_PROJEKCIJE;
       TableColumn<BVMpAkcMatricaRazvozaDop,Date> RD_KRAJ_DATUM_PROJEKCIJE;
    
       
    //kolone za tabelu Matrica Razvoza - prvo punjenje - PREFIX RD_
       TableColumn<BVMpAkcRazvozPrvoPunj,Integer> RP_ID;
       TableColumn<BVMpAkcRazvozPrvoPunj,Integer> RP_BROJ_DOPUNE;
       TableColumn<BVMpAkcRazvozPrvoPunj,String> RP_ORGJED;
       TableColumn<BVMpAkcRazvozPrvoPunj,String> RP_NAZIV_OJ;
       TableColumn<BVMpAkcRazvozPrvoPunj,String> RP_MAGACIN;
       TableColumn<BVMpAkcRazvozPrvoPunj,Date> RP_DATUM;
       TableColumn<BVMpAkcRazvozPrvoPunj,String> RP_DAN_U_NEDELJI;
       TableColumn<BVMpAkcRazvozPrvoPunj,String> RP_STATUS;
       TableColumn<BVMpAkcRazvozPrvoPunj,Date> RP_POC_DATUM_PROJEKCIJE;
       TableColumn<BVMpAkcRazvozPrvoPunj,Date> RP_KRAJ_DATUM_PROJEKCIJE; 
    
    //kolone za preporucene kolicine po osnovnom algoritmu

       TableColumn<BVMpAkcNazivVredX7,String>     PK_NAZIV;
       TableColumn<BVMpAkcNazivVredX7,BigDecimal> PK_VRED1;
       TableColumn<BVMpAkcNazivVredX7,BigDecimal> PK_VRED2;
       TableColumn<BVMpAkcNazivVredX7,BigDecimal> PK_VRED3;
       TableColumn<BVMpAkcNazivVredX7,BigDecimal> PK_VRED4;
       TableColumn<BVMpAkcNazivVredX7,BigDecimal> PK_VRED5;
       TableColumn<BVMpAkcNazivVredX7,BigDecimal> PK_VRED6;
       TableColumn<BVMpAkcNazivVredX7,BigDecimal> PK_VRED7;
    
        
    //kolone za preporucene kolicine po osnovnom algoritmu korigovan izv

       TableColumn<BVMpAkcNazivVredX11,String>     PK_NAZIV_KORIG;
       TableColumn<BVMpAkcNazivVredX11,BigDecimal> PK_VRED1_KORIG;
       TableColumn<BVMpAkcNazivVredX11,BigDecimal> PK_VRED2_KORIG;
       TableColumn<BVMpAkcNazivVredX11,BigDecimal> PK_VRED3_KORIG;
       TableColumn<BVMpAkcNazivVredX11,BigDecimal> PK_VRED4_KORIG;
       TableColumn<BVMpAkcNazivVredX11,BigDecimal> PK_VRED5_KORIG;
       TableColumn<BVMpAkcNazivVredX11,BigDecimal> PK_VRED6_KORIG;
       TableColumn<BVMpAkcNazivVredX11,BigDecimal> PK_VRED7_KORIG;
       TableColumn<BVMpAkcNazivVredX11,BigDecimal> PK_VRED8_KORIG;
       TableColumn<BVMpAkcNazivVredX11,BigDecimal> PK_VRED9_KORIG;
       TableColumn<BVMpAkcNazivVredX11,BigDecimal> PK_VRED10_KORIG;
       TableColumn<BVMpAkcNazivVredX11,BigDecimal> PK_VRED11_KORIG;
    
        //kolone za tabelu lista artikala
         TableColumn<BVMpAkcNazVred,Long> AR_ARTIKAL;
         TableColumn<BVMpAkcNazVred,String> AR_SIFRA;
         TableColumn<BVMpAkcNazVred,String> AR_NAZIV;
         
        //kolone za tabelu lista svih objekata
         TableColumn<BVMpAkcNazVred,Long> MPO_MPO;
         TableColumn<BVMpAkcNazVred,String> MPO_NAZIV;
    
    
    //kolone za PREGLED PO ARTIKLU PO OJ

       TableColumn<BVMpAkcNazivVredX7,String>     OJ_NAZIV;
       TableColumn<BVMpAkcNazivVredX7,BigDecimal> OJ_VRED1;
       TableColumn<BVMpAkcNazivVredX7,BigDecimal> OJ_VRED2;
       TableColumn<BVMpAkcNazivVredX7,BigDecimal> OJ_VRED3;
       TableColumn<BVMpAkcNazivVredX7,BigDecimal> OJ_VRED4;
       TableColumn<BVMpAkcNazivVredX7,BigDecimal> OJ_VRED5;
       TableColumn<BVMpAkcNazivVredX7,BigDecimal> OJ_VRED6;
       TableColumn<BVMpAkcNazivVredX7,BigDecimal> OJ_VRED7;
    
        //kolone za PREGLED GRUPISANO

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

    
    @FXML TextArea PK_OPIS_AREA;
    @FXML ListView<String> listaRadnji;
    @FXML ComboBox PK_P_radnja;
    @FXML TextField PK_P_id_artikla;
    @FXML TextField PK_P_sifra;
    @FXML TextField PK_P_naziv_artikla;
    @FXML TextField PK_P_RG;
    @FXML ComboBox PK_P_algoritam;
    @FXML ComboBox GR_cmb_tip_izv;
    
    
    //kolone za analitiku prepor temp
     //kolone za preporucene kolicine po osnovnom algoritmu
       TableColumn<BVMpAkcPreporKolTemp,Integer> PKT_ID;
       TableColumn<BVMpAkcPreporKolTemp,Long> PKT_ID_AKCIJE;
       TableColumn<BVMpAkcPreporKolTemp,String> PKT_ID_KAMPANJE;
       TableColumn<BVMpAkcPreporKolTemp,String> PKT_ORGJED;
       TableColumn<BVMpAkcPreporKolTemp,String> PKT_NAZIV_ORGJED;
       TableColumn<BVMpAkcPreporKolTemp,Long> PKT_ARTIKAL;
       TableColumn<BVMpAkcPreporKolTemp,String> PKT_SIFRA;
       TableColumn<BVMpAkcPreporKolTemp,String> PKT_NAZIV;
       TableColumn<BVMpAkcPreporKolTemp,Integer> PKT_PRIMENJEN_ALGORITAM;
       TableColumn<BVMpAkcPreporKolTemp,String> PKT_OPIS;
       TableColumn<BVMpAkcPreporKolTemp,BigDecimal> PKT_PREPORUCENA;
       TableColumn<BVMpAkcPreporKolTemp,BigDecimal> PKT_PREPOR_BEZ_KOEF;
       TableColumn<BVMpAkcPreporKolTemp,BigDecimal> PKT_CENA;
       TableColumn<BVMpAkcPreporKolTemp,String> PKT_ROBNA_GRUPA;
    
    @FXML TextArea txtAreaOpisAnalitika;
    
    //kolone za tabelu dopunska trebovanja
       TableColumn<BVMpAkcDopunskaTrebovanja,String> DT_ORGJED;
       TableColumn<BVMpAkcDopunskaTrebovanja,String> DT_RADNJA;
       TableColumn<BVMpAkcDopunskaTrebovanja,Long> DT_ID_ARTIKLA;
       TableColumn<BVMpAkcDopunskaTrebovanja,String> DT_SIFRA;
       TableColumn<BVMpAkcDopunskaTrebovanja,String> DT_NAZIV_ARTIKLA;
       TableColumn<BVMpAkcDopunskaTrebovanja,Integer> DT_BROJ_DOPUNE;    
       TableColumn<BVMpAkcDopunskaTrebovanja,String> DT_MAGACIN;
       TableColumn<BVMpAkcDopunskaTrebovanja,Date> DT_DATUM;
       TableColumn<BVMpAkcDopunskaTrebovanja,BigDecimal> DT_MULTIFAKTOR;
       TableColumn<BVMpAkcDopunskaTrebovanja,BigDecimal> DT_ZALIHA;
       TableColumn<BVMpAkcDopunskaTrebovanja,Date> DT_DATUM_ZALIHE;
       TableColumn<BVMpAkcDopunskaTrebovanja,BigDecimal> DT_PREPOR_KOL_DO_ISPORUKE;
       TableColumn<BVMpAkcDopunskaTrebovanja,BigDecimal> DT_PREPOR_KOL_PERIOD;
       TableColumn<BVMpAkcDopunskaTrebovanja,BigDecimal> DT_NESREDJENA_KOLICINA;
       TableColumn<BVMpAkcDopunskaTrebovanja,BigDecimal> DT_SREDJENA_KOLCINA;
       TableColumn<BVMpAkcDopunskaTrebovanja,Date> DT_PROJEKCIJA_OD;
       TableColumn<BVMpAkcDopunskaTrebovanja,Date> DT_PROJEKCIJA_DO;
   // @FXML   TableColumn<BVMpAkcDopunskaTrebovanja,String> DT_OPIS;
    @FXML   TableColumn<BVMpAkcDopunskaTrebovanja,String> DT_RG_ROOT;
   
    
    @FXML TextField DT_P_naziv_artikla;
    @FXML TextField DT_P_sifra;
    @FXML DatePicker DT_P_datum_od;
    @FXML DatePicker DT_P_datum_do;
    @FXML ComboBox DT_P_radnja;
    @FXML ComboBox DT_P_MAGACIN;
    @FXML ComboBox DT_P_broj_dopune;
    @FXML TextArea DT_P_opis_area;
    @FXML TextField DT_P_id_artikla;
    
    
    @FXML ListView listaIzvestaja;
    @FXML ListView listaStavkiizvestaja;
   @FXML ComboBox IZV_cmb_tip_artikla;
   @FXML ComboBox IZV_cmb_prehrana_nepreh;
   @FXML ComboBox IZV_cmb_lista_objekata;
   @FXML ComboBox IZV_cmb_lista_odeljenja;
   @FXML ComboBox IZV_cmb_lista_algoritama;
   @FXML ComboBox IZV_cmb_razvoz;
 //  @FXML ComboBox IZV_cmb_nacin_prikaza;
   @FXML ComboBox IZV_cmb_VP_magacin;
   @FXML ComboBox IZV_cmb_tip_objekta;
    
    @FXML BarChart  BarChartIZV;
    @FXML LineChart LineChartIZV;
    @FXML CheckBox  checkGrafik;
    @FXML CheckBox  checkTabela;
    @FXML TableView tblIZV;
    ObservableList<BVMpAkcNazivVredX7> IZVESTAJI_data;
    TableColumn<BVMpAkcRazvozPrvoPunj,String> IZVESTAJI_naziv;
    TableColumn<BVMpAkcRazvozPrvoPunj,BigDecimal> IZVESTAJI_VRED1;
    TableColumn<BVMpAkcRazvozPrvoPunj,BigDecimal> IZVESTAJI_VRED2;
    TableColumn<BVMpAkcRazvozPrvoPunj,BigDecimal> IZVESTAJI_VRED3;
    TableColumn<BVMpAkcRazvozPrvoPunj,BigDecimal> IZVESTAJI_VRED4;
    TableColumn<BVMpAkcRazvozPrvoPunj,BigDecimal> IZVESTAJI_VRED5;
    TableColumn<BVMpAkcRazvozPrvoPunj,BigDecimal> IZVESTAJI_VRED6;
   
   //parametri 
    
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
        popuniInicijalno();
        popuniInicijalnoListe();
        listaSvihRadnji2();
       
    }    

    private void popuniInicijalno() {
        listaSvihRadnji();
       //i.setProgress(0.55);
       // popuni inicijalno combobox u trecem tabu po grupi
                List<String> list = new ArrayList<String>();
        list.add("PO_ARTIKLU");
        list.add("PO_MPO");
        list.add("PO_ROBNOJ_GRUPI");
        list.add("PO_MAGACINU_VP");        
        ObservableList obList = FXCollections.observableList(list);
        GR_cmb_tip_izv.getItems().clear();
        GR_cmb_tip_izv.setItems(obList);
        //kraj popune comboboxa za grupisanje izvestaja
       
        
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
          
          tabela.getColumns().setAll(ID, TIP_AKCIJE,DATUM_OD,DATUM_DO,STATUS,KOMENTAR);
          tabela.setItems(data);
          tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tabela.getSelectionModel().getSelectedItem() != null) 
        {    
          
           TableView.TableViewSelectionModel selectionModel = tabela.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);

           
           List<BMpAkcije> selected = selectionModel.getSelectedItems();

           listaRadnji(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
           
           vratiUdeoAkcije(); 
      
           prikaziZbirnePokazatelje();
            //napuniDijagrame();
            
                  
        //odeljenja
        em.clear();
          List<String>  results =  em.createNamedQuery( "BVMpAkcOdeljenja.PrikaziNazive")
                  .setParameter("id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId())
                  .getResultList();
       
        
       ObservableList obList4 = FXCollections.observableList(results);
         
        IZV_cmb_lista_odeljenja.getItems().clear();
        IZV_cmb_lista_odeljenja.setItems( obList4);
        IZV_cmb_lista_odeljenja.getSelectionModel().select(0);
        
        
            listaAlgoritama(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
       
         }
         }
     });
          
          //KREIRAJ DOGADJAJ KAD SE KLIKNE NA ARTIKAL DA KORISNIK DOBIJE LISTU OBJEKATA SA PODACIMA
          
            tblARTIKLI.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tblARTIKLI.getSelectionModel().getSelectedItem() != null) 
        {    
          
           TableView.TableViewSelectionModel selectionModel = tblARTIKLI.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);

           
           List<BVMpAkcNazVred> selected = selectionModel.getSelectedItems();
           //System.out.println(AR_data.get(tblARTIKLI.getSelectionModel().getSelectedIndex()).getBroj());
           listaOJ(AR_data.get(tblARTIKLI.getSelectionModel().getSelectedIndex()).getBroj());
        
           
        
         }
         }
     });
            
            
            //menjanjem selektovanog reda u donjoj tabeli prikazujem ostale artikle iz iste rg
                      
            tblARTIKLI.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tblARTIKLI.getSelectionModel().getSelectedItem() != null) 
        {    
          
           TableView.TableViewSelectionModel selectionModel = tblARTIKLI.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);

           
           List<BVMpAkcNazVred> selected = selectionModel.getSelectedItems();
           //System.out.println(AR_data.get(tblARTIKLI.getSelectionModel().getSelectedIndex()).getBroj());
           listaOJ(AR_data.get(tblARTIKLI.getSelectionModel().getSelectedIndex()).getBroj());
        
           
        
         }
         }
     });
           
        
             listaRadnji.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String> () {

             @Override
             public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
                //listaPreporKol2(data.get(tabela.getSelectionModel().getSelectedIndex()).getId(), newValue);
                
                 List<String>  results =  em.createNamedQuery("BVMpAkcPreporKol.nadjiIdRadnje")
                  .setParameter("id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId())
                  .setParameter("nazivOJ", newValue)
                  .getResultList();
                 
                 System.out.println(results.get(0));
                 lblOJ.setText(results.get(0));
             }
         });
             
          //promenom radnje menjaj grafike
             
            tblListaSvihMPO.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tblListaSvihMPO.getSelectionModel().getSelectedItem() != null) 
        {    
          
           TableView.TableViewSelectionModel selectionModel = tblListaSvihMPO.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);

          /* vratiTrendKOPoMPO();
           vratiTrendOOSPoMPO();
           vratiOdnosProdajeiZaliha();
           poredjenjeProdaje();*/
           refreshGrafikaPoOJ();
           
         }
         }
     });  
             
             
             
             
    }
  
  @FXML
     public void listaIzvestaj1() {
        em.clear();
        
        Integer i=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();  
         List<BVMpAkcNazivVredX7>  results =   em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n" +
"from table(\n" +
"bojanivetic.b_mp_akc_izvestaji2\n" +
" ("+i+",\n" +
" 1,\n" +
lblOJ.getText()+ ",'1'))", BVMpAkcNazivVredX7.class)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList(); 
        
        
  
          PK_data = FXCollections.observableArrayList(results);
          
          
           
          PK_NAZIV=new TableColumn ("PK_NAZIV");
          PK_NAZIV.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,String>("naziv"));
          PK_NAZIV.setPrefWidth(290);
          
          PK_VRED1=new TableColumn ("ZALIHA PS");
          PK_VRED1.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred1"));
          PK_VRED1.setPrefWidth(120);
          
          PK_VRED2=new TableColumn ("PRIJEM");
          PK_VRED2.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred2"));
          PK_VRED2.setPrefWidth(120);
          
          PK_VRED3=new TableColumn ("PRODAJA");
          PK_VRED3.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred3"));
          PK_VRED3.setPrefWidth(120);
          
          PK_VRED4=new TableColumn ("ZALIHA KRAJ");
          PK_VRED4.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred4"));
          PK_VRED4.setPrefWidth(120);
          
          PK_VRED5=new TableColumn ("BR DANA OOS");
          PK_VRED5.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred5"));
          PK_VRED5.setPrefWidth(120);
          
          PK_VRED6=new TableColumn ("KO");
          PK_VRED6.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred6"));
          PK_VRED6.setPrefWidth(120);
    
          tblPreporKol.getColumns().setAll(PK_NAZIV,PK_VRED1,PK_VRED2,PK_VRED3,PK_VRED4,PK_VRED5,PK_VRED6);
     
          tblPreporKol.setItems(PK_data);
          
         sumarniPodaci();
          
    }
  
      @FXML
     public void listaIzvestaj3() {
        
      //   lblRad.setText("Ucitavanje u toku.....");
         em.clear();
        
    
        
        String v_id_artikla=PK_P_id_artikla.getText();
        if ( !"".equals( v_id_artikla) ) {  
          } else {
            v_id_artikla="-1";
          }
        
        String v_sifra_artikla=PK_P_sifra.getText();
        if ( !"".equals( v_sifra_artikla) ) {  
          } else {
            v_sifra_artikla="-1";
          }
        
        String v_naziv_artikla=PK_P_naziv_artikla.getText();
        if ( !"".equals( v_naziv_artikla) ) {  
            v_naziv_artikla=v_naziv_artikla.toUpperCase();
          } else {
            v_naziv_artikla="-1";
          }
        
        Integer i=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();  
         List<BVMpAkcNazivVredX7>  results =   em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n" +
"from table(\n" +
"bojanivetic.b_mp_akc_izvestaji3\n" +
" ("+i+",\n" +
v_id_artikla+",\n" +
v_sifra_artikla+",\n" +
"'"+v_naziv_artikla+"'"+",\n" +
//" 1,\n" +
lblOJ.getText()+ ",'1'))", BVMpAkcNazivVredX7.class)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList(); 
        
        
  
          PK_data = FXCollections.observableArrayList(results);
          
          
           
          PK_NAZIV=new TableColumn ("PK_NAZIV");
          PK_NAZIV.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,String>("naziv"));
          PK_NAZIV.setPrefWidth(290);
          
          PK_VRED1=new TableColumn ("ZALIHA PS");
          PK_VRED1.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred1"));
          PK_VRED1.setPrefWidth(120);
          
          PK_VRED2=new TableColumn ("PRIJEM");
          PK_VRED2.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred2"));
          PK_VRED2.setPrefWidth(120);
          
          PK_VRED3=new TableColumn ("PRODAJA");
          PK_VRED3.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred3"));
          PK_VRED3.setPrefWidth(120);
          
          PK_VRED4=new TableColumn ("ZALIHA KRAJ");
          PK_VRED4.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred4"));
          PK_VRED4.setPrefWidth(120);
          
          PK_VRED5=new TableColumn ("BR DANA OOS");
          PK_VRED5.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred5"));
          PK_VRED5.setPrefWidth(120);
          
          PK_VRED6=new TableColumn ("KO");
          PK_VRED6.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred6"));
          PK_VRED6.setPrefWidth(120);
    
          tblPreporKol.getColumns().setAll(PK_NAZIV,PK_VRED1,PK_VRED2,PK_VRED3,PK_VRED4,PK_VRED5,PK_VRED6);
     
          tblPreporKol.setItems(PK_data);
          
         sumarniPodaci();
        lblRad.setText(listaRadnji.getSelectionModel().getSelectedItem());
          
    }
     
     @FXML
     public void izvozUExcel() throws FileNotFoundException, IOException {
         /* String filename = PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getNaziv();
          System.out.println(filename);
          String[] parts = filename.split("\\-");
           System.out.println(parts[2]);*/
           
           
      
        if ((tabela.getSelectionModel().getSelectedIndex()>-1)  )
       {
      
        em.clear();
        
    
        
        String v_id_artikla=PK_P_id_artikla.getText();
        if ( !"".equals( v_id_artikla) ) {  
          } else {
            v_id_artikla="-1";
          }
        
        String v_sifra_artikla=PK_P_sifra.getText();
        if ( !"".equals( v_sifra_artikla) ) {  
          } else {
            v_sifra_artikla="-1";
          }
        
        String v_naziv_artikla=PK_P_naziv_artikla.getText();
        if ( !"".equals( v_naziv_artikla) ) {  
            v_naziv_artikla=v_naziv_artikla.toUpperCase();
          } else {
            v_naziv_artikla="-1";
          }
        
        Integer i=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();  
         List<BVMpAkcNazivVredX11>  results =   em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7,vred8,vred9,vred10,vred11\n" +
"from table(\n" +
"bojanivetic.b_mp_akc_izvestaji3_prosiren\n" +
" ("+i+",\n" +
v_id_artikla+",\n" +
v_sifra_artikla+",\n" +
"'"+v_naziv_artikla+"'"+",\n" +
//" 1,\n" +
lblOJ.getText()+ ",'1'))", BVMpAkcNazivVredX11.class)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList(); 
        
        //PK_VRED11_KORIG
  
          PK_data_korigovan = FXCollections.observableArrayList(results);
          
          
          
          
                
    Workbook wb = (Workbook) new HSSFWorkbook();
    CreationHelper createhelper = wb.getCreationHelper();
    Sheet sheet = wb.createSheet("PREGLED PO OJ");
    Row row = null;
    Cell cell = null;
   
    
    
   
        
         
   
    //kreiraj zaglavlje dokument
     row = sheet.createRow(0);
            cell = row.createCell(0);
            cell.setCellValue((String) "PK_NAZIV");
           
            cell = row.createCell(1);
            cell.setCellValue((String) "ZALIHA PS");
           
            cell = row.createCell(2);
            cell.setCellValue((String) "PRIJEM");
           
             cell = row.createCell(3);
            cell.setCellValue((String) "PRODAJA");
           
            cell = row.createCell(4);
            cell.setCellValue((String) "ZALIHA KRAJ");
           
      
            cell = row.createCell(5);
            cell.setCellValue((String) "BR DANA OOS");
           
            cell = row.createCell(6);
            cell.setCellValue((String) "KO");
           
             cell = row.createCell(7);
            cell.setCellValue((String) "ZALIHA vred");
           
            cell = row.createCell(8);
            cell.setCellValue((String) "PRODAJA vred");
           
            cell = row.createCell(9);
            cell.setCellValue((String) "PREPORUKA");
           
             cell = row.createCell(10);
            cell.setCellValue((String) "Ostvarenje prepor");
           
          
    //kraj kreiranja zaglavlja
 
    for (int c=0;c<results.size();c++) {
        row = sheet.createRow(c+1); //IDE
       
       
      
     
     //  GR_NAZIV,GR_VRED1,GR_VRED2,GR_VRED3,GR_VRED4,GR_VRED5,GR_VRED6,GR_VRED13,GR_VRED7,GR_VRED8,GR_VRED9,GR_VRED10,GR_VRED11,GR_VRED12
    
      
       
               if (results.get(c).getNaziv() != null)
            {
            cell = row.createCell(0);
            cell.setCellValue((String) results.get(c).getNaziv());
            }else
            {
            cell = row.createCell(0);
            cell.setCellValue((String) "/");
            }      
              
              
           
            if (results.get(c).getVred1() != null)
            {
            cell = row.createCell(1);
            cell.setCellValue((String) results.get(c).getVred1().toString());
            }else
            {
            cell = row.createCell(1);
            cell.setCellValue((String) "/");
            }
           
           
            if (results.get(c).getVred2() != null)
            {
            cell = row.createCell(2);
            cell.setCellValue((String) results.get(c).getVred2().toString());
             }else
            {
            cell = row.createCell(2);
            cell.setCellValue((String) "/");
            }
           
            if (results.get(c).getVred3() != null)
            {
            cell = row.createCell(3);
            cell.setCellValue((String) results.get(c).getVred3().toString());
            }
            else
            {
            cell = row.createCell(3);
            cell.setCellValue((String) "/");      
            }
           
           
            if (results.get(c).getVred4() != null)
            {
            cell = row.createCell(4);
            cell.setCellValue((String) results.get(c).getVred4().toString());
            }
            else
            {
            cell = row.createCell(4);
            cell.setCellValue((String) "/");      
            }
            if (results.get(c).getVred5() != null)
            {
            cell = row.createCell(5);
            cell.setCellValue((String)results.get(c).getVred5().toString());
             }
            else
            {
            cell = row.createCell(5);
            cell.setCellValue((String) "/");      
            }
           
            if (results.get(c).getVred6() != null)
            {
            cell = row.createCell(6);
            cell.setCellValue((String)results.get(c).getVred6().toString());
             }
            else
            {
            cell = row.createCell(6);
            cell.setCellValue((String) "/");      
            }
           
           
           
            if (results.get(c).getVred7() != null)
            { 
            cell = row.createCell(7);
            cell.setCellValue((String) results.get(c).getVred7().toString());
            }else
            {
            cell = row.createCell(7);
            cell.setCellValue((String) "/");  
            }
           
           
            if (results.get(c).getVred8() != null)
            {
            cell = row.createCell(8);
            cell.setCellValue((String) results.get(c).getVred8().toString());
            }
            else
            {
            cell = row.createCell(8);
            cell.setCellValue((String) "/");  
            }   
           
            if (results.get(c).getVred9() != null)
            {
            cell = row.createCell(9);
            cell.setCellValue((String) results.get(c).getVred9().toString());
            }
            else
            {
            cell = row.createCell(9);
            cell.setCellValue((String) "/");      
            }
           
            if (results.get(c).getVred10() != null)
            {
            cell = row.createCell(10);
            cell.setCellValue((String) results.get(c).getVred10().toString());
            }
            else
            {
             cell = row.createCell(10);
            cell.setCellValue((String) "/");  
            } 
           

   
    }
         
    /*
 
   
    */
   
               
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
Date date = new Date();
System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
   // String v_ime_fajla="C:\\Desktop\\Disc.Prijave"+dateFormat.format(date)+".xls";
  String v_ime_fajla="Izveštaj po OJ  "+dateFormat.format(date)+".xls";
   
    FileOutputStream out = new FileOutputStream(v_ime_fajla);/*"E:\\workbook.xls"*/   //);
  
   
    
   

   
    wb.write(out);
    out.close();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Kreiranje Excel fajla.");
               alert.setHeaderText("Kreiran je Excel fajl.");
           //    alert.setContentText("Obračunali ste stimulacije/destimulacije za mesec "+s);
               alert.showAndWait();
           
           
     }
        
     }
    
     

     //SADA  za analitiku
     
   
     
     public void listaRadnji(Integer i) {
           em.clear();
          List<String>  results =  em.createNamedQuery("BVMpAkcPreporKol.razliciteRadnje")
                  .setParameter("id", i)
                  .getResultList();
 
          ObservableList<String> items =FXCollections.observableArrayList (results);
          listaRadnji.setItems(items);
        
     }
     
      public void listaRadnji2(Integer i) {
           em.clear();
          List<String>  results =  em.createNamedQuery("BVMpAkcPreporKol.razliciteRadnje")
                  .setParameter("id", i)
                  .getResultList();
 
          ObservableList<String> items =FXCollections.observableArrayList (results);
          DT_P_radnja.setItems(items);
          PK_P_radnja.setItems(items);
        
     }
      
    public void listaAlgoritama(Integer i) {
           em.clear();
          List<Integer>  results =  em.createNamedQuery("BVMpAkcAlgoritmi.lista")
                  .setParameter("id", i)
                  .getResultList();
 
          ObservableList<Integer> items =FXCollections.observableArrayList ( results);
       //  PK_P_algoritam.setItems(items);
         IZV_cmb_lista_algoritama.setItems(items);
          IZV_cmb_lista_algoritama.getSelectionModel().select(0);
         
        
     }
      
     public void listaMagacina(Integer i) {
           em.clear();
          List<String>  results =  em.createNamedQuery("BVMpAkcDopunskaTrebovanja.spisakMagacina")
                  .setParameter("id", i)
                  .getResultList();
 
          ObservableList<String> items =FXCollections.observableArrayList (results);
          DT_P_MAGACIN.setItems(items);
        
     }
     
      public void listaDopuna(Integer i) {
           em.clear();
          List<String>  results =  em.createNamedQuery("BVMpAkcDopunskaTrebovanja.spisakDopuna")
                  .setParameter("id", i)
                  .getResultList();
 
          ObservableList<String> items =FXCollections.observableArrayList (results);
          DT_P_broj_dopune.setItems(items);
        
     }
     
    
     
     
     @FXML
     public void obrisiPretragu()
     {
      DT_P_naziv_artikla.setText("");
      DT_P_radnja.setValue("");
      DT_P_MAGACIN.setValue("");
      DT_P_sifra.setText("");
      DT_P_MAGACIN.setValue("");
      DT_P_broj_dopune.setValue("");
      DT_P_id_artikla.setText("");
      
   
     }
     
     @FXML
     public void obrisiPretraguPreporKol ()
     {
         PK_P_id_artikla.setText("");
         PK_P_sifra.setText("");
         PK_P_naziv_artikla.setText("");
         PK_P_radnja.setValue("");
         PK_P_RG.setText("");
         PK_P_algoritam.setValue("");
     }
     
     @FXML
     public void pozoviAnalitiku() throws IOException 
     {
    /*  //   tabPaneAnalitika.show;
         SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
         selectionModel.select(tabAnalitika);
      //   listaPreporKolTemp(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
       */   
         
         /*
            String filename = PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getNaziv();
          System.out.println(filename);
          String[] parts = filename.split("\\-");
           System.out.println(parts[2]);
         */
         String filename = PK_data_korigovan.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getNaziv();
          String[] parts = filename.split("\\-");
         
         
          JavaFXTemplate.param_OJ=lblOJ.getText();
         JavaFXTemplate.param_id=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
         JavaFXTemplate.param_id_artikla= Integer.valueOf(parts[2]);
         JavaFXTemplate.param_OJ_naziv=listaRadnji.getSelectionModel().getSelectedItem();
         JavaFXTemplate.param_Artikal_naziv=PK_data_korigovan.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getNaziv();
         
          JavaFXTemplate.showAnalitikuArtikla();
     }
     
     @FXML
     public void pozoviAnalitikuIzOJ() throws IOException 
     {
    /*  //   tabPaneAnalitika.show;
         SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
         selectionModel.select(tabAnalitika);
      //   listaPreporKolTemp(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
       */   
         
         /*
            String filename = PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getNaziv();
          System.out.println(filename);
          String[] parts = filename.split("\\-");
           System.out.println(parts[2]);
         */
         String filename = OJ_data.get(tblPoOJ.getSelectionModel().getSelectedIndex()).getNaziv();
          String[] parts = filename.split("\\-");
         
         
          JavaFXTemplate.param_OJ=parts[1];
         JavaFXTemplate.param_id=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
         JavaFXTemplate.param_id_artikla= AR_data.get(tblARTIKLI.getSelectionModel().getSelectedIndex()).getBroj().intValue();
         JavaFXTemplate.param_OJ_naziv=parts[0];
         JavaFXTemplate.param_Artikal_naziv=AR_data.get(tblARTIKLI.getSelectionModel().getSelectedIndex()).getNaziv();
         
          JavaFXTemplate.showAnalitikuArtikla();
     }
     
      @FXML
     public void pozoviAnalitikuIzOJZaSveMPO() throws IOException 
     {

         
         
        //  JavaFXTemplate.param_OJ=parts[1];
         JavaFXTemplate.param_id=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
         JavaFXTemplate.param_id_artikla= AR_data.get(tblARTIKLI.getSelectionModel().getSelectedIndex()).getBroj().intValue();
       //  JavaFXTemplate.param_OJ_naziv=parts[0];
         JavaFXTemplate.param_Artikal_naziv=AR_data.get(tblARTIKLI.getSelectionModel().getSelectedIndex()).getNaziv();
         
          JavaFXTemplate.showAnalitikuArtiklaSVIMPO();
     }
     
          @FXML
     public void pozoviAnalitikuIzOJZaSveMPO2() throws IOException 
     {
     String filename = GR_data.get(tblGrupisano.getSelectionModel().getSelectedIndex()).getNaziv();
          String[] parts = filename.split("\\#");  
          
         
         
        //  JavaFXTemplate.param_OJ=parts[1];
         JavaFXTemplate.param_id=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
         JavaFXTemplate.param_id_artikla= Integer.parseInt(parts[2]);
       //  JavaFXTemplate.param_OJ_naziv=parts[0];
         JavaFXTemplate.param_Artikal_naziv=parts[0];
         
          JavaFXTemplate.showAnalitikuArtiklaSVIMPO();
     }
     
     //poziv istorijskih akcija artikla
             @FXML
     public void pozoviIstorijskeAkcije() throws IOException 
     {
     String filename = GR_data.get(tblGrupisano.getSelectionModel().getSelectedIndex()).getNaziv();
          String[] parts = filename.split("\\#");  
          
         
         
        //  JavaFXTemplate.param_OJ=parts[1];
         JavaFXTemplate.param2_id_artikla=parts[2];
         JavaFXTemplate.param2_sifra_artikla= parts[1];
       //  JavaFXTemplate.param_OJ_naziv=parts[0];
         JavaFXTemplate.param2_naziv_artikla=parts[0];
         
          JavaFXTemplate.showStatistikaArtikNaAkc();
     }
     
     public void sumarniPodaci() {
        //    String filename = PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getNaziv();
       //   String[] parts = filename.split("\\-");
      //   System.out.println("artikal:"+parts[2]);
         JavaFXTemplate.param_OJ=lblOJ.getText();
         JavaFXTemplate.param_id=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
       //  JavaFXTemplate.param_id_artikla= Integer.valueOf(parts[2]);
         JavaFXTemplate.param_OJ_naziv=listaRadnji.getSelectionModel().getSelectedItem();
         //JavaFXTemplate.param_Artikal_naziv=PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getNaziv();
         
         
          this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
        em.clear(); 

        String w="1";
        String s="select trim(naziv) as naziv,vred1,vred2,vred3,vred4,vred5,vred6,vred7\n" +
                    "from table(\n" +
                    "bojanivetic.b_mp_akc_izv_ko\n" +
                    " ("+JavaFXTemplate.param_id+",\n" +
                    " -1"+/* JavaFXTemplate.param_id_artikla  +*/ " ,\n" +
                    "" +JavaFXTemplate.param_OJ+ " ,"+w+"))";
        System.out.println(s);
       // lbl.setText(s);
         List<BVMpAkcNazivVredX7>  results;
         results= em.createNativeQuery(s, BVMpAkcNazivVredX7.class)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false") //ovo ide zbog osvezavanja gde createNativeQuery pravi problem
                 .getResultList();
         
         lblKo.setText(results.get(0).getVred5().toString());
         lblProsOOS.setText(results.get(0).getVred2().toString());
         lblProdaja.setText(results.get(0).getVred4().toString());
         lblZaliha.setText(results.get(0).getVred3().toString());
     } 
     
    
     
     
     @FXML
     public void listaArtikala() {
         
         
          if ((tabela.getSelectionModel().getSelectedIndex()>-1)  )
       {
         
         /*
             @FXML     TableColumn<BVMpAkcPreporKol,Integer> AR_ID_AKCIJE;
    @FXML     TableColumn<BVMpAkcPreporKol,String> AR_SIFRA;
    @FXML     TableColumn<BVMpAkcPreporKol,String> AR_NAZIV;
         */
         em.clear();
      /*   List<BVMpAkcNazVred>  results =  em.createNamedQuery("BVMpAkcPreporKol.listaArtikala")
                 .setParameter("id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId())
                 .getResultList();*/
         String v_naziv_artikla;
         v_naziv_artikla=DT_P_naziv_artikla.getText();
          if ( !"".equals( v_naziv_artikla) ) {  
            v_naziv_artikla=v_naziv_artikla.toUpperCase();
          } else {
            v_naziv_artikla="";
          }
         
                 List<BVMpAkcNazVred>  results =   em.createNativeQuery("SELECT distinct b.artikal as broj,b.naziv||'-'||b.sifra as naziv,0 as vrednost "
                         + "FROM B_V_MP_AKC_PREPOR_KOL b WHERE b.id = "+data.get(tabela.getSelectionModel().getSelectedIndex()).getId()+
                         "and b.naziv like '%"+v_naziv_artikla+"%'"+
                         
                         " order by 2", BVMpAkcNazVred.class)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList(); 
           AR_data = FXCollections.observableArrayList(results);
          
           
          AR_ARTIKAL=new TableColumn ("id artikla");
          AR_ARTIKAL.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazVred,Long>("broj"));
          
        /*  AR_SIFRA=new TableColumn ("sifra");
          AR_SIFRA.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,String>("sifra"));
         */ 
          AR_NAZIV=new TableColumn ("naziv artikla");
          AR_NAZIV.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazVred,String>("naziv")); 
          
          tblARTIKLI.getColumns().setAll(AR_ARTIKAL,AR_NAZIV);
          tblARTIKLI.setItems(AR_data);
         // System.out.println(results.get(0).getArtikal().toString());
     
       
       
          
       
       
       }
       else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PAŽNJA!");
            alert.setHeaderText("Greška!");
            alert.setContentText("Proverite da li ste selektovali sve potrebne podatke !");
            alert.showAndWait();  
       }
     
     }
       
     
     public void listaSvihRadnji() {
         em.clear();
         List<BVMpAkcNazVred>  results = em.createNativeQuery("select distinct to_number(orgjed) as broj,oj.naziv from rouser.b_mpo_indikatori a, iis.orgjed oj\n" +
            "where datum<sysdate-4\n" +
            "and oj.sifra=a.orgjed\n" +
            "and orgjed<>135\n" +
            "order by 2", BVMpAkcNazVred.class)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList(); 
         
         MPO_data = FXCollections.observableArrayList(results);
          
           
          MPO_MPO=new TableColumn ("orgjed");
          MPO_MPO.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazVred,Long>("broj"));
          
        /*  AR_SIFRA=new TableColumn ("sifra");
          AR_SIFRA.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,String>("sifra"));
         */ 
          MPO_NAZIV=new TableColumn ("naziv mpo");
          MPO_NAZIV.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazVred,String>("naziv")); 
          
          tblListaSvihMPO.getColumns().setAll(MPO_MPO,MPO_NAZIV);
          tblListaSvihMPO.setItems(MPO_data);
        /*
               //kolone za tabelu lista svih objekata
    @FXML     TableColumn<BVMpAkcNazVred,Long> MPO_MPO;
    @FXML     TableColumn<BVMpAkcNazVred,String> MPO_NAZIV;
  tblListaSvihMPO
         */ 
         
     }
     
     @FXML
     public void listaOJ(BigInteger art) {
         
        
      //   lblRad.setText("Ucitavanje u toku.....");
         em.clear();
        
    
      
        Integer i=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();  
         List<BVMpAkcNazivVredX7>  results =   em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n" +
"from table(\n" +
"bojanivetic.b_mp_akc_izvestaji_po_oj\n" +
" ("+i+",\n" +
 art+"))", BVMpAkcNazivVredX7.class)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList(); 
        
        
  
          OJ_data = FXCollections.observableArrayList(results);
          
          
           
          OJ_NAZIV=new TableColumn ("OJ");
          OJ_NAZIV.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,String>("naziv"));
          OJ_NAZIV.setPrefWidth(160);
          
          OJ_VRED1=new TableColumn ("Preporučena uk");
          OJ_VRED1.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred1"));
          OJ_VRED1.setPrefWidth(140);
          
          OJ_VRED2=new TableColumn ("Ostvarenje prepor %");
          OJ_VRED2.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred2"));
          OJ_VRED2.setPrefWidth(160);
          
          OJ_VRED3=new TableColumn ("prodaja");
          OJ_VRED3.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred3"));
          OJ_VRED3.setPrefWidth(80);
          
          OJ_VRED4=new TableColumn ("Zaliha kraj");
          OJ_VRED4.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred4"));
          OJ_VRED4.setPrefWidth(110);
          
          OJ_VRED5=new TableColumn ("br dana OOS");
          OJ_VRED5.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred5"));
          OJ_VRED5.setPrefWidth(120);
          
          OJ_VRED6=new TableColumn ("KO");
          OJ_VRED6.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred6"));
          OJ_VRED6.setPrefWidth(120);
    
          tblPoOJ.getColumns().setAll(OJ_NAZIV,OJ_VRED3,OJ_VRED1,OJ_VRED2,OJ_VRED4,OJ_VRED5,OJ_VRED6);
     
          tblPoOJ.setItems(OJ_data);
          
         sumarniPodaci2();
        /*lblRad.setText(listaRadnji.getSelectionModel().getSelectedItem());*/
     }
      public void sumarniPodaci2() {
         this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
        em.clear(); 

      /*  String w="1";
        String s="select trim(naziv) as naziv,vred1,vred2,vred3,vred4,vred5,vred6,vred7\n" +
                    "from table(\n" +
                    "bojanivetic.b_mp_akc_izv_ko\n" +
                    " ("+JavaFXTemplate.param_id+",\n" +
                    " -1"+ " ,\n" +
                    "" +JavaFXTemplate.param_OJ+ " ,"+w+"))";
        System.out.println(s);
       // lbl.setText(s);
         List<BVMpAkcNazivVredX7>  results;
         results= em.createNativeQuery(s, BVMpAkcNazivVredX7.class)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false") //ovo ide zbog osvezavanja gde createNativeQuery pravi problem
                 .getResultList();*/
        
         Integer i=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();  
         List<BVMpAkcNazivVredX7>  results =   em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n" +
"from table(\n" +
"bojanivetic.b_mp_akc_izvestaji_po_oj_sumar\n" +
" ("+i+",\n" +
 AR_data.get(tblARTIKLI.getSelectionModel().getSelectedIndex()).getBroj()+"))", BVMpAkcNazivVredX7.class)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList(); 
         
         
         /*
         @FXML Label lbl2Prepor;
     @FXML Label lbl2Ostvar;
     @FXML Label lbl2Zaliha;
     @FXML Label lbl2Ko;
     @FXML Label lbl2Prodaja;
     @FXML Label lbl2Nule;
         */
         
         lbl2Prepor.setTextAlignment(TextAlignment.RIGHT);
         lbl2Ostvar.setTextAlignment(TextAlignment.RIGHT);
         lbl2Zaliha.setTextAlignment(TextAlignment.RIGHT);
         lbl2Ko.setTextAlignment(TextAlignment.RIGHT);
         lbl2Prodaja.setTextAlignment(TextAlignment.RIGHT);
         lbl2Nule.setTextAlignment(TextAlignment.RIGHT);
         
       //  lbl2Prepor.setTextFill(Color.BLUE.getBlue());
         
         lbl2Prepor.setText(results.get(0).getVred1().toString());
         lbl2Ostvar.setText(results.get(0).getVred2().toString());
         lbl2Zaliha.setText(results.get(0).getVred4().toString());
         lbl2Ko.setText(results.get(0).getVred6().toString());
         lbl2Prodaja.setText(results.get(0).getVred3().toString());
         lbl2Nule.setText(results.get(0).getVred5().toString());
     }
      
      
     @FXML
     public void pozoviIzvGrupisano() {
         
         if ((tabela.getSelectionModel().getSelectedIndex()>-1)  )
       {
         
         
         em.clear();
          
           Integer i=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();  
         List<BVMpAkcNazivVredX15>  results =   em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,"
                 + "vred5,vred6,vred7,vred8,vred9,vred10,vred11,vred12,vred13,vred14,vred15\n" +
"from table(\n" +
"bojanivetic.b_mp_akc_grupisano\n" +
" ("+i+",'" + GR_cmb_tip_izv.getValue().toString()/* "PO_ARTIKLU"*/+      "'))", BVMpAkcNazivVredX15.class)
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
          
           GR_VRED10=new TableColumn ("Zal VP ZR");
          GR_VRED10.setCellValueFactory(new PropertyValueFactory<>("vred10"));
          GR_VRED10.setPrefWidth(100);
          
           GR_VRED11=new TableColumn ("Zal VP ŠAB");
          GR_VRED11.setCellValueFactory(new PropertyValueFactory<>("vred11"));
          GR_VRED11.setPrefWidth(100);
          
           GR_VRED12=new TableColumn ("Zal RDC");
          GR_VRED12.setCellValueFactory(new PropertyValueFactory<>("vred12"));
          GR_VRED12.setPrefWidth(100);
    
          
           GR_VRED13=new TableColumn ("Nule juce");
          GR_VRED13.setCellValueFactory(new PropertyValueFactory<>("vred13"));
          GR_VRED13.setPrefWidth(70);
          
          if (GR_cmb_tip_izv.getValue().toString().equals("PO_ARTIKLU"))
          {
          tblGrupisano.getColumns().setAll(GR_NAZIV,GR_VRED1,GR_VRED2,GR_VRED3,GR_VRED4,GR_VRED5,GR_VRED6,GR_VRED13,GR_VRED7,GR_VRED8,GR_VRED9,GR_VRED10,GR_VRED11,GR_VRED12);
          }
          
          
          if (GR_cmb_tip_izv.getValue().toString().equals("PO_MPO"))
          {
            //  GR_VRED4.setText("Br artikala");
          tblGrupisano.getColumns().setAll(GR_NAZIV,GR_VRED1,GR_VRED2,/*GR_VRED3,GR_VRED4,*/GR_VRED5,GR_VRED6,GR_VRED7,GR_VRED8);
           GR_VRED8.setText("nule zadnji dan");
          }
          
          if (GR_cmb_tip_izv.getValue().toString().equals("PO_MAGACINU_VP"))
          {
            //  GR_VRED4.setText("Br artikala");
          tblGrupisano.getColumns().setAll(GR_NAZIV,GR_VRED1,GR_VRED2,/*GR_VRED3,GR_VRED4,*/GR_VRED5,GR_VRED6,GR_VRED7/*,GR_VRED8*/);
          }
           
          if (GR_cmb_tip_izv.getValue().toString().equals("PO_ROBNOJ_GRUPI"))
          {
               GR_VRED4.setText("Br artikala"); 
               GR_VRED8.setText("% uk prometa"); 
              tblGrupisano.getColumns().setAll(GR_NAZIV,GR_VRED1,GR_VRED2,/*GR_VRED3,*/GR_VRED4,GR_VRED5,GR_VRED6,GR_VRED7,GR_VRED8);
          }
          
          tblGrupisano.setItems(GR_data);
       }  
          else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PAŽNJA!");
            alert.setHeaderText("Greška!");
            alert.setContentText("Proverite da li ste selektovali sve potrebne podatke !");
            alert.showAndWait();  
       }
  
          
     }
     
     @FXML
     public void izGrupnogTabaUAnalitiku () 
     {
         /*DT_P_naziv_artikla*/
          String filename = GR_data.get(tblGrupisano.getSelectionModel().getSelectedIndex()).getNaziv();
          String[] parts = filename.split("\\#");  
          
          DT_P_naziv_artikla.setText(parts[0]);
          listaArtikala();
          SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
          selectionModel.select(tabArtikal);
          //tblARTIKLI.getSelectionModel().selectFirst();
          tblARTIKLI.getSelectionModel().select(0);
          
          /*
          SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
         selectionModel.select(tabAnalitika);
          
              @FXML TabPane tabPane;
     @FXML Tab tabArtikal;
     @FXML Tab tabOJ;
     @FXML Tab tabGrupisano;
          */
         
     }
     
     public void prikaziZbirnePokazatelje() {
         /*
             @FXML Label lblProcOOSUK_A;
     @FXML Label lblZalihaUK_A;
     @FXML Label lblKoUK_A;
     @FXML Label lbl1ProdajaUK_A;
     
     @FXML Label lblProcOOSUK_R;
     @FXML Label lblZalihaUK_R;
     @FXML Label lblKoUK_R;
     @FXML Label lbl1ProdajaUK_R;
         */
         
         //inicijalizuj vrednosti labela
            lblZalihaUK_A.setText("-");
            lblZalihaUK_R.setText("-");
             
            lblProcOOSUK_A.setText("-");
            lblProcOOSUK_R.setText("-");

            lblKoUK_A.setText("-");
            lblKoUK_R.setText("-");

            lbl1ProdajaUK_A.setText("-");
            lbl1ProdajaUK_R.setText("-");
         //kraj inicijalizacije vrednosti labela
         
         em.clear();

         Integer i = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
         List<BVMpAkcNazivVredX7> results = em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n"
                 + "from table(\n"
                 + "bojanivetic.b_mp_akc_izv_sumarno2\n"
                 + " (" + i + "))", BVMpAkcNazivVredX7.class)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList();

         UK_data = FXCollections.observableArrayList(results);
      
         int size=results.size();
         
         /*
         double amount = Double.parseDouble(number);
DecimalFormat formatter = new DecimalFormat("#,###.00");

System.out.println(formatter.format(amount));
         */
         
         if (size>1)
         {
             lblZalihaUK_A.setText(results.get(0).getVred2().toString());
             lblZalihaUK_R.setText(results.get(1).getVred2().toString());
             
             lblProcOOSUK_A.setText(results.get(0).getVred6().toString());
             lblProcOOSUK_R.setText(results.get(1).getVred6().toString());
             
             lblKoUK_A.setText(results.get(0).getVred3().toString());
             lblKoUK_R.setText(results.get(1).getVred3().toString());
             
             lbl1ProdajaUK_A.setText(results.get(0).getVred1().toString());
             lbl1ProdajaUK_R.setText(results.get(1).getVred1().toString());
         }
         
         
     }
     
     @FXML
     public void napuniDijagrame()
     {
         
         
         
      if ((tabela.getSelectionModel().getSelectedIndex()>-1)  )
       {

                
                  em.clear();

         Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
                List<BVMpAkcNazivVredX7> results = em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n"
                        + "from table(\n"
                        + "bojanivetic.b_mp_akc_izv_ko_trend\n"
                        + " (" + ii + "))", BVMpAkcNazivVredX7.class)
                        .setHint(QueryHints.MAINTAIN_CACHE, "false")
                        .getResultList();

                UK_data = FXCollections.observableArrayList(results);

                  /*
                System.out.println("==> For Loop Example.");
                       for (int i = 0; i < crunchifyList.size(); i++) {
                               System.out.println(crunchifyList.get(i));
                */


                LineChart1.getData().clear();
                XYChart.Series<String,Number> series = new XYChart.Series<String, Number>();
                XYChart.Series<String,Number> series2 = new XYChart.Series<String, Number>();

                for (int i = 0; i < results.size(); i++)
                {
                               //System.out.println(results.get(i).getNaziv());
                               series.getData().add(new XYChart.Data<String, Number>(results.get(i).getNaziv(),results.get(i).getVred1()));
                               series2.getData().add(new XYChart.Data<String, Number>(results.get(i).getNaziv(),results.get(i).getVred2()));

                }
    
                
                series.setName("Automatika");
                series2.setName("Rucno");
                LineChart1.getData().add(series);
                LineChart1.getData().add(series2);
                
 //////////// DRUGI DIJAGRAM-----------------------------------------               
              //sada drui chart za trendove OOS
                  em.clear();

         //Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
                List<BVMpAkcNazivVredX7> resultsOOS = em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n"
                        + "from table(\n"
                        + "bojanivetic.b_mp_akc_izv_oos_trend\n"
                        + " (" + ii + "))", BVMpAkcNazivVredX7.class)
                        .setHint(QueryHints.MAINTAIN_CACHE, "false")
                        .getResultList();

                UK_data = FXCollections.observableArrayList(resultsOOS);

                  /*
                System.out.println("==> For Loop Example.");
                       for (int i = 0; i < crunchifyList.size(); i++) {
                               System.out.println(crunchifyList.get(i));
                */


                LineChart2.getData().clear();
                XYChart.Series<String,Number> seriesOOS = new XYChart.Series<String, Number>();
                XYChart.Series<String,Number> series2OOS = new XYChart.Series<String, Number>();

                for (int i = 0; i < results.size(); i++)
                {
                               //System.out.println(results.get(i).getNaziv());
                               seriesOOS.getData().add(new XYChart.Data<String, Number>(results.get(i).getNaziv(),resultsOOS.get(i).getVred1()));
                               series2OOS.getData().add(new XYChart.Data<String, Number>(results.get(i).getNaziv(),resultsOOS.get(i).getVred2()));

                }
    
                
                seriesOOS.setName("Automatika");
                series2OOS.setName("Rucno");
                LineChart2.getData().add(seriesOOS);
                LineChart2.getData().add(series2OOS);
                
                
      /////////  treci dijagram -  pie  -najgori artikli po OOS
                 //   em.clear();

         //Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
              List<BVMpAkcNazivVredX7> resultsUcesceNula = em.createNativeQuery("select trim(substr(naziv,1,20)) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n"
                        + "from table(\n"
                        + "bojanivetic.b_mp_akc_nule_top5\n"
                        + " (" + ii + "))", BVMpAkcNazivVredX7.class)
                        .setHint(QueryHints.MAINTAIN_CACHE, "false")
                        .getResultList();

                UK_data = FXCollections.observableArrayList(resultsUcesceNula);
                PieChart1.getData().clear();
                
               
                
                
                 ObservableList<PieChart.Data> pieChartData = 
                FXCollections.observableArrayList(
                    new PieChart.Data("", 0));
                
                         
                 String str; Number num;double d;
                 
                for (int i = 0; i < resultsUcesceNula.size(); i++)
                {
                               str=resultsUcesceNula.get(i).getNaziv();
                               num=resultsUcesceNula.get(i).getVred1();
                                d = resultsUcesceNula.get(i).getVred1().doubleValue();
                               pieChartData.add( new PieChart.Data(str, d));
                }    
         
        PieChart1.setTitle("Ucesce artikala u OOS");
        PieChart1.setData(pieChartData);
                

///treci   line chart koji poredi poslednje 4 akcije
    
 
                  em.clear();

         //Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
                List<BVMpAkcNazivVredX7> resultsAK = em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n"
                        + "from table(\n"
                        + "bojanivetic.b_mp_akc_trend_ko_vise_akcija\n"
                        + " (" + ii + "))", BVMpAkcNazivVredX7.class)
                        .setHint(QueryHints.MAINTAIN_CACHE, "false")
                        .getResultList();

                UK_data = FXCollections.observableArrayList(resultsAK);

            


                LineChart3.getData().clear();
                XYChart.Series<String,Number> series1AK = new XYChart.Series<String, Number>();
                XYChart.Series<String,Number> series2AK = new XYChart.Series<String, Number>();
                XYChart.Series<String,Number> series3AK = new XYChart.Series<String, Number>();
              //  XYChart.Series<String,Number> series4AK = new XYChart.Series<String, Number>();
  
                for (int i = 0; i < results.size(); i++)
                {
                              
                               series1AK.getData().add(new XYChart.Data<String, Number>(results.get(i).getNaziv(),resultsAK.get(i).getVred1()));
                               series2AK.getData().add(new XYChart.Data<String, Number>(results.get(i).getNaziv(),resultsAK.get(i).getVred2()));
                               series3AK.getData().add(new XYChart.Data<String, Number>(results.get(i).getNaziv(),resultsAK.get(i).getVred3()));
                          //     series4AK.getData().add(new XYChart.Data<String, Number>(results.get(i).getNaziv(),resultsAK.get(i).getVred4()));

                }
    
                
                series1AK.setName("Akcija "+ii);
                
                int y=ii-1; series2AK.setName("Akcija "+y);
                    y=ii-2; series3AK.setName("Akcija "+y);
                  //  y=ii-3; series4AK.setName("Akcija "+y);
                
                 LineChart3.getData().add(series1AK);
       if (ii>2) LineChart3.getData().add(series2AK);
       if (ii>3) LineChart3.getData().add(series3AK);
    //   if (ii>4) LineChart3.getData().add(series4AK);
              
                

       //// drugi trend poredi poslednje 3 akcije kada je u pitanju oos
        
 
                  em.clear();

         //Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
                List<BVMpAkcNazivVredX7> resultsAKOOS = em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n"
                        + "from table(\n"
                        + "bojanivetic.b_mp_akc_trend_oos_vise_akcija\n"
                        + " (" + ii + "))", BVMpAkcNazivVredX7.class)
                        .setHint(QueryHints.MAINTAIN_CACHE, "false")
                        .getResultList();

                UK_data = FXCollections.observableArrayList(resultsAKOOS);

            


                LineChart4.getData().clear();
                XYChart.Series<String,Number> series1AKOOS = new XYChart.Series<String, Number>();
                XYChart.Series<String,Number> series2AKOOS = new XYChart.Series<String, Number>();
                XYChart.Series<String,Number> series3AKOOS = new XYChart.Series<String, Number>();
              //  XYChart.Series<String,Number> series4AK = new XYChart.Series<String, Number>();
  
                for (int i = 0; i < results.size(); i++)
                {
                              
                               series1AKOOS.getData().add(new XYChart.Data<String, Number>(results.get(i).getNaziv(),resultsAKOOS.get(i).getVred1()));
                               series2AKOOS.getData().add(new XYChart.Data<String, Number>(results.get(i).getNaziv(),resultsAKOOS.get(i).getVred2()));
                               series3AKOOS.getData().add(new XYChart.Data<String, Number>(results.get(i).getNaziv(),resultsAKOOS.get(i).getVred3()));
                          //     series4AK.getData().add(new XYChart.Data<String, Number>(results.get(i).getNaziv(),resultsAK.get(i).getVred4()));

                }
    
                
                series1AKOOS.setName("Akcija "+ii);
                
                int yy=ii-1; series2AKOOS.setName("Akcija "+yy);
                    yy=ii-2; series3AKOOS.setName("Akcija "+yy);
                  //  y=ii-3; series4AK.setName("Akcija "+y);
                
                 LineChart4.getData().add(series1AKOOS);
       if (ii>2) LineChart4.getData().add(series2AKOOS);
       if (ii>3) LineChart4.getData().add(series3AKOOS);
    //   if (ii>4) LineChart3.getData().add(series4AK);
              
       
                
            }
    
        else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PAŽNJA!");
            alert.setHeaderText("Greška!");
            alert.setContentText("Proverite da li ste selektovali sve potrebne podatke !");
            alert.showAndWait();  
       }
     
     }
     
 
     
     public void vratiUdeoAkcije() {
        int i =data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
        
             List<BVMpAkcNazivVredX7>  results =   em.createNativeQuery("select b_mp_akc_vrati_progress_akcije\n" +
"  ("+  i+") as vred1,1 as vred7\n" +
"from dual", BVMpAkcNazivVredX7.class)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList(); 
             
             System.out.println(results.get(0).getVred1().toString());
      pi.setProgress(results.get(0).getVred1().doubleValue());
     }
     
     @FXML
     public void vratiTrendKOPoMPO() { 
         /*
              @FXML LineChart LineChartKOpoOJTrend;
     @FXML LineChart LineChartOOSpoOJ;
          Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
         
         */
       /*   String v_oj = MPO_data.get(tblListaSvihMPO.getSelectionModel().getSelectedIndex()).getNaziv();
          System.out.println(v_oj);
         */
      if(tabela.getSelectionModel().getSelectedItem() != null) 
            {
                em.clear();
                String v_oj = MPO_data.get(tblListaSvihMPO.getSelectionModel().getSelectedIndex()).getBroj().toString();
                Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
         //Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
                List<BVMpAkcNazivVredX7> resultsAK = em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n"
                        + "from table(\n"
                        + "bojanivetic.b_mp_akc_ko_vise_akcija_po_oj\n"
                        + " (" + ii + ","+v_oj+"))", BVMpAkcNazivVredX7.class)
                        .setHint(QueryHints.MAINTAIN_CACHE, "false")
                        .getResultList();

                UK_data = FXCollections.observableArrayList(resultsAK);

            


                LineChartKOpoOJTrend.getData().clear();
                XYChart.Series<String,Number> series1AK = new XYChart.Series<String, Number>();
                XYChart.Series<String,Number> series2AK = new XYChart.Series<String, Number>();
                XYChart.Series<String,Number> series3AK = new XYChart.Series<String, Number>();
              //  XYChart.Series<String,Number> series4AK = new XYChart.Series<String, Number>();
  
                for (int i = 0; i < resultsAK.size(); i++)
                {
                              
                               series1AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred1()));
                               series2AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred2()));
                               series3AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred3()));
                          //     series4AK.getData().add(new XYChart.Data<String, Number>(results.get(i).getNaziv(),resultsAK.get(i).getVred4()));

                }
    
                
                series1AK.setName("Akcija "+ii);
                
                int y=ii-1; series2AK.setName("Akcija "+y);
                    y=ii-2; series3AK.setName("Akcija "+y);
                  //  y=ii-3; series4AK.setName("Akcija "+y);
                
                 LineChartKOpoOJTrend.getData().add(series1AK);
       if (ii>2) LineChartKOpoOJTrend.getData().add(series2AK);
       if (ii>3) LineChartKOpoOJTrend.getData().add(series3AK);
                
                
            
            }
         
         
     }
     
     
       public void vratiTrendOOSPoMPO() {
         /*
              @FXML LineChart LineChartKOpoOJTrend;
     @FXML LineChart LineChartOOSpoOJ;
          Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
         
         */
       /*   String v_oj = MPO_data.get(tblListaSvihMPO.getSelectionModel().getSelectedIndex()).getNaziv();
          System.out.println(v_oj);
         */
      if(tabela.getSelectionModel().getSelectedItem() != null) 
            {
                em.clear();
                String v_oj = MPO_data.get(tblListaSvihMPO.getSelectionModel().getSelectedIndex()).getBroj().toString();
                Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
         //Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
                List<BVMpAkcNazivVredX7> resultsAK = em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n"
                        + "from table(\n"
                        + "bojanivetic.b_mp_akc_trend_oos_vise_akc_oj\n"
                        + " (" + ii + ","+v_oj+"))", BVMpAkcNazivVredX7.class)
                        .setHint(QueryHints.MAINTAIN_CACHE, "false")
                        .getResultList();

                UK_data = FXCollections.observableArrayList(resultsAK);

            


                LineChartOOSpoOJ.getData().clear();
                XYChart.Series<String,Number> series1AK = new XYChart.Series<String, Number>();
                XYChart.Series<String,Number> series2AK = new XYChart.Series<String, Number>();
                XYChart.Series<String,Number> series3AK = new XYChart.Series<String, Number>();
              //  XYChart.Series<String,Number> series4AK = new XYChart.Series<String, Number>();
  
                for (int i = 0; i < resultsAK.size(); i++)
                {
                              
                               series1AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred1()));
                               series2AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred2()));
                               series3AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred3()));
                          //     series4AK.getData().add(new XYChart.Data<String, Number>(results.get(i).getNaziv(),resultsAK.get(i).getVred4()));

                }
    
                
                series1AK.setName("Akcija "+ii);
                
                int y=ii-1; series2AK.setName("Akcija "+y);
                    y=ii-2; series3AK.setName("Akcija "+y);
                  //  y=ii-3; series4AK.setName("Akcija "+y);
                
                 LineChartOOSpoOJ.getData().add(series1AK);
       if (ii>2) LineChartOOSpoOJ.getData().add(series2AK);
       if (ii>3) LineChartOOSpoOJ.getData().add(series3AK);
                
                
                
            }
         
         
     }
       
        public void vratiOdnosProdajeiZaliha() {
         /*
              @FXML LineChart LineChartKOpoOJTrend;
     @FXML LineChart LineChartOOSpoOJ;
          Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
         
         */
       /*   String v_oj = MPO_data.get(tblListaSvihMPO.getSelectionModel().getSelectedIndex()).getNaziv();
          System.out.println(v_oj);
         */
      if(tabela.getSelectionModel().getSelectedItem() != null) 
            {
                em.clear();
                String v_oj = MPO_data.get(tblListaSvihMPO.getSelectionModel().getSelectedIndex()).getBroj().toString();
                Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
         //Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
                List<BVMpAkcNazivVredX7> resultsAK = em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n"
                        + "from table(\n"
                        + "bojanivetic.b_mp_akc_trend_zal_i_prod_oj\n"
                        + " (" + ii + ","+v_oj+"))", BVMpAkcNazivVredX7.class)
                        .setHint(QueryHints.MAINTAIN_CACHE, "false")
                        .getResultList();

                UK_data = FXCollections.observableArrayList(resultsAK);

            


                lineChartProdajaZalihaOJ.getData().clear();
                XYChart.Series<String,Number> series1AK = new XYChart.Series<String, Number>();
                XYChart.Series<String,Number> series2AK = new XYChart.Series<String, Number>();
          
                for (int i = 0; i < resultsAK.size(); i++)
                {
                              
                               series1AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred1()));
                               series2AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred2()));
                      
                }
    
                
                series1AK.setName("Zalihe");
                
                 series2AK.setName("Prodaja");
                  //  y=ii-2; series3AK.setName("Akcija "+y);
                  //  y=ii-3; series4AK.setName("Akcija "+y);
                
                 lineChartProdajaZalihaOJ.getData().add(series1AK);
                 lineChartProdajaZalihaOJ.getData().add(series2AK);
     //  if (ii>3) LineChartOOSpoOJ.getData().add(series3AK);
                
                
                
            }
         
         
     }
        
   public void poredjenjeProdaje() {
       if(tabela.getSelectionModel().getSelectedItem() != null) 
            {
                em.clear();
                String v_oj = MPO_data.get(tblListaSvihMPO.getSelectionModel().getSelectedIndex()).getBroj().toString();
                Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
         //Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
                List<BVMpAkcNazivVredX7> resultsAK = em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n"
                        + "from table(\n"
                        + "bojanivetic.b_mp_akc_prodaja_stop_i_sve\n"
                        + " (" + ii + ","+v_oj+"))", BVMpAkcNazivVredX7.class)
                        .setHint(QueryHints.MAINTAIN_CACHE, "false")
                        .getResultList();

                UK_data = FXCollections.observableArrayList(resultsAK);
                
                BarChartPoredjenjeProdaje.getData().clear();
                
              /*   final NumberAxis xAxis = new NumberAxis();
                 final CategoryAxis yAxis = new CategoryAxis();
                 final BarChart<Number, String> bc = new BarChart<Number, String>(xAxis, yAxis);
                */ 
                 
                  XYChart.Series<String,Number> series1AK = new XYChart.Series<String, Number>();
                XYChart.Series<String,Number> series2AK = new XYChart.Series<String, Number>();
                
                    for (int i = 0; i < resultsAK.size(); i++)
                {
                              
                               series1AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred1()));
                               series2AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred2()));
                      
                }
                     series1AK.setName("Prodaja STOP");
                
                 series2AK.setName("Prodaja ukupna");
                 BarChartPoredjenjeProdaje.getData().add(series1AK);
                 BarChartPoredjenjeProdaje.getData().add(series2AK);   
                    
                    
                    
                
            }
   }
   
    public void vrednostiZaliha() {
       if(tabela.getSelectionModel().getSelectedItem() != null) 
            {
                em.clear();
                String v_oj = MPO_data.get(tblListaSvihMPO.getSelectionModel().getSelectedIndex()).getBroj().toString();
                Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
         //Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
                List<BVMpAkcNazivVredX7> resultsAK = em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n"
                        + "from table(\n"
                        + "bojanivetic.b_mp_akc_vrednost_lagera\n"
                        + " (" + ii + ","+v_oj+"))", BVMpAkcNazivVredX7.class)
                        .setHint(QueryHints.MAINTAIN_CACHE, "false")
                        .getResultList();

                UK_data = FXCollections.observableArrayList(resultsAK);
                
                BarChartVrednostiZaliha.getData().clear();
                
              /*   final NumberAxis xAxis = new NumberAxis();
                 final CategoryAxis yAxis = new CategoryAxis();
                 final BarChart<Number, String> bc = new BarChart<Number, String>(xAxis, yAxis);
                */ 
                 
                  XYChart.Series<String,Number> series1AK = new XYChart.Series<String, Number>();
              //  XYChart.Series<String,Number> series2AK = new XYChart.Series<String, Number>();
                
                    for (int i = 0; i < resultsAK.size(); i++)
                {
                              
                               series1AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred1()));
                             //  series2AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred2()));
                      
                }
                     series1AK.setName("Vrednosti lagera");
                
               //  series2AK.setName("Prodaja ukupna");
                 BarChartVrednostiZaliha.getData().add(series1AK);
              //  BarChartVrednostiZaliha.getData().add(series2AK);   
                    
                    
                    
                
            }
   }
   
   @FXML
   public void refreshGrafikaPoOJ() {
       
       if ((tabela.getSelectionModel().getSelectedIndex()>-1) &&(tblListaSvihMPO.getSelectionModel().getSelectedIndex()>-1))
       {
       
       vratiTrendKOPoMPO();
           vratiTrendOOSPoMPO();
           vratiOdnosProdajeiZaliha();
           poredjenjeProdaje();
           vrednostiZaliha();
   
       }
   else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PAŽNJA!");
            alert.setHeaderText("Greška!");
            alert.setContentText("Proverite da li ste selektovali sve potrebne podatke !");
            alert.showAndWait();  
       }
   
   
   
   }
   
   
       @FXML
     public void listaIzvestaj3Korigovan() {
        
      //   lblRad.setText("Ucitavanje u toku.....");
        
      
      
        if ((tabela.getSelectionModel().getSelectedIndex()>-1)  )
       {
      
        em.clear();
        
    
        
        String v_id_artikla=PK_P_id_artikla.getText();
        if ( !"".equals( v_id_artikla) ) {  
          } else {
            v_id_artikla="-1";
          }
        
        String v_sifra_artikla=PK_P_sifra.getText();
        if ( !"".equals( v_sifra_artikla) ) {  
          } else {
            v_sifra_artikla="-1";
          }
        
        String v_naziv_artikla=PK_P_naziv_artikla.getText();
        if ( !"".equals( v_naziv_artikla) ) {  
            v_naziv_artikla=v_naziv_artikla.toUpperCase();
          } else {
            v_naziv_artikla="-1";
          }
        
        Integer i=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();  
         List<BVMpAkcNazivVredX11>  results =   em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7,vred8,vred9,vred10,vred11\n" +
"from table(\n" +
"bojanivetic.b_mp_akc_izvestaji3_prosiren\n" +
" ("+i+",\n" +
v_id_artikla+",\n" +
v_sifra_artikla+",\n" +
"'"+v_naziv_artikla+"'"+",\n" +
//" 1,\n" +
lblOJ.getText()+ ",'1'))", BVMpAkcNazivVredX11.class)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList(); 
        
        //PK_VRED11_KORIG
  
          PK_data_korigovan = FXCollections.observableArrayList(results);
          
          
           
          PK_NAZIV_KORIG=new TableColumn ("PK_NAZIV");
          PK_NAZIV_KORIG.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX11,String>("naziv"));
          PK_NAZIV_KORIG.setPrefWidth(290);
          
          PK_VRED1_KORIG=new TableColumn ("ZALIHA PS");
          PK_VRED1_KORIG.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX11,BigDecimal>("vred1"));
          PK_VRED1_KORIG.setPrefWidth(90);
          
          PK_VRED2_KORIG=new TableColumn ("PRIJEM");
          PK_VRED2_KORIG.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX11,BigDecimal>("vred2"));
          PK_VRED2_KORIG.setPrefWidth(80);
          
          PK_VRED3_KORIG=new TableColumn ("PRODAJA");
          PK_VRED3_KORIG.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX11,BigDecimal>("vred3"));
          PK_VRED3_KORIG.setPrefWidth(90);
          
          PK_VRED4_KORIG=new TableColumn ("ZALIHA KRAJ");
          PK_VRED4_KORIG.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX11,BigDecimal>("vred4"));
          PK_VRED4_KORIG.setPrefWidth(100);
          
          PK_VRED5_KORIG=new TableColumn ("BR DANA OOS");
          PK_VRED5_KORIG.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX11,BigDecimal>("vred5"));
          PK_VRED5_KORIG.setPrefWidth(120);
          
          PK_VRED6_KORIG=new TableColumn ("KO");
          PK_VRED6_KORIG.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX11,BigDecimal>("vred6"));
          PK_VRED6_KORIG.setPrefWidth(75);
    
          PK_VRED7_KORIG=new TableColumn ("ZALIHA vred");
          PK_VRED7_KORIG.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX11,BigDecimal>("vred7"));
          PK_VRED7_KORIG.setPrefWidth(120);
          
          PK_VRED8_KORIG=new TableColumn ("PRODAJA vred");
          PK_VRED8_KORIG.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX11,BigDecimal>("vred8"));
          PK_VRED8_KORIG.setPrefWidth(120);
          
          PK_VRED9_KORIG=new TableColumn ("PREPORUKA");
          PK_VRED9_KORIG.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX11,BigDecimal>("vred9"));
          PK_VRED9_KORIG.setPrefWidth(120);
          
          PK_VRED10_KORIG=new TableColumn ("Ostvarenje prepor");
          PK_VRED10_KORIG.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX11,BigDecimal>("vred10"));
          PK_VRED10_KORIG.setPrefWidth(120);
          
          tblPreporKol.getColumns().setAll(PK_NAZIV_KORIG,PK_VRED1_KORIG,PK_VRED2_KORIG,
                  PK_VRED3_KORIG,PK_VRED4_KORIG,PK_VRED5_KORIG,PK_VRED6_KORIG,
                  PK_VRED7_KORIG,PK_VRED8_KORIG,PK_VRED9_KORIG,PK_VRED10_KORIG);
     
          tblPreporKol.setItems(PK_data_korigovan);
          
         sumarniPodaci();
        lblRad.setText(listaRadnji.getSelectionModel().getSelectedItem());
          
    }
      else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PAŽNJA!");
            alert.setHeaderText("Greška!");
            alert.setContentText("Proverite da li ste selektovali sve potrebne podatke !");
            alert.showAndWait();  
       }
     
     }
     
     
     public void popuniInicijalnoListe() {
         
          em.clear();
          List<String>  results =  em.createNamedQuery("BMpAkcIzvestaji.napuniListu")
                   .getResultList();
 
          ObservableList<String> items =FXCollections.observableArrayList (results);
          listaRadnji.setItems(items);
         
         
         //pumjenje lidte app
    /*     List<String> listaApp = new ArrayList<String>();
        listaApp.add("APSOLUTNA VREDNOST PROMETA");
        listaApp.add("TRENDOVI KOEFICIJENTA OBRTA");
        listaApp.add("VREDNOST LAGERA PRE I POSLE AKCIJE");
     
        ObservableList obList = FXCollections.observableList(listaApp);*/
        ObservableList obList = FXCollections.observableList(results); 
        listaIzvestaja.getItems().clear();
        listaIzvestaja.setItems(obList);
        
        //punjenje liste tipa artikala
        
        List<String> listaTipArtikla = new ArrayList<String>();
        listaTipArtikla.add("SVI ARTIKLI");
        listaTipArtikla.add("SAMO IN/OUT ARTIKLI");
        listaTipArtikla.add("BEZ IN/OUT ARTIKALA");
        
     
        ObservableList obList2 = FXCollections.observableList(listaTipArtikla);
         
        IZV_cmb_tip_artikla.getItems().clear();
        IZV_cmb_tip_artikla.setItems(obList2);
        IZV_cmb_tip_artikla.getSelectionModel().select(0);
        
        // punjenje liste prehrana/neprehrana
        List<String> listaPrehrana = new ArrayList<String>();
        listaPrehrana.add("SVI ARTIKLI");
        listaPrehrana.add("PREHRANA");
        listaPrehrana.add("NEPREHRANA");
        
     
        ObservableList obList3 = FXCollections.observableList(listaPrehrana);
         
        IZV_cmb_prehrana_nepreh.getItems().clear();
        IZV_cmb_prehrana_nepreh.setItems(obList3);
        IZV_cmb_prehrana_nepreh.getSelectionModel().select(0);
        
        
         List<String> listaRazvoz = new ArrayList<String>();
        listaRazvoz.add("SVI RAZVOZI");
        listaRazvoz.add("RAZVOZ 1");
        listaRazvoz.add("RAZVOZ 2");
        listaRazvoz.add("RAZVOZ 3");
     
        ObservableList obListR = FXCollections.observableList(listaRazvoz);
         
        IZV_cmb_razvoz.getItems().clear();
        IZV_cmb_razvoz.setItems(obListR);
        IZV_cmb_razvoz.getSelectionModel().select(0);
        
        
        
        //popuni combo za vp magacin
        
        List<String> listaVPMagacini = new ArrayList<String>();
        listaVPMagacini.add("SVI VP MAGACINI");
        listaVPMagacini.add("DC MAGACINI");
        listaVPMagacini.add("RDC MAGACINI");
        
     
        ObservableList listaVP = FXCollections.observableList(listaVPMagacini);
         
        IZV_cmb_VP_magacin.getItems().clear();
        IZV_cmb_VP_magacin.setItems(listaVP);
        IZV_cmb_VP_magacin.getSelectionModel().select(0);
        
        
            //popuni combo za tip objekta
        
        List<String> listaTipObjekt = new ArrayList<String>();
        listaTipObjekt.add("SVI TIPOVI OBJEKATA");
        listaTipObjekt.add("A+");
        listaTipObjekt.add("A");
        listaTipObjekt.add("B");
        listaTipObjekt.add("C");
        listaTipObjekt.add("D");
        
     
        ObservableList listaTipObjekta = FXCollections.observableList(listaTipObjekt);
         
        IZV_cmb_tip_objekta.getItems().clear();
        IZV_cmb_tip_objekta.setItems(listaTipObjekta);
        IZV_cmb_tip_objekta.getSelectionModel().select(0);
        
        
        /*
        @FXML ComboBox IZV_cmb_VP_magacin;
   @FXML ComboBox IZV_cmb_tip_objekta;
        */
        
         BarChartIZV.setVisible(false);
         tblIZV.setVisible(false);
         LineChartIZV.setVisible(false);
  
     }
     
     
        public void listaSvihRadnji2() {
       em.clear();
          List<String>  results =  em.createNamedQuery("BVMpAkcSveRadnje.pozovisve")
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                  .getResultList();
       
        
       ObservableList obList3 = FXCollections.observableList(results);
         
        IZV_cmb_lista_objekata.getItems().clear();
        IZV_cmb_lista_objekata.setItems( obList3);
        IZV_cmb_lista_objekata.getSelectionModel().select(0);
        /*
               //kolone za tabelu lista svih objekata
    @FXML     TableColumn<BVMpAkcNazVred,Long> MPO_MPO;
    @FXML     TableColumn<BVMpAkcNazVred,String> MPO_NAZIV;
  tblListaSvihMPO
         
         */
     }
        
        
@FXML
public void popuniNacinPrikaza() {
    System.out.println(IZV_cmb_tip_artikla.getValue().toString());
    
    
     em.clear();
          List<String>  results =  em.createNamedQuery("BVMpAkcIzvestajiStavke.popuniStavke")
                  .setParameter("nazivIzvestaja", listaIzvestaja.getSelectionModel().getSelectedItem().toString())
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                   .getResultList();
 
          ObservableList<String> items =FXCollections.observableArrayList (results);
          
  //        IZV_cmb_nacin_prikaza.getItems().clear();
  //      IZV_cmb_nacin_prikaza.setItems(items);
  //      IZV_cmb_nacin_prikaza.getSelectionModel().select(0);
        
                
                
        listaStavkiizvestaja.getItems().clear();
        listaStavkiizvestaja.setItems(items);
        listaStavkiizvestaja.getSelectionModel().select(0);
        
        
   
          /*
    if (listaIzvestaja.getSelectionModel().getSelectedItem().toString().equals("APSOLUTNA VREDNOST PROMETA"))
    {
        List<String> listaPrikaz = new ArrayList<String>();
        listaPrikaz.add("POSLEDNJE 3 AKCIJE");
        listaPrikaz.add("POSLEDNJIH 10 AKCIJA");
        listaPrikaz.add("PO RAZVOZU");
        listaPrikaz.add("PO TIPU OBJEKTA");
        listaPrikaz.add("PO DANIMA AKCIJE");
        //listaPrikaz.add("RAZVOZ 3");
     
        ObservableList obListR = FXCollections.observableList(listaPrikaz);
         
    //    IZV_cmb_nacin_prikaza.getItems().clear();
    //    IZV_cmb_nacin_prikaza.setItems(obListR);
     //   IZV_cmb_nacin_prikaza.getSelectionModel().select(0);
    
       
    }
    
    
    
    //IZVESTAJ2
      if (listaIzvestaja.getSelectionModel().getSelectedItem().toString().equals("TRENDOVI KOEFICIJENTA OBRTA"))
    {
        List<String> listaPrikaz = new ArrayList<String>();
        listaPrikaz.add("POSLEDNJE 3 AKCIJE");
        listaPrikaz.add("PO RAZVOZU");
        listaPrikaz.add("PREHRANA-NEPREHRANA");
        listaPrikaz.add("PO TIPU OBJEKTA");
       
     
     
        ObservableList obListR = FXCollections.observableList(listaPrikaz);
         
        IZV_cmb_nacin_prikaza.getItems().clear();
        IZV_cmb_nacin_prikaza.setItems(obListR);
        IZV_cmb_nacin_prikaza.getSelectionModel().select(0);
       
     
    }
    
    
    //IZVESTAJ 3
     if (listaIzvestaja.getSelectionModel().getSelectedItem().toString().equals("VREDNOST LAGERA PRE I POSLE AKCIJE"))
    {
        List<String> listaPrikaz = new ArrayList<String>();
        listaPrikaz.add("POSLEDNJE 3 AKCIJE");
        listaPrikaz.add("POSLEDNJIH 10 AKCIJA");
        listaPrikaz.add("PO RAZVOZU");
        listaPrikaz.add("PO TIPU OBJEKTA");
        listaPrikaz.add("PO DANIMA AKCIJE");
        //listaPrikaz.add("RAZVOZ 3");
     
        ObservableList obListR = FXCollections.observableList(listaPrikaz);
         
        IZV_cmb_nacin_prikaza.getItems().clear();
        IZV_cmb_nacin_prikaza.setItems(obListR);
        IZV_cmb_nacin_prikaza.getSelectionModel().select(0);
       
     
    }
  */  
    
}


@FXML
public void pozivIZVESTAJA()  {
    
    if ((tabela.getSelectionModel().getSelectedIndex()>-1)  )
       {
    //nadji sve iz stavki
     em.clear();
          List<BVMpAkcIzvestajiStavke>  results =  em.createNamedQuery("BVMpAkcIzvestajiStavke.nadjiStavku")
                  .setParameter("nazivIzvestaja", listaIzvestaja.getSelectionModel().getSelectedItem().toString())
                  .setParameter("nazivStavke", listaStavkiizvestaja.getSelectionModel().getSelectedItem().toString())
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                   .getResultList();
 
          ObservableList<BVMpAkcIzvestajiStavke> items =FXCollections.observableArrayList (results);
          
     //nadji naziiv procedure     
           em.clear();
          List<String>  results2 =  em.createNamedQuery("BMpAkcIzvestaji.vratiNazivProcedure")
                  .setParameter("nazivIzvestaja", listaIzvestaja.getSelectionModel().getSelectedItem().toString())
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                   .getResultList();
 
         String v_naziv_procedure=results2.get(0);
         
    
         
         
         if (results.get(0).getGrafik().equals("BAR"))  
     prikaziIZVBarGarfik(v_naziv_procedure,results.get(0).getBrojSerija(),results.get(0).getBrojKolona(),
             results.get(0).getSerija1(),results.get(0).getSerija2(),results.get(0).getSerija3(),
             results.get(0).getKolona4(),results.get(0).getKolona5(),results.get(0).getKolona6());
         
         if (results.get(0).getGrafik().equals("LINE"))  
     prikaziIZVLineGarfik(v_naziv_procedure,results.get(0).getBrojSerija(),results.get(0).getBrojKolona(),
             results.get(0).getSerija1(),results.get(0).getSerija2(),results.get(0).getSerija3(),
             results.get(0).getKolona4(),results.get(0).getKolona5(),results.get(0).getKolona6());
    //"BVMpAkcIzvestajiStavke.nadjiStavku"
    
    /*
     if (listaIzvestaja.getSelectionModel().getSelectedItem().toString().equals("APSOLUTNA VREDNOST PROMETA"))
    {
        prikaziIZVBarGarfik("b_mp_akc_bi_ucesce_stopa_u_uk",3,"Učesce u prometu","SER2","SER3");
    }
     
      if (listaIzvestaja.getSelectionModel().getSelectedItem().toString().equals("TRENDOVI KOEFICIJENTA OBRTA"))
    {
        prikaziIZVLineGarfik("b_mp_akc_bi_trendovi_ko",3,"Ova akcija","Prethodna","Pre 2 akcije");
    }
    */
}
    else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PAŽNJA!");
            alert.setHeaderText("Greška!");
            alert.setContentText("Proverite da li ste selektovali sve potrebne podatke !");
            alert.showAndWait();  
       }
}    


public void prikaziIZVBarGarfik(String ime_procedure, int broj_serija,int broj_kolona,String serija1, String serija2, String serija3, 
           String kolona4, String kolona5, String kolona6) {
             
        LineChartIZV.setVisible(false);
            em.clear();
           //     String v_oj = MPO_data.get(tblListaSvihMPO.getSelectionModel().getSelectedIndex()).getBroj().toString();
                Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
         //Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
                List<BVMpAkcNazivVredX7> resultsAK = em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n"
                        + "from table(\n"
                        + "bojanivetic."+ime_procedure+"\n"
                        + " (" + 
                        ii + ","+  //ID
                        "'"+ IZV_cmb_tip_artikla.getValue().toString() + "',"+  //tip artikla
                        "'"+ IZV_cmb_lista_odeljenja.getValue().toString() + "',"+  //odeljenje
                        "'"+ IZV_cmb_prehrana_nepreh.getValue().toString() + "',"+  //(ne)prehrana 
                       "'"+ IZV_cmb_lista_objekata.getValue().toString() + "',"+  //mpo 
                        "'"+ IZV_cmb_lista_algoritama.getValue().toString() + "',"+  //algoritam
                        "'"+ IZV_cmb_razvoz.getValue().toString() + "',"+  //razvoz
                        "'"+ IZV_cmb_tip_objekta.getValue().toString() + "',"+  //TIP OBJEKTA
                        "'"+ IZV_cmb_VP_magacin.getValue().toString() + "',"+  //VP
                       // "'"+ IZV_cmb_nacin_prikaza.getValue().toString() + "'"
                         "'"+ listaStavkiizvestaja.getSelectionModel().getSelectedItem().toString() + "'"
                        //"'POSLEDNJE 3 AKCIJE'"
                        +"))", BVMpAkcNazivVredX7.class)
                        .setHint(QueryHints.MAINTAIN_CACHE, "false")
                        .getResultList();

                UK_data = FXCollections.observableArrayList(resultsAK);
                
                //listaStavkiizvestaja.getSelectionModel().getSelectedItem().toString()
                  String v_sql="select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n"
                        + "from table(\n"
                        + "bojanivetic."+ime_procedure+"\n"
                        + " (" + 
                        ii + ","+  //ID
                        "'"+ IZV_cmb_tip_artikla.getValue().toString() + "',"+  //tip artikla
                        "'"+ IZV_cmb_lista_odeljenja.getValue().toString() + "',"+  //odeljenje
                        "'"+ IZV_cmb_prehrana_nepreh.getValue().toString() + "',"+  //(ne)prehrana 
                       "'"+ IZV_cmb_lista_objekata.getValue().toString() + "',"+  //mpo 
                        "'"+ IZV_cmb_lista_algoritama.getValue().toString() + "',"+  //algoritam
                        "'"+ IZV_cmb_razvoz.getValue().toString() + "',"+  //razvoz
                        "'"+ IZV_cmb_tip_objekta.getValue().toString() + "',"+  //TIP OBJEKTA
                        "'"+ IZV_cmb_VP_magacin.getValue().toString() + "',"+  //VP
                        // "'"+ IZV_cmb_nacin_prikaza.getValue().toString() + "'"
                        "'"+ listaStavkiizvestaja.getSelectionModel().getSelectedItem().toString() + "'"
                        //"'POSLEDNJE 3 AKCIJE'"
                        +"))";
                System.out.println(v_sql);
                
                
                
                BarChartIZV.getData().clear();
                
              /*   final NumberAxis xAxis = new NumberAxis();
                 final CategoryAxis yAxis = new CategoryAxis();
                 final BarChart<Number, String> bc = new BarChart<Number, String>(xAxis, yAxis);
                */ 
                 
                  XYChart.Series<String,Number> series1AK = new XYChart.Series<String, Number>();
                  XYChart.Series<String,Number> series2AK = new XYChart.Series<String, Number>();
                  XYChart.Series<String,Number> series3AK = new XYChart.Series<String, Number>();
                
                    for (int i = 0; i < resultsAK.size(); i++)
                {
                              
                               series1AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred1()));
                               series2AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred2()));
                               series3AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred3()));
                      
                }
                     series1AK.setName(serija1);
                
               //  series2AK.setName("Prodaja ukupna");
         if (broj_serija>=1)        BarChartIZV.getData().add(series1AK);
       
         if (broj_serija>=2) 
                 {
                     BarChartIZV.getData().add(series2AK);
                     series2AK.setName(serija2);
                 }         
         
         if (broj_serija==3)
                 {
                     BarChartIZV.getData().add(series3AK);
                     series3AK.setName(serija3);
                 }        
                 
            ///////////postavka tabele
                
          IZVESTAJI_data = FXCollections.observableArrayList(resultsAK);
          
           
          IZVESTAJI_naziv=new TableColumn ("Naziv");
          IZVESTAJI_naziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          IZVESTAJI_VRED1=new TableColumn (serija1);
          IZVESTAJI_VRED1.setCellValueFactory(new PropertyValueFactory<>("vred1"));
          //NA_ID_AKCIJE.setPrefWidth(90);
         // NA_ID_AKCIJE.setText("id akcije"); 
          
        
          IZVESTAJI_VRED2=new TableColumn (serija2);
          IZVESTAJI_VRED2.setCellValueFactory(new PropertyValueFactory<>("vred2"));
          
          IZVESTAJI_VRED3=new TableColumn (serija3);
          IZVESTAJI_VRED3.setCellValueFactory(new PropertyValueFactory<>("vred3"));
          
          IZVESTAJI_VRED4=new TableColumn (kolona4);
          IZVESTAJI_VRED4.setCellValueFactory(new PropertyValueFactory<>("vred4"));
          
          IZVESTAJI_VRED5=new TableColumn (kolona5);
          IZVESTAJI_VRED5.setCellValueFactory(new PropertyValueFactory<>("vred5"));
          
          IZVESTAJI_VRED6=new TableColumn (kolona6);
          IZVESTAJI_VRED6.setCellValueFactory(new PropertyValueFactory<>("vred6"));
      /*
            ObservableList<BVMpAkcNazivVredX7> IZVESTAJI_data;
    TableColumn<BVMpAkcRazvozPrvoPunj,String> IZVESTAJI_naziv;
    TableColumn<BVMpAkcRazvozPrvoPunj,BigDecimal> IZVESTAJI_VRED1;
    TableColumn<BVMpAkcRazvozPrvoPunj,BigDecimal> IZVESTAJI_VRED2;
    TableColumn<BVMpAkcRazvozPrvoPunj,BigDecimal> IZVESTAJI_VRED3;
          */
          
                             
          
          if (broj_kolona==1)  tblIZV.getColumns().setAll(IZVESTAJI_naziv,IZVESTAJI_VRED1);
          if (broj_kolona==2)  tblIZV.getColumns().setAll(IZVESTAJI_naziv,IZVESTAJI_VRED1,IZVESTAJI_VRED2);
          if (broj_kolona==3)  tblIZV.getColumns().setAll(IZVESTAJI_naziv,IZVESTAJI_VRED1,IZVESTAJI_VRED2,IZVESTAJI_VRED3);
          if (broj_kolona==4)  tblIZV.getColumns().setAll(IZVESTAJI_naziv,IZVESTAJI_VRED1,IZVESTAJI_VRED2,IZVESTAJI_VRED3,IZVESTAJI_VRED4);
          if (broj_kolona==5)  tblIZV.getColumns().setAll(IZVESTAJI_naziv,IZVESTAJI_VRED1,IZVESTAJI_VRED2,IZVESTAJI_VRED3,IZVESTAJI_VRED4,IZVESTAJI_VRED5);
          if (broj_kolona==6)  tblIZV.getColumns().setAll(IZVESTAJI_naziv,IZVESTAJI_VRED1,IZVESTAJI_VRED2,IZVESTAJI_VRED3,IZVESTAJI_VRED4,IZVESTAJI_VRED5,IZVESTAJI_VRED6);
     
          tblIZV.setItems(IZVESTAJI_data);
                 
                 
                 
             
                 
                 
                 
                 //postavka grafika i tabele
                 //ako su selektovana oba objekta
                 if ((checkGrafik.isSelected())  &&  (checkTabela.isSelected()) )
                 {
                     BarChartIZV.setVisible(true);
                     BarChartIZV.setPrefWidth(500);
                     tblIZV.setVisible(true);
                     tblIZV.setPrefWidth(500);
                     BarChartIZV.setLayoutX(340);
                     tblIZV.setLayoutX(900);
                     
                 }
                 else
                 {
                     //selektovan samo graph
                      if (checkGrafik.isSelected()) 
                      {
                         BarChartIZV.setVisible(true);
                         tblIZV.setVisible(false);
                         BarChartIZV.setLayoutX(340);
                         BarChartIZV.setPrefWidth(1000);
                      }
                      else //samo tabela
                      {
                         BarChartIZV.setVisible(false);
                         tblIZV.setVisible(true);
                         tblIZV.setPrefWidth(1000);
                         tblIZV.setLayoutX(340);
                      }
                 }
               
                 
                 //ne vide se oba
                  if ((!checkGrafik.isSelected())  &&  (!checkTabela.isSelected()) )
                 {
                     BarChartIZV.setVisible(false);
                     tblIZV.setVisible(false);
                    
                     
                 }
                 
                
                 
              //   if (checkTabela.isSelected()) tblIZV.setVisible(true);
              //   else tblIZV.setVisible(false);
              //  BarChartVrednostiZaliha.getData().add(series2AK);   
               
}



public void prikaziIZVLineGarfik(String ime_procedure, int broj_serija,int broj_kolona,String serija1, String serija2, String serija3,
         String kolona4, String kolona5, String kolona6) {
    
           BarChartIZV.setVisible(false);
              em.clear();
           //     String v_oj = MPO_data.get(tblListaSvihMPO.getSelectionModel().getSelectedIndex()).getBroj().toString();
                Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
         //Integer ii = data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
                List<BVMpAkcNazivVredX7> resultsAK = em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n"
                        + "from table(\n"
                        + "bojanivetic."+ime_procedure+"\n"
                        + " (" + 
                        ii + ","+  //ID
                        "'"+ IZV_cmb_tip_artikla.getValue().toString() + "',"+  //tip artikla
                        "'"+ IZV_cmb_lista_odeljenja.getValue().toString() + "',"+  //odeljenje
                        "'"+ IZV_cmb_prehrana_nepreh.getValue().toString() + "',"+  //(ne)prehrana 
                       "'"+ IZV_cmb_lista_objekata.getValue().toString() + "',"+  //mpo 
                        "'"+ IZV_cmb_lista_algoritama.getValue().toString() + "',"+  //algoritam
                        "'"+ IZV_cmb_razvoz.getValue().toString() + "',"+  //razvoz
                         "'"+ IZV_cmb_tip_objekta.getValue().toString() + "',"+  //TIP OBJEKTA
                        "'"+ IZV_cmb_VP_magacin.getValue().toString() + "',"+  //VP
                       // "'"+ IZV_cmb_nacin_prikaza.getValue().toString() + "'"
                         "'"+ listaStavkiizvestaja.getSelectionModel().getSelectedItem().toString() + "'"
                        //"'POSLEDNJE 3 AKCIJE'"
                        +"))", BVMpAkcNazivVredX7.class)
                        .setHint(QueryHints.MAINTAIN_CACHE, "false")
                        .getResultList();
                
                
                
               String v_sql="select trim(naziv) as naziv, vred1,vred2,vred3,vred4,vred5,vred6,vred7\n"
                        + "from table(\n"
                        + "bojanivetic."+ime_procedure+"\n"
                        + " (" + 
                        ii + ","+  //ID
                        "'"+ IZV_cmb_tip_artikla.getValue().toString() + "',"+  //tip artikla
                        "'"+ IZV_cmb_lista_odeljenja.getValue().toString() + "',"+  //odeljenje
                        "'"+ IZV_cmb_prehrana_nepreh.getValue().toString() + "',"+  //(ne)prehrana 
                       "'"+ IZV_cmb_lista_objekata.getValue().toString() + "',"+  //mpo 
                        "'"+ IZV_cmb_lista_algoritama.getValue().toString() + "',"+  //algoritam
                        "'"+ IZV_cmb_razvoz.getValue().toString() + "',"+  //razvoz
                        "'"+ IZV_cmb_tip_objekta.getValue().toString() + "',"+  //TIP OBJEKTA
                        "'"+ IZV_cmb_VP_magacin.getValue().toString() + "',"+  //VP
                       // "'"+ IZV_cmb_nacin_prikaza.getValue().toString() + "'"
                         "'"+ listaStavkiizvestaja.getSelectionModel().getSelectedItem().toString() + "'"
                        //"'POSLEDNJE 3 AKCIJE'"
                        +"))";
                System.out.println(v_sql);

                UK_data = FXCollections.observableArrayList(resultsAK);
             
                
                
                LineChartIZV.getData().clear();
                
      
                 
                  XYChart.Series<String,Number> series1AK = new XYChart.Series<String, Number>();
                  XYChart.Series<String,Number> series2AK = new XYChart.Series<String, Number>();
                  XYChart.Series<String,Number> series3AK = new XYChart.Series<String, Number>();
                
                    for (int i = 0; i < resultsAK.size(); i++)
                {
                              
                               series1AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred1()));
                               series2AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred2()));
                               series3AK.getData().add(new XYChart.Data<String, Number>(resultsAK.get(i).getNaziv(),resultsAK.get(i).getVred3()));
                      
                }
                     series1AK.setName(serija1);
                
               //  series2AK.setName("Prodaja ukupna");
         if (broj_serija>=1)        LineChartIZV.getData().add(series1AK);
       
         if (broj_serija>=2) 
                 {
                     LineChartIZV.getData().add(series2AK);
                     series2AK.setName(serija2);
                 }         
         
         if (broj_serija==3)
                 {
                     LineChartIZV.getData().add(series3AK);
                     series3AK.setName(serija3);
                 }        
                 
            ///////////postavka tabele
                
          IZVESTAJI_data = FXCollections.observableArrayList(resultsAK);
          
           
          IZVESTAJI_naziv=new TableColumn ("Naziv");
          IZVESTAJI_naziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          IZVESTAJI_VRED1=new TableColumn (serija1);
          IZVESTAJI_VRED1.setCellValueFactory(new PropertyValueFactory<>("vred1"));
          //NA_ID_AKCIJE.setPrefWidth(90);
         // NA_ID_AKCIJE.setText("id akcije"); 
          
        
          IZVESTAJI_VRED2=new TableColumn (serija2);
          IZVESTAJI_VRED2.setCellValueFactory(new PropertyValueFactory<>("vred2"));
          
          IZVESTAJI_VRED3=new TableColumn (serija3);
          IZVESTAJI_VRED3.setCellValueFactory(new PropertyValueFactory<>("vred3"));
          
          IZVESTAJI_VRED4=new TableColumn (kolona4);
          IZVESTAJI_VRED4.setCellValueFactory(new PropertyValueFactory<>("vred4"));
          
          IZVESTAJI_VRED5=new TableColumn (kolona5);
          IZVESTAJI_VRED5.setCellValueFactory(new PropertyValueFactory<>("vred5"));
          
          IZVESTAJI_VRED6=new TableColumn (kolona6);
          IZVESTAJI_VRED6.setCellValueFactory(new PropertyValueFactory<>("vred6"));
    
          
                             
          
          if (broj_kolona==1)  tblIZV.getColumns().setAll(IZVESTAJI_naziv,IZVESTAJI_VRED1);
          if (broj_kolona==2)  tblIZV.getColumns().setAll(IZVESTAJI_naziv,IZVESTAJI_VRED1,IZVESTAJI_VRED2);
          if (broj_kolona==3)  tblIZV.getColumns().setAll(IZVESTAJI_naziv,IZVESTAJI_VRED1,IZVESTAJI_VRED2,IZVESTAJI_VRED3);
          if (broj_kolona==4)  tblIZV.getColumns().setAll(IZVESTAJI_naziv,IZVESTAJI_VRED1,IZVESTAJI_VRED2,IZVESTAJI_VRED3,IZVESTAJI_VRED4);
          if (broj_kolona==5)  tblIZV.getColumns().setAll(IZVESTAJI_naziv,IZVESTAJI_VRED1,IZVESTAJI_VRED2,IZVESTAJI_VRED3,IZVESTAJI_VRED4,IZVESTAJI_VRED5);
          if (broj_kolona==6)  tblIZV.getColumns().setAll(IZVESTAJI_naziv,IZVESTAJI_VRED1,IZVESTAJI_VRED2,IZVESTAJI_VRED3,IZVESTAJI_VRED4,IZVESTAJI_VRED5,IZVESTAJI_VRED6);
     
          tblIZV.setItems(IZVESTAJI_data);
                 
                 
                 
                 //postavka grafika i tabele
                 //ako su selektovana oba objekta
                 if ((checkGrafik.isSelected())  &&  (checkTabela.isSelected()) )
                 {
                     LineChartIZV.setVisible(true);
                     LineChartIZV.setPrefWidth(500);
                     tblIZV.setVisible(true);
                     tblIZV.setPrefWidth(500);
                     LineChartIZV.setLayoutX(340);
                     tblIZV.setLayoutX(900);
                     
                 }
                 else
                 {
                     //selektovan samo graph
                      if (checkGrafik.isSelected()) 
                      {
                         LineChartIZV.setVisible(true);
                         tblIZV.setVisible(false);
                         LineChartIZV.setLayoutX(340);
                         LineChartIZV.setPrefWidth(1000);
                      }
                      else //samo tabela
                      {
                         LineChartIZV.setVisible(false);
                         tblIZV.setVisible(true);
                         tblIZV.setPrefWidth(1000);
                         tblIZV.setLayoutX(340);
                      }
                 }
               
                 
                 //ne vide se oba
                  if ((!checkGrafik.isSelected())  &&  (!checkTabela.isSelected()) )
                 {
                     LineChartIZV.setVisible(false);
                     tblIZV.setVisible(false);
                    
                     
                 }
                 
     
               
}

@FXML
     public void kreirajExcelZbirniPregledi() {
         //BigInteger art = null;
        Integer a=data.get(tabela.getSelectionModel().getSelectedIndex()).getId(); 
         List<BVMpAkcNazivVredX15>  results =   em.createNativeQuery("select trim(naziv) as naziv, vred1,vred2,vred3,vred4,"
                 + "vred5,vred6,vred7,vred8,vred9,vred10,vred11,vred12,vred13,vred14,vred15\n" +
"from table(\n" +
"bojanivetic.b_mp_akc_grupisano\n" +
" ("+a+",'" + GR_cmb_tip_izv.getValue().toString()/* "PO_ARTIKLU"*/+      "'))", BVMpAkcNazivVredX15.class)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList();
          
    if (GR_cmb_tip_izv.getValue().toString().equals("PO_ARTIKLU"))
          {        
   try {      
           
    Workbook wb = (Workbook) new HSSFWorkbook();
    CreationHelper createhelper = wb.getCreationHelper();
    Sheet sheet = wb.createSheet("Lista Selekcije");
    Row row = null;
    Cell cell = null;
   
    
    
   
        
         
   
    //kreiraj zaglavlje dokument
     row = sheet.createRow(0);
            cell = row.createCell(0);
            cell.setCellValue((String) "NAZIV");
           
            cell = row.createCell(1);
            cell.setCellValue((String) "PRODAJA");
           
            cell = row.createCell(2);
            cell.setCellValue((String) "ZALIHA");
           
             cell = row.createCell(3);
            cell.setCellValue((String) "PRODAJA_DIN");
           
            cell = row.createCell(4);
            cell.setCellValue((String) "PREPORUCENA");
           
           
           
            cell = row.createCell(5);
            cell.setCellValue((String) "KO");
           
            cell = row.createCell(6);
            cell.setCellValue((String) "NULE");
           
             cell = row.createCell(7);
            cell.setCellValue((String) "NULE JUCE");
           
            cell = row.createCell(8);
            cell.setCellValue((String) "PROCENAT OOS");
           
            cell = row.createCell(9);
            cell.setCellValue((String) "% OSTVARENJA");
           
             cell = row.createCell(10);
            cell.setCellValue((String) "NEISPOR SA VP");
           
            cell = row.createCell(11);
            cell.setCellValue((String) "ZAL VP ZR");
           
           
           
            cell = row.createCell(12);
            cell.setCellValue((String) "ZAL VP ŠABAC");
           
            cell = row.createCell(13);
            cell.setCellValue((String) "ZAL RDC");
           
        
           
           
        
    //kraj kreiranja zaglavlja
 
    for (int i=0;i<results.size();i++) {
        row = sheet.createRow(i+1); //IDE
       
       
      
     
     //  GR_NAZIV,GR_VRED1,GR_VRED2,GR_VRED3,GR_VRED4,GR_VRED5,GR_VRED6,GR_VRED13,GR_VRED7,GR_VRED8,GR_VRED9,GR_VRED10,GR_VRED11,GR_VRED12
    
      
       
               if (results.get(i).getNaziv() != null)
            {
            cell = row.createCell(0);
            cell.setCellValue((String) results.get(i).getNaziv());
            }else
            {
            cell = row.createCell(0);
            cell.setCellValue((String) "/");
            }      
              
              
           
            if (results.get(i).getVred1() != null)
            {
            cell = row.createCell(1);
            cell.setCellValue((String) results.get(i).getVred1().toString());
            }else
            {
            cell = row.createCell(1);
            cell.setCellValue((String) "/");
            }
           
           
            if (results.get(i).getVred2() != null)
            {
            cell = row.createCell(2);
            cell.setCellValue((String) results.get(i).getVred2().toString());
             }else
            {
            cell = row.createCell(2);
            cell.setCellValue((String) "/");
            }
           
            if (results.get(i).getVred3() != null)
            {
            cell = row.createCell(3);
            cell.setCellValue((String) results.get(i).getVred3().toString());
            }
            else
            {
            cell = row.createCell(3);
            cell.setCellValue((String) "/");      
            }
           
           
            if (results.get(i).getVred4() != null)
            {
            cell = row.createCell(4);
            cell.setCellValue((String) results.get(i).getVred4().toString());
            }
            else
            {
            cell = row.createCell(4);
            cell.setCellValue((String) "/");      
            }
            if (results.get(i).getVred5() != null)
            {
            cell = row.createCell(5);
            cell.setCellValue((String)results.get(i).getVred5().toString());
             }
            else
            {
            cell = row.createCell(5);
            cell.setCellValue((String) "/");      
            }
           
            if (results.get(i).getVred6() != null)
            {
            cell = row.createCell(6);
            cell.setCellValue((String)results.get(i).getVred6().toString());
             }
            else
            {
            cell = row.createCell(6);
            cell.setCellValue((String) "/");      
            }
           
           
           
            if (results.get(i).getVred13() != null)
            { 
            cell = row.createCell(7);
            cell.setCellValue((String) results.get(i).getVred13().toString());
            }else
            {
            cell = row.createCell(7);
            cell.setCellValue((String) "/");  
            }
           
           
            if (results.get(i).getVred7() != null)
            {
            cell = row.createCell(8);
            cell.setCellValue((String) results.get(i).getVred7().toString());
            }
            else
            {
            cell = row.createCell(8);
            cell.setCellValue((String) "/");  
            }   
           
            if (results.get(i).getVred8() != null)
            {
            cell = row.createCell(9);
            cell.setCellValue((String) results.get(i).getVred8().toString());
            }
            else
            {
            cell = row.createCell(9);
            cell.setCellValue((String) "/");      
            }
           
            if (results.get(i).getVred9() != null)
            {
            cell = row.createCell(10);
            cell.setCellValue((String) results.get(i).getVred9().toString());
            }
            else
            {
             cell = row.createCell(10);
            cell.setCellValue((String) "/");  
            } 
           
           
            if (results.get(i).getVred10() != null)
            {
            cell = row.createCell(11);
            cell.setCellValue((String) results.get(i).getVred10().toString());
             }
            else
            {
            cell = row.createCell(11);
            cell.setCellValue((String) "/");  
            } 
          
            if (results.get(i).getVred11() != null)
            {
            cell = row.createCell(12);
            cell.setCellValue((String)results.get(i).getVred11().toString());
            }
            else
            {
              cell = row.createCell(12);
            cell.setCellValue((String)"/"); 
            }   
             if (results.get(i).getVred12() != null)
            {
            cell = row.createCell(13);
            cell.setCellValue((String)results.get(i).getVred12().toString());
             }
            else
            {
            cell = row.createCell(13);
            cell.setCellValue((String)"/"); 
            } 
        
      
        
          
      
   
    }
         
    /*
 
   
    */
   
               
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
Date date = new Date();
System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
   // String v_ime_fajla="C:\\Desktop\\Disc.Prijave"+dateFormat.format(date)+".xls";
  String v_ime_fajla="Izveštaj po ARTIKLU  "+dateFormat.format(date)+".xls";
   
    FileOutputStream out = new FileOutputStream(v_ime_fajla);/*"E:\\workbook.xls"*/   //);
  
   
    
   

   
    wb.write(out);
    out.close();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Kreiranje Excel fajla");
               alert.setHeaderText("Kreiran je Excel fajl");
           //    alert.setContentText("Obračunali ste stimulacije/destimulacije za mesec "+s);
               alert.showAndWait();
} catch (FileNotFoundException ex) {
    Logger.getLogger(FXMLGlavniController.class.getName()).log(Level.SEVERE, null, ex);
} catch (IOException ex) {
    Logger.getLogger(FXMLGlavniController.class.getName()).log(Level.SEVERE, null, ex);
    System.out.println("greska je: "+ex.getMessage());
}  catch (Exception ex) {
    Logger.getLogger(FXMLGlavniController.class.getName()).log(Level.SEVERE, null, ex);
    System.out.println("greska je opsta: "+ex.getMessage());
}

}
     else if( GR_cmb_tip_izv.getValue().toString().equals("PO_MPO"))
     {
           try {      
           
    Workbook wb = (Workbook) new HSSFWorkbook();
    CreationHelper createhelper = wb.getCreationHelper();
    Sheet sheet = wb.createSheet("Lista Selekcije");
    Row row = null;
    Cell cell = null;
   
    
    
   
        
         
   
    //kreiraj zaglavlje dokument
     row = sheet.createRow(0);
            cell = row.createCell(0);
            cell.setCellValue((String) "NAZIV");
           
            cell = row.createCell(1);
            cell.setCellValue((String) "PRODAJA");
           
            cell = row.createCell(2);
            cell.setCellValue((String) "ZALIHA");
           
             cell = row.createCell(3);
            cell.setCellValue((String) "KO");
           
            cell = row.createCell(4);
            cell.setCellValue((String) "NULE");
           
           
           
            cell = row.createCell(5);
            cell.setCellValue((String) "PROCENAT OOS");
           
            cell = row.createCell(6);
            cell.setCellValue((String) "NULE ZADNJI DAN");
           
         
           
        
           
           
        
    //kraj kreiranja zaglavlja
 
    for (int i=0;i<results.size();i++) {
        row = sheet.createRow(i+1); //IDE
       
       
      
     
     //  GR_NAZIV,GR_VRED1,GR_VRED2,/*GR_VRED3,GR_VRED4,*/GR_VRED5,GR_VRED6,GR_VRED7,GR_VRED8
    
      
       
            
            cell = row.createCell(0);
            cell.setCellValue((String) results.get(i).getNaziv().toString());
           
            cell = row.createCell(1);
            cell.setCellValue((String) results.get(i).getVred1().toString());
           
            cell = row.createCell(2);
            cell.setCellValue((String) results.get(i).getVred2().toString());
           
             cell = row.createCell(3);
            cell.setCellValue((String) results.get(i).getVred5().toString());
           
             cell = row.createCell(4);
            cell.setCellValue((String) results.get(i).getVred6().toString());
          
           
            cell = row.createCell(5);
            cell.setCellValue((String)results.get(i).getVred7().toString());
           
            cell = row.createCell(6);
            cell.setCellValue((String)results.get(i).getVred8().toString());
           
           
        
      
        
          
      
   
    }
         
    /*
 
   
    */
   
               
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
Date date = new Date();
System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
   // String v_ime_fajla="C:\\Desktop\\Disc.Prijave"+dateFormat.format(date)+".xls";
  String v_ime_fajla="Izveštaj po MPO  "+dateFormat.format(date)+".xls";
   
    FileOutputStream out = new FileOutputStream(v_ime_fajla);/*"E:\\workbook.xls"*/   //);
  
   
    
   

   
    wb.write(out);
    out.close();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Kreiranje Excel fajla");
               alert.setHeaderText("Kreiran je Excel fajl");
           //    alert.setContentText("Obračunali ste stimulacije/destimulacije za mesec "+s);
               alert.showAndWait();
} catch (FileNotFoundException ex) {
    Logger.getLogger(FXMLGlavniController.class.getName()).log(Level.SEVERE, null, ex);
} catch (IOException ex) {
    Logger.getLogger(FXMLGlavniController.class.getName()).log(Level.SEVERE, null, ex);
    System.out.println("greska je: "+ex.getMessage());
}  catch (Exception ex) {
    Logger.getLogger(FXMLGlavniController.class.getName()).log(Level.SEVERE, null, ex);
    System.out.println("greska je opsta: "+ex.getMessage());
}

} else if (GR_cmb_tip_izv.getValue().toString().equals("PO_MAGACINU_VP"))
{
               try {      
           
    Workbook wb = (Workbook) new HSSFWorkbook();
    CreationHelper createhelper = wb.getCreationHelper();
    Sheet sheet = wb.createSheet("Lista Selekcije");
    Row row = null;
    Cell cell = null;
   
    
    
   
        
         
   
    //kreiraj zaglavlje dokument
     row = sheet.createRow(0);
            cell = row.createCell(0);
            cell.setCellValue((String) "NAZIV");
           
            cell = row.createCell(1);
            cell.setCellValue((String) "PRODAJA");
           
            cell = row.createCell(2);
            cell.setCellValue((String) "ZALIHA");
           
             cell = row.createCell(3);
            cell.setCellValue((String) "KO");
           
            cell = row.createCell(4);
            cell.setCellValue((String) "NULE");
           
           
           
            cell = row.createCell(5);
            cell.setCellValue((String) "PROCENAT OOS");
           
         
           
         
           
        
           
           
        
    //kraj kreiranja zaglavlja
 
    for (int i=0;i<results.size();i++) {
        row = sheet.createRow(i+1); //IDE
       
       
      
     
     //  GR_NAZIV,GR_VRED1,GR_VRED2,/*GR_VRED3,GR_VRED4,*/GR_VRED5,GR_VRED6,GR_VRED7,GR_VRED8
    
      
       
            
            cell = row.createCell(0);
            cell.setCellValue((String) results.get(i).getNaziv().toString());
           
            cell = row.createCell(1);
            cell.setCellValue((String) results.get(i).getVred1().toString());
           
            cell = row.createCell(2);
            cell.setCellValue((String) results.get(i).getVred2().toString());
           
             cell = row.createCell(3);
            cell.setCellValue((String) results.get(i).getVred5().toString());
           
             cell = row.createCell(4);
            cell.setCellValue((String) results.get(i).getVred6().toString());
          
           
            cell = row.createCell(5);
            cell.setCellValue((String)results.get(i).getVred7().toString());
           
         
           
           
        
      
        
          
      
   
    }
         
    /*
 
   
    */
   
               
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
Date date = new Date();
System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
   // String v_ime_fajla="C:\\Desktop\\Disc.Prijave"+dateFormat.format(date)+".xls";
  String v_ime_fajla="Izveštaj po MAGACINU VP  "+dateFormat.format(date)+".xls";
   
    FileOutputStream out = new FileOutputStream(v_ime_fajla);/*"E:\\workbook.xls"*/   //);
  
   
    
   

   
    wb.write(out);
    out.close();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Kreiranje Excel fajla");
               alert.setHeaderText("Kreiran je Excel fajl");
           //    alert.setContentText("Obračunali ste stimulacije/destimulacije za mesec "+s);
               alert.showAndWait();
} catch (FileNotFoundException ex) {
    Logger.getLogger(FXMLGlavniController.class.getName()).log(Level.SEVERE, null, ex);
} catch (IOException ex) {
    Logger.getLogger(FXMLGlavniController.class.getName()).log(Level.SEVERE, null, ex);
    System.out.println("greska je: "+ex.getMessage());
}  catch (Exception ex) {
    Logger.getLogger(FXMLGlavniController.class.getName()).log(Level.SEVERE, null, ex);
    System.out.println("greska je opsta: "+ex.getMessage());
}
     }else if (GR_cmb_tip_izv.getValue().toString().equals("PO_ROBNOJ_GRUPI"))
    
     {
                    try {      
           
    Workbook wb = (Workbook) new HSSFWorkbook();
    CreationHelper createhelper = wb.getCreationHelper();
    Sheet sheet = wb.createSheet("Lista Selekcije");
    Row row = null;
    Cell cell = null;
   
    
    
   
        
         
   
    //kreiraj zaglavlje dokument
     row = sheet.createRow(0);
            cell = row.createCell(0);
            cell.setCellValue((String) "NAZIV");
           
            cell = row.createCell(1);
            cell.setCellValue((String) "PRODAJA");
           
            cell = row.createCell(2);
            cell.setCellValue((String) "ZALIHA");
           
             cell = row.createCell(3);
            cell.setCellValue((String) "BR. ARTIKALA");
           
            cell = row.createCell(4);
            cell.setCellValue((String) "KO");
           
           
           
            cell = row.createCell(5);
            cell.setCellValue((String) "NULE");
           
             cell = row.createCell(6);
            cell.setCellValue((String) "PROCENAT OOS");
           
             cell = row.createCell(7);
            cell.setCellValue((String) "PROCENAT UK. PROMETA");
           
         
           
         
           
        
           
           
        
    //kraj kreiranja zaglavlja
 
    for (int i=0;i<results.size();i++) {
        row = sheet.createRow(i+1); //IDE
       
       
      
     
     //  GR_NAZIV,GR_VRED1,GR_VRED2,/*GR_VRED3,GR_VRED4,*/GR_VRED5,GR_VRED6,GR_VRED7,GR_VRED8
    
      
       
            
            cell = row.createCell(0);
            cell.setCellValue((String) results.get(i).getNaziv().toString());
           
            cell = row.createCell(1);
            cell.setCellValue((String) results.get(i).getVred1().toString());
           
            cell = row.createCell(2);
            cell.setCellValue((String) results.get(i).getVred2().toString());
           
             cell = row.createCell(3);
            cell.setCellValue((String) results.get(i).getVred4().toString());
           
             cell = row.createCell(4);
            cell.setCellValue((String) results.get(i).getVred5().toString());
          
           
            cell = row.createCell(5);
            cell.setCellValue((String)results.get(i).getVred6().toString());
           
             cell = row.createCell(6);
            cell.setCellValue((String) results.get(i).getVred7().toString());
          
           
            cell = row.createCell(7);
            cell.setCellValue((String)results.get(i).getVred8().toString());
           
         
           
           
        
      
        
          
      
   
    }
         
    /*
 
   
    */
   
               
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
Date date = new Date();
System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
   // String v_ime_fajla="C:\\Desktop\\Disc.Prijave"+dateFormat.format(date)+".xls";
  String v_ime_fajla="Izveštaj po ROBNOJ GRUPI  "+dateFormat.format(date)+".xls";
   
    FileOutputStream out = new FileOutputStream(v_ime_fajla);/*"E:\\workbook.xls"*/   //);
  
   
    
   

   
    wb.write(out);
    out.close();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Kreiranje Excel fajla");
               alert.setHeaderText("Kreiran je Excel fajl");
           //    alert.setContentText("Obračunali ste stimulacije/destimulacije za mesec "+s);
               alert.showAndWait();
} catch (FileNotFoundException ex) {
    Logger.getLogger(FXMLGlavniController.class.getName()).log(Level.SEVERE, null, ex);
} catch (IOException ex) {
    Logger.getLogger(FXMLGlavniController.class.getName()).log(Level.SEVERE, null, ex);
    System.out.println("greska je: "+ex.getMessage());
}  catch (Exception ex) {
    Logger.getLogger(FXMLGlavniController.class.getName()).log(Level.SEVERE, null, ex);
    System.out.println("greska je opsta: "+ex.getMessage());
}
        
     }
    
     }

}