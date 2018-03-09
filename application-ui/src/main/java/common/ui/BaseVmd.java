package common.ui;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Default;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.Include;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.ClickEvent;
import org.zkoss.zul.Window;

import common.model.RestResponse;
import common.model.UserSession;
import common.util.CommonConstants;
import common.util.StringUtil;

/**
 * Base view model class. All view model that used in application must extend
 * this base class.
 * 
 * @author Leo Sendra
 * 
 */
public abstract class BaseVmd {
	
	private static Logger logger = LoggerFactory.getLogger(BaseVmd.class);
	
	private int pageSize = Integer.parseInt(Labels.getLabel("pageSize"));;
	private long totalSize = 0;
	private int activePage = 0;
	
	private String search = "";
	protected String orderBy = ""; // order by entity model column
	protected String currentOrderDirection = CommonConstants.ASC; // desc / asc
																	// order
	
	private final String WS_URL = Labels.getLabel("wsUrl");
	
	private boolean showAdvSearch = false;
	
	@Init
	public void baseInit() {

		logger.debug("baseInit in BaseVmd is called!");
		if (getPageInfo().isListMode()) {
			onList();
		} else if (getPageInfo().isEditMode()) {
			onEdit();
		} else if (getPageInfo().isAddMode()) {
			onAdd();
		} else if (getPageInfo().isViewMode()) {
			onView();
		} else if (getPageInfo().isTaskMode()) {
			onTask();
		} else if (getPageInfo().isBarcodeMode()) {
			onBarcode();
		} else if (getPageInfo().isEditDetailMode()) {
			onEditDetail();
		} else if (getPageInfo().isAddDetailMode()) {
			onAddDetail();
		} else if (getPageInfo().isViewDetailMode()) {
			onViewDetail();
		} else if (getPageInfo().isDeleteDetailMode()) {
			onDeleteDetail();
		}
	}

	/**
	 * Invoked first time when page in list mode. Child class can be override
	 * this method for further custom.
	 */
	protected void onList() {
		loadList();
	}

	/**
	 * Template method to be implemented / override in child class. Invoked
	 * first time when page in add mode
	 */
	protected void onAdd() {
	}

	/**
	 * Template method to be implemented / override in child class. Invoked
	 * first time when page in edit mode
	 */
	protected void onEdit() {
	}

	/**
	 * Template method to be implemented / override in child class. Invoked
	 * first time when page in view mode
	 */
	protected void onView() {
	}

	/**
	 * Template method to be implemented / override in child class. Invoked
	 * first time when page opened via task / inbox from BPM.
	 */
	protected void onTask() {
	}

	/**
	 * Template method to be implemented / override in child class. Invoked
	 * first time when page in barcode mode
	 */
	protected void onBarcode() {
	}

	/**
	 * Template method to be implemented / override in child class. Invoked
	 * first time when page in add detail mode
	 */
	protected void onAddDetail() {
	}

	/**
	 * Template method to be implemented / override in child class. Invoked
	 * first time when page in edit detail mode
	 */
	protected void onEditDetail() {
	}

	/**
	 * Template method to be implemented / override in child class. Invoked
	 * first time when page in delete detail mode
	 */
	protected void onDeleteDetail() {
	}

	/**
	 * Template method to be implemented / override in child class. Invoked
	 * first time when page in view detail mode
	 */
	protected void onViewDetail() {
	}

	/**
	 * Template method to be implemented / override in child class. Invoked
	 * first time when page in sub detail mode
	 */
	protected void onSubDetail() {
	}
	
	protected void loadList() {
	}

	/**
	 * Method that will be executed when do sorting / paging. It will do query
	 * with some criteria start from 1st page.
	 */
	@Command("sortAndSearch")
	@NotifyChange("totalSize")
	public void sortAndSearch() {
		setActivePage(0);
	}
	
