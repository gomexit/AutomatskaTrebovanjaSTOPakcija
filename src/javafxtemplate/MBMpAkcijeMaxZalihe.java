/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigInteger;
import javafxtemplate.DTOs.MaxKolicineDTO;
import javafxtemplate.DTOs.MaxZaliheDTO;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author milost
 */
@Table(name = "M_B_MP_AKC_MAX_ZALIHA")
@XmlRootElement
@SqlResultSetMapping(name = "TblMaxZaliheView", classes = {
    @ConstructorResult(targetClass = MaxZaliheDTO.class,
            columns = {
                    @ColumnResult(name = "SIFRA"),
                    @ColumnResult(name = "NAZIV"),
                    @ColumnResult(name = "MAX_ZALIHA",type = BigInteger.class)
            })
})
@NamedQuery(name = "MBMpAkcijeMaxZalihe.findById", query = "SELECT m FROM MBMpAkcijeMaxZalihe m WHERE m.artikal = :artikal")
@NamedNativeQuery(name = "getMaxZaliheList", 
                  query = "select ar.naziv,t.max_zaliha,ar.sifra from M_B_MP_AKC_MAX_ZALIHA t,iis.artikli ar WHERE ar.id = t.artikal", 
                  resultSetMapping = "TblMaxZaliheView")
@Entity
public class MBMpAkcijeMaxZalihe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ARTIKAL")
    private BigInteger artikal;
    
    @Column(name = "MAX_ZALIHA")
    private BigInteger maxZaliha;

    public BigInteger getArtikal() {
        return artikal;
    }

    public void setArtikal(BigInteger artikal) {
        this.artikal = artikal;
    }

    public BigInteger getMaxZaliha() {
        return maxZaliha;
    }

    public void setMaxZaliha(BigInteger maxZaliha) {
        this.maxZaliha = maxZaliha;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artikal != null ? artikal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the artikal fields are not set
        if (!(object instanceof MBMpAkcijeMaxZalihe)) {
            return false;
        }
        MBMpAkcijeMaxZalihe other = (MBMpAkcijeMaxZalihe) object;
        if ((this.artikal == null && other.artikal != null) || (this.artikal != null && !this.artikal.equals(other.artikal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.MBMpAkcijeMaxZalihe[ id=" + artikal + " ]";
    }
    
}
