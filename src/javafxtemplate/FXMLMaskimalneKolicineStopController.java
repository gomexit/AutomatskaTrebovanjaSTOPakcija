/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.awt.PageAttributes.MediaType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafxtemplate.CompositePrimaryKeys.MBMpAkcijeMaxKolicinePK;
import javafxtemplate.DTOs.MaxKolicineDTO;
import static javafxtemplate.JavaFXTemplate.primaryStage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.apache.http.util.TextUtils;
import org.eclipse.persistence.config.QueryHints;

/**
 * FXML Controller class
 *
 * @author milost
 */
public class FXMLMaskimalneKolicineStopController implements Initializable {

    /**
     * Initializes the controller class.
     */
        
    //varijable koje koristim za jasper report
    public static final String DBURL = "jdbc:oracle:thin:@//10.2.0.246:1521/gom.gomex.local";
    public static final String DBUSER = "rouser";
    public static final String DBPASS = "floret"; 
    


    
    private EntityManager em;
    
    
    ObservableList<MaxKolicineDTO> data; 
    
    @FXML ImageView imgPrimerFajla;
    
    @FXML TextField txt_max_kol_sifra_artikla;
    @FXML TextField txt_max_kol_kolicina;
    @FXML TextField txt_max_kol_sifra_objekta;
    @FXML TextField txt_sifra_za_brisanje;
    
    
    TableColumn<MaxKolicineDTO,String> SIFRA_ARTIKLA;
    TableColumn<MaxKolicineDTO,BigInteger> MAX_KOLICINA;
    TableColumn<MaxKolicineDTO,String> SIFRA_OBJEKTA;
    TableColumn<MaxKolicineDTO,String> NAZIV_OBJEKTA;
    TableColumn<MaxKolicineDTO,String> NAZIV_ARTIKLA;
    
    @FXML   TableView tblArtikli;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
         refreshTabele();
         validacijaPolja();
         Image img;
        try {
            img = new Image(getClass().getResource("/images/primerfajla.png").toURI().toString());
            System.out.println(img.getWidth());
            imgPrimerFajla.setImage(img);
        } catch (URISyntaxException ex) {
            Logger.getLogger(FXMLMaskimalneKolicineStopController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         
    }  
    
    public void validacijaPolja(){
        txt_max_kol_kolicina.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, 
                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        txt_max_kol_kolicina.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });
        
