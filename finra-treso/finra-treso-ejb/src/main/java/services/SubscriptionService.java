package services;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.BookingDetail;
import entities.BookingStatus;
import entities.Course;
import entities.User;

/**
 * Session Bean implementation class SuscriptionService
 */
@Stateless
public class SubscriptionService implements SubscriptionServiceRemote, SubscriptionServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	@EJB
	private BasicOpsServiceLocal basicOpsServiceLocal;

	/**
	 * Default constructor.
	 */
	public SubscriptionService() {
	}

	@Override
	public void assignCourseToTeacher(Course course, User teacher) {
		course.setTeacher(teacher);

		basicOpsServiceLocal.saveOrUpdateCourse(course);

	}

	@Override
	public void bookForCourse(User student, Course course) {
		BookingDetail bookingDetail = new BookingDetail(student, course);

		entityManager.merge(bookingDetail);
	}

	@Override
	public void treatBookingRequest(User user, Course course, Date dateOfTheBooking, BookingStatus status) {
		BookingDetail bookingDetail = basicOpsServiceLocal.findBookingDetailById(user, course, dateOfTheBooking);
		bookingDetail.setBookingStatus(status);

		entityManager.merge(bookingDetail);

	}

}
