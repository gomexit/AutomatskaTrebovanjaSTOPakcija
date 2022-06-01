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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author laki
 */
@Entity
@Table(name = "B_V_ARTIKLI_SA_RG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BVArtikli.findAll", query = "SELECT b FROM BVArtikli b"),
    @NamedQuery(name = "BVArtikli.findById", query = "SELECT b FROM BVArtikli b WHERE b.id = :id"),
    
    @NamedQuery(name = "BVArtikli.findBySve", query = "SELECT b FROM BVArtikli b WHERE b.naziv like :naziv  or b.sifra like :sifra "),
    
    @NamedQuery(name = "BVArtikli.findByNaziv", query = "SELECT b FROM BVArtikli b WHERE b.naziv = :naziv"),
    @NamedQuery(name = ".dByrg", query = "SELECT b FROM BVArtikli b WHERE b.robnagrupa = :rg"),
    @NamedQuery(name = "BVArtikli.findBySifra", query = "SELECT b FROM BVArtikli b WHERE b.sifra = :sifra")})
public class BVArtikli implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID")
    @Id
    private long id;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Basic(optional = false)
    @Column(name = "SIFRA")
    private String sifra;
    
     @Basic(optional = false)
    @Column(name = "ROBNAGRUPA")
    private String robnagrupa;

    public String getRobnagrupa() {
        return robnagrupa;
    }

    public void setRobnagrupa(String robnagrupa) {
        this.robnagrupa = robnagrupa;
    }

    public BVArtikli() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }
    
}
