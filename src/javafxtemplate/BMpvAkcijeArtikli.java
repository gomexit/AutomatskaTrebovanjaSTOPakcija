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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_MPV_AKCIJE_ARTIKLI")
@NamedQueries({
    @NamedQuery(name = "BMpvAkcijeArtikli.findAll", query = "SELECT b FROM BMpvAkcijeArtikli b"),
    @NamedQuery(name = "BMpvAkcijeArtikli.findById", query = "SELECT b FROM BMpvAkcijeArtikli b WHERE b.bMpvAkcijeArtikliPK.id = :id"),
    @NamedQuery(name = "BMpvAkcijeArtikli.findByArtikal", query = "SELECT b FROM BMpvAkcijeArtikli b WHERE b.bMpvAkcijeArtikliPK.artikal = :artikal"),
    @NamedQuery(name = "BMpvAkcijeArtikli.findByOrgjed", query = "SELECT b FROM BMpvAkcijeArtikli b WHERE b.bMpvAkcijeArtikliPK.orgjed = :orgjed"),
    @NamedQuery(name = "BMpvAkcijeArtikli.findBySredjenaKolicina", query = "SELECT b FROM BMpvAkcijeArtikli b WHERE b.sredjenaKolicina = :sredjenaKolicina"),
    @NamedQuery(name = "BMpvAkcijeArtikli.findByOpis", query = "SELECT b FROM BMpvAkcijeArtikli b WHERE b.opis = :opis")})
public class BMpvAkcijeArtikli implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpvAkcijeArtikliPK bMpvAkcijeArtikliPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SREDJENA_KOLICINA")
    private BigDecimal sredjenaKolicina;
    @Column(name = "OPIS")
    private String opis;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BMpvAkcije bMpvAkcije;

    public BMpvAkcijeArtikli() {
    }

    public BMpvAkcijeArtikli(BMpvAkcijeArtikliPK bMpvAkcijeArtikliPK) {
        this.bMpvAkcijeArtikliPK = bMpvAkcijeArtikliPK;
    }

    public BMpvAkcijeArtikli(long id, long artikal, String orgjed) {
        this.bMpvAkcijeArtikliPK = new BMpvAkcijeArtikliPK(id, artikal, orgjed);
    }

    public BMpvAkcijeArtikliPK getBMpvAkcijeArtikliPK() {
        return bMpvAkcijeArtikliPK;
    }

    public void setBMpvAkcijeArtikliPK(BMpvAkcijeArtikliPK bMpvAkcijeArtikliPK) {
        this.bMpvAkcijeArtikliPK = bMpvAkcijeArtikliPK;
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

    public BMpvAkcije getBMpvAkcije() {
        return bMpvAkcije;
    }

    public void setBMpvAkcije(BMpvAkcije bMpvAkcije) {
        this.bMpvAkcije = bMpvAkcije;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpvAkcijeArtikliPK != null ? bMpvAkcijeArtikliPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpvAkcijeArtikli)) {
            return false;
        }
        BMpvAkcijeArtikli other = (BMpvAkcijeArtikli) object;
        if ((this.bMpvAkcijeArtikliPK == null && other.bMpvAkcijeArtikliPK != null) || (this.bMpvAkcijeArtikliPK != null && !this.bMpvAkcijeArtikliPK.equals(other.bMpvAkcijeArtikliPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpvAkcijeArtikli[ bMpvAkcijeArtikliPK=" + bMpvAkcijeArtikliPK + " ]";
    }
    
}
