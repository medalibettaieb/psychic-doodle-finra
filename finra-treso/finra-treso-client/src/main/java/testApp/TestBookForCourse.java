package testApp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Course;
import entities.User;
import services.BasicOpsServiceRemote;
import services.ReportingServiceRemote;
import services.SubscriptionServiceRemote;

public class TestBookForCourse {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsServiceRemote basicOpsServiceRemote = (BasicOpsServiceRemote) context
				.lookup("music-world-ear/music-world-ejb/BasicOpsService!services.BasicOpsServiceRemote");
		ReportingServiceRemote reportingServiceRemote = (ReportingServiceRemote) context
				.lookup("music-world-ear/music-world-ejb/ReportingService!services.ReportingServiceRemote");
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("music-world-ear/music-world-ejb/SubscriptionService!services.SubscriptionServiceRemote");

		User student = basicOpsServiceRemote.findUserById(1);
		Course course = basicOpsServiceRemote.findCourseById(1);
		subscriptionServiceRemote.bookForCourse(student, course);
	}

}
