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
@Table(name = "B_V_MP_AKC_NAZIV_VRED_X9")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcNazivVredX9.findAll", query = "SELECT b FROM BVMpAkcNazivVredX9 b"),
    @NamedQuery(name = "BVMpAkcNazivVredX9.findByNaziv", query = "SELECT b FROM BVMpAkcNazivVredX9 b WHERE b.naziv = :naziv"),
    @NamedQuery(name = "BVMpAkcNazivVredX9.findByVred1", query = "SELECT b FROM BVMpAkcNazivVredX9 b WHERE b.vred1 = :vred1"),
    @NamedQuery(name = "BVMpAkcNazivVredX9.findByVred2", query = "SELECT b FROM BVMpAkcNazivVredX9 b WHERE b.vred2 = :vred2"),
    @NamedQuery(name = "BVMpAkcNazivVredX9.findByVred3", query = "SELECT b FROM BVMpAkcNazivVredX9 b WHERE b.vred3 = :vred3"),
    @NamedQuery(name = "BVMpAkcNazivVredX9.findByVred4", query = "SELECT b FROM BVMpAkcNazivVredX9 b WHERE b.vred4 = :vred4"),
    @NamedQuery(name = "BVMpAkcNazivVredX9.findByVred5", query = "SELECT b FROM BVMpAkcNazivVredX9 b WHERE b.vred5 = :vred5"),
    @NamedQuery(name = "BVMpAkcNazivVredX9.findByVred6", query = "SELECT b FROM BVMpAkcNazivVredX9 b WHERE b.vred6 = :vred6"),
    @NamedQuery(name = "BVMpAkcNazivVredX9.findByVred7", query = "SELECT b FROM BVMpAkcNazivVredX9 b WHERE b.vred7 = :vred7"),
    @NamedQuery(name = "BVMpAkcNazivVredX9.findByVred8", query = "SELECT b FROM BVMpAkcNazivVredX9 b WHERE b.vred8 = :vred8"),
    @NamedQuery(name = "BVMpAkcNazivVredX9.findByVred9", query = "SELECT b FROM BVMpAkcNazivVredX9 b WHERE b.vred9 = :vred9")})
public class BVMpAkcNazivVredX9 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "NAZIV")
    private String naziv;
    @Column(name = "VRED1")
    private BigDecimal vred1;
    @Column(name = "VRED2")
    private BigDecimal vred2;
    @Column(name = "VRED3")
    private BigDecimal vred3;
    @Column(name = "VRED4")
    private BigDecimal vred4;
    @Column(name = "VRED5")
    private BigDecimal vred5;
    @Column(name = "VRED6")
    private BigDecimal vred6;
    @Column(name = "VRED7")
    private BigDecimal vred7;
    @Column(name = "VRED8")
    private BigDecimal vred8;
    @Id
    @Column(name = "VRED9")
    private BigDecimal vred9;

    public BVMpAkcNazivVredX9() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getVred1() {
        return vred1;
    }

    public void setVred1(BigDecimal vred1) {
        this.vred1 = vred1;
    }

    public BigDecimal getVred2() {
        return vred2;
    }

    public void setVred2(BigDecimal vred2) {
        this.vred2 = vred2;
    }

    public BigDecimal getVred3() {
        return vred3;
    }

    public void setVred3(BigDecimal vred3) {
        this.vred3 = vred3;
    }

    public BigDecimal getVred4() {
        return vred4;
    }

    public void setVred4(BigDecimal vred4) {
        this.vred4 = vred4;
    }

    public BigDecimal getVred5() {
        return vred5;
    }

    public void setVred5(BigDecimal vred5) {
        this.vred5 = vred5;
    }

    public BigDecimal getVred6() {
        return vred6;
    }

    public void setVred6(BigDecimal vred6) {
        this.vred6 = vred6;
    }

    public BigDecimal getVred7() {
        return vred7;
    }

    public void setVred7(BigDecimal vred7) {
        this.vred7 = vred7;
    }

    public BigDecimal getVred8() {
        return vred8;
    }

    public void setVred8(BigDecimal vred8) {
        this.vred8 = vred8;
    }

    public BigDecimal getVred9() {
        return vred9;
    }

    public void setVred9(BigDecimal vred9) {
        this.vred9 = vred9;
    }
    
}
