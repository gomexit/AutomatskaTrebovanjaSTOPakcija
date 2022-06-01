/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
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
@Table(name = "B_V_MP_AKC_ALGORITMI")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcAlgoritmi.findAll", query = "SELECT b FROM BVMpAkcAlgoritmi b"),
    @NamedQuery(name = "BVMpAkcAlgoritmi.lista", query = "SELECT b.primenjenAlgoritam FROM BVMpAkcAlgoritmi b where b.id = :id"),
    @NamedQuery(name = "BVMpAkcAlgoritmi.findByPrimenjenAlgoritam", query = "SELECT b FROM BVMpAkcAlgoritmi b WHERE b.primenjenAlgoritam = :primenjenAlgoritam"),
    @NamedQuery(name = "BVMpAkcAlgoritmi.findByBroj", query = "SELECT b FROM BVMpAkcAlgoritmi b WHERE b.broj = :broj")})
public class BVMpAkcAlgoritmi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PRIMENJEN_ALGORITAM")
    private BigInteger primenjenAlgoritam;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;

     @Column(name = "ID")
    private BigInteger id;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }
     
    public BVMpAkcAlgoritmi() {
    }

    public BigInteger getPrimenjenAlgoritam() {
        return primenjenAlgoritam;
    }

    public void setPrimenjenAlgoritam(BigInteger primenjenAlgoritam) {
        this.primenjenAlgoritam = primenjenAlgoritam;
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }
    
}
