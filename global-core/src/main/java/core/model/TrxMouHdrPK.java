package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TRX_MOU_HDR database table.
 * 
 */
@Embeddable
public class TrxMouHdrPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String proposalNo;
	private String mouNo;
	private String proposalType;

	public TrxMouHdrPK() {
	}

	@Column(name="COMPANY_CODE")
	public String getCompanyCode() {
		return this.companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name="PROPOSAL_NO")
	public String getProposalNo() {
		return this.proposalNo;
	}
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}

	@Column(name="MOU_NO")
	public String getMouNo() {
		return this.mouNo;
	}
	public void setMouNo(String mouNo) {
		this.mouNo = mouNo;
	}

	@Column(name="PROPOSAL_TYPE")
	public String getProposalType() {
		return this.proposalType;
	}
	public void setProposalType(String proposalType) {
		this.proposalType = proposalType;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TrxMouHdrPK)) {
			return false;
		}
		TrxMouHdrPK castOther = (TrxMouHdrPK)other;
		return 
			this.companyCode.equals(castOther.companyCode)
			&& this.proposalNo.equals(castOther.proposalNo)
			&& this.mouNo.equals(castOther.mouNo)
			&& this.proposalType.equals(castOther.proposalType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyCode.hashCode();
		hash = hash * prime + this.proposalNo.hashCode();
		hash = hash * prime + this.mouNo.hashCode();
		hash = hash * prime + this.proposalType.hashCode();
		
		return hash;
	}
}