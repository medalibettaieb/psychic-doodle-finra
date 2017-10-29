package services;

import java.util.Date;

import javax.ejb.Remote;

import entities.BookingStatus;
import entities.Course;
import entities.User;

@Remote
public interface SubscriptionServiceRemote {
	void assignCourseToTeacher(Course course, User teacher);

	void bookForCourse(User student, Course course);

	void treatBookingRequest(User user, Course course, Date dateOfTheBooking, BookingStatus status);

}
