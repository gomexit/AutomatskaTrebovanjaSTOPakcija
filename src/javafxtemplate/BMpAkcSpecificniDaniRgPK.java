/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bojan
 */
@Embeddable
public class BMpAkcSpecificniDaniRgPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Basic(optional = false)
    @Column(name = "RG")
    private String rg;

    public BMpAkcSpecificniDaniRgPK() {
    }

    public BMpAkcSpecificniDaniRgPK(Date datum, String rg) {
        this.datum = datum;
        this.rg = rg;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datum != null ? datum.hashCode() : 0);
        hash += (rg != null ? rg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcSpecificniDaniRgPK)) {
            return false;
        }
        BMpAkcSpecificniDaniRgPK other = (BMpAkcSpecificniDaniRgPK) object;
        if ((this.datum == null && other.datum != null) || (this.datum != null && !this.datum.equals(other.datum))) {
            return false;
        }
        if ((this.rg == null && other.rg != null) || (this.rg != null && !this.rg.equals(other.rg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcSpecificniDaniRgPK[ datum=" + datum + ", rg=" + rg + " ]";
    }
    
}
