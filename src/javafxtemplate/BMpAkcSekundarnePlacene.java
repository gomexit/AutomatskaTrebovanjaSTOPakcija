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
@Table(name = "B_MP_AKC_SEKUNDARNE_PLACENE")
@NamedQueries({
    @NamedQuery(name = "BMpAkcSekundarnePlacene.findAll", query = "SELECT b FROM BMpAkcSekundarnePlacene b"),
    @NamedQuery(name = "BMpAkcSekundarnePlacene.findById", query = "SELECT b FROM BMpAkcSekundarnePlacene b WHERE b.bMpAkcSekundarnePlacenePK.id = :id"),
    @NamedQuery(name = "BMpAkcSekundarnePlacene.findByOba", query = "SELECT b FROM BMpAkcSekundarnePlacene b WHERE b.bMpAkcSekundarnePlacenePK.id = :id and b.bMpAkcSekundarnePlacenePK.artikal = :artikal"),
    @NamedQuery(name = "BMpAkcSekundarnePlacene.findByArtikal", query = "SELECT b FROM BMpAkcSekundarnePlacene b WHERE b.bMpAkcSekundarnePlacenePK.artikal = :artikal")})
public class BMpAkcSekundarnePlacene implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpAkcSekundarnePlacenePK bMpAkcSekundarnePlacenePK;

    public BMpAkcSekundarnePlacene() {
    }

    public BMpAkcSekundarnePlacene(BMpAkcSekundarnePlacenePK bMpAkcSekundarnePlacenePK) {
        this.bMpAkcSekundarnePlacenePK = bMpAkcSekundarnePlacenePK;
    }

    public BMpAkcSekundarnePlacene(int id, long artikal) {
        this.bMpAkcSekundarnePlacenePK = new BMpAkcSekundarnePlacenePK(id, artikal);
    }

    public BMpAkcSekundarnePlacenePK getBMpAkcSekundarnePlacenePK() {
        return bMpAkcSekundarnePlacenePK;
    }

    public void setBMpAkcSekundarnePlacenePK(BMpAkcSekundarnePlacenePK bMpAkcSekundarnePlacenePK) {
        this.bMpAkcSekundarnePlacenePK = bMpAkcSekundarnePlacenePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpAkcSekundarnePlacenePK != null ? bMpAkcSekundarnePlacenePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcSekundarnePlacene)) {
            return false;
        }
        BMpAkcSekundarnePlacene other = (BMpAkcSekundarnePlacene) object;
        if ((this.bMpAkcSekundarnePlacenePK == null && other.bMpAkcSekundarnePlacenePK != null) || (this.bMpAkcSekundarnePlacenePK != null && !this.bMpAkcSekundarnePlacenePK.equals(other.bMpAkcSekundarnePlacenePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcSekundarnePlacene[ bMpAkcSekundarnePlacenePK=" + bMpAkcSekundarnePlacenePK + " ]";
    }
    
}
