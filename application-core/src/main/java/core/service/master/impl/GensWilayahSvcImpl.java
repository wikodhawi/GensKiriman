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
import share.GensWilayahDto;
import share.GensWilayahDto;
import core.dao.master.GensWilayahDao;
import core.model.GensWilayah;
import core.model.GensWilayah;
import core.service.master.GensWilayahSvc;


@Service
@Transactional
public class GensWilayahSvcImpl implements GensWilayahSvc {

	Paging page = new Paging();
	
	
	@Autowired
	GensWilayahDao gensWilayahDao;
	
	@Autowired
	MapperFacade mapperFacade;
	
	@Override
	public Map<String, Object> findAll() {
		List<GensWilayahDto> gensWilayahDtos=new ArrayList<GensWilayahDto>();
		List<GensWilayah> gensWilayahs=new ArrayList<GensWilayah>();
		gensWilayahs=gensWilayahDao.findAll();
		for(GensWilayah gensWilayah:gensWilayahs)
		{
			gensWilayahDtos.add(mapperFacade.map(gensWilayah, GensWilayahDto.class));
			
		}
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", gensWilayahDtos.size());
		map.put("contentData", gensWilayahDtos);
		return map;
//		return gensWilayahDtos;
	}

	@Override
	public Map<String, Object> loadList(Map<String, Object> mapInput,
			String search, int pageSequence, int size, String direction,
			String orderBy) {
		if(orderBy.isEmpty()){
			orderBy = "namaWilayah";
		}
		direction = "asc";
		Page<GensWilayah> datas = gensWilayahDao.getDataLoadList(StringUtil.nevl(search, "%%"), page.getPageable(pageSequence, size, direction, orderBy));
		List<GensWilayahDto> dtos = new ArrayList<GensWilayahDto>();
		
		for(GensWilayah o : datas){
			dtos.add(mapperFacade.map(o, GensWilayahDto.class));
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", datas.getTotalElements());
		map.put("contentData", dtos);
		return map;
	}

}
