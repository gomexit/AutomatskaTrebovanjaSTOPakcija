/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate.CompositePrimaryKeys;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author milost
 */
@Embeddable
public class MBMpAkcijeMaxKolicinePK implements Serializable {

  
    @Column(name = "SIFRA_ARTIKLA", nullable = false)
    private String sifraArtikla;

    @Column(name = "SIFRA_OBJEKTA", nullable = false)
    private String sifraObjekta;
    
    public String getSifraArtikla() {
        return sifraArtikla;
    }

    public void setSifraArtikla(String sifraArtikla) {
        this.sifraArtikla = sifraArtikla;
    }

    public String getSifraObjekta() {
        return sifraObjekta;
    }

    public void setSifraObjekta(String sifraObjekta) {
        this.sifraObjekta = sifraObjekta;
    }

    public MBMpAkcijeMaxKolicinePK(String sifraArtikla, String sifraObjekta) {
        this.sifraArtikla = sifraArtikla;
        this.sifraObjekta = sifraObjekta;
    }

    public MBMpAkcijeMaxKolicinePK() {
    }
    
    

    

    
    @Override
    public String toString() {
        return "javafxtemplate.CompositePrimaryKeys.MBMpAkcijeMaxKolicinePK[ id=" + sifraArtikla + " ]";
    }
    
}
