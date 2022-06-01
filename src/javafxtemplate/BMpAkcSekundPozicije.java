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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_MP_AKC_SEKUND_POZICIJE")
@NamedQueries({
    @NamedQuery(name = "BMpAkcSekundPozicije.findAll", query = "SELECT b FROM BMpAkcSekundPozicije b"),
    @NamedQuery(name = "BMpAkcSekundPozicije.findByIdAkcije", query = "SELECT b FROM BMpAkcSekundPozicije b WHERE b.bMpAkcSekundPozicijePK.idAkcije = :idAkcije"),
    @NamedQuery(name = "BMpAkcSekundPozicije.findByIdKampanje", query = "SELECT b FROM BMpAkcSekundPozicije b WHERE b.bMpAkcSekundPozicijePK.idKampanje = :idKampanje"),
    @NamedQuery(name = "BMpAkcSekundPozicije.findByArtikal", query = "SELECT b FROM BMpAkcSekundPozicije b WHERE b.bMpAkcSekundPozicijePK.artikal = :artikal"),
    @NamedQuery(name = "BMpAkcSekundPozicije.findByOrgjed", query = "SELECT b FROM BMpAkcSekundPozicije b WHERE b.bMpAkcSekundPozicijePK.orgjed = :orgjed"),
    @NamedQuery(name = "BMpAkcSekundPozicije.findByKolicina", query = "SELECT b FROM BMpAkcSekundPozicije b WHERE b.kolicina = :kolicina")})
public class BMpAkcSekundPozicije implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpAkcSekundPozicijePK bMpAkcSekundPozicijePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KOLICINA")
    private BigDecimal kolicina;

    public BMpAkcSekundPozicije() {
    }

    public BMpAkcSekundPozicije(BMpAkcSekundPozicijePK bMpAkcSekundPozicijePK) {
        this.bMpAkcSekundPozicijePK = bMpAkcSekundPozicijePK;
    }

    public BMpAkcSekundPozicije(long idAkcije, String idKampanje, long artikal, String orgjed) {
        this.bMpAkcSekundPozicijePK = new BMpAkcSekundPozicijePK(idAkcije, idKampanje, artikal, orgjed);
    }

    public BMpAkcSekundPozicijePK getBMpAkcSekundPozicijePK() {
        return bMpAkcSekundPozicijePK;
    }

    public void setBMpAkcSekundPozicijePK(BMpAkcSekundPozicijePK bMpAkcSekundPozicijePK) {
        this.bMpAkcSekundPozicijePK = bMpAkcSekundPozicijePK;
    }

    public BigDecimal getKolicina() {
        return kolicina;
    }

    public void setKolicina(BigDecimal kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpAkcSekundPozicijePK != null ? bMpAkcSekundPozicijePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcSekundPozicije)) {
            return false;
        }
        BMpAkcSekundPozicije other = (BMpAkcSekundPozicije) object;
        if ((this.bMpAkcSekundPozicijePK == null && other.bMpAkcSekundPozicijePK != null) || (this.bMpAkcSekundPozicijePK != null && !this.bMpAkcSekundPozicijePK.equals(other.bMpAkcSekundPozicijePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcSekundPozicije[ bMpAkcSekundPozicijePK=" + bMpAkcSekundPozicijePK + " ]";
    }
    
}
