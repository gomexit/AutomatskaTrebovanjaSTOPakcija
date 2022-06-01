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
@Table(name = "B_V_MP_AKC_DOPUNSKA_TREBOVANJA")
@NamedQueries({
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findAll", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.Pretraga", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.id = :id AND b.nazivArtikla like :nazivArtikla and b.sifra like :sifra AND b.datum BETWEEN :datOd and :datDo AND b.radnja like :radnja AND b.magacin like :magacin and (b.brojDopune= :brojDopune OR :brojDopune=-1) and (b.idArtikla=:idArtikla or :idArtikla=-1) order by b.sredjenaKolicina desc"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByBroj", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.broj = :broj"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findById", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.spisakRadnji", query = "SELECT DISTINCT b.radnja FROM BVMpAkcDopunskaTrebovanja b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.spisakMagacina", query = "SELECT DISTINCT b.magacin FROM BVMpAkcDopunskaTrebovanja b WHERE b.id = :id"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.spisakDopuna", query = "SELECT DISTINCT b.brojDopune FROM BVMpAkcDopunskaTrebovanja b WHERE b.id = :id ORDER BY b.brojDopune"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByBrojDopune", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.brojDopune = :brojDopune"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByOrgjed", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.orgjed = :orgjed"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByRadnja", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.radnja = :radnja"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByMagacin", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.magacin = :magacin"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByDatum", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.datum = :datum"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByIdArtikla", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.idArtikla = :idArtikla"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findBySifra", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.sifra = :sifra"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByNazivArtikla", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.nazivArtikla = :nazivArtikla"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByMultifaktor", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.multifaktor = :multifaktor"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByZaliha", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.zaliha = :zaliha"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByDatumZalihe", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.datumZalihe = :datumZalihe"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByPreporKolDoIsporuke", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.preporKolDoIsporuke = :preporKolDoIsporuke"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByPreporKolPeriod", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.preporKolPeriod = :preporKolPeriod"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByNesredjenaKolicina", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.nesredjenaKolicina = :nesredjenaKolicina"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findBySredjenaKolicina", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.sredjenaKolicina = :sredjenaKolicina"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByProjekcijaOd", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.projekcijaOd = :projekcijaOd"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByProjekcijaDo", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.projekcijaDo = :projekcijaDo"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByOpis", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.opis = :opis"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByRgRoot", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.rgRoot = :rgRoot"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByIdAkcije", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.idAkcije = :idAkcije"),
    @NamedQuery(name = "BVMpAkcDopunskaTrebovanja.findByIdKampanje", query = "SELECT b FROM BVMpAkcDopunskaTrebovanja b WHERE b.idKampanje = :idKampanje")})
public class BVMpAkcDopunskaTrebovanja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BROJ")
    private BigInteger broj;
    @Basic(optional = false)
    @Column(name = "ID")
    private long id;
    @Basic(optional = false)
    @Column(name = "BROJ_DOPUNE")
    private int brojDopune;
    @Basic(optional = false)
    @Column(name = "ORGJED")
    private String orgjed;
    @Basic(optional = false)
    @Column(name = "RADNJA")
    private String radnja;
    @Basic(optional = false)
    @Column(name = "MAGACIN")
    private String magacin;
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Basic(optional = false)
    @Column(name = "ID_ARTIKLA")
    private long idArtikla;
    @Basic(optional = false)
    @Column(name = "SIFRA")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "NAZIV_ARTIKLA")
    private String nazivArtikla;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MULTIFAKTOR")
    private BigDecimal multifaktor;
    @Column(name = "ZALIHA")
    private BigDecimal zaliha;
     @Column(name = "PRODAJA")
    private BigDecimal prodaja;
    @Column(name = "DATUM_ZALIHE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumZalihe;
    @Column(name = "PREPOR_KOL_DO_ISPORUKE")
    private BigDecimal preporKolDoIsporuke;
    @Column(name = "PREPOR_KOL_PERIOD")
    private BigDecimal preporKolPeriod;
    @Column(name = "NESREDJENA_KOLICINA")
    private BigDecimal nesredjenaKolicina;
    @Column(name = "SREDJENA_KOLICINA")
    private BigDecimal sredjenaKolicina;
    @Column(name = "PROJEKCIJA_OD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date projekcijaOd;
    @Column(name = "PROJEKCIJA_DO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date projekcijaDo;
    @Column(name = "OPIS")
    private String opis;
    @Column(name = "RG_ROOT")
    private String rgRoot;
    @Column(name = "ID_AKCIJE")
    private Long idAkcije;
    @Column(name = "ID_KAMPANJE")
    private String idKampanje;

    public BVMpAkcDopunskaTrebovanja() {
    }
    
    
        public BigDecimal getProdaja() {
        return prodaja;
    }

    public void setProdaja(BigDecimal prodaja) {
        this.prodaja = prodaja;
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

    public int getBrojDopune() {
        return brojDopune;
    }

    public void setBrojDopune(int brojDopune) {
        this.brojDopune = brojDopune;
    }

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    public String getRadnja() {
        return radnja;
    }

    public void setRadnja(String radnja) {
        this.radnja = radnja;
    }

    public String getMagacin() {
        return magacin;
    }

    public void setMagacin(String magacin) {
        this.magacin = magacin;
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

    public String getNazivArtikla() {
        return nazivArtikla;
    }

    public void setNazivArtikla(String nazivArtikla) {
        this.nazivArtikla = nazivArtikla;
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

    public String getDatumZalihe() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
         String time = sdf.format(datumZalihe);
        return time/*datum*/;
      //  return datumZalihe;
    }

    public void setDatumZalihe(Date datumZalihe) {
        this.datumZalihe = datumZalihe;
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

    public BigDecimal getNesredjenaKolicina() {
        return nesredjenaKolicina;
    }

    public void setNesredjenaKolicina(BigDecimal nesredjenaKolicina) {
        this.nesredjenaKolicina = nesredjenaKolicina;
    }

    public BigDecimal getSredjenaKolicina() {
        return sredjenaKolicina;
    }

    public void setSredjenaKolicina(BigDecimal sredjenaKolicina) {
        this.sredjenaKolicina = sredjenaKolicina;
    }

    public String getProjekcijaOd() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
         String time = sdf.format(projekcijaOd);
        return time/*datum*/;
      //  return projekcijaOd;
    }

    public void setProjekcijaOd(Date projekcijaOd) {
        this.projekcijaOd = projekcijaOd;
    }

    public String getProjekcijaDo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
         String time = sdf.format(projekcijaDo);
        return time/*datum*/;
       // return projekcijaDo;
    }

    public void setProjekcijaDo(Date projekcijaDo) {
        this.projekcijaDo = projekcijaDo;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getRgRoot() {
        return rgRoot;
    }

    public void setRgRoot(String rgRoot) {
        this.rgRoot = rgRoot;
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
    
}
