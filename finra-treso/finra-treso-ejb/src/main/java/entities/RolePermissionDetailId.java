package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RolePermissionDetailId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idRole;
	private int idPermission;

	public RolePermissionDetailId() {
		// TODO Auto-generated constructor stub
	}

	public RolePermissionDetailId(int idRole, int idPermission) {
		super();
		this.idRole = idRole;
		this.idPermission = idPermission;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPermission;
		result = prime * result + idRole;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolePermissionDetailId other = (RolePermissionDetailId) obj;
		if (idPermission != other.idPermission)
			return false;
		if (idRole != other.idRole)
			return false;
		return true;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public int getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(int idPermission) {
		this.idPermission = idPermission;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
