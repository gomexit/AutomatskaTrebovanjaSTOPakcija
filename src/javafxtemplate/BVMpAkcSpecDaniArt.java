/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "B_V_MP_AKC_SPEC_DANI_ART")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcSpecDaniArt.findAll", query = "SELECT b FROM BVMpAkcSpecDaniArt b order by b.datum desc"),
    @NamedQuery(name = "BVMpAkcSpecDaniArt.findByDatum", query = "SELECT b FROM BVMpAkcSpecDaniArt b WHERE b.datum = :datum"),
    @NamedQuery(name = "BVMpAkcSpecDaniArt.findByKoef", query = "SELECT b FROM BVMpAkcSpecDaniArt b WHERE b.koef = :koef"),
    @NamedQuery(name = "BVMpAkcSpecDaniArt.findByArtikal", query = "SELECT b FROM BVMpAkcSpecDaniArt b WHERE b.artikal = :artikal"),
    @NamedQuery(name = "BVMpAkcSpecDaniArt.findBySifra", query = "SELECT b FROM BVMpAkcSpecDaniArt b WHERE b.sifra = :sifra"),
    @NamedQuery(name = "BVMpAkcSpecDaniArt.findByNaziv", query = "SELECT b FROM BVMpAkcSpecDaniArt b WHERE b.naziv = :naziv")})
public class BVMpAkcSpecDaniArt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KOEF")
    private BigDecimal koef;
    @Basic(optional = false)
    @Column(name = "ARTIKAL")
    private long artikal;
    @Basic(optional = false)
    @Column(name = "SIFRA")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Basic(optional = false)
    @Id
    @Column(name = "BROJ")
    private String broj;

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public BVMpAkcSpecDaniArt() {
    }

    public Date getDatum2() {
        return datum;
    }
    
     public String getDatum() {
             SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String time = sdf.format(datum);
        return time;
     }
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public BigDecimal getKoef() {
        return koef;
    }

    public void setKoef(BigDecimal koef) {
        this.koef = koef;
    }

    public long getArtikal() {
        return artikal;
    }

    public void setArtikal(long artikal) {
        this.artikal = artikal;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
}
