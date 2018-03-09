package core.service.master.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import share.GensAdminDto;
import share.GensHargaKirimanDto;
import core.dao.master.GensAdminDao;
import core.dao.master.GensHargaKirimanDao;
import core.model.GensAdmin;
import core.model.GensHargaKiriman;
import core.service.master.GensAdminSvc;

@Service
@Transactional

public class GensAdminSvcImpl implements GensAdminSvc{

	@Autowired
//	GensHargaKirimanDao gensHargaKirimanDao;
	GensAdminDao gensAdminDao;
	@Autowired
	MapperFacade mapperFacade;

	@Override
	public Map<String, Object> login(String username, String password) {
		// TODO Auto-generated method stub
		List<GensAdminDto> gensAdminDtos = new ArrayList<GensAdminDto>();
		List<GensAdmin> gensAdmins = new ArrayList<GensAdmin>();
		gensAdmins = gensAdminDao.findAll();
		for(GensAdmin gensAdmin:gensAdmins){
			gensAdminDtos.add(mapperFacade.map(gensAdmin, GensAdminDto.class));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", gensAdminDtos.size());
		map.put("contentData", gensAdminDtos);
		return map;
		
//		@Override
//		public Map<String, Object> findAll() {
//			List<GensHargaKirimanDto> gensHargaKirimanDtos=new ArrayList<GensHargaKirimanDto>();
//			List<GensHargaKiriman> gensHargaKirimans=new ArrayList<GensHargaKiriman>();
//			gensHargaKirimans=gensHargaKirimanDao.findAll();
//			for(GensHargaKiriman gensHargaKiriman:gensHargaKirimans)
//			{
//				gensHargaKirimanDtos.add(mapperFacade.map(gensHargaKiriman, GensHargaKirimanDto.class));
//				
//			}
//			// TODO Auto-generated method stub
//			
//			Map<String, Object> map = new HashMap<>();
//			map.put("totalRecords", gensHargaKirimanDtos.size());
//			map.put("contentData", gensHargaKirimanDtos);
//			return map;
////			return gensHargaKirimanDtos;
//		}
	}
}
