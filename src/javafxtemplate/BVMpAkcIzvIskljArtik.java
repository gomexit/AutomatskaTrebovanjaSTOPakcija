/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
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
@Table(name = "B_V_MP_AKC_IZV_ISKLJ_ARTIK")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcIzvIskljArtik.findAll", query = "SELECT b FROM BVMpAkcIzvIskljArtik b"),
    @NamedQuery(name = "BVMpAkcIzvIskljArtik.findById", query = "SELECT b FROM BVMpAkcIzvIskljArtik b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcIzvIskljArtik.findByIdArtikla", query = "SELECT b FROM BVMpAkcIzvIskljArtik b WHERE b.idArtikla = :idArtikla"),
    @NamedQuery(name = "BVMpAkcIzvIskljArtik.findBySifra", query = "SELECT b FROM BVMpAkcIzvIskljArtik b WHERE b.sifra = :sifra"),
    @NamedQuery(name = "BVMpAkcIzvIskljArtik.findByNaziv", query = "SELECT b FROM BVMpAkcIzvIskljArtik b WHERE b.naziv = :naziv")})
public class BVMpAkcIzvIskljArtik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "ID_ARTIKLA")
    private long idArtikla;
    @Basic(optional = false)
    @Column(name = "SIFRA")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Id
    @Basic(optional = false)
    @Column(name = "BROJ")
    private Long broj;

    public Long getBroj() {
        return broj;
    }

    public void setBroj(Long broj) {
        this.broj = broj;
    }

    public BVMpAkcIzvIskljArtik() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getIdArtikla() {
        return idArtikla;
    }

    public void setIdArtikla(long idArtikla) {
        this.idArtikla = idArtikla;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
}
