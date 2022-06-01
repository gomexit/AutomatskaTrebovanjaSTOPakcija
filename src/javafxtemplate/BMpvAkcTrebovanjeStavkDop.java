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

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_MPV_AKC_TREBOVANJE_STAVK_DOP")
@NamedQueries({
    @NamedQuery(name = "BMpvAkcTrebovanjeStavkDop.findAll", query = "SELECT b FROM BMpvAkcTrebovanjeStavkDop b"),
    @NamedQuery(name = "BMpvAkcTrebovanjeStavkDop.findByEksterniBroj", query = "SELECT b FROM BMpvAkcTrebovanjeStavkDop b WHERE b.bMpvAkcTrebovanjeStavkDopPK.eksterniBroj = :eksterniBroj"),
    @NamedQuery(name = "BMpvAkcTrebovanjeStavkDop.findByRedniBroj", query = "SELECT b FROM BMpvAkcTrebovanjeStavkDop b WHERE b.bMpvAkcTrebovanjeStavkDopPK.redniBroj = :redniBroj"),
    @NamedQuery(name = "BMpvAkcTrebovanjeStavkDop.findByArtikal", query = "SELECT b FROM BMpvAkcTrebovanjeStavkDop b WHERE b.artikal = :artikal"),
    @NamedQuery(name = "BMpvAkcTrebovanjeStavkDop.findByJm", query = "SELECT b FROM BMpvAkcTrebovanjeStavkDop b WHERE b.jm = :jm"),
    @NamedQuery(name = "BMpvAkcTrebovanjeStavkDop.findByNabCena", query = "SELECT b FROM BMpvAkcTrebovanjeStavkDop b WHERE b.nabCena = :nabCena"),
    @NamedQuery(name = "BMpvAkcTrebovanjeStavkDop.findByProdCena", query = "SELECT b FROM BMpvAkcTrebovanjeStavkDop b WHERE b.prodCena = :prodCena"),
    @NamedQuery(name = "BMpvAkcTrebovanjeStavkDop.findByKolicina", query = "SELECT b FROM BMpvAkcTrebovanjeStavkDop b WHERE b.kolicina = :kolicina"),
    @NamedQuery(name = "BMpvAkcTrebovanjeStavkDop.findByArtikalSifra", query = "SELECT b FROM BMpvAkcTrebovanjeStavkDop b WHERE b.artikalSifra = :artikalSifra"),
    @NamedQuery(name = "BMpvAkcTrebovanjeStavkDop.findByBrojDopune", query = "SELECT b FROM BMpvAkcTrebovanjeStavkDop b WHERE b.brojDopune = :brojDopune")})
public class BMpvAkcTrebovanjeStavkDop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpvAkcTrebovanjeStavkDopPK bMpvAkcTrebovanjeStavkDopPK;
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
    @Column(name = "BROJ_DOPUNE")
    private Integer brojDopune;
    @JoinColumn(name = "EKSTERNI_BROJ", referencedColumnName = "EKSTERNI_BROJ", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BMpvAkcTrebovanjeZagDop bMpvAkcTrebovanjeZagDop;

    public BMpvAkcTrebovanjeStavkDop() {
    }

    public BMpvAkcTrebovanjeStavkDop(BMpvAkcTrebovanjeStavkDopPK bMpvAkcTrebovanjeStavkDopPK) {
        this.bMpvAkcTrebovanjeStavkDopPK = bMpvAkcTrebovanjeStavkDopPK;
    }

    public BMpvAkcTrebovanjeStavkDop(long eksterniBroj, int redniBroj) {
        this.bMpvAkcTrebovanjeStavkDopPK = new BMpvAkcTrebovanjeStavkDopPK(eksterniBroj, redniBroj);
    }

    public BMpvAkcTrebovanjeStavkDopPK getBMpvAkcTrebovanjeStavkDopPK() {
        return bMpvAkcTrebovanjeStavkDopPK;
    }

    public void setBMpvAkcTrebovanjeStavkDopPK(BMpvAkcTrebovanjeStavkDopPK bMpvAkcTrebovanjeStavkDopPK) {
        this.bMpvAkcTrebovanjeStavkDopPK = bMpvAkcTrebovanjeStavkDopPK;
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

    public Integer getBrojDopune() {
        return brojDopune;
    }

    public void setBrojDopune(Integer brojDopune) {
        this.brojDopune = brojDopune;
    }

    public BMpvAkcTrebovanjeZagDop getBMpvAkcTrebovanjeZagDop() {
        return bMpvAkcTrebovanjeZagDop;
    }

    public void setBMpvAkcTrebovanjeZagDop(BMpvAkcTrebovanjeZagDop bMpvAkcTrebovanjeZagDop) {
        this.bMpvAkcTrebovanjeZagDop = bMpvAkcTrebovanjeZagDop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpvAkcTrebovanjeStavkDopPK != null ? bMpvAkcTrebovanjeStavkDopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpvAkcTrebovanjeStavkDop)) {
            return false;
        }
        BMpvAkcTrebovanjeStavkDop other = (BMpvAkcTrebovanjeStavkDop) object;
        if ((this.bMpvAkcTrebovanjeStavkDopPK == null && other.bMpvAkcTrebovanjeStavkDopPK != null) || (this.bMpvAkcTrebovanjeStavkDopPK != null && !this.bMpvAkcTrebovanjeStavkDopPK.equals(other.bMpvAkcTrebovanjeStavkDopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpvAkcTrebovanjeStavkDop[ bMpvAkcTrebovanjeStavkDopPK=" + bMpvAkcTrebovanjeStavkDopPK + " ]";
    }
    
}
