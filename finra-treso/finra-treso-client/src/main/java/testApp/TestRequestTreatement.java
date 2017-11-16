package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.ResquestStatus;
import persistence.Room;
import persistence.User;
import services.BasicOpsRemote;
import services.ReportingServiceRemote;
import services.SubscriptionServiceRemote;

public class TestRequestTreatement {

	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("meet-me-ear/meet-me-ejb/BasicOps!services.BasicOpsRemote");
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("meet-me-ear/meet-me-ejb/SubscriptionService!services.SubscriptionServiceRemote");
		ReportingServiceRemote reportingServiceRemote = (ReportingServiceRemote) context
				.lookup("meet-me-ear/meet-me-ejb/ReportingService!services.ReportingServiceRemote");

		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		
		User user=basicOpsRemote.findUserById(4);
		Room room=basicOpsRemote.findRoomById(1);
		Date date=format.parse("2017-10-25");
		
		subscriptionServiceRemote.requestTreatement(user, room, date, ResquestStatus.ACCEPTED);
	}

}
