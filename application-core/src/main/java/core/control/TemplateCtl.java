package core.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import share.MstUserHdrDto;
import common.model.RestResponse;
import core.service.TemplateSvc;

@RestController
@RequestMapping("/template")
public class TemplateCtl {

	@Autowired
	TemplateSvc getLoginSvc;
	
	@RequestMapping(method = RequestMethod.GET)
	public RestResponse all(){		
		Map<String, Object> in = new HashMap<String, Object>();
		in.put("employeeCode", "101");
		in.put("companyCode", "IGLO");
		
		Map<String, Object> out = getLoginSvc.getDataMenu(in);
		
		return new RestResponse(1, "fdsf", out.get("contentData"), (long)out.get("totalRecords"));
	}
	
	@RequestMapping(value="/getLogin",method = RequestMethod.POST)
	public RestResponse getLogin(@RequestBody MstUserHdrDto dto){
		
		Map<String, Object> in = new HashMap<String, Object>();
		in.put("employeeCode", dto.getEmployeeCode());
		in.put("password", dto.getPassword());
		
		Map<String, Object> out = getLoginSvc.getDataLogin(in);
		
		return new RestResponse(1, "fdsf", out.get("contentData"), (long)out.get("totalRecords"));
	}
	
	@RequestMapping(value="/getMenu",method = RequestMethod.POST)
	public RestResponse getMenu(@RequestBody HashMap<String, Object> mapInput){
		
		Map<String, Object> out = getLoginSvc.getDataMenu(mapInput);
		
		return new RestResponse(1, "fdsf", out.get("contentData"), (long)out.get("totalRecords"));
	}
	
	@RequestMapping(value="/getUserButton",method = RequestMethod.POST)
	public RestResponse getUserButton(@RequestBody HashMap<String, Object> mapInput){
		
		List<String> out = getLoginSvc.getButtonMenu(mapInput);
		
		return new RestResponse(1, "fdsf", out, new Long(1));
	}
}
