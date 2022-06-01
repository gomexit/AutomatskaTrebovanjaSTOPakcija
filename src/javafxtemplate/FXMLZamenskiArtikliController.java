/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.eclipse.persistence.config.QueryHints;

/**
 * FXML Controller class
 *
 * @author bojan
 */
public class FXMLZamenskiArtikliController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private EntityManager em;
    ObservableList<BVMpAkcZamenski2> data;
    ObservableList<BVMpAkcArtikli> AR_data;
    
    @FXML TableView tbl;
    @FXML TableColumn<BVMpAkcZamenski2,BigDecimal>  ARTIKAL_ID;
    @FXML TableColumn<BVMpAkcZamenski2,String> ARTIKAL_SIFRA;
    @FXML TableColumn<BVMpAkcZamenski2,String> ARTIKAL_NAZIV;
    @FXML TableColumn<BVMpAkcZamenski2,BigDecimal>  ARTIKAL_ID_ZAM;
    @FXML TableColumn<BVMpAkcZamenski2,String> ARTIKAL_SIFRA_ZAM;
    @FXML TableColumn<BVMpAkcZamenski2,String> ARTIKAL_NAZIV_ZAM;
    @FXML TableColumn<BVMpAkcZamenski2,BigDecimal> ODNOS;
    
    @FXML TextField txt_search;
    
    
    @FXML TableView tbl_artikli;
    @FXML TextField txt_search_artikli;
    @FXML TableColumn<BVMpAkcArtikli,BigDecimal>  AR_ID;
    @FXML TableColumn<BVMpAkcArtikli,String> AR_SIFRA;
    @FXML TableColumn<BVMpAkcArtikli,String> AR_NAZIV;
    @FXML TableColumn<BVMpAkcArtikli,String>  AR_RG;
    
    
    @FXML TextField txt_add_artikal_id;
    @FXML TextField txt_add_artikal_sifra;
    @FXML TextField txt_add_artikal_naziv;
    @FXML TextField txt_add_zamenski_id;
    @FXML TextField txt_add_zamenski_sifra;
    @FXML TextField txt_add_zamenski_naziv;
    @FXML TextField txt_add_odnos;
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
        popuniInicijalno();
       
    }  
    
   @FXML 
   public void popuniInicijalno() {
 
         String v_param="%"+txt_search.getText()+"%";
          if (!"".equals(txt_search.getText())) v_param=v_param.toUpperCase();
         
         
        em.clear();
        List<BVMpAkcZamenski2>  results =  em.createNamedQuery("BVMpAkcZamenski2.findByPretraga")
                .setParameter("naziv", v_param)
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
           data = FXCollections.observableArrayList(results);
  
                  
          ARTIKAL_ID=new TableColumn ("id artikla");
          ARTIKAL_ID.setCellValueFactory(new PropertyValueFactory<>("artikal"));
          
          ARTIKAL_SIFRA=new TableColumn ("sifra artikla");
          ARTIKAL_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifraArtikla"));
          
          ARTIKAL_NAZIV=new TableColumn ("naziv artikla");
          ARTIKAL_NAZIV.setCellValueFactory(new PropertyValueFactory<>("artikalNaziv"));
          
          ARTIKAL_ID_ZAM=new TableColumn ("id zamenskog");
          ARTIKAL_ID_ZAM.setCellValueFactory(new PropertyValueFactory<>("zamenskiIdId"));
          
          ARTIKAL_SIFRA_ZAM=new TableColumn ("sifra zamenskog");
          ARTIKAL_SIFRA_ZAM.setCellValueFactory(new PropertyValueFactory<>("zamenskiSifra"));
          
          ARTIKAL_NAZIV_ZAM=new TableColumn ("naziv zamenskog");
          ARTIKAL_NAZIV_ZAM.setCellValueFactory(new PropertyValueFactory<>("zamenskiNaziv"));
          
          ODNOS=new TableColumn ("odnos");
          ODNOS.setCellValueFactory(new PropertyValueFactory<>("odnos"));
          
          
         
           
         tbl.getColumns().setAll(ARTIKAL_ID,ARTIKAL_SIFRA,ARTIKAL_NAZIV,ARTIKAL_ID_ZAM,
                 ARTIKAL_SIFRA_ZAM,ARTIKAL_NAZIV_ZAM,ODNOS);
           
          tbl.setItems(data);
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
   public void dodajGlavniArtikal() {
       /*
        @FXML TextField txt_add_artikal_id;
    @FXML TextField txt_add_artikal_sifra;
    @FXML TextField txt_add_artikal_naziv;
    @FXML TextField txt_add_zamenski_id;
    @FXML TextField txt_add_zamenski_sifra;
    @FXML TextField txt_add_zamenski_naziv;
    @FXML TextField txt_add_odnos;
       
       RG_spisak_data.get(tbl_spisak_RG.getSelectionModel().getSelectedIndex()).getSifra()
       */
       
       txt_add_artikal_id.setText(String.valueOf(AR_data.get(tbl_artikli.getSelectionModel().getSelectedIndex()).getId())  );
       txt_add_artikal_sifra.setText(AR_data.get(tbl_artikli.getSelectionModel().getSelectedIndex()).getSifra());
       txt_add_artikal_naziv.setText(AR_data.get(tbl_artikli.getSelectionModel().getSelectedIndex()).getNaziv());
   }
   
   
   @FXML
   public void dodajZamenskiArtikal() {
       txt_add_zamenski_id.setText(String.valueOf(AR_data.get(tbl_artikli.getSelectionModel().getSelectedIndex()).getId())  );
       txt_add_zamenski_sifra.setText(AR_data.get(tbl_artikli.getSelectionModel().getSelectedIndex()).getSifra());
       txt_add_zamenski_naziv.setText(AR_data.get(tbl_artikli.getSelectionModel().getSelectedIndex()).getNaziv());
   }
   
    @FXML
   public void dodajZamenskiUBazu() {
      
       
         try {
            em.clear();
            em.getTransaction().begin();
            BMpAkcZamenski2 b = new BMpAkcZamenski2();

            b.setArtikal(Long.valueOf(txt_add_artikal_id.getText()));
            b.setZamenski(Long.valueOf(txt_add_zamenski_id.getText()));
            b.setOdnos(new BigDecimal(txt_add_odnos.getText()));
            
            em.persist(b);
            em.getTransaction().commit();
            // JOptionPane.showMessageDialog(null, "Uneli ste novi specificni dan");
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Zamenski artikli -info");
            alert1.setHeaderText("Zamenski artikli - unos");
            alert1.setContentText("Uneli ste novi zamenski artikal");
            alert1.showAndWait();
            
            txt_add_artikal_id.setText("");
            txt_add_artikal_sifra.setText("");
            txt_add_artikal_naziv.setText("");
            txt_add_zamenski_id.setText("");
            txt_add_zamenski_sifra.setText("");
            txt_add_zamenski_naziv.setText("");
            txt_add_odnos.setText("");
            
            
            popuniInicijalno();            
        } catch (Exception e) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error info");
            alert1.setHeaderText("Zamenski artikli - unos");
            alert1.setContentText("Doslo je do greske. "+e.getMessage());
            alert1.showAndWait();
        }
   } 
   
   
      @FXML
   public void obrisiZamenskiArtikal() {
     
       
         
            if ((tbl.getSelectionModel().getSelectedIndex()>-1)  )
       {
              em.getTransaction().begin();
             
       List<BMpAkcZamenski2> b  =  em.createNamedQuery( "BMpAkcZamenski2.findByArtikal")
               .setParameter("artikal", data.get(tbl.getSelectionModel().getSelectedIndex()).getArtikal())
               .getResultList();

       if (!b.isEmpty())
       {
              em.remove(b.get(0));
              em.getTransaction().commit();
       }
        popuniInicijalno();
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Brisanje zamenskog artikla");
            alert.setContentText("Obrisali ste zamesnki artikal");
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
    
}
