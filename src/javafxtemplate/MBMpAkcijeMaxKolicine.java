/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigInteger;
import javafxtemplate.CompositePrimaryKeys.MBMpAkcijeMaxKolicinePK;
import javafxtemplate.DTOs.MaxKolicineDTO;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author milost
 */
@Entity
@Table(name = "M_B_MP_AKCIJE_MAX_KOLICINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MBMpAkcijeMaxKolicine.findAll", query = "SELECT m FROM MBMpAkcijeMaxKolicine m"),
    @NamedQuery(name = "MBMpAkcijeMaxKolicine.findBySifraArtikla", query = "SELECT m FROM MBMpAkcijeMaxKolicine m WHERE m.myPk.sifraArtikla = :sifraArtikla"),
    @NamedQuery(name = "MBMpAkcijeMaxKolicine.deleteSifraArtikla", query = "delete FROM MBMpAkcijeMaxKolicine m WHERE m.myPk.sifraArtikla = :sifraArtikla"),
    @NamedQuery(name = "MBMpAkcijeMaxKolicine.findBySifraArtiklaOrgjed", query = "SELECT m FROM MBMpAkcijeMaxKolicine m WHERE m.myPk.sifraArtikla = :sifraArtikla and m.myPk.sifraObjekta = :sifraObjekta"),
    @NamedQuery(name = "MBMpAkcijeMaxKolicine.findByMaxKolicina", query = "SELECT m FROM MBMpAkcijeMaxKolicine m WHERE m.maxKolicina = :maxKolicina")})
@SqlResultSetMapping(name = "TblMaxKolicineView", classes = {
    @ConstructorResult(targetClass = MaxKolicineDTO.class,
            columns = {
                    @ColumnResult(name = "SIFRA_ARTIKLA"),
                    @ColumnResult(name = "MAX_KOLICINA",type = BigInteger.class),
                    @ColumnResult(name = "SIFRA_OBJEKTA"),
                    @ColumnResult(name = "NAZIV_OBJEKTA",type=String.class),
                    @ColumnResult(name = "NAZIV_ARTIKLA"),
            })
})
@NamedNativeQuery(name = "getMaxKolicineList", query = "SELECT ma.sifra_artikla,ar.naziv as naziv_artikla, ma.max_kolicina,ma.sifra_objekta,oj.naziv naziv_Objekta \n" +
"FROM M_B_MP_AKCIJE_MAX_KOLICINE ma LEFT JOIN iis.orgjed oj ON ma.sifra_objekta = oj.sifra\n" +
"                                   LEFT JOIN iis.artikli ar ON ar.sifra = ma.sifra_artikla", resultSetMapping = "TblMaxKolicineView")
public class MBMpAkcijeMaxKolicine implements Serializable {
    
    @EmbeddedId
    private MBMpAkcijeMaxKolicinePK myPk;

    public MBMpAkcijeMaxKolicinePK getMyPk() {
        return myPk;
    }

    public void setMyPk(MBMpAkcijeMaxKolicinePK myPk) {
        this.myPk = myPk;
    }
    
    @Column(name = "MAX_KOLICINA")
    private BigInteger maxKolicina;
    

    public MBMpAkcijeMaxKolicine() {
    }

    public MBMpAkcijeMaxKolicine(MBMpAkcijeMaxKolicinePK myPk, String sifraArtikla, BigInteger maxKolicina, String sifraObjekta) {
        this.myPk = myPk;
        this.maxKolicina = maxKolicina;
    }


    public BigInteger getMaxKolicina() {
        return maxKolicina;
    }

    public void setMaxKolicina(BigInteger maxKolicina) {
        this.maxKolicina = maxKolicina;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (sifraArtikla != null ? sifraArtikla.hashCode() : 0);
//        return hash;
//    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof MBMpAkcijeMaxKolicine)) {
//            return false;
//        }
//        MBMpAkcijeMaxKolicine other = (MBMpAkcijeMaxKolicine) object;
//        if ((this.sifraArtikla == null && other.sifraArtikla != null) || (this.sifraArtikla != null && !this.sifraArtikla.equals(other.sifraArtikla))) {
//            return false;
//        }
//        return true;
//    }
    

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "javafxtemplate.MBMpAkcijeMaxKolicine[ sifraArtikla=" + myPk + " ]";
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaFXTemplate_testiranjePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
