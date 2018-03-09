package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MST_DEALER database table.
 * 
 */
@Entity
@Table(name="MST_DEALER")
@IdClass(MstDealerPK.class)
@NamedQuery(name="MstDealer.findAll", query="SELECT m FROM MstDealer m")
public class MstDealer implements Serializable {
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String groupDealerCode;
	private String dealerCode;
	
	private String address;
	private String categoryCode;
	private String corporate;
	private String createdBy;
	private Date createdDate;
	private String dealerCategory;
	private String dealerClass;
	private String dealerKind;
	private String dealerName;
	private String dealerType;
	private BigDecimal dueDaysPay;
	private BigDecimal dueMonthsBpkb;
	private String emailPic;
	private Date endMouDate;
	private String faxArea;
	private String faxNo;
	private String flagPph;
	private String hpNoPic;
	private String kelCode;
	private String mouNo;
	private String npwpName;
	private String npwpNo;
	private String npwpType;
	private String phoneArea1;
	private String phoneArea2;
	private String phoneNo1;
	private String phoneNo2;
	private String picName;
	private String rt;
	private String rw;
	private Date startMouDate;
	private String tradeName;
	private String updatedBy;
	private Date updatedDate;

	public MstDealer() {
	}


	@Id
	@Column(name="COMPANY_CODE")
	public String getCompanyCode() {
		return this.companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@Id
	@Column(name="GROUP_DEALER_CODE")
	public String getGroupDealerCode() {
		return this.groupDealerCode;
	}
	public void setGroupDealerCode(String groupDealerCode) {
		this.groupDealerCode = groupDealerCode;
	}

	@Id
	@Column(name="DEALER_CODE")
	public String getDealerCode() {
		return this.dealerCode;
	}
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Column(name="CATEGORY_CODE")
	public String getCategoryCode() {
		return this.categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}


	public String getCorporate() {
		return this.corporate;
	}

	public void setCorporate(String corporate) {
		this.corporate = corporate;
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


	@Column(name="DEALER_CLASS")
	public String getDealerClass() {
		return this.dealerClass;
	}

	public void setDealerClass(String dealerClass) {
		this.dealerClass = dealerClass;
	}


	@Column(name="DEALER_KIND")
	public String getDealerKind() {
		return this.dealerKind;
	}

	public void setDealerKind(String dealerKind) {
		this.dealerKind = dealerKind;
	}


	@Column(name="DEALER_NAME")
	public String getDealerName() {
		return this.dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}


	@Column(name="DEALER_TYPE")
	public String getDealerType() {
		return this.dealerType;
	}

	public void setDealerType(String dealerType) {
		this.dealerType = dealerType;
	}


	@Column(name="DUE_DAYS_PAY")
	public BigDecimal getDueDaysPay() {
		return this.dueDaysPay;
	}

	public void setDueDaysPay(BigDecimal dueDaysPay) {
		this.dueDaysPay = dueDaysPay;
	}


	@Column(name="DUE_MONTHS_BPKB")
	public BigDecimal getDueMonthsBpkb() {
		return this.dueMonthsBpkb;
	}

	public void setDueMonthsBpkb(BigDecimal dueMonthsBpkb) {
		this.dueMonthsBpkb = dueMonthsBpkb;
	}


	@Column(name="EMAIL_PIC")
	public String getEmailPic() {
		return this.emailPic;
	}

	public void setEmailPic(String emailPic) {
		this.emailPic = emailPic;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="END_MOU_DATE")
	public Date getEndMouDate() {
		return this.endMouDate;
	}

	public void setEndMouDate(Date endMouDate) {
		this.endMouDate = endMouDate;
	}


	@Column(name="FAX_AREA")
	public String getFaxArea() {
		return this.faxArea;
	}

	public void setFaxArea(String faxArea) {
		this.faxArea = faxArea;
	}


	@Column(name="FAX_NO")
	public String getFaxNo() {
		return this.faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}


	@Column(name="FLAG_PPH")
	public String getFlagPph() {
		return this.flagPph;
	}

	public void setFlagPph(String flagPph) {
		this.flagPph = flagPph;
	}


	@Column(name="HP_NO_PIC")
	public String getHpNoPic() {
		return this.hpNoPic;
	}

	public void setHpNoPic(String hpNoPic) {
		this.hpNoPic = hpNoPic;
	}


	@Column(name="KEL_CODE")
	public String getKelCode() {
		return this.kelCode;
	}

	public void setKelCode(String kelCode) {
		this.kelCode = kelCode;
	}


	@Column(name="MOU_NO")
	public String getMouNo() {
		return this.mouNo;
	}

	public void setMouNo(String mouNo) {
		this.mouNo = mouNo;
	}


	@Column(name="NPWP_NAME")
	public String getNpwpName() {
		return this.npwpName;
	}

	public void setNpwpName(String npwpName) {
		this.npwpName = npwpName;
	}


	@Column(name="NPWP_NO")
	public String getNpwpNo() {
		return this.npwpNo;
	}

	public void setNpwpNo(String npwpNo) {
		this.npwpNo = npwpNo;
	}


	@Column(name="NPWP_TYPE")
	public String getNpwpType() {
		return this.npwpType;
	}

	public void setNpwpType(String npwpType) {
		this.npwpType = npwpType;
	}


	@Column(name="PHONE_AREA1")
	public String getPhoneArea1() {
		return this.phoneArea1;
	}

	public void setPhoneArea1(String phoneArea1) {
		this.phoneArea1 = phoneArea1;
	}


	@Column(name="PHONE_AREA2")
	public String getPhoneArea2() {
		return this.phoneArea2;
	}

	public void setPhoneArea2(String phoneArea2) {
		this.phoneArea2 = phoneArea2;
	}


	@Column(name="PHONE_NO1")
	public String getPhoneNo1() {
		return this.phoneNo1;
	}

	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}


	@Column(name="PHONE_NO2")
	public String getPhoneNo2() {
		return this.phoneNo2;
	}

	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}


	@Column(name="PIC_NAME")
	public String getPicName() {
		return this.picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}


	public String getRt() {
		return this.rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}


	public String getRw() {
		return this.rw;
	}

	public void setRw(String rw) {
		this.rw = rw;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="START_MOU_DATE")
	public Date getStartMouDate() {
		return this.startMouDate;
	}

	public void setStartMouDate(Date startMouDate) {
		this.startMouDate = startMouDate;
	}


	@Column(name="TRADE_NAME")
	public String getTradeName() {
		return this.tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
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