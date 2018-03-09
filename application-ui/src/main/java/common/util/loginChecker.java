package common.util;
import java.util.Locale;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.zkoss.util.Locales;
import org.zkoss.web.Attributes;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;

import share.MstUserHdrDto;
import common.model.RestResponse;
import common.model.UserSession;
import common.ui.BaseVmd;

public class loginChecker extends BaseVmd implements Initiator {
	
	@Override
	public void doInit(Page page, Map<String, Object> args){
		if (System.getProperty("debug") != null) {
			String user = System.getProperty("user");
			String password = System.getProperty("password");
			MstUserHdrDto mstUserHdrDto = new MstUserHdrDto();
			mstUserHdrDto.setEmployeeCode(user);
			mstUserHdrDto.setPassword(password);

			RestResponse rest = callCustomWs("/template/getLogin", mstUserHdrDto, HttpMethod.POST);
			
			try {
				UserSession userSession = JsonUtil.mapJsonToSingleObject(rest.getContents(), UserSession.class);
				
				Locale locale = Locales.getLocale(userSession.getUserLocale());
				getCurrentSession().setAttribute(Attributes.PREFERRED_LOCALE,
						locale);

				getCurrentSession().setAttribute("user",
						userSession);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (getCurrentUserSession() == null) {
			Executions.sendRedirect("/login.zul");
		}
	}
}
