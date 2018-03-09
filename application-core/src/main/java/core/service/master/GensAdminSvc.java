package core.service.master;

import java.util.Map;

public interface GensAdminSvc {

	public abstract Map<String, Object> login(String username, String password);
}
