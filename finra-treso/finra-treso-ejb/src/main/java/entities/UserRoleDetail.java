package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: UserRoleDetail
 *
 */
@Entity
@Table(name = "t_userRoleDetail")
public class UserRoleDetail implements Serializable {
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 5538905551958919951L;
	/**
	 * 
	 */
	@EmbeddedId
	private UserRoleDetailId userRoleDetailId;
	private boolean status;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idRole", referencedColumnName = "id", insertable = false, updatable = false)
	private RoleApp roleApp;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idPermission", referencedColumnName = "id", insertable = false, updatable = false)
	private PermissionApp permissionApp;

	public UserRoleDetail() {
	}

	public UserRoleDetail(boolean status, User user, RoleApp roleApp) {
		super();
		this.status = status;
		this.user = user;
		this.roleApp = roleApp;
		this.userRoleDetailId = new UserRoleDetailId(user.getId(), roleApp.getId());
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public UserRoleDetailId getUserRoleDetailId() {
		return userRoleDetailId;
	}

	public void setUserRoleDetailId(UserRoleDetailId userRoleDetailId) {
		this.userRoleDetailId = userRoleDetailId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
