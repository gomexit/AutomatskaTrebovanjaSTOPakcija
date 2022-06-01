/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
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
@Table(name = "B_MP_AKC_IZVESTAJI_STAVKE")
@NamedQueries({
    @NamedQuery(name = "BMpAkcIzvestajiStavke.findAll", query = "SELECT b FROM BMpAkcIzvestajiStavke b"),
    @NamedQuery(name = "BMpAkcIzvestajiStavke.findByNazivIzvestaja", query = "SELECT b FROM BMpAkcIzvestajiStavke b WHERE b.bMpAkcIzvestajiStavkePK.nazivIzvestaja = :nazivIzvestaja"),
    @NamedQuery(name = "BMpAkcIzvestajiStavke.findByNazivStavke", query = "SELECT b FROM BMpAkcIzvestajiStavke b WHERE b.bMpAkcIzvestajiStavkePK.nazivStavke = :nazivStavke"),
    @NamedQuery(name = "BMpAkcIzvestajiStavke.findByBrojSerija", query = "SELECT b FROM BMpAkcIzvestajiStavke b WHERE b.brojSerija = :brojSerija"),
    @NamedQuery(name = "BMpAkcIzvestajiStavke.findByBrojKolona", query = "SELECT b FROM BMpAkcIzvestajiStavke b WHERE b.brojKolona = :brojKolona"),
    @NamedQuery(name = "BMpAkcIzvestajiStavke.findBySerija1", query = "SELECT b FROM BMpAkcIzvestajiStavke b WHERE b.serija1 = :serija1"),
    @NamedQuery(name = "BMpAkcIzvestajiStavke.findBySerija2", query = "SELECT b FROM BMpAkcIzvestajiStavke b WHERE b.serija2 = :serija2"),
    @NamedQuery(name = "BMpAkcIzvestajiStavke.findBySerija3", query = "SELECT b FROM BMpAkcIzvestajiStavke b WHERE b.serija3 = :serija3"),
    @NamedQuery(name = "BMpAkcIzvestajiStavke.findByKolona4", query = "SELECT b FROM BMpAkcIzvestajiStavke b WHERE b.kolona4 = :kolona4"),
    @NamedQuery(name = "BMpAkcIzvestajiStavke.findByKolona5", query = "SELECT b FROM BMpAkcIzvestajiStavke b WHERE b.kolona5 = :kolona5"),
    @NamedQuery(name = "BMpAkcIzvestajiStavke.findByGrafik", query = "SELECT b FROM BMpAkcIzvestajiStavke b WHERE b.grafik = :grafik")})
public class BMpAkcIzvestajiStavke implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpAkcIzvestajiStavkePK bMpAkcIzvestajiStavkePK;
    @Column(name = "BROJ_SERIJA")
    private Short brojSerija;
    @Column(name = "BROJ_KOLONA")
    private Short brojKolona;
    @Column(name = "SERIJA1")
    private String serija1;
    @Column(name = "SERIJA2")
    private String serija2;
    @Column(name = "SERIJA3")
    private String serija3;
    @Column(name = "KOLONA4")
    private String kolona4;
    @Column(name = "KOLONA5")
    private String kolona5;
    @Column(name = "KOLONA6")
    private String kolona6;

    public String getKolona6() {
        return kolona6;
    }

    public void setKolona6(String kolona6) {
        this.kolona6 = kolona6;
    }
    @Column(name = "GRAFIK")
    private String grafik;
    @JoinColumn(name = "NAZIV_IZVESTAJA", referencedColumnName = "NAZIV_IZVESTAJA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BMpAkcIzvestaji bMpAkcIzvestaji;

    public BMpAkcIzvestajiStavke() {
    }

    public BMpAkcIzvestajiStavke(BMpAkcIzvestajiStavkePK bMpAkcIzvestajiStavkePK) {
        this.bMpAkcIzvestajiStavkePK = bMpAkcIzvestajiStavkePK;
    }

    public BMpAkcIzvestajiStavke(String nazivIzvestaja, String nazivStavke) {
        this.bMpAkcIzvestajiStavkePK = new BMpAkcIzvestajiStavkePK(nazivIzvestaja, nazivStavke);
    }

    public BMpAkcIzvestajiStavkePK getBMpAkcIzvestajiStavkePK() {
        return bMpAkcIzvestajiStavkePK;
    }

    public void setBMpAkcIzvestajiStavkePK(BMpAkcIzvestajiStavkePK bMpAkcIzvestajiStavkePK) {
        this.bMpAkcIzvestajiStavkePK = bMpAkcIzvestajiStavkePK;
    }

    public Short getBrojSerija() {
        return brojSerija;
    }

    public void setBrojSerija(Short brojSerija) {
        this.brojSerija = brojSerija;
    }

    public Short getBrojKolona() {
        return brojKolona;
    }

    public void setBrojKolona(Short brojKolona) {
        this.brojKolona = brojKolona;
    }

    public String getSerija1() {
        return serija1;
    }

    public void setSerija1(String serija1) {
        this.serija1 = serija1;
    }

    public String getSerija2() {
        return serija2;
    }

    public void setSerija2(String serija2) {
        this.serija2 = serija2;
    }

    public String getSerija3() {
        return serija3;
    }

    public void setSerija3(String serija3) {
        this.serija3 = serija3;
    }

    public String getKolona4() {
        return kolona4;
    }

    public void setKolona4(String kolona4) {
        this.kolona4 = kolona4;
    }

    public String getKolona5() {
        return kolona5;
    }

    public void setKolona5(String kolona5) {
        this.kolona5 = kolona5;
    }

    public String getGrafik() {
        return grafik;
    }

    public void setGrafik(String grafik) {
        this.grafik = grafik;
    }

    public BMpAkcIzvestaji getBMpAkcIzvestaji() {
        return bMpAkcIzvestaji;
    }

    public void setBMpAkcIzvestaji(BMpAkcIzvestaji bMpAkcIzvestaji) {
        this.bMpAkcIzvestaji = bMpAkcIzvestaji;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpAkcIzvestajiStavkePK != null ? bMpAkcIzvestajiStavkePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcIzvestajiStavke)) {
            return false;
        }
        BMpAkcIzvestajiStavke other = (BMpAkcIzvestajiStavke) object;
        if ((this.bMpAkcIzvestajiStavkePK == null && other.bMpAkcIzvestajiStavkePK != null) || (this.bMpAkcIzvestajiStavkePK != null && !this.bMpAkcIzvestajiStavkePK.equals(other.bMpAkcIzvestajiStavkePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcIzvestajiStavke[ bMpAkcIzvestajiStavkePK=" + bMpAkcIzvestajiStavkePK + " ]";
    }
    
}
