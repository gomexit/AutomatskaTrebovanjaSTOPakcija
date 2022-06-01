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
 * @author bojan
 */
@Embeddable
public class BMpAkcSekundPozicijePK implements Serializable {
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
    @Column(name = "ORGJED")
    private String orgjed;

    public BMpAkcSekundPozicijePK() {
    }

    public BMpAkcSekundPozicijePK(long idAkcije, String idKampanje, long artikal, String orgjed) {
        this.idAkcije = idAkcije;
        this.idKampanje = idKampanje;
        this.artikal = artikal;
        this.orgjed = orgjed;
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

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAkcije;
        hash += (idKampanje != null ? idKampanje.hashCode() : 0);
        hash += (int) artikal;
        hash += (orgjed != null ? orgjed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcSekundPozicijePK)) {
            return false;
        }
        BMpAkcSekundPozicijePK other = (BMpAkcSekundPozicijePK) object;
        if (this.idAkcije != other.idAkcije) {
            return false;
        }
        if ((this.idKampanje == null && other.idKampanje != null) || (this.idKampanje != null && !this.idKampanje.equals(other.idKampanje))) {
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
        return "javafxtemplate.BMpAkcSekundPozicijePK[ idAkcije=" + idAkcije + ", idKampanje=" + idKampanje + ", artikal=" + artikal + ", orgjed=" + orgjed + " ]";
    }
    
}
