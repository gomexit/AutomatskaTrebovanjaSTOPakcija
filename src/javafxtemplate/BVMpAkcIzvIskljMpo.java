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
@Table(name = "B_V_MP_AKC_IZV_ISKLJ_MPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BVMpAkcIzvIskljMpo.findAll", query = "SELECT b FROM BVMpAkcIzvIskljMpo b"),
    @NamedQuery(name = "BVMpAkcIzvIskljMpo.findById", query = "SELECT b FROM BVMpAkcIzvIskljMpo b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcIzvIskljMpo.findBySifra", query = "SELECT b FROM BVMpAkcIzvIskljMpo b WHERE b.sifra = :sifra"),
    @NamedQuery(name = "BVMpAkcIzvIskljMpo.findByNaziv", query = "SELECT b FROM BVMpAkcIzvIskljMpo b WHERE b.naziv = :naziv"),
    @NamedQuery(name = "BVMpAkcIzvIskljMpo.findByBroj", query = "SELECT b FROM BVMpAkcIzvIskljMpo b WHERE b.broj = :broj")})
public class BVMpAkcIzvIskljMpo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "SIFRA")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;

    public BVMpAkcIzvIskljMpo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }
    
}
