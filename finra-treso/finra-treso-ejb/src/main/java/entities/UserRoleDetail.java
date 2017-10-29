package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: UserRoleDetail
 *
 */
@Entity

public class UserRoleDetail implements Serializable {
	@EmbeddedId
	private UserRoleDetailId userRoleDetailId;
	private boolean status;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "idRole", referencedColumnName = "id", insertable = false, updatable = false)
	private RoleApp roleApp;

	public UserRoleDetail() {
		super();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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

}
