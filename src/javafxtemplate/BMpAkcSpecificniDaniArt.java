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

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_MP_AKC_SPECIFICNI_DANI_ART")
@NamedQueries({
    @NamedQuery(name = "BMpAkcSpecificniDaniArt.findAll", query = "SELECT b FROM BMpAkcSpecificniDaniArt b"),
    @NamedQuery(name = "BMpAkcSpecificniDaniArt.findByDatum", query = "SELECT b FROM BMpAkcSpecificniDaniArt b WHERE b.bMpAkcSpecificniDaniArtPK.datum = :datum"),
    @NamedQuery(name = "BMpAkcSpecificniDaniArt.findByDatumART", query = "SELECT b FROM BMpAkcSpecificniDaniArt b WHERE b.bMpAkcSpecificniDaniArtPK.datum = :datum and b.bMpAkcSpecificniDaniArtPK.artikal = :artikal"),
    @NamedQuery(name = "BMpAkcSpecificniDaniArt.findByKoef", query = "SELECT b FROM BMpAkcSpecificniDaniArt b WHERE b.koef = :koef"),
    @NamedQuery(name = "BMpAkcSpecificniDaniArt.findByArtikal", query = "SELECT b FROM BMpAkcSpecificniDaniArt b WHERE b.bMpAkcSpecificniDaniArtPK.artikal = :artikal")})
public class BMpAkcSpecificniDaniArt implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpAkcSpecificniDaniArtPK bMpAkcSpecificniDaniArtPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KOEF")
    private BigDecimal koef;

    public BMpAkcSpecificniDaniArt() {
    }

    public BMpAkcSpecificniDaniArt(BMpAkcSpecificniDaniArtPK bMpAkcSpecificniDaniArtPK) {
        this.bMpAkcSpecificniDaniArtPK = bMpAkcSpecificniDaniArtPK;
    }

    public BMpAkcSpecificniDaniArt(Date datum, long artikal) {
        this.bMpAkcSpecificniDaniArtPK = new BMpAkcSpecificniDaniArtPK(datum, artikal);
    }

    public BMpAkcSpecificniDaniArtPK getBMpAkcSpecificniDaniArtPK() {
        return bMpAkcSpecificniDaniArtPK;
    }

    public void setBMpAkcSpecificniDaniArtPK(BMpAkcSpecificniDaniArtPK bMpAkcSpecificniDaniArtPK) {
        this.bMpAkcSpecificniDaniArtPK = bMpAkcSpecificniDaniArtPK;
    }

    public BigDecimal getKoef() {
        return koef;
    }

    public void setKoef(BigDecimal koef) {
        this.koef = koef;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpAkcSpecificniDaniArtPK != null ? bMpAkcSpecificniDaniArtPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcSpecificniDaniArt)) {
            return false;
        }
        BMpAkcSpecificniDaniArt other = (BMpAkcSpecificniDaniArt) object;
        if ((this.bMpAkcSpecificniDaniArtPK == null && other.bMpAkcSpecificniDaniArtPK != null) || (this.bMpAkcSpecificniDaniArtPK != null && !this.bMpAkcSpecificniDaniArtPK.equals(other.bMpAkcSpecificniDaniArtPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcSpecificniDaniArt[ bMpAkcSpecificniDaniArtPK=" + bMpAkcSpecificniDaniArtPK + " ]";
    }
    
}
