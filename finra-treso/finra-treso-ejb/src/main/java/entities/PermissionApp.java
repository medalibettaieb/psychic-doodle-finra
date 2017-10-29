package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: PermissionApp
 *
 */
@Entity

public class PermissionApp implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToMany(mappedBy = "permissionApp")
	private List<UserRoleDetail> userRoleDetails;
	private static final long serialVersionUID = 1L;

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

	
	public List<UserRoleDetail> getUserRoleDetails() {
		return userRoleDetails;
	}

	public void setUserRoleDetails(List<UserRoleDetail> userRoleDetails) {
		this.userRoleDetails = userRoleDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
