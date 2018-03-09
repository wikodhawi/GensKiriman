package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MST_COLOR database table.
 * 
 */
@Embeddable
public class MstColorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String colorCode;

	public MstColorPK() {
	}

	public String getCompanyCode() {
		return this.companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getColorCode() {
		return this.colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MstColorPK)) {
			return false;
		}
		MstColorPK castOther = (MstColorPK)other;
		return 
			this.companyCode.equals(castOther.companyCode)
			&& this.colorCode.equals(castOther.colorCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyCode.hashCode();
		hash = hash * prime + this.colorCode.hashCode();
		
		return hash;
	}
}