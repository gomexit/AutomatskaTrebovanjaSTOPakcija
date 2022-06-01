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
@Table(name = "B_V_MP_AKC_RAZVOZ_PRVO_PUNJ")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcRazvozPrvoPunj.findAll", query = "SELECT b FROM BVMpAkcRazvozPrvoPunj b"),
    @NamedQuery(name = "BVMpAkcRazvozPrvoPunj.findByBroj", query = "SELECT b FROM BVMpAkcRazvozPrvoPunj b WHERE b.broj = :broj"),
    @NamedQuery(name = "BVMpAkcRazvozPrvoPunj.findById", query = "SELECT b FROM BVMpAkcRazvozPrvoPunj b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcRazvozPrvoPunj.findByBrojDopune", query = "SELECT b FROM BVMpAkcRazvozPrvoPunj b WHERE b.brojDopune = :brojDopune"),
    @NamedQuery(name = "BVMpAkcRazvozPrvoPunj.findByOrgjed", query = "SELECT b FROM BVMpAkcRazvozPrvoPunj b WHERE b.orgjed = :orgjed"),
    @NamedQuery(name = "BVMpAkcRazvozPrvoPunj.findByRadnja", query = "SELECT b FROM BVMpAkcRazvozPrvoPunj b WHERE b.radnja = :radnja"),
    @NamedQuery(name = "BVMpAkcRazvozPrvoPunj.findByMagacin", query = "SELECT b FROM BVMpAkcRazvozPrvoPunj b WHERE b.magacin = :magacin"),
    @NamedQuery(name = "BVMpAkcRazvozPrvoPunj.findByDatum", query = "SELECT b FROM BVMpAkcRazvozPrvoPunj b WHERE b.datum = :datum"),
    @NamedQuery(name = "BVMpAkcRazvozPrvoPunj.findByStatus", query = "SELECT b FROM BVMpAkcRazvozPrvoPunj b WHERE b.status = :status"),
    @NamedQuery(name = "BVMpAkcRazvozPrvoPunj.findByPocDatumProjekcije", query = "SELECT b FROM BVMpAkcRazvozPrvoPunj b WHERE b.pocDatumProjekcije = :pocDatumProjekcije"),
    @NamedQuery(name = "BVMpAkcRazvozPrvoPunj.findByKrajDatumProjekcije", query = "SELECT b FROM BVMpAkcRazvozPrvoPunj b WHERE b.krajDatumProjekcije = :krajDatumProjekcije")})
public class BVMpAkcRazvozPrvoPunj implements Serializable {
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
    @Column(name = "RADNJA")
    private String radnja;
    @Column(name = "MAGACIN")
    private String magacin;
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Column(name = "DAN_U_NEDELJI")
    private String danUNedelji;

    public String getDanUNedelji() {
        return danUNedelji;
    }

    public void setDanUNedelji(String danUNedelji) {
        this.danUNedelji = danUNedelji;
    }
    @Column(name = "STATUS")
    private String status;
    @Column(name = "POC_DATUM_PROJEKCIJE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pocDatumProjekcije;
    @Column(name = "KRAJ_DATUM_PROJEKCIJE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date krajDatumProjekcije;

    public BVMpAkcRazvozPrvoPunj() {
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

    public String getRadnja() {
        return radnja;
    }

    public void setRadnja(String radnja) {
        this.radnja = radnja;
    }

    public String getMagacin() {
        return magacin;
    }

    public void setMagacin(String magacin) {
        this.magacin = magacin;
    }

    public String getDatum() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String time = sdf.format(datum);
         return time;
               

//return datum;
    }
    
       public Date getDatum2() {
       return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPocDatumProjekcije() {
        
         SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
         String time = sdf.format(pocDatumProjekcije);
         return time;
      //  return pocDatumProjekcije;
    }
    
      public Date getPocDatumProjekcije2() {
          return pocDatumProjekcije;
    }

    public void setPocDatumProjekcije(Date pocDatumProjekcije) {
        this.pocDatumProjekcije = pocDatumProjekcije;
    }

    public String getKrajDatumProjekcije() {
        
         SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
         String time = sdf.format(krajDatumProjekcije);
         return time;
       // return krajDatumProjekcije;
    }
    
    
    public Date getKrajDatumProjekcije2() {
        
         return krajDatumProjekcije;
    }

    public void setKrajDatumProjekcije(Date krajDatumProjekcije) {
        this.krajDatumProjekcije = krajDatumProjekcije;
    }
    
}
