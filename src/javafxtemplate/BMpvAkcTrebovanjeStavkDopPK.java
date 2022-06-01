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
public class BMpvAkcTrebovanjeStavkDopPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "EKSTERNI_BROJ")
    private long eksterniBroj;
    @Basic(optional = false)
    @Column(name = "REDNI_BROJ")
    private int redniBroj;

    public BMpvAkcTrebovanjeStavkDopPK() {
    }

    public BMpvAkcTrebovanjeStavkDopPK(long eksterniBroj, int redniBroj) {
        this.eksterniBroj = eksterniBroj;
        this.redniBroj = redniBroj;
    }

    public long getEksterniBroj() {
        return eksterniBroj;
    }

    public void setEksterniBroj(long eksterniBroj) {
        this.eksterniBroj = eksterniBroj;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) eksterniBroj;
        hash += (int) redniBroj;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpvAkcTrebovanjeStavkDopPK)) {
            return false;
        }
        BMpvAkcTrebovanjeStavkDopPK other = (BMpvAkcTrebovanjeStavkDopPK) object;
        if (this.eksterniBroj != other.eksterniBroj) {
            return false;
        }
        if (this.redniBroj != other.redniBroj) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpvAkcTrebovanjeStavkDopPK[ eksterniBroj=" + eksterniBroj + ", redniBroj=" + redniBroj + " ]";
    }
    
}
