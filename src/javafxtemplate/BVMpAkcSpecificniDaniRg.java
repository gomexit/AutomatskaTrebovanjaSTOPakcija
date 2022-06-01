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
@Table(name = "B_V_MP_AKC_SPECIFICNI_DANI_RG")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcSpecificniDaniRg.findAll", query = "SELECT b FROM BVMpAkcSpecificniDaniRg b order by b.datum desc"),
    @NamedQuery(name = "BVMpAkcSpecificniDaniRg.findByDatum", query = "SELECT b FROM BVMpAkcSpecificniDaniRg b WHERE b.datum = :datum"),
    @NamedQuery(name = "BVMpAkcSpecificniDaniRg.findByKoef", query = "SELECT b FROM BVMpAkcSpecificniDaniRg b WHERE b.koef = :koef"),
    @NamedQuery(name = "BVMpAkcSpecificniDaniRg.findByRg", query = "SELECT b FROM BVMpAkcSpecificniDaniRg b WHERE b.rg = :rg"),
    @NamedQuery(name = "BVMpAkcSpecificniDaniRg.findByNazivRobneGrupe", query = "SELECT b FROM BVMpAkcSpecificniDaniRg b WHERE b.nazivRobneGrupe = :nazivRobneGrupe"),
    @NamedQuery(name = "BVMpAkcSpecificniDaniRg.findByNazivNadgrupe1", query = "SELECT b FROM BVMpAkcSpecificniDaniRg b WHERE b.nazivNadgrupe1 = :nazivNadgrupe1"),
    @NamedQuery(name = "BVMpAkcSpecificniDaniRg.findByBroj", query = "SELECT b FROM BVMpAkcSpecificniDaniRg b WHERE b.broj = :broj")})
public class BVMpAkcSpecificniDaniRg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KOEF")
    private BigDecimal koef;
    @Column(name = "RG")
    private String rg;
    @Basic(optional = false)
    @Column(name = "NAZIV_ROBNE_GRUPE")
    private String nazivRobneGrupe;
    @Basic(optional = false)
    @Column(name = "NAZIV_NADGRUPE1")
    private String nazivNadgrupe1;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;

    public BVMpAkcSpecificniDaniRg() {
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

    public BigDecimal getKoef() {
        return koef;
    }

    public void setKoef(BigDecimal koef) {
        this.koef = koef;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNazivRobneGrupe() {
        return nazivRobneGrupe;
    }

    public void setNazivRobneGrupe(String nazivRobneGrupe) {
        this.nazivRobneGrupe = nazivRobneGrupe;
    }

    public String getNazivNadgrupe1() {
        return nazivNadgrupe1;
    }

    public void setNazivNadgrupe1(String nazivNadgrupe1) {
        this.nazivNadgrupe1 = nazivNadgrupe1;
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }
    
}
