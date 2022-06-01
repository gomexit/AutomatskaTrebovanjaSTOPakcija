/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate.DTOs;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.SqlResultSetMapping;

/**
 *
 * @author milost
 */

public class MaxKolicineDTO implements Serializable {
    private String sifraArtikla;
    private BigInteger maxKolicina;
    private String sifraObjekta;
    private String nazivObjekta;
    private String nazivArtikla;

    
    public MaxKolicineDTO(String sifraArtikla, BigInteger maxKolicina, String sifraObjekta, String nazivObjekta,String nazivArtikla) {
        this.sifraArtikla = sifraArtikla;
        this.maxKolicina = maxKolicina;
        this.sifraObjekta = sifraObjekta;
        this.nazivObjekta = nazivObjekta;
        this.nazivArtikla = nazivArtikla;
    }
    

    public String getSifraArtikla() {
        return sifraArtikla;
    }

    public void setSifraArtikla(String sifraArtikla) {
        this.sifraArtikla = sifraArtikla;
    }

    public BigInteger getMaxKolicina() {
        return maxKolicina;
    }

    public void setMaxKolicina(BigInteger maxKolicina) {
        this.maxKolicina = maxKolicina;
    }

    public String getSifraObjekta() {
        return sifraObjekta;
    }

    public void setSifraObjekta(String sifraObjekta) {
        this.sifraObjekta = sifraObjekta;
    }

    public String getNazivObjekta() {
        return nazivObjekta;
    }

    public void setNazivObjekta(String nazivObjekta) {
        this.nazivObjekta = nazivObjekta;
    }
    public String getNazivArtikla() {
        return nazivArtikla;
    }

    public void setNazivArtikla(String nazivArtikla) {
        this.nazivArtikla = nazivArtikla;
    }

    
    
    
}
