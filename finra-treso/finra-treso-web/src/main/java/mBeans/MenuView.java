package mBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import entities.PermissionApp;
import entities.RoleApp;
import services.BasicOpsServiceLocal;

@ManagedBean
public class MenuView {

	private MenuModel model;
	@EJB
	private BasicOpsServiceLocal basicOpsServiceLocal;
	@ManagedProperty(value = "#{identity}")
	private Identity identity;

	@PostConstruct
	public void init() {
		List<RoleApp> roleApps = basicOpsServiceLocal.findRolesByUser(identity.getUser());
		model = new DefaultMenuModel();

		for (RoleApp r : roleApps) {
			DefaultSubMenu firstSubmenu = new DefaultSubMenu(r.getName());
			List<PermissionApp> permissionApps = basicOpsServiceLocal.findAllPermissionByUserAndRole(identity.getUser(),
					r);

			for (PermissionApp p : permissionApps) {
				DefaultMenuItem item = new DefaultMenuItem(p.getName());
				item.setUrl("../a.jsf");
				item.setIcon("ui-icon-home");
				firstSubmenu.addElement(item);
			

			}
			model.addElement(firstSubmenu);
		}

		// Second submenu
		// DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");
		//
		// item = new DefaultMenuItem("Save");
		// item.setIcon("ui-icon-disk");
		// item.setCommand("#{menuView.save}");
		// item.setUpdate("messages");
		// secondSubmenu.addElement(item);
		//
		// item = new DefaultMenuItem("Delete");
		// item.setIcon("ui-icon-close");
		// item.setCommand("#{menuView.delete}");
		// item.setAjax(false);
		// secondSubmenu.addElement(item);
		//
		// item = new DefaultMenuItem("Redirect");
		// item.setIcon("ui-icon-search");
		// item.setCommand("#{menuView.redirect}");
		// secondSubmenu.addElement(item);
		//
		// model.addElement(secondSubmenu);
	}

	public MenuModel getModel() {
		return model;
	}

	public void save() {
		addMessage("Success", "Data saved");
	}

	public void update() {
		addMessage("Success", "Data updated");
	}

	public void delete() {
		addMessage("Success", "Data deleted");
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
}