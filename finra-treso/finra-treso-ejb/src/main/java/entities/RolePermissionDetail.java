package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: RolePermissionDetail
 *
 */
@Entity

public class RolePermissionDetail implements Serializable {
	@EmbeddedId
	private RolePermissionDetailId rolePermissionDetailId;
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "idRole", referencedColumnName = "id", insertable = false, updatable = false)
	private RoleApp roleApp;

	@ManyToOne
	@JoinColumn(name = "idPermission", referencedColumnName = "id", insertable = false, updatable = false)
	private PermissionApp permissionApp;
	private static final long serialVersionUID = 1L;

	public RolePermissionDetail() {
		super();
	}

	public RolePermissionDetail(boolean status, RoleApp roleApp, PermissionApp permissionApp) {
		super();
		this.status = status;
		this.roleApp = roleApp;
		this.permissionApp = permissionApp;
		this.rolePermissionDetailId = new RolePermissionDetailId(roleApp.getId(), permissionApp.getId());
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
