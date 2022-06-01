/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "B_V_MP_AKC_KANDIDATI_ZA_AKC")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcKandidatiZaAkc.findAll", query = "SELECT b FROM BVMpAkcKandidatiZaAkc b"),
    @NamedQuery(name = "BVMpAkcKandidatiZaAkc.findByIdAkcije", query = "SELECT b FROM BVMpAkcKandidatiZaAkc b WHERE b.idAkcije = :idAkcije"),
    @NamedQuery(name = "BVMpAkcKandidatiZaAkc.findByKampanja", query = "SELECT b FROM BVMpAkcKandidatiZaAkc b WHERE b.kampanja = :kampanja"),
    @NamedQuery(name = "BVMpAkcKandidatiZaAkc.findByNazivAkcije", query = "SELECT b FROM BVMpAkcKandidatiZaAkc b WHERE b.nazivAkcije = :nazivAkcije"),
    @NamedQuery(name = "BVMpAkcKandidatiZaAkc.findByVreme", query = "SELECT b FROM BVMpAkcKandidatiZaAkc b WHERE b.vreme = :vreme")})
public class BVMpAkcKandidatiZaAkc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_AKCIJE")
    private Long idAkcije;
    @Column(name = "KAMPANJA")
    private String kampanja;
    @Column(name = "NAZIV_AKCIJE")
    private String nazivAkcije;
    @Column(name = "VREME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vreme;

    public BVMpAkcKandidatiZaAkc() {
    }

    public Long getIdAkcije() {
        return idAkcije;
    }

    public void setIdAkcije(Long idAkcije) {
        this.idAkcije = idAkcije;
    }

    public String getKampanja() {
        return kampanja;
    }

    public void setKampanja(String kampanja) {
        this.kampanja = kampanja;
    }

    public String getNazivAkcije() {
        return nazivAkcije;
    }

    public void setNazivAkcije(String nazivAkcije) {
        this.nazivAkcije = nazivAkcije;
    }

    public Date getVreme() {
        return vreme;
    }

    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }
    
}
