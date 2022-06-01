/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.swing.JOptionPane;
import oracle.net.ns.DataPacket;
import org.eclipse.persistence.config.QueryHints;

/**
 * FXML Controller class
 *
 * @author bojan
 */
public class FXMLListaAkcijaController implements Initializable {
    
     private EntityManager em;
     ObservableList<BMpAkcije> data;
     ObservableList<BMpAkcijeStavkeAsw> data2; 
     ObservableList<BVMpAkcKandidatiZaAkc> data3;
    
     
     
    @FXML
     TableView tabela;
    
    @FXML
     TableView tabela3;
    
    @FXML
     TableView tabela4;
    
     @FXML TableView tbl_KONK_izaberi_RG;
     @FXML TableView tbl_KONK_izaberi_RG_ART;
     @FXML TableView tbl_KONK_izabrano_RG;
     ObservableList<BVMpAkcNazVred> RG_data;
     ObservableList<BVMpAkcNazVred> RG2_data;
     ObservableList<BVMpAkcNazVred> RG_AR_data;
     
    
    @FXML  TableColumn<BMpAkcije,String> RG_SIFRA;
    @FXML  TableColumn<BMpAkcije,String> RG_NAZIV;
    
    @FXML  TableColumn<BMpAkcije,String> RG_AR_SIFRA;
    @FXML  TableColumn<BMpAkcije,String> RG_AR_NAZIV;
    
    @FXML  TableColumn<BMpAkcije,String> RG_SIFRA2;
    @FXML  TableColumn<BMpAkcije,String> RG_NAZIV2;
     
    
    @FXML
    TableColumn<BMpAkcije,Integer> ID;
    @FXML
    TableColumn<BMpAkcije,String> TIP_AKCIJE;
    @FXML
    TableColumn<BMpAkcije,Date> DATUM_OD;
    @FXML
    TableColumn<BMpAkcije,Date> DATUM_DO;
    @FXML
    TableColumn<BMpAkcije,String> STATUS;
    @FXML
    TableColumn<BMpAkcije,String> KOMENTAR;
    
    
       @FXML
    TableColumn<BMpAkcijeStavkeAsw,Integer> ID1;
       @FXML
    TableColumn<BMpAkcijeStavkeAsw,Integer> ID_AKCIJE;
       @FXML
    TableColumn<BMpAkcijeStavkeAsw,String> ID_KAMPANJE;
       @FXML
    TableColumn<BMpAkcijeStavkeAsw,String> KOMENTAR1;
       
       
          @FXML
    TableColumn<BMpAkcijeStavkeAsw,String> NAZIV_AKCIJE;
       @FXML
    TableColumn<BMpAkcijeStavkeAsw,Integer> ID_AKCIJE2;
       @FXML
    TableColumn<BMpAkcijeStavkeAsw,String> KAMPANJA;
       
       @FXML
       TextField txtTipAkcije;
       @FXML
       DatePicker dataPickerOD;
       @FXML
       DatePicker dataPickerDO;
       @FXML
       TextArea txtAreaKomentar;
       
       @FXML
       DatePicker dataPickerIzmenaOD1;
       @FXML
       DatePicker dataPickerIzmenaDO1;
       
   //placene sekundarne pozicije
       @FXML TableView tbl_PL_SEK;
    ObservableList<BVMpAkcSekundarnePlacene> PL_SEK_data;
       
   TableColumn<BVMpAkcSekundarnePlacene,Long> PL_SEK_ARTIKAL;
   TableColumn<BVMpAkcSekundarnePlacene,String> PL_SEK_SIFRA;    
   TableColumn<BVMpAkcSekundarnePlacene,String> PL_SEK_NAZIV;
  
       //neplacene sekundarne pozicije
       @FXML TableView tbl_NPL_SEK;
    ObservableList<BVMpAkcArtikBezPlSek> NPL_SEK_data;
       
   TableColumn<BVMpAkcArtikBezPlSek,Long> NPL_SEK_ARTIKAL;
   TableColumn<BVMpAkcArtikBezPlSek,String> NPL_SEK_SIFRA;    
   TableColumn<BVMpAkcArtikBezPlSek,String> NPL_SEK_NAZIV; 
   
   //iskljuceni artikli iz analize
        @FXML TableView tbl_ISKLJ;
    ObservableList<BVMpAkcIzvIskljArtik> ISKLJ_data;
       
   TableColumn<BVMpAkcIzvIskljArtik,Long> ISKLJ_ARTIKAL;
   TableColumn<BVMpAkcIzvIskljArtik,String> ISKLJ_SIFRA;    
   TableColumn<BVMpAkcIzvIskljArtik,String> ISKLJ_NAZIV;
   
   //iskljuceni mpo iz analize
    @FXML TableView tbl_ISKLJ_MPO;
    ObservableList<BVMpAkcIzvIskljMpo> ISKLJ_MPO_data;
  
    TableColumn<BVMpAkcIzvIskljMpo,Long> ISKLJ_MPO_ORGJED;    
    TableColumn<BVMpAkcIzvIskljMpo,String> ISKLJ_MPO_NAZIV;
   
      //nisu iskljuceni artikli iz analize
        @FXML TableView tbl_NISKLJ;
    ObservableList<BVMpAkcArtikBezIsljuc> NISKLJ_data;
       
