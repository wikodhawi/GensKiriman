package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MST_USER_DTL database table.
 * 
 */
public class MstUserDtlPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String employeeCode;
	private String roleCode;
	private String branchCode;
	private String companyCode;

	public MstUserDtlPK() {
	}

	public String getEmployeeCode() {
		return this.employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getRoleCode() {
		return this.roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getBranchCode() {
		return this.branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getCompanyCode() {
		return this.companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MstUserDtlPK)) {
			return false;
		}
		MstUserDtlPK castOther = (MstUserDtlPK)other;
		return 
			this.employeeCode.equals(castOther.employeeCode)
			&& this.roleCode.equals(castOther.roleCode)
			&& this.branchCode.equals(castOther.branchCode)
			&& this.companyCode.equals(castOther.companyCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.employeeCode.hashCode();
		hash = hash * prime + this.roleCode.hashCode();
		hash = hash * prime + this.branchCode.hashCode();
		hash = hash * prime + this.companyCode.hashCode();
		
		return hash;
	}
}