/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_V_MP_AKC_IZVESTAJI_STAVKE")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcIzvestajiStavke.findAll", query = "SELECT b FROM BVMpAkcIzvestajiStavke b"),
    @NamedQuery(name = "BVMpAkcIzvestajiStavke.findByNazivIzvestaja", query = "SELECT b FROM BVMpAkcIzvestajiStavke b WHERE b.nazivIzvestaja = :nazivIzvestaja"),
     @NamedQuery(name = "BVMpAkcIzvestajiStavke.nadjiStavku", query = "SELECT b FROM BVMpAkcIzvestajiStavke b WHERE b.nazivIzvestaja = :nazivIzvestaja and b.nazivStavke = :nazivStavke"),
    @NamedQuery(name = "BVMpAkcIzvestajiStavke.popuniStavke", query = "SELECT b.nazivStavke FROM BVMpAkcIzvestajiStavke b WHERE b.nazivIzvestaja = :nazivIzvestaja order by b.nazivStavke"),
    @NamedQuery(name = "BVMpAkcIzvestajiStavke.findByNazivStavke", query = "SELECT b FROM BVMpAkcIzvestajiStavke b WHERE b.nazivStavke = :nazivStavke"),
    @NamedQuery(name = "BVMpAkcIzvestajiStavke.findByBrojSerija", query = "SELECT b FROM BVMpAkcIzvestajiStavke b WHERE b.brojSerija = :brojSerija"),
    @NamedQuery(name = "BVMpAkcIzvestajiStavke.findByBrojKolona", query = "SELECT b FROM BVMpAkcIzvestajiStavke b WHERE b.brojKolona = :brojKolona"),
    @NamedQuery(name = "BVMpAkcIzvestajiStavke.findBySerija1", query = "SELECT b FROM BVMpAkcIzvestajiStavke b WHERE b.serija1 = :serija1"),
    @NamedQuery(name = "BVMpAkcIzvestajiStavke.findBySerija2", query = "SELECT b FROM BVMpAkcIzvestajiStavke b WHERE b.serija2 = :serija2"),
    @NamedQuery(name = "BVMpAkcIzvestajiStavke.findBySerija3", query = "SELECT b FROM BVMpAkcIzvestajiStavke b WHERE b.serija3 = :serija3"),
    @NamedQuery(name = "BVMpAkcIzvestajiStavke.findByKolona4", query = "SELECT b FROM BVMpAkcIzvestajiStavke b WHERE b.kolona4 = :kolona4"),
    @NamedQuery(name = "BVMpAkcIzvestajiStavke.findByKolona5", query = "SELECT b FROM BVMpAkcIzvestajiStavke b WHERE b.kolona5 = :kolona5"),
    @NamedQuery(name = "BVMpAkcIzvestajiStavke.findByGrafik", query = "SELECT b FROM BVMpAkcIzvestajiStavke b WHERE b.grafik = :grafik"),
    @NamedQuery(name = "BVMpAkcIzvestajiStavke.findByBroj", query = "SELECT b FROM BVMpAkcIzvestajiStavke b WHERE b.broj = :broj")})
public class BVMpAkcIzvestajiStavke implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "NAZIV_IZVESTAJA")
    private String nazivIzvestaja;
    @Basic(optional = false)
    @Column(name = "NAZIV_STAVKE")
    private String nazivStavke;
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
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;

    public BVMpAkcIzvestajiStavke() {
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

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }
    
}
