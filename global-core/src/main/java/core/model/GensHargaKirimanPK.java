package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GENS_HARGA_KIRIMAN database table.
 * 
 */
@Embeddable
public class GensHargaKirimanPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String kodeKiriman;

	public GensHargaKirimanPK() {
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getKodeKiriman() {
		return this.kodeKiriman;
	}

	public void setKodeKiriman(String kodeKiriman) {
		this.kodeKiriman = kodeKiriman;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GensHargaKirimanPK)) {
			return false;
		}
		GensHargaKirimanPK castOther = (GensHargaKirimanPK) other;
		return this.companyCode.equals(castOther.companyCode)
				&& this.kodeKiriman.equals(castOther.kodeKiriman);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyCode.hashCode();
		hash = hash * prime + this.kodeKiriman.hashCode();

		return hash;
	}
}