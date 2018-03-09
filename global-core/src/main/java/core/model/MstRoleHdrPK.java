package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MST_ROLE_HDR database table.
 * 
 */
public class MstRoleHdrPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String roleCode;
	private String positionCode;
	private String applProgCode;
	private String companyCode;

	public MstRoleHdrPK() {
	}

	public String getRoleCode() {
		return this.roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getPositionCode() {
		return this.positionCode;
	}
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public String getApplProgCode() {
		return this.applProgCode;
	}
	public void setApplProgCode(String applProgCode) {
		this.applProgCode = applProgCode;
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
		if (!(other instanceof MstRoleHdrPK)) {
			return false;
		}
		MstRoleHdrPK castOther = (MstRoleHdrPK)other;
		return 
			this.roleCode.equals(castOther.roleCode)
			&& this.positionCode.equals(castOther.positionCode)
			&& this.applProgCode.equals(castOther.applProgCode)
			&& this.companyCode.equals(castOther.companyCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.roleCode.hashCode();
		hash = hash * prime + this.positionCode.hashCode();
		hash = hash * prime + this.applProgCode.hashCode();
		hash = hash * prime + this.companyCode.hashCode();
		
		return hash;
	}
}