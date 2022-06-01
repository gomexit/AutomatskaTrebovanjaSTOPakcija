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
@Table(name = "B_V_MP_AKC_NEDOSTAJUCI_ARTIKLI")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcNedostajuciArtikli.findAll", query = "SELECT b FROM BVMpAkcNedostajuciArtikli b"),
    @NamedQuery(name = "BVMpAkcNedostajuciArtikli.findByBroj", query = "SELECT b FROM BVMpAkcNedostajuciArtikli b WHERE b.broj = :broj"),
    @NamedQuery(name = "BVMpAkcNedostajuciArtikli.findById", query = "SELECT b FROM BVMpAkcNedostajuciArtikli b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcNedostajuciArtikli.findByIdAkcije", query = "SELECT b FROM BVMpAkcNedostajuciArtikli b WHERE b.idAkcije = :idAkcije"),
    @NamedQuery(name = "BVMpAkcNedostajuciArtikli.findByIdKampanje", query = "SELECT b FROM BVMpAkcNedostajuciArtikli b WHERE b.idKampanje = :idKampanje"),
    @NamedQuery(name = "BVMpAkcNedostajuciArtikli.findByArtikal", query = "SELECT b FROM BVMpAkcNedostajuciArtikli b WHERE b.artikal = :artikal"),
    @NamedQuery(name = "BVMpAkcNedostajuciArtikli.findBySifra", query = "SELECT b FROM BVMpAkcNedostajuciArtikli b WHERE b.sifra = :sifra"),
    @NamedQuery(name = "BVMpAkcNedostajuciArtikli.findByNaziv", query = "SELECT b FROM BVMpAkcNedostajuciArtikli b WHERE b.naziv = :naziv"),
    @NamedQuery(name = "BVMpAkcNedostajuciArtikli.findByOrgjed", query = "SELECT b FROM BVMpAkcNedostajuciArtikli b WHERE b.orgjed = :orgjed")})
public class BVMpAkcNedostajuciArtikli implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;
    @Basic(optional = false)
    @Column(name = "ID")
    private long id;
    @Column(name = "ID_AKCIJE")
    private Long idAkcije;
    @Column(name = "ID_KAMPANJE")
    private String idKampanje;
    @Column(name = "ARTIKAL")
    private Long artikal;
    @Basic(optional = false)
    @Column(name = "SIFRA")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Column(name = "ORGJED")
    private String orgjed;

    public BVMpAkcNedostajuciArtikli() {
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getIdAkcije() {
        return idAkcije;
    }

    public void setIdAkcije(Long idAkcije) {
        this.idAkcije = idAkcije;
    }

    public String getIdKampanje() {
        return idKampanje;
    }

    public void setIdKampanje(String idKampanje) {
        this.idKampanje = idKampanje;
    }

    public Long getArtikal() {
        return artikal;
    }

    public void setArtikal(Long artikal) {
        this.artikal = artikal;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }
    
}
