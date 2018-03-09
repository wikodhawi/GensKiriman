package common.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Class for maintain user session
 * @author Leo Sendra
 *
 */
public class UserSession implements Serializable {
	private static final long serialVersionUID = 5962120871566848104L;
	private String userId;
	private String userName;
	private String companyCode;
	private String companyName;
	private String userLocale;
	private byte[] companyImage;
	private Set<String> roleCode = new HashSet<String>();

	public UserSession() {
	}

	public UserSession(String userId, String userRealName, String companyCode,
			String companyName,
			String userLocale, String userName, byte[] companyImage, Set<String> roleCode) {
		this.userId = userId;
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.userLocale = userLocale;
		this.userName = userName;
		this.companyImage = companyImage;
		this.roleCode = roleCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserLocale() {
		return userLocale;
	}

	public void setUserLocale(String userLocale) {
		this.userLocale = userLocale;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public byte[] getCompanyImage() {
		return companyImage;
	}

	public void setCompanyImage(byte[] companyImage) {
		this.companyImage = companyImage;
	}

	public Set<String> getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(Set<String> roleCode) {
		this.roleCode = roleCode;
	}
}