package core.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.util.StringUtil;
import core.dao.master.MstCounterDao;
import core.model.MstCounter;
import core.model.MstCounterPK;
import core.service.NumberGeneratorSvc;

@Service
@Transactional
public class NumberGeneratorSvcImpl implements NumberGeneratorSvc {
	private static Logger logger = LoggerFactory
			.getLogger(NumberGeneratorSvcImpl.class);

	@Autowired
	MstCounterDao mstCounterDao;
	
	@Override
	public String getNextNumericNumber(String companyCode, String trxCode,
			String createdBy) {
		Date today = new Date();
		MstCounterPK mstCounterPK = new MstCounterPK();
		mstCounterPK.setCompanyCode(companyCode);
		mstCounterPK.setBranchCode("_");
		mstCounterPK.setTrxCode(trxCode);
		mstCounterPK.setCashBankCode("_");
		mstCounterPK.setDirectPrefix("_");
		mstCounterPK.setYear(0);
		mstCounterPK.setMonth(0);
		mstCounterPK.setDay(0);
		
		String nextNumber;
		
		MstCounter counter = mstCounterDao.findOne(mstCounterPK);
		if (counter == null){
			nextNumber = "1";
			counter = new MstCounter(mstCounterPK);
			counter.setCreatedBy(createdBy);
			counter.setCreatedDate(today);
		} else {
			nextNumber = String.valueOf(counter.getLastNo().add(new BigDecimal(1)));
			counter.setUpdatedBy(createdBy);
			counter.setUpdatedDate(today);
		}
		
		counter.setLastNo(new BigDecimal(nextNumber));
		if (nextNumber.length() > Integer.valueOf("5")) {
//			logger.debug("LARGER DIGIT");
			logger.debug("NUMBER WAS EXPIRED");
		}
		String n = StringUtil.addCharToLeft(nextNumber, '0',
				Integer.valueOf("5"));
		
		mstCounterDao.save(counter);
		
		return n;
	}

}
