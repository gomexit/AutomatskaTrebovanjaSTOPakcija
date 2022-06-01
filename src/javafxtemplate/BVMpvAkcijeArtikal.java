/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_V_MPV_AKCIJE_ARTIKAL")
@NamedQueries({
    @NamedQuery(name = "BVMpvAkcijeArtikal.findAll", query = "SELECT b FROM BVMpvAkcijeArtikal b"),
    @NamedQuery(name = "BVMpvAkcijeArtikal.findById", query = "SELECT b FROM BVMpvAkcijeArtikal b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpvAkcijeArtikal.findByArtikal", query = "SELECT b FROM BVMpvAkcijeArtikal b WHERE b.artikal = :artikal"),
    @NamedQuery(name = "BVMpvAkcijeArtikal.findBySifra", query = "SELECT b FROM BVMpvAkcijeArtikal b WHERE b.sifra = :sifra"),
    @NamedQuery(name = "BVMpvAkcijeArtikal.findByNaziv", query = "SELECT b FROM BVMpvAkcijeArtikal b WHERE b.naziv = :naziv"),
    @NamedQuery(name = "BVMpvAkcijeArtikal.findByCm", query = "SELECT b FROM BVMpvAkcijeArtikal b WHERE b.cm = :cm"),
    @NamedQuery(name = "BVMpvAkcijeArtikal.findByOrgjed", query = "SELECT b FROM BVMpvAkcijeArtikal b WHERE b.orgjed = :orgjed"),
    @NamedQuery(name = "BVMpvAkcijeArtikal.findBySredjenaKolicina", query = "SELECT b FROM BVMpvAkcijeArtikal b WHERE b.sredjenaKolicina = :sredjenaKolicina"),
    @NamedQuery(name = "BVMpvAkcijeArtikal.findByOpis", query = "SELECT b FROM BVMpvAkcijeArtikal b WHERE b.opis = :opis"),
    @NamedQuery(name = "BVMpvAkcijeArtikal.findByBroj", query = "SELECT b FROM BVMpvAkcijeArtikal b WHERE b.broj = :broj")})
public class BVMpvAkcijeArtikal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID")
    private long id;
    @Basic(optional = false)
    @Column(name = "ARTIKAL")
    private long artikal;
    @Basic(optional = false)
    @Column(name = "SIFRA")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Column(name = "CM")
    private String cm;
    @Basic(optional = false)
    @Column(name = "ORGJED")
    private String orgjed;
     @Basic(optional = false)
    @Column(name = "NAZIV_OJ")
    private String nazivOj;

    public String getNazivOj() {
        return nazivOj;
    }

    public void setNazivOj(String nazivOj) {
        this.nazivOj = nazivOj;
    }
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SREDJENA_KOLICINA")
    private BigDecimal sredjenaKolicina;
    @Column(name = "OPIS")
    private String opis;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;

    public BVMpvAkcijeArtikal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCm() {
        return cm;
    }

    public void setCm(String cm) {
        this.cm = cm;
    }

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    public BigDecimal getSredjenaKolicina() {
        return sredjenaKolicina;
    }

    public void setSredjenaKolicina(BigDecimal sredjenaKolicina) {
        this.sredjenaKolicina = sredjenaKolicina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }
    
}
