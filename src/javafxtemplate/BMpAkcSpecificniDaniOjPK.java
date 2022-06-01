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
public class BMpAkcSpecificniDaniOjPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Basic(optional = false)
    @Column(name = "ORGJED")
    private String orgjed;

    public BMpAkcSpecificniDaniOjPK() {
    }

    public BMpAkcSpecificniDaniOjPK(Date datum, String orgjed) {
        this.datum = datum;
        this.orgjed = orgjed;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
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
        hash += (datum != null ? datum.hashCode() : 0);
        hash += (orgjed != null ? orgjed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcSpecificniDaniOjPK)) {
            return false;
        }
        BMpAkcSpecificniDaniOjPK other = (BMpAkcSpecificniDaniOjPK) object;
        if ((this.datum == null && other.datum != null) || (this.datum != null && !this.datum.equals(other.datum))) {
            return false;
        }
        if ((this.orgjed == null && other.orgjed != null) || (this.orgjed != null && !this.orgjed.equals(other.orgjed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcSpecificniDaniOjPK[ datum=" + datum + ", orgjed=" + orgjed + " ]";
    }
    
}
