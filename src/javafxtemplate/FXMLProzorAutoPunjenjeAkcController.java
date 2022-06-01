
package javafxtemplate;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.eclipse.persistence.config.QueryHints;
import javafxtemplate.FXMLStatIstikaArtikNaAkcController.*;
import javafxtemplate.FXMLProzorAutoPunjenjeAkcController.*;

public class FXMLProzorAutoPunjenjeAkcController implements Initializable {

    private EntityManager em;
   
    // Notacije 
    @FXML TableView tbl_AR;
    @FXML TextField Akc_txt_pretraga;
    @FXML TextField AR_txt_pretraga;
    
    
    
    
    
       
    
   
    //Podaci za tabelu artikala 
    @FXML TableColumn<BVArtikli,Long>  AK_ID;
    @FXML TableColumn<BVArtikli,String>  AK_SIFRA;
    @FXML TableColumn<BVArtikli,String>  AK_NAZIV;
    @FXML TableColumn<BVArtikli,String>  AK_NAZIV_RG;
    @FXML TableColumn<BVArtikli,String>  AK_RG;
         
    ObservableList<BVArtikli> AR_data;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
        
        
         
        
        
         
          
           tbl_AR.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tbl_AR.getSelectionModel().getSelectedItem() != null) 
        {    
          
           TableView.TableViewSelectionModel selectionModel = tbl_AR.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);           
           List<BVArtikli> selected = selectionModel.getSelectedItems();
           
          // ((Node)event.getSource()).getScene().getWindow().hide();
          
          
          FXMLStatIstikaArtikNaAkcController x = JavaFXTemplate.loader_static.getController();
          x.txt_id.setText(String.valueOf(AR_data.get(tbl_AR.getSelectionModel().getSelectedIndex()).getId()) );
          x.txt_sifra.setText(AR_data.get(tbl_AR.getSelectionModel().getSelectedIndex()).getSifra() );
          x.txt_naziv.setText(AR_data.get(tbl_AR.getSelectionModel().getSelectedIndex()).getNaziv());
          JavaFXTemplate.stage_static.hide();
          
        
         

        }
         }
     });  
        
           //set focus na pretragu
             Platform.runLater(new Runnable() {
     @Override
     public void run() {
         AR_txt_pretraga.requestFocus();
     }
});   
             
       //ON ENTER
             AR_txt_pretraga.setOnKeyPressed(new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER)  {
            String text = AR_txt_pretraga.getText();

            System.out.println(AR_txt_pretraga.getText());
            prikaziArtikle();
        }
    }
});
             
    }    
    
    //Metoda koja izbacuje listu pretrage po specificiranim parametrima za pop up prozor
   @FXML
   public void prikaziArtikle() {
         em.clear();
         
         if (!"".equals(AR_txt_pretraga.getText()))
         {  
         
             String v_a= "%"+AR_txt_pretraga.getText().toUpperCase()  +"%";
            List<BVArtikli>  results =  em.createNamedQuery("BVArtikli.findBySve")
                .setParameter("naziv", v_a)
                
               // .setParameter("id", v_a)
               
                .setParameter("sifra", v_a)
                
                
                
                .setHint(QueryHints.MAINTAIN_CACHE, "false")
                .getResultList();
           AR_data = FXCollections.observableArrayList(results);
                  
          AK_ID=new TableColumn ("id ");
          AK_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
          
          AK_SIFRA=new TableColumn ("šifra");
          AK_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          
          AK_NAZIV=new TableColumn ("naziv");
          AK_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          
          
           
         tbl_AR.getColumns().setAll(AK_ID,AK_SIFRA,AK_NAZIV);
           
          tbl_AR.setItems(AR_data);
        
         // JavaFXTemplate.loader_static;
         /* 
          //sakrij prozor
          ((Node)event.getSource()).getScene().getWindow().hide();
          
          FXMLAkcijaController x = JavaFXTemplate.loader_static.getController();
          x.RU_txt_id.setText("Bojan");*/
         }
      
         else
       {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Greska!");
            alert.setContentText("Morate uneti nesto u polje pretraga! Unesite pa pokušajte ponovo!"); 
            alert.showAndWait();  
       }

}
   
    public void zatvoriprozor(ActionEvent event)  {
        
       
          ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
}
