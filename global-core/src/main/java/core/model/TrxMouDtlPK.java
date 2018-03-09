package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TRX_MOU_DTL database table.
 * 
 */
@Embeddable
public class TrxMouDtlPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String proposalNo;
	private String dealerCode;

	public TrxMouDtlPK() {
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

	@Column(name="DEALER_CODE")
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
		if (!(other instanceof TrxMouDtlPK)) {
			return false;
		}
		TrxMouDtlPK castOther = (TrxMouDtlPK)other;
		return 
			this.companyCode.equals(castOther.companyCode)
			&& this.proposalNo.equals(castOther.proposalNo)
			&& this.dealerCode.equals(castOther.dealerCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyCode.hashCode();
		hash = hash * prime + this.proposalNo.hashCode();
		hash = hash * prime + this.dealerCode.hashCode();
		
		return hash;
	}
}