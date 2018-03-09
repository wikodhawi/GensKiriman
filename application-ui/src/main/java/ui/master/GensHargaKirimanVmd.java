package ui.master;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.Form;
import org.zkoss.bind.SimpleForm;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;

import share.GensHargaKirimanDto;
import share.GensKirimanDto;
import common.model.RestResponse;
import common.ui.BaseVmd;
import common.ui.UIConstants;
import common.util.CommonConstants;
import common.util.JsonUtil;

@Init(superclass = true)
public class GensHargaKirimanVmd extends BaseVmd implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String INDEX_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/GensKiriman5/_index.zul";
	private final String DETAIL_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/GensKiriman5/_detail.zul";
	private final String WS_URI = "/GensHargaKiriman";

	List<GensHargaKirimanDto> indexDtos = new ArrayList<GensHargaKirimanDto>();
	private GensHargaKirimanDto gensHargaKirimanDto = new GensHargaKirimanDto();
	private GensHargaKirimanDto gensHargaKirimanDtoSelected = new GensHargaKirimanDto();
	private Form formMaster = new SimpleForm();

	@Override
	protected void loadList() {
		Map<String, Object> map = new HashMap<>();
		map.put("testing", "JSON");
		RestResponse rest = callWsWithPaging(WS_URI + "/all/paging", map,
				HttpMethod.POST);
		try {
			indexDtos = JsonUtil.mapJsonToListObject(rest.getContents(),
					GensHargaKirimanDto.class);
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
	public void add() {
		getPageInfo().setAddMode(true);
		navigate(DETAIL_PAGE_PATH);
	}

	@Command
	public void back() {
		getPageInfo().setListMode(true);
		navigate(INDEX_PAGE_PATH);
	}
	
	@Command
	public void edit(){
		if(gensHargaKirimanDto == null || gensHargaKirimanDto.getKodeKiriman()==null){
			showSmartMsgBox("W001");
			return;
		}

		Executions.getCurrent().setAttribute("obj", gensHargaKirimanDto);
		getPageInfo().setEditMode(true);
		navigate(DETAIL_PAGE_PATH);
	}
	@Override
	public void onEdit(){
		gensHargaKirimanDto = (GensHargaKirimanDto) Executions.getCurrent().getAttribute("obj");
		BindUtils.postNotifyChange(null, null, this, "ankSewaDto");
	}
	
	@Command
	public void view(){
		if(gensHargaKirimanDtoSelected == null || gensHargaKirimanDtoSelected.getKodeKiriman()==null){
			showSmartMsgBox("W001");
			return;
		}
		Executions.getCurrent().setAttribute("obj", gensHargaKirimanDtoSelected);
		getPageInfo().setViewMode(true);
		navigate(DETAIL_PAGE_PATH);
	}
	@Command
	public void save(){
		gensHargaKirimanDto.setCompanyCode(getCurrentUserSession().getCompanyCode());
		if(getPageInfo().isAddMode()){
			gensHargaKirimanDto.setCreatedBy(getCurrentUserSession().getUserId());
			gensHargaKirimanDto.setCreatedDate(new Date());
		}else{
			gensHargaKirimanDto.setUpdatedBy(getCurrentUserSession().getUserId());
			gensHargaKirimanDto.setUpdatedDate(new Date());
		}
//		gensHargaKirimanDto.("APPD");
		RestResponse rest = callCustomWs(WS_URI, gensHargaKirimanDto, HttpMethod.POST);
		
		if(rest.getStatus()==CommonConstants.OK_REST_STATUS){
			showSmartMsgBox(rest.getMessage());
			back();
		}else{
			showSmartMsgBox(rest.getMessage());
		}
		
	}
	
	@Override
	public void onView(){
		gensHargaKirimanDto = (GensHargaKirimanDto) Executions.getCurrent().getAttribute("obj");
		onEdit();
	}
	
	public List<GensHargaKirimanDto> getIndexDtos() {
		return indexDtos;
	}

	public void setIndexDtos(List<GensHargaKirimanDto> indexDtos) {
		this.indexDtos = indexDtos;
	}

	public GensHargaKirimanDto getGensHargaKirimanDto() {
		return gensHargaKirimanDto;
	}

	public void setGensHargaKirimanDto(GensHargaKirimanDto gensHargaKirimanDto) {
		this.gensHargaKirimanDto = gensHargaKirimanDto;
	}

	public GensHargaKirimanDto getGensHargaKirimanDtoSelected() {
		return gensHargaKirimanDtoSelected;
	}

	public void setGensHargaKirimanDtoSelected(
			GensHargaKirimanDto gensHargaKirimanDtoSelected) {
		this.gensHargaKirimanDtoSelected = gensHargaKirimanDtoSelected;
	}

	public Form getFormMaster() {
		return formMaster;
	}

	public void setFormMaster(Form formMaster) {
		this.formMaster = formMaster;
	}


}
