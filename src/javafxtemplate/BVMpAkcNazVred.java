/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "B_V_MP_AKC_NAZ_VRED")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcNazVred.findAll", query = "SELECT b FROM BVMpAkcNazVred b"),
    @NamedQuery(name = "BVMpAkcNazVred.findByBroj", query = "SELECT b FROM BVMpAkcNazVred b WHERE b.broj = :broj"),
    @NamedQuery(name = "BVMpAkcNazVred.findByNaziv", query = "SELECT b FROM BVMpAkcNazVred b WHERE b.naziv = :naziv"),
    @NamedQuery(name = "BVMpAkcNazVred.findByVrednost", query = "SELECT b FROM BVMpAkcNazVred b WHERE b.vrednost = :vrednost")})
public class BVMpAkcNazVred implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;
    @Column(name = "NAZIV")
    private String naziv;
    @Column(name = "VREDNOST")
    private BigDecimal vrednost;

    public BVMpAkcNazVred() {
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getVrednost() {
        return vrednost;
    }

    public void setVrednost(BigDecimal vrednost) {
        this.vrednost = vrednost;
    }
    
}
