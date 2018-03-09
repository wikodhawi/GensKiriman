package core.service.master;

import java.util.List;
import java.util.Map;

import share.GensHargaKirimanDto;

public interface GensHargaKirimanSvc {
	public abstract Map<String, Object> findAll();
	
	public abstract Map<String, Object> loadList(Map<String, Object> mapInput, String search, int pageSequence, int size, String direction, String orderBy);
}