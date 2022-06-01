/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author ivan.babic
 */
@Entity
@Table(name = "B_V_MP_AKC_PLANOGRAM_PRETRAGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BVMpAkcPlanogramPretraga.findAll", query = "SELECT b FROM BVMpAkcPlanogramPretraga b")
    , @NamedQuery(name = "BVMpAkcPlanogramPretraga.findByGrupa", query = "SELECT b FROM BVMpAkcPlanogramPretraga b WHERE b.grupa = :grupa")
         , @NamedQuery(name = "BVMpAkcPlanogramPretraga.find2parametara", query = "SELECT b FROM BVMpAkcPlanogramPretraga b WHERE b.artikalNaziv like :artikalNaziv and b.artikalSifra like :artikalSifra")
    , @NamedQuery(name = "BVMpAkcPlanogramPretraga.findByOrgjed", query = "SELECT b FROM BVMpAkcPlanogramPretraga b WHERE b.orgjed = :orgjed")
    , @NamedQuery(name = "BVMpAkcPlanogramPretraga.findByArtikalId", query = "SELECT b FROM BVMpAkcPlanogramPretraga b WHERE b.artikalId = :artikalId")
    , @NamedQuery(name = "BVMpAkcPlanogramPretraga.findByArtikalSifra", query = "SELECT b FROM BVMpAkcPlanogramPretraga b WHERE b.artikalSifra = :artikalSifra")
    , @NamedQuery(name = "BVMpAkcPlanogramPretraga.findByArtikalNaziv", query = "SELECT b FROM BVMpAkcPlanogramPretraga b WHERE b.artikalNaziv = :artikalNaziv")
    , @NamedQuery(name = "BVMpAkcPlanogramPretraga.findByKolicina", query = "SELECT b FROM BVMpAkcPlanogramPretraga b WHERE b.kolicina = :kolicina")
    , @NamedQuery(name = "BVMpAkcPlanogramPretraga.findByBroj", query = "SELECT b FROM BVMpAkcPlanogramPretraga b WHERE b.broj = :broj")})
public class BVMpAkcPlanogramPretraga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "GRUPA")
    private String grupa;
    @Column(name = "ORGJED")
    private String orgjed;
    @Basic(optional = false)
    @Column(name = "ARTIKAL_ID")
    private long artikalId;
    @Basic(optional = false)
    @Column(name = "ARTIKAL_SIFRA")
    private String artikalSifra;
    @Basic(optional = false)
    @Column(name = "ARTIKAL_NAZIV")
    private String artikalNaziv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "KOLICINA")
    private BigDecimal kolicina;
     @Id
    @Column(name = "BROJ")
    private BigInteger broj;

    public BVMpAkcPlanogramPretraga() {
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    public long getArtikalId() {
        return artikalId;
    }

    public void setArtikalId(long artikalId) {
        this.artikalId = artikalId;
    }

    public String getArtikalSifra() {
        return artikalSifra;
    }

    public void setArtikalSifra(String artikalSifra) {
        this.artikalSifra = artikalSifra;
    }

    public String getArtikalNaziv() {
        return artikalNaziv;
    }

    public void setArtikalNaziv(String artikalNaziv) {
        this.artikalNaziv = artikalNaziv;
    }

    public BigDecimal getKolicina() {
        return kolicina;
    }

    public void setKolicina(BigDecimal kolicina) {
        this.kolicina = kolicina;
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }
    
}