   TableColumn<BVMpAkcArtikBezIsljuc,Long> NISKLJ_ARTIKAL;
   TableColumn<BVMpAkcArtikBezIsljuc,String> NISKLJ_SIFRA;    
   TableColumn<BVMpAkcArtikBezIsljuc,String> NISKLJ_NAZIV;
   
   //nisu iskljuceni orgjed iz analize
        @FXML TableView tbl_NISKLJ_ORGJED;
    ObservableList<BVMpAkcMpoBezIsljuc> data_NISKLJ_ORGJED;
       
   TableColumn<BVMpAkcMpoBezIsljuc,String> NISKLJ_ORGJED_ORGJED;
   TableColumn<BVMpAkcMpoBezIsljuc,String> NISKLJ_ORGJED_SIFRA;    
   TableColumn<BVMpAkcMpoBezIsljuc,String> NISKLJ_ORGJED_NAZIV;
   
   
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.em = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU").createEntityManager();
        popuniInicijalno();
        popuniAkcijeKandidate();
        System.out.println("usao");
    }    

    private void popuniInicijalno() {
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
           System.out.println("Selected Value" + val);
           System.out.println("red je "+selectedCells.get(0).toString());
           
           
           List<BMpAkcije> selected = selectionModel.getSelectedItems();
           System.out.println("red je "+tabela.getSelectionModel().getSelectedIndex());
           System.out.println("polje je "+data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
          popuniStavke( data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
          prikaziPlaceneSekPozicije(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
          prikaziNePlaceneSekPozicije(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
          prikaziIskljuceneArtikle(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
          prikaziNeIskljuceneArtikle(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
          
          // refreshTabele4 (data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
           prikaziSveRG();
          prikaziOdabraneRG();
          
          prikaziNeIskljuceneMPO(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
          prikaziIskljuceneMPO(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
          
          
          DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d.MM.uuuu");
          dataPickerIzmenaOD1.setValue(LocalDate.parse(data.get(tabela.getSelectionModel().getSelectedIndex()).getDatumOd(),formatters));
          dataPickerIzmenaDO1.setValue(LocalDate.parse(data.get(tabela.getSelectionModel().getSelectedIndex()).getDatumDo(),formatters));
           
         }
         }
     });
           
           
                      tbl_KONK_izaberi_RG.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tbl_KONK_izaberi_RG.getSelectionModel().getSelectedItem() != null) 
        {    
          
           TableView.TableViewSelectionModel selectionModel = tbl_KONK_izaberi_RG.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);
          
           prikaziArtikleRG();

           
         }
         }
     });
           
    }
    
    
    
    public void refreshZaglavlja () {
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
    }
    public void popuniStavke(Integer i){
        em.clear();
         List<BMpAkcijeStavkeAsw>  results2 =  em.createNamedQuery("BVMpAkcijeStavkeAsw.findById")
                 .setParameter("id", i)
                 .getResultList();
         data2 = FXCollections.observableArrayList(results2);
          
          ID_AKCIJE=new TableColumn ("ID_AKCIJE");
          ID_AKCIJE.setCellValueFactory(new PropertyValueFactory<>("idAkcije"));
          
          ID1=new TableColumn ("ID1");
          ID1.setCellValueFactory(new PropertyValueFactory<>("id"));
          
          ID_KAMPANJE=new TableColumn ("ID_KAMPANJE");
          ID_KAMPANJE.setCellValueFactory(new PropertyValueFactory<BMpAkcijeStavkeAsw,String>("idKampanje"));
          
                   
          KOMENTAR1=new TableColumn ("KOMENTAR1");
          KOMENTAR1.setCellValueFactory(new PropertyValueFactory<BMpAkcijeStavkeAsw,String>("komentar"));
          
          
          
          tabela3.getColumns().setAll(ID1,ID_AKCIJE,ID_KAMPANJE,KOMENTAR1);
     
          tabela3.setItems(data2);
    }
    
    @FXML
    public void unesiNovuAkciju(){
          em.clear();
           em.getTransaction().begin();
        BMpAkcije b = new BMpAkcije();
       
        b.setId((Integer) vratiNoviRbr());
        b.setDatumOd(java.sql.Date.valueOf(dataPickerOD.getValue()));
        b.setDatumDo(java.sql.Date.valueOf(dataPickerDO.getValue()));
        b.setStatus("O");
        b.setTipAkcije(txtTipAkcije.getText());
        b.setKomentar(txtAreaKomentar.getText());
    //  b.setTrazenaKolPoObjektu( new BigDecimal(jFormattedTxtKOL.getText()));
     // b.setTrazenaKolPoObjektu(jFormattedTxtKOL.getn);
        //  b.setTrazenaKolPoObjektu( new BigDecimal(jTxtKol.getText()));
      //  b.setDatum(jXDatePicker1.getDate());
        
        em.persist(b);
        em.getTransaction().commit();
        refreshZaglavlja () ;
        JOptionPane.showMessageDialog(null, "Uneli ste novu akciju");
        
        txtAreaKomentar.setText("");
        txtTipAkcije.setText("");
    }
    
        @FXML
    public void izmeniSelektovanuAkciju(){
            
            int row = tabela.getSelectionModel().getSelectedIndex();
            if(row == -1){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Greska");
                alert.setContentText("Morate selektovati akciju!");
                alert.showAndWait();  
                return;
            };
            em.clear();
            em.getTransaction().begin();
            
            List<BMpAkcije> b  =  em.createNamedQuery("BMpAkcije.findById")
               .setParameter("id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId())
                // .setHint(QueryHints.MAINTAIN_CACHE, "false")
               .getResultList();
            if (b.get(0).getStatus().matches("R") == false){
                JOptionPane.showMessageDialog(null, "Samo akcije u statusu \"R\" mogu biti izmenjene");
                em.getTransaction().rollback();
                return;
            }
            if (!b.isEmpty())
                {
                    Date datumIzmeneOd = null,datumIzmeneDo = null;
                    if (dataPickerIzmenaOD1.getValue() == null || dataPickerIzmenaDO1.getValue() == null){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText("Greska");
                        alert.setContentText("Sva polja moraju biti popunjena!");
                        alert.showAndWait();  
                        em.getTransaction().rollback();
                        return;
                    }
                    datumIzmeneOd = java.sql.Date.valueOf(dataPickerIzmenaOD1.getValue());
                    datumIzmeneDo = java.sql.Date.valueOf(dataPickerIzmenaDO1.getValue());
                    
                    b.get(0).setDatumOd(datumIzmeneOd);
                    b.get(0).setDatumDo(datumIzmeneDo);
                    em.getTransaction().commit();
                }
            refreshZaglavlja () ;
            JOptionPane.showMessageDialog(null, "Izmenili ste akciju");
//            System.out.println("Rado");

    }
    
    public Integer vratiNoviRbr() {
           int s;
        s = 0;
        try {    
           //  JOptionPane.showMessageDialog(this, jTable1.getValueAt(jTable1.getSelectedRow(), 1));
              em.clear();
            List  results =  em.createNamedQuery( "BMpAkcije.MaxId").getResultList();
            if(!results.isEmpty()){
                String v_a=results.get(0).toString();
                 s = Integer.parseInt(v_a);
                s=s+1;
               // JOptionPane.showMessageDialog(this, "ipak usao ovde");
               
}
            else  { s=1; }
           // jTxtOJ.setText(queryOJ.getSingleResult().);
        } catch (Exception e) {
             s=1; //izaziva nullpionterexception i novi slog je u pitanju i dodeljujemo 1
        }
      //  JOptionPane.showMessageDialog(this, " rbr stavke je "+s);
        
        return s;
       
    }
    

    
    
     public void popuniAkcijeKandidate(){
           em.clear();
         List<BVMpAkcKandidatiZaAkc>  results2 =  em.createNamedQuery("BVMpAkcKandidatiZaAkc.findAll").getResultList();
         data3 = FXCollections.observableArrayList(results2);
          
          ID_AKCIJE2=new TableColumn ("ID_AKCIJE2");
          ID_AKCIJE2.setCellValueFactory(new PropertyValueFactory<>("idAkcije"));
          
          KAMPANJA=new TableColumn ("KAMPANJA");
          KAMPANJA.setCellValueFactory(new PropertyValueFactory<BMpAkcijeStavkeAsw,String>("kampanja"));
          
                   
          NAZIV_AKCIJE=new TableColumn ("NAZIV_AKCIJE");
          NAZIV_AKCIJE.setCellValueFactory(new PropertyValueFactory<BMpAkcijeStavkeAsw,String>("nazivAkcije"));
          
          
          
          tabela4.getColumns().setAll(ID_AKCIJE2,KAMPANJA,NAZIV_AKCIJE);
     
          tabela4.setItems(data3);
    }
     
     @FXML
     public void prebaciAkciju() {
         //
      
          //prvo proveri status. Ako je O i R mozes generisati matricu razvoza
        String v_status=data.get(tabela.getSelectionModel().getSelectedIndex()).getStatus(); 
if  ( (v_status.equals("O")   )||(v_status.equals("R"  ) ) )
                { 
                        if(tabela.getSelectionModel().getSelectedItem() != null) 
                      {    


                          if(tabela4.getSelectionModel().getSelectedItem() != null) 
                                   {  


                                    em.clear();
                                  em.getTransaction().begin();
                               BMpAkcijeStavkeAsw b = new BMpAkcijeStavkeAsw();



                               BMpAkcijeStavkeAswPK q = new BMpAkcijeStavkeAswPK();

                               q.setIdAkcije(data3.get(tabela4.getSelectionModel().getSelectedIndex()).getIdAkcije().intValue());
                               q.setIdKampanje(data3.get(tabela4.getSelectionModel().getSelectedIndex()).getKampanja());
                               q.setId(data.get(tabela.getSelectionModel().getSelectedIndex()).getId().longValue());

                               b.setBMpAkcijeStavkeAswPK(q);
                               b.setKomentar(data3.get(tabela4.getSelectionModel().getSelectedIndex()).getNazivAkcije());

                               em.persist(b);
                               em.getTransaction().commit();
                               popuniStavke( data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
                              // refreshZaglavlja () ;
                               JOptionPane.showMessageDialog(null, "Uneli ste novu akciju iz ERP-a");
                                 }
                          else JOptionPane.showMessageDialog(null, "Selektujete akciju iz ERP-a koju zelite da prebacite");

                       }
                }              
         else 
        {
                     Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                     alert1.setTitle("Information Dialog");
                     alert1.setHeaderText("Greska!");
                     alert1.setContentText("Status nije O ili R. Ne mozete menjati odabrane akcije!");
                     alert1.showAndWait();
        }               
         
     }
     
     public void vratiAkciju() {
         
      //prvo proveri status. Ako je O i R mozes generisati matricu razvoza
        String v_status=data.get(tabela.getSelectionModel().getSelectedIndex()).getStatus(); 
if  ( (v_status.equals("O")   )||(v_status.equals("R"  ) ) )
                {     
         
         
           if ((tabela3.getSelectionModel().getSelectedIndex()>-1)  )
       {
          if(!em.getTransaction().isActive())  em.getTransaction().begin(); 
           em.clear();
         //  em.close();
          
             
      
  
           
           BVMpAkcijeStavkeAsw a=(BVMpAkcijeStavkeAsw) tabela3.getSelectionModel().getSelectedItem();
           
           Long v_br_akcije=a.getIdAkcije();
            // v_br_akcije=data22.get(tabela3.getSelectionModel().getSelectedIndex()).getIdAkcije();
           //  JOptionPane.showMessageDialog(null, "broj akcije je"+v_br_akcije);
             
       List<BMpAkcijeStavkeAsw> b  =  em.createNamedQuery("BMpAkcijeStavkeAsw.findByIdAkcije")
                            .setParameter("idAkcije", v_br_akcije)
                            .getResultList();

                    if (!b.isEmpty())
                            {
                               
                                   em.remove(b.get(0));
                                   em.getTransaction().commit();
                                   popuniStavke( data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
                                   JOptionPane.showMessageDialog(null, "Obrisali ste akciju broj: "+v_br_akcije);
                                   
                                  
                            }
                     

         }
           else
                            {
                                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                 alert.setTitle("Information Dialog");
                                 alert.setHeaderText("Greska!");
                                 alert.setContentText("Proverite da li ste selektovali povezanu akciju!!");
                                 alert.showAndWait();  
                            }
           
           
        
}
else 
        {
                     Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                     alert1.setTitle("Information Dialog");
                     alert1.setHeaderText("Greska!");
                     alert1.setContentText("Status nije O ili R. Ne mozete menjati odabrane akcije!");
                     alert1.showAndWait();
        }   
           
           
           
     }
     
     
             @FXML
            public void generisiMatricuRazvoza()
    {
        //prvo proveri status. Ako je O i R mozes generisati matricu razvoza
        String v_status=data.get(tabela.getSelectionModel().getSelectedIndex()).getStatus();
        
        if  ( (v_status.equals("O")   )||(v_status.equals("R"  ) ) )
                {
                    
               
        
        System.out.println("stampa");
        //generisi matricu prvog punjenja
        em.getTransaction().begin();
        StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mp_akc_razvoz_prvo_punjenje");
        
        storedprocedure1.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
        storedprocedure1.registerStoredProcedureParameter("p_datum_od", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_datum_od", data.get(tabela.getSelectionModel().getSelectedIndex()).getDatumOd2());
        
        storedprocedure1.registerStoredProcedureParameter("p_datum_do", Date.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_datum_do", data.get(tabela.getSelectionModel().getSelectedIndex()).getDatumDo2());
        
        storedprocedure1.execute();
        em.getTransaction().commit();
        
        
        
        //generisu matricu za dopunu punjenja
        em.getTransaction().begin();
        StoredProcedureQuery storedprocedure = em.createStoredProcedureQuery("rouser.b_mp_akc_generisi_dopune");
        
        storedprocedure.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        storedprocedure.setParameter("p_id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
        storedprocedure.registerStoredProcedureParameter("p_datum_od", Date.class, ParameterMode.IN);
        storedprocedure.setParameter("p_datum_od", data.get(tabela.getSelectionModel().getSelectedIndex()).getDatumOd2());
        
        storedprocedure.registerStoredProcedureParameter("p_datum_do", Date.class, ParameterMode.IN);
        storedprocedure.setParameter("p_datum_do", data.get(tabela.getSelectionModel().getSelectedIndex()).getDatumDo2());
        
        storedprocedure.execute();
        em.getTransaction().commit();
        
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Akcijska trebovanja");
               alert.setHeaderText("Generisanje matrice razvoza  akcijskog trebovanja");
               alert.setContentText("Generisali ste matricu razvoza za prvo punjenje i dopunska trebovanja ");
               alert.showAndWait();  
               
               
               
       
           if ((tabela.getSelectionModel().getSelectedIndex()>-1)  )
       {
              em.getTransaction().begin();
           em.clear();   
       List<BMpAkcije> b  =  em.createNamedQuery( "BMpAkcije.findById").setParameter("id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId()).getResultList();

       if (!b.isEmpty())
                {
                    b.get(0).setStatus("R");
                    em.getTransaction().commit();
                }
                refreshZaglavlja ();
                }
       else
                {
                     Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                     alert1.setTitle("Information Dialog");
                     alert1.setHeaderText("Greska!");
                     alert1.setContentText("Proverite da li ste selektovali mesec koji brisete!!");
                     alert1.showAndWait();  
                }        
       }
        else 
        {
                     Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                     alert1.setTitle("Information Dialog");
                     alert1.setHeaderText("Greska!");
                     alert1.setContentText("Status nije O ili R. Matrica je vec generisana!");
                     alert1.showAndWait();
        }
    }
            
    
            
    public void prikaziSveRG() {
        
         em.clear();
        
        Integer i=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();  
         List<BVMpAkcNazVred>  results =   em.createNativeQuery("select naziv,sifra as vrednost,rownum as broj\n" +
"from (\n" +
"        select distinct rg.naziv,to_number(rg.sifra) as sifra\n" +
"        from b_mp_akcije_prepor_kol a, iis.robnegrupe rg,b_mp_akcije_stavke_asw asw,iis.artikli ar\n" +
"        where a.id_akcije=asw.id_akcije\n" +
"        and a.id_kampanje=asw.id_kampanje\n" +
"        and a.artikal=ar.id\n" +
"        and ar.robnagrupa=rg.sifra\n" +
"        and asw.id="+i+"\n" +
"        ) e\n" +
"        order by 1", BVMpAkcNazVred.class)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList(); 
        
        
  
          RG_data = FXCollections.observableArrayList(results);
          
          
           
          RG_NAZIV=new TableColumn ("naziv RG");
          RG_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          RG_NAZIV.setPrefWidth(290);
          
          RG_SIFRA=new TableColumn ("šifra RG");
          RG_SIFRA.setCellValueFactory(new PropertyValueFactory<>("vrednost"));
          RG_SIFRA.setPrefWidth(120);
          
          
    
          tbl_KONK_izaberi_RG.getColumns().setAll(RG_NAZIV,RG_SIFRA);
     
          tbl_KONK_izaberi_RG.setItems(RG_data);
        /*
          
              
    @FXML  TableColumn<BMpAkcije,String> RG_SIFRA;
    @FXML  TableColumn<BMpAkcije,String> RG_NAZIV;
    
    @FXML  TableColumn<BMpAkcije,String> RG_AR_SIFRA;
    @FXML  TableColumn<BMpAkcije,String> RG_AR_NAZIV;
    
    @FXML  TableColumn<BMpAkcije,String> RG_SIFRA2;
    @FXML  TableColumn<BMpAkcije,String> RG_NAZIV2;
        @FXML TableView tbl_KONK_izaberi_RG;
     @FXML TableView tbl_KONK_izaberi_RG_ART;
     @FXML TableView tbl_KONK_izabrano_RG;
     ObservableList<BVMpAkcNazVred> RG_data;
     ObservableList<BVMpAkcNazVred> RG2_data;
     ObservableList<BVMpAkcNazVred> RG_AR_data;
     
        */
    }
    
     public void prikaziArtikleRG() {
        
         em.clear();
        
        Integer i=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();  
        String v_rg=RG_data.get(tbl_KONK_izaberi_RG.getSelectionModel().getSelectedIndex()).getVrednost().toString();
         List<BVMpAkcNazVred>  results =   em.createNativeQuery("select naziv,sifra as vrednost,rownum as broj\n" +
"from (\n" +
"        select distinct ar.naziv,to_number(ar.sifra) as sifra\n" +
"        from b_mp_akcije_prepor_kol a, b_mp_akcije_stavke_asw asw,iis.artikli ar\n" +
"        where a.id_akcije=asw.id_akcije\n" +
"        and a.id_kampanje=asw.id_kampanje\n" +
"        and a.artikal=ar.id\n" +
"        and asw.id="+i+"\n" +
"        and ar.robnagrupa='"+v_rg+"'\n" +
"        ) e\n" +
"        order by 1", BVMpAkcNazVred.class)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList(); 
        
        
  
          RG_AR_data = FXCollections.observableArrayList(results);
          
                     
          RG_AR_NAZIV=new TableColumn ("naziv artikla");
          RG_AR_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          RG_AR_NAZIV.setPrefWidth(290);
          
          RG_AR_SIFRA=new TableColumn ("šifra ");
          RG_AR_SIFRA.setCellValueFactory(new PropertyValueFactory<>("vrednost"));
          RG_AR_SIFRA.setPrefWidth(120);
          
          
    
          tbl_KONK_izaberi_RG_ART.getColumns().setAll(RG_AR_NAZIV,RG_AR_SIFRA);
     
          tbl_KONK_izaberi_RG_ART.setItems(RG_AR_data);
        /*
          
              
    @FXML  TableColumn<BMpAkcije,String> RG_SIFRA;
    @FXML  TableColumn<BMpAkcije,String> RG_NAZIV;
    
    @FXML  TableColumn<BMpAkcije,String> RG_AR_SIFRA;
    @FXML  TableColumn<BMpAkcije,String> RG_AR_NAZIV;
    
    @FXML  TableColumn<BMpAkcije,String> RG_SIFRA2;
    @FXML  TableColumn<BMpAkcije,String> RG_NAZIV2;
        @FXML TableView tbl_KONK_izaberi_RG;
     @FXML TableView tbl_KONK_izaberi_RG_ART;
     @FXML TableView tbl_KONK_izabrano_RG;
     ObservableList<BVMpAkcNazVred> RG_data;
     ObservableList<BVMpAkcNazVred> RG2_data;
     ObservableList<BVMpAkcNazVred> RG_AR_data;
     
        */
    }
            
            
    public void prikaziOdabraneRG() {
        
         em.clear();
        
        Integer i=data.get(tabela.getSelectionModel().getSelectedIndex()).getId();  
        List<BVMpAkcNazVred>  results =   em.createNativeQuery("SELECT rg.naziv,  to_number(rg.sifra) as vrednost, rownum as broj\n" +
"  FROM b_mp_akc_konkurentni_rg a,iis.robnegrupe rg\n" +
"  where rg.sifra=a.rg\n" +
"  and id="+i, BVMpAkcNazVred.class)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList(); 
        
        
  
          RG2_data = FXCollections.observableArrayList(results);
          
                     
          RG_NAZIV2=new TableColumn ("naziv artikla");
          RG_NAZIV2.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          RG_NAZIV2.setPrefWidth(290);
          
          RG_SIFRA2=new TableColumn ("šifra ");
          RG_SIFRA2.setCellValueFactory(new PropertyValueFactory<>("vrednost"));
          RG_SIFRA2.setPrefWidth(120);
          
          
    
          tbl_KONK_izabrano_RG.getColumns().setAll(RG_NAZIV2,RG_SIFRA2);
     
          tbl_KONK_izabrano_RG.setItems(RG2_data);

    }     
    
    
   @FXML public void  unesiNovuRG() {
        em.getTransaction().begin();
        StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mp_akc_unesi_rg_konkur");
        
        storedprocedure1.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
        storedprocedure1.registerStoredProcedureParameter("p_sifra_rg", String.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_sifra_rg", RG_data.get(tbl_KONK_izaberi_RG.getSelectionModel().getSelectedIndex()).getVrednost().toString());
        
       
        storedprocedure1.execute();
        em.getTransaction().commit();
        
        prikaziOdabraneRG();
   }
   
   
      @FXML public void  obrisiRG() {
        em.getTransaction().begin();
        StoredProcedureQuery storedprocedure1 = em.createStoredProcedureQuery("rouser.b_mp_akc_obrisi_rg_konkur");
        
        storedprocedure1.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_id", data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
        storedprocedure1.registerStoredProcedureParameter("p_sifra_rg", String.class, ParameterMode.IN);
        storedprocedure1.setParameter("p_sifra_rg", RG2_data.get(tbl_KONK_izabrano_RG.getSelectionModel().getSelectedIndex()).getVrednost().toString());
        
       
        storedprocedure1.execute();
        em.getTransaction().commit();
        
        prikaziOdabraneRG();
   }
      
      
      public void prikaziPlaceneSekPozicije(Integer i)
      {
          
            em.clear();
         List<BVMpAkcSekundarnePlacene>  results2 =  em.createNamedQuery("BVMpAkcSekundarnePlacene.findById")
                  .setParameter("id", i)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList();
         PL_SEK_data = FXCollections.observableArrayList(results2);
          
          PL_SEK_ARTIKAL=new TableColumn ("artikal");
          PL_SEK_ARTIKAL.setCellValueFactory(new PropertyValueFactory<>("artikal"));
          
          PL_SEK_SIFRA=new TableColumn ("sifra artikla");
          PL_SEK_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          
                   
          PL_SEK_NAZIV=new TableColumn ("naziv artikla");
          PL_SEK_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          
          
          tbl_PL_SEK.getColumns().setAll(PL_SEK_ARTIKAL,PL_SEK_SIFRA,PL_SEK_NAZIV);
     
          tbl_PL_SEK.setItems(PL_SEK_data);
          
          
          
          
          
          /*
              @FXML TableView tbl_PL_SEK;
    ObservableList<BVMpAkcSekundarnePlacene> PL_SEK_data;
       
   TableColumn<BVMpAkcSekundarnePlacene,Long> PL_SEK_ARTIKAL;
   TableColumn<BVMpAkcSekundarnePlacene,String> PL_SEK_SIFRA;    
   TableColumn<BVMpAkcSekundarnePlacene,String> PL_SEK_NAZIV;
          */
      }
      
      
      
       public void prikaziNePlaceneSekPozicije(Integer i)
      {
          
            em.clear();
         List<BVMpAkcArtikBezPlSek>  results2 =  em.createNamedQuery("BVMpAkcArtikBezPlSek.findByIdAkcije")
                  .setParameter("idAkcije", i)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList();
         NPL_SEK_data = FXCollections.observableArrayList(results2);
          
          NPL_SEK_ARTIKAL=new TableColumn ("artikal");
          NPL_SEK_ARTIKAL.setCellValueFactory(new PropertyValueFactory<>("artikal"));
          
          NPL_SEK_SIFRA=new TableColumn ("sifra artikla");
          NPL_SEK_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          
                   
          NPL_SEK_NAZIV=new TableColumn ("naziv artikla");
          NPL_SEK_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          
          
          tbl_NPL_SEK.getColumns().setAll(NPL_SEK_ARTIKAL,NPL_SEK_SIFRA,NPL_SEK_NAZIV);
     
          tbl_NPL_SEK.setItems(NPL_SEK_data);

      }
       
       
       @FXML
       public void dodajPlacenuSekPoz() {
      em.clear();
      em.getTransaction().begin();
      
      BMpAkcSekundarnePlacene b = new BMpAkcSekundarnePlacene();
      BMpAkcSekundarnePlacenePK c = new BMpAkcSekundarnePlacenePK();
      
      
      c.setArtikal(NPL_SEK_data.get(tbl_NPL_SEK.getSelectionModel().getSelectedIndex()).getArtikal());
      c.setId(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
           
      b.setBMpAkcSekundarnePlacenePK(c);
      em.persist(b);
      em.getTransaction().commit();
        
         prikaziPlaceneSekPozicije(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
         prikaziNePlaceneSekPozicije(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
      
      
           
      
       }
       @FXML
       public void dodajSvePlaceneSekPoz(){
            int row = tabela.getSelectionModel().getSelectedIndex();
            if(row == -1){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Greska");
                alert.setContentText("Morate selektovati akciju!");
                alert.showAndWait();  
                return;
            };
            for (BVMpAkcArtikBezPlSek d: NPL_SEK_data){
                em.clear();
                em.getTransaction().begin();

                BMpAkcSekundarnePlacene b = new BMpAkcSekundarnePlacene();
                BMpAkcSekundarnePlacenePK c = new BMpAkcSekundarnePlacenePK();


                c.setArtikal(d.getArtikal());
                c.setId(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());

                b.setBMpAkcSekundarnePlacenePK(c);
                em.persist(b);
                em.getTransaction().commit();
            }
           prikaziPlaceneSekPozicije(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
           prikaziNePlaceneSekPozicije(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
           
       }
       
         
       @FXML
       public void obrisiPlacenuSekPoz() {
    
                 
         
            if ((tbl_PL_SEK.getSelectionModel().getSelectedIndex()>-1)  )
       {
              em.getTransaction().begin();
             
       List<BMpAkcSekundarnePlacene> b  =  em.createNamedQuery("BMpAkcSekundarnePlacene.findByOba")
               .setParameter("id", PL_SEK_data.get(tbl_PL_SEK.getSelectionModel().getSelectedIndex()).getId())
               .setParameter("artikal", PL_SEK_data.get(tbl_PL_SEK.getSelectionModel().getSelectedIndex()).getArtikal())
               .getResultList();

       if (!b.isEmpty())
       {
              em.remove(b.get(0));
              em.getTransaction().commit();
       }
         prikaziPlaceneSekPozicije(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
         prikaziNePlaceneSekPozicije(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Brisanje artikla na listi placenih sekundarnih pozicija");
            alert.setContentText("Obrisali ste placenu sekundarnu poziciju");
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
       
       
         public void prikaziIskljuceneArtikle(Integer i)
      {
          
            em.clear();
         List<BVMpAkcIzvIskljArtik>  results2 =  em.createNamedQuery("BVMpAkcIzvIskljArtik.findById")
                  .setParameter("id", i)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                  .getResultList();
          ISKLJ_data = FXCollections.observableArrayList(results2);
          
          ISKLJ_ARTIKAL=new TableColumn ("artikal");
          ISKLJ_ARTIKAL.setCellValueFactory(new PropertyValueFactory<>("idArtikla"));
          
          ISKLJ_SIFRA=new TableColumn ("sifra artikla");
          ISKLJ_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          
                   
          ISKLJ_NAZIV=new TableColumn ("naziv artikla");
          ISKLJ_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          
          
          tbl_ISKLJ.getColumns().setAll(ISKLJ_ARTIKAL,ISKLJ_SIFRA,ISKLJ_NAZIV);
     
          tbl_ISKLJ.setItems(ISKLJ_data);
          
          
          
          

      }
         
         //prikazuje iskljucene mpo
          public void prikaziIskljuceneMPO(Integer i)
      {
          
            em.clear();
         List<BVMpAkcIzvIskljMpo>  results2 =  em.createNamedQuery("BVMpAkcIzvIskljMpo.findById")
                  .setParameter("id", i)
                  .setHint(QueryHints.MAINTAIN_CACHE, "false")
                  .getResultList();
          ISKLJ_MPO_data = FXCollections.observableArrayList(results2);
          
          
          ISKLJ_MPO_NAZIV=new TableColumn ("NAZIV");
          ISKLJ_MPO_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          ISKLJ_MPO_ORGJED=new TableColumn ("SIFRA");
          ISKLJ_MPO_ORGJED.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          
                   
          
          
          
          
          tbl_ISKLJ_MPO.getColumns().setAll(ISKLJ_MPO_ORGJED,ISKLJ_MPO_NAZIV);
     
          tbl_ISKLJ_MPO.setItems(ISKLJ_MPO_data);
          
          
          
          

      }

               public void prikaziNeIskljuceneArtikle(Integer i)
      {
          
            em.clear();
         List<BVMpAkcArtikBezIsljuc>  results2 =  em.createNamedQuery("BVMpAkcArtikBezIsljuc.findByIdAkcije")
                  .setParameter("idAkcije", i)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList();
         NISKLJ_data = FXCollections.observableArrayList(results2);
          
          NISKLJ_ARTIKAL=new TableColumn ("artikal");
          NISKLJ_ARTIKAL.setCellValueFactory(new PropertyValueFactory<>("artikal"));
          
          NISKLJ_SIFRA=new TableColumn ("sifra artikla");
          NISKLJ_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          
                   
          NISKLJ_NAZIV=new TableColumn ("naziv artikla");
          NISKLJ_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          
          
          tbl_NISKLJ.getColumns().setAll(NISKLJ_ARTIKAL,NISKLJ_SIFRA,NISKLJ_NAZIV);
     
          tbl_NISKLJ.setItems(NISKLJ_data);
          
          
          
          

      }
               
             
         
           public void prikaziNeIskljuceneMPO(Integer i)
      {
          
            em.clear();
         List<BVMpAkcMpoBezIsljuc>  results2 =  em.createNamedQuery("BVMpAkcMpoBezIsljuc.findByIdAkcije")
                  .setParameter("idAkcije", i)
                 .setHint(QueryHints.MAINTAIN_CACHE, "false")
                 .getResultList();
          
          data_NISKLJ_ORGJED = FXCollections.observableArrayList(results2);
          
          NISKLJ_ORGJED_ORGJED=new TableColumn ("ORGJED");
          NISKLJ_ORGJED_ORGJED.setCellValueFactory(new PropertyValueFactory<>("orgjed"));
          
          NISKLJ_ORGJED_SIFRA=new TableColumn ("SIFRA");
          NISKLJ_ORGJED_SIFRA.setCellValueFactory(new PropertyValueFactory<>("sifra"));
          
                   
          NISKLJ_ORGJED_NAZIV=new TableColumn ("NAZIV");
          NISKLJ_ORGJED_NAZIV.setCellValueFactory(new PropertyValueFactory<>("naziv"));
          
          
          
          tbl_NISKLJ_ORGJED.getColumns().setAll(NISKLJ_ORGJED_ORGJED,NISKLJ_ORGJED_NAZIV);
     
          tbl_NISKLJ_ORGJED.setItems(data_NISKLJ_ORGJED);
          
          
          
          

      }
   @FXML
       public void dodajIskljuceneArtikle() {
      em.clear();
      em.getTransaction().begin();
      
      BMpAkcIzvestajiIskljArtik b = new BMpAkcIzvestajiIskljArtik();
      BMpAkcIzvestajiIskljArtikPK c = new BMpAkcIzvestajiIskljArtikPK();
      
      
      c.setArtikal(NISKLJ_data.get(tbl_NISKLJ.getSelectionModel().getSelectedIndex()).getArtikal());
      c.setId(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
           
      b.setBMpAkcIzvestajiIskljArtikPK(c);
      em.persist(b);
      em.getTransaction().commit();
        
         
          prikaziNeIskljuceneArtikle(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
          prikaziIskljuceneArtikle(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
          
      
       }
       
       
       @FXML
       public void dodajIskljuceneMPO() {
      em.clear();
      em.getTransaction().begin();
      
      BMpAkcIzvestajiIskljMpo b = new BMpAkcIzvestajiIskljMpo();
      BMpAkcIzvestajiIskljMpoPK c = new BMpAkcIzvestajiIskljMpoPK();
      
      
      c.setOrgjed(data_NISKLJ_ORGJED.get(tbl_NISKLJ_ORGJED.getSelectionModel().getSelectedIndex()).getSifra());
      c.setId(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
           
      b.setBMpAkcIzvestajiIskljMpoPK(c);
      em.persist(b);
      em.getTransaction().commit();
        
         
          prikaziNeIskljuceneMPO(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
          prikaziIskljuceneMPO(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
      
       }
       
   @FXML
       public void obrisiIskljuceneArtikle() {
    
            
            if ((tbl_ISKLJ.getSelectionModel().getSelectedIndex()>-1)  )
       {
              em.getTransaction().begin();
             
       List<BMpAkcIzvestajiIskljArtik> b  =  em.createNamedQuery("BMpAkcIzvestajiIskljArtik.findByOba")
               .setParameter("id", ISKLJ_data.get(tbl_ISKLJ.getSelectionModel().getSelectedIndex()).getId())
               .setParameter("artikal", ISKLJ_data.get(tbl_ISKLJ.getSelectionModel().getSelectedIndex()).getIdArtikla())
               .getResultList();

       if (!b.isEmpty())
       {
              em.remove(b.get(0));
              em.getTransaction().commit();
       }
        prikaziNeIskljuceneArtikle(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
          prikaziIskljuceneArtikle(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Brisanje artikla na listi iskljucenih artikala");
            alert.setContentText("Obrisali ste iskljucene artikle");
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
          prikaziNeIskljuceneArtikle(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
          prikaziIskljuceneArtikle(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
      
       }
     
       @FXML
       public void obrisiIskljuceneMPO() {
    
            
            if ((tbl_ISKLJ_MPO.getSelectionModel().getSelectedIndex()>-1)  )
       {
              em.getTransaction().begin();
             
       List<BMpAkcIzvestajiIskljMpo> b  =  em.createNamedQuery("BMpAkcIzvestajiIskljMpo.findByOBA")
               .setParameter("id", ISKLJ_MPO_data.get(tbl_ISKLJ_MPO.getSelectionModel().getSelectedIndex()).getId())
               .setParameter("orgjed", ISKLJ_MPO_data.get(tbl_ISKLJ_MPO.getSelectionModel().getSelectedIndex()).getSifra())
               .getResultList();

       if (!b.isEmpty())
       {
              em.remove(b.get(0));
              em.getTransaction().commit();
       }
        prikaziNeIskljuceneMPO(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
          prikaziNeIskljuceneMPO(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Brisanje mpo na listi iskljucenih artikala");
            alert.setContentText("Obrisali ste iskljucene mpo");
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
          prikaziNeIskljuceneMPO(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
          prikaziIskljuceneMPO(data.get(tabela.getSelectionModel().getSelectedIndex()).getId());
      
       }
       
}
