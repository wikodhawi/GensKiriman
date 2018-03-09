package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MST_DEALER database table.
 * 
 */

public class MstDealerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String groupDealerCode;
	private String dealerCode;

	public MstDealerPK() {
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

	public String getDealerCode() {
		return this.dealerCode;
	}
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MstDealerPK)) {
			return false;
		}
		MstDealerPK castOther = (MstDealerPK)other;
		return 
			this.companyCode.equals(castOther.companyCode)
			&& this.groupDealerCode.equals(castOther.groupDealerCode)
			&& this.dealerCode.equals(castOther.dealerCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyCode.hashCode();
		hash = hash * prime + this.groupDealerCode.hashCode();
		hash = hash * prime + this.dealerCode.hashCode();
		
		return hash;
	}
}