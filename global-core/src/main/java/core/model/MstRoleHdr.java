package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the MST_ROLE_HDR database table.
 * 
 */
@Entity
@Table(name="MST_ROLE_HDR")
@IdClass(MstRoleHdrPK.class)
@NamedQuery(name="MstRoleHdr.findAll", query="SELECT m FROM MstRoleHdr m")
public class MstRoleHdr implements Serializable {
	private static final long serialVersionUID = 1L;
	private String createdBy;
	private Date createdDate;
	private String flagActive;
	private String flagDefault;
	private String levelType;
	private String roleDescrip;
	private String roleName;
	private String updatedBy;
	private Date updatedDate;
	
	private String roleCode;
	private String positionCode;
	private String applProgCode;
	private String companyCode;

	public MstRoleHdr() {
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
	@Column(name="POSITION_CODE")
	public String getPositionCode() {
		return this.positionCode;
	}
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	@Id
	@Column(name="APPL_PROG_CODE")
	public String getApplProgCode() {
		return this.applProgCode;
	}
	public void setApplProgCode(String applProgCode) {
		this.applProgCode = applProgCode;
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


	@Column(name="FLAG_ACTIVE")
	public String getFlagActive() {
		return this.flagActive;
	}

	public void setFlagActive(String flagActive) {
		this.flagActive = flagActive;
	}


	@Column(name="FLAG_DEFAULT")
	public String getFlagDefault() {
		return this.flagDefault;
	}

	public void setFlagDefault(String flagDefault) {
		this.flagDefault = flagDefault;
	}


	@Column(name="LEVEL_TYPE")
	public String getLevelType() {
		return this.levelType;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}


	@Column(name="ROLE_DESCRIP")
	public String getRoleDescrip() {
		return this.roleDescrip;
	}

	public void setRoleDescrip(String roleDescrip) {
		this.roleDescrip = roleDescrip;
	}


	@Column(name="ROLE_NAME")
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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