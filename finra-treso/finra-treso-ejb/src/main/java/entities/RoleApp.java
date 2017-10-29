package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: RoleApp
 *
 */
@Entity

public class RoleApp implements Serializable {

	@Id
	private int id;
	private String name;

	@OneToMany(mappedBy = "roleApp")
	private List<UserRoleDetail> userRoleDetails;
	
	@OneToMany(mappedBy="roleApp")
	private List<RolePermissionDetail> rolePermissionDetails;
	private static final long serialVersionUID = 1L;

	public RoleApp() {
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

	public List<UserRoleDetail> getUserRoleDetails() {
		return userRoleDetails;
	}

	public void setUserRoleDetails(List<UserRoleDetail> userRoleDetails) {
		this.userRoleDetails = userRoleDetails;
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
