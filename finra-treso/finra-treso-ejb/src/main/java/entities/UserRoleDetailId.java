package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UserRoleDetailId implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private int idUser;
	private int idRole;
	private int idPermission;

	public UserRoleDetailId() {
	}

	public UserRoleDetailId(int idUser, int idRole, int idPermission) {
		super();
		this.idUser = idUser;
		this.idRole = idRole;
		this.idPermission = idPermission;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRole;
		result = prime * result + idUser;
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
		UserRoleDetailId other = (UserRoleDetailId) obj;
		if (idRole != other.idRole)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	public UserRoleDetailId(int idUser, int idRole) {
		super();
		this.idUser = idUser;
		this.idRole = idRole;
	}

	public int getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(int idPermission) {
		this.idPermission = idPermission;
	}

}
