package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: BookingDetail
 *
 */
@Entity

public class BookingDetail implements Serializable {
	@EmbeddedId
	private BookingDetailId bookingDetailId;
	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStatus;

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
	private User student;

	@ManyToOne
	@JoinColumn(name = "idCourse", referencedColumnName = "id", insertable = false, updatable = false)
	private Course course;
	private static final long serialVersionUID = 1L;

	public BookingDetail() {
		super();
	}

	public BookingDetail(User student, Course course) {
		super();
		this.student = student;
		this.course = course;
		this.bookingStatus = BookingStatus.NEW;
		this.bookingDetailId = new BookingDetailId(course.getId(), student.getId());
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public BookingDetailId getBookingDetailId() {
		return bookingDetailId;
	}

	public void setBookingDetailId(BookingDetailId bookingDetailId) {
		this.bookingDetailId = bookingDetailId;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
