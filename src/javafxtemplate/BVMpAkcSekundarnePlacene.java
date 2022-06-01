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
@Table(name = "B_V_MP_AKC_SEKUNDARNE_PLACENE")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcSekundarnePlacene.findAll", query = "SELECT b FROM BVMpAkcSekundarnePlacene b"),
    @NamedQuery(name = "BVMpAkcSekundarnePlacene.findById", query = "SELECT b FROM BVMpAkcSekundarnePlacene b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcSekundarnePlacene.findByArtikal", query = "SELECT b FROM BVMpAkcSekundarnePlacene b WHERE b.artikal = :artikal"),
    @NamedQuery(name = "BVMpAkcSekundarnePlacene.findBySifra", query = "SELECT b FROM BVMpAkcSekundarnePlacene b WHERE b.sifra = :sifra"),
    @NamedQuery(name = "BVMpAkcSekundarnePlacene.findByNaziv", query = "SELECT b FROM BVMpAkcSekundarnePlacene b WHERE b.naziv = :naziv"),
    @NamedQuery(name = "BVMpAkcSekundarnePlacene.findByBroj", query = "SELECT b FROM BVMpAkcSekundarnePlacene b WHERE b.broj = :broj")})
public class BVMpAkcSekundarnePlacene implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "ARTIKAL")
    private long artikal;
    @Basic(optional = false)
    @Column(name = "SIFRA")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;

    public BVMpAkcSekundarnePlacene() {
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

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }
    
}
