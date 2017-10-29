package services;

import javax.ejb.Remote;

import entities.Course;

@Remote
public interface ReportingServiceRemote {
	int nbBookingByCourse(Course course);

	int nbBookingByTeacher(Course course);
}
