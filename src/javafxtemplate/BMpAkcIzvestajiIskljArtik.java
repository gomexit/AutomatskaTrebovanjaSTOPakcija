/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
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
@Table(name = "B_MP_AKC_IZVESTAJI_ISKLJ_ARTIK")
@NamedQueries({
    @NamedQuery(name = "BMpAkcIzvestajiIskljArtik.findAll", query = "SELECT b FROM BMpAkcIzvestajiIskljArtik b"),
    @NamedQuery(name = "BMpAkcIzvestajiIskljArtik.findById", query = "SELECT b FROM BMpAkcIzvestajiIskljArtik b WHERE b.bMpAkcIzvestajiIskljArtikPK.id = :id"),
     @NamedQuery(name = "BMpAkcIzvestajiIskljArtik.findByOba", query = "SELECT b FROM BMpAkcIzvestajiIskljArtik b WHERE b.bMpAkcIzvestajiIskljArtikPK.id = :id and b.bMpAkcIzvestajiIskljArtikPK.artikal = :artikal"),
    @NamedQuery(name = "BMpAkcIzvestajiIskljArtik.findByArtikal", query = "SELECT b FROM BMpAkcIzvestajiIskljArtik b WHERE b.bMpAkcIzvestajiIskljArtikPK.artikal = :artikal")})
public class BMpAkcIzvestajiIskljArtik implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpAkcIzvestajiIskljArtikPK bMpAkcIzvestajiIskljArtikPK;

    public BMpAkcIzvestajiIskljArtik() {
    }

    public BMpAkcIzvestajiIskljArtik(BMpAkcIzvestajiIskljArtikPK bMpAkcIzvestajiIskljArtikPK) {
        this.bMpAkcIzvestajiIskljArtikPK = bMpAkcIzvestajiIskljArtikPK;
    }

    public BMpAkcIzvestajiIskljArtik(int id, long artikal) {
        this.bMpAkcIzvestajiIskljArtikPK = new BMpAkcIzvestajiIskljArtikPK(id, artikal);
    }

    public BMpAkcIzvestajiIskljArtikPK getBMpAkcIzvestajiIskljArtikPK() {
        return bMpAkcIzvestajiIskljArtikPK;
    }

    public void setBMpAkcIzvestajiIskljArtikPK(BMpAkcIzvestajiIskljArtikPK bMpAkcIzvestajiIskljArtikPK) {
        this.bMpAkcIzvestajiIskljArtikPK = bMpAkcIzvestajiIskljArtikPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpAkcIzvestajiIskljArtikPK != null ? bMpAkcIzvestajiIskljArtikPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcIzvestajiIskljArtik)) {
            return false;
        }
        BMpAkcIzvestajiIskljArtik other = (BMpAkcIzvestajiIskljArtik) object;
        if ((this.bMpAkcIzvestajiIskljArtikPK == null && other.bMpAkcIzvestajiIskljArtikPK != null) || (this.bMpAkcIzvestajiIskljArtikPK != null && !this.bMpAkcIzvestajiIskljArtikPK.equals(other.bMpAkcIzvestajiIskljArtikPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcIzvestajiIskljArtik[ bMpAkcIzvestajiIskljArtikPK=" + bMpAkcIzvestajiIskljArtikPK + " ]";
    }
    
}
