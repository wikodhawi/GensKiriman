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
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;

import share.MstDealerDto;
import share.MstGlobalParamDto;
import share.MstGroupDealerDto;
import common.model.RestResponse;
import common.ui.BaseVmd;
import common.ui.UIConstants;
import common.util.CommonConstants;
import common.util.JsonUtil;

@Init(superclass = true)
public class MasterDealerVmd extends BaseVmd implements Serializable {
	private static final long serialVersionUID = 1L;

	private final String INDEX_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/MasterDealer/_index.zul";
	private final String DETAIL_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/MasterDealer/_detail.zul";
	private final String WS_URI = "/MasterDealer";

	List<MstDealerDto> indexDtos = new ArrayList<MstDealerDto>();
	private MstDealerDto mstDealerDto = new MstDealerDto();
	private MstDealerDto MstDealerDtoSelected = new MstDealerDto();
	private Form formMaster = new SimpleForm();

	private List<MstGlobalParamDto> corporates = new ArrayList<MstGlobalParamDto>();
	private MstGlobalParamDto corporate = new MstGlobalParamDto();

	private List<MstGlobalParamDto> dealerKinds = new ArrayList<MstGlobalParamDto>();
	private MstGlobalParamDto dealerKind = new MstGlobalParamDto();

	private List<MstGlobalParamDto> dealerTypes = new ArrayList<MstGlobalParamDto>();
	private MstGlobalParamDto dealerType = new MstGlobalParamDto();

	private List<MstGlobalParamDto> dealerCategorys = new ArrayList<MstGlobalParamDto>();
	private MstGlobalParamDto dealerCategory = new MstGlobalParamDto();

	@Override
	protected void loadList() {
		Map<String, Object> map = new HashMap<>();
		map.put("testing", "JSON");
		RestResponse rest = callWsWithPaging(WS_URI + "/all/paging", map,
				HttpMethod.POST);
		try {
			indexDtos = JsonUtil.mapJsonToListObject(rest.getContents(),
					MstDealerDto.class);
			setTotalSize(rest.getTotalRecords());
			BindUtils.postNotifyChange(null, null, this, "indexDtos");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private List<MstGlobalParamDto> getMstGlobalParam(String condition) {
		List<MstGlobalParamDto> out = new ArrayList<MstGlobalParamDto>();
		RestResponse rest = callWs("/MasterGlobalParam/all/data/" + condition,
				null, HttpMethod.GET);
		try {
			out = JsonUtil.mapJsonToListObject(rest.getContents(),
					MstGlobalParamDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
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

	@Override
	public void onAdd() {
		corporates.addAll(getMstGlobalParam("CORPORATE"));
		dealerCategorys.addAll(getMstGlobalParam("DEALER_CATEGORY"));
		dealerKinds.addAll(getMstGlobalParam("DEALER_KIND"));
		dealerTypes.addAll(getMstGlobalParam("DEALER_TYPE"));

		BindUtils.postNotifyChange(null, null, this, "corporates");
		BindUtils.postNotifyChange(null, null, this, "dealerCategorys");
		BindUtils.postNotifyChange(null, null, this, "dealerKinds");
		BindUtils.postNotifyChange(null, null, this, "dealerTypes");
	}

	@GlobalCommand("groupDealerHandler")
	public void groupDealerHandler(
			@BindingParam("groupDealer") MstGroupDealerDto dto){
		formMaster.setField("groupDealerCode", dto.getGroupDealerCode());
		BindUtils.postNotifyChange(null, null, formMaster, "dealerCode");
	}
	
	@Command
	public void save(){
		mstDealerDto.setCompanyCode(getCurrentUserSession().getCompanyCode());
		if(getPageInfo().isAddMode()){
			mstDealerDto.setCreatedBy(getCurrentUserSession().getUserId());
			mstDealerDto.setCreatedDate(new Date());
		}else{
			mstDealerDto.setUpdatedBy(getCurrentUserSession().getUserId());
			mstDealerDto.setUpdatedDate(new Date());
		}
		mstDealerDto.setCorporate(corporate.getParamCode());
		mstDealerDto.setDealerCategory(dealerCategory.getParamCode());
		mstDealerDto.setDealerKind(dealerKind.getParamCode());
		mstDealerDto.setDealerType(dealerType.getParamCode());
		mstDealerDto.setCategoryCode("1");
		RestResponse rest = callCustomWs(WS_URI, mstDealerDto, HttpMethod.POST);
		
		if(rest.getStatus()==CommonConstants.OK_REST_STATUS){
			showSmartMsgBox(rest.getMessage());
			back();
		}else{
			showSmartMsgBox(rest.getMessage());
		}
		
	}

	
	public List<MstDealerDto> getIndexDtos() {
		return indexDtos;
	}

	public void setIndexDtos(List<MstDealerDto> indexDtos) {
		this.indexDtos = indexDtos;
	}

	public MstDealerDto getMstDealerDto() {
		return mstDealerDto;
	}

	public void setMstDealerDto(MstDealerDto mstDealerDto) {
		this.mstDealerDto = mstDealerDto;
	}

	public MstDealerDto getMstDealerDtoSelected() {
		return MstDealerDtoSelected;
	}

	public void setMstDealerDtoSelected(MstDealerDto mstDealerDtoSelected) {
		MstDealerDtoSelected = mstDealerDtoSelected;
	}

	public Form getFormMaster() {
		return formMaster;
	}

	public void setFormMaster(Form formMaster) {
		this.formMaster = formMaster;
	}

	public List<MstGlobalParamDto> getCorporates() {
		return corporates;
	}

	public void setCorporates(List<MstGlobalParamDto> corporates) {
		this.corporates = corporates;
	}

	public MstGlobalParamDto getCorporate() {
		return corporate;
	}

	public void setCorporate(MstGlobalParamDto corporate) {
		this.corporate = corporate;
	}

	public List<MstGlobalParamDto> getDealerKinds() {
		return dealerKinds;
	}

	public void setDealerKinds(List<MstGlobalParamDto> dealerKinds) {
		this.dealerKinds = dealerKinds;
	}

	public MstGlobalParamDto getDealerKind() {
		return dealerKind;
	}

	public void setDealerKind(MstGlobalParamDto dealerKind) {
		this.dealerKind = dealerKind;
	}

	public List<MstGlobalParamDto> getDealerTypes() {
		return dealerTypes;
	}

	public void setDealerTypes(List<MstGlobalParamDto> dealerTypes) {
		this.dealerTypes = dealerTypes;
	}

	public MstGlobalParamDto getDealerType() {
		return dealerType;
	}

	public void setDealerType(MstGlobalParamDto dealerType) {
		this.dealerType = dealerType;
	}

	public List<MstGlobalParamDto> getDealerCategorys() {
		return dealerCategorys;
	}

	public void setDealerCategorys(List<MstGlobalParamDto> dealerCategorys) {
		this.dealerCategorys = dealerCategorys;
	}

	public MstGlobalParamDto getDealerCategory() {
		return dealerCategory;
	}

	public void setDealerCategory(MstGlobalParamDto dealerCategory) {
		this.dealerCategory = dealerCategory;
	}

}
