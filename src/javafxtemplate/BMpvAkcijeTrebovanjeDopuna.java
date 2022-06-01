/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bojan
 */
@Entity
@Table(name = "B_MPV_AKCIJE_TREBOVANJE_DOPUNA")
@NamedQueries({
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findAll", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findById", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.bMpvAkcijeTrebovanjeDopunaPK.id = :id"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByBrojDopune", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.bMpvAkcijeTrebovanjeDopunaPK.brojDopune = :brojDopune"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByOrgjed", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.bMpvAkcijeTrebovanjeDopunaPK.orgjed = :orgjed"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByMagacin", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.bMpvAkcijeTrebovanjeDopunaPK.magacin = :magacin"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByTipAkcije", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.tipAkcije = :tipAkcije"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByIdAkcije", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.idAkcije = :idAkcije"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByIdKampanje", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.idKampanje = :idKampanje"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByIdArtikla", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.bMpvAkcijeTrebovanjeDopunaPK.idArtikla = :idArtikla"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByMultifaktor", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.multifaktor = :multifaktor"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByZaliha", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.zaliha = :zaliha"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByPreporKolDoIsporuke", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.preporKolDoIsporuke = :preporKolDoIsporuke"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByPreporKolPeriod", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.preporKolPeriod = :preporKolPeriod"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findBySredjenaKolicina", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.sredjenaKolicina = :sredjenaKolicina"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByOpis", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.opis = :opis"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByDatumZalihe", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.datumZalihe = :datumZalihe"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByDatum", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.datum = :datum"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByNesredjenaKolicina", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.nesredjenaKolicina = :nesredjenaKolicina"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByProjekcijaOd", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.projekcijaOd = :projekcijaOd"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByProjekcijaDo", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.projekcijaDo = :projekcijaDo"),
    @NamedQuery(name = "BMpvAkcijeTrebovanjeDopuna.findByRgRoot", query = "SELECT b FROM BMpvAkcijeTrebovanjeDopuna b WHERE b.rgRoot = :rgRoot")})
