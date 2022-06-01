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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
import javafx.scene.layout.Pane;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
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
public class FXMLObracunControlerVikend implements Initializable {

    
    //varijable koje koristim za jasper report
    public static final String DBURL = "jdbc:oracle:thin:@//10.2.0.246:1521/gom.gomex.local";
    public static final String DBUSER = "rouser";
    public static final String DBPASS = "floret"; 
    
    //----------------------------------------
    
      private EntityManager em;
     ObservableList<BMpvAkcije> data; 
     ObservableList<BVMpvAkcMatricaRazvozDop> RD_data; 
     ObservableList<BVMpvAkcijeArtikli> PK_data; 
     ObservableList<BVMpAkcPreporKolTemp> PKT_data; 
     ObservableList<BVMpvAkcDopunskaTrebovanj> DT_data;
     ObservableList<BVMpAkcRazvozPrvoPunj> RP_data;
     ObservableList<BVMpAkcNedostajuciArtikli> NA_data;
     ObservableList<BVMpAkcErrorLog> ER_data;
     ObservableList<BVMpAkcTrebovanje> PP_data; //pregled prvog punjenja
    // List<BVMpAkcPreporKol>  results_excel;
          
    @FXML   TableView tabela;
    @FXML   TableView tblRazvozDopuna;    
    @FXML   TableView tblPreporKol; 
    @FXML   TableView tblPreporKolTemp; 
    @FXML   TableView tblDopunskaTrebovanja;
    @FXML   TableView tblProba;
    @FXML   TableView tblrazvozPrvoPunj;
    @FXML   TableView tblPNedostajuciArtikli;
    @FXML   TableView tblErrorLog;
    @FXML   TableView tblPrvoPunjenje;
    
    @FXML TabPane tabPane;
    @FXML Tab tabAnalitika;
    
    //kolone za tabelu akcija
    @FXML     TableColumn<BMpAkcije,Integer> ID;
   // @FXML     TableColumn<BMpAkcije,String> TIP_AKCIJE;
    @FXML     TableColumn<BMpvAkcije,Date> DATUM_OD;
    @FXML     TableColumn<BMpvAkcije,Date> DATUM_DO;
    @FXML     TableColumn<BMpvAkcije,String> STATUS;
    @FXML     TableColumn<BMpvAkcije,String> KOMENTAR;    
    
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
       TableColumn<BVMpAkcMatricaRazvozaDop,Date> RD_POC_DATUM_PROJEKCIJE2;
       TableColumn<BVMpAkcMatricaRazvozaDop,Date> RD_KRAJ_DATUM_PROJEKCIJE2;
    
       
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
       TableColumn<BVMpvAkcijeArtikli,Integer> PK_ID;
      // TableColumn<BVMpAkcPreporKol,Long> PK_ID_AKCIJE;
      // TableColumn<BVMpAkcPreporKol,String> PK_ID_KAMPANJE;
       TableColumn<BVMpvAkcijeArtikli,String> PK_ORGJED;
       TableColumn<BVMpvAkcijeArtikli,String> PK_NAZIV_ORGJED;
       TableColumn<BVMpvAkcijeArtikli,Long> PK_ARTIKAL;
       TableColumn<BVMpvAkcijeArtikli,String> PK_SIFRA;
       TableColumn<BVMpvAkcijeArtikli,String> PK_NAZIV;
        TableColumn<BVMpvAkcijeArtikli,String> PK_SREDJENA_KOL;
   //    TableColumn<BVMpAkcPreporKol,Integer> PK_PRIMENJEN_ALGORITAM;
       TableColumn<BVMpAkcPreporKol,String> PK_OPIS;
    //   TableColumn<BVMpAkcPreporKol,BigDecimal> PK_PREPORUCENA;
    //   TableColumn<BVMpAkcPreporKol,BigDecimal> PK_PREPOR_BEZ_KOEF;
    //   TableColumn<BVMpAkcPreporKol,BigDecimal> PK_CENA;
       TableColumn<BVMpAkcPreporKol,String> PK_ROBNA_GRUPA;
    
    @FXML TextArea PK_OPIS_AREA;
    @FXML ListView<String> listaRadnji;
    @FXML ComboBox PK_P_radnja;
    @FXML TextField PK_P_id_artikla;
    @FXML TextField PK_P_sifra;
    @FXML TextField PK_P_naziv_artikla;
    @FXML TextField PK_P_RG;
    @FXML ComboBox PK_P_algoritam;
    @FXML ComboBox cmb_find_matrica_dop;
    
    @FXML TextField PK_P_RG_izmena_kol;
    @FXML TextArea PK_P_RG_izmena_opis;
    
    
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
       TableColumn<BVMpAkcDopunskaTrebovanja,BigDecimal> DT_PRODAJA;
       TableColumn<BVMpAkcDopunskaTrebovanja,Date> DT_DATUM_ZALIHE;
       TableColumn<BVMpAkcDopunskaTrebovanja,BigDecimal> DT_PREPOR_KOL_DO_ISPORUKE;
       TableColumn<BVMpAkcDopunskaTrebovanja,BigDecimal> DT_PREPOR_KOL_PERIOD;
       TableColumn<BVMpAkcDopunskaTrebovanja,BigDecimal> DT_NESREDJENA_KOLICINA;
       TableColumn<BVMpAkcDopunskaTrebovanja,BigDecimal> DT_SREDJENA_KOLCINA;
       TableColumn<BVMpAkcDopunskaTrebovanja,Date> DT_PROJEKCIJA_OD;
       TableColumn<BVMpAkcDopunskaTrebovanja,Date> DT_PROJEKCIJA_DO;
   // @FXML   TableColumn<BVMpAkcDopunskaTrebovanja,String> DT_OPIS;
       TableColumn<BVMpAkcDopunskaTrebovanja,String> DT_RG_ROOT;
    //@FXML   TableColumn<BVMpAkcDopunskaTrebovanja,Long> DT_ID_AKCIJE;
    //@FXML   TableColumn<BVMpAkcDopunskaTrebovanja,String> DT_ID_KAMPANJE;
    //@FXML   TableColumn<BVMpAkcDopunskaTrebovanja,Integer> DT_ID;
    
      //kolone za tabelu nedostajuci artikli
       TableColumn<BVMpAkcNedostajuciArtikli,Integer> NA_ID;
       TableColumn<BVMpAkcNedostajuciArtikli,Long> NA_ID_AKCIJE;
       TableColumn<BVMpAkcNedostajuciArtikli,String> NA_ID_KAMPANJE;
       TableColumn<BVMpAkcNedostajuciArtikli,Long> NA_ARTIKAL;
       TableColumn<BVMpAkcNedostajuciArtikli,String> NA_SIFRA;
       TableColumn<BVMpAkcNedostajuciArtikli,String> NA_NAZIV;
       TableColumn<BVMpAkcNedostajuciArtikli,String> NA_ORGJED;
    
    
    //kolone za tabelu error log
       TableColumn<BVMpAkcErrorLog,Integer> ER_ID;
       TableColumn<BVMpAkcErrorLog,Long> ER_ID_AKCIJE;
       TableColumn<BVMpAkcErrorLog,String> ER_ID_KAMPANJE;
       TableColumn<BVMpAkcErrorLog,Long> ER_ARTIKAL;
       TableColumn<BVMpAkcErrorLog,String> ER_SIFRA;
       TableColumn<BVMpAkcErrorLog,String> ER_NAZIV;
       TableColumn<BVMpAkcErrorLog,String> ER_KOLONA1;
       TableColumn<BVMpAkcErrorLog,String> ER_KOLONA2;
       TableColumn<BVMpAkcErrorLog,String> ER_KOLONA3;
    
    @FXML TextField DT_P_naziv_artikla;
    @FXML TextField DT_P_sifra;
    @FXML DatePicker DT_P_datum_od;
    @FXML DatePicker DT_P_datum_do;
    @FXML ComboBox DT_P_radnja;
    @FXML ComboBox DT_P_MAGACIN;
    @FXML ComboBox DT_P_broj_dopune;
    @FXML TextArea DT_P_opis_area;
    @FXML TextField DT_P_id_artikla;
    
    //kolone i polja za pregled prvog punjenja
    
     @FXML TextArea PP_OPIS_AREA;
   // @FXML ListView<String> listaRadnji;
    @FXML ComboBox PP_P_radnja;
    @FXML TextField PP_P_id_artikla;
    @FXML TextField PP_P_sifra;
    @FXML TextField PP_P_naziv_artikla;
   
       TableColumn<BVMpAkcTrebovanje,Integer> PP_ID;
       TableColumn<BVMpAkcTrebovanje,Long> PP_ID_AKCIJE;
       TableColumn<BVMpAkcTrebovanje,String> PP_ID_KAMPANJE;
       TableColumn<BVMpAkcTrebovanje,String> PP_ORGJED;
       TableColumn<BVMpAkcTrebovanje,String> PP_NAZIV_ORGJED;
       TableColumn<BVMpAkcTrebovanje,Long> PP_ARTIKAL;
       TableColumn<BVMpAkcTrebovanje,String> PP_SIFRA;
       TableColumn<BVMpAkcTrebovanje,String> PP_NAZIV;
       TableColumn<BVMpAkcTrebovanje,String> PP_OPIS;
       TableColumn<BVMpAkcTrebovanje,String> PP_MAGACIN;
       TableColumn<BVMpAkcTrebovanje,BigDecimal> PP_SREDJENA_KOL;
       TableColumn<BVMpAkcTrebovanje,BigDecimal> PP_MULTIFAKTOR;
       TableColumn<BVMpAkcTrebovanje,BigDecimal> PP_SEK_POZICIJA;
       TableColumn<BVMpAkcTrebovanje,BigDecimal> PP_NABAVLJAM_KOL;
       TableColumn<BVMpAkcTrebovanje,BigDecimal> PP_PREPORUCENA_KOL_UK;
       TableColumn<BVMpAkcTrebovanje,BigDecimal> PP_PREPORUCENA_KOL;
       TableColumn<BVMpAkcTrebovanje,BigDecimal> PP_ZALIHA;
       TableColumn<BVMpAkcTrebovanje,Date> PP_DATUM;

    
     
     //izmena matrice dopuna
      @FXML Pane paneIzmenaMatriceDopuna;
      @FXML DatePicker izmDatum;
      @FXML DatePicker izmDatumOd;
      @FXML DatePicker izmDatumDo;
      @FXML DatePicker izmDatumOd2;
      @FXML DatePicker izmDatumDo2;
      
      @FXML DatePicker unosDatum;
      @FXML DatePicker unosDatumOd;
      @FXML DatePicker unosDatumDo;
      @FXML DatePicker unosDatumOd2;
      @FXML DatePicker unosDatumDo2;
      
