/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_MP_AKC_TREBOVANJE_ZAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BMpAkcTrebovanjeZag.findAll", query = "SELECT b FROM BMpAkcTrebovanjeZag b")})
public class BMpAkcTrebovanjeZag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ORGJED")
    private String orgjed;
    @Column(name = "VD")
    private String vd;
    @Id
    @Basic(optional = false)
    @Column(name = "EKSTERNI_BROJ")
    private Long eksterniBroj;
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Column(name = "SIS_DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sisDatum;
    @Column(name = "MAGACIN")
    private String magacin;
    @Column(name = "KOMENTAR")
    private String komentar;
    @Column(name = "NAZIV_FAJLA")
    private String nazivFajla;
    @Column(name = "TIP_AKCIJE")
    private String tipAkcije;
    @Column(name = "DATUM_OD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumOd;
    @Column(name = "KREIRAN_FAJL")
    private String kreiranFajl;
    @Column(name = "RG_ROOT")
    private String rgRoot;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bMpAkcTrebovanjeZag")
    private Collection<BMpAkcTrebovanjeStavke> bMpAkcTrebovanjeStavkeCollection;

    public BMpAkcTrebovanjeZag() {
    }

    public BMpAkcTrebovanjeZag(Long eksterniBroj) {
        this.eksterniBroj = eksterniBroj;
    }

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    public String getVd() {
        return vd;
    }

    public void setVd(String vd) {
        this.vd = vd;
    }

    public Long getEksterniBroj() {
        return eksterniBroj;
    }

    public void setEksterniBroj(Long eksterniBroj) {
        this.eksterniBroj = eksterniBroj;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Date getSisDatum() {
        return sisDatum;
    }

    public void setSisDatum(Date sisDatum) {
        this.sisDatum = sisDatum;
    }

    public String getMagacin() {
        return magacin;
    }

    public void setMagacin(String magacin) {
        this.magacin = magacin;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public String getNazivFajla() {
        return nazivFajla;
    }

    public void setNazivFajla(String nazivFajla) {
        this.nazivFajla = nazivFajla;
    }

    public String getTipAkcije() {
        return tipAkcije;
    }

    public void setTipAkcije(String tipAkcije) {
        this.tipAkcije = tipAkcije;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public String getKreiranFajl() {
        return kreiranFajl;
    }

    public void setKreiranFajl(String kreiranFajl) {
        this.kreiranFajl = kreiranFajl;
    }

    public String getRgRoot() {
        return rgRoot;
    }

    public void setRgRoot(String rgRoot) {
        this.rgRoot = rgRoot;
    }

    @XmlTransient
    public Collection<BMpAkcTrebovanjeStavke> getBMpAkcTrebovanjeStavkeCollection() {
        return bMpAkcTrebovanjeStavkeCollection;
    }

    public void setBMpAkcTrebovanjeStavkeCollection(Collection<BMpAkcTrebovanjeStavke> bMpAkcTrebovanjeStavkeCollection) {
        this.bMpAkcTrebovanjeStavkeCollection = bMpAkcTrebovanjeStavkeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eksterniBroj != null ? eksterniBroj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcTrebovanjeZag)) {
            return false;
        }
        BMpAkcTrebovanjeZag other = (BMpAkcTrebovanjeZag) object;
        if ((this.eksterniBroj == null && other.eksterniBroj != null) || (this.eksterniBroj != null && !this.eksterniBroj.equals(other.eksterniBroj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcTrebovanjeZag[ eksterniBroj=" + eksterniBroj + " ]";
    }
    
}
