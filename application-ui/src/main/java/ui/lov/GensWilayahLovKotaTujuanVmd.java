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

import share.GensWilayahDto;
import common.model.RestResponse;
import common.ui.BaseLovVmd;
import common.util.CommonConstants;
import common.util.JsonUtil;

public class GensWilayahLovKotaTujuanVmd extends BaseLovVmd implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String WS_URI = "/GensWilayah/all/paging";
	private ListModelList<GensWilayahDto> gensWilayahDtos = new ListModelList<>();
	private GensWilayahDto gensWilayahDto;
	private Set<Integer> list = new HashSet<>();
	private Map<String, Object> mapInput = null;
	private GensWilayahDto kotaAsalDto;
	private GensWilayahDto kotaTujuanDto;
	
	
	
	
	public GensWilayahDto getKotaAsalDto() {
		return kotaAsalDto;
	}

	public void setKotaAsalDto(GensWilayahDto kotaAsalDto) {
		this.kotaAsalDto = kotaAsalDto;
	}

	public GensWilayahDto getKotaTujuanDto() {
		return kotaTujuanDto;
	}

	public void setKotaTujuanDto(GensWilayahDto kotaTujuanDto) {
		this.kotaTujuanDto = kotaTujuanDto;
	}

	public ListModelList<GensWilayahDto> getgensWilayahDtos() {
		return gensWilayahDtos;
	}
	
	public void setgensWilayahDtos(
			ListModelList<GensWilayahDto> gensWilayahDtos) {
		this.gensWilayahDtos = gensWilayahDtos;
	}
	
	public GensWilayahDto getGensWilayahDto() {
		return gensWilayahDto;
	}
	
	public void setGensWilayahDto(GensWilayahDto GensWilayahDto) {
		this.gensWilayahDto = GensWilayahDto;
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
			gensWilayahDtos.clear();
			setTotalSize(restResponse.getTotalRecords());
			if(restResponse.getContents()!=null){
				try{
					gensWilayahDtos.addAll(JsonUtil.mapJsonToListObject(restResponse.getContents(), GensWilayahDto.class ));
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	@Command("choose")
	public void chooseDate(){
		Map<String, Object> args = new HashMap<>();
		args.put("gensWilayahKotaTujuan", gensWilayahDto);
		returnValue(args);
	}

}
