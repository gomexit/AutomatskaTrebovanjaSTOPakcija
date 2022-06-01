/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author bojan
 */
public class JavaFXTemplate extends Application {
     public static Stage primaryStage;
    private static BorderPane mainLayout;
    public static Integer param_id;
    public static Integer param_id_artikla;
    public static String param_OJ;
    public static String param_OJ_naziv;
    public static String param_Artikal_naziv;
    
    public static Integer param_ist_akc_id_artikla;
  
    //parametri koji se popunjavaju u masci istorijske akcije
    public static String param2_id_artikla="";
    public static String param2_sifra_artikla="";
    public static String param2_naziv_artikla="";
    
    
    //kraj
    
    public static FXMLLoader loader_static;
    public static Stage stage_static;
    
   
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage=primaryStage; 
       
       showMainView();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void showMainView() throws IOException {
        FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLGlavni.fxml"));
       mainLayout=loader.load();   
       Scene scene = new Scene (mainLayout);
     
       primaryStage.setScene(scene);
        
       primaryStage.show();
       primaryStage.setTitle("Konfiguracija algoritma za akcijska trebovanja (V 2.55)");
      
       
       //dodajemo za maksimiziranje prozora
       Screen screen = Screen.getPrimary();
         javafx.geometry.Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
    }
    
    
     public static void showListaAkcija() throws IOException {
      /* FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLListaAkcija.fxml"));
       BorderPane drugi =loader.load();
       mainLayout.setCenter(drugi);*/
       
       
         Stage stageAnalitikaArtikla = new Stage();
             FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLListaAkcija.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageAnalitikaArtikla.setScene(scene);
       stageAnalitikaArtikla.setScene(new Scene(new ScrollPane(bpArt)));
       stageAnalitikaArtikla.show();
     }
     
      public static void showPreglediAkcija() throws IOException {
      /* FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLPreglediAkcija.fxml"));
       BorderPane treci =loader.load();
       mainLayout.setCenter(treci);*/
            Stage stageAnalitikaArtikla = new Stage();
        //Fill stage with content
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLPreglediAkcija.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageAnalitikaArtikla.setScene(scene);
       stageAnalitikaArtikla.setScene(new Scene(new ScrollPane(bpArt)));
       stageAnalitikaArtikla.show();
          
     }
      
            public static void showMaksimalneKolicineStop() throws IOException {
      /* FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLPreglediAkcija.fxml"));
       BorderPane treci =loader.load();
       mainLayout.setCenter(treci);*/
            Stage stageAnalitikaArtikla = new Stage();
        //Fill stage with content
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLMaskimalneKolicineStop.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageAnalitikaArtikla.setScene(scene);
       stageAnalitikaArtikla.setScene(new Scene(new ScrollPane(bpArt)));
       stageAnalitikaArtikla.show();
          
     }
            
     public static void showMaksimalneZaliheStop() throws IOException {
       Stage stageAnalitikaArtikla = new Stage();
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLMaskimalneZaliheStop.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageAnalitikaArtikla.setScene(scene);
       stageAnalitikaArtikla.setScene(new Scene(new ScrollPane(bpArt)));
       stageAnalitikaArtikla.show();
     }
      
      public static void showObracun() throws IOException {
    /*   FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLObracun.fxml"));
       BorderPane treci =loader.load();
       mainLayout.setCenter(treci);*/
           Stage stageAnalitikaArtikla = new Stage();
             FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLObracun.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageAnalitikaArtikla.setScene(scene);
       stageAnalitikaArtikla.setScene(new Scene(new ScrollPane(bpArt)));
       stageAnalitikaArtikla.show();
     }
      
      
      
