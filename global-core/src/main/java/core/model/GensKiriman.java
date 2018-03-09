package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the GENS_KIRIMAN database table.
 * 
 */
@Entity
@Table(name = "GENS_KIRIMAN")
@IdClass(GensKirimanPK.class)
@NamedQuery(name = "GensKiriman.findAll", query = "SELECT g FROM GensKiriman g")
public class GensKiriman implements Serializable {
	private static final long serialVersionUID = 1L;
	// private GensKirimanPK id;
	private String companyCode;
	private String id;
	private String alamatAsal;
	private String alamatTujuan;
	private BigDecimal berat;
	private String createdBy;
	private Date createdDate;
	private BigDecimal hargaJenis;
	private BigDecimal hargaTotal;
	private String jenisKiriman;
	private String kodeWilayahAsal;
	private String kodeWilayahTujuan;
	private String namaPenerima;
	private String namaPengirim;
	private String updatedBy;
	private Date updatedDate;

	public GensKiriman() {
	}

	// @EmbeddedId
	// public GensKirimanPK getId() {
	// return this.id;
	// }
	//
	// public void setId(GensKirimanPK id) {
	// this.id = id;
	// }

	@Id
	@Column(name = "COMPANY_CODE")
	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Id
	@Column(name = "ID")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "ALAMAT_ASAL")
	public String getAlamatAsal() {
		return this.alamatAsal;
	}

	public void setAlamatAsal(String alamatAsal) {
		this.alamatAsal = alamatAsal;
	}

	@Column(name = "ALAMAT_TUJUAN")
	public String getAlamatTujuan() {
		return this.alamatTujuan;
	}

	public void setAlamatTujuan(String alamatTujuan) {
		this.alamatTujuan = alamatTujuan;
	}

	public BigDecimal getBerat() {
		return this.berat;
	}

	public void setBerat(BigDecimal berat) {
		this.berat = berat;
	}

	@Column(name = "CREATED_BY")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "HARGA_JENIS")
	public BigDecimal getHargaJenis() {
		return this.hargaJenis;
	}

	public void setHargaJenis(BigDecimal hargaJenis) {
		this.hargaJenis = hargaJenis;
	}

	@Column(name = "HARGA_TOTAL")
	public BigDecimal getHargaTotal() {
		return this.hargaTotal;
	}

	public void setHargaTotal(BigDecimal hargaTotal) {
		this.hargaTotal = hargaTotal;
	}

	@Column(name = "JENIS_KIRIMAN")
	public String getJenisKiriman() {
		return this.jenisKiriman;
	}

	public void setJenisKiriman(String jenisKiriman) {
		this.jenisKiriman = jenisKiriman;
	}

	@Column(name = "KODE_WILAYAH_ASAL")
	public String getKodeWilayahAsal() {
		return this.kodeWilayahAsal;
	}

	public void setKodeWilayahAsal(String kodeWilayahAsal) {
		this.kodeWilayahAsal = kodeWilayahAsal;
	}

	@Column(name = "KODE_WILAYAH_TUJUAN")
	public String getKodeWilayahTujuan() {
		return this.kodeWilayahTujuan;
	}

	public void setKodeWilayahTujuan(String kodeWilayahTujuan) {
		this.kodeWilayahTujuan = kodeWilayahTujuan;
	}

	@Column(name = "NAMA_PENERIMA")
	public String getNamaPenerima() {
		return this.namaPenerima;
	}

	public void setNamaPenerima(String namaPenerima) {
		this.namaPenerima = namaPenerima;
	}

	@Column(name = "NAMA_PENGIRIM")
	public String getNamaPengirim() {
		return this.namaPengirim;
	}

	public void setNamaPengirim(String namaPengirim) {
		this.namaPengirim = namaPengirim;
	}

	@Column(name = "UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}