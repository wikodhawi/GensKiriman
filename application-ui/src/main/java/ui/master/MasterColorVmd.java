package ui.master;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.http.HttpMethod;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.Form;
import org.zkoss.bind.SimpleForm;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.util.Locales;
import org.zkoss.util.resource.Labels;
import org.zkoss.web.Attributes;
import org.zkoss.zk.ui.Executions;

import share.MstColorDto;
import common.model.RestResponse;
import common.model.UserSession;
import common.ui.BaseVmd;
import common.ui.UIConstants;
import common.util.CommonConstants;
import common.util.JsonUtil;

@Init(superclass = true)
public class MasterColorVmd extends BaseVmd implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String INDEX_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/MasterColor/_index.zul";
	private final String DETAIL_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/MasterColor/_detail.zul";
	private final String WS_URI = "/MasterColor";
	
	List<MstColorDto> indexDtos = new ArrayList<MstColorDto>();
	private MstColorDto mstColorDto = new MstColorDto();
	private MstColorDto mstColorDtoSelected = new MstColorDto();
	private Form formMaster = new SimpleForm();
	
	@Override
	protected void loadList(){
		RestResponse rest = callWsWithPaging(WS_URI+"/all/paging", new HashMap<String, Object>(), HttpMethod.POST);
		try {
			indexDtos = JsonUtil.mapJsonToListObject(rest.getContents(), MstColorDto.class);
			setTotalSize(rest.getTotalRecords());
			BindUtils.postNotifyChange(null, null, this, "indexDtos");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Command("refresh")
	public void refresh() {
		navigate("");
		getPageInfo().setListMode(true);
		navigate(INDEX_PAGE_PATH);
	}
	
	@Command
	public void add(){
		getPageInfo().setAddMode(true);
		navigate(DETAIL_PAGE_PATH);
	}
	
	@Command
	public void edit(){
		if(mstColorDtoSelected == null || mstColorDtoSelected.getColorCode()==null){
			showSmartMsgBox("W001");
			return;
		}
		
		Executions.getCurrent().setAttribute("obj", mstColorDtoSelected);
		getPageInfo().setEditMode(true);
		navigate(DETAIL_PAGE_PATH);
	}
	
	@Override
	public void onEdit(){
		mstColorDto = (MstColorDto) Executions.getCurrent().getAttribute("obj");
		BindUtils.postNotifyChange(null, null, this, "mstColorDto");
	}
	
	@Command
	public void view(){
		if(mstColorDtoSelected == null || mstColorDtoSelected.getColorCode()==null){
			showSmartMsgBox("W001");
			return;
		}
		Executions.getCurrent().setAttribute("obj", mstColorDtoSelected);
		getPageInfo().setViewMode(true);
		navigate(DETAIL_PAGE_PATH);
	}
	
	@Override
	public void onView(){
		mstColorDto = (MstColorDto) Executions.getCurrent().getAttribute("obj");
		onEdit();
	}
	
	@Command
	public void save(){
		mstColorDto.setCompanyCode(getCurrentUserSession().getCompanyCode());
		if(getPageInfo().isAddMode()){
			mstColorDto.setCreatedBy(getCurrentUserSession().getUserId());
			mstColorDto.setCreatedDate(new Date());
		}else{
			mstColorDto.setUpdatedBy(getCurrentUserSession().getUserId());
			mstColorDto.setUpdatedDate(new Date());
		}
		mstColorDto.setAppvSts("APPD");
		RestResponse rest = callCustomWs(WS_URI, mstColorDto, HttpMethod.POST);
		
		if(rest.getStatus()==CommonConstants.OK_REST_STATUS){
			showSmartMsgBox(rest.getMessage());
			back();
		}else{
			showSmartMsgBox(rest.getMessage());
		}
		
	}
	
	@Command
	public void back(){
		getPageInfo().setListMode(true);
		navigate(INDEX_PAGE_PATH);
	}

	public List<MstColorDto> getIndexDtos() {
		return indexDtos;
	}

	public void setIndexDtos(List<MstColorDto> indexDtos) {
		this.indexDtos = indexDtos;
	}

	public MstColorDto getMstColorDto() {
		return mstColorDto;
	}

	public void setMstColorDto(MstColorDto mstColorDto) {
		this.mstColorDto = mstColorDto;
	}

	public Form getFormMaster() {
		return formMaster;
	}

	public void setFormMaster(Form formMaster) {
		this.formMaster = formMaster;
	}

	public MstColorDto getMstColorDtoSelected() {
		return mstColorDtoSelected;
	}

	public void setMstColorDtoSelected(MstColorDto mstColorDtoSelected) {
		this.mstColorDtoSelected = mstColorDtoSelected;
	}
}
