package ui.master;

import java.io.Serializable;
import java.math.BigDecimal;
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

import share.GensHargaKirimanDto;
import share.GensKirimanDto;
import share.GensWilayahDto;
import share.MstGroupDealerDto;
import common.model.RestResponse;
import common.ui.BaseVmd;
import common.ui.UIConstants;
import common.util.CommonConstants;
import common.util.JsonUtil;

@Init(superclass = true)
public class GensKirimanVmd extends BaseVmd implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String INDEX_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/GensKiriman/_index.zul";
	private final String DETAIL_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/GensKiriman/_detail.zul";
	private final String WS_URI = "/GensKiriman";

	List<GensKirimanDto> indexDtos = new ArrayList<GensKirimanDto>();
	private GensKirimanDto gensKirimanDto = new GensKirimanDto();
	private GensKirimanDto gensKirimanDtoSelected = new GensKirimanDto();
	
	private final String XS_URI = "/GensWilayah";
	private final String ZS_URI = "/GensHargaKiriman";
	

	List<GensWilayahDto> gensWilayahDtos = new ArrayList<GensWilayahDto>();
	private GensWilayahDto gensWilayahDto = new GensWilayahDto();
	private GensWilayahDto GensWilayahDtoSelected = new GensWilayahDto();
	private Form formMaster = new SimpleForm();
	private Form formMaster2 = new SimpleForm();

	private GensWilayahDto kotaAsalDto;
	private GensWilayahDto kotaTujuanDto;
	private GensHargaKirimanDto gensHargaKirimanDto;
	private List<GensHargaKirimanDto> gensHargaKirimanDtos=new ArrayList<GensHargaKirimanDto>();
	
	private int bobot;
	
	public int totalHarga;
	
	

	
	

	@Override
	protected void loadList() {
		Map<String, Object> map = new HashMap<>();
		map.put("testing", "JSON");
		RestResponse rest = callWsWithPaging(WS_URI + "/all/paging", map,
				HttpMethod.POST);
		try {
			indexDtos = JsonUtil.mapJsonToListObject(rest.getContents(),
					GensKirimanDto.class);
			setTotalSize(rest.getTotalRecords());
			BindUtils.postNotifyChange(null, null, this, "indexDtos");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gensHargaKirimanDtos.addAll(getHargaKirimanDtos());
		
		BindUtils.postNotifyChange(null, null, this, "gensHargaKirimanDtos");
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
	
	@Override
	public void onAdd() {
		gensHargaKirimanDtos.addAll(getHargaKirimanDtos());
		BindUtils.postNotifyChange(null, null, this, "gensHargaKirimanDto");
		BindUtils.postNotifyChange(null, null, this, "gensHargaKirimanDtos");
	}

	@Command
	public void back() {
		getPageInfo().setListMode(true);
		navigate(INDEX_PAGE_PATH);
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
	
	@Command
	public void save() {
		gensKirimanDto.setKodeWilayahAsal(kotaAsalDto.getKodeWilayah());
		gensKirimanDto.setKodeWilayahTujuan(kotaTujuanDto.getKodeWilayah());
		gensKirimanDto.setHargaTotal(BigDecimal.valueOf(totalHarga));
		gensKirimanDto.setBerat(BigDecimal.valueOf(bobot).movePointLeft(2));
		gensKirimanDto.setHargaJenis(gensHargaKirimanDto.getHargaPerSkor());
		gensKirimanDto.setJenisKiriman(gensHargaKirimanDto.getKodeKiriman());
		gensKirimanDto.setCompanyCode(getCurrentUserSession().getCompanyCode());
		
		if (getPageInfo().isAddMode()) {
			gensKirimanDto.setCreatedBy(getCurrentUserSession().getUserId());
			gensKirimanDto.setCreatedDate(new Date());
		} else {
			gensKirimanDto.setUpdatedBy(getCurrentUserSession().getUserId());
			gensKirimanDto.setUpdatedDate(new Date());
		}
		RestResponse rest = callCustomWs(WS_URI, gensKirimanDto,
				HttpMethod.POST);
		if (rest.getStatus() == CommonConstants.OK_REST_STATUS) {
			showSmartMsgBox(rest.getMessage());
			back();
		} else {
			showSmartMsgBox(rest.getMessage());
		}
		

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

	@GlobalCommand("gensWilayahHandler")
	public void gensWilayahHandler(
			@BindingParam("gensWilayahKotaAsal") GensWilayahDto dto){
		formMaster2.setField("namaWilayahKotaAsal", dto.getNamaWilayah());
		BindUtils.postNotifyChange(null, null, formMaster2, "namaWilayahKotaAsal");
		kotaAsalDto=dto;
	}
	
	@GlobalCommand("gensWilayahHandler2")
	public void gensWilayahHandler2(
			@BindingParam("gensWilayahKotaTujuan") GensWilayahDto dto){
		formMaster2.setField("namaWilayahKotaTujuan", dto.getNamaWilayah());
		BindUtils.postNotifyChange(null, null, formMaster2, "namaWilayahKotaTujuan");
		kotaTujuanDto=dto;
	}
	

	public List<GensWilayahDto> getGensWilayahDtos() {
		return gensWilayahDtos;
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

	public GensHargaKirimanDto getGensHargaKirimanDto() {
		return gensHargaKirimanDto;
	}

	public void setGensHargaKirimanDto(GensHargaKirimanDto gensHargaKirimanDto) {
		this.gensHargaKirimanDto = gensHargaKirimanDto;
	}

	public List<GensHargaKirimanDto> getGensHargaKirimanDtos() {
		return gensHargaKirimanDtos;
	}

	public void setGensHargaKirimanDtos(
			List<GensHargaKirimanDto> gensHargaKirimanDtos) {
		this.gensHargaKirimanDtos = gensHargaKirimanDtos;
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

	public List<GensKirimanDto> getIndexDtos() {
		return indexDtos;
	}

	public void setIndexDtos(List<GensKirimanDto> indexDtos) {
		this.indexDtos = indexDtos;
	}

	public GensKirimanDto getGensKirimanDto() {
		return gensKirimanDto;
	}

	public void setGensKirimanDto(GensKirimanDto gensKirimanDto) {
		this.gensKirimanDto = gensKirimanDto;
	}

	public GensKirimanDto getGensKirimanDtoSelected() {
		return gensKirimanDtoSelected;
	}

	public void setGensKirimanDtoSelected(GensKirimanDto gensKirimanDtoSelected) {
		this.gensKirimanDtoSelected = gensKirimanDtoSelected;
	}

	public Form getFormMaster() {
		return formMaster;
	}

	public void setFormMaster(Form formMaster) {
		this.formMaster = formMaster;
	}

	public Form getFormMaster2() {
		return formMaster2;
	}

	public void setFormMaster2(Form formMaster2) {
		this.formMaster2 = formMaster2;
	}

	
}
