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
@Table(name = "B_V_MP_AKCIJE_STAVKE_ASW")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcijeStavkeAsw.findAll", query = "SELECT b FROM BVMpAkcijeStavkeAsw b"),
    @NamedQuery(name = "BVMpAkcijeStavkeAsw.findByBroj", query = "SELECT b FROM BVMpAkcijeStavkeAsw b WHERE b.broj = :broj"),
    @NamedQuery(name = "BVMpAkcijeStavkeAsw.findById", query = "SELECT b FROM BVMpAkcijeStavkeAsw b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcijeStavkeAsw.findByIdAkcije", query = "SELECT b FROM BVMpAkcijeStavkeAsw b WHERE b.idAkcije = :idAkcije"),
    @NamedQuery(name = "BVMpAkcijeStavkeAsw.findByIdKampanje", query = "SELECT b FROM BVMpAkcijeStavkeAsw b WHERE b.idKampanje = :idKampanje"),
    @NamedQuery(name = "BVMpAkcijeStavkeAsw.findByKomentar", query = "SELECT b FROM BVMpAkcijeStavkeAsw b WHERE b.komentar = :komentar")})
public class BVMpAkcijeStavkeAsw implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;
    @Basic(optional = false)
    @Column(name = "ID")
    private long id;
    @Basic(optional = false)
    @Column(name = "ID_AKCIJE")
    private long idAkcije;
    @Basic(optional = false)
    @Column(name = "ID_KAMPANJE")
    private String idKampanje;
    @Column(name = "KOMENTAR")
    private String komentar;

    public BVMpAkcijeStavkeAsw() {
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAkcije() {
        return idAkcije;
    }

    public void setIdAkcije(long idAkcije) {
        this.idAkcije = idAkcije;
    }

    public String getIdKampanje() {
        return idKampanje;
    }

    public void setIdKampanje(String idKampanje) {
        this.idKampanje = idKampanje;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
    
}
