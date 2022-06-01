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
@Table(name = "B_MP_AKC_SPECIFICNI_DANI_RG_OJ")
@NamedQueries({
    @NamedQuery(name = "BMpAkcSpecificniDaniRgOj.findAll", query = "SELECT b FROM BMpAkcSpecificniDaniRgOj b"),
    @NamedQuery(name = "BMpAkcSpecificniDaniRgOj.findByDatum", query = "SELECT b FROM BMpAkcSpecificniDaniRgOj b WHERE b.bMpAkcSpecificniDaniRgOjPK.datum = :datum"),
     @NamedQuery(name = "BMpAkcSpecificniDaniRgOj.findByDatumRGOJ", query = "SELECT b FROM BMpAkcSpecificniDaniRgOj b WHERE b.bMpAkcSpecificniDaniRgOjPK.datum = :datum and b.bMpAkcSpecificniDaniRgOjPK.oj = :oj and b.bMpAkcSpecificniDaniRgOjPK.rg = :rg"),
    @NamedQuery(name = "BMpAkcSpecificniDaniRgOj.findByKoef", query = "SELECT b FROM BMpAkcSpecificniDaniRgOj b WHERE b.koef = :koef"),
    @NamedQuery(name = "BMpAkcSpecificniDaniRgOj.findByRg", query = "SELECT b FROM BMpAkcSpecificniDaniRgOj b WHERE b.bMpAkcSpecificniDaniRgOjPK.rg = :rg"),
    @NamedQuery(name = "BMpAkcSpecificniDaniRgOj.findByOj", query = "SELECT b FROM BMpAkcSpecificniDaniRgOj b WHERE b.bMpAkcSpecificniDaniRgOjPK.oj = :oj")})
public class BMpAkcSpecificniDaniRgOj implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpAkcSpecificniDaniRgOjPK bMpAkcSpecificniDaniRgOjPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KOEF")
    private BigDecimal koef;

    public BMpAkcSpecificniDaniRgOj() {
    }

    public BMpAkcSpecificniDaniRgOj(BMpAkcSpecificniDaniRgOjPK bMpAkcSpecificniDaniRgOjPK) {
        this.bMpAkcSpecificniDaniRgOjPK = bMpAkcSpecificniDaniRgOjPK;
    }

    public BMpAkcSpecificniDaniRgOj(Date datum, String rg, String oj) {
        this.bMpAkcSpecificniDaniRgOjPK = new BMpAkcSpecificniDaniRgOjPK(datum, rg, oj);
    }

    public BMpAkcSpecificniDaniRgOjPK getBMpAkcSpecificniDaniRgOjPK() {
        return bMpAkcSpecificniDaniRgOjPK;
    }

    public void setBMpAkcSpecificniDaniRgOjPK(BMpAkcSpecificniDaniRgOjPK bMpAkcSpecificniDaniRgOjPK) {
        this.bMpAkcSpecificniDaniRgOjPK = bMpAkcSpecificniDaniRgOjPK;
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
        hash += (bMpAkcSpecificniDaniRgOjPK != null ? bMpAkcSpecificniDaniRgOjPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcSpecificniDaniRgOj)) {
            return false;
        }
        BMpAkcSpecificniDaniRgOj other = (BMpAkcSpecificniDaniRgOj) object;
        if ((this.bMpAkcSpecificniDaniRgOjPK == null && other.bMpAkcSpecificniDaniRgOjPK != null) || (this.bMpAkcSpecificniDaniRgOjPK != null && !this.bMpAkcSpecificniDaniRgOjPK.equals(other.bMpAkcSpecificniDaniRgOjPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcSpecificniDaniRgOj[ bMpAkcSpecificniDaniRgOjPK=" + bMpAkcSpecificniDaniRgOjPK + " ]";
    }
    
}
