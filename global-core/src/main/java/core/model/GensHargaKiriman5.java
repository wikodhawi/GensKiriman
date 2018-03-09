package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the GENS_HARGA_KIRIMAN database table.
 * 
 */
@Entity
@Table(name = "GENS_HARGA_KIRIMAN")
@IdClass(GensHargaKirimanPK5.class)
@NamedQuery(name = "GensHargaKiriman5.findAll", query = "SELECT g FROM GensHargaKiriman5 g")
public class GensHargaKiriman5 implements Serializable {
	private static final long serialVersionUID = 1L;
	// private GensHargaKirimanPK id;
	private String companyCode;
	private String kodeKiriman;
	private String createdBy;
	private Date createdDate;
	private BigDecimal hargaPerSkor;
	private String jenisKiriman;
	private String updatedBy;
	private Date updatedDate;

	public GensHargaKiriman5() {
	}

	// @EmbeddedId
	// public GensHargaKirimanPK getId() {
	// return this.id;
	// }
	//
	// public void setId(GensHargaKirimanPK id) {
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
	@Column(name = "KODE_KIRIMAN")
	public String getKodeKiriman() {
		return this.kodeKiriman;
	}

	public void setKodeKiriman(String kodeKiriman) {
		this.kodeKiriman = kodeKiriman;
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

	@Column(name = "HARGA_PER_SKOR")
	public BigDecimal getHargaPerSkor() {
		return this.hargaPerSkor;
	}

	public void setHargaPerSkor(BigDecimal hargaPerSkor) {
		this.hargaPerSkor = hargaPerSkor;
	}

	@Column(name = "JENIS_KIRIMAN")
	public String getJenisKiriman() {
		return this.jenisKiriman;
	}

	public void setJenisKiriman(String jenisKiriman) {
		this.jenisKiriman = jenisKiriman;
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