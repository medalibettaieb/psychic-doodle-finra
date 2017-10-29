package testApp;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Course;
import entities.User;
import services.BasicOpsServiceRemote;
import services.ReportingServiceRemote;
import services.SubscriptionServiceRemote;

public class TestFindCoursesByTeacher {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsServiceRemote basicOpsServiceRemote = (BasicOpsServiceRemote) context
				.lookup("music-world-ear/music-world-ejb/BasicOpsService!services.BasicOpsServiceRemote");
		ReportingServiceRemote reportingServiceRemote = (ReportingServiceRemote) context
				.lookup("music-world-ear/music-world-ejb/ReportingService!services.ReportingServiceRemote");
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("music-world-ear/music-world-ejb/SubscriptionService!services.SubscriptionServiceRemote");

		User teacher = basicOpsServiceRemote.findUserById(4);
		List<Course> coursesByTeacher = basicOpsServiceRemote.findAllCoursesByTeacher(teacher);
		
		
		for (Course c : coursesByTeacher) {
			System.out.println(c.getName());
		}

	}

}
