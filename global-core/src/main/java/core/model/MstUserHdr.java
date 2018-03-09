package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the MST_USER_HDR database table.
 * 
 */
@Entity
@Table(name="MST_USER_HDR")
@IdClass(MstUserHdrPK.class)
@NamedQuery(name="MstUserHdr.findAll", query="SELECT m FROM MstUserHdr m")
public class MstUserHdr implements Serializable {
	private static final long serialVersionUID = 1L;

	private String createdBy;
	private Date createdDate;
	private String defaultBranchCode;
	private String flagActive;
	private String levelBgtCode;
	private String levelBgtType;
	private String password;
	private String preferedLocale;
	private String subBranchCode;
	private String updatedBy;
	private Date updatedDate;
	private String employeeCode;
	private String companyCode;


	public MstUserHdr() {
	}

	@Id
	@Column(name="EMPLOYEE_CODE")
	public String getEmployeeCode() {
		return this.employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	@Id
	@Column(name="COMPANY_CODE")
	public String getCompanyCode() {
		return this.companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
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


	@Column(name="DEFAULT_BRANCH_CODE")
	public String getDefaultBranchCode() {
		return this.defaultBranchCode;
	}

	public void setDefaultBranchCode(String defaultBranchCode) {
		this.defaultBranchCode = defaultBranchCode;
	}


	@Column(name="FLAG_ACTIVE")
	public String getFlagActive() {
		return this.flagActive;
	}

	public void setFlagActive(String flagActive) {
		this.flagActive = flagActive;
	}


	@Column(name="LEVEL_BGT_CODE")
	public String getLevelBgtCode() {
		return this.levelBgtCode;
	}

	public void setLevelBgtCode(String levelBgtCode) {
		this.levelBgtCode = levelBgtCode;
	}


	@Column(name="LEVEL_BGT_TYPE")
	public String getLevelBgtType() {
		return this.levelBgtType;
	}

	public void setLevelBgtType(String levelBgtType) {
		this.levelBgtType = levelBgtType;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column(name="PREFERED_LOCALE")
	public String getPreferedLocale() {
		return this.preferedLocale;
	}

	public void setPreferedLocale(String preferedLocale) {
		this.preferedLocale = preferedLocale;
	}


	@Column(name="SUB_BRANCH_CODE")
	public String getSubBranchCode() {
		return this.subBranchCode;
	}

	public void setSubBranchCode(String subBranchCode) {
		this.subBranchCode = subBranchCode;
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