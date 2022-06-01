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
public class BMpAkcijeStavkeAswPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID")
    private long id;
    @Basic(optional = false)
    @Column(name = "ID_AKCIJE")
    private long idAkcije;
    @Basic(optional = false)
    @Column(name = "ID_KAMPANJE")
    private String idKampanje;

    public BMpAkcijeStavkeAswPK() {
    }

    public BMpAkcijeStavkeAswPK(long id, long idAkcije, String idKampanje) {
        this.id = id;
        this.idAkcije = idAkcije;
        this.idKampanje = idKampanje;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) idAkcije;
        hash += (idKampanje != null ? idKampanje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcijeStavkeAswPK)) {
            return false;
        }
        BMpAkcijeStavkeAswPK other = (BMpAkcijeStavkeAswPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.idAkcije != other.idAkcije) {
            return false;
        }
        if ((this.idKampanje == null && other.idKampanje != null) || (this.idKampanje != null && !this.idKampanje.equals(other.idKampanje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcijeStavkeAswPK[ id=" + id + ", idAkcije=" + idAkcije + ", idKampanje=" + idKampanje + " ]";
    }
    
}
