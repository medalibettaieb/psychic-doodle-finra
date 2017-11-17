package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import persistence.Room;
import persistence.User;
import services.BasicOpsLocal;
import services.ReportingServiceLocal;
import services.SubscriptionServiceLocal;

@ManagedBean

public class RequestBean {
	private User user = new User();
	private Room room = new Room();

	@EJB
	private BasicOpsLocal basicOpsLocal;
	@EJB
	private SubscriptionServiceLocal subscriptionServiceLocal;
	@EJB
	private ReportingServiceLocal reportingServiceLocal;

	public void dodo() {
		user = basicOpsLocal.findUserById(1);
		room = basicOpsLocal.findRoomById(5);

		subscriptionServiceLocal.requestForSubscription(user, room);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
