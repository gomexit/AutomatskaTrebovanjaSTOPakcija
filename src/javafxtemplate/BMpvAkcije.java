/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_MPV_AKCIJE")
@NamedQueries({
    @NamedQuery(name = "BMpvAkcije.findAll", query = "SELECT b FROM BMpvAkcije b order by b.datumDo desc"),
    @NamedQuery(name = "BMpvAkcije.findById", query = "SELECT b FROM BMpvAkcije b WHERE b.id = :id"),
    @NamedQuery(name = "BMpvAkcije.findByDatumOd", query = "SELECT b FROM BMpvAkcije b WHERE b.datumOd = :datumOd"),
    @NamedQuery(name = "BMpvAkcije.findByDatumDo", query = "SELECT b FROM BMpvAkcije b WHERE b.datumDo = :datumDo"),
    @NamedQuery(name = "BMpvAkcije.findByStatus", query = "SELECT b FROM BMpvAkcije b WHERE b.status = :status"),
    @NamedQuery(name = "BMpvAkcije.findByOpis", query = "SELECT b FROM BMpvAkcije b WHERE b.opis = :opis")})
public class BMpvAkcije implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DATUM_OD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumOd;
    @Column(name = "DATUM_DO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumDo;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "OPIS")
    private String opis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bMpvAkcije")
    private Collection<BMpvAkcijeArtikli> bMpvAkcijeArtikliCollection;

    public BMpvAkcije() {
    }

    public BMpvAkcije(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatumOd2() {
        return datumOd;
    }
       public String getDatumOd() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String time = sdf.format(datumOd);
         return time;
        //return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo2() {
        return datumDo;
    }
     public String getDatumDo() {
       SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String time = sdf.format(datumDo);
        return time;
        
        //return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Collection<BMpvAkcijeArtikli> getBMpvAkcijeArtikliCollection() {
        return bMpvAkcijeArtikliCollection;
    }

    public void setBMpvAkcijeArtikliCollection(Collection<BMpvAkcijeArtikli> bMpvAkcijeArtikliCollection) {
        this.bMpvAkcijeArtikliCollection = bMpvAkcijeArtikliCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpvAkcije)) {
            return false;
        }
        BMpvAkcije other = (BMpvAkcije) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpvAkcije[ id=" + id + " ]";
    }
    
}
