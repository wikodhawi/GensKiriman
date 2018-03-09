package core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the MST_MENU_ACT database table.
 * 
 */
@Entity
@Table(name="MST_MENU_ACT")
@NamedQuery(name="MstMenuAct.findAll", query="SELECT m FROM MstMenuAct m")
public class MstMenuAct implements Serializable {
	private static final long serialVersionUID = 1L;
	private MstMenuActPK id;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;

	public MstMenuAct() {
	}


	@EmbeddedId
	public MstMenuActPK getId() {
		return this.id;
	}

	public void setId(MstMenuActPK id) {
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