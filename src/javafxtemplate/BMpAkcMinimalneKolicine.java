/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "B_MP_AKC_MINIMALNE_KOLICINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BMpAkcMinimalneKolicine.findAll", query = "SELECT b FROM BMpAkcMinimalneKolicine b")
    , @NamedQuery(name = "BMpAkcMinimalneKolicine.findById", query = "SELECT b FROM BMpAkcMinimalneKolicine b WHERE b.bMpAkcMinimalneKolicinePK.id = :id")
    , @NamedQuery(name = "BMpAkcMinimalneKolicine.findByIdAkcije", query = "SELECT b FROM BMpAkcMinimalneKolicine b WHERE b.idAkcije = :idAkcije")
    , @NamedQuery(name = "BMpAkcMinimalneKolicine.findByIdKampanje", query = "SELECT b FROM BMpAkcMinimalneKolicine b WHERE b.idKampanje = :idKampanje")
    , @NamedQuery(name = "BMpAkcMinimalneKolicine.findByArtikal", query = "SELECT b FROM BMpAkcMinimalneKolicine b WHERE b.bMpAkcMinimalneKolicinePK.artikal = :artikal")
    , @NamedQuery(name = "BMpAkcMinimalneKolicine.findByKolicina", query = "SELECT b FROM BMpAkcMinimalneKolicine b WHERE b.kolicina = :kolicina")
    , @NamedQuery(name = "BMpAkcMinimalneKolicine.findBySisDatum", query = "SELECT b FROM BMpAkcMinimalneKolicine b WHERE b.sisDatum = :sisDatum")
    , @NamedQuery(name = "BMpAkcMinimalneKolicine.findByOrgjed", query = "SELECT b FROM BMpAkcMinimalneKolicine b WHERE b.bMpAkcMinimalneKolicinePK.orgjed = :orgjed")})
public class BMpAkcMinimalneKolicine implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpAkcMinimalneKolicinePK bMpAkcMinimalneKolicinePK;
    @Column(name = "ID_AKCIJE")
    private Long idAkcije;
    @Column(name = "ID_KAMPANJE")
    private String idKampanje;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KOLICINA")
    private BigDecimal kolicina;
    @Column(name = "SIS_DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sisDatum;

    public BMpAkcMinimalneKolicine() {
    }

    public BMpAkcMinimalneKolicine(BMpAkcMinimalneKolicinePK bMpAkcMinimalneKolicinePK) {
        this.bMpAkcMinimalneKolicinePK = bMpAkcMinimalneKolicinePK;
    }

    public BMpAkcMinimalneKolicine(int id, long artikal, String orgjed) {
        this.bMpAkcMinimalneKolicinePK = new BMpAkcMinimalneKolicinePK(id, artikal, orgjed);
    }

    public BMpAkcMinimalneKolicinePK getBMpAkcMinimalneKolicinePK() {
        return bMpAkcMinimalneKolicinePK;
    }

    public void setBMpAkcMinimalneKolicinePK(BMpAkcMinimalneKolicinePK bMpAkcMinimalneKolicinePK) {
        this.bMpAkcMinimalneKolicinePK = bMpAkcMinimalneKolicinePK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpAkcMinimalneKolicinePK != null ? bMpAkcMinimalneKolicinePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcMinimalneKolicine)) {
            return false;
        }
        BMpAkcMinimalneKolicine other = (BMpAkcMinimalneKolicine) object;
        if ((this.bMpAkcMinimalneKolicinePK == null && other.bMpAkcMinimalneKolicinePK != null) || (this.bMpAkcMinimalneKolicinePK != null && !this.bMpAkcMinimalneKolicinePK.equals(other.bMpAkcMinimalneKolicinePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcMinimalneKolicine[ bMpAkcMinimalneKolicinePK=" + bMpAkcMinimalneKolicinePK + " ]";
    }
    
}
