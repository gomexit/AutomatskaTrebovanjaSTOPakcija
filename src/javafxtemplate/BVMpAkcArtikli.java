/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
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
@Table(name = "B_V_MP_AKC_ARTIKLI")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcArtikli.findAll", query = "SELECT b FROM BVMpAkcArtikli b"),
    @NamedQuery(name = "BVMpAkcArtikli.findById", query = "SELECT b FROM BVMpAkcArtikli b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcArtikli.findBySifra", query = "SELECT b FROM BVMpAkcArtikli b WHERE b.sifra = :sifra"),
    @NamedQuery(name = "BVMpAkcArtikli.findPretraga", query = "SELECT b FROM BVMpAkcArtikli b WHERE b.sifra like :naziv  or b.naziv like :naziv or b.robnagrupa like :naziv"),
    @NamedQuery(name = "BVMpAkcArtikli.findByNaziv", query = "SELECT b FROM BVMpAkcArtikli b WHERE b.naziv = :naziv"),
    @NamedQuery(name = "BVMpAkcArtikli.findByRobnagrupa", query = "SELECT b FROM BVMpAkcArtikli b WHERE b.robnagrupa = :robnagrupa")})
public class BVMpAkcArtikli implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Id
    @Column(name = "ID")
    private long id;
    @Basic(optional = false)
    @Column(name = "SIFRA")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Basic(optional = false)
    @Column(name = "ROBNAGRUPA")
    private String robnagrupa;

    public BVMpAkcArtikli() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getRobnagrupa() {
        return robnagrupa;
    }

    public void setRobnagrupa(String robnagrupa) {
        this.robnagrupa = robnagrupa;
    }
    
}
