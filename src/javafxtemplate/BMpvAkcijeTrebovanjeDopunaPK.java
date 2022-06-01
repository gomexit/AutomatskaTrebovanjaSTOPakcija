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
public class BMpvAkcijeTrebovanjeDopunaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID")
    private long id;
    @Basic(optional = false)
    @Column(name = "BROJ_DOPUNE")
    private int brojDopune;
    @Basic(optional = false)
    @Column(name = "ORGJED")
    private String orgjed;
    @Basic(optional = false)
    @Column(name = "MAGACIN")
    private String magacin;
    @Basic(optional = false)
    @Column(name = "ID_ARTIKLA")
    private long idArtikla;

    public BMpvAkcijeTrebovanjeDopunaPK() {
    }

    public BMpvAkcijeTrebovanjeDopunaPK(long id, int brojDopune, String orgjed, String magacin, long idArtikla) {
        this.id = id;
        this.brojDopune = brojDopune;
        this.orgjed = orgjed;
        this.magacin = magacin;
        this.idArtikla = idArtikla;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBrojDopune() {
        return brojDopune;
    }

    public void setBrojDopune(int brojDopune) {
        this.brojDopune = brojDopune;
    }

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    public String getMagacin() {
        return magacin;
    }

    public void setMagacin(String magacin) {
        this.magacin = magacin;
    }

    public long getIdArtikla() {
        return idArtikla;
    }

    public void setIdArtikla(long idArtikla) {
        this.idArtikla = idArtikla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) brojDopune;
        hash += (orgjed != null ? orgjed.hashCode() : 0);
        hash += (magacin != null ? magacin.hashCode() : 0);
        hash += (int) idArtikla;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpvAkcijeTrebovanjeDopunaPK)) {
            return false;
        }
        BMpvAkcijeTrebovanjeDopunaPK other = (BMpvAkcijeTrebovanjeDopunaPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.brojDopune != other.brojDopune) {
            return false;
        }
        if ((this.orgjed == null && other.orgjed != null) || (this.orgjed != null && !this.orgjed.equals(other.orgjed))) {
            return false;
        }
        if ((this.magacin == null && other.magacin != null) || (this.magacin != null && !this.magacin.equals(other.magacin))) {
            return false;
        }
        if (this.idArtikla != other.idArtikla) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpvAkcijeTrebovanjeDopunaPK[ id=" + id + ", brojDopune=" + brojDopune + ", orgjed=" + orgjed + ", magacin=" + magacin + ", idArtikla=" + idArtikla + " ]";
    }
    
}
