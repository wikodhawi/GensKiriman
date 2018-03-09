package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GENS_KIRIMAN database table.
 * 
 */
@Embeddable
public class GensKirimanPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String id;

	public GensKirimanPK() {
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GensKirimanPK)) {
			return false;
		}
		GensKirimanPK castOther = (GensKirimanPK) other;
		return this.companyCode.equals(castOther.companyCode)
				&& this.id.equals(castOther.id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyCode.hashCode();
		hash = hash * prime + this.id.hashCode();

		return hash;
	}
}