	@Command("sort")
	public void sort(@BindingParam("col") String toBeSortedColumn) {
		if (orderBy.equals(toBeSortedColumn)) {
			if (currentOrderDirection.equals(CommonConstants.ASC)) {
				currentOrderDirection = CommonConstants.DESC;
			} else {
				currentOrderDirection = CommonConstants.ASC;
			}
		} else {
			currentOrderDirection = CommonConstants.ASC;
		}

		orderBy = toBeSortedColumn;
		sortAndSearch();
	}

	/**
	 * 
	 * @param popup
	 *            URI LOV popup (ZUL page)
	 * @param globalHandleMethodName
	 *            global method name to be invoked when user choose data in LOV
	 *            popup
	 */
	@Command("showLov")
	public void showLov(
			@BindingParam("popup") String popup,
			@Default(UIConstants.LOV_HANDLER) @BindingParam(UIConstants.LOV_HANDLER) String globalHandleMethodName) {
		Map<String, Object> args = new HashMap<>();

		// put global command method name that will be invoked after user choose
		// data in LOV popup
		args.put(UIConstants.LOV_HANDLER, globalHandleMethodName);

		if (!beforeCallLov(args, popup))
			return;
		try {
			((Window) Executions.createComponents(popup, null, args)).doModal();
		} catch (UiException u) {
			u.printStackTrace();
		}
	}

	/**
	 * Template method to be implemented / override in child class. Invoked
	 * before LOV popup be showed
	 * 
	 * @param args
	 *            HashMap argument to be sent to popup LOV
	 * @param popup
	 *            LOV popup name. Using this variable if we need a filter /
	 *            selection when fill @param args.
	 * 
	 * @return true if proceed to show LOV popup. false to terminate process.
	 */
	protected boolean beforeCallLov(Map<String, Object> args, String popup) {
		return true;
	}

		
	protected RestResponse callCustomWs(String url, Object sentObject,
			HttpMethod httpMethod) {
		return executeWebService(WS_URL + url, sentObject, httpMethod);
	}
	
	protected RestResponse callWs(String url, Object sentObject,
			HttpMethod httpMethod) {
		return executeWebService(WS_URL + url, sentObject, httpMethod);
	}
	
	protected RestResponse callWsWithPaging(String url, Object sentObject,
			HttpMethod httpMethod) {
		return executeWebService(WS_URL + url 
				+ "/" + getActivePage()
				+ "/" + getPageSize() 
				+ "?" + CommonConstants.SEARCH + "=" + StringUtil.nevl(getSearch(), "")
				+ "&" + CommonConstants.DIRECTION + "=" + StringUtil.nevl(currentOrderDirection, "")
				+ "&" + CommonConstants.ORDER_BY + "=" + StringUtil.nevl(orderBy, ""), sentObject, httpMethod);
	}
	