        txt_max_kol_sifra_artikla.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, 
                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        txt_max_kol_sifra_artikla.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });
        txt_max_kol_sifra_objekta.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, 
                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        txt_max_kol_sifra_objekta.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });
        
        txt_sifra_za_brisanje.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, 
                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        txt_sifra_za_brisanje.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });
    }
    
    public void refreshTabele(){
        em.clear();
        if (em.getTransaction().isActive() == false){
         em.getTransaction().begin();
        }
        List<MaxKolicineDTO>  results =  em.createNamedQuery("getMaxKolicineList").getResultList(); 
        data = FXCollections.observableArrayList(results);
        em.getTransaction().commit();    
        SIFRA_ARTIKLA=new TableColumn ("SIFRA_ARTIKLA");
        SIFRA_ARTIKLA.setCellValueFactory(new PropertyValueFactory<MaxKolicineDTO,String>("sifraArtikla"));
        MAX_KOLICINA=new TableColumn ("MAX_KOLICINA");
        MAX_KOLICINA.setCellValueFactory(new PropertyValueFactory<MaxKolicineDTO,BigInteger>("maxKolicina"));
        SIFRA_OBJEKTA=new TableColumn ("SIFRA_OBJEKTA");
        SIFRA_OBJEKTA.setCellValueFactory(new PropertyValueFactory<MaxKolicineDTO,String>("sifraObjekta"));
        NAZIV_OBJEKTA=new TableColumn ("NAZIV_OBJEKTA");
        NAZIV_OBJEKTA.setCellValueFactory(new PropertyValueFactory<MaxKolicineDTO,String>("nazivObjekta"));
        NAZIV_ARTIKLA=new TableColumn ("NAZIV_ARTIKLA");
        NAZIV_ARTIKLA.setCellValueFactory(new PropertyValueFactory<MaxKolicineDTO,String>("nazivArtikla"));
          
        tblArtikli.getColumns().setAll(SIFRA_ARTIKLA,NAZIV_ARTIKLA,SIFRA_OBJEKTA,NAZIV_OBJEKTA,MAX_KOLICINA);
        tblArtikli.setItems(data);
    }
   public void unosMaskimalnihKolicinaStop(){
        em.clear();
        if (em.getTransaction().isActive() == false){
         em.getTransaction().begin();
        }
        if (txt_max_kol_kolicina.getText() == null || txt_max_kol_kolicina.getText().isEmpty() ||
            txt_max_kol_sifra_artikla.getText().isEmpty() || txt_max_kol_sifra_artikla.getText() == null  ||
            txt_max_kol_sifra_objekta.getText().isEmpty() || txt_max_kol_sifra_objekta.getText() == null){
            JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena");
            return;
        }
        MBMpAkcijeMaxKolicine b = new MBMpAkcijeMaxKolicine();
        
        BigInteger vrednostKolicina = new BigInteger(txt_max_kol_kolicina.getText());
        b.setMaxKolicina(vrednostKolicina);
        MBMpAkcijeMaxKolicinePK newPk =  new MBMpAkcijeMaxKolicinePK(txt_max_kol_sifra_artikla.getText(),txt_max_kol_sifra_objekta.getText());
        b.setMyPk(newPk);
//        b.setSifraArtikla(txt_max_kol_sifra_artikla.getText());
//        b.setSifraObjekta(txt_max_kol_sifra_objekta.getText());
        em.persist(b);
        em.getTransaction().commit();
        refreshTabele();
        txt_max_kol_kolicina.setText("");
        txt_max_kol_sifra_artikla.setText("");
        txt_max_kol_sifra_objekta.setText("");

   }
   
   public void brisanjeMaskimalnihKolicinaStop(){
       int row = tblArtikli.getSelectionModel().getSelectedIndex();
            if(row == -1){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Greska");
                alert.setContentText("Morate selektovati artikal!");
                alert.showAndWait();  
                return;
            };
        em.clear();
        if (em.getTransaction().isActive() == false){
         em.getTransaction().begin();
        }
//        List<MBMpAkcijeMaxKolicine> b  =  em.createNamedQuery("MBMpAkcijeMaxKolicine.findBySifraArtikla")
//        .setParameter("sifraArtikla", data.get(tblArtikli.getSelectionModel().getSelectedIndex()).getSifraArtikla())
//        .getResultList();
        MBMpAkcijeMaxKolicinePK selectedPrimaryKey = new MBMpAkcijeMaxKolicinePK(data.get(tblArtikli.getSelectionModel().getSelectedIndex()).getSifraArtikla(),data.get(tblArtikli.getSelectionModel().getSelectedIndex()).getSifraObjekta());
     
        MBMpAkcijeMaxKolicine b = em.find(MBMpAkcijeMaxKolicine.class,selectedPrimaryKey);
        
        if (!TextUtils.isEmpty(b.getMyPk().getSifraArtikla()) && !TextUtils.isEmpty(b.getMyPk().getSifraObjekta()))
         {
                em.remove(b);
                em.getTransaction().commit();
         }
          refreshTabele();
        
   }
   
    public void brisanjeKolicinaPoSifri(){
        if (txt_sifra_za_brisanje.getText() == null || txt_sifra_za_brisanje.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Unesite sifru artikla!");
            return;
        }
        em.clear();
        if (em.getTransaction().isActive() == false){
         em.getTransaction().begin();
        }
        em.createNamedQuery("MBMpAkcijeMaxKolicine.deleteSifraArtikla").setParameter("sifraArtikla", txt_sifra_za_brisanje.getText()).executeUpdate();
        refreshTabele();
        txt_sifra_za_brisanje.setText("");
    }
 
   
   public void uploadCsvFajla() throws FileNotFoundException, IOException{
        
           
        
       FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Odabir fajla sa maksmilanim kolicinama");
        File defaultDirectory = new File("/");
        fileChooser.setInitialDirectory(defaultDirectory);
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Brisanje");
                alert.setHeaderText("Da li zelite da importujete sve kolicine sa fajla?");
                //alert.setContentText("Da li zelite da obrisete selektovani red?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                        String FieldDelimiter = null;
                        String lineD = "";
                        boolean firstLine = true;
                try (BufferedReader br = new BufferedReader(new FileReader(file)))  {
                    while ((lineD = br.readLine()) != null) {
                        if(firstLine) {
                            FieldDelimiter = determineDelimiter(lineD);
                            if(FieldDelimiter.equalsIgnoreCase("")) {
                                JOptionPane.showMessageDialog(null,"Unsupported delimiter found: " + FieldDelimiter);
                                return;
                            }
                            firstLine = false;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                        BufferedReader br;
                        try {
                                br = new BufferedReader(new FileReader(file));
                                            String line;
                                            boolean prviRed = true;
                                            while ((line = br.readLine()) != null) {
                                                if (prviRed == true){
                                                    prviRed = false;
                                                    continue;
                                                }
                                                String[] fields = line.split(FieldDelimiter, -1);
                                                /*String orgjed = fields[0].trim();
                                                String sifra_artikla = fields[1].trim();
                                                String max_kolicina = fields[2].trim();*/
                                                unesiMaxKolicinu(fields[0].trim(),fields[1].trim(),new BigInteger(fields[2].trim()));
                                            }
                                            refreshTabele();
                            }
                         catch (IOException ex) {

                        }
                    }
                }
        }
   
    private static List<String> delimiterList = new ArrayList<String>(){{
                add(",");
                add(";");
            }};
    private static String determineDelimiter(String text) {
         for (String delimiter : delimiterList) {
             if(text.contains(delimiter)) {
                 return delimiter;
             }
         }
         return "";
     }
    public void unesiMaxKolicinu(String orgjed,String sifra_artikla,BigInteger maxKolicina){
        em.clear();
        if (em.getTransaction().isActive() == false){
         em.getTransaction().begin();
        }
        List<MBMpAkcijeMaxKolicine> bE  =  em.createNamedQuery("MBMpAkcijeMaxKolicine.findBySifraArtiklaOrgjed")
               .setParameter("sifraArtikla", sifra_artikla)
               .setParameter("sifraObjekta", orgjed)
               .getResultList();
        if (bE.isEmpty()){
                            MBMpAkcijeMaxKolicine b = new MBMpAkcijeMaxKolicine();
                            b.setMaxKolicina(maxKolicina);
                            MBMpAkcijeMaxKolicinePK newPk =  new MBMpAkcijeMaxKolicinePK(sifra_artikla,orgjed);
                            b.setMyPk(newPk);
//                            b.setSifraArtikla(sifra_artikla);
//                            b.setSifraObjekta(orgjed);
                            em.persist(b);
                            em.getTransaction().commit();
                        }
        
    }
   
}
   

    
    

