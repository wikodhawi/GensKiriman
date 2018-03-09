package share.dtoTree;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MstMenuTreeDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private MstMenuTreeDto parent;
	private List<MstMenuTreeDto> children;
	private String menuCode ="";
	private String applProgCode="";
	private String createdBy="";
	private Date createdDate;
	private String flagActive="";
	private String levelType="";
	private String menuName="";
	private String menuParent="";
	private BigDecimal menuSeq;
	private String menuType="";
	private String menuUrl="";
	private String updatedBy="";
	private Date updatedDate;
		
	public MstMenuTreeDto(){
		
	}
	
	public MstMenuTreeDto(MstMenuTreeDto parent, String menuCode, String applProgCode,	 String createdBy,	 Date createdDate,	 String flagActive,	 String levelType,	 String menuName,
	 String menuParent,	 BigDecimal menuSeq,	 String menuType,	 String menuUrl,	 String updatedBy,	 Date updatedDate){
		this.parent = parent;
		this.menuCode = menuCode;
		this.applProgCode = applProgCode;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.flagActive = flagActive;
		this.levelType = levelType;
		this.menuName = menuName;
		this.menuParent = menuParent;
		this.menuSeq = menuSeq;
		this.menuType = menuType;
		this.menuUrl = menuUrl;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public MstMenuTreeDto(MstMenuTreeDto o){
				this.parent = o.parent;
				this.menuCode = o.menuCode;
				this.applProgCode = o.applProgCode;
				this.createdBy = o.createdBy;
				this.createdDate = o.createdDate;
				this.flagActive = o.flagActive;
				this.levelType = o.levelType;
				this.menuName = o.menuName;
				this.menuParent = o.menuParent;
				this.menuSeq = o.menuSeq;
				this.menuType = o.menuType;
				this.menuUrl = o.menuUrl;
				this.updatedBy = o.updatedBy;
				this.updatedDate = o.updatedDate;
			}
	public MstMenuTreeDto getParent() {
		return parent;
	}

	public void setParent(MstMenuTreeDto parent) {
		this.parent = parent;
	}
	
	public void appendChild(MstMenuTreeDto child) {
		if (children == null)
			children = new ArrayList<>();
		children.add(child);
		child.setParent(this);
	}

	public List<MstMenuTreeDto> getChildren() {
		if (children == null)
			return Collections.emptyList();
		return children;
	}

	public void setChildren(List<MstMenuTreeDto> children) {
		this.children = children;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getApplProgCode() {
		return applProgCode;
	}

	public void setApplProgCode(String applProgCode) {
		this.applProgCode = applProgCode;
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

	public String getFlagActive() {
		return flagActive;
	}

	public void setFlagActive(String flagActive) {
		this.flagActive = flagActive;
	}

	public String getLevelType() {
		return levelType;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuParent() {
		return menuParent;
	}

	public void setMenuParent(String menuParent) {
		this.menuParent = menuParent;
	}

	public BigDecimal getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(BigDecimal menuSeq) {
		this.menuSeq = menuSeq;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
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
	
	// untuk sort berdasarkan sequence
//		@Override
//		public int compareTo(MstMenuTreeDto m) {
//			return getMenuSeq().compareTo(m.getMenuSeq());
//		}
//
//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result
//					+ ((menuCode == null) ? 0 : menuCode.hashCode());
//			result = prime * result
//					+ ((menuParent == null) ? 0 : menuParent.hashCode());
//			return result;
//		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MstMenuTreeDto other = (MstMenuTreeDto) obj;
			if (menuCode == null) {
				if (other.menuCode != null)
					return false;
			} else if (!menuCode.equals(other.menuCode))
				return false;
			if (menuParent == null) {
				if (other.menuParent != null)
					return false;
			} else if (!menuParent.equals(other.menuParent))
				return false;
			return true;
		}
	
}
