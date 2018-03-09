package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MST_EMPLOYEE database table.
 * 
 */
@Embeddable
public class MstEmployeePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String employeeCode;
	private String companyCode;

	public MstEmployeePK() {
	}

	public String getEmployeeCode() {
		return this.employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
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
		if (!(other instanceof MstEmployeePK)) {
			return false;
		}
		MstEmployeePK castOther = (MstEmployeePK)other;
		return 
			this.employeeCode.equals(castOther.employeeCode)
			&& this.companyCode.equals(castOther.companyCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.employeeCode.hashCode();
		hash = hash * prime + this.companyCode.hashCode();
		
		return hash;
	}
}