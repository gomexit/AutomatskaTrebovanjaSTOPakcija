/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
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
@Table(name = "B_MP_AKC_SPECIFICNI_DANI_RG")
@NamedQueries({
    @NamedQuery(name = "BMpAkcSpecificniDaniRg.findAll", query = "SELECT b FROM BMpAkcSpecificniDaniRg b"),
    @NamedQuery(name = "BMpAkcSpecificniDaniRg.findByDatum", query = "SELECT b FROM BMpAkcSpecificniDaniRg b WHERE b.bMpAkcSpecificniDaniRgPK.datum = :datum"),
    @NamedQuery(name = "BMpAkcSpecificniDaniRg.findByDatumRG", query = "SELECT b FROM BMpAkcSpecificniDaniRg b WHERE b.bMpAkcSpecificniDaniRgPK.datum = :datum and b.bMpAkcSpecificniDaniRgPK.rg = :rg"),
    @NamedQuery(name = "BMpAkcSpecificniDaniRg.findByKoef", query = "SELECT b FROM BMpAkcSpecificniDaniRg b WHERE b.koef = :koef"),
    @NamedQuery(name = "BMpAkcSpecificniDaniRg.findByRg", query = "SELECT b FROM BMpAkcSpecificniDaniRg b WHERE b.bMpAkcSpecificniDaniRgPK.rg = :rg")})
public class BMpAkcSpecificniDaniRg implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpAkcSpecificniDaniRgPK bMpAkcSpecificniDaniRgPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KOEF")
    private BigDecimal koef;

    public BMpAkcSpecificniDaniRg() {
    }

    public BMpAkcSpecificniDaniRg(BMpAkcSpecificniDaniRgPK bMpAkcSpecificniDaniRgPK) {
        this.bMpAkcSpecificniDaniRgPK = bMpAkcSpecificniDaniRgPK;
    }

    public BMpAkcSpecificniDaniRg(Date datum, String rg) {
        this.bMpAkcSpecificniDaniRgPK = new BMpAkcSpecificniDaniRgPK(datum, rg);
    }

    public BMpAkcSpecificniDaniRgPK getBMpAkcSpecificniDaniRgPK() {
        return bMpAkcSpecificniDaniRgPK;
    }

    public void setBMpAkcSpecificniDaniRgPK(BMpAkcSpecificniDaniRgPK bMpAkcSpecificniDaniRgPK) {
        this.bMpAkcSpecificniDaniRgPK = bMpAkcSpecificniDaniRgPK;
    }

    public BigDecimal getKoef() {
        return koef;
    }

    public void setKoef(BigDecimal koef) {
        this.koef = koef;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpAkcSpecificniDaniRgPK != null ? bMpAkcSpecificniDaniRgPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcSpecificniDaniRg)) {
            return false;
        }
        BMpAkcSpecificniDaniRg other = (BMpAkcSpecificniDaniRg) object;
        if ((this.bMpAkcSpecificniDaniRgPK == null && other.bMpAkcSpecificniDaniRgPK != null) || (this.bMpAkcSpecificniDaniRgPK != null && !this.bMpAkcSpecificniDaniRgPK.equals(other.bMpAkcSpecificniDaniRgPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcSpecificniDaniRg[ bMpAkcSpecificniDaniRgPK=" + bMpAkcSpecificniDaniRgPK + " ]";
    }
    
}
