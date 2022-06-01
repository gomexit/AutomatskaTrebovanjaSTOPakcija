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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author laki
 */
@Entity
@Table(name = "B_V_MP_AKC_ARIOJ_ISKLJIZ_AKC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BVMpAkcAriojIskljizAkc.findAll", query = "SELECT b FROM BVMpAkcAriojIskljizAkc b"),
    @NamedQuery(name = "BVMpAkcAriojIskljizAkc.findById", query = "SELECT b FROM BVMpAkcAriojIskljizAkc b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcAriojIskljizAkc.findByArtikal", query = "SELECT b FROM BVMpAkcAriojIskljizAkc b WHERE b.artikal = :artikal"),
    @NamedQuery(name = "BVMpAkcAriojIskljizAkc.findByNazivArtikla", query = "SELECT b FROM BVMpAkcAriojIskljizAkc b WHERE b.nazivArtikla = :nazivArtikla"),
    @NamedQuery(name = "BVMpAkcAriojIskljizAkc.findByOrgjed", query = "SELECT b FROM BVMpAkcAriojIskljizAkc b WHERE b.orgjed = :orgjed"),
    @NamedQuery(name = "BVMpAkcAriojIskljizAkc.findByNazivOrgjed", query = "SELECT b FROM BVMpAkcAriojIskljizAkc b WHERE b.nazivOrgjed = :nazivOrgjed"),
    @NamedQuery(name = "BVMpAkcAriojIskljizAkc.findByBroj", query = "SELECT b FROM BVMpAkcAriojIskljizAkc b WHERE b.broj = :broj")})
public class BVMpAkcAriojIskljizAkc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "ARTIKAL")
    private long artikal;
    @Basic(optional = false)
    @Column(name = "NAZIV_ARTIKLA")
    private String nazivArtikla;
    @Basic(optional = false)
    @Column(name = "ORGJED")
    private String orgjed;
    @Basic(optional = false)
    @Column(name = "NAZIV_ORGJED")
    private String nazivOrgjed;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;

    public BVMpAkcAriojIskljizAkc() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getArtikal() {
        return artikal;
    }

    public void setArtikal(long artikal) {
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

    public String getNazivOrgjed() {
        return nazivOrgjed;
    }

    public void setNazivOrgjed(String nazivOrgjed) {
        this.nazivOrgjed = nazivOrgjed;
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }
    
}
