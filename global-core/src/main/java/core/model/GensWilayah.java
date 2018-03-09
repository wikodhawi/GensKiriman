package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the GENS_WILAYAH database table.
 * 
 */
@Entity
@Table(name = "GENS_WILAYAH")
@IdClass(GensWilayahPK.class)
@NamedQuery(name = "GensWilayah.findAll", query = "SELECT g FROM GensWilayah g")
public class GensWilayah implements Serializable {
	private static final long serialVersionUID = 1L;
	// private GensWilayahPK id;
	private String companyCode;
	private String kodeWilayah;
	private String createdBy;
	private Date createdDate;
	private double latitude;
	private double longitude;
	private String namaWilayah;
	private String updatedBy;
	private Date updatedDate;

	public GensWilayah() {
	}

	// @EmbeddedId
	// public GensWilayahPK getId() {
	// return this.id;
	// }
	//
	// public void setId(GensWilayahPK id) {
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
	@Column(name = "KODE_WILAYAH")
	public String getKodeWilayah() {
		return this.kodeWilayah;
	}

	public void setKodeWilayah(String kodeWilayah) {
		this.kodeWilayah = kodeWilayah;
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

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Column(name = "NAMA_WILAYAH")
	public String getNamaWilayah() {
		return this.namaWilayah;
	}

	public void setNamaWilayah(String namaWilayah) {
		this.namaWilayah = namaWilayah;
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