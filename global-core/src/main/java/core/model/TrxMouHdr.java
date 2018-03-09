package core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TRX_MOU_HDR database table.
 * 
 */
@Entity
@Table(name="TRX_MOU_HDR")
@NamedQuery(name="TrxMouHdr.findAll", query="SELECT t FROM TrxMouHdr t")
public class TrxMouHdr implements Serializable {
	private static final long serialVersionUID = 1L;
	private TrxMouHdrPK id;
	private String appvSts;
	private String branchCode;
	private String createdBy;
	private Date createdDate;
	private String dealerCategory;
	private Date endMouDate;
	private String extensionSts;
	private String firstPartyNik1;
	private String firstPartyNik2;
	private String firstPartyPosition1;
	private String firstPartyPosition2;
	private String flagPrint;
	private String groupDealerCode;
	private String mouRecommendation;
	private String notesRecommend;
	private Date printDate;
	private Date proposalDate;
	private String refProposalNo;
	private String regionalCode;
	private String secPartIdNo1;
	private String secPartyHp1;
	private String secPartyHp2;
	private String secPartyIdNo2;
	private String secPartyName1;
	private String secPartyName2;
	private String secPartyPhoneArea1;
	private String secPartyPhoneArea2;
	private String secPartyPhoneNo1;
	private String secPartyPhoneNo2;
	private String secPartyPosition1;
	private String secPartyPosition2;
	private Date startMouDate;
	private String updatedBy;
	private Date updatedDate;

	public TrxMouHdr() {
	}


	@EmbeddedId
	public TrxMouHdrPK getId() {
		return this.id;
	}

	public void setId(TrxMouHdrPK id) {
		this.id = id;
	}


	@Column(name="APPV_STS")
	public String getAppvSts() {
		return this.appvSts;
	}

	public void setAppvSts(String appvSts) {
		this.appvSts = appvSts;
	}


