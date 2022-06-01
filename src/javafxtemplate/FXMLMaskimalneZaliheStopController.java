/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafxtemplate.CompositePrimaryKeys.MBMpAkcijeMaxKolicinePK;
import javafxtemplate.DTOs.MaxKolicineDTO;
import javafxtemplate.DTOs.MaxZaliheDTO;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.apache.http.util.TextUtils;

/**
 * FXML Controller class
 *
 * @author milost
 */
public class FXMLMaskimalneZaliheStopController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public static final String DBURL = "jdbc:oracle:thin:@//10.2.0.246:1521/gom.gomex.local";
    public static final String DBUSER = "rouser";
    public static final String DBPASS = "floret"; 
    private EntityManager em;
    ObservableList<MaxZaliheDTO> data; 
    
    @FXML   TableView tblArtikli;
    
    TableColumn<MaxZaliheDTO,String> SIFRA_ARTIKLA;
    TableColumn<MaxZaliheDTO,BigInteger> MAX_KOLICINA;
    TableColumn<MaxZaliheDTO,String> NAZIV_ARTIKLA;
    
    @FXML TextField txt_max_kol_sifra_artikla;
    @FXML TextField txt_max_kol_kolicina;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
        refreshTabele();
        validacijaPolja();
    }    
    
    
        public void refreshTabele(){
        em.clear();
        if (em.getTransaction().isActive() == false){
         em.getTransaction().begin();
        }
        List<MaxZaliheDTO>  results =  em.createNamedQuery("getMaxZaliheList").getResultList(); 
        data = FXCollections.observableArrayList(results);
        em.getTransaction().commit();    
        SIFRA_ARTIKLA=new TableColumn ("SIFRA_ARTIKLA");
        SIFRA_ARTIKLA.setCellValueFactory(new PropertyValueFactory<MaxZaliheDTO,String>("sifraArtikla"));
        MAX_KOLICINA=new TableColumn ("MAX_KOLICINA");
        MAX_KOLICINA.setCellValueFactory(new PropertyValueFactory<MaxZaliheDTO,BigInteger>("maxKolicina"));
        NAZIV_ARTIKLA=new TableColumn ("NAZIV_ARTIKLA");
        NAZIV_ARTIKLA.setCellValueFactory(new PropertyValueFactory<MaxZaliheDTO,String>("nazivArtikla"));
          
        tblArtikli.getColumns().setAll(SIFRA_ARTIKLA,NAZIV_ARTIKLA,MAX_KOLICINA);
        tblArtikli.setItems(data);
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
    }
    
    public void unosMaskimalnihZalihaStop(){
        em.clear();
        if (em.getTransaction().isActive() == false){
         em.getTransaction().begin();
        }
        if (txt_max_kol_kolicina.getText() == null || txt_max_kol_kolicina.getText().isEmpty() ||
            txt_max_kol_sifra_artikla.getText().isEmpty() || txt_max_kol_sifra_artikla.getText() == null){
            JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena");
            return;
        }
        MBMpAkcijeMaxZalihe b = new MBMpAkcijeMaxZalihe();
        
        BigInteger vrednostKolicina = new BigInteger(txt_max_kol_kolicina.getText());
        String sifraArtikla = txt_max_kol_sifra_artikla.getText();
        b.setMaxZaliha(vrednostKolicina);
        Query q = em.createNativeQuery("SELECT ID FROM iis.artikli WHERE sifra = ?");
        BigDecimal artikal = null;
        try {
            artikal = (BigDecimal) q.setParameter(1, sifraArtikla).getSingleResult();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Proverite sifru artikla!");
            return;
        }
        BigInteger artikalBigInteger = artikal.toBigInteger();
        b.setArtikal(artikalBigInteger);
        em.persist(b);
        em.getTransaction().commit();
        refreshTabele();
        txt_max_kol_kolicina.setText("");
        txt_max_kol_sifra_artikla.setText("");
    }
    
    public void brisanjeMaskimalnihZalihaStop(){
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
        
        
        Query q = em.createNativeQuery("SELECT ID FROM iis.artikli WHERE sifra = ?");
        BigDecimal artikal = null;
        try {
            artikal = (BigDecimal) q.setParameter(1, data.get(tblArtikli.getSelectionModel().getSelectedIndex()).getSifraArtikla()).getSingleResult();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Proverite sifru artikla!");
            return;
        }
        
        BigInteger artikalBigInteger = artikal.toBigInteger();
//        zaliheObj.setArtikal(artikalBigInteger);
//        zaliheObj.setMaxZaliha(data.get(tblArtikli.getSelectionModel().getSelectedIndex()).getMaxKolicina());
        
        if (artikalBigInteger != null && data.get(tblArtikli.getSelectionModel().getSelectedIndex()).getMaxKolicina() != null)
         {
                MBMpAkcijeMaxZalihe zaliheObj = em.find(MBMpAkcijeMaxZalihe.class, artikalBigInteger);
                em.remove(zaliheObj);
                em.getTransaction().commit();
         }
          refreshTabele();
        
   }
    
}
