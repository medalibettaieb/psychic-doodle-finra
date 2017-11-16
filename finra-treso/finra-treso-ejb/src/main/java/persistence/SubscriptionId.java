package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class SubscriptionId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -423841344467621800L;
	/**
	 * 
	 */
	private int idRoom;
	private int idMember;
	@Temporal(TemporalType.DATE)
	private Date dateOfTheRequest;

	public SubscriptionId() {
	}

	public SubscriptionId(int idRoom, int idMember) {
		super();
		this.idRoom = idRoom;
		this.idMember = idMember;
		this.dateOfTheRequest = new Date();
	}

	public SubscriptionId(int idRoom, int idMember, Date date) {
		super();
		this.idRoom = idRoom;
		this.idMember = idMember;
		this.dateOfTheRequest = date;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public int getIdMember() {
		return idMember;
	}

	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMember;
		result = prime * result + idRoom;
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
		SubscriptionId other = (SubscriptionId) obj;
		if (idMember != other.idMember)
			return false;
		if (idRoom != other.idRoom)
			return false;
		return true;
	}

	public Date getDateOfTheRequest() {
		return dateOfTheRequest;
	}

	public void setDateOfTheRequest(Date dateOfTheRequest) {
		this.dateOfTheRequest = dateOfTheRequest;
	}

}
