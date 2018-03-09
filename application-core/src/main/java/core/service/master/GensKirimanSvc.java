package core.service.master;

import java.util.List;
import java.util.Map;

import share.GensKirimanDto;

public interface GensKirimanSvc {
	public abstract void save(GensKirimanDto gensKirimanDto);

	public abstract Map<String, Object> loadList(Map<String, Object> mapInput, String search, int pageSequence, int size, String direction, String orderBy);
	
	public abstract Map<String, Object> searchResi(String search);
	
}
