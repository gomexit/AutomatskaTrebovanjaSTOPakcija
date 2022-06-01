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
@Table(name = "B_V_MP_AKC_RG_SIFARNIK")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcRgSifarnik.findAll", query = "SELECT b FROM BVMpAkcRgSifarnik b"),
    @NamedQuery(name = "BVMpAkcRgSifarnik.findBySifra", query = "SELECT b FROM BVMpAkcRgSifarnik b WHERE b.sifra = :sifra"),
    @NamedQuery(name = "BVMpAkcRgSifarnik.findByNaziv", query = "SELECT b FROM BVMpAkcRgSifarnik b WHERE b.naziv = :naziv"),
    @NamedQuery(name = "BVMpAkcRgSifarnik.findByNaziv2", query = "SELECT b FROM BVMpAkcRgSifarnik b WHERE b.naziv like :naziv or b.nazivNadgrupe1 like :naziv order by b.naziv"),
    @NamedQuery(name = "BVMpAkcRgSifarnik.findByNazivNadgrupe1", query = "SELECT b FROM BVMpAkcRgSifarnik b WHERE b.nazivNadgrupe1 = :nazivNadgrupe1")})
public class BVMpAkcRgSifarnik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Id
    @Column(name = "SIFRA")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Basic(optional = false)
    @Column(name = "NAZIV_NADGRUPE1")
    private String nazivNadgrupe1;

    public BVMpAkcRgSifarnik() {
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

    public String getNazivNadgrupe1() {
        return nazivNadgrupe1;
    }

    public void setNazivNadgrupe1(String nazivNadgrupe1) {
        this.nazivNadgrupe1 = nazivNadgrupe1;
    }
    
}
