package core.service.master.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import share.GensHargaKirimanDto5;
import common.spring.Paging;
import core.dao.master.GensHargaKirimanDao5;
import core.model.GensHargaKiriman5;
import core.service.NumberGeneratorSvc;
import core.service.master.GensHargaKirimanSvc5;

@Service
@Transactional
public class GensHargaKirimanSvcImpl5 implements GensHargaKirimanSvc5{
	@Autowired
	GensHargaKirimanDao5 gensHargaKirimanDao;

	@Autowired
	MapperFacade mapperFacade;

	@Autowired
	NumberGeneratorSvc numberGeneratorSvc;

	Paging page = new Paging();

	@Override
	public void save(GensHargaKirimanDto5 gensHargaKirimanDto) {
		String kodeKiriman = "";
		if (gensHargaKirimanDto.getKodeKiriman() == null)
			kodeKiriman = numberGeneratorSvc.getNextNumericNumber(
					gensHargaKirimanDto.getCompanyCode(), "MDLR01",
					gensHargaKirimanDto.getCreatedBy());
		else
			kodeKiriman = gensHargaKirimanDto.getKodeKiriman();

		GensHargaKiriman5 gensHargaKiriman = mapperFacade.map(gensHargaKirimanDto, GensHargaKiriman5.class);
		gensHargaKiriman.setKodeKiriman(kodeKiriman);
		gensHargaKirimanDao.save(gensHargaKiriman);
	}

	@Override
	public Map<String, Object> loadList(Map<String, Object> mapInput,
			String search, int pageSequence, int size, String direction,
			String orderBy) {
		orderBy = "id";
		direction = "asc";

		Page<GensHargaKiriman5> datas = gensHargaKirimanDao.getDataLoadList(page.getPageable(
				pageSequence, size, direction, orderBy));
		List<GensHargaKirimanDto5> dtos = new ArrayList<GensHargaKirimanDto5>();
		
		for (GensHargaKiriman5 o : datas){
			dtos.add(mapperFacade.map(o, GensHargaKirimanDto5.class));
		}

		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", datas.getTotalElements());
		map.put("contentData", dtos);
		return map;

	}

}
