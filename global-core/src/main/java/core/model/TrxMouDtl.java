package core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TRX_MOU_DTL database table.
 * 
 */
@Entity
@Table(name="TRX_MOU_DTL")
@NamedQuery(name="TrxMouDtl.findAll", query="SELECT t FROM TrxMouDtl t")
public class TrxMouDtl implements Serializable {
	private static final long serialVersionUID = 1L;
	private TrxMouDtlPK id;
	private String createdBy;
	private Date createdDate;
	private String flagInput;
	private String updatedBy;
	private Date updatedDate;

	public TrxMouDtl() {
	}


	@EmbeddedId
	public TrxMouDtlPK getId() {
		return this.id;
	}

	public void setId(TrxMouDtlPK id) {
		this.id = id;
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


	@Column(name="FLAG_INPUT")
	public String getFlagInput() {
		return this.flagInput;
	}

	public void setFlagInput(String flagInput) {
		this.flagInput = flagInput;
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