package common.ui;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.util.resource.Labels;

/**
 * Contain current page information
 * 
 * @author Leo Sendra
 * 
 */
public class PageInfo implements Serializable {
	private static final long serialVersionUID = 7788591977608319088L;

	private String menuCode = "";
	private String title = "";
	private String operation = "";
	private String separator = " : ";
	private String customAttribute; //helper attribute for keeping a custom content that could be used for further process manipulation

	private boolean isAddMode = false;
	private boolean isEditMode = false;
	private boolean isViewMode = false;
	private boolean isDeleteMode = false;
	private boolean isListMode = false;
	private boolean isTaskMode = false;
	private boolean isBarcodeMode = false;
	
	private boolean isAddDetailMode = false;
	private boolean isEditDetailMode = false;
	private boolean isDeleteDetailMode = false;
	private boolean isViewDetailMode = false;
	
	private Map<String, Boolean> userButton = new HashMap<>();
	private Map<String, Boolean> menuButton = new HashMap<>();
			
	public PageInfo() {
	}

	public PageInfo(String title) {
		this.title = title;
	}
	
	private void resetMode() {
		isAddMode = false;
		isEditMode = false;
		isViewMode = false;
		isDeleteMode = false;
		isListMode = false;
		isTaskMode = false;
		isBarcodeMode = false;
		isAddDetailMode = false;
		isEditDetailMode = false;
		isDeleteDetailMode = false;
		isViewDetailMode = false;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String pageTitle) {
		this.title = pageTitle;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public boolean isAddMode() {
		return isAddMode;
	}

	public void setAddMode(boolean isAddMode) {
		resetMode();
		this.isAddMode = isAddMode;
		operation = Labels.getLabel(UIConstants.ADD_LABEL_KEY);
	}

	public boolean isEditMode() {
		return isEditMode;
	}

	public void setEditMode(boolean isEditMode) {
		resetMode();
		this.isEditMode = isEditMode;
		operation = Labels.getLabel(UIConstants.EDIT_LABEL_KEY);
	}

	public boolean isViewMode() {
		return isViewMode;
	}

	public void setViewMode(boolean isViewMode) {
		resetMode();
		this.isViewMode = isViewMode;
		operation = Labels.getLabel(UIConstants.VIEW_LABEL_KEY);
	}

	public boolean isDeleteMode() {
		return isDeleteMode;
	}

	public void setDeleteMode(boolean isDeleteMode) {
		resetMode();
		this.isDeleteMode = isDeleteMode;
		operation = Labels.getLabel(UIConstants.DELETE_LABEL_KEY);
	}

	public boolean isListMode() {
		return isListMode;
	}

	public void setListMode(boolean isListMode) {
		resetMode();
		this.isListMode = isListMode;
		operation = "";
	}

	public String getCustomAttribute() {
		return customAttribute;
	}

	public void setCustomAttribute(String customAttribute) {
		this.customAttribute = customAttribute;
	}

	public Map<String, Boolean> getMenuButton() {
		return menuButton;
	}

	public void setMenuButton(Map<String, Boolean> menuButton) {
		this.menuButton = menuButton;
	}

	public Map<String, Boolean> getUserButton() {
		return userButton;
	}

	public void setUserButton(Map<String, Boolean> userButton) {
		this.userButton = userButton;
	}
	
	@Override
	public String toString() {
		if (!operation.isEmpty()) {
			return title + separator + operation;
		}

		return title;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public boolean isTaskMode() {
		return isTaskMode;
	}

	public void setTaskMode(boolean isTaskMode) {
		resetMode();
		this.isTaskMode = isTaskMode;
		operation = "";
	}

	public boolean isBarcodeMode() {
		return isBarcodeMode;
	}

	public void setBarcodeMode(boolean isBarcodeMode) {
		resetMode();
		this.isBarcodeMode = isBarcodeMode;
		operation = Labels.getLabel(UIConstants.BARCODE_LABEL_KEY);
	}

	public boolean isAddDetailMode() {
		return isAddDetailMode;
	}

	public void setAddDetailMode(boolean isAddDetailMode) {
		resetMode();
		this.isAddDetailMode = isAddDetailMode;
		operation = Labels.getLabel(UIConstants.ADD_DETAIL_LABEL_KEY);
	}

	public boolean isEditDetailMode() {
		return isEditDetailMode;
	}

	public void setEditDetailMode(boolean isEditDetailMode) {
		resetMode();
		operation = Labels.getLabel(UIConstants.EDIT_DETAIL_LABEL_KEY);
		this.isEditDetailMode = isEditDetailMode;
	}

	public boolean isDeleteDetailMode() {
		return isDeleteDetailMode;
	}

	public void setDeleteDetailMode(boolean isDeleteDetailMode) {
		resetMode();
		operation = Labels.getLabel(UIConstants.DELETE_DETAIL_LABEL_KEY);
		this.isDeleteDetailMode = isDeleteDetailMode;
	}

	public boolean isViewDetailMode() {
		return isViewDetailMode;
	}

	public void setViewDetailMode(boolean isViewDetailMode) {
		resetMode();
		operation = Labels.getLabel(UIConstants.VIEW_DETAIL_LABEL_KEY);
		this.isViewDetailMode = isViewDetailMode;
	}		
}