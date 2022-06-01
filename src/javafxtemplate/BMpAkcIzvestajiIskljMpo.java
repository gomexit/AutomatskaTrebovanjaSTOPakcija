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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author laki
 */
@Entity
@Table(name = "B_MP_AKC_IZVESTAJI_ISKLJ_MPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BMpAkcIzvestajiIskljMpo.findAll", query = "SELECT b FROM BMpAkcIzvestajiIskljMpo b"),
    @NamedQuery(name = "BMpAkcIzvestajiIskljMpo.findById", query = "SELECT b FROM BMpAkcIzvestajiIskljMpo b WHERE b.bMpAkcIzvestajiIskljMpoPK.id = :id"),
    @NamedQuery(name = "BMpAkcIzvestajiIskljMpo.findByOBA", query = "SELECT b FROM BMpAkcIzvestajiIskljMpo b WHERE b.bMpAkcIzvestajiIskljMpoPK.id = :id and b.bMpAkcIzvestajiIskljMpoPK.orgjed = :orgjed"),
    @NamedQuery(name = "BMpAkcIzvestajiIskljMpo.findByOrgjed", query = "SELECT b FROM BMpAkcIzvestajiIskljMpo b WHERE b.bMpAkcIzvestajiIskljMpoPK.orgjed = :orgjed")})
public class BMpAkcIzvestajiIskljMpo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpAkcIzvestajiIskljMpoPK bMpAkcIzvestajiIskljMpoPK;

    public BMpAkcIzvestajiIskljMpo() {
    }

    public BMpAkcIzvestajiIskljMpo(BMpAkcIzvestajiIskljMpoPK bMpAkcIzvestajiIskljMpoPK) {
        this.bMpAkcIzvestajiIskljMpoPK = bMpAkcIzvestajiIskljMpoPK;
    }

    public BMpAkcIzvestajiIskljMpo(int id, String orgjed) {
        this.bMpAkcIzvestajiIskljMpoPK = new BMpAkcIzvestajiIskljMpoPK(id, orgjed);
    }

    public BMpAkcIzvestajiIskljMpoPK getBMpAkcIzvestajiIskljMpoPK() {
        return bMpAkcIzvestajiIskljMpoPK;
    }

    public void setBMpAkcIzvestajiIskljMpoPK(BMpAkcIzvestajiIskljMpoPK bMpAkcIzvestajiIskljMpoPK) {
        this.bMpAkcIzvestajiIskljMpoPK = bMpAkcIzvestajiIskljMpoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpAkcIzvestajiIskljMpoPK != null ? bMpAkcIzvestajiIskljMpoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcIzvestajiIskljMpo)) {
            return false;
        }
        BMpAkcIzvestajiIskljMpo other = (BMpAkcIzvestajiIskljMpo) object;
        if ((this.bMpAkcIzvestajiIskljMpoPK == null && other.bMpAkcIzvestajiIskljMpoPK != null) || (this.bMpAkcIzvestajiIskljMpoPK != null && !this.bMpAkcIzvestajiIskljMpoPK.equals(other.bMpAkcIzvestajiIskljMpoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcIzvestajiIskljMpo[ bMpAkcIzvestajiIskljMpoPK=" + bMpAkcIzvestajiIskljMpoPK + " ]";
    }
    
}
