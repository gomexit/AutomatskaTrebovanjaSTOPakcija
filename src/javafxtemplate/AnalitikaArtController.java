/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import static javafxtemplate.FXMLObracunControler.DBPASS;
import static javafxtemplate.FXMLObracunControler.DBURL;
import static javafxtemplate.FXMLObracunControler.DBUSER;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.eclipse.persistence.config.QueryHints;


/**
 * FXML Controller class
 *
 * @author bojan
 */
public class AnalitikaArtController implements Initializable {

    
        private EntityManager em;
     ObservableList<BVMpAkcNazVred> data;
     ObservableList<BVMpAkcNazivVredX7> AN_data;
     
     @FXML TextArea PK_opis;
     @FXML ComboBox cmbMagVP;
    
     @FXML   TableView tblArtikalAnalitika;
     @FXML   TableColumn<BVMpAkcNazVred,String> PK_NAZIV;
     @FXML   TableColumn<BVMpAkcNazVred,BigDecimal> PK_VREDNOST;
     @FXML   Label lbl;
     @FXML   Label lblArtikal;
     @FXML   Label lblOJ;
     @FXML   Label lblNazivIzvestaja;
   //  List<BVMpAkcNazVred>  results;
     
     @FXML   TableView tblAnaliticka;
     @FXML   TableColumn<BVMpAkcNazivVredX7,String> AN_NAZIV;
     @FXML   TableColumn<BVMpAkcNazivVredX7,BigDecimal> AN_VRED1;
     @FXML   TableColumn<BVMpAkcNazivVredX7,BigDecimal> AN_VRED2;
     @FXML   TableColumn<BVMpAkcNazivVredX7,BigDecimal> AN_VRED3;
     @FXML   TableColumn<BVMpAkcNazivVredX7,BigDecimal> AN_VRED4;
     @FXML   TableColumn<BVMpAkcNazivVredX7,BigDecimal> AN_VRED5;
     @FXML   TableColumn<BVMpAkcNazivVredX7,BigDecimal> AN_VRED6;
     @FXML   TableColumn<BVMpAkcNazivVredX7,BigDecimal> AN_VRED7;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
         stisniButton2();
         pozoviAnaliticku();
         menjajOpis();
         System.out.println("STARTOVAO INITIALIZE");
         
         
         
         
          List<String> list = new ArrayList<String>();
        list.add("DC ZRENJANIN");
        list.add("DC SABAC");
        list.add("RDC");
             
        ObservableList obList = FXCollections.observableList(list);
        cmbMagVP.getItems().clear();
        cmbMagVP.setItems(obList);
        
   
         
         /*
              tblArtikalAnalitika.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tblArtikalAnalitika.getSelectionModel().getSelectedItem() != null) 
        {    
          
         }
         }
     });*/
         
