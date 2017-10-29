package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.BookingDetail;
import entities.BookingDetailId;
import entities.Course;
import entities.User;

/**
 * Session Bean implementation class BasicOpsService
 */
@Stateless
public class BasicOpsService implements BasicOpsServiceRemote<Object>, BasicOpsServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public BasicOpsService() {
	}

	@Override
	public void saveOrUpdateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public void saveOrUpdateCourse(Course course) {
		entityManager.merge(course);
	}

	@Override
	public List<Course> findAllCourses() {
		String jpql = "SELECT z FROM Course z";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public User findUserById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<Course> findAllCoursesByTeacher(User teacher) {
		String jpql = "SELECT z FROM Course z WHERE z.teacher=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", teacher);
		return query.getResultList();
	}

	@Override
	public Course findCourseById(int id) {
		return entityManager.find(Course.class, id);
	}

	@Override
	public BookingDetail findBookingDetailById(User user, Course course, Date date) {
		return entityManager.find(BookingDetail.class, new BookingDetailId(course.getId(), user.getId(), date));
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		try {
			user = (User) entityManager.createQuery("select u from User u where u.login=:param1 and u.password=:param2")
					.setParameter("param1", login).setParameter("param2", password).getSingleResult();
		} catch (Exception e) {
		}

		return user;
	}

	@Override
	public void saveOrUpdateOnject(Object t) {
		entityManager.merge(t);
	}

}
