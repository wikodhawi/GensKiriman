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
import share.MstDealerDto;
import share.MstGroupDealerDto;
import core.dao.master.MstDealerDao;
import core.dao.master.MstGroupDealerDao;
import core.model.MstDealer;
import core.model.MstGroupDealer;
import core.service.NumberGeneratorSvc;
import core.service.master.MasterDealerSvc;

@Service
@Transactional
public class MasterDealerSvcImpl implements MasterDealerSvc {
	@Autowired
	MstDealerDao mstDealerDao;

	@Autowired
	MapperFacade mapperFacade;

	@Autowired
	NumberGeneratorSvc numberGenerator;

	Paging page = new Paging();

	@Override
	public void save(MstDealerDto mstDealerDto) {
		String dealerCode = "";
		if (mstDealerDto.getDealerCode() == null)
			dealerCode = numberGenerator.getNextNumericNumber(
					mstDealerDto.getCompanyCode(), "MDLR01",
					mstDealerDto.getCreatedBy());
		else
			dealerCode = mstDealerDto.getDealerCode();
		
		MstDealer mstDealer = mapperFacade.map(mstDealerDto, MstDealer.class);
		mstDealer.setDealerCode(dealerCode);
		mstDealerDao.save(mstDealer);
	}

	@Override
	public Map<String, Object> loadList(Map<String, Object> mapInput,
			String search, int pageSequence, int size, String direction,
			String orderBy) {
		orderBy = "dealerCode";
		direction = "asc";

		Page<MstDealer> datas = mstDealerDao.getDataLoadList(page.getPageable(
				pageSequence, size, direction, orderBy));
		List<MstDealerDto> dtos = new ArrayList<MstDealerDto>();

		for (MstDealer o : datas) {
			dtos.add(mapperFacade.map(o, MstDealerDto.class));
		}

		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", datas.getTotalElements());
		map.put("contentData", dtos);
		return map;

	}

}
