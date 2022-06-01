/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "B_V_MP_AKC_SPECIFICNI_DANI_OJ")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcSpecificniDaniOj.findAll", query = "SELECT b FROM BVMpAkcSpecificniDaniOj b order by b.datum desc"),
    @NamedQuery(name = "BVMpAkcSpecificniDaniOj.findByDatum", query = "SELECT b FROM BVMpAkcSpecificniDaniOj b WHERE b.datum = :datum"),
    @NamedQuery(name = "BVMpAkcSpecificniDaniOj.findByKoefPrehrana", query = "SELECT b FROM BVMpAkcSpecificniDaniOj b WHERE b.koefPrehrana = :koefPrehrana"),
    @NamedQuery(name = "BVMpAkcSpecificniDaniOj.findByKoefNeprehrana", query = "SELECT b FROM BVMpAkcSpecificniDaniOj b WHERE b.koefNeprehrana = :koefNeprehrana"),
    @NamedQuery(name = "BVMpAkcSpecificniDaniOj.findByOrgjed", query = "SELECT b FROM BVMpAkcSpecificniDaniOj b WHERE b.orgjed = :orgjed"),
    @NamedQuery(name = "BVMpAkcSpecificniDaniOj.findByNaziv", query = "SELECT b FROM BVMpAkcSpecificniDaniOj b WHERE b.naziv = :naziv"),
    @NamedQuery(name = "BVMpAkcSpecificniDaniOj.findByBroj", query = "SELECT b FROM BVMpAkcSpecificniDaniOj b WHERE b.broj = :broj")})
public class BVMpAkcSpecificniDaniOj implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KOEF_PREHRANA")
    private BigDecimal koefPrehrana;
    @Column(name = "KOEF_NEPREHRANA")
    private BigDecimal koefNeprehrana;
    @Column(name = "ORGJED")
    private String orgjed;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;

    public BVMpAkcSpecificniDaniOj() {
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

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }
    
}
