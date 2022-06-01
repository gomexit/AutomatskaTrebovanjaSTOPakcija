/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import static javafxtemplate.JavaFXTemplate.showListaAkcija;

/**
 * FXML Controller class
 *
 * @author bojan
 */
public class FXMLGlavniController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML    
    public void probaMenu()
    {
        System.out.print("Pozvao meni");
        
    }
    
    @FXML
    public void pozoviListuAkcija() throws IOException
    {
        showListaAkcija();
    }
    
    @FXML
    public void pozoviPregledeAkcija() throws IOException
    {
        JavaFXTemplate.showPreglediAkcija();
    }
            
    @FXML
    public void pozoviMaksimalneKolicineStop() throws IOException
    {
        JavaFXTemplate.showMaksimalneKolicineStop();
    }
    @FXML
    public void pozoviMaksimalneZaliheStop() throws IOException
    {
        JavaFXTemplate.showMaksimalneZaliheStop();
    }
    @FXML
       public void pozoviObracun() throws IOException
    {
        JavaFXTemplate.showObracun();
    }
      
               
    @FXML
       public void pozoviObracunArhiva() throws IOException
    {
        JavaFXTemplate.showObracunArhiva();
    }           
       
         @FXML
       public void pozoviSpecificneDane() throws IOException
    {
        JavaFXTemplate.showSpecificniDani();
    }
       
              @FXML
       public void pozoviZamenskeArtikle() throws IOException
    {
        JavaFXTemplate.showZamenskiArtikli();
    }
       
                  @FXML
       public void pozoviRadnje() throws IOException
    {
        JavaFXTemplate.showRadnje();
    }
       
                       @FXML
       public void pozoviRucnuKorekcijuKol() throws IOException
    {
        JavaFXTemplate.showRucnaKorekcijaKol();
    }
       
                 @FXML
       public void pozoviSekundarnePozicije() throws IOException
    {
        JavaFXTemplate.showSekundarnePozicije();
    }

            @FXML
       public void pozoviStatArtikNaAkc() throws IOException
    {
        JavaFXTemplate.showStatistikaArtikNaAkc();
    }

       

public void reakcijaNaKlikNedozvoljenogPolja () {
           
   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                              alert.setTitle("ERROR!");
                              alert.setHeaderText("Authorized personnel only!");
                              alert.setContentText("Pristup nije dozvoljen!"); 
                              alert.showAndWait();


}



 @FXML
       public void showAkcije2maska() throws IOException
    {
        JavaFXTemplate.showAkcije2maska();
    }
       
       
        @FXML
       public void showVikendAkcija() throws IOException
    {
        JavaFXTemplate.showVikendAkcija();
    }
       
       
       
           
        @FXML
       public void showObracunVikend() throws IOException
    {
        JavaFXTemplate.showObradaVikendAkcija();
    }
    
     @FXML
       public void showIzuzeciIzAsortimana() throws IOException
    {
        JavaFXTemplate.showIzuzeciIzAsortimana();
    }   
       
        @FXML
       public void showPlanogram() throws IOException
    {
        JavaFXTemplate.showPlanogram();
    }   
       
       
             @FXML
       public void showRucnePreporuke() throws IOException
    {
        JavaFXTemplate.showRucnePreporuke();
    } 
       
       
              @FXML
       public void showRucneDopune() throws IOException
    {
        JavaFXTemplate.showRucneDopune();
    } 
       
       
          @FXML
       public void showMinimalneKolicine() throws IOException
    {
        JavaFXTemplate.showMinimalneKolicine();
    }    
       
       
        @FXML
       public void showArhivaStopAkcije() throws IOException
    {
        JavaFXTemplate.showArhivaStopAkcije();
    } 
       
}
