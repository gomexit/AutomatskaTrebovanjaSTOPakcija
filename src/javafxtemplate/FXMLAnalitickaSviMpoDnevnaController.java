/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.eclipse.persistence.config.QueryHints;

/**
 * FXML Controller class
 *
 * @author bojan
 */
public class FXMLAnalitickaSviMpoDnevnaController implements Initializable {

    
            private EntityManager em;
     ObservableList<BVMpAkcNazVred> data;
     ObservableList<BVMpAkcNazivVredX11> AN_data;
         @FXML   TableView tblAnaliticka;
        TableColumn<BVMpAkcNazivVredX15,String> AN_NAZIV;
        TableColumn<BVMpAkcNazivVredX15,BigDecimal> AN_VRED1;
        TableColumn<BVMpAkcNazivVredX15,BigDecimal> AN_VRED2;
        TableColumn<BVMpAkcNazivVredX15,BigDecimal> AN_VRED3;
        TableColumn<BVMpAkcNazivVredX15,BigDecimal> AN_VRED4;
        TableColumn<BVMpAkcNazivVredX15,BigDecimal> AN_VRED5;
        TableColumn<BVMpAkcNazivVredX15,BigDecimal> AN_VRED6;
        TableColumn<BVMpAkcNazivVredX15,BigDecimal> AN_VRED7;
        TableColumn<BVMpAkcNazivVredX15,BigDecimal> AN_VRED8;
        TableColumn<BVMpAkcNazivVredX15,BigDecimal> AN_VRED9;
        TableColumn<BVMpAkcNazivVredX15,BigDecimal> AN_VRED10;
        TableColumn<BVMpAkcNazivVredX15,BigDecimal> AN_VRED11;
        TableColumn<BVMpAkcNazivVredX15,BigDecimal> AN_VRED12;
        TableColumn<BVMpAkcNazivVredX15,BigDecimal> AN_VRED13;
        TableColumn<BVMpAkcNazivVredX15,BigDecimal> AN_VRED14;
     
     
     @FXML Label lblNazivArtikla;
     @FXML LineChart LineChart1; //prodaja
     @FXML LineChart LineChart2; //zaliha i prodaja kumulativno
     @FXML LineChart LineChart3; //ko i oos
     @FXML BarChart BarChart4; //nule po danima
     
