/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_MP_AKC_ZAMENSKI2")
@NamedQueries({
    @NamedQuery(name = "BMpAkcZamenski2.findAll", query = "SELECT b FROM BMpAkcZamenski2 b"),
    @NamedQuery(name = "BMpAkcZamenski2.findByArtikal", query = "SELECT b FROM BMpAkcZamenski2 b WHERE b.artikal = :artikal"),
    @NamedQuery(name = "BMpAkcZamenski2.findByZamenski", query = "SELECT b FROM BMpAkcZamenski2 b WHERE b.zamenski = :zamenski"),
    @NamedQuery(name = "BMpAkcZamenski2.findByOdnos", query = "SELECT b FROM BMpAkcZamenski2 b WHERE b.odnos = :odnos")})
public class BMpAkcZamenski2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ARTIKAL")
    private Long artikal;
    @Column(name = "ZAMENSKI")
    private Long zamenski;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ODNOS")
    private BigDecimal odnos;

    public BMpAkcZamenski2() {
    }

    public BMpAkcZamenski2(Long artikal) {
        this.artikal = artikal;
    }

    public Long getArtikal() {
        return artikal;
    }

    public void setArtikal(Long artikal) {
        this.artikal = artikal;
    }

    public Long getZamenski() {
        return zamenski;
    }

    public void setZamenski(Long zamenski) {
        this.zamenski = zamenski;
    }

    public BigDecimal getOdnos() {
        return odnos;
    }

    public void setOdnos(BigDecimal odnos) {
        this.odnos = odnos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artikal != null ? artikal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcZamenski2)) {
            return false;
        }
        BMpAkcZamenski2 other = (BMpAkcZamenski2) object;
        if ((this.artikal == null && other.artikal != null) || (this.artikal != null && !this.artikal.equals(other.artikal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcZamenski2[ artikal=" + artikal + " ]";
    }
    
}
