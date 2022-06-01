/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "B_V_MP_AKC_TREBOVANJE")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcTrebovanje.findAll", query = "SELECT b FROM BVMpAkcTrebovanje b"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByBroj", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.broj = :broj"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findById", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findPretraga", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.id = :id and (b.idArtikla=:idArtikla or :idArtikla=-1) and b.sifra like :sifra AND b.nazivArtikla like :nazivArtikla AND b.ojNaziv like :ojNaziv order by b.sredjenaKolicina desc"),
    @NamedQuery(name = "BVMpAkcTrebovanje.spisakRadnji", query = "SELECT DISTINCT b.ojNaziv FROM BVMpAkcTrebovanje b WHERE b.id = :id order by b.ojNaziv"),
 //  @NamedQuery(name = "BVMpAkcTrebovanje.Pretraga", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.id = :id AND b.nazivArtikla like :nazivArtikla and b.sifra like :sifra AND b.datum BETWEEN :datOd and :datDo AND b.radnja like :radnja AND b.magacin like :magacin and (b.brojDopune= :brojDopune OR :brojDopune=-1) and (b.idArtikla=:idArtikla or :idArtikla=-1)"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByTipAkcije", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.tipAkcije = :tipAkcije"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByDatumOd", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.datumOd = :datumOd"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByDatumDo", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.datumDo = :datumDo"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByIdAkcije", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.idAkcije = :idAkcije"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByIdKampanje", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.idKampanje = :idKampanje"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByIdArtikla", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.idArtikla = :idArtikla"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findBySifra", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.sifra = :sifra"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByNazivArtikla", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.nazivArtikla = :nazivArtikla"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByMagacin", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.magacin = :magacin"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByOrgjed", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.orgjed = :orgjed"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByOjNaziv", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.ojNaziv = :ojNaziv"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByMultifaktor", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.multifaktor = :multifaktor"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findBySredjenaKolicina", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.sredjenaKolicina = :sredjenaKolicina"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByNabavljamKolicinu", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.nabavljamKolicinu = :nabavljamKolicinu"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByPreporucenaKolUk", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.preporucenaKolUk = :preporucenaKolUk"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByPreporucenaKol", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.preporucenaKol = :preporucenaKol"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByZaliha", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.zaliha = :zaliha"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findBySekundarnaPozicija", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.sekundarnaPozicija = :sekundarnaPozicija"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByRgRoot", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.rgRoot = :rgRoot"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByDatum", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.datum = :datum"),
    @NamedQuery(name = "BVMpAkcTrebovanje.findByOpis", query = "SELECT b FROM BVMpAkcTrebovanje b WHERE b.opis = :opis")})
public class BVMpAkcTrebovanje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;
    @Basic(optional = false)
    @Column(name = "ID")
    private long id;
    @Column(name = "TIP_AKCIJE")
    private String tipAkcije;
    @Column(name = "DATUM_OD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumOd;
    @Column(name = "DATUM_DO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumDo;
    @Column(name = "ID_AKCIJE")
    private Long idAkcije;
    @Column(name = "ID_KAMPANJE")
    private String idKampanje;
    @Column(name = "ID_ARTIKLA")
    private Long idArtikla;
    @Basic(optional = false)
    @Column(name = "SIFRA")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "NAZIV_ARTIKLA")
    private String nazivArtikla;
    @Column(name = "MAGACIN")
    private String magacin;
    @Column(name = "ORGJED")
    private String orgjed;
    @Basic(optional = false)
    @Column(name = "OJ_NAZIV")
    private String ojNaziv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MULTIFAKTOR")
    private BigDecimal multifaktor;
    @Column(name = "SREDJENA_KOLICINA")
    private BigDecimal sredjenaKolicina;
    @Column(name = "NABAVLJAM_KOLICINU")
    private BigDecimal nabavljamKolicinu;
    @Column(name = "PREPORUCENA_KOL_UK")
    private BigDecimal preporucenaKolUk;
    @Column(name = "PREPORUCENA_KOL")
    private BigDecimal preporucenaKol;
    @Column(name = "ZALIHA")
    private BigDecimal zaliha;
    @Column(name = "SEKUNDARNA_POZICIJA")
    private BigDecimal sekundarnaPozicija;
    @Column(name = "RG_ROOT")
    private String rgRoot;
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Column(name = "OPIS")
    private String opis;

    public BVMpAkcTrebovanje() {
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipAkcije() {
        return tipAkcije;
    }

    public void setTipAkcije(String tipAkcije) {
        this.tipAkcije = tipAkcije;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
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

    public Long getIdArtikla() {
        return idArtikla;
    }

    public void setIdArtikla(Long idArtikla) {
        this.idArtikla = idArtikla;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNazivArtikla() {
        return nazivArtikla;
    }

    public void setNazivArtikla(String nazivArtikla) {
        this.nazivArtikla = nazivArtikla;
    }

    public String getMagacin() {
        return magacin;
    }

    public void setMagacin(String magacin) {
        this.magacin = magacin;
    }

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    public String getOjNaziv() {
        return ojNaziv;
    }

    public void setOjNaziv(String ojNaziv) {
        this.ojNaziv = ojNaziv;
    }

    public BigDecimal getMultifaktor() {
        return multifaktor;
    }

    public void setMultifaktor(BigDecimal multifaktor) {
        this.multifaktor = multifaktor;
    }

    public BigDecimal getSredjenaKolicina() {
        return sredjenaKolicina;
    }

    public void setSredjenaKolicina(BigDecimal sredjenaKolicina) {
        this.sredjenaKolicina = sredjenaKolicina;
    }

    public BigDecimal getNabavljamKolicinu() {
        return nabavljamKolicinu;
    }

    public void setNabavljamKolicinu(BigDecimal nabavljamKolicinu) {
        this.nabavljamKolicinu = nabavljamKolicinu;
    }

    public BigDecimal getPreporucenaKolUk() {
        return preporucenaKolUk;
    }

    public void setPreporucenaKolUk(BigDecimal preporucenaKolUk) {
        this.preporucenaKolUk = preporucenaKolUk;
    }

    public BigDecimal getPreporucenaKol() {
        return preporucenaKol;
    }

    public void setPreporucenaKol(BigDecimal preporucenaKol) {
        this.preporucenaKol = preporucenaKol;
    }

    public BigDecimal getZaliha() {
        return zaliha;
    }

    public void setZaliha(BigDecimal zaliha) {
        this.zaliha = zaliha;
    }

    public BigDecimal getSekundarnaPozicija() {
        return sekundarnaPozicija;
    }

    public void setSekundarnaPozicija(BigDecimal sekundarnaPozicija) {
        this.sekundarnaPozicija = sekundarnaPozicija;
    }

    public String getRgRoot() {
        return rgRoot;
    }

    public void setRgRoot(String rgRoot) {
        this.rgRoot = rgRoot;
    }

     public String getDatum() {
      //  return datum;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
         String time = sdf.format(datum);
        return time/*datum*/;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    
}
