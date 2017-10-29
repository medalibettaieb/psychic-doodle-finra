package services;

import javax.ejb.Local;

import entities.Course;
import entities.User;

@Local
public interface ReportingServiceLocal {
	int nbBookingByCourse(Course course);

	int nbBookingByTeacher(User teacher);
}
