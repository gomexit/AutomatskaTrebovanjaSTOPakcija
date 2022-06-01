/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_MP_AKC_IZVESTAJI")
@NamedQueries({
    @NamedQuery(name = "BMpAkcIzvestaji.findAll", query = "SELECT b FROM BMpAkcIzvestaji b"),
    @NamedQuery(name = "BMpAkcIzvestaji.napuniListu", query = "SELECT b.nazivIzvestaja FROM BMpAkcIzvestaji b order by b.nazivIzvestaja"),
    @NamedQuery(name = "BMpAkcIzvestaji.findByNazivIzvestaja", query = "SELECT b FROM BMpAkcIzvestaji b WHERE b.nazivIzvestaja = :nazivIzvestaja"),
    @NamedQuery(name = "BMpAkcIzvestaji.vratiNazivProcedure", query = "SELECT b.nazivProcedure FROM BMpAkcIzvestaji b WHERE b.nazivIzvestaja = :nazivIzvestaja"),
    @NamedQuery(name = "BMpAkcIzvestaji.findByNazivProcedure", query = "SELECT b FROM BMpAkcIzvestaji b WHERE b.nazivProcedure = :nazivProcedure")})
public class BMpAkcIzvestaji implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NAZIV_IZVESTAJA")
    private String nazivIzvestaja;
    @Column(name = "NAZIV_PROCEDURE")
    private String nazivProcedure;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bMpAkcIzvestaji")
    private Collection<BMpAkcIzvestajiStavke> bMpAkcIzvestajiStavkeCollection;

    public BMpAkcIzvestaji() {
    }

    public BMpAkcIzvestaji(String nazivIzvestaja) {
        this.nazivIzvestaja = nazivIzvestaja;
    }

    public String getNazivIzvestaja() {
        return nazivIzvestaja;
    }

    public void setNazivIzvestaja(String nazivIzvestaja) {
        this.nazivIzvestaja = nazivIzvestaja;
    }

    public String getNazivProcedure() {
        return nazivProcedure;
    }

    public void setNazivProcedure(String nazivProcedure) {
        this.nazivProcedure = nazivProcedure;
    }

    public Collection<BMpAkcIzvestajiStavke> getBMpAkcIzvestajiStavkeCollection() {
        return bMpAkcIzvestajiStavkeCollection;
    }

    public void setBMpAkcIzvestajiStavkeCollection(Collection<BMpAkcIzvestajiStavke> bMpAkcIzvestajiStavkeCollection) {
        this.bMpAkcIzvestajiStavkeCollection = bMpAkcIzvestajiStavkeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nazivIzvestaja != null ? nazivIzvestaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcIzvestaji)) {
            return false;
        }
        BMpAkcIzvestaji other = (BMpAkcIzvestaji) object;
        if ((this.nazivIzvestaja == null && other.nazivIzvestaja != null) || (this.nazivIzvestaja != null && !this.nazivIzvestaja.equals(other.nazivIzvestaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcIzvestaji[ nazivIzvestaja=" + nazivIzvestaja + " ]";
    }
    
}
