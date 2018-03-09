package core.service.master.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.spring.Paging;
import common.util.StringUtil;
import share.MstColorDto;
import core.dao.master.MstColorDao;
import core.model.MstColor;
import core.model.MstCompany;
import core.service.NumberGeneratorSvc;
import core.service.master.MasterColorSvc;

@Service
@Transactional
public class MasterColorSvcImpl implements MasterColorSvc {
	
	Paging page = new Paging();
	
	@Autowired
	MstColorDao mstColorDao;
	
	@Autowired
	NumberGeneratorSvc numberGenerator;
	
	@Autowired
	MapperFacade mapperFacade;

	@Override
	public void save(MstColorDto mstColorDto) {
		String colorCode = "";
		if(mstColorDto.getColorCode()==null)
			colorCode = numberGenerator.getNextNumericNumber(mstColorDto.getCompanyCode(), "GL02", mstColorDto.getCreatedBy());
		else
			colorCode = mstColorDto.getColorCode();
		
		MstColor mstColor = mapperFacade.map(mstColorDto, MstColor.class);
		mstColor.setColorCode(colorCode);
		mstColorDao.save(mstColor);
	}

	@Override
	public Map<String, Object> loadList(Map<String, Object> mapInput, String search, int pageSequence, int size, String direction, String orderBy) {
		// TODO Auto-generated method stub
		if(orderBy.isEmpty()){
			orderBy = "colorCode";
		}
		direction = "asc";
		Page<MstColor> datas = mstColorDao.getDataLoadList(StringUtil.nevl(search, "%%"), page.getPageable(pageSequence, size, direction, orderBy));
		List<MstColorDto> dtos = new ArrayList<MstColorDto>();
		
		for(MstColor o : datas){
			dtos.add(mapperFacade.map(o, MstColorDto.class));
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", datas.getTotalElements());
		map.put("contentData", dtos);
		return map;
	}
} 
