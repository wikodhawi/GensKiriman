package core.service.master;

import java.util.Map;

import share.GensHargaKirimanDto5;

public interface GensHargaKirimanSvc5 {
	public abstract void save(GensHargaKirimanDto5 gensHargaKirimanDto);
	public abstract Map<String, Object> loadList(Map<String, Object> mapInput, String search, int pageSequence, int size, String direction, String orderBy);

}


