package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MST_GROUP_DEALER database table.
 * 
 */
public class MstGroupDealerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String groupDealerCode;

	public MstGroupDealerPK() {
	}

	public String getCompanyCode() {
		return this.companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getGroupDealerCode() {
		return this.groupDealerCode;
	}
	public void setGroupDealerCode(String groupDealerCode) {
		this.groupDealerCode = groupDealerCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MstGroupDealerPK)) {
			return false;
		}
		MstGroupDealerPK castOther = (MstGroupDealerPK)other;
		return 
			this.companyCode.equals(castOther.companyCode)
			&& this.groupDealerCode.equals(castOther.groupDealerCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyCode.hashCode();
		hash = hash * prime + this.groupDealerCode.hashCode();
		
		return hash;
	}
}