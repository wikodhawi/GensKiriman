package ui.master;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Sessions;

import share.GensKirimanDto;
import common.model.RestResponse;
import common.ui.BaseVmd;
import common.ui.UIConstants;
import common.util.JsonUtil;

@Init(superclass = true)
public class ResiVmd extends BaseVmd implements Serializable {
	private static final long serialVersionUID = 1L;

	private final String INDEX_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/GensKiriman2/_index.zul";
	private final String DETAIL_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/GensKiriman2/_detail.zul";
	private final String WS_URI = "/GensWilayah";
	private final String ZS_URI = "/GensKiriman";

	
	private List<GensKirimanDto> gensKirimanDtos = new ArrayList<GensKirimanDto>();
	private GensKirimanDto gensKirimanDto;

	private boolean statusPopUp=false;
	
	private String search;
	
	
	
	

	@Override
	protected void loadList() {
//		Messagebox.show("test");
		
		System.out.println("pindah halaman tes");
		
		search = (String) Sessions.getCurrent().getAttribute("search");
		gensKirimanDtos.addAll(getKiriman(search));
		gensKirimanDto=gensKirimanDtos.get(0);
		BindUtils.postNotifyChange(null, null, this, "gensKirimanDtos");
		BindUtils.postNotifyChange(null, null, this, "gensKirimanDto");
	}
	
	
	private List<GensKirimanDto> getKiriman(String search) {
		List<GensKirimanDto> out = new ArrayList<GensKirimanDto>();
		RestResponse rest = callWs(ZS_URI+"/search/"+search,
				null, HttpMethod.GET);
		try {
			out = JsonUtil.mapJsonToListObject(rest.getContents(),
					GensKirimanDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}
	
	@Command
	public void backs() {
		System.out.println("cekoutput");
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public boolean isStatusPopUp() {
		return statusPopUp;
	}

	public void setStatusPopUp(boolean statusPopUp) {
		this.statusPopUp = statusPopUp;
	}

	public List<GensKirimanDto> getGensKirimanDtos() {
		return gensKirimanDtos;
	}

	public void setGensKirimanDtos(List<GensKirimanDto> gensKirimanDtos) {
		this.gensKirimanDtos = gensKirimanDtos;
	}

	public GensKirimanDto getGensKirimanDto() {
		return gensKirimanDto;
	}

	public void setGensKirimanDto(GensKirimanDto gensKirimanDto) {
		this.gensKirimanDto = gensKirimanDto;
	}

}