package core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the MST_COMPANY database table.
 * 
 */
@Entity
@Table(name="MST_COMPANY")
@NamedQuery(name="MstCompany.findAll", query="SELECT m FROM MstCompany m")
public class MstCompany implements Serializable {
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String address;
	private String cityCode;
	private String companyName;
	private String createdBy;
	private Date createdDate;
	private Date dateEod;
	private String flagActive;
	private byte[] image;
	private String kecCode;
	private String kelCode;
	private String npwpNo;
	private String provCode;
	private String updatedBy;
	private Date updatedDate;
	private String zipcode;

	public MstCompany() {
	}


	@Id
	@Column(name="COMPANY_CODE")
	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Column(name="CITY_CODE")
	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}


	@Column(name="COMPANY_NAME")
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="DATE_EOD")
	public Date getDateEod() {
		return this.dateEod;
	}

	public void setDateEod(Date dateEod) {
		this.dateEod = dateEod;
	}


	@Column(name="FLAG_ACTIVE")
	public String getFlagActive() {
		return this.flagActive;
	}

	public void setFlagActive(String flagActive) {
		this.flagActive = flagActive;
	}


	@Lob
	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}


	@Column(name="KEC_CODE")
	public String getKecCode() {
		return this.kecCode;
	}

	public void setKecCode(String kecCode) {
		this.kecCode = kecCode;
	}


	@Column(name="KEL_CODE")
	public String getKelCode() {
		return this.kelCode;
	}

	public void setKelCode(String kelCode) {
		this.kelCode = kelCode;
	}


	@Column(name="NPWP_NO")
	public String getNpwpNo() {
		return this.npwpNo;
	}

	public void setNpwpNo(String npwpNo) {
		this.npwpNo = npwpNo;
	}


	@Column(name="PROV_CODE")
	public String getProvCode() {
		return this.provCode;
	}

	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}