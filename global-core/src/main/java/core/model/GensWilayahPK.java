package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GENS_WILAYAH database table.
 * 
 */
@Embeddable
public class GensWilayahPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String kodeWilayah;

	public GensWilayahPK() {
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getKodeWilayah() {
		return this.kodeWilayah;
	}

	public void setKodeWilayah(String kodeWilayah) {
		this.kodeWilayah = kodeWilayah;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GensWilayahPK)) {
			return false;
		}
		GensWilayahPK castOther = (GensWilayahPK) other;
		return this.companyCode.equals(castOther.companyCode)
				&& this.kodeWilayah.equals(castOther.kodeWilayah);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyCode.hashCode();
		hash = hash * prime + this.kodeWilayah.hashCode();

		return hash;
	}
}