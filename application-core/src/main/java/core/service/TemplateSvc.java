package core.service;

import java.util.List;
import java.util.Map;

public interface TemplateSvc {

	public abstract Map<String, Object> getDataLogin(Map<String, Object> mapInput);
	
	public Map<String, Object> getDataMenu(Map<String, Object> mapInput);
	
	public List<String> getButtonMenu(Map<String, Object> mapInput);
}