      //izmena matrice razvoza
      @FXML Pane panePrvoPunjenje;
      @FXML DatePicker izm2Datum;
      @FXML DatePicker izm2DatumOd;
      @FXML DatePicker izm2DatumDo;
      
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
        popuniInicijalno();
       
    }    

    private void popuniInicijalno() {
        
         paneIzmenaMatriceDopuna.setStyle("-fx-background-color: silver;");
         panePrvoPunjenje.setStyle("-fx-background-color: silver;");
        
        em.clear();
         List<BMpvAkcije>  results =  em.createNamedQuery("BMpvAkcije.findAll").getResultList();
           data = FXCollections.observableArrayList(results);
          
           
          ID=new TableColumn ("ID");
          ID.setCellValueFactory(new PropertyValueFactory<BMpAkcije,Integer>("id"));
          
        /*  TIP_AKCIJE=new TableColumn ("TIP_AKCIJE");
          TIP_AKCIJE.setCellValueFactory(new PropertyValueFactory<BMpAkcije,String>("tipAkcije"));*/
          
          DATUM_OD=new TableColumn ("DATUM_OD");
          DATUM_OD.setCellValueFactory(new PropertyValueFactory<BMpvAkcije,Date>("datumOd")); 
          
          DATUM_DO=new TableColumn ("DATUM_DO");
          DATUM_DO.setCellValueFactory(new PropertyValueFactory<BMpvAkcije,Date>("datumDo")); 
          
          STATUS=new TableColumn ("STATUS");
          STATUS.setCellValueFactory(new PropertyValueFactory<BMpvAkcije,String>("status"));
          
          KOMENTAR=new TableColumn ("KOMENTAR");
          KOMENTAR.setCellValueFactory(new PropertyValueFactory<BMpvAkcije,String>("opis"));
          
          tabela.getColumns().setAll(ID, DATUM_OD,DATUM_DO,STATUS,KOMENTAR);
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

           
           List<BMpvAkcije> selected = selectionModel.getSelectedItems();

          // listaRazvozaDopuna(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
         //  listaRazvozaPrvoPunjenje(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
       //    listaPreporKol(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
      
           
               tblrazvozPrvoPunj.setItems(null);
           tblRazvozDopuna.setItems(null);
         listaRadnji(data.get(tabela.getSelectionModel().getSelectedIndex()).getId().intValue());
    /*        listaMagacina(data.get(tabela.getSelectionModel().getSelectedIndex()).getId().intValue());
           listaDopuna(data.get(tabela.getSelectionModel().getSelectedIndex()).getId().intValue());
           listaAlgoritama(data.get(tabela.getSelectionModel().getSelectedIndex()).getId().intValue());
           listaNedostajuci(data.get(tabela.getSelectionModel().getSelectedIndex()).getId().intValue());
           listaErrorLog(data.get(tabela.getSelectionModel().getSelectedIndex()).getId().intValue());
           listaRadnjiPrvoPunjenje(data.get(tabela.getSelectionModel().getSelectedIndex()).getId().intValue());
   */        
           
           Date input = data.get( tabela.getSelectionModel().getSelectedIndex()).getDatumOd2();
           LocalDate datee = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
           DT_P_datum_od.setValue(datee);
           
           Date input2 = data.get( tabela.getSelectionModel().getSelectedIndex()).getDatumDo2();
           LocalDate datee2 = input2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
           DT_P_datum_do.setValue(datee2);
       
           
         }
         }
     });
           
           
           //povezi textarea sa vrednoscu kolone
           
          tblPreporKol.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                        //Check whether item is selected and set value of selected item to Label
                        if(tblPreporKol.getSelectionModel().getSelectedItem() != null) 
                        {              
                           TableView.TableViewSelectionModel selectionModel = tblPreporKol.getSelectionModel();

                          PK_OPIS_AREA.setText(PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getOpis());
                         // PK_P_RG_izmena_kol.setText(PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getPreporucena().toString());

                         }
                         }
     });
          
          
          
          
                     
           //povezi textarea za opis kod dopunskih trebovanja sa vrednoscu kolone
           
          tblDopunskaTrebovanja.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                        //Check whether item is selected and set value of selected item to Label
                        if(tblDopunskaTrebovanja.getSelectionModel().getSelectedItem() != null) 
                        {              
                           TableView.TableViewSelectionModel selectionModel = tblDopunskaTrebovanja.getSelectionModel();

                          DT_P_opis_area.setText(DT_data.get(tblDopunskaTrebovanja.getSelectionModel().getSelectedIndex()).getOpis());

                         }
                         }
     });
          
          //TEXTAREA ZA ANALITIKU
          
                    tblPreporKolTemp.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                        //Check whether item is selected and set value of selected item to Label
                        if(tblPreporKolTemp.getSelectionModel().getSelectedItem() != null) 
                        {              
                           TableView.TableViewSelectionModel selectionModel = tblPreporKolTemp.getSelectionModel();

                          txtAreaOpisAnalitika.setText(PKT_data.get(tblPreporKolTemp.getSelectionModel().getSelectedIndex()).getOpis());

                         }
                         }
     });
          
          
          
          //povezi textarea kod DOPUNSKIH TREBOVANJA sa pisnim poljem
                    tblDopunskaTrebovanja.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                        //Check whether item is selected and set value of selected item to Label
                        if(tblDopunskaTrebovanja.getSelectionModel().getSelectedItem() != null) 
                        {              
                           TableView.TableViewSelectionModel selectionModel = tblDopunskaTrebovanja.getSelectionModel();

                          DT_P_opis_area.setText(DT_data.get(tblDopunskaTrebovanja.getSelectionModel().getSelectedIndex()).getOpis());

                         }
                         }
     });
          
                //povezi textarea za opis kod prvog punjenja trebovanja sa vrednoscu kolone za temp
           
          tblPrvoPunjenje.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                        //Check whether item is selected and set value of selected item to Label
                        if(tblPrvoPunjenje.getSelectionModel().getSelectedItem() != null) 
                        {              
                           TableView.TableViewSelectionModel selectionModel = tblPrvoPunjenje.getSelectionModel();

                          PP_OPIS_AREA.setText(PP_data.get(tblPrvoPunjenje.getSelectionModel().getSelectedIndex()).getOpis());

                         }
                         }
     });
         
          
          /////vrti kod matrice razvoza dopuna i popuni inicijalno datume rayvoya kako bi ih neko izmenjao nakon toga
                    tblRazvozDopuna.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                        //Check whether item is selected and set value of selected item to Label
                        if(tblRazvozDopuna.getSelectionModel().getSelectedItem() != null) 
                        {              
                           TableView.TableViewSelectionModel selectionModel = tblRazvozDopuna.getSelectionModel();

                  /*
                             Date input = RD_data.get( tblRazvozDopuna.getSelectionModel().getSelectedIndex()).getDatum2();
                             LocalDate datee = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                             izmDatum.setValue(datee);
                             
                             Date input2 = RD_data.get( tblRazvozDopuna.getSelectionModel().getSelectedIndex()).getPocDatumProjekcije_datum();
                             LocalDate datee2 = input2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                             izmDatumOd.setValue(datee2);
                             
                             Date input3 = RD_data.get( tblRazvozDopuna.getSelectionModel().getSelectedIndex()).getKrajDatumProjekcije_datum();
                             LocalDate datee3 = input3.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                             izmDatumDo.setValue(datee3);
                             
                             Date input22 = RD_data.get( tblRazvozDopuna.getSelectionModel().getSelectedIndex()).getPocDatumProjekcije_datum2();
                             LocalDate datee22 = input22.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                             izmDatumOd2.setValue(datee22);
                             
                             Date input32 = RD_data.get( tblRazvozDopuna.getSelectionModel().getSelectedIndex()).getKrajDatumProjekcije_datum2();
                             LocalDate datee32 = input32.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                             izmDatumDo2.setValue(datee32);
                         */
                           
                       
                         }
                         }
     });
                    
                    
                    //kod matrice prvog punjenja popuni inicijalno datume koji su spremni za izmenu
                    
                      /////vrti kod matrice razvoza dopuna i popuni inicijalno datume rayvoya kako bi ih neko izmenjao nakon toga
                    tblrazvozPrvoPunj.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                        //Check whether item is selected and set value of selected item to Label
                        if(tblrazvozPrvoPunj.getSelectionModel().getSelectedItem() != null) 
                        {              
                           TableView.TableViewSelectionModel selectionModel = tblrazvozPrvoPunj.getSelectionModel();

                  
                             Date inputP = RP_data.get( tblrazvozPrvoPunj.getSelectionModel().getSelectedIndex()).getDatum2();
                             LocalDate dateeP = inputP.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                             izm2Datum.setValue(dateeP);
                             
                             Date input2P = RP_data.get( tblrazvozPrvoPunj.getSelectionModel().getSelectedIndex()).getPocDatumProjekcije2();
                             LocalDate datee2P = input2P.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                             izm2DatumOd.setValue(datee2P);
                             
                             Date input3P = RP_data.get( tblrazvozPrvoPunj.getSelectionModel().getSelectedIndex()).getKrajDatumProjekcije2();
                             LocalDate datee3P = input3P.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                             izm2DatumDo.setValue(datee3P);
                         
                           
                       
                         }
                         }
     });
          
          

          
          listaRadnji.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String> () {

             @Override
             public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
                listaPreporKol2(data.get(tabela.getSelectionModel().getSelectedIndex()).getId().intValue(), newValue);
             }
         });
          


          
    }
    
    public void listaRazvozaDopuna(Integer i,String s) {
        em.clear();
          List<BVMpvAkcMatricaRazvozDop>  results =  em.createNamedQuery("BVMpvAkcMatricaRazvozDop.findByIdiNazivOJ")
                  .setParameter("id", i)
                  .setParameter("nazivOJ", s)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                  .getResultList();
           RD_data = FXCollections.observableArrayList(results);
          
           
          RD_ID=new TableColumn ("RD_ID");
          RD_ID.setCellValueFactory(new PropertyValueFactory<BVMpAkcMatricaRazvozaDop,Integer>("id"));
          RD_ID.setPrefWidth(30);
          RD_ID.setText("id");
          
          RD_BROJ_DOPUNE=new TableColumn ("RD_BROJ_DOPUNE");
          RD_BROJ_DOPUNE.setCellValueFactory(new PropertyValueFactory<BVMpAkcMatricaRazvozaDop,Integer>("brojDopune"));
          RD_BROJ_DOPUNE.setPrefWidth(60);
          RD_BROJ_DOPUNE.setText("dopuna");
          
          RD_ORGJED=new TableColumn ("RD_ORGJED");
          RD_ORGJED.setCellValueFactory(new PropertyValueFactory<BVMpAkcMatricaRazvozaDop,String>("orgjed"));
          RD_ORGJED.setPrefWidth(80);
          RD_ORGJED.setText("OJ");
          
          
          RD_NAZIV_OJ=new TableColumn ("RD_NAZIV_OJ");
          RD_NAZIV_OJ.setCellValueFactory(new PropertyValueFactory<BVMpAkcMatricaRazvozaDop,String>("nazivOj"));
          RD_NAZIV_OJ.setPrefWidth(140);
          RD_NAZIV_OJ.setText("OJ naziv");
          
          RD_MAGACIN=new TableColumn ("RD_MAGACIN");
          RD_MAGACIN.setCellValueFactory(new PropertyValueFactory<BVMpAkcMatricaRazvozaDop,String>("magacin"));
          RD_MAGACIN.setPrefWidth(40);
          RD_MAGACIN.setText("DC");
          
          
          RD_DATUM=new TableColumn ("RD_DATUM");
          RD_DATUM.setCellValueFactory(new PropertyValueFactory<BVMpAkcMatricaRazvozaDop,Date>("datum")); 
          RD_DATUM.setPrefWidth(80);
          RD_DATUM.setText("datum");
          
          
          RD_DAN_U_NEDELJI=new TableColumn ("RD_DAN_U_NEDELJI");
          RD_DAN_U_NEDELJI.setCellValueFactory(new PropertyValueFactory<BVMpAkcMatricaRazvozaDop,String>("danUNedelji"));
          RD_DAN_U_NEDELJI.setPrefWidth(100);
          RD_DAN_U_NEDELJI.setText("dan");
          
          RD_STATUS=new TableColumn ("RD_STATUS");
          RD_STATUS.setCellValueFactory(new PropertyValueFactory<BVMpAkcMatricaRazvozaDop,String>("status"));
          RD_STATUS.setPrefWidth(50);
          RD_STATUS.setText("status");
          
          
          RD_POC_DATUM_PROJEKCIJE=new TableColumn ("RD_POC_DATUM_PROJEKCIJE");
          RD_POC_DATUM_PROJEKCIJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcMatricaRazvozaDop,Date>("pocDatumProjekcije"));
          RD_POC_DATUM_PROJEKCIJE.setPrefWidth(120);
          RD_POC_DATUM_PROJEKCIJE.setText("dat pocet projekc");
          
          RD_KRAJ_DATUM_PROJEKCIJE=new TableColumn ("RD_KRAJ_DATUM_PROJEKCIJE");
          RD_KRAJ_DATUM_PROJEKCIJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcMatricaRazvozaDop,Date>("krajDatumProjekcije"));
          RD_KRAJ_DATUM_PROJEKCIJE.setPrefWidth(120);
          RD_KRAJ_DATUM_PROJEKCIJE.setText("dat kraja projekc");
          
          RD_POC_DATUM_PROJEKCIJE2=new TableColumn ("RD_POC_DATUM_PROJEKCIJE");
          RD_POC_DATUM_PROJEKCIJE2.setCellValueFactory(new PropertyValueFactory<BVMpAkcMatricaRazvozaDop,Date>("pocDatumProjekcije2"));
          RD_POC_DATUM_PROJEKCIJE2.setPrefWidth(120);
          RD_POC_DATUM_PROJEKCIJE2.setText("dat pocet2");
          
          RD_KRAJ_DATUM_PROJEKCIJE2=new TableColumn ("RD_KRAJ_DATUM_PROJEKCIJE");
          RD_KRAJ_DATUM_PROJEKCIJE2.setCellValueFactory(new PropertyValueFactory<BVMpAkcMatricaRazvozaDop,Date>("krajDatumProjekcije2"));
          RD_KRAJ_DATUM_PROJEKCIJE2.setPrefWidth(120);
          RD_KRAJ_DATUM_PROJEKCIJE2.setText("dat kraja2");
          
          
          
          tblRazvozDopuna.getColumns().setAll(RD_ID,RD_BROJ_DOPUNE,RD_ORGJED,RD_NAZIV_OJ,RD_MAGACIN,RD_DATUM,RD_DAN_U_NEDELJI,
                  RD_STATUS /*,RD_POC_DATUM_PROJEKCIJE,RD_KRAJ_DATUM_PROJEKCIJE,RD_POC_DATUM_PROJEKCIJE2,RD_KRAJ_DATUM_PROJEKCIJE2*/);
     
          tblRazvozDopuna.setItems(RD_data);
    }
    
    
     public void listaRazvozaPrvoPunjenje(Integer i) {
        em.clear();
          List<BVMpAkcRazvozPrvoPunj>  results =  em.createNamedQuery("BVMpAkcRazvozPrvoPunj.findById")
                  .setParameter("id", i)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                  .getResultList();
           RP_data = FXCollections.observableArrayList(results);
          
           
          RP_ID=new TableColumn ("RP_ID");
          RP_ID.setCellValueFactory(new PropertyValueFactory<BVMpAkcRazvozPrvoPunj,Integer>("id"));
          RP_ID.setPrefWidth(60);
          RP_ID.setText("id");
          
          RP_BROJ_DOPUNE=new TableColumn ("RP_BROJ_DOPUNE");
          RP_BROJ_DOPUNE.setCellValueFactory(new PropertyValueFactory<BVMpAkcRazvozPrvoPunj,Integer>("brojDopune"));
          RP_BROJ_DOPUNE.setPrefWidth(80);
          RP_BROJ_DOPUNE.setText("dopuna");
          
          RP_ORGJED=new TableColumn ("RP_ORGJED");
          RP_ORGJED.setCellValueFactory(new PropertyValueFactory<BVMpAkcRazvozPrvoPunj,String>("orgjed"));
          RP_ORGJED.setPrefWidth(80);
          RP_ORGJED.setText("OJ");
          
          
          RP_NAZIV_OJ=new TableColumn ("RP_NAZIV_OJ");
          RP_NAZIV_OJ.setCellValueFactory(new PropertyValueFactory<BVMpAkcRazvozPrvoPunj,String>("radnja"));
          RP_NAZIV_OJ.setPrefWidth(140);
          RP_NAZIV_OJ.setText("radnja");
          
          RP_MAGACIN=new TableColumn ("RP_MAGACIN");
          RP_MAGACIN.setCellValueFactory(new PropertyValueFactory<BVMpAkcRazvozPrvoPunj,String>("magacin"));
          RP_MAGACIN.setPrefWidth(80);
          RP_MAGACIN.setText("DC");
          
          RP_DATUM=new TableColumn ("RP_DATUM");
          RP_DATUM.setCellValueFactory(new PropertyValueFactory<BVMpAkcRazvozPrvoPunj,Date>("datum")); 
          RP_DATUM.setPrefWidth(100);
          RP_DATUM.setText("datum");
          
          RP_DAN_U_NEDELJI=new TableColumn ("RP_DAN_U_NEDELJI");
          RP_DAN_U_NEDELJI.setCellValueFactory(new PropertyValueFactory<BVMpAkcRazvozPrvoPunj,String>("danUNedelji"));
          RP_DAN_U_NEDELJI.setPrefWidth(120);
          RP_DAN_U_NEDELJI.setText("dan");
          
          RP_STATUS=new TableColumn ("RP_STATUS");
          RP_STATUS.setCellValueFactory(new PropertyValueFactory<BVMpAkcRazvozPrvoPunj,String>("status"));
          RP_STATUS.setPrefWidth(80);
          RP_STATUS.setText("status");
          
          RP_POC_DATUM_PROJEKCIJE=new TableColumn ("RP_POC_DATUM_PROJEKCIJE");
          RP_POC_DATUM_PROJEKCIJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcRazvozPrvoPunj,Date>("pocDatumProjekcije"));
          RP_POC_DATUM_PROJEKCIJE.setPrefWidth(170);
          RP_POC_DATUM_PROJEKCIJE.setText("dat pocet projekc");
          
          RP_KRAJ_DATUM_PROJEKCIJE=new TableColumn ("RP_KRAJ_DATUM_PROJEKCIJE");
          RP_KRAJ_DATUM_PROJEKCIJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcRazvozPrvoPunj,Date>("krajDatumProjekcije"));
          RP_KRAJ_DATUM_PROJEKCIJE.setPrefWidth(170);
          RP_KRAJ_DATUM_PROJEKCIJE.setText("dat kraja projekc");
          
          
          
          tblrazvozPrvoPunj.getColumns().setAll(RP_ID,RP_BROJ_DOPUNE,RP_ORGJED,RP_NAZIV_OJ,RP_MAGACIN,RP_DATUM,RP_DAN_U_NEDELJI,RP_STATUS,RP_POC_DATUM_PROJEKCIJE,RP_KRAJ_DATUM_PROJEKCIJE);
     
          tblrazvozPrvoPunj.setItems(RP_data);
    }
    
    
     public void listaPreporKol(Integer i) {
        em.clear();
          List<BVMpvAkcijeArtikli>  results =  em.createNamedQuery("BVMpvAkcijeArtikli.findById")
                  .setParameter("id", i)
                  .getResultList();
          PK_data = FXCollections.observableArrayList(results);
          
           
          PK_ID=new TableColumn ("PK_ID");
          PK_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        /*  
          PK_ID_AKCIJE=new TableColumn ("PK_ID_AKCIJE");
          PK_ID_AKCIJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,Long>("idAkcije"));
          
          PK_ID_KAMPANJE=new TableColumn ("PK_ID_KAMPANJE");
          PK_ID_KAMPANJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,String>("idKampanje"));*/
          
          PK_ORGJED=new TableColumn ("PK_ORGJED");
          PK_ORGJED.setCellValueFactory(new PropertyValueFactory<>("orgjed"));
          
          PK_NAZIV_ORGJED=new TableColumn ("PK_NAZIV_ORGJED");
          PK_NAZIV_ORGJED.setCellValueFactory(new PropertyValueFactory<>("nazivOrgjed"));
          
          PK_ARTIKAL=new TableColumn ("PK_ARTIKAL");
          PK_ARTIKAL.setCellValueFactory(new PropertyValueFactory<>("artikal"));
          
          PK_SIFRA=new TableColumn ("PK_SIFRA");
          PK_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          
          PK_NAZIV=new TableColumn ("PK_NAZIV");
          PK_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
      /*    
          PK_PRIMENJEN_ALGORITAM=new TableColumn ("PK_PRIMENJEN_ALGORITAM");
          PK_PRIMENJEN_ALGORITAM.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,Integer>("primenjenAlgoritam"));
      */   
          PK_OPIS=new TableColumn ("PK_OPIS");
          PK_OPIS.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,String>("opis"));
      /*    
          PK_PREPORUCENA=new TableColumn ("PK_PREPORUCENA");
          PK_PREPORUCENA.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,BigDecimal>("preporucena"));
          
          PK_PREPOR_BEZ_KOEF=new TableColumn ("PK_PREPOR_BEZ_KOEF");
          PK_PREPOR_BEZ_KOEF.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,BigDecimal>("preporBezKoef"));
          
          PK_CENA=new TableColumn ("PK_CENA");
          PK_CENA.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,BigDecimal>("cena"));
         */ 
          PK_ROBNA_GRUPA=new TableColumn ("PK_ROBNA_GRUPA");
          PK_ROBNA_GRUPA.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,String>("robnaGrupa"));
          
          
          
          tblPreporKol.getColumns().setAll(PK_ID,/*PK_ID_AKCIJE,PK_ID_KAMPANJE,*/PK_ORGJED,PK_NAZIV_ORGJED,PK_ARTIKAL,PK_SIFRA,PK_NAZIV,
                         /*   PK_PRIMENJEN_ALGORITAM,PK_PREPORUCENA,PK_PREPOR_BEZ_KOEF,PK_CENA,*/PK_ROBNA_GRUPA,PK_OPIS);
     
          tblPreporKol.setItems(PK_data);
    }
     
     @FXML
     
     public void listaPreporKolFilter() {
             
   
         
   
       String v_cmb_radnja;
           if (PK_P_radnja.getValue() == null) v_cmb_radnja="%%";
           else  v_cmb_radnja="%"+PK_P_radnja.getValue()+"%";
           
            Integer v_cmb_algoritam;
       
            try {
             if ("".equals(PK_P_algoritam.getValue().toString())) {
                 v_cmb_algoritam = -1;
             } else {
                 v_cmb_algoritam = Integer.parseInt(PK_P_algoritam.getValue().toString());
             }             
         } catch (Exception E) {
             v_cmb_algoritam = -1;
         }
           
           Long v_id_artikla;
         try {
             if (PK_P_id_artikla.getText().isEmpty()) {
                 v_id_artikla = Long.valueOf("-1");
             } else {
                 v_id_artikla = Long.parseLong(PK_P_id_artikla.getText());
             }             
         } catch (Exception exception) {
              v_id_artikla = Long.valueOf("-1");
         }
         
        // v_id_artikla=Long.valueOf("-1");
        em.clear();
          List<BVMpvAkcijeArtikli>  results =  em.createNamedQuery("BVMpvAkcijeArtikli.filterPretraga")
                  .setParameter("id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId())
                  .setParameter("naziv","%" +PK_P_naziv_artikla.getText().toUpperCase()+"%")
                  .setParameter("sifra","%" + PK_P_sifra.getText()+"%")
                  .setParameter("nazivOrgjed", v_cmb_radnja)
                  .setParameter("robnaGrupa","%" + PK_P_RG.getText().toUpperCase()+"%")
                 // .setParameter("primenjenAlgoritam", v_cmb_algoritam)
                  .setParameter("artikal", v_id_artikla)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                  .getResultList();
          
         // results_excel=results;
          PK_data = FXCollections.observableArrayList(results);
          
           
          PK_ID=new TableColumn ("PK_ID");
          PK_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
    /*      
          PK_ID_AKCIJE=new TableColumn ("PK_ID_AKCIJE");
          PK_ID_AKCIJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,Long>("idAkcije"));
          PK_ID_AKCIJE.setPrefWidth(90);
          PK_ID_AKCIJE.setText("id akcije"); 
          
          PK_ID_KAMPANJE=new TableColumn ("PK_ID_KAMPANJE");
          PK_ID_KAMPANJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,String>("idKampanje"));
          PK_ID_KAMPANJE.setPrefWidth(90);
          PK_ID_KAMPANJE.setText("id kampanje"); */
          
          PK_ORGJED=new TableColumn ("PK_ORGJED");
          PK_ORGJED.setCellValueFactory(new PropertyValueFactory<>("orgjed"));
          PK_ORGJED.setPrefWidth(30);
          PK_ORGJED.setText("OJ"); 
          
          PK_NAZIV_ORGJED=new TableColumn ("PK_NAZIV_ORGJED");
          PK_NAZIV_ORGJED.setCellValueFactory(new PropertyValueFactory<>("nazivOrgjed"));
          PK_NAZIV_ORGJED.setPrefWidth(120);
          PK_NAZIV_ORGJED.setText("OJ naziv"); 
          
          PK_ARTIKAL=new TableColumn ("PK_ARTIKAL");
          PK_ARTIKAL.setCellValueFactory(new PropertyValueFactory<>("artikal"));
          PK_ARTIKAL.setPrefWidth(60);
          PK_ARTIKAL.setText("id artikla"); 
          
          PK_SIFRA=new TableColumn ("PK_SIFRA");
          PK_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          PK_SIFRA.setPrefWidth(60);
          PK_SIFRA.setText("sifra art");
          
          PK_NAZIV=new TableColumn ("PK_NAZIV");
          PK_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          PK_NAZIV.setPrefWidth(200);
          PK_NAZIV.setText("naziv artikla");
     /*      
          PK_PRIMENJEN_ALGORITAM=new TableColumn ("PK_PRIMENJEN_ALGORITAM");
          PK_PRIMENJEN_ALGORITAM.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,Integer>("primenjenAlgoritam"));
          PK_PRIMENJEN_ALGORITAM.setPrefWidth(60);
          PK_PRIMENJEN_ALGORITAM.setText("algoritam");
          */
          PK_OPIS=new TableColumn ("PK_OPIS");
          PK_OPIS.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,String>("opis"));
      /*    
          PK_PREPORUCENA=new TableColumn ("PK_PREPORUCENA");
          PK_PREPORUCENA.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,BigDecimal>("preporucena"));
          PK_PREPORUCENA.setPrefWidth(100);
          PK_PREPORUCENA.setText("preporucena");
          
          PK_PREPOR_BEZ_KOEF=new TableColumn ("PK_PREPOR_BEZ_KOEF");
          PK_PREPOR_BEZ_KOEF.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,BigDecimal>("preporBezKoef"));
          PK_PREPOR_BEZ_KOEF.setPrefWidth(120);
          PK_PREPOR_BEZ_KOEF.setText("prepor bez koef");
          
          PK_CENA=new TableColumn ("PK_CENA");
          PK_CENA.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,BigDecimal>("cena"));
          PK_CENA.setPrefWidth(85);
          PK_CENA.setText("cena");*/
     
          PK_ROBNA_GRUPA=new TableColumn ("PK_ROBNA_GRUPA");
          PK_ROBNA_GRUPA.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,String>("robnaGrupa"));
          PK_ROBNA_GRUPA.setPrefWidth(150);
          PK_ROBNA_GRUPA.setText("robna grupa");
      
          
          
          tblPreporKol.getColumns().setAll(PK_ARTIKAL,PK_SIFRA,PK_NAZIV,
                           /* PK_PRIMENJEN_ALGORITAM,PK_PREPORUCENA,PK_PREPOR_BEZ_KOEF,PK_CENA,*/PK_ROBNA_GRUPA,PK_ORGJED,PK_NAZIV_ORGJED,/*PK_ID_AKCIJE,PK_ID_KAMPANJE,*/PK_OPIS,PK_ID);
     
          tblPreporKol.setItems(PK_data);
   }
           
               
     
     
     
     public void listaPreporKol2(Integer i, String s) {
        em.clear();
          List<BVMpvAkcijeArtikli>  results =  em.createNamedQuery("BVMpvAkcijeArtikli.poOJiID")
                  .setParameter("id", i)
                  .setParameter("nazivOrgjed", s)
                  .getResultList();
          PK_data = FXCollections.observableArrayList(results);
          System.out.println("prosao do 2"); 
           
          PK_ID=new TableColumn ("PK_ID");
          PK_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
          /*
          PK_ID_AKCIJE=new TableColumn ("PK_ID_AKCIJE");
          PK_ID_AKCIJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,Long>("idAkcije"));
          PK_ID_AKCIJE.setPrefWidth(90);
          PK_ID_AKCIJE.setText("id akcije"); 
          
          PK_ID_KAMPANJE=new TableColumn ("PK_ID_KAMPANJE");
          PK_ID_KAMPANJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,String>("idKampanje"));
          PK_ID_KAMPANJE.setPrefWidth(90);
          PK_ID_KAMPANJE.setText("id kampanje"); */
          
          PK_ORGJED=new TableColumn ("PK_ORGJED");
          PK_ORGJED.setCellValueFactory(new PropertyValueFactory<>("orgjed"));
          PK_ORGJED.setPrefWidth(30);
          PK_ORGJED.setText("OJ"); 
          
          PK_NAZIV_ORGJED=new TableColumn ("PK_NAZIV_ORGJED");
          PK_NAZIV_ORGJED.setCellValueFactory(new PropertyValueFactory<>("nazivOrgjed"));
          PK_NAZIV_ORGJED.setPrefWidth(120);
          PK_NAZIV_ORGJED.setText("OJ naziv"); 
          
          PK_ARTIKAL=new TableColumn ("PK_ARTIKAL");
          PK_ARTIKAL.setCellValueFactory(new PropertyValueFactory<>("artikal"));
          PK_ARTIKAL.setPrefWidth(60);
          PK_ARTIKAL.setText("id artikla"); 
          
          PK_SIFRA=new TableColumn ("PK_SIFRA");
          PK_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          PK_SIFRA.setPrefWidth(60);
          PK_SIFRA.setText("sifra art");
          
          PK_NAZIV=new TableColumn ("PK_NAZIV");
          PK_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          PK_NAZIV.setPrefWidth(200);
          PK_NAZIV.setText("naziv artikla");
          
          
           PK_SREDJENA_KOL=new TableColumn ("PK_SREDJENA_KOL");
          PK_SREDJENA_KOL.setCellValueFactory(new PropertyValueFactory<>("sredjenaKolicina"));
          PK_SREDJENA_KOL.setPrefWidth(60);
          PK_SREDJENA_KOL.setText("kolicina"); 
       /*    
          PK_PRIMENJEN_ALGORITAM=new TableColumn ("PK_PRIMENJEN_ALGORITAM");
          PK_PRIMENJEN_ALGORITAM.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,Integer>("primenjenAlgoritam"));
          PK_PRIMENJEN_ALGORITAM.setPrefWidth(60);
          PK_PRIMENJEN_ALGORITAM.setText("algoritam");*/
        
          PK_OPIS=new TableColumn ("PK_OPIS");
          PK_OPIS.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,String>("opis"));
       /*   
          PK_PREPORUCENA=new TableColumn ("PK_PREPORUCENA");
          PK_PREPORUCENA.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,BigDecimal>("preporucena"));
          PK_PREPORUCENA.setPrefWidth(100);
          PK_PREPORUCENA.setText("preporucena");
          
          PK_PREPOR_BEZ_KOEF=new TableColumn ("PK_PREPOR_BEZ_KOEF");
          PK_PREPOR_BEZ_KOEF.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,BigDecimal>("preporBezKoef"));
          PK_PREPOR_BEZ_KOEF.setPrefWidth(120);
          PK_PREPOR_BEZ_KOEF.setText("prepor bez koef");
          
          PK_CENA=new TableColumn ("PK_CENA");
          PK_CENA.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,BigDecimal>("cena"));
          PK_CENA.setPrefWidth(85);
          PK_CENA.setText("cena");*/
     
          PK_ROBNA_GRUPA=new TableColumn ("PK_ROBNA_GRUPA");
          PK_ROBNA_GRUPA.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKol,String>("robnaGrupa"));
          PK_ROBNA_GRUPA.setPrefWidth(150);
          PK_ROBNA_GRUPA.setText("robna grupa");
      
          
           
          tblPreporKol.getColumns().setAll(PK_ARTIKAL,PK_SIFRA,PK_NAZIV,PK_SREDJENA_KOL,
                           /* PK_PRIMENJEN_ALGORITAM,PK_PREPORUCENA,PK_PREPOR_BEZ_KOEF,PK_CENA,*/PK_ROBNA_GRUPA,PK_ORGJED,PK_NAZIV_ORGJED,/*PK_ID_AKCIJE,PK_ID_KAMPANJE,*/PK_OPIS,PK_ID);
       System.out.println("Prosao do 3");
          tblPreporKol.setItems(PK_data);
    }
     
     
     //SADA  za analitiku
      public void listaPreporKolTemp(Integer i) {
        em.clear();
        
        Long v_id; String v_sifra,v_orgjed;
      //  data.get(tabela.getSelectionModel().getSelectedIndex()).getId()
        
        v_id=PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getId();
        v_sifra=PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getSifra();
        v_orgjed=PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getOrgjed();
        
          List<BVMpAkcPreporKolTemp>  results =  em.createNamedQuery("BVMpAkcPreporKolTemp.findById")
                  .setParameter("id", /*i*/v_id)
                  .setParameter("sifra", v_sifra)
                  .setParameter("orgjed", v_orgjed)
                  .getResultList();
          PKT_data = FXCollections.observableArrayList(results);
          
           
          PKT_ID=new TableColumn ("PKT_ID");
          PKT_ID.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKolTemp,Integer>("id"));
          
          PKT_ID_AKCIJE=new TableColumn ("PKT_ID_AKCIJE");
          PKT_ID_AKCIJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKolTemp,Long>("idAkcije"));
          PKT_ID_AKCIJE.setPrefWidth(90);
          PKT_ID_AKCIJE.setText("id akcije"); 
          
          PKT_ID_KAMPANJE=new TableColumn ("PKT_ID_KAMPANJE");
          PKT_ID_KAMPANJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKolTemp,String>("idKampanje"));
          PKT_ID_KAMPANJE.setPrefWidth(90);
          PKT_ID_KAMPANJE.setText("id kampanje"); 
          
          PKT_ORGJED=new TableColumn ("PKT_ORGJED");
          PKT_ORGJED.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKolTemp,String>("orgjed"));
          PKT_ORGJED.setPrefWidth(30);
          PKT_ORGJED.setText("OJ"); 
          
          PKT_NAZIV_ORGJED=new TableColumn ("PKT_NAZIV_ORGJED");
          PKT_NAZIV_ORGJED.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKolTemp,String>("nazivOrgjed"));
          PKT_NAZIV_ORGJED.setPrefWidth(120);
          PKT_NAZIV_ORGJED.setText("OJ naziv"); 
          
          PKT_ARTIKAL=new TableColumn ("PKT_ARTIKAL");
          PKT_ARTIKAL.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKolTemp,Long>("artikal"));
          PKT_ARTIKAL.setPrefWidth(60);
          PKT_ARTIKAL.setText("id artikla"); 
          
          PKT_SIFRA=new TableColumn ("PKT_SIFRA");
          PKT_SIFRA.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKolTemp,String>("sifra"));
          PKT_SIFRA.setPrefWidth(60);
          PKT_SIFRA.setText("sifra art");
          
          PKT_NAZIV=new TableColumn ("PKT_NAZIV");
          PKT_NAZIV.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKolTemp,String>("naziv"));
          PKT_NAZIV.setPrefWidth(200);
          PKT_NAZIV.setText("naziv artikla");
           
          PKT_PRIMENJEN_ALGORITAM=new TableColumn ("PKT_PRIMENJEN_ALGORITAM");
          PKT_PRIMENJEN_ALGORITAM.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKolTemp,Integer>("primenjenAlgoritam"));
          PKT_PRIMENJEN_ALGORITAM.setPrefWidth(60);
          PKT_PRIMENJEN_ALGORITAM.setText("algoritam");
          
          PKT_OPIS=new TableColumn ("PKT_OPIS");
          PKT_OPIS.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKolTemp,String>("opis"));
          
          PKT_PREPORUCENA=new TableColumn ("PKT_PREPORUCENA");
          PKT_PREPORUCENA.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKolTemp,BigDecimal>("preporucena"));
          PKT_PREPORUCENA.setPrefWidth(100);
          PKT_PREPORUCENA.setText("preporucena");
          
          PKT_PREPOR_BEZ_KOEF=new TableColumn ("PKT_PREPOR_BEZ_KOEF");
          PKT_PREPOR_BEZ_KOEF.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKolTemp,BigDecimal>("preporBezKoef"));
          PKT_PREPOR_BEZ_KOEF.setPrefWidth(120);
          PKT_PREPOR_BEZ_KOEF.setText("prepor bez koef");
          
          PKT_CENA=new TableColumn ("PKT_CENA");
          PKT_CENA.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKolTemp,BigDecimal>("cena"));
          PKT_CENA.setPrefWidth(85);
          PKT_CENA.setText("cena");
     
          PKT_ROBNA_GRUPA=new TableColumn ("PKT_ROBNA_GRUPA");
          PKT_ROBNA_GRUPA.setCellValueFactory(new PropertyValueFactory<BVMpAkcPreporKolTemp,String>("robnaGrupa"));
          PKT_ROBNA_GRUPA.setPrefWidth(150);
          PKT_ROBNA_GRUPA.setText("robna grupa");
      
          
          
          tblPreporKolTemp.getColumns().setAll(PKT_ARTIKAL,PKT_SIFRA,PKT_NAZIV,
                            PKT_PRIMENJEN_ALGORITAM,PKT_PREPORUCENA,PKT_PREPOR_BEZ_KOEF,PKT_CENA,PKT_ROBNA_GRUPA,PKT_ORGJED,PKT_NAZIV_ORGJED,PKT_ID_AKCIJE,PKT_ID_KAMPANJE,PKT_OPIS,PKT_ID);
     
          tblPreporKolTemp.setItems(PKT_data);
    }
    
     
     
     
     public void listaRadnji(Integer i) {
           em.clear();
          List<String>  results =  em.createNamedQuery("BVMpvAkcijeArtikli.razliciteRadnje")
                  .setParameter("id", i)
                  .getResultList();
 
          ObservableList<String> items =FXCollections.observableArrayList (results);
          listaRadnji.setItems(items);
        
          
           DT_P_radnja.setItems(items);
           PK_P_radnja.setItems(items);
          cmb_find_matrica_dop.setItems(items);
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
      
        public void listaRadnjiPrvoPunjenje(Integer i) {
           em.clear();
          List<String>  results =  em.createNamedQuery("BVMpAkcTrebovanje.spisakRadnji")
                  .setParameter("id", i)
                  .getResultList();
 
          ObservableList<String> items =FXCollections.observableArrayList (results);
       /*   DT_P_radnja.setItems(items);
          PK_P_radnja.setItems(items);*/
          PP_P_radnja.setItems(items);
        
     }
      
    public void listaAlgoritama(Integer i) {
           em.clear();
          List<Integer>  results =  em.createNamedQuery("BVMpAkcPreporKol.Algoritmi")
                  .setParameter("id", i)
                  .getResultList();
 
          ObservableList<Integer> items =FXCollections.observableArrayList ( results);
         PK_P_algoritam.setItems(items);
         
        
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
     public void pretragaDopunskihTrebovanja () 
     {
           em.clear();
           Date date1 = Date.from(DT_P_datum_od.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
           Date date2 = Date.from(DT_P_datum_do.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
         
           
           String v_cmb_radnja;
           if (DT_P_radnja.getValue() == null) v_cmb_radnja="%%";
           else  v_cmb_radnja="%"+DT_P_radnja.getValue()+"%";
           
           String v_cmb_mag;
           if (DT_P_MAGACIN.getValue() == null) v_cmb_mag="%%";
           else  v_cmb_mag="%"+DT_P_MAGACIN.getValue()+"%";
           
           Integer v_cmb_brDop;
         try {
             if (DT_P_broj_dopune.getValue().toString() == "") {
                 v_cmb_brDop = -1;
             } else {
                 v_cmb_brDop = Integer.parseInt(DT_P_broj_dopune.getValue().toString());
             }             
         } catch (Exception exception) {
              v_cmb_brDop = -1;
         }
           
           Integer v_id_artikla;
           if (DT_P_id_artikla.getText().isEmpty() ) v_id_artikla=-1;
           else  v_id_artikla=Integer.parseInt(DT_P_id_artikla.getText()); 
           
           
          List<BVMpvAkcDopunskaTrebovanj>  results =  em.createNamedQuery("BVMpvAkcDopunskaTrebovanj.Pretraga")
                  .setParameter("id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId())
                  .setParameter("nazivArtikla", "%"+DT_P_naziv_artikla.getText().toUpperCase()+"%")
                  .setParameter("sifra","%"+ DT_P_sifra.getText()+"%")
                  .setParameter("datOd", date1)
                  .setParameter("datDo", date2)
                  .setParameter("radnja",v_cmb_radnja)
                  .setParameter("magacin", v_cmb_mag)
                  .setParameter("brojDopune", v_cmb_brDop)
                  .setParameter("idArtikla", v_id_artikla)
                  .getResultList();
          DT_data = FXCollections.observableArrayList(results);       
  
          DT_ID_ARTIKLA=new TableColumn ("DT_ID_ARTIKLA");
          DT_ID_ARTIKLA.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,Long>("idArtikla"));
          DT_ID_ARTIKLA.setPrefWidth(80);
          DT_ID_ARTIKLA.setText("id artikla"); 
          
          DT_BROJ_DOPUNE=new TableColumn ("DT_BROJ_DOPUNE");
          DT_BROJ_DOPUNE.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,Integer>("brojDopune"));
          DT_BROJ_DOPUNE.setPrefWidth(80);
          DT_BROJ_DOPUNE.setText("dopuna");
        
          DT_ORGJED=new TableColumn ("DT_ORGJED");
          DT_ORGJED.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,String>("orgjed"));
          DT_ORGJED.setPrefWidth(30);
          DT_ORGJED.setText("OJ");
                  
          
          DT_RADNJA=new TableColumn ("DT_RADNJA");
          DT_RADNJA.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,String>("radnja"));
          DT_RADNJA.setPrefWidth(120);
          DT_RADNJA.setText("OJ naziv"); 
          
          DT_SIFRA=new TableColumn ("DT_SIFRA");
          DT_SIFRA.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,String>("sifra"));
          DT_SIFRA.setPrefWidth(80);
          DT_SIFRA.setText("šifra artikla"); 
          
          DT_NAZIV_ARTIKLA=new TableColumn ("DT_NAZIV_ARTIKLA");
          DT_NAZIV_ARTIKLA.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,String>("nazivArtikla"));
          DT_NAZIV_ARTIKLA.setPrefWidth(200);
          DT_NAZIV_ARTIKLA.setText("naziv artikla");
                  
          DT_MAGACIN=new TableColumn ("DT_MAGACIN");
          DT_MAGACIN.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,String>("magacin"));
          DT_MAGACIN.setPrefWidth(30);
          DT_MAGACIN.setText("DC");
          
          DT_DATUM=new TableColumn ("DT_DATUM");
          DT_DATUM.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,Date>("datum"));
          DT_DATUM.setPrefWidth(80);
          DT_DATUM.setText("datum");
          
          DT_MULTIFAKTOR=new TableColumn ("DT_MULTIFAKTOR");
          DT_MULTIFAKTOR.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,BigDecimal>("multifaktor"));
          DT_MULTIFAKTOR.setPrefWidth(30);
          DT_MULTIFAKTOR.setText("MF");
          
          DT_ZALIHA=new TableColumn ("DT_ZALIHA");
          DT_ZALIHA.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,BigDecimal>("zaliha"));
          DT_ZALIHA.setPrefWidth(60);
          DT_ZALIHA.setText("zaliha");
          
         /* DT_PRODAJA=new TableColumn ("DT_PRODAJA");
          DT_PRODAJA.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,BigDecimal>("prodaja"));
          DT_PRODAJA.setPrefWidth(60);
          DT_PRODAJA.setText("prodaja");*/
         
          DT_DATUM_ZALIHE=new TableColumn ("DT_DATUM_ZALIHE");
          DT_DATUM_ZALIHE.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,Date>("datumZalihe"));
          DT_DATUM_ZALIHE.setPrefWidth(80);
          DT_DATUM_ZALIHE.setText("dat zal");
          
          DT_PREPOR_KOL_DO_ISPORUKE=new TableColumn ("DT_PREPOR_KOL_DO_ISPORUKE");
          DT_PREPOR_KOL_DO_ISPORUKE.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,BigDecimal>("preporKolDoIsporuke"));
          DT_PREPOR_KOL_DO_ISPORUKE.setPrefWidth(100);
          DT_PREPOR_KOL_DO_ISPORUKE.setText("kol do isp");
          
          DT_PREPOR_KOL_PERIOD=new TableColumn ("DT_PREPOR_KOL_PERIOD");
          DT_PREPOR_KOL_PERIOD.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,BigDecimal>("preporKolPeriod"));
          DT_PREPOR_KOL_PERIOD.setPrefWidth(100);
          DT_PREPOR_KOL_PERIOD.setText("kol-period");
         
          DT_NESREDJENA_KOLICINA=new TableColumn ("DT_NESREDJENA_KOLICINA");
          DT_NESREDJENA_KOLICINA.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,BigDecimal>("nesredjenaKolicina"));
          DT_NESREDJENA_KOLICINA.setPrefWidth(120);
          DT_NESREDJENA_KOLICINA.setText("kol-nesredjeno");
          
          DT_SREDJENA_KOLCINA=new TableColumn ("DT_SREDJENA_KOLCINA");
          DT_SREDJENA_KOLCINA.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,BigDecimal>("sredjenaKolicina"));
          DT_SREDJENA_KOLCINA.setPrefWidth(120);
          DT_SREDJENA_KOLCINA.setText("kol-sredjeno");
          
          DT_PROJEKCIJA_OD=new TableColumn ("DT_PROJEKCIJA_OD");
          DT_PROJEKCIJA_OD.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,Date>("projekcijaOd"));
          DT_PROJEKCIJA_OD.setPrefWidth(120);
          DT_PROJEKCIJA_OD.setText("dat_projekcije_od");
          
          DT_PROJEKCIJA_DO=new TableColumn ("DT_PROJEKCIJA_DO");
          DT_PROJEKCIJA_DO.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,Date>("projekcijaDo"));
          DT_PROJEKCIJA_DO.setPrefWidth(120);
          DT_PROJEKCIJA_DO.setText("dat_projekcije_do");
          
          DT_RG_ROOT=new TableColumn ("DT_RG_ROOT");
          DT_RG_ROOT.setCellValueFactory(new PropertyValueFactory<BVMpAkcDopunskaTrebovanja,String>("rgRoot"));
           
          tblDopunskaTrebovanja.getColumns().setAll(DT_ORGJED,DT_RADNJA,DT_ID_ARTIKLA,DT_SIFRA,DT_NAZIV_ARTIKLA,
                                  DT_BROJ_DOPUNE,DT_MAGACIN,DT_DATUM,DT_MULTIFAKTOR,DT_ZALIHA,DT_DATUM_ZALIHE,
                                  DT_PREPOR_KOL_DO_ISPORUKE,DT_PREPOR_KOL_PERIOD,DT_NESREDJENA_KOLICINA,
                                  DT_SREDJENA_KOLCINA,/*DT_PRODAJA,*/DT_PROJEKCIJA_OD,DT_PROJEKCIJA_DO,DT_RG_ROOT
                                  );
       //   tblDopunskaTrebovanja.getColumns().set(0, DT_ID_ARTIKLA);
     
          tblDopunskaTrebovanja.setItems(DT_data);
   
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
     public void obrisiPretraguPrvoPunjenje ()
     {
         PP_P_id_artikla.setText("");
         PP_P_sifra.setText("");
         PP_P_naziv_artikla.setText("");
         PP_P_radnja.setValue("");

     }
     
     @FXML
     public void pozoviAnalitiku() 
     {
      //   tabPaneAnalitika.show;
         txtAreaOpisAnalitika.setText("");
         SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
         selectionModel.select(tabAnalitika);
         listaPreporKolTemp(data.get(tabela.getSelectionModel().getSelectedIndex()).getId().intValue());
                 
     }
     
     @FXML
     public void obracun() {
         
           try {
             String v_status = data.get(tabela.getSelectionModel().getSelectedIndex()).getStatus(); 
             System.out.println(v_status);
             if ((v_status.equals("O")) || (v_status.equals("R"))) {                 
                 if (tabela.getSelectionModel().getSelectedItem() != null) {                     
                     
                     em.getTransaction().begin();
                     StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mp_akc_glavna_start");
                     
                     storedprocedure1.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
                     storedprocedure1.setParameter("p_id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
                     
                     storedprocedure1.execute();
                     em.getTransaction().commit();
                     
                     Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                     alert1.setTitle("Information Dialog");
                     alert1.setHeaderText("Obracun preporuka ");
                     alert1.setContentText("Uradjen je obracun za odabranu akciju");
                     alert1.showAndWait();
                     
                 } else {
                     Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                     alert1.setTitle("Information Dialog");
                     alert1.setHeaderText("Greska!");
                     alert1.setContentText("Prvo selektujte akciju");
                     alert1.showAndWait();
                 }
             } else {
                 Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                 alert1.setTitle("Information Dialog");
                 alert1.setHeaderText("Greska!");
                 alert1.setContentText("Status nije O ili R. Ne mozete menjati odabrane akcije!");
                 alert1.showAndWait();
             }             
             
         } catch (Exception e) {
              Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                     alert1.setTitle("Information Dialog");
                     alert1.setHeaderText("Greska!");
                     alert1.setContentText("Prvo selektujte akciju");
                     alert1.showAndWait();
         }
        /*  em.getTransaction().begin();
        StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mp_akc_glavna_start");
        
        storedprocedure1.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
        storedprocedure1.execute();
        em.getTransaction().commit();*/
     }
     
       public void listaNedostajuci(Integer i) {
            
        em.clear();
          List<BVMpAkcNedostajuciArtikli>  results =  em.createNamedQuery("BVMpAkcNedostajuciArtikli.findById")
                  .setParameter("id", i)
                  .getResultList();
          NA_data = FXCollections.observableArrayList(results);
          
           
          NA_ID=new TableColumn ("NA_ID");
          NA_ID.setCellValueFactory(new PropertyValueFactory<BVMpAkcNedostajuciArtikli,Integer>("id"));
          
          NA_ID_AKCIJE=new TableColumn ("NA_ID_AKCIJE");
          NA_ID_AKCIJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcNedostajuciArtikli,Long>("idAkcije"));
          NA_ID_AKCIJE.setPrefWidth(90);
          NA_ID_AKCIJE.setText("id akcije"); 
          
          NA_ID_KAMPANJE=new TableColumn ("NA_ID_KAMPANJE");
          NA_ID_KAMPANJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcNedostajuciArtikli,String>("idKampanje"));
          NA_ID_KAMPANJE.setPrefWidth(120);
          NA_ID_KAMPANJE.setText("id kampanje"); 
          
          NA_ORGJED=new TableColumn ("NA_ORGJED");
          NA_ORGJED.setCellValueFactory(new PropertyValueFactory<BVMpAkcNedostajuciArtikli,String>("orgjed"));
          NA_ORGJED.setPrefWidth(30);
          NA_ORGJED.setText("OJ"); 
          
          
          NA_ARTIKAL=new TableColumn ("NA_ARTIKAL");
          NA_ARTIKAL.setCellValueFactory(new PropertyValueFactory<BVMpAkcNedostajuciArtikli,Long>("artikal"));
          NA_ARTIKAL.setPrefWidth(100);
          NA_ARTIKAL.setText("id artikla"); 
          
          NA_SIFRA=new TableColumn ("NA_SIFRA");
          NA_SIFRA.setCellValueFactory(new PropertyValueFactory<BVMpAkcNedostajuciArtikli,String>("sifra"));
          NA_SIFRA.setPrefWidth(60);
          NA_SIFRA.setText("sifra art");
          
          NA_NAZIV=new TableColumn ("NA_NAZIV");
          NA_NAZIV.setCellValueFactory(new PropertyValueFactory<BVMpAkcNedostajuciArtikli,String>("naziv"));
          NA_NAZIV.setPrefWidth(340);
          NA_NAZIV.setText("naziv artikla");
          
                             
          
          
          tblPNedostajuciArtikli.getColumns().setAll(NA_ID_AKCIJE,NA_ID_KAMPANJE,NA_ORGJED,NA_ARTIKAL,NA_SIFRA,NA_NAZIV);
     
          tblPNedostajuciArtikli.setItems(NA_data);
   
}
       
         public void listaErrorLog(Integer i) {
            
        em.clear();
          List<BVMpAkcErrorLog>  results =  em.createNamedQuery("BVMpAkcErrorLog.findById")
                  .setParameter("id", i)
                  .getResultList();
          ER_data = FXCollections.observableArrayList(results);
          
           
          ER_ID=new TableColumn ("ER_ID");
          ER_ID.setCellValueFactory(new PropertyValueFactory<BVMpAkcErrorLog,Integer>("id"));
          
          ER_ID_AKCIJE=new TableColumn ("ER_ID_AKCIJE");
          ER_ID_AKCIJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcErrorLog,Long>("idAkcije"));
          ER_ID_AKCIJE.setPrefWidth(90);
          ER_ID_AKCIJE.setText("id akcije"); 
          
          ER_ID_KAMPANJE=new TableColumn ("ER_ID_KAMPANJE");
          ER_ID_KAMPANJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcErrorLog,String>("idKampanje"));
          ER_ID_KAMPANJE.setPrefWidth(90);
          ER_ID_KAMPANJE.setText("id kampanje"); 
          
           
          ER_ARTIKAL=new TableColumn ("ER_ARTIKAL");
          ER_ARTIKAL.setCellValueFactory(new PropertyValueFactory<BVMpAkcErrorLog,Long>("idArtikla"));
          ER_ARTIKAL.setPrefWidth(60);
          ER_ARTIKAL.setText("id artikla"); 
          
          ER_SIFRA=new TableColumn ("ER_SIFRA");
          ER_SIFRA.setCellValueFactory(new PropertyValueFactory<BVMpAkcErrorLog,String>("sifra"));
          ER_SIFRA.setPrefWidth(60);
          ER_SIFRA.setText("sifra art");
          
          ER_NAZIV=new TableColumn ("ER_NAZIV");
          ER_NAZIV.setCellValueFactory(new PropertyValueFactory<BVMpAkcErrorLog,String>("naziv"));
          ER_NAZIV.setPrefWidth(280);
          ER_NAZIV.setText("naziv artikla");
          
          ER_KOLONA1=new TableColumn ("ER_KOLONA1");
          ER_KOLONA1.setCellValueFactory(new PropertyValueFactory<BVMpAkcErrorLog,String>("kolona1"));
          ER_KOLONA1.setPrefWidth(260);
          ER_KOLONA1.setText("kolona1");

          ER_KOLONA2=new TableColumn ("ER_KOLONA2");
          ER_KOLONA2.setCellValueFactory(new PropertyValueFactory<BVMpAkcErrorLog,String>("kolona2"));
          ER_KOLONA2.setPrefWidth(260);
          ER_KOLONA2.setText("kolona2");
          
          ER_KOLONA3=new TableColumn ("ER_KOLONA3");
          ER_KOLONA3.setCellValueFactory(new PropertyValueFactory<BVMpAkcErrorLog,String>("kolona3"));
          ER_KOLONA3.setPrefWidth(260);
          ER_KOLONA3.setText("kolona3");
          
          
          tblErrorLog.getColumns().setAll(ER_ID_AKCIJE,ER_ID_KAMPANJE,ER_ARTIKAL,ER_SIFRA,ER_NAZIV,ER_KOLONA1,ER_KOLONA2,ER_KOLONA3);
     
          tblErrorLog.setItems(ER_data);
   
}
         
         
           @FXML
    public void pozoviReport() throws SQLException, JRException {
        
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        
        HashMap param1=new HashMap();
        param1.put("P_ID",data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
        String reportPath ="E:\\Akc_treb_pracenje.jrxml";
        JasperReport jr=JasperCompileManager.compileReport(reportPath);
        JasperPrint jp = JasperFillManager.fillReport(jr, param1,con);
        JasperViewer.viewReport(jp,false);
        con.close();
        
    }
    
      @FXML
    public void pozoviReportIsporukePoDC() throws SQLException, JRException {
        
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        
        HashMap param1=new HashMap();
        param1.put("P_ID",data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
      // String reportPath ="E:\\Preporuka_po_dc.jrxml";
        String reportPath ="Preporuka_po_dc.jrxml";
        JasperReport jr=JasperCompileManager.compileReport(reportPath);
        JasperPrint jp = JasperFillManager.fillReport(jr, param1,con);
        JasperViewer.viewReport(jp,false);
        con.close();
        
    }
    
    @FXML
    public void pozoviReportPoredjenjePlanograma() throws SQLException, JRException {
        
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        
        HashMap param1=new HashMap();
        param1.put("P_ID",data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
      // String reportPath ="E:\\Preporuka_po_dc.jrxml";
        String reportPath ="Uporedi_planograme_i_prepor_kol.jrxml";
        JasperReport jr=JasperCompileManager.compileReport(reportPath);
        JasperPrint jp = JasperFillManager.fillReport(jr, param1,con);
        JasperViewer.viewReport(jp,false);
        con.close();
        
    }
    
    
       @FXML
    public void pozoviReportKriticneSekundarne() throws SQLException, JRException {
        
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        
        HashMap param1=new HashMap();
        param1.put("P_ID",data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
      // String reportPath ="E:\\Preporuka_po_dc.jrxml";
        String reportPath ="AT-kriticne sekundarne pozicjie.jrxml";
        JasperReport jr=JasperCompileManager.compileReport(reportPath);
        JasperPrint jp = JasperFillManager.fillReport(jr, param1,con);
        JasperViewer.viewReport(jp,false);
        con.close();
        
    }
    
        @FXML
    public void pozoviReportPoredjenjeMF() throws SQLException, JRException {
        
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        
        HashMap param1=new HashMap();
        param1.put("P_ID",data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
      // String reportPath ="E:\\Preporuka_po_dc.jrxml";
        String reportPath ="Uporedi_multifaktore_i_prepor_kol.jrxml";
        JasperReport jr=JasperCompileManager.compileReport(reportPath);
        JasperPrint jp = JasperFillManager.fillReport(jr, param1,con);
        JasperViewer.viewReport(jp,false);
        con.close();
        
    }
    
         @FXML
    public void pozoviReportNeposlatiArtikli() throws SQLException, JRException {
        
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        
        HashMap param1=new HashMap();
        param1.put("p_id_akcije",data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
      // String reportPath ="E:\\Preporuka_po_dc.jrxml";
        String reportPath ="AT-neposlate instance.jrxml";
        JasperReport jr=JasperCompileManager.compileReport(reportPath);
        JasperPrint jp = JasperFillManager.fillReport(jr, param1,con);
        JasperViewer.viewReport(jp,false);
        con.close();
        
    }
    
 @FXML
     
 
 
 
 
 
 public void listaPrvoPunjenjeFilter() {
             
     
     
 if ((tabela.getSelectionModel().getSelectedIndex()>-1)  )
   {
          
      
     String v_cmb_radnja;
           if (PP_P_radnja.getValue() == null) v_cmb_radnja="%%";
           else  v_cmb_radnja="%"+PP_P_radnja.getValue()+"%";
           
            Integer v_cmb_algoritam;
       
        
           
           Long v_id_artikla;
         try {
             if (PP_P_id_artikla.getText().isEmpty()) {
                 v_id_artikla = Long.valueOf("-1");
             } else {
                 v_id_artikla = Long.parseLong(PP_P_id_artikla.getText());
             }             
         } catch (Exception exception) {
              v_id_artikla = Long.valueOf("-1");
         }
         
        // v_id_artikla=Long.valueOf("-1");
        em.clear();
          List<BVMpAkcTrebovanje>  results =  em.createNamedQuery("BVMpAkcTrebovanje.findPretraga")
                  .setParameter("id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId())
                  .setParameter("idArtikla", v_id_artikla)
                  .setParameter("sifra","%" + PP_P_sifra.getText()+"%")
                  .setParameter("nazivArtikla","%" +PP_P_naziv_artikla.getText().toUpperCase()+"%")
                  .setParameter("ojNaziv", v_cmb_radnja)
                //  .setParameter("robnaGrupa","%" + PK_P_RG.getText().toUpperCase()+"%")
                    
                  .getResultList();
          PP_data = FXCollections.observableArrayList(results);
          
           
          PP_ID=new TableColumn ("PP_ID");
          PP_ID.setCellValueFactory(new PropertyValueFactory<BVMpAkcTrebovanje,Integer>("id"));
          
          PP_ID_AKCIJE=new TableColumn ("PP_ID_AKCIJE");
          PP_ID_AKCIJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcTrebovanje,Long>("idAkcije"));
          PP_ID_AKCIJE.setPrefWidth(90);
          PP_ID_AKCIJE.setText("id akcije"); 
          
          PP_ID_KAMPANJE=new TableColumn ("PP_ID_KAMPANJE");
          PP_ID_KAMPANJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcTrebovanje,String>("idKampanje"));
          PP_ID_KAMPANJE.setPrefWidth(90);
          PP_ID_KAMPANJE.setText("id kampanje"); 
          
          PP_ORGJED=new TableColumn ("PP_ORGJED");
          PP_ORGJED.setCellValueFactory(new PropertyValueFactory<BVMpAkcTrebovanje,String>("orgjed"));
          PP_ORGJED.setPrefWidth(30);
          PP_ORGJED.setText("OJ"); 
          
          PP_NAZIV_ORGJED=new TableColumn ("PP_NAZIV_ORGJED");
          PP_NAZIV_ORGJED.setCellValueFactory(new PropertyValueFactory<BVMpAkcTrebovanje,String>("ojNaziv"));
          PP_NAZIV_ORGJED.setPrefWidth(120);
          PP_NAZIV_ORGJED.setText("OJ naziv"); 
         
          PP_ARTIKAL=new TableColumn ("PP_ARTIKAL");
          PP_ARTIKAL.setCellValueFactory(new PropertyValueFactory<BVMpAkcTrebovanje,Long>("idArtikla"));
          PP_ARTIKAL.setPrefWidth(60);
          PP_ARTIKAL.setText("id artikla"); 
       
          PP_SIFRA=new TableColumn ("PP_SIFRA");
          PP_SIFRA.setCellValueFactory(new PropertyValueFactory<BVMpAkcTrebovanje,String>("sifra"));
          PP_SIFRA.setPrefWidth(60);
          PP_SIFRA.setText("sifra art");
          
          PP_NAZIV=new TableColumn ("PP_NAZIV");
          PP_NAZIV.setCellValueFactory(new PropertyValueFactory<BVMpAkcTrebovanje,String>("nazivArtikla"));
          PP_NAZIV.setPrefWidth(200);
          PP_NAZIV.setText("naziv artikla");
           
          PP_MAGACIN=new TableColumn ("PP_MAGACIN");
          PP_MAGACIN.setCellValueFactory(new PropertyValueFactory<BVMpAkcTrebovanje,String>("magacin"));
          PP_MAGACIN.setPrefWidth(80);
          PP_MAGACIN.setText("magacina");
          
          
          PP_SREDJENA_KOL=new TableColumn ("PP_SREDJENA_KOL");
          PP_SREDJENA_KOL.setCellValueFactory(new PropertyValueFactory<>("sredjenaKolicina"));
          PP_SREDJENA_KOL.setPrefWidth(100);
          PP_SREDJENA_KOL.setText("sredjena kolicina");
          
          PP_NABAVLJAM_KOL=new TableColumn ("PP_NABAVLJAM_KOL");
          PP_NABAVLJAM_KOL.setCellValueFactory(new PropertyValueFactory<>("nabavljamKolicinu"));
          PP_NABAVLJAM_KOL.setPrefWidth(100);
          PP_NABAVLJAM_KOL.setText("nabavljam kol");
          
          PP_MULTIFAKTOR=new TableColumn ("PP_MULTIFAKTOR");
          PP_MULTIFAKTOR.setCellValueFactory(new PropertyValueFactory<>("multifaktor"));
          PP_MULTIFAKTOR.setPrefWidth(60);
          PP_MULTIFAKTOR.setText("MF");
          
          PP_PREPORUCENA_KOL_UK=new TableColumn ("PP_PREPORUCENA_KOL_UK");
          PP_PREPORUCENA_KOL_UK.setCellValueFactory(new PropertyValueFactory<>("preporucenaKolUk"));
          PP_PREPORUCENA_KOL_UK.setPrefWidth(120);
          PP_PREPORUCENA_KOL_UK.setText("prepor uk");
          
          PP_PREPORUCENA_KOL=new TableColumn ("PP_PREPORUCENA_KOL");
          PP_PREPORUCENA_KOL.setCellValueFactory(new PropertyValueFactory<>("preporucenaKol"));
          PP_PREPORUCENA_KOL.setPrefWidth(120);
          PP_PREPORUCENA_KOL.setText("prepor");
          
          PP_SEK_POZICIJA=new TableColumn ("PP_SEK_POZICIJA");
          PP_SEK_POZICIJA.setCellValueFactory(new PropertyValueFactory<>("sekundarnaPozicija"));
          PP_SEK_POZICIJA.setPrefWidth(120);
          PP_SEK_POZICIJA.setText("sekund poz");
          
          
          PP_ZALIHA=new TableColumn ("PP_ZALIHA");
          PP_ZALIHA.setCellValueFactory(new PropertyValueFactory<>("zaliha"));
          PP_ZALIHA.setPrefWidth(120);
          PP_ZALIHA.setText("zaliha");
          
          PP_DATUM=new TableColumn ("PP_DATUM");
          PP_DATUM.setCellValueFactory(new PropertyValueFactory<>("datum"));
          PP_DATUM.setPrefWidth(80);
          PP_DATUM.setText("datum");
          
          PP_OPIS=new TableColumn ("PP_OPIS");
          PP_OPIS.setCellValueFactory(new PropertyValueFactory<BVMpAkcTrebovanje,String>("opis"));
               
          tblPrvoPunjenje.getColumns().setAll(
                PP_DATUM,PP_ORGJED,PP_NAZIV_ORGJED,PP_MAGACIN,PP_ARTIKAL,PP_SIFRA,PP_NAZIV,
                PP_SREDJENA_KOL,PP_NABAVLJAM_KOL,PP_MULTIFAKTOR,PP_PREPORUCENA_KOL_UK,PP_PREPORUCENA_KOL,
                PP_SEK_POZICIJA,PP_ZALIHA,PP_ID,PP_ID_AKCIJE,PP_ID_KAMPANJE);
        
      
          tblPrvoPunjenje.setItems(PP_data);
    }
 
     else
                                               {
                                                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                                     alert.setTitle("PAŽNJA!");
                                                     alert.setHeaderText("Greška!");
                                                     alert.setContentText("Proverite da li ste uneli sve potrebne podatke?!");
                                                     alert.showAndWait();  
                                                }
 
 }
     
     @FXML
     public void pozoviAnalitikuArtikla() throws IOException {
      
        
      /*   
         JavaFXTemplate.param_OJ=PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getOrgjed();
         JavaFXTemplate.param_id=data.get(tabela.getSelectionModel().getSelectedIndex()).getId().intValue();
         JavaFXTemplate.param_id_artikla=PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getArtikal().intValue;
         JavaFXTemplate.param_OJ_naziv=PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getNazivOrgjed();
         JavaFXTemplate.param_Artikal_naziv=PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getNaziv();
         
          JavaFXTemplate.showAnalitikuArtikla();*/
     }
     
     @FXML
     public void pozoviAnalitikuArtIzDopTreb() throws IOException {
      
        
         
         JavaFXTemplate.param_OJ=DT_data.get(tblDopunskaTrebovanja.getSelectionModel().getSelectedIndex()).getOrgjed();
         JavaFXTemplate.param_id=data.get(tabela.getSelectionModel().getSelectedIndex()).getId().intValue();
         JavaFXTemplate.param_id_artikla=(int) DT_data.get(tblDopunskaTrebovanja.getSelectionModel().getSelectedIndex()).getIdArtikla();
         JavaFXTemplate.param_OJ_naziv=DT_data.get(tblDopunskaTrebovanja.getSelectionModel().getSelectedIndex()).getRadnja();
         JavaFXTemplate.param_Artikal_naziv=DT_data.get(tblDopunskaTrebovanja.getSelectionModel().getSelectedIndex()).getNazivArtikla();
         
          JavaFXTemplate.showAnalitikuArtikla();
     }
     
       @FXML
       public void azurirajMatricuRazvozaDopuna() {
       /*
       b_mp_akc_izmeni_matricu_dopune
   ( p_id in number,p_orgjed in varchar2,p_broj_dopune in number,p_magacin in varchar2,
     p_datum in date,p_poc_datum_projekcije in date,p_kraj_datum_projekcije in date)
           
*/
        //generisi matricu prvog punjenja
        em.getTransaction().begin();
        StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mp_akc_izmeni_matricu_dopune");
        
        storedprocedure1.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
        storedprocedure1.registerStoredProcedureParameter("p_orgjed", String.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_orgjed", RD_data.get(tblRazvozDopuna.getSelectionModel().getSelectedIndex()).getOrgjed());
        
        storedprocedure1.registerStoredProcedureParameter("p_broj_dopune", Integer.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_broj_dopune", RD_data.get(tblRazvozDopuna.getSelectionModel().getSelectedIndex()).getBrojDopune());
        
        storedprocedure1.registerStoredProcedureParameter("p_magacin", String.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_magacin", RD_data.get(tblRazvozDopuna.getSelectionModel().getSelectedIndex()).getMagacin());
        
        storedprocedure1.registerStoredProcedureParameter("p_datum", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_datum",  Date.from(izmDatum.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
      
        storedprocedure1.registerStoredProcedureParameter("p_poc_datum_projekcije", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_poc_datum_projekcije",Date.from(izmDatumOd.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    
        storedprocedure1.registerStoredProcedureParameter("p_kraj_datum_projekcije", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_kraj_datum_projekcije",Date.from(izmDatumDo.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        
          storedprocedure1.registerStoredProcedureParameter("p_poc_datum_projekcije2", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_poc_datum_projekcije2",Date.from(izmDatumOd2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    
        storedprocedure1.registerStoredProcedureParameter("p_kraj_datum_projekcije2", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_kraj_datum_projekcije2",Date.from(izmDatumDo2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        
        
        storedprocedure1.registerStoredProcedureParameter("p_poruka", String.class, ParameterMode.OUT);
       
        storedprocedure1.execute();

        String poruka=(String)storedprocedure1.getOutputParameterValue("p_poruka");
        em.getTransaction().commit();
        
       // int xx=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
      //  listaRazvozaDopuna(xx);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("info o izmeni");
               alert.setHeaderText("info o izmeni matrice dopune");
               alert.setContentText(poruka);
               alert.showAndWait(); 
        
        
      
   }   
       
       
     @FXML
     public void unesiNoviRazvozDopune() {
         /*
           @FXML DatePicker unosDatum;
      @FXML DatePicker unosDatumOd;
      @FXML DatePicker unosDatumDo;
         */
         
         em.getTransaction().begin();
        StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mp_akc_dodaj_dopunski_razvoz");
        
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
        
        storedprocedure1.registerStoredProcedureParameter("p_poc_datum_projekcije2", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_poc_datum_projekcije2",Date.from(unosDatumOd2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    
        storedprocedure1.registerStoredProcedureParameter("p_kraj_datum_projekcije2", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_kraj_datum_projekcije2",Date.from(unosDatumDo2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        
        
        storedprocedure1.registerStoredProcedureParameter("p_poruka", String.class, ParameterMode.OUT);
       
        storedprocedure1.execute();

        String poruka=(String)storedprocedure1.getOutputParameterValue("p_poruka");
        em.getTransaction().commit();
        
       // int xx=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
      //  listaRazvozaDopuna(xx);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("info o dopuni razvoza");
               alert.setHeaderText("info o dopuni razvoza");
               alert.setContentText(poruka);
               alert.showAndWait(); 
     }
     
     @FXML
     public void izmeniPrvoPunjenje() {
         /*
              @FXML Pane panePrvoPunjenje;
      @FXML DatePicker izm2Datum;
      @FXML DatePicker izm2DatumOd;
      @FXML DatePicker izm2DatumDo;
         */
         
            em.getTransaction().begin();
        StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mp_akc_izmeni_prvo_punjenje");
        
        storedprocedure1.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
        storedprocedure1.registerStoredProcedureParameter("p_orgjed", String.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_orgjed", RP_data.get(tblrazvozPrvoPunj.getSelectionModel().getSelectedIndex()).getOrgjed());
        
        storedprocedure1.registerStoredProcedureParameter("p_broj_dopune", Integer.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_broj_dopune", RP_data.get(tblrazvozPrvoPunj.getSelectionModel().getSelectedIndex()).getBrojDopune());
        
        storedprocedure1.registerStoredProcedureParameter("p_magacin", String.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_magacin", RP_data.get(tblrazvozPrvoPunj.getSelectionModel().getSelectedIndex()).getMagacin());
        
        storedprocedure1.registerStoredProcedureParameter("p_datum", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_datum",  Date.from(izm2Datum.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
      
        storedprocedure1.registerStoredProcedureParameter("p_poc_datum_projekcije", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_poc_datum_projekcije",Date.from(izm2DatumOd.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    
        storedprocedure1.registerStoredProcedureParameter("p_kraj_datum_projekcije", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_kraj_datum_projekcije",Date.from(izm2DatumDo.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        
        storedprocedure1.registerStoredProcedureParameter("p_poruka", String.class, ParameterMode.OUT);
       
        storedprocedure1.execute();

        String poruka=(String)storedprocedure1.getOutputParameterValue("p_poruka");
        em.getTransaction().commit();
        
       // int xx=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
      //  listaRazvozaDopuna(xx);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("info o izmeni prvog punjenja");
               alert.setHeaderText("info o izmeni matrice prvog punjenja");
               alert.setContentText(poruka.toUpperCase());
               alert.showAndWait(); 
         listaRazvozaPrvoPunjenje(data.get(tabela.getSelectionModel().getSelectedIndex()).getId().intValue());
        
     }
     
     @FXML
     public void kreirajExcelPreporuke() {
         
            String v_cmb_radnja;
           if (PK_P_radnja.getValue() == null) v_cmb_radnja="%%";
           else  v_cmb_radnja="%"+PK_P_radnja.getValue()+"%";
           
            Integer v_cmb_algoritam;
       
            try {
             if ("".equals(PK_P_algoritam.getValue().toString())) {
                 v_cmb_algoritam = -1;
             } else {
                 v_cmb_algoritam = Integer.parseInt(PK_P_algoritam.getValue().toString());
             }             
         } catch (Exception E) {
             v_cmb_algoritam = -1;
         }
           
           Long v_id_artikla;
         try {
             if (PK_P_id_artikla.getText().isEmpty()) {
                 v_id_artikla = Long.valueOf("-1");
             } else {
                 v_id_artikla = Long.parseLong(PK_P_id_artikla.getText());
             }             
         } catch (Exception exception) {
              v_id_artikla = Long.valueOf("-1");
         }
         
        // v_id_artikla=Long.valueOf("-1");
        em.clear();
          List<BVMpAkcPreporKol>  results_excel =  em.createNamedQuery("BVMpAkcPreporKol.filterPretraga")
                  .setParameter("id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId())
                  .setParameter("naziv","%" +PK_P_naziv_artikla.getText().toUpperCase()+"%")
                  .setParameter("sifra","%" + PK_P_sifra.getText()+"%")
                  .setParameter("nazivOrgjed", v_cmb_radnja)
                  .setParameter("robnaGrupa","%" + PK_P_RG.getText().toUpperCase()+"%")
                  .setParameter("primenjenAlgoritam", v_cmb_algoritam)
                  .setParameter("artikal", v_id_artikla)
                  .getResultList();
             
   try {       
               
    Workbook wb = new HSSFWorkbook();
    CreationHelper createhelper = wb.getCreationHelper();
    Sheet sheet = wb.createSheet("preporuka algoritma");
    Row row = null;
    Cell cell = null;
    
    //kreiraj zaglavlje dokument
    row = sheet.createRow(0);
            cell = row.createCell(0);
            cell.setCellValue((String) "ID ARTIKLA");
            cell = row.createCell(1);
            cell.setCellValue((String) "SIFRA ARTIKLA");
            cell = row.createCell(2);
            cell.setCellValue((String) "NAZIV ARTIKLA");
            cell = row.createCell(3);
            cell.setCellValue((String) "ALGORITAM");
            cell = row.createCell(4);
            cell.setCellValue((String) "PREPORUCENA");
            cell = row.createCell(5);
            cell.setCellValue((String) "CENA");
            cell = row.createCell(6);
            cell.setCellValue((String) "ROBNA GRUPA");
            cell = row.createCell(7);
            cell.setCellValue((String) "OJ");
            cell = row.createCell(8);
            cell.setCellValue((String) "OJ NAZIV");
            cell = row.createCell(9);
            cell.setCellValue((String) "ID AKCIJE ASW");
            cell = row.createCell(10);
            cell.setCellValue((String) "ID KAMPANJE");
           
         
    //kraj kreiranja zaglavlja
  
    for (int i=0;i<results_excel.size();i++) {
        row = sheet.createRow(i+1); //IDE 
      
             
            cell = row.createCell(0);
            cell.setCellValue((Long) results_excel.get(i).getArtikal());
            cell = row.createCell(1);
            cell.setCellValue((String) results_excel.get(i).getSifra());
            cell = row.createCell(2);
            cell.setCellValue((String) results_excel.get(i).getNaziv());
            cell = row.createCell(3);
            cell.setCellValue((Integer) results_excel.get(i).getPrimenjenAlgoritam());
            cell = row.createCell(4);
            cell.setCellValue((Double) results_excel.get(i).getPreporucena().doubleValue());
            cell = row.createCell(5);
            
    if (results_excel.get(i).getCena() != null)        cell.setCellValue((Double) results_excel.get(i).getCena().doubleValue());
            cell = row.createCell(6);
            cell.setCellValue((String) results_excel.get(i).getRobnaGrupa());
            cell = row.createCell(7);
            cell.setCellValue((String) results_excel.get(i).getOrgjed());
            cell = row.createCell(8);
            cell.setCellValue((String) results_excel.get(i).getNazivOrgjed());
            cell = row.createCell(9);
            cell.setCellValue((Long) results_excel.get(i).getIdAkcije());
            cell = row.createCell(10);
            cell.setCellValue((String) results_excel.get(i).getIdKampanje());
           
       
    
    }
            
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
Date date = new Date();
System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
    //String v_ime_fajla="E:\\Obracun stimulacija  "+dateFormat.format(date)+".xls";
  String v_ime_fajla="AT-preporuka  "+dateFormat.format(date)+".xls";
    
    FileOutputStream out = new FileOutputStream(v_ime_fajla/*"E:\\workbook.xls"*/);
    wb.write(out);
    out.close();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Kreiranje excel fajla");
               alert.setHeaderText("Kreiran je excel fajl");
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
     
     
     //sada excel fajl za dopunska trebovanja
      @FXML
     public void kreirajExcelDopuna() {
          em.clear();
           Date date1 = Date.from(DT_P_datum_od.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
           Date date2 = Date.from(DT_P_datum_do.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
         
           
           String v_cmb_radnja;
           if (DT_P_radnja.getValue() == null) v_cmb_radnja="%%";
           else  v_cmb_radnja="%"+DT_P_radnja.getValue()+"%";
           
           String v_cmb_mag;
           if (DT_P_MAGACIN.getValue() == null) v_cmb_mag="%%";
           else  v_cmb_mag="%"+DT_P_MAGACIN.getValue()+"%";
           
           Integer v_cmb_brDop;
         try {
             if (DT_P_broj_dopune.getValue().toString() == "") {
                 v_cmb_brDop = -1;
             } else {
                 v_cmb_brDop = Integer.parseInt(DT_P_broj_dopune.getValue().toString());
             }             
         } catch (Exception exception) {
              v_cmb_brDop = -1;
         }
           
           Integer v_id_artikla;
           if (DT_P_id_artikla.getText().isEmpty() ) v_id_artikla=-1;
           else  v_id_artikla=Integer.parseInt(DT_P_id_artikla.getText()); 
           
           
          List<BVMpvAkcDopunskaTrebovanj>  results_excel =  em.createNamedQuery("BVMpvAkcDopunskaTrebovanj.Pretraga")
                  .setParameter("id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId())
              
                  .setParameter("nazivArtikla", "%"+DT_P_naziv_artikla.getText().toUpperCase()+"%")
                  .setParameter("sifra","%"+ DT_P_sifra.getText()+"%")
                  .setParameter("datOd", date1)
                  .setParameter("datDo", date2)
                  .setParameter("radnja",v_cmb_radnja)
                  .setParameter("magacin", v_cmb_mag)
                  .setParameter("brojDopune", v_cmb_brDop)
                  .setParameter("idArtikla", v_id_artikla)
             
                  .getResultList();
             
   try {       
               
    Workbook wb = new HSSFWorkbook();
    CreationHelper createhelper = wb.getCreationHelper();
    Sheet sheet = wb.createSheet("dopuna trebovanja");
    Row row = null;
    Cell cell = null;
    
    //kreiraj zaglavlje dokument
    row = sheet.createRow(0);
            cell = row.createCell(0);
            cell.setCellValue((String) "OJ");
            cell = row.createCell(1);
            cell.setCellValue((String) "OJ NAZIV");
            cell = row.createCell(2);
            cell.setCellValue((String) "ID ARTIKLA");
            cell = row.createCell(3);
            cell.setCellValue((String) "ŠIFRA ARTIKLA");
            cell = row.createCell(4);
            cell.setCellValue((String) "NAZIV ARTIKLA");
            cell = row.createCell(5);
            cell.setCellValue((String) "DOPUNA");
            cell = row.createCell(6);
            cell.setCellValue((String) "DC");
            cell = row.createCell(7);
            cell.setCellValue((String) "DATUM");
            cell = row.createCell(8);
            cell.setCellValue((String) "MF");
            cell = row.createCell(9);
            cell.setCellValue((String) "ZALIHA");
            cell = row.createCell(10);
            cell.setCellValue((String) "DAT ZAL");
            cell = row.createCell(11);
            cell.setCellValue((String) "KOL DO ISPOR");
            cell = row.createCell(12);
            cell.setCellValue((String) "KOL PERIOD");
            cell = row.createCell(13);
            cell.setCellValue((String) "KOL NESREDJENO");
            cell = row.createCell(14);
            cell.setCellValue((String) "KOL SREDJENO");
            
            cell = row.createCell(15);
            cell.setCellValue((String) "DATUM PROJEKCIJE OD");
            
            cell = row.createCell(16);
            cell.setCellValue((String) "DATUM PROJEKCIJE DO");
            cell = row.createCell(17);
            cell.setCellValue((String) "RG ROOT");
          
           
            
           
         
    //kraj kreiranja zaglavlja
  
    for (int i=0;i<results_excel.size();i++) {
        row = sheet.createRow(i+1); //IDE 
      
             
            cell = row.createCell(0);
            cell.setCellValue((String) results_excel.get(i).getOrgjed());
            cell = row.createCell(1);
            cell.setCellValue((String) results_excel.get(i).getRadnja());
            cell = row.createCell(2);
            cell.setCellValue((Long) results_excel.get(i).getIdArtikla());
            cell = row.createCell(3);
            cell.setCellValue((String) results_excel.get(i).getSifra());
            cell = row.createCell(4);
            cell.setCellValue((String) results_excel.get(i).getNazivArtikla());
            cell = row.createCell(5);            
            cell.setCellValue((Integer) results_excel.get(i).getBrojDopune());
            cell = row.createCell(6);
            cell.setCellValue((String) results_excel.get(i).getMagacin());
            cell = row.createCell(7);
            cell.setCellValue((String) results_excel.get(i).getDatum());
            cell = row.createCell(8);
            cell.setCellValue((Double) results_excel.get(i).getMultifaktor().doubleValue());
            cell = row.createCell(9);
           if( results_excel.get(i).getZaliha()!= null)     cell.setCellValue((Double) results_excel.get(i).getZaliha().doubleValue());
            cell = row.createCell(10);
           if( results_excel.get(i).getDatumZalihe() !=null) cell.setCellValue((Date) results_excel.get(i).getDatumZalihe());
            cell = row.createCell(11);
     if (results_excel.get(i).getPreporKolDoIsporuke() != null)  cell.setCellValue((Double) results_excel.get(i).getPreporKolDoIsporuke().doubleValue());
            cell = row.createCell(12);
     if (results_excel.get(i).getPreporKolPeriod() != null)        cell.setCellValue((Double) results_excel.get(i).getPreporKolPeriod().doubleValue());
            cell = row.createCell(13);
     if (results_excel.get(i).getNesredjenaKolicina() != null)         cell.setCellValue((Double) results_excel.get(i).getNesredjenaKolicina().doubleValue());
            cell = row.createCell(14);
     if (results_excel.get(i).getSredjenaKolicina() != null)       cell.setCellValue((Double) results_excel.get(i).getSredjenaKolicina().doubleValue());
            cell = row.createCell(15);
            cell.setCellValue((String) results_excel.get(i).getProjekcijaOd());
            cell = row.createCell(16);
            cell.setCellValue((String) results_excel.get(i).getProjekcijaDo());
            cell = row.createCell(17);
            cell.setCellValue((String) results_excel.get(i).getRgRoot());
           
        
        // if (results_excel.get(i).getCena() != null)    
       
    
    }
            
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
Date date = new Date();
System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
    //String v_ime_fajla="E:\\Obracun stimulacija  "+dateFormat.format(date)+".xls";
  String v_ime_fajla="AT-dopuna  "+dateFormat.format(date)+".xls";
    
    FileOutputStream out = new FileOutputStream(v_ime_fajla/*"E:\\workbook.xls"*/);
    wb.write(out);
    out.close();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Kreiranje excel fajla");
               alert.setHeaderText("Kreiran je excel fajl dopune");
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
     
     
     
    @FXML
    public void zatvoriObracun() {
             if ((tabela.getSelectionModel().getSelectedIndex()>-1)  )
       {
              em.getTransaction().begin();
             
       List<BMpvAkcije> b  =  em.createNamedQuery( "BMpvAkcije.findById")
               .setParameter("id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId())
             
              // .setHint(QueryHints.MAINTAIN_CACHE, "false")
               .getResultList();

       
                if (!b.isEmpty())
                {
                 //   b.get(0).setKoefNeprehrana(new BigDecimal(txt_edit_koef_neprehrana.getText()));
                   try {
                 
              if ((b.get(0).getStatus().equals("R")) || (b.get(0).getStatus().equals("O")) )
                      {      
                       b.get(0).setStatus("Z");
                       
                       
                       
                     em.getTransaction().commit();
                     
                      List<BMpvAkcije>  results =  em.createNamedQuery("BMpAkcije.findAll").getResultList();
                        data = FXCollections.observableArrayList(results);


                       ID=new TableColumn ("ID");
                       ID.setCellValueFactory(new PropertyValueFactory<>("id"));

                     /*  TIP_AKCIJE=new TableColumn ("TIP_AKCIJE");
                       TIP_AKCIJE.setCellValueFactory(new PropertyValueFactory<BMpAkcije,String>("tipAkcije"));*/

                       DATUM_OD=new TableColumn ("DATUM_OD");
                       DATUM_OD.setCellValueFactory(new PropertyValueFactory<BMpvAkcije,Date>("datumOd")); 

                       DATUM_DO=new TableColumn ("DATUM_DO");
                       DATUM_DO.setCellValueFactory(new PropertyValueFactory<BMpvAkcije,Date>("datumDo")); 

                       STATUS=new TableColumn ("STATUS");
                       STATUS.setCellValueFactory(new PropertyValueFactory<BMpvAkcije,String>("status"));

                       KOMENTAR=new TableColumn ("KOMENTAR");
                       KOMENTAR.setCellValueFactory(new PropertyValueFactory<BMpvAkcije,String>("komentar"));

                       tabela.getColumns().setAll(ID, DATUM_OD,DATUM_DO,STATUS,KOMENTAR);
                       tabela.setItems(data);
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                       alert.setTitle("Information Dialog");
                       alert.setHeaderText("Izmena vrednosti!");
                       alert.setContentText("Zatvorili ste akciju"); 
                       alert.showAndWait();  
                      }  
              else if (b.get(0).getStatus().equals("Z"))
                      {      
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                       alert.setTitle("Information Dialog");
                       alert.setHeaderText("Izmena vrednosti!");
                       alert.setContentText("Akcija je već zatvorena"); 
                       alert.showAndWait();  
                      }
                     
                    
                   }
                   catch (Exception e) {
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                     alert.setTitle("Information Error");
                     alert.setHeaderText("Greska u izmeni");
                     alert.setContentText("Doslo je do greske prilikom pokusaja izmene.  "+e.getMessage()); 
                     alert.showAndWait();
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
    
    
    @FXML
    public void prikaziMatricuPrvogPunjenja() {
        //  listaRazvozaPrvoPunjenje(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
    }
    
     @FXML
    public void prikaziMatricuDopuna() {
           listaRazvozaDopuna(data.get(tabela.getSelectionModel().getSelectedIndex()).getId().intValue(),cmb_find_matrica_dop.getValue().toString());
    }
    
    
    @FXML public void izmeniPreporuku() {
        //pozovi proceduru za 
   /*   String v_status= data.get(tabela.getSelectionModel().getSelectedIndex()).getStatus();
      
      if (!v_status.equals("Z"))
      {   
        // PK_P_RG_izmena_kol.setText(PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getPreporucena().toString());
        try {
            em.getTransaction().begin();
            StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mp_akc_rucna_korek_prep_poje");
            
            storedprocedure1.registerStoredProcedureParameter("p_id_akcije", Long.class, ParameterMode.IN);
            storedprocedure1.setParameter("p_id_akcije", PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getIdAkcije());
            
            storedprocedure1.registerStoredProcedureParameter("p_id_kampanje", String.class, ParameterMode.IN);
            storedprocedure1.setParameter("p_id_kampanje", PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getIdKampanje());
            
            storedprocedure1.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
            storedprocedure1.setParameter("p_id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
            
            storedprocedure1.registerStoredProcedureParameter("p_orgjed", String.class, ParameterMode.IN);
            storedprocedure1.setParameter("p_orgjed", PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getOrgjed());
            
            storedprocedure1.registerStoredProcedureParameter("p_artikal", Long.class, ParameterMode.IN);
            storedprocedure1.setParameter("p_artikal", PK_data.get(tblPreporKol.getSelectionModel().getSelectedIndex()).getArtikal());
            
            storedprocedure1.registerStoredProcedureParameter("p_kolicina", Integer.class, ParameterMode.IN);
            storedprocedure1.setParameter("p_kolicina", new BigDecimal(PK_P_RG_izmena_kol.getText()));
            
            storedprocedure1.registerStoredProcedureParameter("p_opis", String.class, ParameterMode.IN);
            storedprocedure1.setParameter("p_opis", PK_P_RG_izmena_opis.getText());
            
            storedprocedure1.execute();
            
            em.getTransaction().commit();

       // int xx=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();
            //  listaRazvozaDopuna(xx);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("info o izmeni preporucenih kolicina");
            alert.setHeaderText("info o izmeni preporucenih kolicina");
            alert.setContentText("Izmenili ste preporucenu kolicinu");
            alert.showAndWait();            
            listaPreporKolFilter();
        } catch (Exception e) {
            em.getTransaction().rollback();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("info o izmeni preporucenih kolicina");
            alert.setHeaderText("GRESKA");
            alert.setContentText("Doslo je do greske "+e.getMessage());
            alert.showAndWait();  
        }
        
        
      }
      else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("info o izmeni preporucenih kolicina");
            alert.setHeaderText("GRESKA");
            alert.setContentText("Ne mozete menjati zatvorenu akciju!!");
            alert.showAndWait();
          
      }
       //  listaRazvozaPrvoPunjenje(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
 */       
    } 
}
