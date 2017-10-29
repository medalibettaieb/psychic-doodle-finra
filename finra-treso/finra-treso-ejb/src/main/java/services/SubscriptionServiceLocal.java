package services;

import java.util.Date;

import javax.ejb.Local;

import entities.BookingStatus;
import entities.Course;
import entities.User;

@Local
public interface SubscriptionServiceLocal {
	void assignCourseToTeacher(Course course, User teacher);

	void bookForCourse(User student, Course course);

	void treatBookingRequest(User user, Course course, Date dateOfTheBooking, BookingStatus status);
}
