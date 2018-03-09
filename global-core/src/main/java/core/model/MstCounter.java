package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MST_COUNTER database table.
 * 
 */
@Entity
@Table(name="MST_COUNTER")
@IdClass(MstCounterPK.class)
@NamedQuery(name="MstCounter.findAll", query="SELECT m FROM MstCounter m")
public class MstCounter implements Serializable {
	private static final long serialVersionUID = 1L;
	private String createdBy;
	private Date createdDate;
	private BigDecimal lastNo;
	private String updatedBy;
	private Date updatedDate;
	
	private String companyCode;
	private String trxCode;
	private String branchCode;
	private String cashBankCode;
	private String directPrefix;
	private long year;
	private long month;
	private long day;

	public MstCounter() {
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
	@Column(name="TRX_CODE")
	public String getTrxCode() {
		return this.trxCode;
	}
	public void setTrxCode(String trxCode) {
		this.trxCode = trxCode;
	}

	@Id
	@Column(name="BRANCH_CODE")
	public String getBranchCode() {
		return this.branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	@Id
	@Column(name="CASH_BANK_CODE")
	public String getCashBankCode() {
		return this.cashBankCode;
	}
	public void setCashBankCode(String cashBankCode) {
		this.cashBankCode = cashBankCode;
	}

	@Id
	@Column(name="DIRECT_PREFIX")
	public String getDirectPrefix() {
		return this.directPrefix;
	}
	public void setDirectPrefix(String directPrefix) {
		this.directPrefix = directPrefix;
	}

	@Id
	@Column(name="\"YEAR\"")
	public long getYear() {
		return this.year;
	}
	public void setYear(long year) {
		this.year = year;
	}

	@Id
	@Column(name="\"MONTH\"")
	public long getMonth() {
		return this.month;
	}
	public void setMonth(long month) {
		this.month = month;
	}

	@Id
	@Column(name="\"DAY\"")
	public long getDay() {
		return this.day;
	}
	public void setDay(long day) {
		this.day = day;
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


	@Column(name="LAST_NO")
	public BigDecimal getLastNo() {
		return this.lastNo;
	}

	public void setLastNo(BigDecimal lastNo) {
		this.lastNo = lastNo;
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

	public MstCounter(MstCounterPK mstCounterPK){
		this.companyCode = mstCounterPK.getCompanyCode();
		this.trxCode = mstCounterPK.getTrxCode();
		this.branchCode = mstCounterPK.getBranchCode();
		this.cashBankCode = mstCounterPK.getCashBankCode();
		this.day = mstCounterPK.getDay();
		this.month = mstCounterPK.getMonth();
		this.year = mstCounterPK.getYear();
		this.directPrefix = mstCounterPK.getDirectPrefix();
	}
}