/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author laki
 */
@Embeddable
public class BMpAkcAriojIskljizAkcPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "ARTIKAL")
    private long artikal;
    @Basic(optional = false)
    @Column(name = "ORGJED")
    private String orgjed;

    public BMpAkcAriojIskljizAkcPK() {
    }

    public BMpAkcAriojIskljizAkcPK(int id, long artikal, String orgjed) {
        this.id = id;
        this.artikal = artikal;
        this.orgjed = orgjed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getArtikal() {
        return artikal;
    }

    public void setArtikal(long artikal) {
        this.artikal = artikal;
    }

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) artikal;
        hash += (orgjed != null ? orgjed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcAriojIskljizAkcPK)) {
            return false;
        }
        BMpAkcAriojIskljizAkcPK other = (BMpAkcAriojIskljizAkcPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.artikal != other.artikal) {
            return false;
        }
        if ((this.orgjed == null && other.orgjed != null) || (this.orgjed != null && !this.orgjed.equals(other.orgjed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcAriojIskljizAkcPK[ id=" + id + ", artikal=" + artikal + ", orgjed=" + orgjed + " ]";
    }
    
}
