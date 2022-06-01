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
@Table(name = "B_V_MP_AKC_SEKUNDARNE_POZICIJE")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcSekundarnePozicije.findAll", query = "SELECT b FROM BVMpAkcSekundarnePozicije b"),
    @NamedQuery(name = "BVMpAkcSekundarnePozicije.findById", query = "SELECT b FROM BVMpAkcSekundarnePozicije b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcSekundarnePozicije.findByIdAkcije", query = "SELECT b FROM BVMpAkcSekundarnePozicije b WHERE b.idAkcije = :idAkcije"),
    @NamedQuery(name = "BVMpAkcSekundarnePozicije.findByIdKampanje", query = "SELECT b FROM BVMpAkcSekundarnePozicije b WHERE b.idKampanje = :idKampanje"),
    @NamedQuery(name = "BVMpAkcSekundarnePozicije.findByArtikal", query = "SELECT b FROM BVMpAkcSekundarnePozicije b WHERE b.artikal = :artikal"),
    @NamedQuery(name = "BVMpAkcSekundarnePozicije.findBySifra", query = "SELECT b FROM BVMpAkcSekundarnePozicije b WHERE b.sifra = :sifra"),
    @NamedQuery(name = "BVMpAkcSekundarnePozicije.findByNazivArtikla", query = "SELECT b FROM BVMpAkcSekundarnePozicije b WHERE b.nazivArtikla = :nazivArtikla"),
    @NamedQuery(name = "BVMpAkcSekundarnePozicije.findByOrgjed", query = "SELECT b FROM BVMpAkcSekundarnePozicije b WHERE b.orgjed = :orgjed"),
    @NamedQuery(name = "BVMpAkcSekundarnePozicije.findByNazivOj", query = "SELECT b FROM BVMpAkcSekundarnePozicije b WHERE b.nazivOj = :nazivOj"),
    @NamedQuery(name = "BVMpAkcSekundarnePozicije.findByKolicina", query = "SELECT b FROM BVMpAkcSekundarnePozicije b WHERE b.kolicina = :kolicina"),
    @NamedQuery(name = "BVMpAkcSekundarnePozicije.findByBroj", query = "SELECT b FROM BVMpAkcSekundarnePozicije b WHERE b.broj = :broj")})
public class BVMpAkcSekundarnePozicije implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID")
    private long id;
    @Basic(optional = false)
    @Column(name = "ID_AKCIJE")
    private long idAkcije;
    @Basic(optional = false)
    @Column(name = "ID_KAMPANJE")
    private String idKampanje;
    @Basic(optional = false)
    @Column(name = "ARTIKAL")
    private long artikal;
    @Basic(optional = false)
    @Column(name = "SIFRA")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "NAZIV_ARTIKLA")
    private String nazivArtikla;
    @Basic(optional = false)
    @Column(name = "ORGJED")
    private String orgjed;
    @Basic(optional = false)
    @Column(name = "NAZIV_OJ")
    private String nazivOj;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KOLICINA")
    private BigDecimal kolicina;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;

    public BVMpAkcSekundarnePozicije() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAkcije() {
        return idAkcije;
    }

    public void setIdAkcije(long idAkcije) {
        this.idAkcije = idAkcije;
    }

    public String getIdKampanje() {
        return idKampanje;
    }

    public void setIdKampanje(String idKampanje) {
        this.idKampanje = idKampanje;
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

    public String getNazivArtikla() {
        return nazivArtikla;
    }

    public void setNazivArtikla(String nazivArtikla) {
        this.nazivArtikla = nazivArtikla;
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

    public BigDecimal getKolicina() {
        return kolicina;
    }

    public void setKolicina(BigDecimal kolicina) {
        this.kolicina = kolicina;
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }
    
}
