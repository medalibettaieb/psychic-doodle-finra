package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: PermissionApp
 *
 */
@Entity
@Table(name = "t_perm")
public class PermissionApp implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@OneToMany(mappedBy = "permissionApp")
	private List<RolePermissionApp> rolePermissionApps;

	public PermissionApp() {
		super();
	}

	public PermissionApp(String name) {
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

	public List<RolePermissionApp> getRolePermissionApps() {
		return rolePermissionApps;
	}

	public void setRolePermissionApps(List<RolePermissionApp> rolePermissionApps) {
		this.rolePermissionApps = rolePermissionApps;
	}

}
