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

import share.GensHargaKirimanDto5;
import share.MstColorDto;
import common.model.RestResponse;
import common.util.CommonConstants;
import core.service.master.GensHargaKirimanSvc5;
import core.service.master.GensKirimanSvc;

@RestController
@RequestMapping("/GensHargaKiriman5")
public class GensHargaKirimanCtl5 {
	@Autowired
	 GensHargaKirimanSvc5 gensHargaKirimanSvc;
	
	@RequestMapping(method = RequestMethod.POST)
	public RestResponse save(@RequestBody GensHargaKirimanDto5 gensHargaKirimanDto){	
		int status;
		String message;
		try {
			gensHargaKirimanSvc.save(gensHargaKirimanDto);
			status = CommonConstants.OK_REST_STATUS;
			message = "I001";
		} catch (Exception e) {
			// TODO: handle exception
			status = CommonConstants.ERROR_REST_STATUS;
			message = "E003";
		}
		return new RestResponse(status, message, new HashMap<String, Object>());
	};
	@RequestMapping(value = "/all/paging/{pageSequence}/{size}",method = RequestMethod.POST)
	public RestResponse loadList(
			@RequestParam(value = CommonConstants.SEARCH, required =false) String search,
			@RequestParam(value = CommonConstants.DIRECTION, required=false) String direction,
			@RequestParam(value= CommonConstants.ORDER_BY, required=false)String orderBy,
			@PathVariable("pageSequence") int pageSequence,
			@PathVariable("size") int size,
			@RequestBody Map<String, Object> mapInput){
		
		Map<String, Object> map = gensHargaKirimanSvc.loadList(mapInput, search, pageSequence, size, direction, orderBy);
		return new RestResponse(CommonConstants.OK_REST_STATUS, null,
				map.get("contentData"), (long) map.get("totalRecords"));
	};

}
