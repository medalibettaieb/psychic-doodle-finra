package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: RoleApp
 *
 */
@Entity
@Table(name = "t_role")
public class RoleApp implements Serializable {
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -3455087871481705264L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@OneToMany(mappedBy = "roleApp")
	private List<UserRoleDetail> userRoleDetails;

	@OneToMany(mappedBy = "roleApp")
	private List<RolePermissionApp> rolePermissionApps;

	public RoleApp() {
		super();
	}

	public RoleApp(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserRoleDetail> getUserRoleDetails() {
		return userRoleDetails;
	}

	public void setUserRoleDetails(List<UserRoleDetail> userRoleDetails) {
		this.userRoleDetails = userRoleDetails;
	}

	public List<RolePermissionApp> getRolePermissionApps() {
		return rolePermissionApps;
	}

	public void setRolePermissionApps(List<RolePermissionApp> rolePermissionApps) {
		this.rolePermissionApps = rolePermissionApps;
	}

}
