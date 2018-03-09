package ui.master;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.Form;
import org.zkoss.bind.SimpleForm;


import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;

import share.MstGroupDealerDto;
import common.model.RestResponse;
import common.ui.BaseVmd;
import common.ui.UIConstants;
import common.util.JsonUtil;

@Init(superclass = true)
public class MasterGroupDealerVmd extends BaseVmd implements Serializable{

private static final long serialVersionUID = 1L;
	
	private final String INDEX_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/MasterGroupDealer/_index.zul";
	private final String DETAIL_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/MasterGroupDealer/_detail.zul";
	private final String WS_URI = "/MasterGroupDealer";
	
	List<MstGroupDealerDto> indexDtos = new ArrayList<MstGroupDealerDto>();
	private MstGroupDealerDto mstGroupDealerDto = new MstGroupDealerDto();
	private MstGroupDealerDto MstGroupDealerDtoSelected = new MstGroupDealerDto();
	private Form formMaster = new SimpleForm();
	
	@Override
	protected void loadList(){
		RestResponse rest = callWsWithPaging(WS_URI+"/all/paging", new HashMap<String, Object>(), HttpMethod.POST);
		try {
			indexDtos = JsonUtil.mapJsonToListObject(rest.getContents(), MstGroupDealerDto.class);
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
	public void view(){
		if(MstGroupDealerDtoSelected == null || MstGroupDealerDtoSelected.getCompanyCode()==null){
			showSmartMsgBox("W001");
			return;
		}
		Executions.getCurrent().setAttribute("obj", MstGroupDealerDtoSelected);
		getPageInfo().setViewMode(true);
		navigate(DETAIL_PAGE_PATH);
	}
	
	public List<MstGroupDealerDto> getIndexDtos() {
		return indexDtos;
	}

	public void setIndexDtos(List<MstGroupDealerDto> indexDtos) {
		this.indexDtos = indexDtos;
	}

	public MstGroupDealerDto getMstGroupDealerDto() {
		return mstGroupDealerDto;
	}

	public void setMstGroupDealerDto(MstGroupDealerDto mstGroupDealerDto) {
		this.mstGroupDealerDto = mstGroupDealerDto;
	}

	public MstGroupDealerDto getMstGroupDealerDtoSelected() {
		return MstGroupDealerDtoSelected;
	}

	public void setMstGroupDealerDtoSelected(
			MstGroupDealerDto mstGroupDealerDtoSelected) {
		MstGroupDealerDtoSelected = mstGroupDealerDtoSelected;
	}

	public Form getFormMaster() {
		return formMaster;
	}

	public void setFormMaster(Form formMaster) {
		this.formMaster = formMaster;
	}
	
}
