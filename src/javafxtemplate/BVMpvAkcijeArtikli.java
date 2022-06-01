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
@Table(name = "B_V_MPV_AKCIJE_ARTIKLI")
@NamedQueries({
    @NamedQuery(name = "BVMpvAkcijeArtikli.findAll", query = "SELECT b FROM BVMpvAkcijeArtikli b"),
    @NamedQuery(name = "BVMpvAkcijeArtikli.filterPretraga", query = "SELECT b FROM BVMpvAkcijeArtikli b WHERE b.id = :id and b.naziv like :naziv AND b.sifra like :sifra and b.nazivOrgjed like :nazivOrgjed and b.robnaGrupa like :robnaGrupa  and (b.artikal=:artikal or :artikal=-1)"),
    @NamedQuery(name = "BVMpvAkcijeArtikli.findByBroj", query = "SELECT b FROM BVMpvAkcijeArtikli b WHERE b.broj = :broj"),
    @NamedQuery(name = "BVMpvAkcijeArtikli.findById", query = "SELECT b FROM BVMpvAkcijeArtikli b WHERE b.id = :id"),
     @NamedQuery(name = "BVMpvAkcijeArtikli.razliciteRadnje", query = "SELECT distinct b.nazivOrgjed FROM BVMpvAkcijeArtikli b WHERE b.id = :id order by b.nazivOrgjed"),
    @NamedQuery(name = "BVMpvAkcijeArtikli.findByArtikal", query = "SELECT b FROM BVMpvAkcijeArtikli b WHERE b.artikal = :artikal"),
    @NamedQuery(name = "BVMpvAkcijeArtikli.findBySifra", query = "SELECT b FROM BVMpvAkcijeArtikli b WHERE b.sifra = :sifra"),
    @NamedQuery(name = "BVMpvAkcijeArtikli.findByNaziv", query = "SELECT b FROM BVMpvAkcijeArtikli b WHERE b.naziv = :naziv"),
     @NamedQuery(name = "BVMpvAkcijeArtikli.poOJiID", query = "SELECT b FROM BVMpvAkcijeArtikli b WHERE b.id = :id AND b.nazivOrgjed=:nazivOrgjed"),
    @NamedQuery(name = "BVMpvAkcijeArtikli.findByOrgjed", query = "SELECT b FROM BVMpvAkcijeArtikli b WHERE b.orgjed = :orgjed"),
    @NamedQuery(name = "BVMpvAkcijeArtikli.findByNazivOrgjed", query = "SELECT b FROM BVMpvAkcijeArtikli b WHERE b.nazivOrgjed = :nazivOrgjed"),
    @NamedQuery(name = "BVMpvAkcijeArtikli.findBySredjenaKolicina", query = "SELECT b FROM BVMpvAkcijeArtikli b WHERE b.sredjenaKolicina = :sredjenaKolicina"),
    @NamedQuery(name = "BVMpvAkcijeArtikli.findByOpis", query = "SELECT b FROM BVMpvAkcijeArtikli b WHERE b.opis = :opis"),
    @NamedQuery(name = "BVMpvAkcijeArtikli.findByRobnaGrupa", query = "SELECT b FROM BVMpvAkcijeArtikli b WHERE b.robnaGrupa = :robnaGrupa")})
public class BVMpvAkcijeArtikli implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;
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
    @Basic(optional = false)
    @Column(name = "ORGJED")
    private String orgjed;
    @Basic(optional = false)
    @Column(name = "NAZIV_ORGJED")
    private String nazivOrgjed;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SREDJENA_KOLICINA")
    private BigDecimal sredjenaKolicina;
    @Column(name = "OPIS")
    private String opis;
    @Basic(optional = false)
    @Column(name = "ROBNA_GRUPA")
    private String robnaGrupa;

    public BVMpvAkcijeArtikli() {
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
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

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    public String getNazivOrgjed() {
        return nazivOrgjed;
    }

    public void setNazivOrgjed(String nazivOrgjed) {
        this.nazivOrgjed = nazivOrgjed;
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

    public String getRobnaGrupa() {
        return robnaGrupa;
    }

    public void setRobnaGrupa(String robnaGrupa) {
        this.robnaGrupa = robnaGrupa;
    }
    
}
