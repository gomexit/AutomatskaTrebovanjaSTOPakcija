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
@Table(name = "B_V_MP_AKC_ODELJENJA")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcOdeljenja.findAll", query = "SELECT b FROM BVMpAkcOdeljenja b"),
    @NamedQuery(name = "BVMpAkcOdeljenja.PrikaziNazive", query = "SELECT b.rgNadNaziv FROM BVMpAkcOdeljenja b where b.id= :id"),
    @NamedQuery(name = "BVMpAkcOdeljenja.findByRgNad", query = "SELECT b FROM BVMpAkcOdeljenja b WHERE b.rgNad = :rgNad"),
    @NamedQuery(name = "BVMpAkcOdeljenja.findByRgNadNaziv", query = "SELECT b FROM BVMpAkcOdeljenja b WHERE b.rgNadNaziv = :rgNadNaziv"),
    @NamedQuery(name = "BVMpAkcOdeljenja.findByBroj", query = "SELECT b FROM BVMpAkcOdeljenja b WHERE b.broj = :broj")})
public class BVMpAkcOdeljenja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "RG_NAD")
    private String rgNad;
    @Basic(optional = false)
    @Column(name = "RG_NAD_NAZIV")
    private String rgNadNaziv;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;
    
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BVMpAkcOdeljenja() {
    }

    public String getRgNad() {
        return rgNad;
    }

    public void setRgNad(String rgNad) {
        this.rgNad = rgNad;
    }

    public String getRgNadNaziv() {
        return rgNadNaziv;
    }

    public void setRgNadNaziv(String rgNadNaziv) {
        this.rgNadNaziv = rgNadNaziv;
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }
    
}
