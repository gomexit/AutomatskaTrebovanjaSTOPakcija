/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
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
@Table(name = "B_V_MP_AKC_SVE_RADNJE")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcSveRadnje.pozovisve", query = "SELECT b.naziv FROM BVMpAkcSveRadnje b"),
    @NamedQuery(name = "BVMpAkcSveRadnje.findByNaziv", query = "SELECT b FROM BVMpAkcSveRadnje b WHERE b.naziv = :naziv")})
public class BVMpAkcSveRadnje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "NAZIV")
    private String naziv;

    public BVMpAkcSveRadnje() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
}
