/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_MP_AKC_SPECIFICNI_DANI")
@NamedQueries({
    @NamedQuery(name = "BMpAkcSpecificniDani.findAll", query = "SELECT b FROM BMpAkcSpecificniDani b order by b.datum desc"),
    @NamedQuery(name = "BMpAkcSpecificniDani.findByDatum", query = "SELECT b FROM BMpAkcSpecificniDani b WHERE b.datum = :datum"),
    @NamedQuery(name = "BMpAkcSpecificniDani.findByKoefPrehrana", query = "SELECT b FROM BMpAkcSpecificniDani b WHERE b.koefPrehrana = :koefPrehrana"),
    @NamedQuery(name = "BMpAkcSpecificniDani.findByKoefNeprehrana", query = "SELECT b FROM BMpAkcSpecificniDani b WHERE b.koefNeprehrana = :koefNeprehrana")})
public class BMpAkcSpecificniDani implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KOEF_PREHRANA")
    private BigDecimal koefPrehrana;
    @Column(name = "KOEF_NEPREHRANA")
    private BigDecimal koefNeprehrana;

    public BMpAkcSpecificniDani() {
    }

    public BMpAkcSpecificniDani(Date datum) {
        this.datum = datum;
    }

    
        
    public Date getDatum2() {
        return datum;
    }   
    
        public String getDatum() {
             SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String time = sdf.format(datum);
        return time;
    }   
    
    

    public void setDatum(Date datum) {
        this.datum = datum;
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
        hash += (datum != null ? datum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcSpecificniDani)) {
            return false;
        }
        BMpAkcSpecificniDani other = (BMpAkcSpecificniDani) object;
        if ((this.datum == null && other.datum != null) || (this.datum != null && !this.datum.equals(other.datum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcSpecificniDani[ datum=" + datum + " ]";
    }
    
}
