package testApp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Room;
import persistence.User;
import services.BasicOpsRemote;
import services.ReportingServiceRemote;
import services.SubscriptionServiceRemote;

public class TestRequestForSubscription {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("finra-treso-ear/finra-treso-ejb/BasicOps!services.BasicOpsRemote");
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("finra-treso-ear/finra-treso-ejb/SubscriptionService!services.SubscriptionServiceRemote");

		User member = basicOpsRemote.findUserById(1);

		Room room = basicOpsRemote.findRoomById(5);

		subscriptionServiceRemote.requestForSubscription(member, room);

	}

}
