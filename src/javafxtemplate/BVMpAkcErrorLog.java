/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_V_MP_AKC_ERROR_LOG")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcErrorLog.findAll", query = "SELECT b FROM BVMpAkcErrorLog b"),
    @NamedQuery(name = "BVMpAkcErrorLog.findByBroj", query = "SELECT b FROM BVMpAkcErrorLog b WHERE b.broj = :broj"),
    @NamedQuery(name = "BVMpAkcErrorLog.findByKolona1", query = "SELECT b FROM BVMpAkcErrorLog b WHERE b.kolona1 = :kolona1"),
    @NamedQuery(name = "BVMpAkcErrorLog.findByKolona2", query = "SELECT b FROM BVMpAkcErrorLog b WHERE b.kolona2 = :kolona2"),
    @NamedQuery(name = "BVMpAkcErrorLog.findByKolona3", query = "SELECT b FROM BVMpAkcErrorLog b WHERE b.kolona3 = :kolona3"),
    @NamedQuery(name = "BVMpAkcErrorLog.findById", query = "SELECT b FROM BVMpAkcErrorLog b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcErrorLog.findByIdAkcije", query = "SELECT b FROM BVMpAkcErrorLog b WHERE b.idAkcije = :idAkcije"),
    @NamedQuery(name = "BVMpAkcErrorLog.findByIdKampanje", query = "SELECT b FROM BVMpAkcErrorLog b WHERE b.idKampanje = :idKampanje"),
    @NamedQuery(name = "BVMpAkcErrorLog.findByIdArtikla", query = "SELECT b FROM BVMpAkcErrorLog b WHERE b.idArtikla = :idArtikla"),
    @NamedQuery(name = "BVMpAkcErrorLog.findBySifra", query = "SELECT b FROM BVMpAkcErrorLog b WHERE b.sifra = :sifra"),
    @NamedQuery(name = "BVMpAkcErrorLog.findByNaziv", query = "SELECT b FROM BVMpAkcErrorLog b WHERE b.naziv = :naziv"),
    @NamedQuery(name = "BVMpAkcErrorLog.findByDatum", query = "SELECT b FROM BVMpAkcErrorLog b WHERE b.datum = :datum")})
public class BVMpAkcErrorLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;
    @Column(name = "KOLONA1")
    private String kolona1;
    @Column(name = "KOLONA2")
    private String kolona2;
    @Column(name = "KOLONA3")
    private String kolona3;
    @Basic(optional = false)
    @Column(name = "ID")
    private long id;
    @Column(name = "ID_AKCIJE")
    private Long idAkcije;
    @Column(name = "ID_KAMPANJE")
    private Long idKampanje;
    @Column(name = "ID_ARTIKLA")
    private Long idArtikla;
    @Basic(optional = false)
    @Column(name = "SIFRA")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;

    public BVMpAkcErrorLog() {
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }

    public String getKolona1() {
        return kolona1;
    }

    public void setKolona1(String kolona1) {
        this.kolona1 = kolona1;
    }

    public String getKolona2() {
        return kolona2;
    }

    public void setKolona2(String kolona2) {
        this.kolona2 = kolona2;
    }

    public String getKolona3() {
        return kolona3;
    }

    public void setKolona3(String kolona3) {
        this.kolona3 = kolona3;
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

    public Long getIdKampanje() {
        return idKampanje;
    }

    public void setIdKampanje(Long idKampanje) {
        this.idKampanje = idKampanje;
    }

    public Long getIdArtikla() {
        return idArtikla;
    }

    public void setIdArtikla(Long idArtikla) {
        this.idArtikla = idArtikla;
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

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
    
}
