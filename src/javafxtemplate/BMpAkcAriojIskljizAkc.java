/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author laki
 */
@Entity
@Table(name = "B_MP_AKC_ARIOJ_ISKLJIZ_AKC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BMpAkcAriojIskljizAkc.findAll", query = "SELECT b FROM BMpAkcAriojIskljizAkc b"),
    @NamedQuery(name = "BMpAkcAriojIskljizAkc.findById", query = "SELECT b FROM BMpAkcAriojIskljizAkc b WHERE b.bMpAkcAriojIskljizAkcPK.id = :id"),
    @NamedQuery(name = "BMpAkcAriojIskljizAkc.findByArtikal", query = "SELECT b FROM BMpAkcAriojIskljizAkc b WHERE b.bMpAkcAriojIskljizAkcPK.artikal = :artikal"),
    @NamedQuery(name = "BMpAkcAriojIskljizAkc.findBySve", query = "SELECT b FROM BMpAkcAriojIskljizAkc b WHERE b.bMpAkcAriojIskljizAkcPK.artikal = :artikal and b.bMpAkcAriojIskljizAkcPK.id = :id and b.bMpAkcAriojIskljizAkcPK.orgjed = :orgjed"),
    @NamedQuery(name = "BMpAkcAriojIskljizAkc.findByOrgjed", query = "SELECT b FROM BMpAkcAriojIskljizAkc b WHERE b.bMpAkcAriojIskljizAkcPK.orgjed = :orgjed")})
public class BMpAkcAriojIskljizAkc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpAkcAriojIskljizAkcPK bMpAkcAriojIskljizAkcPK;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BMpAkcije bMpAkcije;

    public BMpAkcAriojIskljizAkc() {
    }

    public BMpAkcAriojIskljizAkc(BMpAkcAriojIskljizAkcPK bMpAkcAriojIskljizAkcPK) {
        this.bMpAkcAriojIskljizAkcPK = bMpAkcAriojIskljizAkcPK;
    }

    public BMpAkcAriojIskljizAkc(int id, long artikal, String orgjed) {
        this.bMpAkcAriojIskljizAkcPK = new BMpAkcAriojIskljizAkcPK(id, artikal, orgjed);
    }

    public BMpAkcAriojIskljizAkcPK getBMpAkcAriojIskljizAkcPK() {
        return bMpAkcAriojIskljizAkcPK;
    }

    public void setBMpAkcAriojIskljizAkcPK(BMpAkcAriojIskljizAkcPK bMpAkcAriojIskljizAkcPK) {
        this.bMpAkcAriojIskljizAkcPK = bMpAkcAriojIskljizAkcPK;
    }

    public BMpAkcije getBMpAkcije() {
        return bMpAkcije;
    }

    public void setBMpAkcije(BMpAkcije bMpAkcije) {
        this.bMpAkcije = bMpAkcije;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpAkcAriojIskljizAkcPK != null ? bMpAkcAriojIskljizAkcPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcAriojIskljizAkc)) {
            return false;
        }
        BMpAkcAriojIskljizAkc other = (BMpAkcAriojIskljizAkc) object;
        if ((this.bMpAkcAriojIskljizAkcPK == null && other.bMpAkcAriojIskljizAkcPK != null) || (this.bMpAkcAriojIskljizAkcPK != null && !this.bMpAkcAriojIskljizAkcPK.equals(other.bMpAkcAriojIskljizAkcPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcAriojIskljizAkc[ bMpAkcAriojIskljizAkcPK=" + bMpAkcAriojIskljizAkcPK + " ]";
    }
    
}
