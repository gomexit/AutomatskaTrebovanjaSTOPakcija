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
 * @author controling
 */
@Embeddable
public class BMpAkcijePreporKolPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_KAMPANJE")
    private String idKampanje;
    @Basic(optional = false)
    @Column(name = "ID_AKCIJE")
    private long idAkcije;
    @Basic(optional = false)
    @Column(name = "ORGJED")
    private String orgjed;
    @Basic(optional = false)
    @Column(name = "ARTIKAL")
    private long artikal;

    public BMpAkcijePreporKolPK() {
    }

    public BMpAkcijePreporKolPK(String idKampanje, long idAkcije, String orgjed, long artikal) {
        this.idKampanje = idKampanje;
        this.idAkcije = idAkcije;
        this.orgjed = orgjed;
        this.artikal = artikal;
    }

    public String getIdKampanje() {
        return idKampanje;
    }

    public void setIdKampanje(String idKampanje) {
        this.idKampanje = idKampanje;
    }

    public long getIdAkcije() {
        return idAkcije;
    }

    public void setIdAkcije(long idAkcije) {
        this.idAkcije = idAkcije;
    }

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    public long getArtikal() {
        return artikal;
    }

    public void setArtikal(long artikal) {
        this.artikal = artikal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKampanje != null ? idKampanje.hashCode() : 0);
        hash += (int) idAkcije;
        hash += (orgjed != null ? orgjed.hashCode() : 0);
        hash += (int) artikal;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcijePreporKolPK)) {
            return false;
        }
        BMpAkcijePreporKolPK other = (BMpAkcijePreporKolPK) object;
        if ((this.idKampanje == null && other.idKampanje != null) || (this.idKampanje != null && !this.idKampanje.equals(other.idKampanje))) {
            return false;
        }
        if (this.idAkcije != other.idAkcije) {
            return false;
        }
        if ((this.orgjed == null && other.orgjed != null) || (this.orgjed != null && !this.orgjed.equals(other.orgjed))) {
            return false;
        }
        if (this.artikal != other.artikal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcijePreporKolPK[ idKampanje=" + idKampanje + ", idAkcije=" + idAkcije + ", orgjed=" + orgjed + ", artikal=" + artikal + " ]";
    }
    
}
