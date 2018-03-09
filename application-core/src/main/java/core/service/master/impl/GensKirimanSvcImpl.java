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

import common.spring.Paging;
import common.util.StringUtil;
import share.GensKirimanDto;
import core.dao.master.GensKirimanDao;
import core.model.GensKiriman;
import core.service.NumberGeneratorSvc;
import core.service.master.GensKirimanSvc;

@Service
@Transactional
public class GensKirimanSvcImpl implements GensKirimanSvc {

	@Autowired
	GensKirimanDao gensKirimanDao;

	@Autowired
	MapperFacade mapperFacade;

	@Autowired
	NumberGeneratorSvc numberGeneratorSvc;

	Paging page = new Paging();

	@Override
	public void save(GensKirimanDto gensKirimanDto) {
		String id = "";
		if (gensKirimanDto.getId() == null)
			id = numberGeneratorSvc.getNextNumericNumber(
					gensKirimanDto.getCompanyCode(), "GL02",
					gensKirimanDto.getCreatedBy());
		else
			id = gensKirimanDto.getId();

		GensKiriman gensKiriman = mapperFacade.map(gensKirimanDto,
				GensKiriman.class);
		gensKiriman.setId(id);
		gensKirimanDao.save(gensKiriman);
	}

	@Override
	public Map<String, Object> loadList(Map<String, Object> mapInput,
			String search, int pageSequence, int size, String direction,
			String orderBy) {
		orderBy = "id";
		direction = "asc";
		
		Page<GensKiriman> datas = gensKirimanDao.getDataLoadList(StringUtil.nevl(search, "%%"), page.getPageable(pageSequence, size, direction, orderBy));
		List<GensKirimanDto> dtos = new ArrayList<GensKirimanDto>();
		
		for (GensKiriman o : datas){
			dtos.add(mapperFacade.map(o, GensKirimanDto.class));
		}

		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", datas.getTotalElements());
		map.put("contentData", dtos);
		return map;
	}

	@Override
	public Map<String, Object> searchResi(String search) {
		
		String searchJenisKiriman=search.substring(0, 3);
		String searchId=search.substring(3, 8);
		
		System.out.println(search);
		System.out.println(searchId);
		System.out.println(searchJenisKiriman);
//		return null;
		List<GensKiriman> datas = gensKirimanDao.searchResi("%"+searchId+"%", "%"+searchJenisKiriman+"%");
		List<GensKirimanDto> dtos = new ArrayList<GensKirimanDto>();
		
		for (GensKiriman o : datas){
			dtos.add(mapperFacade.map(o, GensKirimanDto.class));
		}

		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", datas.size());
		map.put("contentData", dtos);
		return map;
	}

}
