package ui.template;

import java.io.IOException;
import java.util.Date;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.image.AImage;
import org.zkoss.zk.ui.Executions;

import common.model.UserSession;
import common.ui.BaseVmd;

public class NavbarVmd extends BaseVmd{

	private AImage companyImage;
	private String companyName;
	private Date currentDate = new Date();
	private String userName;
	
	@Init
	public void loadlist(){
		try {
			companyImage = new AImage("img.jpg", getCurrentUserSession().getCompanyImage());
			companyName = getCurrentUserSession().getCompanyName();
			userName = getCurrentUserSession().getUserName();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Command
	public void logout(){
		Executions.sendRedirect("/login.zul");
	}

	public AImage getCompanyImage() {
		return companyImage;
	}

	public void setCompanyImage(AImage companyImage) {
		this.companyImage = companyImage;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
