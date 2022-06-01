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
public class BMpAkcIzvestajiIskljArtikPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "ARTIKAL")
    private long artikal;

    public BMpAkcIzvestajiIskljArtikPK() {
    }

    public BMpAkcIzvestajiIskljArtikPK(int id, long artikal) {
        this.id = id;
        this.artikal = artikal;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) artikal;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcIzvestajiIskljArtikPK)) {
            return false;
        }
        BMpAkcIzvestajiIskljArtikPK other = (BMpAkcIzvestajiIskljArtikPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.artikal != other.artikal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcIzvestajiIskljArtikPK[ id=" + id + ", artikal=" + artikal + " ]";
    }
    
}