     @FXML Label L_akc_cena;
     @FXML Label L_prodaja_kom;
     @FXML Label L_prodaja_din;
     @FXML Label L_ko;
     @FXML Label L_oos;
     @FXML Label L_izgub_prodaja_kom;
     @FXML Label L_izgub_prodaja_din;
     @FXML Label L_izgub_prodaja_proc;
     @FXML Label L_uk_preporuka;
     @FXML Label L_ostvarenje_preporuke;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
        pozoviAnaliticku();
    } 
    
      @FXML
    public  void pozoviAnaliticku() {
        lblNazivArtikla.setText(JavaFXTemplate.param_Artikal_naziv);
        System.out.println("Ovo je stampa opet");
       
        Integer p_id;
        Integer p_id_artikla;
        String p_oj;
        List<BVMpAkcNazivVredX11>  results;
      /*  JavaFXTemplate.param_id=4;
        JavaFXTemplate.param_OJ="2";
        JavaFXTemplate.param_id_artikla=4188;*/
        
               
        p_id= JavaFXTemplate.param_id;
        p_id_artikla=JavaFXTemplate.param_id_artikla;
        p_oj=JavaFXTemplate.param_OJ;

       if (em != null) {
        if (em.getTransaction().isActive()) {
            em.flush();
            em.getTransaction().commit();
        }
        em.clear();
        if (em.isOpen()) {
            em.close();
        }
        em = null;
        }
    //  em.getTransaction().begin(); 
       
       this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
        em.clear(); 

        String w="1";
        String s="select trim(naziv) as naziv,vred1,vred2,vred3,vred4,vred5,vred6,vred7,vred8,"
                + "vred9,vred10,vred11,vred12,vred13,vred14,vred15\n" +
                    "from table(\n" +
                    "bojanivetic.b_mp_akc_izv_anal_sve_oj_dnevn\n" +
                    " ("+JavaFXTemplate.param_id+",\n" +
                    " "+ JavaFXTemplate.param_id_artikla  +" ,\n" +w+"))";
        
       // lbl.setText(s);
       
         results= em.createNativeQuery(s, BVMpAkcNazivVredX11.class)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false") //ovo ide zbog osvezavanja gde createNativeQuery pravi problem
                 .getResultList();
        
//   data = FXCollections.observableArrayList(results);
           
        //   System.out.println(results.get(0).getId()+" d");
           System.out.println("id="+JavaFXTemplate.param_id);
           System.out.println("id_artikla="+JavaFXTemplate.param_id_artikla);
           System.out.println("oj="+JavaFXTemplate.param_OJ);
        /*   for (int i = 0; i < results.size(); i++) {
                      
			System.out.println(results.get(i).getNaziv()+" "+results.get(i).getVrednost());
                        s=s+" "+results.get(i).getVrednost() +" size="+results.size();
                    
                        
                 }   */    
             AN_data = FXCollections.observableArrayList(results);
          
           
          AN_NAZIV=new TableColumn ("dan");
          AN_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          AN_VRED1=new TableColumn ("prijem");
          AN_VRED1.setCellValueFactory(new PropertyValueFactory<>("vred1"));
          
          AN_VRED2=new TableColumn ("narudz_AT");
          AN_VRED2.setCellValueFactory(new PropertyValueFactory<>("vred2"));
          
          AN_VRED3=new TableColumn ("prodaja");
          AN_VRED3.setCellValueFactory(new PropertyValueFactory<>("vred3"));
          
     
          
          AN_VRED5=new TableColumn ("zal MP");
          AN_VRED5.setCellValueFactory(new PropertyValueFactory<>("vred5"));
          
          AN_VRED7=new TableColumn ("AN_VRED7");
          AN_VRED7.setCellValueFactory(new PropertyValueFactory<>("vred7"));
          
          AN_VRED9=new TableColumn ("zal VP ZR");
          AN_VRED9.setCellValueFactory(new PropertyValueFactory<>("vred9"));
          
          AN_VRED10=new TableColumn ("zal VP ŠAB");
          AN_VRED10.setCellValueFactory(new PropertyValueFactory<>("vred10"));
          
          AN_VRED11=new TableColumn ("zal RDC");
          AN_VRED11.setCellValueFactory(new PropertyValueFactory<>("vred11"));
          
          AN_VRED4=new TableColumn ("nule dnevno");
          AN_VRED4.setCellValueFactory(new PropertyValueFactory<>("vred4"));
          
          AN_VRED7=new TableColumn ("KO");
          AN_VRED7.setCellValueFactory(new PropertyValueFactory<>("vred7"));
          
          AN_VRED8=new TableColumn ("OOS");
          AN_VRED8.setCellValueFactory(new PropertyValueFactory<>("vred8"));
          
        
          
           
          tblAnaliticka.getColumns().setAll(AN_NAZIV,AN_VRED1,AN_VRED2,AN_VRED3,AN_VRED5,AN_VRED9,AN_VRED10,AN_VRED11,AN_VRED4,AN_VRED7,AN_VRED8);
     
          tblAnaliticka.setItems(AN_data);
     
          
          //********punjenje grafika
          
          
          
                LineChart1.getData().clear();
                XYChart.Series<String,Number> series = new XYChart.Series<String, Number>();
                
                 LineChart2.getData().clear();
                XYChart.Series<String,Number> series2 = new XYChart.Series<String, Number>();
                XYChart.Series<String,Number> series3 = new XYChart.Series<String, Number>();
                
                
                 LineChart3.getData().clear();
                XYChart.Series<String,Number> series4 = new XYChart.Series<String, Number>();
                XYChart.Series<String,Number> series5 = new XYChart.Series<String, Number>();
                
                 BarChart4.getData().clear();
                XYChart.Series<String,Number> series6 = new XYChart.Series<String, Number>();
             //   XYChart.Series<String,Number> series2 = new XYChart.Series<String, Number>();

                for (int i = results.size(); i >0 ; i--)
                {
                               //System.out.println(results.get(i).getNaziv());
                               series.getData().add(new XYChart.Data<String, Number>(results.get(i-1).getNaziv(),results.get(i-1).getVred3()));
                               series2.getData().add(new XYChart.Data<String, Number>(results.get(i-1).getNaziv(),results.get(i-1).getVred5()));
                               series3.getData().add(new XYChart.Data<String, Number>(results.get(i-1).getNaziv(),results.get(i-1).getVred6()));
                               series4.getData().add(new XYChart.Data<String, Number>(results.get(i-1).getNaziv(),results.get(i-1).getVred7()));
                               series5.getData().add(new XYChart.Data<String, Number>(results.get(i-1).getNaziv(),results.get(i-1).getVred8()));
                               series6.getData().add(new XYChart.Data<String, Number>(results.get(i-1).getNaziv(),results.get(i-1).getVred4()));

                }
    
                
                series.setName("Prodaja po danima");
                series2.setName("Zaliha po danima");
                series3.setName("Prodaja kumulativ");
                series4.setName("Koeficijent obrta");
                series5.setName("OOS");
                series6.setName("Broj nula dnevno");
                LineChart1.getData().add(series);
                LineChart2.getData().add(series2);
                LineChart2.getData().add(series3);
                LineChart3.getData().add(series4);
                LineChart3.getData().add(series5);
                BarChart4.getData().add(series6);
               //  LineChart1.getData().add(series2);
		
          
          info();
          
    }
    
    
    
    public void info()  {
         this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
        em.clear(); 

        String w="1";
        String s="select trim(naziv) as naziv,vred1,vred2,vred3,vred4,vred5,vred6,vred7,vred8,vred9,vred10,vred11\n" +
                    "from table(\n" +
                    "bojanivetic.b_mp_akc_anal_sve_oj_info\n" +
                    " ("+JavaFXTemplate.param_id+",\n" +
                    " "+ JavaFXTemplate.param_id_artikla  +" ,\n" +w+"))";
        
        
      List<BVMpAkcNazivVredX11>    results_info= em.createNativeQuery(s, BVMpAkcNazivVredX11.class)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false") //ovo ide zbog osvezavanja gde createNativeQuery pravi problem
                 .getResultList();
         
        DecimalFormat df = new DecimalFormat("#,##0.00"); 
        df.format(new BigDecimal(123456.75));
        
        
        
        L_prodaja_kom.setText(df.format(results_info.get(0).getVred1()));
        L_izgub_prodaja_proc.setText(df.format(results_info.get(0).getVred2()));
        
        L_prodaja_din.setText(df.format(results_info.get(0).getVred3()));
        L_uk_preporuka.setText(df.format(results_info.get(0).getVred4()));
        L_ko.setText(df.format(results_info.get(0).getVred5()));
        L_akc_cena.setText(df.format(results_info.get(0).getVred6()));
        L_oos.setText(df.format(results_info.get(0).getVred7()));
        L_ostvarenje_preporuke.setText(df.format(results_info.get(0).getVred8()));
       // L_izgub_prodaja_kom.setText(results_info.get(0).getVred9().toString());
        L_izgub_prodaja_kom.setText(df.format(results_info.get(0).getVred9()));
        L_izgub_prodaja_din.setText(df.format(results_info.get(0).getVred10())   );
        
        
    }
  
    
}
