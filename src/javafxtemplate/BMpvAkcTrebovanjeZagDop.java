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

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_MPV_AKC_TREBOVANJE_ZAG_DOP")
@NamedQueries({
    @NamedQuery(name = "BMpvAkcTrebovanjeZagDop.findAll", query = "SELECT b FROM BMpvAkcTrebovanjeZagDop b"),
    @NamedQuery(name = "BMpvAkcTrebovanjeZagDop.findByOrgjed", query = "SELECT b FROM BMpvAkcTrebovanjeZagDop b WHERE b.orgjed = :orgjed"),
    @NamedQuery(name = "BMpvAkcTrebovanjeZagDop.findByVd", query = "SELECT b FROM BMpvAkcTrebovanjeZagDop b WHERE b.vd = :vd"),
    @NamedQuery(name = "BMpvAkcTrebovanjeZagDop.findByEksterniBroj", query = "SELECT b FROM BMpvAkcTrebovanjeZagDop b WHERE b.eksterniBroj = :eksterniBroj"),
    @NamedQuery(name = "BMpvAkcTrebovanjeZagDop.findByDatum", query = "SELECT b FROM BMpvAkcTrebovanjeZagDop b WHERE b.datum = :datum"),
    @NamedQuery(name = "BMpvAkcTrebovanjeZagDop.findBySisDatum", query = "SELECT b FROM BMpvAkcTrebovanjeZagDop b WHERE b.sisDatum = :sisDatum"),
    @NamedQuery(name = "BMpvAkcTrebovanjeZagDop.findByMagacin", query = "SELECT b FROM BMpvAkcTrebovanjeZagDop b WHERE b.magacin = :magacin"),
    @NamedQuery(name = "BMpvAkcTrebovanjeZagDop.findByKomentar", query = "SELECT b FROM BMpvAkcTrebovanjeZagDop b WHERE b.komentar = :komentar"),
    @NamedQuery(name = "BMpvAkcTrebovanjeZagDop.findByNazivFajla", query = "SELECT b FROM BMpvAkcTrebovanjeZagDop b WHERE b.nazivFajla = :nazivFajla"),
    @NamedQuery(name = "BMpvAkcTrebovanjeZagDop.findByTipAkcije", query = "SELECT b FROM BMpvAkcTrebovanjeZagDop b WHERE b.tipAkcije = :tipAkcije"),
    @NamedQuery(name = "BMpvAkcTrebovanjeZagDop.findByDatumOd", query = "SELECT b FROM BMpvAkcTrebovanjeZagDop b WHERE b.datumOd = :datumOd"),
    @NamedQuery(name = "BMpvAkcTrebovanjeZagDop.findByKreiranFajl", query = "SELECT b FROM BMpvAkcTrebovanjeZagDop b WHERE b.kreiranFajl = :kreiranFajl"),
    @NamedQuery(name = "BMpvAkcTrebovanjeZagDop.findByRgRoot", query = "SELECT b FROM BMpvAkcTrebovanjeZagDop b WHERE b.rgRoot = :rgRoot")})
public class BMpvAkcTrebovanjeZagDop implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bMpvAkcTrebovanjeZagDop")
    private Collection<BMpvAkcTrebovanjeStavkDop> bMpvAkcTrebovanjeStavkDopCollection;

    public BMpvAkcTrebovanjeZagDop() {
    }

    public BMpvAkcTrebovanjeZagDop(Long eksterniBroj) {
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

    public Collection<BMpvAkcTrebovanjeStavkDop> getBMpvAkcTrebovanjeStavkDopCollection() {
        return bMpvAkcTrebovanjeStavkDopCollection;
    }

    public void setBMpvAkcTrebovanjeStavkDopCollection(Collection<BMpvAkcTrebovanjeStavkDop> bMpvAkcTrebovanjeStavkDopCollection) {
        this.bMpvAkcTrebovanjeStavkDopCollection = bMpvAkcTrebovanjeStavkDopCollection;
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
        if (!(object instanceof BMpvAkcTrebovanjeZagDop)) {
            return false;
        }
        BMpvAkcTrebovanjeZagDop other = (BMpvAkcTrebovanjeZagDop) object;
        if ((this.eksterniBroj == null && other.eksterniBroj != null) || (this.eksterniBroj != null && !this.eksterniBroj.equals(other.eksterniBroj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpvAkcTrebovanjeZagDop[ eksterniBroj=" + eksterniBroj + " ]";
    }
    
}
