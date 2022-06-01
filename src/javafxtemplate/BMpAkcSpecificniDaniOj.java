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
@Table(name = "B_MP_AKC_SPECIFICNI_DANI_OJ")
@NamedQueries({
    @NamedQuery(name = "BMpAkcSpecificniDaniOj.findAll", query = "SELECT b FROM BMpAkcSpecificniDaniOj b"),
    @NamedQuery(name = "BMpAkcSpecificniDaniOj.findByDatumOJ", query = "SELECT b FROM BMpAkcSpecificniDaniOj b WHERE b.bMpAkcSpecificniDaniOjPK.datum = :datum and b.bMpAkcSpecificniDaniOjPK.orgjed= :orgjed"),
    @NamedQuery(name = "BMpAkcSpecificniDaniOj.findByKoefPrehrana", query = "SELECT b FROM BMpAkcSpecificniDaniOj b WHERE b.koefPrehrana = :koefPrehrana"),
    @NamedQuery(name = "BMpAkcSpecificniDaniOj.findByKoefNeprehrana", query = "SELECT b FROM BMpAkcSpecificniDaniOj b WHERE b.koefNeprehrana = :koefNeprehrana"),
    @NamedQuery(name = "BMpAkcSpecificniDaniOj.findByOrgjed", query = "SELECT b FROM BMpAkcSpecificniDaniOj b WHERE b.bMpAkcSpecificniDaniOjPK.orgjed = :orgjed")})
public class BMpAkcSpecificniDaniOj implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpAkcSpecificniDaniOjPK bMpAkcSpecificniDaniOjPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KOEF_PREHRANA")
    private BigDecimal koefPrehrana;
    @Column(name = "KOEF_NEPREHRANA")
    private BigDecimal koefNeprehrana;

    public BMpAkcSpecificniDaniOj() {
    }

    public BMpAkcSpecificniDaniOj(BMpAkcSpecificniDaniOjPK bMpAkcSpecificniDaniOjPK) {
        this.bMpAkcSpecificniDaniOjPK = bMpAkcSpecificniDaniOjPK;
    }

    public BMpAkcSpecificniDaniOj(Date datum, String orgjed) {
        this.bMpAkcSpecificniDaniOjPK = new BMpAkcSpecificniDaniOjPK(datum, orgjed);
    }

    public BMpAkcSpecificniDaniOjPK getBMpAkcSpecificniDaniOjPK() {
        return bMpAkcSpecificniDaniOjPK;
    }

    public void setBMpAkcSpecificniDaniOjPK(BMpAkcSpecificniDaniOjPK bMpAkcSpecificniDaniOjPK) {
        this.bMpAkcSpecificniDaniOjPK = bMpAkcSpecificniDaniOjPK;
    }

    public BigDecimal getKoefPrehrana() {
        return koefPrehrana;
    }

    public void setKoefPrehrana(BigDecimal koefPrehrana) {
        this.koefPrehrana = koefPrehrana;
    }

    public BigDecimal getKoefNeprehrana() {
        return koefNeprehrana;
    }

    public void setKoefNeprehrana(BigDecimal koefNeprehrana) {
        this.koefNeprehrana = koefNeprehrana;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpAkcSpecificniDaniOjPK != null ? bMpAkcSpecificniDaniOjPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcSpecificniDaniOj)) {
            return false;
        }
        BMpAkcSpecificniDaniOj other = (BMpAkcSpecificniDaniOj) object;
        if ((this.bMpAkcSpecificniDaniOjPK == null && other.bMpAkcSpecificniDaniOjPK != null) || (this.bMpAkcSpecificniDaniOjPK != null && !this.bMpAkcSpecificniDaniOjPK.equals(other.bMpAkcSpecificniDaniOjPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcSpecificniDaniOj[ bMpAkcSpecificniDaniOjPK=" + bMpAkcSpecificniDaniOjPK + " ]";
    }
    
}