       public static void showObracunArhiva() throws IOException {
    /*   FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLObracun.fxml"));
       BorderPane treci =loader.load();
       mainLayout.setCenter(treci);*/
           Stage stageAnalitikaArtikla = new Stage();
             FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLObracun_arhiva.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageAnalitikaArtikla.setScene(scene);
       stageAnalitikaArtikla.setScene(new Scene(new ScrollPane(bpArt)));
       stageAnalitikaArtikla.show();
     }
      
           
     public static void showAnalitikuArtikla() throws IOException  {

        
         Stage stageAnalitikaArtikla = new Stage();
        //Fill stage with content
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("AnalitikaArt.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageAnalitikaArtikla.setScene(scene);
       stageAnalitikaArtikla.setScene(new Scene(new ScrollPane(bpArt)));
       stageAnalitikaArtikla.show();
      // AnalitikaArtController.stisniButton2();

} 
     
     public static void showArhivaStopAkcije() throws IOException  {

        
         Stage stageArhiva = new Stage();
        //Fill stage with content
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLArhivaStopAkcija.fxml"));
       Pane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageArhiva.setScene(scene);
       stageArhiva.setScene(new Scene(new ScrollPane(bpArt)));
       stageArhiva.show();
      // AnalitikaArtController.stisniButton2();

} 
     
          public static void showAnalitikuArtiklaSVIMPO() throws IOException  {

        
         Stage stageAnalitikaArtikla = new Stage();
        //Fill stage with content
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLAnalitickaSviMpoDnevna.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageAnalitikaArtikla.setScene(scene);
       stageAnalitikaArtikla.setScene(new Scene(new ScrollPane(bpArt)));
       stageAnalitikaArtikla.show();
      // AnalitikaArtController.stisniButton2();

} 
     
      public static void showSpecificniDani() throws IOException  {

        
         Stage stageAnalitikaArtikla = new Stage();
        //Fill stage with content
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLSpecificniDani.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageAnalitikaArtikla.setScene(scene);
       stageAnalitikaArtikla.setScene(new Scene(new ScrollPane(bpArt)));
       stageAnalitikaArtikla.show();
      // AnalitikaArtController.stisniButton2();

}
      
    public static void showZamenskiArtikli() throws IOException  {

        
         Stage stageZamenski = new Stage();
        //Fill stage with content
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLZamenskiArtikli.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageZamenski.setScene(scene);
       stageZamenski.setScene(new Scene(new ScrollPane(bpArt)));
       stageZamenski.show();
      // AnalitikaArtController.stisniButton2();

}
        
    public static void showRadnje() throws IOException  {

        
         Stage stageZamenski = new Stage();
        //Fill stage with content
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLRadnje.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageZamenski.setScene(scene);
       stageZamenski.setTitle("lista mp objekata");
       stageZamenski.setScene(new Scene(new ScrollPane(bpArt)));
       stageZamenski.show();
      // AnalitikaArtController.stisniButton2();

}
    
           
    public static void showRucnaKorekcijaKol() throws IOException  {

        
         Stage stageZamenski = new Stage();
        //Fill stage with content
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLRucnaKorekcijaKol.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageZamenski.setScene(scene);
       stageZamenski.setTitle("Rucna korekcija preporucenih količina");
       stageZamenski.setScene(new Scene(new ScrollPane(bpArt)));
       stageZamenski.show();
      // AnalitikaArtController.stisniButton2();

}
    
     public static void showSekundarnePozicije() throws IOException  {

        
         Stage stageZamenski = new Stage();
        //Fill stage with content
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLSekundarnePozicije.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageZamenski.setScene(scene);
       stageZamenski.setTitle("Sekundarne pozicije");
       stageZamenski.setScene(new Scene(new ScrollPane(bpArt)));
       stageZamenski.show();
      // AnalitikaArtController.stisniButton2();

}
    
 public static void showStatistikaArtikNaAkc() throws IOException  {

         
         Stage stageZamenski = new Stage();
        //Fill stage with content
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLStatistikaArtikNaAkc.fxml"));
       Pane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageZamenski.setScene(scene);
       stageZamenski.setTitle("Pregledi istorijskih akcija artikala");
       stageZamenski.setScene(new Scene(new ScrollPane(bpArt)));
       stageZamenski.show();
        loader_static=loader;
}    

public static void showAkcije() throws IOException  {

        
         Stage stageZamenski = new Stage();
        //Fill stage with content
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLProzorAutoPunjenjeAkcController.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageZamenski.setScene(scene);
       stageZamenski.setTitle("Odaberite artikal");
       stage_static=stageZamenski;
       stageZamenski.setScene(new Scene(new ScrollPane(bpArt)));
       stageZamenski.show();
 
      
      // AnalitikaArtController.stisniButton2();

}

public static void showAkcije2maska() throws IOException  {

        
         Stage stageZamenski = new Stage();
        
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLMpAkcMarketing.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageZamenski.setScene(scene);
       stageZamenski.setTitle("Marketing");
       stage_static=stageZamenski;
       stageZamenski.setScene(new Scene(new ScrollPane(bpArt)));
       stageZamenski.show();
 
      
     

}

public static void showVikendAkcija() throws IOException  {

        
         Stage stageZamenski = new Stage();
        
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLVikendAkcija.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageZamenski.setScene(scene);
       stageZamenski.setTitle("Vikend akcija");
       stage_static=stageZamenski;
       stageZamenski.setScene(new Scene(new ScrollPane(bpArt)));
       stageZamenski.show();
 
      
     

}


public static void showObradaVikendAkcija() throws IOException  {

        
         Stage stageZamenski = new Stage();
        
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLObracunVikend.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageZamenski.setScene(scene);
       stageZamenski.setTitle("Vikend akcija - analiticki uvid u akciju");
       stage_static=stageZamenski;
       stageZamenski.setScene(new Scene(new ScrollPane(bpArt)));
       stageZamenski.show();
 
      
     

}
public static void showIzuzeciIzAsortimana() throws IOException  {

        
         Stage stageZamenski = new Stage();
        
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLIzuzeciIzAsortimana.fxml"));
       BorderPane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageZamenski.setScene(scene);
       stageZamenski.setTitle("Izuzeci iz asortimana");
       stage_static=stageZamenski;
       stageZamenski.setScene(new Scene(new ScrollPane(bpArt)));
       stageZamenski.show();
}

public static void showPlanogram() throws IOException  {

        
         Stage stageZamenski = new Stage();
        
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLPlanogram.fxml"));
       Pane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageZamenski.setScene(scene);
       stageZamenski.setTitle("Planogram");
       stage_static=stageZamenski;
       stageZamenski.setScene(new Scene(new ScrollPane(bpArt)));
       stageZamenski.show();
}


public static void showRucnePreporuke() throws IOException  {

        
         Stage stageZamenski = new Stage();
        
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLRucnePreporuke.fxml"));
       Pane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageZamenski.setScene(scene);
       stageZamenski.setTitle("Rucne preporuke kolicina");
       stage_static=stageZamenski;
       stageZamenski.setScene(new Scene(new ScrollPane(bpArt)));
       stageZamenski.show();
}



public static void showRucneDopune() throws IOException  {

        
         Stage stageZamenski = new Stage();
        
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLRucneDopune.fxml"));
       Pane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageZamenski.setScene(scene);
       stageZamenski.setTitle("Rucne preporuke kolicina");
       stage_static=stageZamenski;
       stageZamenski.setScene(new Scene(new ScrollPane(bpArt)));
       stageZamenski.show();
}



public static void showMinimalneKolicine() throws IOException  {

        
         Stage stageZamenski = new Stage();
        
         
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(JavaFXTemplate.class.getResource("FXMLRucnePreporuke_2.fxml"));
       Pane  bpArt=loader.load();   
       Scene scene = new Scene (bpArt);
       stageZamenski.setScene(scene);
       stageZamenski.setTitle("Minimalne količine");
       stage_static=stageZamenski;
       stageZamenski.setScene(new Scene(new ScrollPane(bpArt)));
       stageZamenski.show();
}

}