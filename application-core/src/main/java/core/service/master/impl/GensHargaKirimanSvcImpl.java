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
import share.GensHargaKirimanDto;
import share.GensHargaKirimanDto;
import core.dao.master.GensHargaKirimanDao;
import core.model.GensHargaKiriman;
import core.model.GensHargaKiriman;
import core.service.master.GensHargaKirimanSvc;


@Service
@Transactional
public class GensHargaKirimanSvcImpl implements GensHargaKirimanSvc {

	Paging page = new Paging();
	
	
	@Autowired
	GensHargaKirimanDao gensHargaKirimanDao;
	
	@Autowired
	MapperFacade mapperFacade;
	
	@Override
	public Map<String, Object> findAll() {
		List<GensHargaKirimanDto> gensHargaKirimanDtos=new ArrayList<GensHargaKirimanDto>();
		List<GensHargaKiriman> gensHargaKirimans=new ArrayList<GensHargaKiriman>();
		gensHargaKirimans=gensHargaKirimanDao.findAll();
		for(GensHargaKiriman gensHargaKiriman:gensHargaKirimans)
		{
			gensHargaKirimanDtos.add(mapperFacade.map(gensHargaKiriman, GensHargaKirimanDto.class));
			
		}
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", gensHargaKirimanDtos.size());
		map.put("contentData", gensHargaKirimanDtos);
		return map;
//		return gensHargaKirimanDtos;
	}

	@Override
	public Map<String, Object> loadList(Map<String, Object> mapInput,
			String search, int pageSequence, int size, String direction,
			String orderBy) {
		/*
		if(orderBy.isEmpty()){
			orderBy = "kodeKiriman";
		}
		direction = "asc";
		Page<GensHargaKiriman> datas = gensHargaKirimanDao.getDataLoadList(StringUtil.nevl(search, "%%"), page.getPageable(pageSequence, size, direction, orderBy));
		List<GensHargaKirimanDto> dtos = new ArrayList<GensHargaKirimanDto>();
		
		for(GensHargaKiriman o : datas){
			dtos.add(mapperFacade.map(o, GensHargaKirimanDto.class));
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", datas.getTotalElements());
		map.put("contentData", dtos);
		return map;
		*/
		return null;
	}

}
