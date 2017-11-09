package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: RolePermissionApp
 *
 */
@Entity
@Table(name = "t_rolePermissionApp")
public class RolePermissionApp implements Serializable {
	@EmbeddedId
	private RolePermissionAppId rolePermissionAppId;
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "idRole", referencedColumnName = "id", insertable = false, updatable = false)
	private RoleApp roleApp;

	@ManyToOne
	@JoinColumn(name = "idPermission", referencedColumnName = "id", insertable = false, updatable = false)
	private PermissionApp permissionApp;
	private static final long serialVersionUID = 1L;

	public RolePermissionApp() {
		super();
	}

	public RolePermissionApp(boolean status, RoleApp roleApp, PermissionApp permissionApp) {
		super();
		this.status = status;
		this.roleApp = roleApp;
		this.permissionApp = permissionApp;
		this.rolePermissionAppId = new RolePermissionAppId(roleApp.getId(), permissionApp.getId());
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public RolePermissionAppId getRolePermissionAppId() {
		return rolePermissionAppId;
	}

	public void setRolePermissionAppId(RolePermissionAppId rolePermissionAppId) {
		this.rolePermissionAppId = rolePermissionAppId;
	}

	public RoleApp getRoleApp() {
		return roleApp;
	}

	public void setRoleApp(RoleApp roleApp) {
		this.roleApp = roleApp;
	}

	public PermissionApp getPermissionApp() {
		return permissionApp;
	}

	public void setPermissionApp(PermissionApp permissionApp) {
		this.permissionApp = permissionApp;
	}

}
