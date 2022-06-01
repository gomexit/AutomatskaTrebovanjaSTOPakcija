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
@Table(name = "B_V_MP_AKC_NAZIV_VRED_X15")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcNazivVredX15.findAll", query = "SELECT b FROM BVMpAkcNazivVredX15 b"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByNaziv", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.naziv = :naziv"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByVred1", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.vred1 = :vred1"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByVred2", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.vred2 = :vred2"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByVred3", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.vred3 = :vred3"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByVred4", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.vred4 = :vred4"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByVred5", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.vred5 = :vred5"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByVred6", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.vred6 = :vred6"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByVred7", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.vred7 = :vred7"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByVred8", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.vred8 = :vred8"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByVred9", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.vred9 = :vred9"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByVred10", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.vred10 = :vred10"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByVred11", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.vred11 = :vred11"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByVred12", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.vred12 = :vred12"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByVred13", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.vred13 = :vred13"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByVred14", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.vred14 = :vred14"),
    @NamedQuery(name = "BVMpAkcNazivVredX15.findByVred15", query = "SELECT b FROM BVMpAkcNazivVredX15 b WHERE b.vred15 = :vred15")})
public class BVMpAkcNazivVredX15 implements Serializable {
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
    @Column(name = "VRED9")
    private BigDecimal vred9;
    @Column(name = "VRED10")
    private BigDecimal vred10;
    @Column(name = "VRED11")
    private BigDecimal vred11;
    @Column(name = "VRED12")
    private BigDecimal vred12;
    @Column(name = "VRED13")
    private BigDecimal vred13;
    @Column(name = "VRED14")
    private BigDecimal vred14;
    @Id
    @Column(name = "VRED15")
    private BigInteger vred15;

    public BVMpAkcNazivVredX15() {
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

    public BigDecimal getVred10() {
        return vred10;
    }

    public void setVred10(BigDecimal vred10) {
        this.vred10 = vred10;
    }

    public BigDecimal getVred11() {
        return vred11;
    }

    public void setVred11(BigDecimal vred11) {
        this.vred11 = vred11;
    }

    public BigDecimal getVred12() {
        return vred12;
    }

    public void setVred12(BigDecimal vred12) {
        this.vred12 = vred12;
    }

    public BigDecimal getVred13() {
        return vred13;
    }

    public void setVred13(BigDecimal vred13) {
        this.vred13 = vred13;
    }

    public BigDecimal getVred14() {
        return vred14;
    }

    public void setVred14(BigDecimal vred14) {
        this.vred14 = vred14;
    }

    public BigInteger getVred15() {
        return vred15;
    }

    public void setVred15(BigInteger vred15) {
        this.vred15 = vred15;
    }
    
}
