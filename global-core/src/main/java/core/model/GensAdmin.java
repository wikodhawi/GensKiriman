package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the GENS_ADMIN database table.
 * 
 */
@Entity
@Table(name = "GENS_ADMIN")
@IdClass(GensAdminPK.class)
@NamedQuery(name = "GensAdmin.findAll", query = "SELECT g FROM GensAdmin g")
public class GensAdmin implements Serializable {
	private static final long serialVersionUID = 1L;
	// private GensAdminPK id;
	private String companyCode;
	private String username;
	private String createdBy;
	private Date createdDate;
	private String password;
	private String updatedBy;
	private Date updatedDate;

	public GensAdmin() {
	}

	// @EmbeddedId
	// public GensAdminPK getId() {
	// return this.id;
	// }
	//
	// public void setId(GensAdminPK id) {
	// this.id = id;
	// }

	@Column(name = "CREATED_BY")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "COMPANY_CODE")
	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	@Id
	@Column(name = "USERNAME")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}