package common.ui;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

/**
 * Base class for LOV popup window. LOV popup window must use id = "lov",
 * otherwise it will throw an error.
 * 
 * @author Leo Sendra
 * 
 */
public abstract class BaseLovVmd extends BaseVmd {
	private static Logger logger = LoggerFactory.getLogger(BaseLovVmd.class);

	@Wire("#lov")
	private Window winLov;

	private String lovHandler;

	/**
	 * Initial method to be run when page on load. To execute this method,
	 * implementer class must use annotation @Init(superclass = true)
	 * 
	 * @param lovHandler
	 *            LOV handler global method to be executed when LOV return a
	 *            value
	 * @param view
	 *            Binding window id "lov" with view
	 */
	@Init
	public void baseInit(
			@ExecutionArgParam(UIConstants.LOV_HANDLER) String lovHandler,
			@ContextParam(ContextType.VIEW) Component view) {

		logger.debug("baseInit in BaseLovVmd is called!");

		Selectors.wireComponents(view, this, false);
		this.lovHandler = lovHandler;
	}

	/**
	 * Close LOV popup. When LOV popup don't use ID "lov", it will throw an
	 * error.
	 * Can also be used for cancel button in LOV popup.
	 */
	@Command("closeLov")
	public void closeLov() {
		if (winLov == null)
			throw new RuntimeException(
					"Window with id \"lov\" is not found. Please check your .zul page script!");
		winLov.detach();
	}

	protected String getLovHandler() {
		return this.lovHandler;
	}

	/**
	 * To be invoked when user choose values from LOV and return these values to
	 * parent and close LOV popup
	 * 
	 * @param args values to be return to parent window
	 */
	protected void returnValue(Map<String, Object> args) {
		//invoke global method in parent view model and also send return value
		BindUtils.postGlobalCommand(null, null, getLovHandler(), args);
		closeLov();
	}
}
