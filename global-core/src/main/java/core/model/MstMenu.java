package core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MST_MENU database table.
 * 
 */
@Entity
@Table(name="MST_MENU")
@NamedQuery(name="MstMenu.findAll", query="SELECT m FROM MstMenu m")
public class MstMenu implements Serializable {
	private static final long serialVersionUID = 1L;
	private String menuCode;
	private String applProgCode;
	private String createdBy;
	private Date createdDate;
	private String flagActive;
	private String levelType;
	private String menuName;
	private String menuParent;
	private BigDecimal menuSeq;
	private String menuType;
	private String menuUrl;
	private String updatedBy;
	private Date updatedDate;

	public MstMenu() {
	}


	@Id
	@Column(name="MENU_CODE")
	public String getMenuCode() {
		return this.menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}


	@Column(name="APPL_PROG_CODE")
	public String getApplProgCode() {
		return this.applProgCode;
	}

	public void setApplProgCode(String applProgCode) {
		this.applProgCode = applProgCode;
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


	@Column(name="FLAG_ACTIVE")
	public String getFlagActive() {
		return this.flagActive;
	}

	public void setFlagActive(String flagActive) {
		this.flagActive = flagActive;
	}


	@Column(name="LEVEL_TYPE")
	public String getLevelType() {
		return this.levelType;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}


	@Column(name="MENU_NAME")
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}


	@Column(name="MENU_PARENT")
	public String getMenuParent() {
		return this.menuParent;
	}

	public void setMenuParent(String menuParent) {
		this.menuParent = menuParent;
	}


	@Column(name="MENU_SEQ")
	public BigDecimal getMenuSeq() {
		return this.menuSeq;
	}

	public void setMenuSeq(BigDecimal menuSeq) {
		this.menuSeq = menuSeq;
	}


	@Column(name="MENU_TYPE")
	public String getMenuType() {
		return this.menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}


	@Column(name="MENU_URL")
	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
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