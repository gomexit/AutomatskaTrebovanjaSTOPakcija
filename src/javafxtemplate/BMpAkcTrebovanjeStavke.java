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
 * @author bojan
 */
@Entity
@Table(name = "B_MP_AKC_TREBOVANJE_STAVKE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BMpAkcTrebovanjeStavke.findAll", query = "SELECT b FROM BMpAkcTrebovanjeStavke b")})
public class BMpAkcTrebovanjeStavke implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpAkcTrebovanjeStavkePK bMpAkcTrebovanjeStavkePK;
    @Column(name = "ARTIKAL")
    private Long artikal;
    @Column(name = "JM")
    private String jm;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NAB_CENA")
    private BigDecimal nabCena;
    @Column(name = "PROD_CENA")
    private BigDecimal prodCena;
    @Column(name = "KOLICINA")
    private BigDecimal kolicina;
    @Column(name = "ARTIKAL_SIFRA")
    private String artikalSifra;
    @JoinColumn(name = "EKSTERNI_BROJ", referencedColumnName = "EKSTERNI_BROJ", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BMpAkcTrebovanjeZag bMpAkcTrebovanjeZag;

    public BMpAkcTrebovanjeStavke() {
    }

    public BMpAkcTrebovanjeStavke(BMpAkcTrebovanjeStavkePK bMpAkcTrebovanjeStavkePK) {
        this.bMpAkcTrebovanjeStavkePK = bMpAkcTrebovanjeStavkePK;
    }

    public BMpAkcTrebovanjeStavke(long eksterniBroj, int redniBroj) {
        this.bMpAkcTrebovanjeStavkePK = new BMpAkcTrebovanjeStavkePK(eksterniBroj, redniBroj);
    }

    public BMpAkcTrebovanjeStavkePK getBMpAkcTrebovanjeStavkePK() {
        return bMpAkcTrebovanjeStavkePK;
    }

    public void setBMpAkcTrebovanjeStavkePK(BMpAkcTrebovanjeStavkePK bMpAkcTrebovanjeStavkePK) {
        this.bMpAkcTrebovanjeStavkePK = bMpAkcTrebovanjeStavkePK;
    }

    public Long getArtikal() {
        return artikal;
    }

    public void setArtikal(Long artikal) {
        this.artikal = artikal;
    }

    public String getJm() {
        return jm;
    }

    public void setJm(String jm) {
        this.jm = jm;
    }

    public BigDecimal getNabCena() {
        return nabCena;
    }

    public void setNabCena(BigDecimal nabCena) {
        this.nabCena = nabCena;
    }

    public BigDecimal getProdCena() {
        return prodCena;
    }

    public void setProdCena(BigDecimal prodCena) {
        this.prodCena = prodCena;
    }

    public BigDecimal getKolicina() {
        return kolicina;
    }

    public void setKolicina(BigDecimal kolicina) {
        this.kolicina = kolicina;
    }

    public String getArtikalSifra() {
        return artikalSifra;
    }

    public void setArtikalSifra(String artikalSifra) {
        this.artikalSifra = artikalSifra;
    }

    public BMpAkcTrebovanjeZag getBMpAkcTrebovanjeZag() {
        return bMpAkcTrebovanjeZag;
    }

    public void setBMpAkcTrebovanjeZag(BMpAkcTrebovanjeZag bMpAkcTrebovanjeZag) {
        this.bMpAkcTrebovanjeZag = bMpAkcTrebovanjeZag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpAkcTrebovanjeStavkePK != null ? bMpAkcTrebovanjeStavkePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcTrebovanjeStavke)) {
            return false;
        }
        BMpAkcTrebovanjeStavke other = (BMpAkcTrebovanjeStavke) object;
        if ((this.bMpAkcTrebovanjeStavkePK == null && other.bMpAkcTrebovanjeStavkePK != null) || (this.bMpAkcTrebovanjeStavkePK != null && !this.bMpAkcTrebovanjeStavkePK.equals(other.bMpAkcTrebovanjeStavkePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcTrebovanjeStavke[ bMpAkcTrebovanjeStavkePK=" + bMpAkcTrebovanjeStavkePK + " ]";
    }
    
}
