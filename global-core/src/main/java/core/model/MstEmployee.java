package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the MST_EMPLOYEE database table.
 * 
 */
@Entity
@Table(name="MST_EMPLOYEE")
@IdClass(MstEmployeePK.class)
@NamedQuery(name="MstEmployee.findAll", query="SELECT m FROM MstEmployee m")
public class MstEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	private String acctName;
	private String acctNo;
	private String address;
	private String bankBranchCode;
	private String bankCode;
	private String branchCode;
	private Date chgPositionDate;
	private String createdBy;
	private Date createdDate;
	private String email;
	private Date enterDate;
	private String firstName;
	private String headEmployee;
	private String hpNo;
	private String idNo;
	private String lastName;
	private String magnetProductive;
	private String middleName;
	private Date mutationStartDate;
	private String phoneNo;
	private String positionCode;
	private String prefixTitle;
	private Date resignDate;
	private String suffixTitle;
	private String updatedBy;
	private Date updatedDate;
	
	private String employeeCode;
	private String companyCode;

	public MstEmployee() {
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


	@Column(name="ACCT_NAME")
	public String getAcctName() {
		return this.acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}


	@Column(name="ACCT_NO")
	public String getAcctNo() {
		return this.acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Column(name="BANK_BRANCH_CODE")
	public String getBankBranchCode() {
		return this.bankBranchCode;
	}

	public void setBankBranchCode(String bankBranchCode) {
		this.bankBranchCode = bankBranchCode;
	}


	@Column(name="BANK_CODE")
	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}


	@Column(name="BRANCH_CODE")
	public String getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="CHG_POSITION_DATE")
	public Date getChgPositionDate() {
		return this.chgPositionDate;
	}

	public void setChgPositionDate(Date chgPositionDate) {
		this.chgPositionDate = chgPositionDate;
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


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="ENTER_DATE")
	public Date getEnterDate() {
		return this.enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}


	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Column(name="HEAD_EMPLOYEE")
	public String getHeadEmployee() {
		return this.headEmployee;
	}

	public void setHeadEmployee(String headEmployee) {
		this.headEmployee = headEmployee;
	}


	@Column(name="HP_NO")
	public String getHpNo() {
		return this.hpNo;
	}

	public void setHpNo(String hpNo) {
		this.hpNo = hpNo;
	}


	@Column(name="ID_NO")
	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}


	@Column(name="LAST_NAME")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Column(name="MAGNET_PRODUCTIVE")
	public String getMagnetProductive() {
		return this.magnetProductive;
	}

	public void setMagnetProductive(String magnetProductive) {
		this.magnetProductive = magnetProductive;
	}


	@Column(name="MIDDLE_NAME")
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="MUTATION_START_DATE")
	public Date getMutationStartDate() {
		return this.mutationStartDate;
	}

	public void setMutationStartDate(Date mutationStartDate) {
		this.mutationStartDate = mutationStartDate;
	}


	@Column(name="PHONE_NO")
	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	@Column(name="POSITION_CODE")
	public String getPositionCode() {
		return this.positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}


	@Column(name="PREFIX_TITLE")
	public String getPrefixTitle() {
		return this.prefixTitle;
	}

	public void setPrefixTitle(String prefixTitle) {
		this.prefixTitle = prefixTitle;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="RESIGN_DATE")
	public Date getResignDate() {
		return this.resignDate;
	}

	public void setResignDate(Date resignDate) {
		this.resignDate = resignDate;
	}


	@Column(name="SUFFIX_TITLE")
	public String getSuffixTitle() {
		return this.suffixTitle;
	}

	public void setSuffixTitle(String suffixTitle) {
		this.suffixTitle = suffixTitle;
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