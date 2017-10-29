package testApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.BookingStatus;
import entities.Course;
import entities.User;
import services.BasicOpsServiceRemote;
import services.ReportingServiceRemote;
import services.SubscriptionServiceRemote;

public class TestTreatBookingRequest {

	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		BasicOpsServiceRemote basicOpsServiceRemote = (BasicOpsServiceRemote) context
				.lookup("music-world-ear/music-world-ejb/BasicOpsService!services.BasicOpsServiceRemote");
		ReportingServiceRemote reportingServiceRemote = (ReportingServiceRemote) context
				.lookup("music-world-ear/music-world-ejb/ReportingService!services.ReportingServiceRemote");
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("music-world-ear/music-world-ejb/SubscriptionService!services.SubscriptionServiceRemote");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		User user = basicOpsServiceRemote.findUserById(1);
		Course course = basicOpsServiceRemote.findCourseById(1);
		
		subscriptionServiceRemote.treatBookingRequest(user, course, format.parse("2017-10-27"), BookingStatus.ACCEPTED);
	}

}
