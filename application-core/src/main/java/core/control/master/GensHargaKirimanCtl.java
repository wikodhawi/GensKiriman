 package core.control.master;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import common.model.RestResponse;
import common.util.CommonConstants;
import core.service.master.GensHargaKirimanSvc;

@RestController
@RequestMapping("/GensHargaKiriman")
public class GensHargaKirimanCtl {
	
	@Autowired
	GensHargaKirimanSvc gensHargaKirimanSvc;

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public RestResponse loadList() {

		Map<String, Object> map = gensHargaKirimanSvc.findAll();
		return new RestResponse(CommonConstants.OK_REST_STATUS, null,
				map.get("contentData"));

	};
	
	@RequestMapping(value = "/all/paging/{pageSequence}/{size}", method = RequestMethod.POST)
	public RestResponse loadListLov(
			@RequestParam(value=CommonConstants.SEARCH, required=false) String search,
			@RequestParam(value=CommonConstants.DIRECTION, required=false) String direction,
			@RequestParam(value=CommonConstants.ORDER_BY, required=false) String orderBy,
			@PathVariable("pageSequence") int pageSequence,
			@PathVariable("size") int size,
			@RequestBody Map<String, Object> mapInput) {

		Map<String, Object> map = gensHargaKirimanSvc.loadList(mapInput, search, pageSequence, size, direction, orderBy);
		return new RestResponse(CommonConstants.OK_REST_STATUS, null,
				map.get("contentData"), (long) map.get("totalRecords"));

	};
}
