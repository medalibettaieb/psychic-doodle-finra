package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entities.BookingDetail;
import entities.Course;
import entities.User;

@Remote
public interface BasicOpsServiceRemote<T> {
	void saveOrUpdateUser(User user);

	void saveOrUpdateCourse(Course course);

	List<Course> findAllCourses();

	BookingDetail findBookingDetailById(User user, Course course, Date date);

	User findUserById(int id);

	List<Course> findAllCoursesByTeacher(User teacher);

	Course findCourseById(int id);

	User login(String login, String password);

	void saveOrUpdateOnject(T t);
}
