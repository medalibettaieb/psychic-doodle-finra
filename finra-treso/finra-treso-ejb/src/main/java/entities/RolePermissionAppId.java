package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class RolePermissionAppId implements Serializable {
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 2908284603455998213L;
	/**
	 * 
	 */
	private int idRole;
	private int idPermission;
	private Date dateOf;

	public RolePermissionAppId() {
	}

	public RolePermissionAppId(int idRole, int idPermission) {
		super();
		this.idRole = idRole;
		this.idPermission = idPermission;
		this.dateOf = new Date();
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
		RolePermissionAppId other = (RolePermissionAppId) obj;
		if (idPermission != other.idPermission)
			return false;
		if (idRole != other.idRole)
			return false;
		return true;
	}

	public Date getDateOf() {
		return dateOf;
	}

	public void setDateOf(Date dateOf) {
		this.dateOf = dateOf;
	}

}
