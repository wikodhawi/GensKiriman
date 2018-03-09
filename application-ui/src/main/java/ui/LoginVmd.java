package ui;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;

import org.springframework.http.HttpMethod;
import org.zkoss.bind.Form;
import org.zkoss.bind.SimpleForm;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.util.Locales;
import org.zkoss.web.Attributes;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;

import share.MstUserHdrDto;
import common.model.RestResponse;
import common.model.UserSession;
import common.ui.BaseVmd;
import common.util.JsonUtil;

public class LoginVmd extends BaseVmd implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MstUserHdrDto mstUserHdrDto = new MstUserHdrDto();
	
	private Form formMaster = new SimpleForm();

	@Init
	public void loadList(){
		
	}
	
	@Command
	public void login(){
		RestResponse rest = callCustomWs("/template/getLogin", mstUserHdrDto, HttpMethod.POST);
		
		try {
			UserSession userSession = JsonUtil.mapJsonToSingleObject(rest.getContents(), UserSession.class);
			
			Locale locale = Locales.getLocale(userSession.getUserLocale());
			getCurrentSession().setAttribute(Attributes.PREFERRED_LOCALE,
					locale);

			getCurrentSession().setAttribute("user",
					userSession);
			Executions.sendRedirect("/index.zul");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MstUserHdrDto getMstUserHdrDto() {
		return mstUserHdrDto;
	}

	public void setMstUserHdrDto(MstUserHdrDto mstUserHdrDto) {
		this.mstUserHdrDto = mstUserHdrDto;
	}

	public Form getFormMaster() {
		return formMaster;
	}

	public void setFormMaster(Form formMaster) {
		this.formMaster = formMaster;
	}
	
}
