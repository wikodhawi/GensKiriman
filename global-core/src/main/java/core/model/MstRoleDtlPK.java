package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MST_ROLE_DTL database table.
 * 
 */

public class MstRoleDtlPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String actionName;
	private String menuCode;
	private String roleCode;
	private String companyCode;

	public MstRoleDtlPK() {
	}

	public String getActionName() {
		return this.actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getMenuCode() {
		return this.menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getRoleCode() {
		return this.roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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
		if (!(other instanceof MstRoleDtlPK)) {
			return false;
		}
		MstRoleDtlPK castOther = (MstRoleDtlPK)other;
		return 
			this.actionName.equals(castOther.actionName)
			&& this.menuCode.equals(castOther.menuCode)
			&& this.roleCode.equals(castOther.roleCode)
			&& this.companyCode.equals(castOther.companyCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.actionName.hashCode();
		hash = hash * prime + this.menuCode.hashCode();
		hash = hash * prime + this.roleCode.hashCode();
		hash = hash * prime + this.companyCode.hashCode();
		
		return hash;
	}
}