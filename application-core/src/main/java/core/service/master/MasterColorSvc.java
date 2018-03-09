package core.service.master;

import java.util.Map;

import share.MstColorDto;

public interface MasterColorSvc {

	public abstract void save(MstColorDto mstColorDto);
	
	public abstract Map<String, Object> loadList(Map<String, Object> mapInput, String search, int pageSequence, int size, String direction, String orderBy);
}
