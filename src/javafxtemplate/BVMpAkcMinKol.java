/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ivan.babic
 */
@Entity
@Table(name = "B_V_MP_AKC_MIN_KOL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BVMpAkcMinKol.findAll", query = "SELECT b FROM BVMpAkcMinKol b")
    , @NamedQuery(name = "BVMpAkcMinKol.findById", query = "SELECT b FROM BVMpAkcMinKol b WHERE b.id = :id")
    , @NamedQuery(name = "BVMpAkcMinKol.findByIdAkcije", query = "SELECT b FROM BVMpAkcMinKol b WHERE b.idAkcije = :idAkcije")
    , @NamedQuery(name = "BVMpAkcMinKol.findByIdKampanje", query = "SELECT b FROM BVMpAkcMinKol b WHERE b.idKampanje = :idKampanje")
    , @NamedQuery(name = "BVMpAkcMinKol.findByArtikal", query = "SELECT b FROM BVMpAkcMinKol b WHERE b.artikal = :artikal")
    , @NamedQuery(name = "BVMpAkcMinKol.findBySifra", query = "SELECT b FROM BVMpAkcMinKol b WHERE b.sifra = :sifra")
    , @NamedQuery(name = "BVMpAkcMinKol.findByNaziv", query = "SELECT b FROM BVMpAkcMinKol b WHERE b.naziv = :naziv")
    , @NamedQuery(name = "BVMpAkcMinKol.findByOrgjed", query = "SELECT b FROM BVMpAkcMinKol b WHERE b.orgjed = :orgjed")
    , @NamedQuery(name = "BVMpAkcMinKol.findByOjNaziv", query = "SELECT b FROM BVMpAkcMinKol b WHERE b.ojNaziv = :ojNaziv")
    , @NamedQuery(name = "BVMpAkcMinKol.findByBroj", query = "SELECT b FROM BVMpAkcMinKol b WHERE b.broj = :broj")
    , @NamedQuery(name = "BVMpAkcMinKol.findByKolicina", query = "SELECT b FROM BVMpAkcMinKol b WHERE b.kolicina = :kolicina")
    , @NamedQuery(name = "BVMpAkcMinKol.findBySisDatum", query = "SELECT b FROM BVMpAkcMinKol b WHERE b.sisDatum = :sisDatum")})
public class BVMpAkcMinKol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ID_AKCIJE")
    private Long idAkcije;
    @Column(name = "ID_KAMPANJE")
    private String idKampanje;
    @Column(name = "ARTIKAL")
    private Long artikal;
    @Basic(optional = false)
    @Column(name = "SIFRA")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Column(name = "ORGJED")
    private String orgjed;
    @Basic(optional = false)
    @Column(name = "OJ_NAZIV")
    private String ojNaziv;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KOLICINA")
    private BigDecimal kolicina;
    @Column(name = "SIS_DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sisDatum;

    public BVMpAkcMinKol() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getIdAkcije() {
        return idAkcije;
    }

    public void setIdAkcije(Long idAkcije) {
        this.idAkcije = idAkcije;
    }

    public String getIdKampanje() {
        return idKampanje;
    }

    public void setIdKampanje(String idKampanje) {
        this.idKampanje = idKampanje;
    }

    public Long getArtikal() {
        return artikal;
    }

    public void setArtikal(Long artikal) {
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

    public String getOjNaziv() {
        return ojNaziv;
    }

    public void setOjNaziv(String ojNaziv) {
        this.ojNaziv = ojNaziv;
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }

    public BigDecimal getKolicina() {
        return kolicina;
    }

    public void setKolicina(BigDecimal kolicina) {
        this.kolicina = kolicina;
    }

    public Date getSisDatum() {
        return sisDatum;
    }

    public void setSisDatum(Date sisDatum) {
        this.sisDatum = sisDatum;
    }
    
}
