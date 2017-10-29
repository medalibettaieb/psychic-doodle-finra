package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Course;
import entities.User;

/**
 * Session Bean implementation class ReportingService
 */
@Stateless
public class ReportingService implements ReportingServiceRemote, ReportingServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ReportingService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int nbBookingByCourse(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nbBookingByTeacher(User teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nbBookingByTeacher(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}


}
