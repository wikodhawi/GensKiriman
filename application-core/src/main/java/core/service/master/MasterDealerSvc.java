package core.service.master;

import java.util.Map;

import share.MstDealerDto;

public interface MasterDealerSvc {
	public abstract void save(MstDealerDto mstDealerDto);
	public abstract Map<String, Object> loadList(Map<String, Object> mapInput, String search, int pageSequence, int size, String direction, String orderBy);
}
