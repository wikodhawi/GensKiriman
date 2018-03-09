package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MST_MENU_ACT database table.
 * 
 */
@Embeddable
public class MstMenuActPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String menuCode;
	private String actionName;

	public MstMenuActPK() {
	}

	@Column(name="MENU_CODE")
	public String getMenuCode() {
		return this.menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	@Column(name="ACTION_NAME")
	public String getActionName() {
		return this.actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MstMenuActPK)) {
			return false;
		}
		MstMenuActPK castOther = (MstMenuActPK)other;
		return 
			this.menuCode.equals(castOther.menuCode)
			&& this.actionName.equals(castOther.actionName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.menuCode.hashCode();
		hash = hash * prime + this.actionName.hashCode();
		
		return hash;
	}
}