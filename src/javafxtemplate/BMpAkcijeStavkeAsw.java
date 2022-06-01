/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_MP_AKCIJE_STAVKE_ASW")
@NamedQueries({
    @NamedQuery(name = "BMpAkcijeStavkeAsw.findAll", query = "SELECT b FROM BMpAkcijeStavkeAsw b"),
    @NamedQuery(name = "BMpAkcijeStavkeAsw.findPravi", query = "SELECT b FROM BMpAkcijeStavkeAsw b"),
    @NamedQuery(name = "BMpAkcijeStavkeAsw.findById", query = "SELECT b FROM BMpAkcijeStavkeAsw b WHERE b.bMpAkcijeStavkeAswPK.id = :id"),
    @NamedQuery(name = "BMpAkcijeStavkeAsw.findByIdAkcije", query = "SELECT b FROM BMpAkcijeStavkeAsw b WHERE b.bMpAkcijeStavkeAswPK.idAkcije = :idAkcije"),
    @NamedQuery(name = "BMpAkcijeStavkeAsw.findByIdKampanje", query = "SELECT b FROM BMpAkcijeStavkeAsw b WHERE b.bMpAkcijeStavkeAswPK.idKampanje = :idKampanje"),
    @NamedQuery(name = "BMpAkcijeStavkeAsw.findByKomentar", query = "SELECT b FROM BMpAkcijeStavkeAsw b WHERE b.komentar = :komentar")})
public class BMpAkcijeStavkeAsw implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpAkcijeStavkeAswPK bMpAkcijeStavkeAswPK;
    @Column(name = "KOMENTAR")
    private String komentar;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BMpAkcije bMpAkcije;
    
 /*   @Column(name = "ID_AKCIJE")
    protected Integer idAkcije;
    
    @Column(name = "ID_KAMPANJE")
    protected String idKampanje;
    
    @Column(name = "ID")
    protected Long id;*/
    
   // public Integer id1;

    public BMpAkcijeStavkeAsw() {
    }

    public BMpAkcijeStavkeAsw(BMpAkcijeStavkeAswPK bMpAkcijeStavkeAswPK) {
        this.bMpAkcijeStavkeAswPK = bMpAkcijeStavkeAswPK;
    }

    public BMpAkcijeStavkeAsw(long id, long idAkcije, String idKampanje) {
        this.bMpAkcijeStavkeAswPK = new BMpAkcijeStavkeAswPK(id, idAkcije, idKampanje);
    }

    public BMpAkcijeStavkeAswPK getBMpAkcijeStavkeAswPK() {
        return bMpAkcijeStavkeAswPK;
    }

    public void setBMpAkcijeStavkeAswPK(BMpAkcijeStavkeAswPK bMpAkcijeStavkeAswPK) {
        this.bMpAkcijeStavkeAswPK = bMpAkcijeStavkeAswPK;
    }

    public String getKomentar() {
        return komentar;
    }
    
    //dodato jer je u kljucu
 /*   public long getidAkcije() {
        return this.bMpAkcijeStavkeAswPK.getIdAkcije();
    }
    
       public void setidAkcije(Integer id__Akcije) {
        this.idAkcije= id__Akcije;
    }
       
       public long getid() {
        return this.bMpAkcijeStavkeAswPK.getId();
    }
    
       public void setid(Long id2) {
        this.id= id2;
    }
    
       
        public String getidKampanje() {
        return this.bMpAkcijeStavkeAswPK.getIdKampanje();
    }
      
        
        public void setidKampanje(String id__Kampanje) {
        this.idKampanje= id__Kampanje;
    }

*/
    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public BMpAkcije getBMpAkcije() {
        return bMpAkcije;
    }

    public void setBMpAkcije(BMpAkcije bMpAkcije) {
        this.bMpAkcije = bMpAkcije;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpAkcijeStavkeAswPK != null ? bMpAkcijeStavkeAswPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpAkcijeStavkeAsw)) {
            return false;
        }
        BMpAkcijeStavkeAsw other = (BMpAkcijeStavkeAsw) object;
        if ((this.bMpAkcijeStavkeAswPK == null && other.bMpAkcijeStavkeAswPK != null) || (this.bMpAkcijeStavkeAswPK != null && !this.bMpAkcijeStavkeAswPK.equals(other.bMpAkcijeStavkeAswPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpAkcijeStavkeAsw[ bMpAkcijeStavkeAswPK=" + bMpAkcijeStavkeAswPK + " ]";
    }
    
}
