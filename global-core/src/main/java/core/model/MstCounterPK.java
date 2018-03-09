package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MST_COUNTER database table.
 * 
 */
@Embeddable
public class MstCounterPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String trxCode;
	private String branchCode;
	private String cashBankCode;
	private String directPrefix;
	private long year;
	private long month;
	private long day;

	public MstCounterPK() {
	}

	public String getCompanyCode() {
		return this.companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getTrxCode() {
		return this.trxCode;
	}
	public void setTrxCode(String trxCode) {
		this.trxCode = trxCode;
	}

	public String getBranchCode() {
		return this.branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getCashBankCode() {
		return this.cashBankCode;
	}
	public void setCashBankCode(String cashBankCode) {
		this.cashBankCode = cashBankCode;
	}

	public String getDirectPrefix() {
		return this.directPrefix;
	}
	public void setDirectPrefix(String directPrefix) {
		this.directPrefix = directPrefix;
	}

	public long getYear() {
		return this.year;
	}
	public void setYear(long year) {
		this.year = year;
	}

	public long getMonth() {
		return this.month;
	}
	public void setMonth(long month) {
		this.month = month;
	}

	public long getDay() {
		return this.day;
	}
	public void setDay(long day) {
		this.day = day;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MstCounterPK)) {
			return false;
		}
		MstCounterPK castOther = (MstCounterPK)other;
		return 
			this.companyCode.equals(castOther.companyCode)
			&& this.trxCode.equals(castOther.trxCode)
			&& this.branchCode.equals(castOther.branchCode)
			&& this.cashBankCode.equals(castOther.cashBankCode)
			&& this.directPrefix.equals(castOther.directPrefix)
			&& (this.year == castOther.year)
			&& (this.month == castOther.month)
			&& (this.day == castOther.day);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyCode.hashCode();
		hash = hash * prime + this.trxCode.hashCode();
		hash = hash * prime + this.branchCode.hashCode();
		hash = hash * prime + this.cashBankCode.hashCode();
		hash = hash * prime + this.directPrefix.hashCode();
		hash = hash * prime + ((int) (this.year ^ (this.year >>> 32)));
		hash = hash * prime + ((int) (this.month ^ (this.month >>> 32)));
		hash = hash * prime + ((int) (this.day ^ (this.day >>> 32)));
		
		return hash;
	}
}