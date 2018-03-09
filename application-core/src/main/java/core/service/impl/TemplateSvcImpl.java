package core.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.model.UserSession;
import common.util.StringUtil;
import share.MstMenuDto;
import share.MstUserHdrDto;
import core.dao.BaseDaoImpl;
import core.dao.master.MstMenuDao;
import core.dao.master.MstRoleDtlDao;
import core.dao.master.MstUserDtlDao;
import core.dao.master.MstUserHdrDao;
import core.model.MstCompany;
import core.model.MstEmployee;
import core.model.MstMenu;
import core.model.MstUserHdr;
import core.service.TemplateSvc;

@Service
@Transactional
public class TemplateSvcImpl extends BaseDaoImpl implements TemplateSvc{

	@Autowired
	MstUserHdrDao mstUserHdrDao;
	
	@Autowired
	MstMenuDao mstMenuDao;
	
	@Autowired
	MstUserDtlDao mstUserDtlDao;
	
	@Autowired
	MstRoleDtlDao mstRoleDtlDao;
	
	@Autowired
	MapperFacade mapperFacade;
	
	@Override
	public Map<String, Object> getDataLogin(Map<String, Object> mapInput) {
		
		String employeeCode = (String) mapInput.get("employeeCode");
		String password = (String) mapInput.get("password");
		
		List<Object[]> data = mstUserHdrDao.getLogin(employeeCode, password);
		
		MstUserHdr mstUserHdr = null;
		MstCompany mstCompany = null;
		MstEmployee mstEmployee = null;
		for(Object[] o : data){
			mstUserHdr = (MstUserHdr) o[0];
			mstCompany = (MstCompany) o[1];
			mstEmployee = (MstEmployee) o[2];
		}
		
		List<String> roleCodes = mstUserDtlDao.getRoleCode(employeeCode);
		
		UserSession userSession = new UserSession();
		userSession.setUserId(mstUserHdr.getEmployeeCode());
		userSession.setCompanyName(mstCompany.getCompanyName());
		userSession.setCompanyCode(mstCompany.getCompanyCode());
		userSession.setCompanyImage(mstCompany.getImage());
		userSession.getRoleCode().addAll(roleCodes);
		String middleName = StringUtil.nevl(mstEmployee.getMiddleName(), "").equalsIgnoreCase("")?"":" "+mstEmployee.getMiddleName();
		String lastName = StringUtil.nevl(mstEmployee.getLastName(), "").equalsIgnoreCase("")?"":" "+mstEmployee.getLastName();
		userSession.setUserName(mstEmployee.getFirstName() + middleName + lastName);
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", new Long(1));
		if (userSession!=null && userSession.getCompanyCode()!=null) {
			map.put("contentData", userSession);
			return map;
		}
		
		map.put("contentData", null);
		return map;
	}

	@Override
	public Map<String, Object> getDataMenu(Map<String, Object> mapInput) {
		
		String employeeCode = (String) mapInput.get("employeeCode");
		String companyCode = (String) mapInput.get("companyCode");
		
		String sql = ("select a.menu_code, a.menu_name, a.menu_type, a.menu_url, a.menu_parent, a.menu_seq "
				+ "from mst_menu a "
				+ "where a.flag_active = 1 "
				+ "start with a.menu_parent is null connect by NOCYCLE prior a.menu_code = a.menu_parent "
				+ "and (menu_type = 'G' or a.menu_code in (select d.menu_code from "
				+ "mst_user_dtl b, "
				+ "mst_role_hdr c, "
				+ "mst_role_dtl d "
				+ "where "
				+ "b.company_code = '"+companyCode+"' "
				+ "and c.company_code = d.company_code "
				+ "and b.employee_Code = '" + employeeCode + "' "
				+ "and b.role_Code = c.role_code "
				+ "and c.flag_Active = 1 "
				+ "and c.role_code = d.role_code)) ");
		List<Object[]> data = getListData(sql);
		
		List<MstMenuDto> listData = new ArrayList<MstMenuDto>();
		
		for(Object[] o : data){
			MstMenuDto dto = new MstMenuDto();
			dto.setMenuCode((String) o[0]);
			dto.setMenuName((String) o[1]);
			dto.setMenuType((String) o[2]);
			dto.setMenuUrl((String) o[3]);
			dto.setMenuParent((String) o[4]);
			dto.setMenuSeq((BigDecimal) o[5]);
			listData.add(dto);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", new Long(1));
		if (listData.size()>0) {
			map.put("contentData", listData);
			return map;
		}
		map.put("contentData", null);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getButtonMenu(Map<String, Object> mapInput) {
		String menuCode = (String) mapInput.get("menuCode");
		List<String> tempRoleCode = (List<String>) mapInput.get("roleCode");
		
		Set<String> roleCode = new HashSet<String>();
		for(String a : tempRoleCode){
			roleCode.add(a);
		}
		
		List<String> datas = mstRoleDtlDao.getDtlByRoleCodeAndMenuCode(roleCode, menuCode);
		
		return datas;
	}

	
}
