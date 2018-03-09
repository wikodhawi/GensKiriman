package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the MST_GROUP_DEALER database table.
 * 
 */
@Entity
@Table(name="MST_GROUP_DEALER")
@IdClass(MstGroupDealerPK.class)
@NamedQuery(name="MstGroupDealer.findAll", query="SELECT m FROM MstGroupDealer m")
public class MstGroupDealer implements Serializable {
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String groupDealerCode;
	
	private String address;
	private String brandCode;
	private String categoryCode;
	private String corporate;
	private String createdBy;
	private Date createdDate;
	private String emailPic;
	private Date endDate;
	private String faxArea;
	private String faxNo;
	private String flagGroupDealer;
	private String groupDealerName;
	private String hpNo;
	private String kelCode;
	private String phoneArea1;
	private String phoneArea2;
	private String phoneNo1;
	private String phoneNo2;
	private String picName;
	private String rt;
	private String rw;
	private Date startDate;
	private String tradeName;
	private String updatedBy;
	private Date updatedDate;

	public MstGroupDealer() {
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


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Column(name="BRAND_CODE")
	public String getBrandCode() {
		return this.brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
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


	@Column(name="EMAIL_PIC")
	public String getEmailPic() {
		return this.emailPic;
	}

	public void setEmailPic(String emailPic) {
		this.emailPic = emailPic;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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


	@Column(name="FLAG_GROUP_DEALER")
	public String getFlagGroupDealer() {
		return this.flagGroupDealer;
	}

	public void setFlagGroupDealer(String flagGroupDealer) {
		this.flagGroupDealer = flagGroupDealer;
	}


	@Column(name="GROUP_DEALER_NAME")
	public String getGroupDealerName() {
		return this.groupDealerName;
	}

	public void setGroupDealerName(String groupDealerName) {
		this.groupDealerName = groupDealerName;
	}


	@Column(name="HP_NO")
	public String getHpNo() {
		return this.hpNo;
	}

	public void setHpNo(String hpNo) {
		this.hpNo = hpNo;
	}


	@Column(name="KEL_CODE")
	public String getKelCode() {
		return this.kelCode;
	}

	public void setKelCode(String kelCode) {
		this.kelCode = kelCode;
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
	@Column(name="START_DATE")
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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