	private RestResponse executeWebService(String url, Object sentObject,
			HttpMethod httpMethod) {
		url = url.replace("\\", "");

		RestTemplate restTemplate = new RestTemplate();
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<Object> requestEntity = new HttpEntity<Object>(
				sentObject, headers);
		RestResponse restResponse = null;
		
		
		ResponseEntity<RestResponse> reponseEntity = null;
		try {
			reponseEntity = restTemplate.exchange(url, httpMethod,
					requestEntity, RestResponse.class);
			restResponse = reponseEntity.getBody();
			if (restResponse != null
					&& restResponse.getStatus() == CommonConstants.ERROR_BY_PAGE_ERROR) {
				throw new RuntimeException(restResponse.getMessage());
			}
		} catch (Exception e) {
			if (reponseEntity != null) {
				try {
					HttpStatus httpStatus = reponseEntity.getStatusCode();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			restResponse = new RestResponse(CommonConstants.ERROR_REST_STATUS,
					"E150", null);
			e.printStackTrace();

		}

		return restResponse;
	}
	
	@Command("navigate")
	public void navigate(@BindingParam("uri") String locationUri) {
		Include include = (Include) getCurrentExecution().getDesktop()
				.getPage(UIConstants.PAGE_INDEX_ID)
				.getFellow(UIConstants.PAGE_INCLUDE_ID);
		include.setSrc(locationUri);
	}
	
	protected void showSmartMsgBox(String keyMessage, String... param) {
		String code = keyMessage.substring(0, 1);
		switch (code) {
		case "E":
			showErrorMsgBox(keyMessage, param);
			break;
		case "I":
			showInfoMsgBox(keyMessage, param);
			break;
		case "W":
			showWarningMsgBox(keyMessage, param);
			break;
		default:
			showErrorMsgBox(keyMessage, param);
			break;
		}
	}
	
	/**
	 * Show error message box with i18n feature
	 * 
	 * @param keyMessage
	 *            key code message
	 */
	protected void showErrorMsgBox(String keyMessage, String... param) {
		String message = Labels.getLabel(keyMessage, param);
		showMessageBox(message == null || message.isEmpty() ? keyMessage
				: message, Labels.getLabel("error"), Messagebox.ERROR);
	}

	/**
	 * Show info message box with i18n feature
	 * 
	 * @param keyMessage
	 *            key code message
	 */
	protected void showInfoMsgBox(String keyMessage, String... param) {
		String message = Labels.getLabel(keyMessage, param);
		showMessageBox(message == null || message.isEmpty() ? keyMessage
				: message, Labels.getLabel("info"), Messagebox.INFORMATION);
	}

	/**
	 * Show warning message box with i18n feature
	 * 
	 * @param keyMessage
	 *            key code message
	 */
	protected void showWarningMsgBox(String keyMessage, String... param) {
		String message = Labels.getLabel(keyMessage, param);
		showMessageBox(message == null || message.isEmpty() ? keyMessage
				: message, Labels.getLabel("warning"), Messagebox.EXCLAMATION);
	}
	
	private void showMessageBox(String message, String title, String type) {
		Messagebox.show(message, title, new Messagebox.Button[] { Messagebox.Button.OK },
				new String[] { Labels.getLabel("ok") }, type, Messagebox.Button.OK, null);
	}
	
	@Command("showDirty")
	public void showDirtyMsgBox() {
		Messagebox.show(Labels.getLabel("W002"), Labels.getLabel("warning"),
				new Messagebox.Button[] { Messagebox.Button.YES, Messagebox.Button.OK }, Messagebox.EXCLAMATION,
				Messagebox.Button.NO, new EventListener<ClickEvent>() {
					public void onEvent(ClickEvent evt) throws Exception {
						if (Messagebox.ON_YES.equals(evt.getName())) {
							back();
						}
					}
				});
	}
	
	public void back() {
	}
	
	protected Session getCurrentSession() {
		return Sessions.getCurrent();
	}
	
	protected Execution getCurrentExecution() {
		return Executions.getCurrent();
	}
	
	protected UserSession getCurrentUserSession() {
		return (UserSession) getCurrentSession().getAttribute(
				"user");
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	public int getActivePage() {
		return activePage;
	}

	public void setActivePage(int activePage) {
		this.activePage = activePage;
		loadList();
		BindUtils.postNotifyChange(null, null, this, "activePage");
	}

	public PageInfo getPageInfo() {
		return (PageInfo) Executions.getCurrent().getDesktop()
				.getAttribute(UIConstants.PAGE_INFO_ID);
	}
	
	@Command("toggleAdvSearch")
	public void toggleAdvSearch() {
		setShowAdvSearch(!isShowAdvSearch());
		BindUtils.postNotifyChange(null, null, this, "showAdvSearch");
	}
	
	public Map<String, Boolean> getUserButton() {
		return getPageInfo().getUserButton();
	}

	public Map<String, Boolean> getMenuButton() {
		return getPageInfo().getMenuButton();
	}

	public boolean isShowAdvSearch() {
		return showAdvSearch;
	}

	public void setShowAdvSearch(boolean showAdvSearch) {
		this.showAdvSearch = showAdvSearch;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
}