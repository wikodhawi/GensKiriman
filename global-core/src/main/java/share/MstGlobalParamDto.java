package share;

import java.math.BigDecimal;
import java.util.Date;

public class MstGlobalParamDto {
	private String condition;
	private String paramCode;
	private java.util.Date startDate;

	private String charValues;
	private String createdBy;
	private Date createdDate;
	private Date dateFrom;
	private Date dateParam;
	private Date dateTo;
	private Date endDate;
	private String paramDescrip;
	private String updatedBy;
	private Date updatedDate;
	private BigDecimal valuesFrom;
	private BigDecimal valuesParam;
	private BigDecimal valuesTo;
	
	public MstGlobalParamDto(){
		
	}
	public MstGlobalParamDto(MstGlobalParamDto mstGlobalParamDto){
		this.condition = mstGlobalParamDto.getCondition();
		this.paramCode = mstGlobalParamDto.getParamCode();
	}
	public MstGlobalParamDto(String condition, String paramCode){
		this.condition = condition;
		this.paramCode = paramCode;
	}
	public MstGlobalParamDto(String condition,String paramCode, String paramDescrip){
		this.condition = condition;
		this.paramCode = paramCode;
		this.paramDescrip = paramDescrip;
	}
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getParamCode() {
		return paramCode;
	}
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}
	public java.util.Date getStartDate() {
		return startDate;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}
	public String getCharValues() {
		return charValues;
	}
	public void setCharValues(String charValues) {
		this.charValues = charValues;
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
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateParam() {
		return dateParam;
	}
	public void setDateParam(Date dateParam) {
		this.dateParam = dateParam;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getParamDescrip() {
		return paramDescrip;
	}
	public void setParamDescrip(String paramDescrip) {
		this.paramDescrip = paramDescrip;
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
	public BigDecimal getValuesFrom() {
		return valuesFrom;
	}
	public void setValuesFrom(BigDecimal valuesFrom) {
		this.valuesFrom = valuesFrom;
	}
	public BigDecimal getValuesParam() {
		return valuesParam;
	}
	public void setValuesParam(BigDecimal valuesParam) {
		this.valuesParam = valuesParam;
	}
	public BigDecimal getValuesTo() {
		return valuesTo;
	}
	public void setValuesTo(BigDecimal valuesTo) {
		this.valuesTo = valuesTo;
	}
	
	
}
