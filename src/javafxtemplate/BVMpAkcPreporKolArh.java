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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ivan.babic
 */
@Entity
@Table(name = "B_V_MP_AKC_PREPOR_KOL_ARH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BVMpAkcPreporKolArh.findAll", query = "SELECT b FROM BVMpAkcPreporKolArh b")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.findByBroj", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.broj = :broj")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.Algoritmi", query = "SELECT DISTINCT b.primenjenAlgoritam FROM BVMpAkcPreporKol b WHERE b.id = :id ORDER BY b.primenjenAlgoritam")    
    , @NamedQuery(name = "BVMpAkcPreporKolArh.razliciteRadnje", query = "SELECT DISTINCT b.nazivOrgjed FROM BVMpAkcPreporKolArh b WHERE b.id = :id ORDER BY b.nazivOrgjed")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.filterPretraga", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.id = :id and b.naziv like :naziv AND b.sifra like :sifra and b.nazivOrgjed like :nazivOrgjed and b.robnaGrupa like :robnaGrupa and (b.primenjenAlgoritam=:primenjenAlgoritam or :primenjenAlgoritam=-1) and (b.artikal=:artikal or :artikal=-1)")    
    , @NamedQuery(name = "BVMpAkcPreporKolArh.poOJiID", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.id = :id AND b.nazivOrgjed=:nazivOrgjed")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.findById", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.id = :id")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.findByIdKampanje", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.idKampanje = :idKampanje")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.findByIdAkcije", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.idAkcije = :idAkcije")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.findByOrgjed", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.orgjed = :orgjed")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.findByNazivOrgjed", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.nazivOrgjed = :nazivOrgjed")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.findByArtikal", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.artikal = :artikal")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.findBySifra", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.sifra = :sifra")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.findByNaziv", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.naziv = :naziv")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.findByPrimenjenAlgoritam", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.primenjenAlgoritam = :primenjenAlgoritam")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.findByOpis", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.opis = :opis")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.findByPreporucena", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.preporucena = :preporucena")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.findByPreporBezKoef", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.preporBezKoef = :preporBezKoef")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.findByCena", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.cena = :cena")
    , @NamedQuery(name = "BVMpAkcPreporKolArh.findByRobnaGrupa", query = "SELECT b FROM BVMpAkcPreporKolArh b WHERE b.robnaGrupa = :robnaGrupa")})
public class BVMpAkcPreporKolArh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Column(name = "ID_KAMPANJE")
    private String idKampanje;
    @Column(name = "ID_AKCIJE")
    private Long idAkcije;
    @Column(name = "ORGJED")
    private String orgjed;
    @Basic(optional = false)
    @Column(name = "NAZIV_ORGJED")
    private String nazivOrgjed;
    @Column(name = "ARTIKAL")
    private Long artikal;
    @Basic(optional = false)
    @Column(name = "SIFRA")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Column(name = "PRIMENJEN_ALGORITAM")
    private Integer primenjenAlgoritam;
    @Column(name = "OPIS")
    private String opis;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PREPORUCENA")
    private BigDecimal preporucena;
    @Column(name = "PREPOR_BEZ_KOEF")
    private BigDecimal preporBezKoef;
    @Column(name = "CENA")
    private BigDecimal cena;
    @Basic(optional = false)
    @Column(name = "ROBNA_GRUPA")
    private String robnaGrupa;

    public BVMpAkcPreporKolArh() {
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

    public String getIdKampanje() {
        return idKampanje;
    }

    public void setIdKampanje(String idKampanje) {
        this.idKampanje = idKampanje;
    }

    public Long getIdAkcije() {
        return idAkcije;
    }

    public void setIdAkcije(Long idAkcije) {
        this.idAkcije = idAkcije;
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

    public Integer getPrimenjenAlgoritam() {
        return primenjenAlgoritam;
    }

    public void setPrimenjenAlgoritam(Integer primenjenAlgoritam) {
        this.primenjenAlgoritam = primenjenAlgoritam;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public BigDecimal getPreporucena() {
        return preporucena;
    }

    public void setPreporucena(BigDecimal preporucena) {
        this.preporucena = preporucena;
    }

    public BigDecimal getPreporBezKoef() {
        return preporBezKoef;
    }

    public void setPreporBezKoef(BigDecimal preporBezKoef) {
        this.preporBezKoef = preporBezKoef;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public String getRobnaGrupa() {
        return robnaGrupa;
    }

    public void setRobnaGrupa(String robnaGrupa) {
        this.robnaGrupa = robnaGrupa;
    }
    
}
