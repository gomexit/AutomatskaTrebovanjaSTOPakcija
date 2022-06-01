/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate.DTOs;

import java.math.BigInteger;

/**
 *
 * @author milost
 */
public class MaxZaliheDTO {
    private String sifraArtikla;
    private String nazivArtikla;
    private BigInteger maxKolicina;

    public MaxZaliheDTO(String sifraArtikla, String nazivArtikla, BigInteger maxKolicina) {
        this.sifraArtikla = sifraArtikla;
        this.nazivArtikla = nazivArtikla;
        this.maxKolicina = maxKolicina;
    }

    public String getSifraArtikla() {
        return sifraArtikla;
    }

    public void setSifraArtikla(String sifraArtikla) {
        this.sifraArtikla = sifraArtikla;
    }

    public String getNazivArtikla() {
        return nazivArtikla;
    }

    public void setNazivArtikla(String nazivArtikla) {
        this.nazivArtikla = nazivArtikla;
    }

    public BigInteger getMaxKolicina() {
        return maxKolicina;
    }

    public void setMaxKolicina(BigInteger maxKolicina) {
        this.maxKolicina = maxKolicina;
    }
    
    
    
    
}
