package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MST_GLOBAL_PARAM database table.
 * 
 */
@Entity
@Table(name="MST_GLOBAL_PARAM")
@IdClass(MstGlobalParamPK.class)
@NamedQuery(name="MstGlobalParam.findAll", query="SELECT m FROM MstGlobalParam m")
public class MstGlobalParam implements Serializable {
	private static final long serialVersionUID = 1L;
//	private MstGlobalParamPK id;
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

	public MstGlobalParam() {
	}
	@Id
	@Column(name="CONDITION")
	public String getCondition() {
		return this.condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	@Id
	@Column(name="PARAM_CODE")
	public String getParamCode() {
		return this.paramCode;
	}
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	public java.util.Date getStartDate() {
		return this.startDate;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}


	@Column(name="CHAR_VALUES")
	public String getCharValues() {
		return this.charValues;
	}

	public void setCharValues(String charValues) {
		this.charValues = charValues;
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


	@Temporal(TemporalType.DATE)
	@Column(name="DATE_FROM")
	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="DATE_PARAM")
	public Date getDateParam() {
		return this.dateParam;
	}

	public void setDateParam(Date dateParam) {
		this.dateParam = dateParam;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="DATE_TO")
	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	@Column(name="PARAM_DESCRIP")
	public String getParamDescrip() {
		return this.paramDescrip;
	}

	public void setParamDescrip(String paramDescrip) {
		this.paramDescrip = paramDescrip;
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


	@Column(name="VALUES_FROM")
	public BigDecimal getValuesFrom() {
		return this.valuesFrom;
	}

	public void setValuesFrom(BigDecimal valuesFrom) {
		this.valuesFrom = valuesFrom;
	}


	@Column(name="VALUES_PARAM")
	public BigDecimal getValuesParam() {
		return this.valuesParam;
	}

	public void setValuesParam(BigDecimal valuesParam) {
		this.valuesParam = valuesParam;
	}


	@Column(name="VALUES_TO")
	public BigDecimal getValuesTo() {
		return this.valuesTo;
	}

	public void setValuesTo(BigDecimal valuesTo) {
		this.valuesTo = valuesTo;
	}

}