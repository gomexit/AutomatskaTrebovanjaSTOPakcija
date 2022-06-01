/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_V_MPV_AKC_MATRICA_RAZVOZ_DOP")
@NamedQueries({
    @NamedQuery(name = "BVMpvAkcMatricaRazvozDop.findAll", query = "SELECT b FROM BVMpvAkcMatricaRazvozDop b"),
    @NamedQuery(name = "BVMpvAkcMatricaRazvozDop.findByBroj", query = "SELECT b FROM BVMpvAkcMatricaRazvozDop b WHERE b.broj = :broj"),
    @NamedQuery(name = "BVMpvAkcMatricaRazvozDop.findById", query = "SELECT b FROM BVMpvAkcMatricaRazvozDop b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpvAkcMatricaRazvozDop.findByIdiNazivOJ", query = "SELECT b FROM BVMpvAkcMatricaRazvozDop b WHERE b.id = :id and b.nazivOj = :nazivOJ"),
    @NamedQuery(name = "BVMpvAkcMatricaRazvozDop.findByBrojDopune", query = "SELECT b FROM BVMpvAkcMatricaRazvozDop b WHERE b.brojDopune = :brojDopune"),
    @NamedQuery(name = "BVMpvAkcMatricaRazvozDop.findByOrgjed", query = "SELECT b FROM BVMpvAkcMatricaRazvozDop b WHERE b.orgjed = :orgjed"),
    @NamedQuery(name = "BVMpvAkcMatricaRazvozDop.findByNazivOj", query = "SELECT b FROM BVMpvAkcMatricaRazvozDop b WHERE b.nazivOj = :nazivOj"),
    @NamedQuery(name = "BVMpvAkcMatricaRazvozDop.findByMagacin", query = "SELECT b FROM BVMpvAkcMatricaRazvozDop b WHERE b.magacin = :magacin"),
    @NamedQuery(name = "BVMpvAkcMatricaRazvozDop.findByDatum", query = "SELECT b FROM BVMpvAkcMatricaRazvozDop b WHERE b.datum = :datum"),
    @NamedQuery(name = "BVMpvAkcMatricaRazvozDop.findByDanUNedelji", query = "SELECT b FROM BVMpvAkcMatricaRazvozDop b WHERE b.danUNedelji = :danUNedelji"),
    @NamedQuery(name = "BVMpvAkcMatricaRazvozDop.findByStatus", query = "SELECT b FROM BVMpvAkcMatricaRazvozDop b WHERE b.status = :status"),
    @NamedQuery(name = "BVMpvAkcMatricaRazvozDop.findByPocDatumProjekcije", query = "SELECT b FROM BVMpvAkcMatricaRazvozDop b WHERE b.pocDatumProjekcije = :pocDatumProjekcije"),
    @NamedQuery(name = "BVMpvAkcMatricaRazvozDop.findByKrajDatumProjekcije", query = "SELECT b FROM BVMpvAkcMatricaRazvozDop b WHERE b.krajDatumProjekcije = :krajDatumProjekcije"),
    @NamedQuery(name = "BVMpvAkcMatricaRazvozDop.findByPocDatumProjekcije2", query = "SELECT b FROM BVMpvAkcMatricaRazvozDop b WHERE b.pocDatumProjekcije2 = :pocDatumProjekcije2"),
    @NamedQuery(name = "BVMpvAkcMatricaRazvozDop.findByKrajDatumProjekcije2", query = "SELECT b FROM BVMpvAkcMatricaRazvozDop b WHERE b.krajDatumProjekcije2 = :krajDatumProjekcije2")})
public class BVMpvAkcMatricaRazvozDop implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "BROJ_DOPUNE")
    private int brojDopune;
    @Column(name = "ORGJED")
    private String orgjed;
    @Basic(optional = false)
    @Column(name = "NAZIV_OJ")
    private String nazivOj;
    @Column(name = "MAGACIN")
    private String magacin;
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Column(name = "DAN_U_NEDELJI")
    private String danUNedelji;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "POC_DATUM_PROJEKCIJE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pocDatumProjekcije;
    @Column(name = "KRAJ_DATUM_PROJEKCIJE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date krajDatumProjekcije;
    @Column(name = "POC_DATUM_PROJEKCIJE2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pocDatumProjekcije2;
    @Column(name = "KRAJ_DATUM_PROJEKCIJE2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date krajDatumProjekcije2;

    public BVMpvAkcMatricaRazvozDop() {
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrojDopune() {
        return brojDopune;
    }

    public void setBrojDopune(int brojDopune) {
        this.brojDopune = brojDopune;
    }

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    public String getNazivOj() {
        return nazivOj;
    }

    public void setNazivOj(String nazivOj) {
        this.nazivOj = nazivOj;
    }

    public String getMagacin() {
        return magacin;
    }

    public void setMagacin(String magacin) {
        this.magacin = magacin;
    }

    public Date getDatum2() {
        return datum;
    }
    
        public String getDatum() {
         if (datum !=null)
         {     
         SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
         String time = sdf.format(datum);
        return time/*datum*/;
         }
         else return null;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getDanUNedelji() {
        return danUNedelji;
    }

    public void setDanUNedelji(String danUNedelji) {
        this.danUNedelji = danUNedelji;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPocDatumProjekcije() {
        return pocDatumProjekcije;
    }

    public void setPocDatumProjekcije(Date pocDatumProjekcije) {
        this.pocDatumProjekcije = pocDatumProjekcije;
    }

    public Date getKrajDatumProjekcije() {
        return krajDatumProjekcije;
    }

    public void setKrajDatumProjekcije(Date krajDatumProjekcije) {
        this.krajDatumProjekcije = krajDatumProjekcije;
    }

    public Date getPocDatumProjekcije2() {
        return pocDatumProjekcije2;
    }

    public void setPocDatumProjekcije2(Date pocDatumProjekcije2) {
        this.pocDatumProjekcije2 = pocDatumProjekcije2;
    }

    public Date getKrajDatumProjekcije2() {
        return krajDatumProjekcije2;
    }

    public void setKrajDatumProjekcije2(Date krajDatumProjekcije2) {
        this.krajDatumProjekcije2 = krajDatumProjekcije2;
    }
    
}
