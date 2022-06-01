/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author laki
 */
@Entity
@Table(name = "B_MP_AKC_MARKETING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BMpAkcMarketing.findAll", query = "SELECT b FROM BMpAkcMarketing b"),
    @NamedQuery(name = "BMpAkcMarketing.findById", query = "SELECT b FROM BMpAkcMarketing b WHERE b.bMpAkcMarketingPK.id = :id"),
    @NamedQuery(name = "BMpAkcMarketing.findByArtikal", query = "SELECT b FROM BMpAkcMarketing b WHERE b.bMpAkcMarketingPK.artikal = :artikal"),
    @NamedQuery(name = "BMpAkcMarketing.findBy2PK", query = "SELECT b FROM BMpAkcMarketing b WHERE b.bMpAkcMarketingPK.artikal = :artikal and b.bMpAkcMarketingPK.id = :id"),
    @NamedQuery(name = "BMpAkcMarketing.findByKoeficijent", query = "SELECT b FROM BMpAkcMarketing b WHERE b.koeficijent = :koeficijent"),
    @NamedQuery(name = "BMpAkcMarketing.findByOpis", query = "SELECT b FROM BMpAkcMarketing b WHERE b.opis = :opis")})
public class BMpAkcMarketing implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpAkcMarketingPK bMpAkcMarketingPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KOEFICIJENT")
    private BigDecimal koeficijent;
    @Column(name = "OPIS")
    private String opis;
    @JoinColumn(name = "TIP_REKLAME", referencedColumnName = "NAZIV")
    @ManyToOne
    private BMpAkcTipReklame tipReklame;

    public BMpAkcMarketing() {
    }

    public BMpAkcMarketing(BMpAkcMarketingPK bMpAkcMarketingPK) {
        this.bMpAkcMarketingPK = bMpAkcMarketingPK;
    }

    public BMpAkcMarketing(int id, long artikal) {
        this.bMpAkcMarketingPK = new BMpAkcMarketingPK(id, artikal);
    }

    public BMpAkcMarketingPK getBMpAkcMarketingPK() {
        return bMpAkcMarketingPK;
    }

    public void setBMpAkcMarketingPK(BMpAkcMarketingPK bMpAkcMarketingPK) {
        this.bMpAkcMarketingPK = bMpAkcMarketingPK;
    }

    public BigDecimal getKoeficijent() {
        return koeficijent;
    }

    public void setKoeficijent(BigDecimal koeficijent) {
        this.koeficijent = koeficijent;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public BMpAkcTipReklame getTipReklame() {
        return tipReklame;
    }

    public void setTipReklame(BMpAkcTipReklame tipReklame) {
        this.tipReklame = tipReklame;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpAkcMarketingPK != null ? bMpAkcMarketingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcMarketing)) {
            return false;
        }
        BMpAkcMarketing other = (BMpAkcMarketing) object;
        if ((this.bMpAkcMarketingPK == null && other.bMpAkcMarketingPK != null) || (this.bMpAkcMarketingPK != null && !this.bMpAkcMarketingPK.equals(other.bMpAkcMarketingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcMarketing[ bMpAkcMarketingPK=" + bMpAkcMarketingPK + " ]";
    }
    
}
