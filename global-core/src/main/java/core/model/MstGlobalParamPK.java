package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MST_GLOBAL_PARAM database table.
 * 
 */
@Embeddable
public class MstGlobalParamPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String condition;
	private String paramCode;
	private java.util.Date startDate;

	public MstGlobalParamPK() {
	}

	public String getCondition() {
		return this.condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getParamCode() {
		return this.paramCode;
	}
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}


	public java.util.Date getStartDate() {
		return this.startDate;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MstGlobalParamPK)) {
			return false;
		}
		MstGlobalParamPK castOther = (MstGlobalParamPK)other;
		return 
			this.condition.equals(castOther.condition)
			&& this.paramCode.equals(castOther.paramCode)
			&& this.startDate.equals(castOther.startDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.condition.hashCode();
		hash = hash * prime + this.paramCode.hashCode();
		hash = hash * prime + this.startDate.hashCode();
		
		return hash;
	}
}