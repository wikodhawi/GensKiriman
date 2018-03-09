package share;

import java.io.Serializable;
import java.util.Date;

public class MstColorDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String colorCode;
	
	private String aliasName;
	private String appvSts;
	private String batchNo;
	private String colorDescrip;
	private String createdBy;
	private Date createdDate;
	private Date endDate;
	private String flagUpload;
	private Date startDate;
	private String updatedBy;
	private Date updatedDate;
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public String getAppvSts() {
		return appvSts;
	}
	public void setAppvSts(String appvSts) {
		this.appvSts = appvSts;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getColorDescrip() {
		return colorDescrip;
	}
	public void setColorDescrip(String colorDescrip) {
		this.colorDescrip = colorDescrip;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getFlagUpload() {
		return flagUpload;
	}
	public void setFlagUpload(String flagUpload) {
		this.flagUpload = flagUpload;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
