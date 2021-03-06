package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class UserRoleDetailId implements Serializable {
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -6624480886315677775L;
	/**
	 * 
	 */
	private int idUser;
	private int idRole;

	public UserRoleDetailId() {
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

}
