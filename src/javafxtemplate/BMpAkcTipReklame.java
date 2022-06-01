/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author laki
 */
@Entity
@Table(name = "B_MP_AKC_TIP_REKLAME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BMpAkcTipReklame.findAll", query = "SELECT b FROM BMpAkcTipReklame b"),
    @NamedQuery(name = "BMpAkcTipReklame.pozovi", query = "SELECT b.naziv FROM BMpAkcTipReklame b"),
    @NamedQuery(name = "BMpAkcTipReklame.findByNaziv", query = "SELECT b FROM BMpAkcTipReklame b WHERE b.naziv = :naziv")})
public class BMpAkcTipReklame implements Serializable {

    @OneToMany(mappedBy = "tipReklame")
    private Collection<BMpAkcMarketing> bMpAkcMarketingCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;

    public BMpAkcTipReklame() {
    }

    public BMpAkcTipReklame(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (naziv != null ? naziv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcTipReklame)) {
            return false;
        }
        BMpAkcTipReklame other = (BMpAkcTipReklame) object;
        if ((this.naziv == null && other.naziv != null) || (this.naziv != null && !this.naziv.equals(other.naziv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcTipReklame[ naziv=" + naziv + " ]";
    }

    @XmlTransient
    public Collection<BMpAkcMarketing> getBMpAkcMarketingCollection() {
        return bMpAkcMarketingCollection;
    }

    public void setBMpAkcMarketingCollection(Collection<BMpAkcMarketing> bMpAkcMarketingCollection) {
        this.bMpAkcMarketingCollection = bMpAkcMarketingCollection;
    }
    
}
