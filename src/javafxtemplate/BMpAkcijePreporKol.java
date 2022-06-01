/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author controling
 */
@Entity
@Table(name = "B_MP_AKCIJE_PREPOR_KOL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BMpAkcijePreporKol.findAll", query = "SELECT b FROM BMpAkcijePreporKol b")
    , @NamedQuery(name = "BMpAkcijePreporKol.findByIdKampanje", query = "SELECT b FROM BMpAkcijePreporKol b WHERE b.bMpAkcijePreporKolPK.idKampanje = :idKampanje")
    , @NamedQuery(name = "BMpAkcijePreporKol.findByIdAkcije", query = "SELECT b FROM BMpAkcijePreporKol b WHERE b.bMpAkcijePreporKolPK.idAkcije = :idAkcije")
    , @NamedQuery(name = "BMpAkcijePreporKol.findByOrgjed", query = "SELECT b FROM BMpAkcijePreporKol b WHERE b.bMpAkcijePreporKolPK.orgjed = :orgjed")
    , @NamedQuery(name = "BMpAkcijePreporKol.findByArtikal", query = "SELECT b FROM BMpAkcijePreporKol b WHERE b.bMpAkcijePreporKolPK.artikal = :artikal")
    , @NamedQuery(name = "BMpAkcijePreporKol.findByPreporucena", query = "SELECT b FROM BMpAkcijePreporKol b WHERE b.preporucena = :preporucena")
    , @NamedQuery(name = "BMpAkcijePreporKol.findByZaliha", query = "SELECT b FROM BMpAkcijePreporKol b WHERE b.zaliha = :zaliha")
    , @NamedQuery(name = "BMpAkcijePreporKol.findByOpis", query = "SELECT b FROM BMpAkcijePreporKol b WHERE b.opis = :opis")
    , @NamedQuery(name = "BMpAkcijePreporKol.findByPrimenjenAlgoritam", query = "SELECT b FROM BMpAkcijePreporKol b WHERE b.primenjenAlgoritam = :primenjenAlgoritam")
    , @NamedQuery(name = "BMpAkcijePreporKol.findByPreporBezKoef", query = "SELECT b FROM BMpAkcijePreporKol b WHERE b.preporBezKoef = :preporBezKoef")
    , @NamedQuery(name = "BMpAkcijePreporKol.findByPutanjaAlgoritma", query = "SELECT b FROM BMpAkcijePreporKol b WHERE b.putanjaAlgoritma = :putanjaAlgoritma")
    , @NamedQuery(name = "BMpAkcijePreporKol.findByCena", query = "SELECT b FROM BMpAkcijePreporKol b WHERE b.cena = :cena")
    , @NamedQuery(name = "BMpAkcijePreporKol.findByPreporucenaBezKonkur", query = "SELECT b FROM BMpAkcijePreporKol b WHERE b.preporucenaBezKonkur = :preporucenaBezKonkur")})
public class BMpAkcijePreporKol implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpAkcijePreporKolPK bMpAkcijePreporKolPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PREPORUCENA")
    private BigDecimal preporucena;
    @Column(name = "ZALIHA")
    private BigDecimal zaliha;
    @Column(name = "OPIS")
    private String opis;
    @Column(name = "PRIMENJEN_ALGORITAM")
    private Integer primenjenAlgoritam;
    @Column(name = "PREPOR_BEZ_KOEF")
    private BigDecimal preporBezKoef;
    @Column(name = "PUTANJA_ALGORITMA")
    private String putanjaAlgoritma;
    @Column(name = "CENA")
    private BigDecimal cena;
    @Column(name = "PREPORUCENA_BEZ_KONKUR")
    private BigDecimal preporucenaBezKonkur;

    public BMpAkcijePreporKol() {
    }

    public BMpAkcijePreporKol(BMpAkcijePreporKolPK bMpAkcijePreporKolPK) {
        this.bMpAkcijePreporKolPK = bMpAkcijePreporKolPK;
    }

    public BMpAkcijePreporKol(String idKampanje, long idAkcije, String orgjed, long artikal) {
        this.bMpAkcijePreporKolPK = new BMpAkcijePreporKolPK(idKampanje, idAkcije, orgjed, artikal);
    }

    public BMpAkcijePreporKolPK getBMpAkcijePreporKolPK() {
        return bMpAkcijePreporKolPK;
    }

    public void setBMpAkcijePreporKolPK(BMpAkcijePreporKolPK bMpAkcijePreporKolPK) {
        this.bMpAkcijePreporKolPK = bMpAkcijePreporKolPK;
    }

    public BigDecimal getPreporucena() {
        return preporucena;
    }

    public void setPreporucena(BigDecimal preporucena) {
        this.preporucena = preporucena;
    }

    public BigDecimal getZaliha() {
        return zaliha;
    }

    public void setZaliha(BigDecimal zaliha) {
        this.zaliha = zaliha;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Integer getPrimenjenAlgoritam() {
        return primenjenAlgoritam;
    }

    public void setPrimenjenAlgoritam(Integer primenjenAlgoritam) {
        this.primenjenAlgoritam = primenjenAlgoritam;
    }

    public BigDecimal getPreporBezKoef() {
        return preporBezKoef;
    }

    public void setPreporBezKoef(BigDecimal preporBezKoef) {
        this.preporBezKoef = preporBezKoef;
    }

    public String getPutanjaAlgoritma() {
        return putanjaAlgoritma;
    }

    public void setPutanjaAlgoritma(String putanjaAlgoritma) {
        this.putanjaAlgoritma = putanjaAlgoritma;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public BigDecimal getPreporucenaBezKonkur() {
        return preporucenaBezKonkur;
    }

    public void setPreporucenaBezKonkur(BigDecimal preporucenaBezKonkur) {
        this.preporucenaBezKonkur = preporucenaBezKonkur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpAkcijePreporKolPK != null ? bMpAkcijePreporKolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcijePreporKol)) {
            return false;
        }
        BMpAkcijePreporKol other = (BMpAkcijePreporKol) object;
        if ((this.bMpAkcijePreporKolPK == null && other.bMpAkcijePreporKolPK != null) || (this.bMpAkcijePreporKolPK != null && !this.bMpAkcijePreporKolPK.equals(other.bMpAkcijePreporKolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcijePreporKol[ bMpAkcijePreporKolPK=" + bMpAkcijePreporKolPK + " ]";
    }
    
}
