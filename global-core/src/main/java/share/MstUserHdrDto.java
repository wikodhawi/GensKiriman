package share;

import java.io.Serializable;
import java.util.Date;

public class MstUserHdrDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String createdBy;
	private Date createdDate;
	private String defaultBranchCode;
	private String flagActive;
	private String levelBgtCode;
	private String levelBgtType;
	private String password;
	private String preferedLocale;
	private String subBranchCode;
	private String updatedBy;
	private Date updatedDate;
	private String employeeCode;
	private String companyCode;
	
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
	public String getDefaultBranchCode() {
		return defaultBranchCode;
	}
	public void setDefaultBranchCode(String defaultBranchCode) {
		this.defaultBranchCode = defaultBranchCode;
	}
	public String getFlagActive() {
		return flagActive;
	}
	public void setFlagActive(String flagActive) {
		this.flagActive = flagActive;
	}
	public String getLevelBgtCode() {
		return levelBgtCode;
	}
	public void setLevelBgtCode(String levelBgtCode) {
		this.levelBgtCode = levelBgtCode;
	}
	public String getLevelBgtType() {
		return levelBgtType;
	}
	public void setLevelBgtType(String levelBgtType) {
		this.levelBgtType = levelBgtType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPreferedLocale() {
		return preferedLocale;
	}
	public void setPreferedLocale(String preferedLocale) {
		this.preferedLocale = preferedLocale;
	}
	public String getSubBranchCode() {
		return subBranchCode;
	}
	public void setSubBranchCode(String subBranchCode) {
		this.subBranchCode = subBranchCode;
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
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
