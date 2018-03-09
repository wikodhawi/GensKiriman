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
import core.model.MstGlobalParam;
import core.service.master.MasterGlobalParamSvc;



@RestController
@RequestMapping("/MasterGlobalParam")
public class MasterGlobalParamCtl {
	@Autowired
	MasterGlobalParamSvc masterGlobalParamSvc;

	@RequestMapping(value = "/all/data/{condition}", method = RequestMethod.GET)
	public RestResponse loadList(
			@PathVariable("condition") String search) {

		Map<String, Object> map = masterGlobalParamSvc.loadList(search);
		return new RestResponse(CommonConstants.OK_REST_STATUS, null,
				map.get("contentData"));

	};
}
