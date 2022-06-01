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
@Table(name = "B_V_MP_AKC_RADNJE")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcRadnje.findAll", query = "SELECT b FROM BVMpAkcRadnje b order by b.naziv"),
    @NamedQuery(name = "BVMpAkcRadnje.findByOrgjed", query = "SELECT b FROM BVMpAkcRadnje b WHERE b.orgjed = :orgjed"),
    @NamedQuery(name = "BVMpAkcRadnje.findByNaziv", query = "SELECT b FROM BVMpAkcRadnje b WHERE b.naziv = :naziv"),
    @NamedQuery(name = "BVMpAkcRadnje.findByNaziv2", query = "SELECT b FROM BVMpAkcRadnje b WHERE b.naziv like :naziv ORDER BY B.naziv"),
    @NamedQuery(name = "BVMpAkcRadnje.findByAkcijskoTrebovanje", query = "SELECT b FROM BVMpAkcRadnje b WHERE b.akcijskoTrebovanje = :akcijskoTrebovanje"),
    @NamedQuery(name = "BVMpAkcRadnje.findByStopDanZaPrvoPunjenje", query = "SELECT b FROM BVMpAkcRadnje b WHERE b.stopDanZaPrvoPunjenje = :stopDanZaPrvoPunjenje"),
    @NamedQuery(name = "BVMpAkcRadnje.findByStopDanZaPrvuDopunu", query = "SELECT b FROM BVMpAkcRadnje b WHERE b.stopDanZaPrvuDopunu = :stopDanZaPrvuDopunu"),
    @NamedQuery(name = "BVMpAkcRadnje.findByDc", query = "SELECT b FROM BVMpAkcRadnje b WHERE b.dc = :dc"),
    @NamedQuery(name = "BVMpAkcRadnje.findByStopDanZaPrvuDopunuRdc", query = "SELECT b FROM BVMpAkcRadnje b WHERE b.stopDanZaPrvuDopunuRdc = :stopDanZaPrvuDopunuRdc"),
    @NamedQuery(name = "BVMpAkcRadnje.findByRazvoz1", query = "SELECT b FROM BVMpAkcRadnje b WHERE b.razvoz1 = :razvoz1"),
    @NamedQuery(name = "BVMpAkcRadnje.findByRazvoz2", query = "SELECT b FROM BVMpAkcRadnje b WHERE b.razvoz2 = :razvoz2"),
    @NamedQuery(name = "BVMpAkcRadnje.findByRazvoz3", query = "SELECT b FROM BVMpAkcRadnje b WHERE b.razvoz3 = :razvoz3")})
public class BVMpAkcRadnje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ORGJED")
    private String orgjed;
    @Basic(optional = false)
    @Column(name = "NAZIV")
    private String naziv;
    @Column(name = "AKCIJSKO_TREBOVANJE")
    private String akcijskoTrebovanje;
     @Column(name = "AKCIJSKO_TREBOVANJE_VIK")
    private String akcijskoTrebovanjeVik;

    public String getAkcijskoTrebovanjeVik() {
        return akcijskoTrebovanjeVik;
    }

    public void setAkcijskoTrebovanjeVik(String akcijskoTrebovanjeVik) {
        this.akcijskoTrebovanjeVik = akcijskoTrebovanjeVik;
    }
    @Column(name = "STOP_DAN_ZA_PRVO_PUNJENJE")
    private Short stopDanZaPrvoPunjenje;
    @Column(name = "STOP_DAN_ZA_PRVU_DOPUNU")
    private Short stopDanZaPrvuDopunu;
    @Column(name = "DC")
    private String dc;
     @Column(name = "STOP_DAN_ZA_PRVO_PUNJENJE_RDC")
    private Short stopDanZaPrvoPunjenjeRdc;

    public Short getStopDanZaPrvoPunjenjeRdc() {
        return stopDanZaPrvoPunjenjeRdc;
    }

    public void setStopDanZaPrvoPunjenjeRdc(Short stopDanZaPrvoPunjenjeRdc) {
        this.stopDanZaPrvoPunjenjeRdc = stopDanZaPrvoPunjenjeRdc;
    }
    @Column(name = "STOP_DAN_ZA_PRVU_DOPUNU_RDC")
    private Short stopDanZaPrvuDopunuRdc;
    @Column(name = "RAZVOZ1")
    private Short razvoz1;
    @Column(name = "RAZVOZ2")
    private Short razvoz2;
    @Column(name = "RAZVOZ3")
    private Short razvoz3;

    public BVMpAkcRadnje() {
    }

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAkcijskoTrebovanje() {
        return akcijskoTrebovanje;
    }

    public void setAkcijskoTrebovanje(String akcijskoTrebovanje) {
        this.akcijskoTrebovanje = akcijskoTrebovanje;
    }

    public Short getStopDanZaPrvoPunjenje() {
        return stopDanZaPrvoPunjenje;
    }

    public void setStopDanZaPrvoPunjenje(Short stopDanZaPrvoPunjenje) {
        this.stopDanZaPrvoPunjenje = stopDanZaPrvoPunjenje;
    }

    public Short getStopDanZaPrvuDopunu() {
        return stopDanZaPrvuDopunu;
    }

    public void setStopDanZaPrvuDopunu(Short stopDanZaPrvuDopunu) {
        this.stopDanZaPrvuDopunu = stopDanZaPrvuDopunu;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public Short getStopDanZaPrvuDopunuRdc() {
        return stopDanZaPrvuDopunuRdc;
    }

    public void setStopDanZaPrvuDopunuRdc(Short stopDanZaPrvuDopunuRdc) {
        this.stopDanZaPrvuDopunuRdc = stopDanZaPrvuDopunuRdc;
    }

    public Short getRazvoz1() {
        return razvoz1;
    }

    public void setRazvoz1(Short razvoz1) {
        this.razvoz1 = razvoz1;
    }

    public Short getRazvoz2() {
        return razvoz2;
    }

    public void setRazvoz2(Short razvoz2) {
        this.razvoz2 = razvoz2;
    }

    public Short getRazvoz3() {
        return razvoz3;
    }

    public void setRazvoz3(Short razvoz3) {
        this.razvoz3 = razvoz3;
    }
    
}
