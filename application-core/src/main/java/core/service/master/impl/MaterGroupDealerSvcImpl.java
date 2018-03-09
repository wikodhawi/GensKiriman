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
import share.MstColorDto;
import share.MstGroupDealerDto;
import core.dao.master.MstGroupDealerDao;
import core.model.MstColor;
import core.model.MstGroupDealer;
import core.service.master.MasterGroupDealerSvc;

@Service
@Transactional
public class MaterGroupDealerSvcImpl implements MasterGroupDealerSvc {
	
	@Autowired
	MstGroupDealerDao mstGroupDealerDao;
	
	@Autowired
	MapperFacade mapperFacade;
	
	Paging page = new Paging();

	@Override
	public Map<String, Object> loadList(Map<String, Object> mapInput,
			String search, int pageSequence, int size, String direction,
			String orderBy) {
		
		orderBy = "groupDealerCode";
		direction = "asc";
		
		Page<MstGroupDealer> datas = mstGroupDealerDao.getDataLoadList(page.getPageable(pageSequence, size, direction, orderBy));
		List<MstGroupDealerDto> dtos = new ArrayList<MstGroupDealerDto>();
		
		for(MstGroupDealer o : datas){
			dtos.add(mapperFacade.map(o, MstGroupDealerDto.class));
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", datas.getTotalElements());
		map.put("contentData", dtos);
		return map;
	}

}
