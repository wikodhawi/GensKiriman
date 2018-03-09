package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GENS_ADMIN database table.
 * 
 */
@Embeddable
public class GensAdminPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String username;

	public GensAdminPK() {
	}

	public String getCompanyCode() {
		return this.companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GensAdminPK)) {
			return false;
		}
		GensAdminPK castOther = (GensAdminPK)other;
		return 
			this.companyCode.equals(castOther.companyCode)
			&& this.username.equals(castOther.username);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyCode.hashCode();
		hash = hash * prime + this.username.hashCode();
		
		return hash;
	}
}