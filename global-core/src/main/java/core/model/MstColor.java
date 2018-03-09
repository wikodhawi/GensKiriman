package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the MST_COLOR database table.
 * 
 */
@Entity
@Table(name="MST_COLOR")
@IdClass(MstColorPK.class)
@NamedQuery(name="MstColor.findAll", query="SELECT m FROM MstColor m")
public class MstColor implements Serializable {
	private static final long serialVersionUID = 1L;

	private String companyCode;
	private String colorCode;
	
	private String aliasName;
	private String appvSts;
	private String batchNo;
	private String colorDescrip;
	private String createdBy;
	private Date createdDate;
	private Date endDate;
	private String flagUpload;
	private Date startDate;
	private String updatedBy;
	private Date updatedDate;

	public MstColor() {
	}

	@Id
	@Column(name="COMPANY_CODE")
	public String getCompanyCode() {
		return this.companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Id
	@Column(name="COLOR_CODE")
	public String getColorCode() {
		return this.colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}


	@Column(name="ALIAS_NAME")
	public String getAliasName() {
		return this.aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}


	@Column(name="APPV_STS")
	public String getAppvSts() {
		return this.appvSts;
	}

	public void setAppvSts(String appvSts) {
		this.appvSts = appvSts;
	}


	@Column(name="BATCH_NO")
	public String getBatchNo() {
		return this.batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}


	@Column(name="COLOR_DESCRIP")
	public String getColorDescrip() {
		return this.colorDescrip;
	}

	public void setColorDescrip(String colorDescrip) {
		this.colorDescrip = colorDescrip;
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
	@Column(name="END_DATE")
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	@Column(name="FLAG_UPLOAD")
	public String getFlagUpload() {
		return this.flagUpload;
	}

	public void setFlagUpload(String flagUpload) {
		this.flagUpload = flagUpload;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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

}