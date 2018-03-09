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

import share.MstDealerDto;
import share.MstGlobalParamDto;
import common.spring.Paging;
import common.util.StringUtil;
import core.dao.master.MstGlobalParamDao;
import core.model.MstDealer;
import core.model.MstGlobalParam;
import core.service.master.MasterGlobalParamSvc;

@Service
@Transactional
public class MasterGlobalParamSvcImpl implements MasterGlobalParamSvc {
	@Autowired
	MstGlobalParamDao mstGlobalParamDao;
	
	@Autowired
	MapperFacade mapperFacade;
	
	Paging page = new Paging();
	
	@Override
	public Map<String, Object> loadList(
			String search) {
		List<MstGlobalParam> datas = mstGlobalParamDao.getDataLoadListSearch(StringUtil.nevl(search, "%%"));
		List<MstGlobalParamDto> dtos = new ArrayList<MstGlobalParamDto>();
		
		for(MstGlobalParam o : datas){
			dtos.add(mapperFacade.map(o, MstGlobalParamDto.class));
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("contentData", dtos);
		return map;
	}

}
