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
@Table(name = "B_V_MP_AKC_MPO_BEZ_ISLJUC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BVMpAkcMpoBezIsljuc.findAll", query = "SELECT b FROM BVMpAkcMpoBezIsljuc b"),
    @NamedQuery(name = "BVMpAkcMpoBezIsljuc.findByOrgjed", query = "SELECT b FROM BVMpAkcMpoBezIsljuc b WHERE b.orgjed = :orgjed"),
    @NamedQuery(name = "BVMpAkcMpoBezIsljuc.findBySifra", query = "SELECT b FROM BVMpAkcMpoBezIsljuc b WHERE b.sifra = :sifra"),
    @NamedQuery(name = "BVMpAkcMpoBezIsljuc.findByNaziv", query = "SELECT b FROM BVMpAkcMpoBezIsljuc b WHERE b.naziv = :naziv"),
    @NamedQuery(name = "BVMpAkcMpoBezIsljuc.findByIdAkcije", query = "SELECT b FROM BVMpAkcMpoBezIsljuc b WHERE b.idAkcije = :idAkcije"),
    @NamedQuery(name = "BVMpAkcMpoBezIsljuc.findByBroj", query = "SELECT b FROM BVMpAkcMpoBezIsljuc b WHERE b.broj = :broj")})
public class BVMpAkcMpoBezIsljuc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ORGJED")
    private String orgjed;
    @Basic(optional = false)
    @Column(name = "SIFRA")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Basic(optional = false)
    @Column(name = "ID_AKCIJE")
    private long idAkcije;
   @Id
    @Column(name = "BROJ")
    private BigInteger broj;

    public BVMpAkcMpoBezIsljuc() {
    }

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
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

    public long getIdAkcije() {
        return idAkcije;
    }

    public void setIdAkcije(long idAkcije) {
        this.idAkcije = idAkcije;
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }
    
}
