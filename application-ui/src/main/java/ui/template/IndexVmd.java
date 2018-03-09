package ui.template;

import java.io.Serializable;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;

import common.ui.BaseVmd;

public class IndexVmd extends BaseVmd implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}

}
