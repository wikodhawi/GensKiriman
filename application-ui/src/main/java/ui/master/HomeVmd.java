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
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import share.GensHargaKirimanDto;
import share.GensKirimanDto;
import share.GensWilayahDto;
import share.GensWilayahDto;
import share.GensWilayahDto;
import share.MstColorDto;
import share.MstGlobalParamDto;
import common.model.RestResponse;
import common.ui.BaseVmd;
import common.ui.UIConstants;
import common.util.CommonConstants;
import common.util.JsonUtil;

@Init(superclass = true)
public class HomeVmd extends BaseVmd implements Serializable {
	private static final long serialVersionUID = 1L;

	private final String INDEX_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/GensKiriman2/_index.zul";
	private final String DETAIL_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/GensKiriman2/_detail.zul";
	private final String WS_URI = "/GensWilayah";
	private final String ZS_URI = "/GensKiriman";
	

	List<GensWilayahDto> gensWilayahDtos = new ArrayList<GensWilayahDto>();
	private GensWilayahDto gensWilayahDto = new GensWilayahDto();
	private GensWilayahDto GensWilayahDtoSelected = new GensWilayahDto();
	private Form formMaster = new SimpleForm();

	private GensWilayahDto kotaAsalDto;
	private GensWilayahDto kotaTujuanDto;
	private GensHargaKirimanDto gensHargaKirimanDto;
	private List<GensHargaKirimanDto> gensHargaKirimanDtos=new ArrayList<GensHargaKirimanDto>();
	
	
	
	private int bobot;
	
	public int totalHarga;
	
	private String search;
	
	private List<GensKirimanDto> gensKirimanDtos = new ArrayList<GensKirimanDto>();
	private GensKirimanDto gensKirimanDto;

	private boolean statusPopUp=false;
	
	
	
	
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

	public List<GensWilayahDto> getGensWilayahDtos() {
		return gensWilayahDtos;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getBobot() {
		return bobot;
	}

	public void setBobot(int bobot) {
		this.bobot = bobot;
	}

	public int getTotalHarga() {
		return totalHarga;
	}

	public void setTotalHarga(int totalHarga) {
		this.totalHarga = totalHarga;
	}

	public List<GensHargaKirimanDto> getGensHargaKirimanDtos() {
		return gensHargaKirimanDtos;
	}

	public void setGensHargaKirimanDtos(
			List<GensHargaKirimanDto> gensHargaKirimanDtos) {
		this.gensHargaKirimanDtos = gensHargaKirimanDtos;
	}

	public GensHargaKirimanDto getGensHargaKirimanDto() {
		return gensHargaKirimanDto;
	}

	public void setGensHargaKirimanDto(GensHargaKirimanDto gensHargaKirimanDto) {
		this.gensHargaKirimanDto = gensHargaKirimanDto;
	}

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

	@Override
	protected void loadList() {
//		Messagebox.show("test");
		gensHargaKirimanDtos.addAll(getHargaKirimanDtos());
		
		BindUtils.postNotifyChange(null, null, this, "gensHargaKirimanDtos");
	}
	
	private List<GensHargaKirimanDto> getHargaKirimanDtos() {
		List<GensHargaKirimanDto> out = new ArrayList<GensHargaKirimanDto>();
		RestResponse rest = callWs("/GensHargaKiriman/getall/",
				null, HttpMethod.GET);
		try {
			out = JsonUtil.mapJsonToListObject(rest.getContents(),
					GensHargaKirimanDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
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
	public void search()
	{
		Sessions.getCurrent().setAttribute("search", search);
		setStatusPopUp(true);
		System.out.println(statusPopUp);
		System.out.println(search);
		
		Map<String, Object> arguments = new HashMap<String, Object>();
//        arguments.put("orderId", orderDto.getOrderId());
		String template = DETAIL_PAGE_PATH;
        Window window = (Window)Executions.createComponents(template, null, arguments);
        window.doModal();
		
		
//		getPageInfo().setAddMode(true);
//		gensKirimanDtos.addAll(getKiriman(search));
//		gensKirimanDto=gensKirimanDtos.get(0);
//		System.out.println(gensKirimanDto.getNamaPenerima());
//		BindUtils.postNotifyChange(null, null, this, "gensKirimanDto");
//		BindUtils.postNotifyChange(null, null, this, "gensKirimanDtos");
		
//		navigate(DETAIL_PAGE_PATH);
	}
	
	@Command
	public void calculateHarga()
	{
		//totalHarga=bobot* Integer.valueOf(gensHargaKirimanDto.getHargaPerSkor().intValue()) *(int) kotaAsalDto.getLatitude();
		//Math.pow( (kotaAsalDto.getLatitude()-kotaTujuanDto.getLatitude() )
		int skor=(int)  Math.sqrt( (Math.pow( kotaAsalDto.getLatitude()*1.0-kotaTujuanDto.getLatitude()*1.0,2.0)+ Math.pow( kotaAsalDto.getLongitude()*1.0-kotaTujuanDto.getLongitude()*1.0,2.0))*1.0 )  ;
		if(skor==0) skor=1;
		totalHarga=bobot*Integer.valueOf(gensHargaKirimanDto.getHargaPerSkor().intValue())*skor;
		BindUtils.postNotifyChange(null, null, this, "totalHarga");
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


	@GlobalCommand("gensWilayahHandler")
	public void gensWilayahHandler(
			@BindingParam("gensWilayahKotaAsal") GensWilayahDto dto){
		formMaster.setField("namaWilayahKotaAsal", dto.getNamaWilayah());
		BindUtils.postNotifyChange(null, null, formMaster, "namaWilayahKotaAsal");
		kotaAsalDto=dto;
	}
	
	@GlobalCommand("gensWilayahHandler2")
	public void gensWilayahHandler2(
			@BindingParam("gensWilayahKotaTujuan") GensWilayahDto dto){
		formMaster.setField("namaWilayahKotaTujuan", dto.getNamaWilayah());
		BindUtils.postNotifyChange(null, null, formMaster, "namaWilayahKotaTujuan");
		kotaTujuanDto=dto;
	}
	
	
	
	public void setGensWilayahDtos(List<GensWilayahDto> gensWilayahDtos) {
		this.gensWilayahDtos = gensWilayahDtos;
	}

	public GensWilayahDto getGensWilayahDto() {
		return gensWilayahDto;
	}

	public void setGensWilayahDto(GensWilayahDto gensWilayahDto) {
		this.gensWilayahDto = gensWilayahDto;
	}

	public GensWilayahDto getGensWilayahDtoSelected() {
		return GensWilayahDtoSelected;
	}

	public void setGensWilayahDtoSelected(GensWilayahDto gensWilayahDtoSelected) {
		GensWilayahDtoSelected = gensWilayahDtoSelected;
	}

	public Form getFormMaster() {
		return formMaster;
	}

	public void setFormMaster(Form formMaster) {
		this.formMaster = formMaster;
	}

	

}
