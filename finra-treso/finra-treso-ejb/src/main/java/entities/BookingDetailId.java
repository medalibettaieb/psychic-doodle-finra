package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class BookingDetailId implements Serializable {

	private int idCourse;
	private int idUser;
	@Temporal(TemporalType.DATE)
	private Date dateOfBooking;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookingDetailId() {
	}

	public BookingDetailId(int idCourse, int idUser) {
		super();
		this.idCourse = idCourse;
		this.idUser = idUser;
		this.dateOfBooking = new Date();
	}

	public BookingDetailId(int idCourse, int idUser, Date dateOfBooking) {
		super();
		this.idCourse = idCourse;
		this.idUser = idUser;
		this.dateOfBooking = dateOfBooking;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCourse;
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
		BookingDetailId other = (BookingDetailId) obj;
		if (idCourse != other.idCourse)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

}
