package testApp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Course;
import entities.User;
import services.BasicOpsServiceRemote;
import services.ReportingServiceRemote;
import services.SubscriptionServiceRemote;

public class TestAssignCourseToTeacher {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsServiceRemote basicOpsServiceRemote = (BasicOpsServiceRemote) context
				.lookup("music-world-ear/music-world-ejb/BasicOpsService!services.BasicOpsServiceRemote");
		ReportingServiceRemote reportingServiceRemote = (ReportingServiceRemote) context
				.lookup("music-world-ear/music-world-ejb/ReportingService!services.ReportingServiceRemote");
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("music-world-ear/music-world-ejb/SubscriptionService!services.SubscriptionServiceRemote");

		Course course = basicOpsServiceRemote.findCourseById(1);
		User teacher = basicOpsServiceRemote.findUserById(4);
		subscriptionServiceRemote.assignCourseToTeacher(course, teacher);

	}

}
