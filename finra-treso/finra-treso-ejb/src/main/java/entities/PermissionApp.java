package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: PermissionApp
 *
 */
@Entity

public class PermissionApp implements Serializable {

	@Id
	private int id;
	private String name;

	@OneToMany(mappedBy = "permissionApp")
	private List<RolePermissionDetail> rolePermissionDetails;
	private static final long serialVersionUID = 1L;

	public PermissionApp() {
		super();
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

	public List<RolePermissionDetail> getRolePermissionDetails() {
		return rolePermissionDetails;
	}

	public void setRolePermissionDetails(List<RolePermissionDetail> rolePermissionDetails) {
		this.rolePermissionDetails = rolePermissionDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