	@Column(name="BRANCH_CODE")
	public String getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}


	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	@Column(name="DEALER_CATEGORY")
	public String getDealerCategory() {
		return this.dealerCategory;
	}

	public void setDealerCategory(String dealerCategory) {
		this.dealerCategory = dealerCategory;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="END_MOU_DATE")
	public Date getEndMouDate() {
		return this.endMouDate;
	}

	public void setEndMouDate(Date endMouDate) {
		this.endMouDate = endMouDate;
	}


	@Column(name="EXTENSION_STS")
	public String getExtensionSts() {
		return this.extensionSts;
	}

	public void setExtensionSts(String extensionSts) {
		this.extensionSts = extensionSts;
	}


	@Column(name="FIRST_PARTY_NIK1")
	public String getFirstPartyNik1() {
		return this.firstPartyNik1;
	}

	public void setFirstPartyNik1(String firstPartyNik1) {
		this.firstPartyNik1 = firstPartyNik1;
	}


	@Column(name="FIRST_PARTY_NIK2")
	public String getFirstPartyNik2() {
		return this.firstPartyNik2;
	}

	public void setFirstPartyNik2(String firstPartyNik2) {
		this.firstPartyNik2 = firstPartyNik2;
	}


	@Column(name="FIRST_PARTY_POSITION1")
	public String getFirstPartyPosition1() {
		return this.firstPartyPosition1;
	}

	public void setFirstPartyPosition1(String firstPartyPosition1) {
		this.firstPartyPosition1 = firstPartyPosition1;
	}


	@Column(name="FIRST_PARTY_POSITION2")
	public String getFirstPartyPosition2() {
		return this.firstPartyPosition2;
	}

	public void setFirstPartyPosition2(String firstPartyPosition2) {
		this.firstPartyPosition2 = firstPartyPosition2;
	}


	@Column(name="FLAG_PRINT")
	public String getFlagPrint() {
		return this.flagPrint;
	}

	public void setFlagPrint(String flagPrint) {
		this.flagPrint = flagPrint;
	}


	@Column(name="GROUP_DEALER_CODE")
	public String getGroupDealerCode() {
		return this.groupDealerCode;
	}

	public void setGroupDealerCode(String groupDealerCode) {
		this.groupDealerCode = groupDealerCode;
	}


	@Column(name="MOU_RECOMMENDATION")
	public String getMouRecommendation() {
		return this.mouRecommendation;
	}

	public void setMouRecommendation(String mouRecommendation) {
		this.mouRecommendation = mouRecommendation;
	}


	@Column(name="NOTES_RECOMMEND")
	public String getNotesRecommend() {
		return this.notesRecommend;
	}

	public void setNotesRecommend(String notesRecommend) {
		this.notesRecommend = notesRecommend;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="PRINT_DATE")
	public Date getPrintDate() {
		return this.printDate;
	}

	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="PROPOSAL_DATE")
	public Date getProposalDate() {
		return this.proposalDate;
	}

	public void setProposalDate(Date proposalDate) {
		this.proposalDate = proposalDate;
	}


	@Column(name="REF_PROPOSAL_NO")
	public String getRefProposalNo() {
		return this.refProposalNo;
	}

	public void setRefProposalNo(String refProposalNo) {
		this.refProposalNo = refProposalNo;
	}


	@Column(name="REGIONAL_CODE")
	public String getRegionalCode() {
		return this.regionalCode;
	}

	public void setRegionalCode(String regionalCode) {
		this.regionalCode = regionalCode;
	}


	@Column(name="SEC_PART_ID_NO1")
	public String getSecPartIdNo1() {
		return this.secPartIdNo1;
	}

	public void setSecPartIdNo1(String secPartIdNo1) {
		this.secPartIdNo1 = secPartIdNo1;
	}


	@Column(name="SEC_PARTY_HP1")
	public String getSecPartyHp1() {
		return this.secPartyHp1;
	}

	public void setSecPartyHp1(String secPartyHp1) {
		this.secPartyHp1 = secPartyHp1;
	}


	@Column(name="SEC_PARTY_HP2")
	public String getSecPartyHp2() {
		return this.secPartyHp2;
	}

	public void setSecPartyHp2(String secPartyHp2) {
		this.secPartyHp2 = secPartyHp2;
	}


	@Column(name="SEC_PARTY_ID_NO2")
	public String getSecPartyIdNo2() {
		return this.secPartyIdNo2;
	}

	public void setSecPartyIdNo2(String secPartyIdNo2) {
		this.secPartyIdNo2 = secPartyIdNo2;
	}


	@Column(name="SEC_PARTY_NAME1")
	public String getSecPartyName1() {
		return this.secPartyName1;
	}

	public void setSecPartyName1(String secPartyName1) {
		this.secPartyName1 = secPartyName1;
	}


	@Column(name="SEC_PARTY_NAME2")
	public String getSecPartyName2() {
		return this.secPartyName2;
	}

	public void setSecPartyName2(String secPartyName2) {
		this.secPartyName2 = secPartyName2;
	}


	@Column(name="SEC_PARTY_PHONE_AREA1")
	public String getSecPartyPhoneArea1() {
		return this.secPartyPhoneArea1;
	}

	public void setSecPartyPhoneArea1(String secPartyPhoneArea1) {
		this.secPartyPhoneArea1 = secPartyPhoneArea1;
	}


	@Column(name="SEC_PARTY_PHONE_AREA2")
	public String getSecPartyPhoneArea2() {
		return this.secPartyPhoneArea2;
	}

	public void setSecPartyPhoneArea2(String secPartyPhoneArea2) {
		this.secPartyPhoneArea2 = secPartyPhoneArea2;
	}


	@Column(name="SEC_PARTY_PHONE_NO1")
	public String getSecPartyPhoneNo1() {
		return this.secPartyPhoneNo1;
	}

	public void setSecPartyPhoneNo1(String secPartyPhoneNo1) {
		this.secPartyPhoneNo1 = secPartyPhoneNo1;
	}


	@Column(name="SEC_PARTY_PHONE_NO2")
	public String getSecPartyPhoneNo2() {
		return this.secPartyPhoneNo2;
	}

	public void setSecPartyPhoneNo2(String secPartyPhoneNo2) {
		this.secPartyPhoneNo2 = secPartyPhoneNo2;
	}


	@Column(name="SEC_PARTY_POSITION1")
	public String getSecPartyPosition1() {
		return this.secPartyPosition1;
	}

	public void setSecPartyPosition1(String secPartyPosition1) {
		this.secPartyPosition1 = secPartyPosition1;
	}


	@Column(name="SEC_PARTY_POSITION2")
	public String getSecPartyPosition2() {
		return this.secPartyPosition2;
	}

	public void setSecPartyPosition2(String secPartyPosition2) {
		this.secPartyPosition2 = secPartyPosition2;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="START_MOU_DATE")
	public Date getStartMouDate() {
		return this.startMouDate;
	}

	public void setStartMouDate(Date startMouDate) {
		this.startMouDate = startMouDate;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}