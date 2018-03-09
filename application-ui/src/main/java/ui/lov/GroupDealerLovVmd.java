package ui.lov;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpMethod;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.ListModelList;

import share.MstGroupDealerDto;
import common.model.RestResponse;
import common.ui.BaseLovVmd;
import common.util.CommonConstants;
import common.util.JsonUtil;

public class GroupDealerLovVmd extends BaseLovVmd implements Serializable {
private static final long serialVersionUID = 1L;
private final String WS_URI = "/MasterDealer/lov/groupDealer";
private ListModelList<MstGroupDealerDto> mstGroupDealerDtos = new ListModelList<>();
private MstGroupDealerDto mstGroupDealerDto;
private Set<Integer> list = new HashSet<>();
private Map<String, Object> mapInput = null;

public ListModelList<MstGroupDealerDto> getMstGroupDealerDtos() {
	return mstGroupDealerDtos;
}

public void setMstGroupDealerDtos(
		ListModelList<MstGroupDealerDto> mstGroupDealerDtos) {
	this.mstGroupDealerDtos = mstGroupDealerDtos;
}

public MstGroupDealerDto getMstGroupDealerDto() {
	return mstGroupDealerDto;
}

public void setMstGroupDealerDto(MstGroupDealerDto mstGroupDealerDto) {
	this.mstGroupDealerDto = mstGroupDealerDto;
}

public Set<Integer> getList() {
	return list;
}

public void setList(Set<Integer> list) {
	this.list = list;
}

public Map<String, Object> getMapInput() {
	return mapInput;
}

public void setMapInput(Map<String, Object> mapInput) {
	this.mapInput = mapInput;
}

public String getWS_URI() {
	return WS_URI;
}

@Init(superclass=true)
public void init(@ExecutionArgParam("listNotIn") Set<Integer> listNotIn,
		@ExecutionArgParam("mapInput")HashMap<String, Object> mapInput){
	if(listNotIn==null){
		setList(new HashSet<Integer>());
	}else {
		setList(listNotIn);
	}
	if(mapInput!=null)
		setMapInput(mapInput);
	loadList();
}

@Override
protected void loadList(){
	RestResponse restResponse = callWsWithPaging(WS_URI, new HashMap<String, Object>(), HttpMethod.POST);
	if(restResponse.getStatus()== CommonConstants.OK_REST_STATUS){
		mstGroupDealerDtos.clear();
		setTotalSize(restResponse.getTotalRecords());
		if(restResponse.getContents()!=null){
			try{
				mstGroupDealerDtos.addAll(JsonUtil.mapJsonToListObject(restResponse.getContents(), MstGroupDealerDto.class ));
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
@Command("choose")
public void chooseDate(){
	Map<String, Object> args = new HashMap<>();
	args.put("groupDealer", mstGroupDealerDto);
	returnValue(args);
}

}
