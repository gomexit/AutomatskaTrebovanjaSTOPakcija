/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author laki
 */
@Entity
@Table(name = "B_V_MP_AKC_MARKETING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BVMpAkcMarketing.findAll", query = "SELECT b FROM BVMpAkcMarketing b"),
    @NamedQuery(name = "BVMpAkcMarketing.findById", query = "SELECT b FROM BVMpAkcMarketing b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcMarketing.findByArtikal", query = "SELECT b FROM BVMpAkcMarketing b WHERE b.artikal = :artikal"),
    @NamedQuery(name = "BVMpAkcMarketing.findByNaziv", query = "SELECT b FROM BVMpAkcMarketing b WHERE b.naziv = :naziv"),
    @NamedQuery(name = "BVMpAkcMarketing.findByKoeficijent", query = "SELECT b FROM BVMpAkcMarketing b WHERE b.koeficijent = :koeficijent"),
    @NamedQuery(name = "BVMpAkcMarketing.findByTipReklame", query = "SELECT b FROM BVMpAkcMarketing b WHERE b.tipReklame = :tipReklame"),
    @NamedQuery(name = "BVMpAkcMarketing.findByOpis", query = "SELECT b FROM BVMpAkcMarketing b WHERE b.opis = :opis"),
    @NamedQuery(name = "BVMpAkcMarketing.findByBroj", query = "SELECT b FROM BVMpAkcMarketing b WHERE b.broj = :broj")})
public class BVMpAkcMarketing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "ARTIKAL")
    private long artikal;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KOEFICIJENT")
    private BigDecimal koeficijent;
    @Column(name = "TIP_REKLAME")
    private String tipReklame;
    @Column(name = "OPIS")
    private String opis;
      @Id
    @Column(name = "BROJ")
    private BigInteger broj;

    public BVMpAkcMarketing() {
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

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getKoeficijent() {
        return koeficijent;
    }

    public void setKoeficijent(BigDecimal koeficijent) {
        this.koeficijent = koeficijent;
    }

    public String getTipReklame() {
        return tipReklame;
    }

    public void setTipReklame(String tipReklame) {
        this.tipReklame = tipReklame;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }
    
}
