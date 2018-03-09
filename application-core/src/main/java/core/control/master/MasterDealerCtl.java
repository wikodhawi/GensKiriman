package core.control.master;

import java.util.HashMap;
import java.util.Map;

import javassist.expr.NewArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import share.MstDealerDto;
import common.model.RestResponse;
import common.util.CommonConstants;
import core.service.master.MasterDealerSvc;
import core.service.master.MasterGroupDealerSvc;

@RestController
@RequestMapping("/MasterDealer")
public class MasterDealerCtl {

	@Autowired
	MasterDealerSvc masterDealerSvc;
	
	@Autowired
	MasterGroupDealerSvc masterGroupDealerSvc;
	
	@RequestMapping(method = RequestMethod.POST)
	public RestResponse save(@RequestBody MstDealerDto mstDealerDto){
		int status;
		String message;
		try {
			masterDealerSvc.save(mstDealerDto);
			status = CommonConstants.OK_REST_STATUS;
			message = "I001";
		} catch (Exception e) {
			status = CommonConstants.ERROR_REST_STATUS;
			message = "E003";
		}
		return new RestResponse(status, message, new HashMap<String, Object>());
	}
	
	@RequestMapping(value = "/all/paging/{pageSequence}/{size}",method = RequestMethod.POST)
	public RestResponse loadList(
			@RequestParam(value = CommonConstants.SEARCH, required =false) String search,
			@RequestParam(value = CommonConstants.DIRECTION, required=false) String direction,
			@RequestParam(value= CommonConstants.ORDER_BY, required=false)String orderBy,
			@PathVariable("pageSequence") int pageSequence,
			@PathVariable("size") int size,
			@RequestBody Map<String, Object> mapInput){
		
		Map<String, Object> map = masterDealerSvc.loadList(mapInput, search, pageSequence, size, direction, orderBy);
		return new RestResponse(CommonConstants.OK_REST_STATUS, null,
				map.get("contentData"), (long) map.get("totalRecords"));
	};
	
	@RequestMapping(value = "/lov/groupDealer/{pageSequence}/{size}",method = RequestMethod.POST)
	public RestResponse loadListLov(
			@RequestParam(value = CommonConstants.SEARCH, required =false) String search,
			@RequestParam(value = CommonConstants.DIRECTION, required=false) String direction,
			@RequestParam(value= CommonConstants.ORDER_BY, required=false)String orderBy,
			@PathVariable("pageSequence") int pageSequence,
			@PathVariable("size") int size,
			@RequestBody Map<String, Object> mapInput){
		
		Map<String, Object> map = masterGroupDealerSvc.loadList(mapInput, search, pageSequence, size, direction, orderBy);
		return new RestResponse(CommonConstants.OK_REST_STATUS, null,
				map.get("contentData"), (long) map.get("totalRecords"));
	};
	
}
