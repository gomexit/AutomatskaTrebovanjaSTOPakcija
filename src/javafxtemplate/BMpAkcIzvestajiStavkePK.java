/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author bojan
 */
@Embeddable
public class BMpAkcIzvestajiStavkePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "NAZIV_IZVESTAJA")
    private String nazivIzvestaja;
    @Basic(optional = false)
    @Column(name = "NAZIV_STAVKE")
    private String nazivStavke;

    public BMpAkcIzvestajiStavkePK() {
    }

    public BMpAkcIzvestajiStavkePK(String nazivIzvestaja, String nazivStavke) {
        this.nazivIzvestaja = nazivIzvestaja;
        this.nazivStavke = nazivStavke;
    }

    public String getNazivIzvestaja() {
        return nazivIzvestaja;
    }

    public void setNazivIzvestaja(String nazivIzvestaja) {
        this.nazivIzvestaja = nazivIzvestaja;
    }

    public String getNazivStavke() {
        return nazivStavke;
    }

    public void setNazivStavke(String nazivStavke) {
        this.nazivStavke = nazivStavke;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nazivIzvestaja != null ? nazivIzvestaja.hashCode() : 0);
        hash += (nazivStavke != null ? nazivStavke.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcIzvestajiStavkePK)) {
            return false;
        }
        BMpAkcIzvestajiStavkePK other = (BMpAkcIzvestajiStavkePK) object;
        if ((this.nazivIzvestaja == null && other.nazivIzvestaja != null) || (this.nazivIzvestaja != null && !this.nazivIzvestaja.equals(other.nazivIzvestaja))) {
            return false;
        }
        if ((this.nazivStavke == null && other.nazivStavke != null) || (this.nazivStavke != null && !this.nazivStavke.equals(other.nazivStavke))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcIzvestajiStavkePK[ nazivIzvestaja=" + nazivIzvestaja + ", nazivStavke=" + nazivStavke + " ]";
    }
    
}
