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
import java.util.List;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_MP_AKCIJE")
@NamedQueries({
    @NamedQuery(name = "BMpAkcije.findAll", query = "SELECT b FROM BMpAkcije b order by b.id DESC"),
    @NamedQuery(name = "BMpAkcije.MaxId", query = "SELECT MAX (b.id) FROM BMpAkcije b"),
    @NamedQuery(name = "BMpAkcije.MaxIdZ", query = "SELECT MAX (b.id) FROM BMpAkcije b where b.status='Z'"),
    @NamedQuery(name = "BMpAkcije.findById", query = "SELECT b FROM BMpAkcije b WHERE b.id = :id"),
    @NamedQuery(name = "BMpAkcije.findByTipAkcije", query = "SELECT b FROM BMpAkcije b WHERE b.tipAkcije = :tipAkcije"),
    @NamedQuery(name = "BMpAkcije.findByDatumOd", query = "SELECT b FROM BMpAkcije b WHERE b.datumOd = :datumOd"),
    @NamedQuery(name = "BMpAkcije.findByDatumDo", query = "SELECT b FROM BMpAkcije b WHERE b.datumDo = :datumDo"),
    @NamedQuery(name = "BMpAkcije.findByStatus", query = "SELECT b FROM BMpAkcije b WHERE b.status = :status"),
    @NamedQuery(name = "BMpAkcije.findByKomentar", query = "SELECT b FROM BMpAkcije b WHERE b.komentar = :komentar")})
public class BMpAkcije implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bMpAkcije")
    private Collection<BMpAkcAriojIskljizAkc> bMpAkcAriojIskljizAkcCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TIP_AKCIJE")
    private String tipAkcije;
    @Column(name = "DATUM_OD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumOd;
    @Column(name = "DATUM_DO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumDo;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "KOMENTAR")
    private String komentar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bMpAkcije")
    private List<BMpAkcijeStavkeAsw> bMpAkcijeStavkeAswList;

    public BMpAkcije() {
    }

    public BMpAkcije(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipAkcije() {
        return tipAkcije;
    }

    public void setTipAkcije(String tipAkcije) {
        this.tipAkcije = tipAkcije;
    }

    public String getDatumOd() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String time = sdf.format(datumOd);
         return time;
        //return datumOd;
    }
    
     public Date getDatumOd2() {
       
        return datumOd;
    }
     
      public Date getDatumDo2() {
       
        return datumDo;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
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

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public List<BMpAkcijeStavkeAsw> getBMpAkcijeStavkeAswList() {
        return bMpAkcijeStavkeAswList;
    }

    public void setBMpAkcijeStavkeAswList(List<BMpAkcijeStavkeAsw> bMpAkcijeStavkeAswList) {
        this.bMpAkcijeStavkeAswList = bMpAkcijeStavkeAswList;
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
        if (!(object instanceof BMpAkcije)) {
            return false;
        }
        BMpAkcije other = (BMpAkcije) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcije[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<BMpAkcAriojIskljizAkc> getBMpAkcAriojIskljizAkcCollection() {
        return bMpAkcAriojIskljizAkcCollection;
    }

    public void setBMpAkcAriojIskljizAkcCollection(Collection<BMpAkcAriojIskljizAkc> bMpAkcAriojIskljizAkcCollection) {
        this.bMpAkcAriojIskljizAkcCollection = bMpAkcAriojIskljizAkcCollection;
    }
    
}
