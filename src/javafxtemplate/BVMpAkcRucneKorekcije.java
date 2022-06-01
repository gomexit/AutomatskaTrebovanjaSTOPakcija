/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "B_V_MP_AKC_RUCNE_KOREKCIJE")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcRucneKorekcije.findAll", query = "SELECT b FROM BVMpAkcRucneKorekcije b"),
    @NamedQuery(name = "BVMpAkcRucneKorekcije.findById", query = "SELECT b FROM BVMpAkcRucneKorekcije b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcRucneKorekcije.findByArtikal", query = "SELECT b FROM BVMpAkcRucneKorekcije b WHERE b.artikal = :artikal"),
    @NamedQuery(name = "BVMpAkcRucneKorekcije.findByNazivArtikla", query = "SELECT b FROM BVMpAkcRucneKorekcije b WHERE b.nazivArtikla = :nazivArtikla"),
    @NamedQuery(name = "BVMpAkcRucneKorekcije.findByOrgjed", query = "SELECT b FROM BVMpAkcRucneKorekcije b WHERE b.orgjed = :orgjed"),
    @NamedQuery(name = "BVMpAkcRucneKorekcije.findByNazivOj", query = "SELECT b FROM BVMpAkcRucneKorekcije b WHERE b.nazivOj = :nazivOj"),
    @NamedQuery(name = "BVMpAkcRucneKorekcije.findByTipKorekcije", query = "SELECT b FROM BVMpAkcRucneKorekcije b WHERE b.tipKorekcije = :tipKorekcije"),
    @NamedQuery(name = "BVMpAkcRucneKorekcije.findByKoeficijent", query = "SELECT b FROM BVMpAkcRucneKorekcije b WHERE b.koeficijent = :koeficijent"),
    @NamedQuery(name = "BVMpAkcRucneKorekcije.findByOpis", query = "SELECT b FROM BVMpAkcRucneKorekcije b WHERE b.opis = :opis")})
public class BVMpAkcRucneKorekcije implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ARTIKAL")
    private Long artikal;
    @Column(name = "NAZIV_ARTIKLA")
    private String nazivArtikla;
    @Column(name = "ORGJED")
    private String orgjed;
    @Column(name = "NAZIV_OJ")
    private String nazivOj;
    @Column(name = "TIP_KOREKCIJE")
    private String tipKorekcije;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KOEFICIJENT")
    private BigDecimal koeficijent;
    @Column(name = "OPIS")
    private String opis;
    @Id
    @Column(name = "BROJ")
    private Long broj;

    public Long getBroj() {
        return broj;
    }

    public void setBroj(Long broj) {
        this.broj = broj;
    }

    public BVMpAkcRucneKorekcije() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getArtikal() {
        return artikal;
    }

    public void setArtikal(Long artikal) {
        this.artikal = artikal;
    }

    public String getNazivArtikla() {
        return nazivArtikla;
    }

    public void setNazivArtikla(String nazivArtikla) {
        this.nazivArtikla = nazivArtikla;
    }

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    public String getNazivOj() {
        return nazivOj;
    }

    public void setNazivOj(String nazivOj) {
        this.nazivOj = nazivOj;
    }

    public String getTipKorekcije() {
        return tipKorekcije;
    }

    public void setTipKorekcije(String tipKorekcije) {
        this.tipKorekcije = tipKorekcije;
    }

    public BigDecimal getKoeficijent() {
        return koeficijent;
    }

    public void setKoeficijent(BigDecimal koeficijent) {
        this.koeficijent = koeficijent;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    
}