       //  lbl.setText(JavaFXTemplate.param_id_artikla.toString());
    }    
    
    @FXML
    public void stisniButton() {
        System.out.println("Ovo je stampa opet");
        
         //   List<BMpAkcije>  results =  em.createNamedQuery("BMpAkcije.findAll").getResultList();
        //List<BMpAkcije>  results =   em.createNativeQuery("SELECT a.id,a.tip_akcije FROM B_MP_AKCIJE a, b_mp_akcije_stavke_asw b where a.id=b.id", BMpAkcije.class).getResultList();
        List<BMpAkcije>  results =   em.createNativeQuery("select trim(naziv) as tip_akcije, vrednost1 as  id\n" +
"from table(\n" +
"bojanivetic.b_mp_akc_stanje_artikla\n" +
" (4,\n" +
" 4188,\n" +
"  '2'))", BMpAkcije.class).getResultList();        
//   data = FXCollections.observableArrayList(results);
           
        //   System.out.println(results.get(0).getId()+" d");
           
           for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i).getId()+" d");
		}
    }
    
     @FXML
    public  void stisniButton2() {
        System.out.println("Ovo je stampa opet");
       
        Integer p_id;
        Integer p_id_artikla;
        String p_oj;
        List<BVMpAkcNazVred>  results;
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
      //  em.refresh(BVMpAkcNazVred.class);
         /*   q = em.createNativeQuery("select trim(naziv) as naziv,vrednost1 as vrednost, vrednost2 as  broj\n" +
                    "from table(\n" +
                    "bojanivetic.b_mp_akc_stanje_artikla\n" +
                    " (?1,\n" +
                    " ?2,\n" +
                    "  ?3))", BVMpAkcNazVred.class).setParameter(1, p_id)
                    .setParameter(2, p_id_artikla)
                    .setParameter(3, p_oj);

 // em.setProperty("id", 4);
    List<BVMpAkcNazVred>  results=q.getResultList();*/
        
        String s="select trim(naziv) as naziv,vrednost1 as vrednost, vrednost2 as  broj\n" +
                    "from table(\n" +
                    "bojanivetic.b_mp_akc_stanje_artikla\n" +
                    " ("+JavaFXTemplate.param_id+",\n" +
                    " "+ JavaFXTemplate.param_id_artikla  +" ,\n" +
                    "" +JavaFXTemplate.param_OJ+ "))";
        
       // lbl.setText(s);
       
         results= em.createNativeQuery(s, BVMpAkcNazVred.class)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false") //ovo ide zbog osvezavanja gde createNativeQuery pravi problem
                 .getResultList();
        
//   data = FXCollections.observableArrayList(results);
           
        //   System.out.println(results.get(0).getId()+" d");
           System.out.println("id="+JavaFXTemplate.param_id);
           System.out.println("id_artikla="+JavaFXTemplate.param_id_artikla);
           System.out.println("oj="+JavaFXTemplate.param_OJ);
    /*       for (int i = 0; i < results.size(); i++) {
                      
			System.out.println(results.get(i).getNaziv()+" "+results.get(i).getVrednost());
                        s=s+" "+results.get(i).getVrednost() +" size="+results.size();
                    
                        
                 }    */   
             data = FXCollections.observableArrayList(results);
          
           
          PK_NAZIV=new TableColumn ("PK_NAZIV");
          PK_NAZIV.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazVred,String>("naziv"));
          
          PK_VREDNOST=new TableColumn ("PK_VREDNOST");
          PK_VREDNOST.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazVred,BigDecimal>("vrednost"));
          
           
          tblArtikalAnalitika.getColumns().setAll(PK_NAZIV,PK_VREDNOST);
     
          tblArtikalAnalitika.setItems(data);
          lblArtikal.setText(JavaFXTemplate.param_Artikal_naziv);
          lblOJ.setText(JavaFXTemplate.param_OJ_naziv);
          lblOJ.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
          lblArtikal.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
         
         // em.getTransaction().commit();
          /*PP_ID_AKCIJE=new TableColumn ("PP_ID_AKCIJE");
          PP_ID_AKCIJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcTrebovanje,Long>("idAkcije"));
          PP_ID_AKCIJE.setPrefWidth(90);
          PP_ID_AKCIJE.setText("id akcije");  */ 
         
		
    }
    
      @FXML
    public  void pozoviAnaliticku() {
        lblNazivIzvestaja.setText("ANALITICKA KARTICA PO DANIMA");
        System.out.println("Ovo je stampa opet");
       
        Integer p_id;
        Integer p_id_artikla;
        String p_oj;
        List<BVMpAkcNazivVredX7>  results;
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
        String s="select trim(naziv) as naziv,vred1,vred2,vred3,vred4,vred5,vred6,vred7\n" +
                    "from table(\n" +
                    "bojanivetic.b_mp_akc_izvestaji\n" +
                    " ("+JavaFXTemplate.param_id+",\n" +
                    " "+ JavaFXTemplate.param_id_artikla  +" ,\n" +
                    "" +JavaFXTemplate.param_OJ+ " ,"+w+"))";
        
       // lbl.setText(s);
       
         results= em.createNativeQuery(s, BVMpAkcNazivVredX7.class)
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
          
           
          AN_NAZIV=new TableColumn ("DAN");
          AN_NAZIV.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,String>("naziv"));
          
          AN_VRED1=new TableColumn ("PRIJEM");
          AN_VRED1.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred1"));
          
          AN_VRED2=new TableColumn ("PRIJEM_AT");
          AN_VRED2.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred2"));
          
          AN_VRED3=new TableColumn ("PRODAJA");
          AN_VRED3.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred3"));
          
          AN_VRED4=new TableColumn ("OSTALE_PROMENE");
          AN_VRED4.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred4"));
          
          AN_VRED5=new TableColumn ("ZALIHA");
          AN_VRED5.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred5"));
          
          AN_VRED7=new TableColumn ("AN_VRED7");
          AN_VRED7.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred7"));
          
        
          
           
          tblAnaliticka.getColumns().setAll(AN_NAZIV,AN_VRED1,AN_VRED2,AN_VRED3,AN_VRED4,AN_VRED5);
     
          tblAnaliticka.setItems(AN_data);
     /*     lblArtikal.setText(JavaFXTemplate.param_Artikal_naziv);
          lblOJ.setText(JavaFXTemplate.param_OJ_naziv);
          lblOJ.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
          lblArtikal.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        */ 
         // em.getTransaction().commit();
          /*PP_ID_AKCIJE=new TableColumn ("PP_ID_AKCIJE");
          PP_ID_AKCIJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcTrebovanje,Long>("idAkcije"));
          PP_ID_AKCIJE.setPrefWidth(90);
          PP_ID_AKCIJE.setText("id akcije");  */ 
         
		
    }
    
    
    public void menjajOpis() {
       
         tblArtikalAnalitika.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tblArtikalAnalitika.getSelectionModel().getSelectedItem() != null) 
        {    
                System.out.println(data.get(tblArtikalAnalitika.getSelectionModel().getSelectedIndex()).getNaziv());
                 Integer p_id;
              Integer p_id_artikla;
              String p_oj;
              List<BVMpAkcNazVred>  results ;

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

           em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
              em.clear();
              
             /*  String s="select trim(naziv) as naziv,vrednost1 as vrednost, vrednost2 as  broj\n" +
                    "from table(\n" +
                    "bojanivetic.b_mp_akc_stanje_artikla\n" +
                    " ("+JavaFXTemplate.param_id+",\n" +
                    " "+ JavaFXTemplate.param_id_artikla  +" ,\n" +
                    "" +JavaFXTemplate.param_OJ+ "))";*/
              
      //  String s=" select 1 as broj,substr(rouser.b_mp_akc_vrati_komentar   ( 4,93601,'25','DOPUNA 2 FF'),1,1999) as naziv,1 as vrednost   from dual";
        String s=" select 1 as broj,rouser.b_mp_akc_vrati_komentar   ( \n"+
               p_id+","+ p_id_artikla+","+p_oj+",'"+
                data.get(tblArtikalAnalitika.getSelectionModel().getSelectedIndex()).getNaziv()+ "')as naziv,1 as vrednost   from dual";
       // lbl.setText(s);
       
         results= em.createNativeQuery(s, BVMpAkcNazVred.class)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false") //ovo ide zbog osvezavanja gde createNativeQuery pravi problem
                 .getResultList();
          PK_opis.setText(results.get(0).getNaziv());
         }
         }
     });
        
    }
    
    
        
      @FXML
    public void pozoviReportAnalitickaVP() throws SQLException, JRException {
        
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        
        String v_oj="";
        
        if (cmbMagVP.getValue().toString().equals("DC ZRENJANIN")) v_oj="131";
        if (cmbMagVP.getValue().toString().equals("DC SABAC")) v_oj="139";
        if (cmbMagVP.getValue().toString().equals("RDC")) v_oj="138";
        
        
        HashMap param1=new HashMap();
        param1.put("P_ID",JavaFXTemplate.param_id);
        param1.put("P_ARTIKAL",JavaFXTemplate.param_id_artikla);
        param1.put("P_OJ",v_oj);
        
       //String reportPath ="E:\\Analiticka_po_dc.jrxml";
      String reportPath ="Analiticka_po_dc.jrxml";
        JasperReport jr=JasperCompileManager.compileReport(reportPath);
        JasperPrint jp = JasperFillManager.fillReport(jr, param1,con);
        JasperViewer.viewReport(jp,false);
        con.close();
        
    }
    
    
      @FXML
    public  void pozoviAnalitickuPoMesecima() {
         lblNazivIzvestaja.setText("ANALITICKA KARTICA PO MESECIMA");
        System.out.println("Ovo je stampa opet");
       
        Integer p_id;
        Integer p_id_artikla;
        String p_oj;
        List<BVMpAkcNazivVredX7>  results;
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
        String s="select trim(naziv) as naziv,vred1,vred2,vred3,vred4,vred5,vred6,vred7\n" +
                    "from table(\n" +
                    "bojanivetic.b_mp_akc_analiticka_mesecna\n" +
                    " ("+JavaFXTemplate.param_id+",\n" +
                    " "+ JavaFXTemplate.param_id_artikla  +" ,\n" +
                    "" +JavaFXTemplate.param_OJ+ " ,"+w+"))";
        
       // lbl.setText(s);
       
         results= em.createNativeQuery(s, BVMpAkcNazivVredX7.class)
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
          
           
          AN_NAZIV=new TableColumn ("DAN");
          AN_NAZIV.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,String>("naziv"));
          
          AN_VRED1=new TableColumn ("PRIJEM");
          AN_VRED1.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred1"));
          
          AN_VRED2=new TableColumn ("PRODAJA");
          AN_VRED2.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred2"));
          
          AN_VRED3=new TableColumn ("OSTALE PROMENE");
          AN_VRED3.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred3"));
          
          AN_VRED4=new TableColumn ("ZALIHA");
          AN_VRED4.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred4"));
         /* 
          AN_VRED5=new TableColumn ("ZALIHA");
          AN_VRED5.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred5"));
          
          AN_VRED7=new TableColumn ("AN_VRED7");
          AN_VRED7.setCellValueFactory(new PropertyValueFactory<BVMpAkcNazivVredX7,BigDecimal>("vred7"));
          */
        
          
           
          tblAnaliticka.getColumns().setAll(AN_NAZIV,AN_VRED1,AN_VRED2,AN_VRED3,AN_VRED4);
     
          tblAnaliticka.setItems(AN_data);
     /*     lblArtikal.setText(JavaFXTemplate.param_Artikal_naziv);
          lblOJ.setText(JavaFXTemplate.param_OJ_naziv);
          lblOJ.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
          lblArtikal.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        */ 
         // em.getTransaction().commit();
          /*PP_ID_AKCIJE=new TableColumn ("PP_ID_AKCIJE");
          PP_ID_AKCIJE.setCellValueFactory(new PropertyValueFactory<BVMpAkcTrebovanje,Long>("idAkcije"));
          PP_ID_AKCIJE.setPrefWidth(90);
          PP_ID_AKCIJE.setText("id akcije");  */ 
         
		
    }
    
    @FXML
    public void pozoviAnalitickuZaSveMPO() throws IOException {
         JavaFXTemplate.showAnalitikuArtiklaSVIMPO();
    }
    
}

