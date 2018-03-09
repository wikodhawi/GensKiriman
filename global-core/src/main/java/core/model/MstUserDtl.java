package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the MST_USER_DTL database table.
 * 
 */
@Entity
@Table(name="MST_USER_DTL")
@IdClass(MstUserDtlPK.class)
@NamedQuery(name="MstUserDtl.findAll", query="SELECT m FROM MstUserDtl m")
public class MstUserDtl implements Serializable {
	private static final long serialVersionUID = 1L;
	private String applProgCode;
	private String createdBy;
	private Date createdDate;
	private Date endDate;
	private String levelType;
	private Date startDate;
	private String updatedBy;
	private Date updatedDate;
	
	private String employeeCode;
	private String roleCode;
	private String branchCode;
	private String companyCode;

	public MstUserDtl() {
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
	@Column(name="ROLE_CODE")
	public String getRoleCode() {
		return this.roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@Id
	@Column(name="BRANCH_CODE")
	public String getBranchCode() {
		return this.branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	@Id
	@Column(name="COMPANY_CODE")
	public String getCompanyCode() {
		return this.companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name="APPL_PROG_CODE")
	public String getApplProgCode() {
		return this.applProgCode;
	}

	public void setApplProgCode(String applProgCode) {
		this.applProgCode = applProgCode;
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


	@Column(name="LEVEL_TYPE")
	public String getLevelType() {
		return this.levelType;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
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