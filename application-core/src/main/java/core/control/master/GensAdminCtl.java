package core.control.master;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import common.model.RestResponse;
import common.util.CommonConstants;
import core.service.master.GensAdminSvc;
import core.service.master.GensHargaKirimanSvc;



@RestController
@RequestMapping("/GensAdmin")
public class GensAdminCtl {

	@Autowired
	GensAdminSvc gensAdminSvc;

	@RequestMapping(value = "/all/paging/{username}/{password}", method = RequestMethod.GET)
	public RestResponse login(
//			@RequestParam(value=CommonConstants.SEARCH, required=false) String search,
//			@RequestParam(value=CommonConstants.DIRECTION, required=false) String direction,
//			@RequestParam(value=CommonConstants.ORDER_BY, required=false) String orderBy,
			@PathVariable("username") String username,
			@PathVariable("password") String password
			) {

		Map<String, Object> map = gensAdminSvc.login(username,password);
		return new RestResponse(CommonConstants.OK_REST_STATUS, null,
				map.get("contentData"), (int) map.get("totalRecords"));

	};
}
