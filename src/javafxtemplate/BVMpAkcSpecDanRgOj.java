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
@Table(name = "B_V_MP_AKC_SPEC_DAN_RG_OJ")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcSpecDanRgOj.findAll", query = "SELECT b FROM BVMpAkcSpecDanRgOj b order by b.datum"),
    @NamedQuery(name = "BVMpAkcSpecDanRgOj.findByDatum", query = "SELECT b FROM BVMpAkcSpecDanRgOj b WHERE b.datum = :datum"),
    @NamedQuery(name = "BVMpAkcSpecDanRgOj.findByDatumRGOJ", query = "SELECT b FROM BVMpAkcSpecDanRgOj b WHERE b.datum = :datum and b.oj= :oj and b.rg = :rg"),
    @NamedQuery(name = "BVMpAkcSpecDanRgOj.findByKoef", query = "SELECT b FROM BVMpAkcSpecDanRgOj b WHERE b.koef = :koef"),
    @NamedQuery(name = "BVMpAkcSpecDanRgOj.findByRg", query = "SELECT b FROM BVMpAkcSpecDanRgOj b WHERE b.rg = :rg"),
    @NamedQuery(name = "BVMpAkcSpecDanRgOj.findByRobnaGrupa", query = "SELECT b FROM BVMpAkcSpecDanRgOj b WHERE b.robnaGrupa = :robnaGrupa"),
    @NamedQuery(name = "BVMpAkcSpecDanRgOj.findByOj", query = "SELECT b FROM BVMpAkcSpecDanRgOj b WHERE b.oj = :oj"),
    @NamedQuery(name = "BVMpAkcSpecDanRgOj.findByNazivOj", query = "SELECT b FROM BVMpAkcSpecDanRgOj b WHERE b.nazivOj = :nazivOj"),
    @NamedQuery(name = "BVMpAkcSpecDanRgOj.findByBroj", query = "SELECT b FROM BVMpAkcSpecDanRgOj b WHERE b.broj = :broj")})
public class BVMpAkcSpecDanRgOj implements Serializable {
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
    @Column(name = "ROBNA_GRUPA")
    private String robnaGrupa;
    @Column(name = "OJ")
    private String oj;
    @Basic(optional = false)
    @Column(name = "NAZIV_OJ")
    private String nazivOj;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;

    public BVMpAkcSpecDanRgOj() {
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

    public String getRobnaGrupa() {
        return robnaGrupa;
    }

    public void setRobnaGrupa(String robnaGrupa) {
        this.robnaGrupa = robnaGrupa;
    }

    public String getOj() {
        return oj;
    }

    public void setOj(String oj) {
        this.oj = oj;
    }

    public String getNazivOj() {
        return nazivOj;
    }

    public void setNazivOj(String nazivOj) {
        this.nazivOj = nazivOj;
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }
    
}
