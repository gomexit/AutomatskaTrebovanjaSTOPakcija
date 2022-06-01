/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "B_V_MP_AKC_ZAMENSKI2")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcZamenski2.findAll", query = "SELECT b FROM BVMpAkcZamenski2 b"),
    @NamedQuery(name = "BVMpAkcZamenski2.findByArtikal", query = "SELECT b FROM BVMpAkcZamenski2 b WHERE b.artikal = :artikal"),
    @NamedQuery(name = "BVMpAkcZamenski2.findByPretraga", query = "SELECT b FROM BVMpAkcZamenski2 b WHERE b.artikalNaziv like :naziv or b.sifraArtikla like :naziv or b.zamenskiNaziv like :naziv or b.zamenskiSifra like :naziv"),
    @NamedQuery(name = "BVMpAkcZamenski2.findBySifraArtikla", query = "SELECT b FROM BVMpAkcZamenski2 b WHERE b.sifraArtikla = :sifraArtikla"),
    @NamedQuery(name = "BVMpAkcZamenski2.findByArtikalNaziv", query = "SELECT b FROM BVMpAkcZamenski2 b WHERE b.artikalNaziv = :artikalNaziv"),
    @NamedQuery(name = "BVMpAkcZamenski2.findByZamenskiIdId", query = "SELECT b FROM BVMpAkcZamenski2 b WHERE b.zamenskiIdId = :zamenskiIdId"),
    @NamedQuery(name = "BVMpAkcZamenski2.findByZamenskiSifra", query = "SELECT b FROM BVMpAkcZamenski2 b WHERE b.zamenskiSifra = :zamenskiSifra"),
    @NamedQuery(name = "BVMpAkcZamenski2.findByZamenskiNaziv", query = "SELECT b FROM BVMpAkcZamenski2 b WHERE b.zamenskiNaziv = :zamenskiNaziv"),
    @NamedQuery(name = "BVMpAkcZamenski2.findByOdnos", query = "SELECT b FROM BVMpAkcZamenski2 b WHERE b.odnos = :odnos")})
public class BVMpAkcZamenski2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Id
    @Column(name = "ARTIKAL")
    private long artikal;
    @Basic(optional = false)
    @Column(name = "SIFRA_ARTIKLA")
    private String sifraArtikla;
    @Basic(optional = false)
    @Column(name = "ARTIKAL_NAZIV")
    private String artikalNaziv;
    @Column(name = "ZAMENSKI_ID_ID")
    private Long zamenskiIdId;
    @Basic(optional = false)
    @Column(name = "ZAMENSKI_SIFRA")
    private String zamenskiSifra;
    @Basic(optional = false)
    @Column(name = "ZAMENSKI_NAZIV")
    private String zamenskiNaziv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ODNOS")
    private BigDecimal odnos;

    public BVMpAkcZamenski2() {
    }

    public long getArtikal() {
        return artikal;
    }

    public void setArtikal(long artikal) {
        this.artikal = artikal;
    }

    public String getSifraArtikla() {
        return sifraArtikla;
    }

    public void setSifraArtikla(String sifraArtikla) {
        this.sifraArtikla = sifraArtikla;
    }

    public String getArtikalNaziv() {
        return artikalNaziv;
    }

    public void setArtikalNaziv(String artikalNaziv) {
        this.artikalNaziv = artikalNaziv;
    }

    public Long getZamenskiIdId() {
        return zamenskiIdId;
    }

    public void setZamenskiIdId(Long zamenskiIdId) {
        this.zamenskiIdId = zamenskiIdId;
    }

    public String getZamenskiSifra() {
        return zamenskiSifra;
    }

    public void setZamenskiSifra(String zamenskiSifra) {
        this.zamenskiSifra = zamenskiSifra;
    }

    public String getZamenskiNaziv() {
        return zamenskiNaziv;
    }

    public void setZamenskiNaziv(String zamenskiNaziv) {
        this.zamenskiNaziv = zamenskiNaziv;
    }

    public BigDecimal getOdnos() {
        return odnos;
    }

    public void setOdnos(BigDecimal odnos) {
        this.odnos = odnos;
    }
    
}