public class BMpvAkcijeTrebovanjeDopuna implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BMpvAkcijeTrebovanjeDopunaPK bMpvAkcijeTrebovanjeDopunaPK;
    @Column(name = "TIP_AKCIJE")
    private String tipAkcije;
    @Column(name = "ID_AKCIJE")
    private Long idAkcije;
    @Column(name = "ID_KAMPANJE")
    private String idKampanje;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MULTIFAKTOR")
    private BigDecimal multifaktor;
    @Column(name = "ZALIHA")
    private BigDecimal zaliha;
    @Column(name = "PREPOR_KOL_DO_ISPORUKE")
    private BigDecimal preporKolDoIsporuke;
    @Column(name = "PREPOR_KOL_PERIOD")
    private BigDecimal preporKolPeriod;
    @Column(name = "SREDJENA_KOLICINA")
    private BigDecimal sredjenaKolicina;
    @Column(name = "OPIS")
    private String opis;
    @Column(name = "DATUM_ZALIHE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumZalihe;
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Column(name = "NESREDJENA_KOLICINA")
    private BigDecimal nesredjenaKolicina;
    @Column(name = "PROJEKCIJA_OD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date projekcijaOd;
    @Column(name = "PROJEKCIJA_DO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date projekcijaDo;
    @Column(name = "RG_ROOT")
    private String rgRoot;

    public BMpvAkcijeTrebovanjeDopuna() {
    }

    public BMpvAkcijeTrebovanjeDopuna(BMpvAkcijeTrebovanjeDopunaPK bMpvAkcijeTrebovanjeDopunaPK) {
        this.bMpvAkcijeTrebovanjeDopunaPK = bMpvAkcijeTrebovanjeDopunaPK;
    }

    public BMpvAkcijeTrebovanjeDopuna(long id, int brojDopune, String orgjed, String magacin, long idArtikla) {
        this.bMpvAkcijeTrebovanjeDopunaPK = new BMpvAkcijeTrebovanjeDopunaPK(id, brojDopune, orgjed, magacin, idArtikla);
    }

    public BMpvAkcijeTrebovanjeDopunaPK getBMpvAkcijeTrebovanjeDopunaPK() {
        return bMpvAkcijeTrebovanjeDopunaPK;
    }

    public void setBMpvAkcijeTrebovanjeDopunaPK(BMpvAkcijeTrebovanjeDopunaPK bMpvAkcijeTrebovanjeDopunaPK) {
        this.bMpvAkcijeTrebovanjeDopunaPK = bMpvAkcijeTrebovanjeDopunaPK;
    }

    public String getTipAkcije() {
        return tipAkcije;
    }

    public void setTipAkcije(String tipAkcije) {
        this.tipAkcije = tipAkcije;
    }

    public Long getIdAkcije() {
        return idAkcije;
    }

    public void setIdAkcije(Long idAkcije) {
        this.idAkcije = idAkcije;
    }

    public String getIdKampanje() {
        return idKampanje;
    }

    public void setIdKampanje(String idKampanje) {
        this.idKampanje = idKampanje;
    }

    public BigDecimal getMultifaktor() {
        return multifaktor;
    }

    public void setMultifaktor(BigDecimal multifaktor) {
        this.multifaktor = multifaktor;
    }

    public BigDecimal getZaliha() {
        return zaliha;
    }

    public void setZaliha(BigDecimal zaliha) {
        this.zaliha = zaliha;
    }

    public BigDecimal getPreporKolDoIsporuke() {
        return preporKolDoIsporuke;
    }

    public void setPreporKolDoIsporuke(BigDecimal preporKolDoIsporuke) {
        this.preporKolDoIsporuke = preporKolDoIsporuke;
    }

    public BigDecimal getPreporKolPeriod() {
        return preporKolPeriod;
    }

    public void setPreporKolPeriod(BigDecimal preporKolPeriod) {
        this.preporKolPeriod = preporKolPeriod;
    }

    public BigDecimal getSredjenaKolicina() {
        return sredjenaKolicina;
    }

    public void setSredjenaKolicina(BigDecimal sredjenaKolicina) {
        this.sredjenaKolicina = sredjenaKolicina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDatumZalihe() {
        return datumZalihe;
    }

    public void setDatumZalihe(Date datumZalihe) {
        this.datumZalihe = datumZalihe;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public BigDecimal getNesredjenaKolicina() {
        return nesredjenaKolicina;
    }

    public void setNesredjenaKolicina(BigDecimal nesredjenaKolicina) {
        this.nesredjenaKolicina = nesredjenaKolicina;
    }

    public Date getProjekcijaOd() {
        return projekcijaOd;
    }

    public void setProjekcijaOd(Date projekcijaOd) {
        this.projekcijaOd = projekcijaOd;
    }

    public Date getProjekcijaDo() {
        return projekcijaDo;
    }

    public void setProjekcijaDo(Date projekcijaDo) {
        this.projekcijaDo = projekcijaDo;
    }

    public String getRgRoot() {
        return rgRoot;
    }

    public void setRgRoot(String rgRoot) {
        this.rgRoot = rgRoot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bMpvAkcijeTrebovanjeDopunaPK != null ? bMpvAkcijeTrebovanjeDopunaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMpvAkcijeTrebovanjeDopuna)) {
            return false;
        }
        BMpvAkcijeTrebovanjeDopuna other = (BMpvAkcijeTrebovanjeDopuna) object;
        if ((this.bMpvAkcijeTrebovanjeDopunaPK == null && other.bMpvAkcijeTrebovanjeDopunaPK != null) || (this.bMpvAkcijeTrebovanjeDopunaPK != null && !this.bMpvAkcijeTrebovanjeDopunaPK.equals(other.bMpvAkcijeTrebovanjeDopunaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxtemplate.BMpvAkcijeTrebovanjeDopuna[ bMpvAkcijeTrebovanjeDopunaPK=" + bMpvAkcijeTrebovanjeDopunaPK + " ]";
    }
    
}
