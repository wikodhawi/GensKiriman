package ui.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tree;
import org.zkoss.zul.TreeModel;
import org.zkoss.zul.TreeNode;

import share.MstMenuDto;
import share.dtoTree.MstMenuTreeDto;
import common.model.RestResponse;
import common.ui.BaseVmd;
import common.ui.PageInfo;
import common.ui.UIConstants;
import common.util.JsonUtil;

public class SideBarVmd extends BaseVmd{
	
	private List<MstMenuDto> mstMenuDtos = new ArrayList<MstMenuDto>();
	private List<MstMenuTreeDto> listMenu = new ArrayList<MstMenuTreeDto>();
	private TreeModel<MstMenuTreeDto> menuTrees;
	private ListModelList<DefaultTreeModel<MstMenuTreeDto>> listMenuTreeModel = new ListModelList<>();

	@Init
	public void loadList(){
//		menuTrees = new MstMenuTree(getBranch());
		Executions.getCurrent().getDesktop()
		.setAttribute(UIConstants.PAGE_INFO_ID, new PageInfo());
		getBranch();
		BindUtils.postNotifyChange(null, null, this, "listMenuTreeModel");
		BindUtils.postNotifyChange(null, null, this, "mstMenuDtos");
	}
	
	private List<MstMenuTreeDto> getList(){
		Map<String, Object> mapInput = new HashMap<String, Object>();
		mapInput.put("employeeCode", getCurrentUserSession().getUserId());
		mapInput.put("companyCode", getCurrentUserSession().getCompanyCode());
		
		RestResponse rest = callCustomWs("/template/getMenu", mapInput, HttpMethod.POST);
		List<MstMenuTreeDto> dtos = new ArrayList<MstMenuTreeDto>();
		try {
			dtos = JsonUtil.mapJsonToListObject(rest.getContents(), MstMenuTreeDto.class);
			
			BindUtils.postNotifyChange(null, null, this, "mstMenuDtos");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dtos;
	}
	
	@Command
	public void toogleTree(@BindingParam("tree") Tree node) {
		if (node.getSelectedItem().isOpen()) {
			node.getSelectedItem().setOpen(false);
		} else {
			node.getSelectedItem().setOpen(true);
		}
	}
	
	// fungsi untuk merubah list menjadi tree
	@SuppressWarnings("unchecked")
	private void getBranch() {
		DefaultTreeNode<MstMenuTreeDto> root = new DefaultTreeNode<MstMenuTreeDto>(
				null, (List) null);;
		listMenu = getList();

		String tempRootAccord = "";
		for (MstMenuTreeDto o : listMenu) {

			// menu parent is null mean this node is used for accordion
			if (o.getMenuParent() == null || o.getMenuParent().isEmpty()) {
				mstMenuDtos.add(new MstMenuDto(o.getMenuCode(), o.getApplProgCode(), o.getCreatedBy(), o.getCreatedDate(), o.getFlagActive(), o.getLevelType(),	 
						o.getMenuName(), o.getMenuParent(), o.getMenuSeq(), o.getMenuType(), o.getMenuUrl(), o.getUpdatedBy(), o.getUpdatedDate()));

				tempRootAccord = o.getMenuCode();
				
				// for every new accordion, then declare new empty root
				root = new DefaultTreeNode<MstMenuTreeDto>(new MstMenuTreeDto(),
						new ArrayList<DefaultTreeNode<MstMenuTreeDto>>());

				// add the root of tree into our tree model collection
				listMenuTreeModel.add(new DefaultTreeModel<MstMenuTreeDto>(root));
			} else {
				MstMenuTreeDto nextUm = null;

				// check next user menu if only is exist
				if (listMenu.indexOf(o)+1 < listMenu.size()) {
					nextUm = listMenu.get(listMenu.indexOf(o)+1);
				}

				DefaultTreeNode<MstMenuTreeDto> newNode;

				if (nextUm != null && nextUm.getMenuParent() != null) {
					// if next menu parent is current menu, then declare
					// current menu has child
					if (nextUm.getMenuParent().equals(o.getMenuCode())) {
						newNode = new DefaultTreeNode<MstMenuTreeDto>(
								new MstMenuTreeDto(o), (List) null);
					} else { // otherwise there will be no child for menu
						newNode = new DefaultTreeNode<MstMenuTreeDto>(new MstMenuTreeDto(o));
					}
				} else { // last node in list, there will be no child for
							// menu
					newNode = new DefaultTreeNode<MstMenuTreeDto>(new MstMenuTreeDto(o));
				}
				if (o.getMenuParent().equals(tempRootAccord)) {
					root.add(newNode);
				} else { // otherwise, then search true parent of node and
							// added it as a child
					DefaultTreeNode<MstMenuTreeDto> parent = recurseSearch(root,
							o.getMenuParent());
					parent.add(newNode);
				}
			}
		}
		
		Iterator<MstMenuDto> iterAcc = mstMenuDtos
				.listIterator();
		for (Iterator<DefaultTreeModel<MstMenuTreeDto>> iter = listMenuTreeModel
				.listIterator(); iter.hasNext();) {

			DefaultTreeModel<MstMenuTreeDto> ut = iter.next();
			iterAcc.next();

			if (ut.getChildCount(ut.getRoot()) <= 0) {
				iter.remove();
				iterAcc.remove();
			}
		}
	}
	
	private DefaultTreeNode<MstMenuTreeDto> recurseSearch(DefaultTreeNode<MstMenuTreeDto> node,
			String branchParent) {
		if (node.getData().getMenuCode().equals(branchParent))
			return node;

		DefaultTreeNode<MstMenuTreeDto> res = null;
		for (TreeNode<MstMenuTreeDto> fn : node.getChildren()) {
			res = recurseSearch((DefaultTreeNode<MstMenuTreeDto>) fn, branchParent);
		}
		return res;
	}
	
	@Command
	public void navi(@BindingParam("uri") String locationUri,
			@BindingParam("title") String title,
			@BindingParam("menuCode") String menuCode) {
		
		Map<String, Object> mapInput = new HashMap<String, Object>();
		mapInput.put("menuCode", menuCode);
		mapInput.put("roleCode", getCurrentUserSession().getRoleCode());
		
		RestResponse rest = callCustomWs("/template/getUserButton", mapInput, HttpMethod.POST);
		List<String> dtos = new ArrayList<String>();
		try {
			dtos = JsonUtil.mapJsonToListObject(rest.getContents(), String.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PageInfo pageInfo = getPageInfo();
		pageInfo.getUserButton().clear();
		pageInfo.getMenuButton().clear();
		
		for (String s : dtos) {
			pageInfo.getMenuButton().put(s.toLowerCase(), true);
			pageInfo.getUserButton().put(s.toLowerCase(), true);
		}
		pageInfo.setTitle(title);
		getPageInfo().setListMode(true);
		navigate(UIConstants.BASE_PAGE_PATH + locationUri);
	}

	public List<MstMenuDto> getMstMenuDtos() {
		return mstMenuDtos;
	}

	public void setMstMenuDtos(List<MstMenuDto> mstMenuDtos) {
		this.mstMenuDtos = mstMenuDtos;
	}

	public TreeModel<MstMenuTreeDto> getMenuTrees() {
		return menuTrees;
	}

	public void setMenuTrees(TreeModel<MstMenuTreeDto> menuTrees) {
		this.menuTrees = menuTrees;
	}

	public ListModelList<DefaultTreeModel<MstMenuTreeDto>> getListMenuTreeModel() {
		return listMenuTreeModel;
	}

	public void setListMenuTreeModel(
			ListModelList<DefaultTreeModel<MstMenuTreeDto>> listMenuTreeModel) {
		this.listMenuTreeModel = listMenuTreeModel;
	}
}
