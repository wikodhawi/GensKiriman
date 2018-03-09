package ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import share.GensAdminDto;
import share.MstGlobalParamDto;
import share.MstUserHdrDto;
import common.model.RestResponse;
import common.model.UserSession;
import common.ui.BaseVmd;
import common.ui.UIConstants;
import common.util.JsonUtil;
import common.util.loginChecker;
import core.model.GensAdmin;

public class Login1Vmd extends BaseVmd implements Serializable{
	
	/**
	 * 
	 */
	
	private final String DESTINATION_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/GensKiriman/_index.zul";
	
	private final String INDEX_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/GensKiriman/_index.zul";
	
	private final String DETAIL_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/GensKiriman2/_index.zul";
	private static final long serialVersionUID = 1L;
	private final String WS_URI = "/GensAdmin";
	private List<GensAdminDto> gensAdminDtos=new ArrayList<GensAdminDto>();
	
	
	
	private GensAdminDto gensAdminDto = new GensAdminDto();
	private Form formMaster = new SimpleForm();

	@Init
	public void loadList(){
		
	}
	
	@Command
	public void login(){
		System.out.println(gensAdminDto.getUsername());
		System.out.println(gensAdminDto.getPassword());
		
		gensAdminDtos.addAll(getAdminDto(gensAdminDto.getUsername(), gensAdminDto.getPassword()));
		System.out.println(gensAdminDtos.size());
		if(gensAdminDtos.size()>1)
		{
			System.out.println("login berhasil");
//			for(GensAdminDto gensAdminDto:gensAdminDtos)
//			{
//				System.out.println(gensAdminDto.getUsername());
//				
//			}
			navigate(DESTINATION_PAGE_PATH);
		}
		else {
			System.out.println("login gagal");
			showSmartMsgBox("Login Gagal");
		}
		
	}

//	public MstUserHdrDto getMstUserHdrDto() {
//		return mstUserHdrDto;
//	}
//
//	public void setMstUserHdrDto(MstUserHdrDto mstUserHdrDto) {
//		this.mstUserHdrDto = mstUserHdrDto;
//	}
	
	private List<GensAdminDto> getAdminDto(String username, String password) {
		List<GensAdminDto> out = new ArrayList<GensAdminDto>();
		RestResponse rest = callWs("/GensAdmin/all/paging/" + username+"/"+password,
				null, HttpMethod.GET);
		try {
			out = JsonUtil.mapJsonToListObject(rest.getContents(),
					GensAdminDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}
	
	

	public List<GensAdminDto> getGensAdminDtos() {
		return gensAdminDtos;
	}

	public void setGensAdminDtos(List<GensAdminDto> gensAdminDtos) {
		this.gensAdminDtos = gensAdminDtos;
	}

	public Form getFormMaster() {
		return formMaster;
	}

	public void setFormMaster(Form formMaster) {
		this.formMaster = formMaster;
	}

	public String getDETAIL_PAGE_PATH() {
		return DETAIL_PAGE_PATH;
	}

	public GensAdminDto getGensAdminDto() {
		return gensAdminDto;
	}

	public void setGensAdminDto(GensAdminDto gensAdminDto) {
		this.gensAdminDto = gensAdminDto;
	}

	public String getWS_URI() {
		return WS_URI;
	}
	
}
