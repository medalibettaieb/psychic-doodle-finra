package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import persistence.ResquestStatus;
import persistence.Room;
import persistence.SubscriptionRequest;
import persistence.User;

@Remote
public interface SubscriptionServiceRemote {
	void assignUserToRoom(User user, Room room);

	void assignRoomToUser(User user, Room room);

	void deleteUserFromRoom(User user);

	void assignSuperviserToRoom(User user, Room room);

	List<Room> matchesRooms(User user);

	List<User> matchesMember(User theNewOne, Room room);

	void requestForSubscription(User member, Room room);

	SubscriptionRequest findSubscriptionRequestById(User user, Room room, Date date);

	void requestTreatement(User user, Room room, Date date, ResquestStatus status);

	List<SubscriptionRequest> findSuscriptionRequestsByRoom(Room room);
	
	List<SubscriptionRequest> findSuscriptionRequestsByMember(User user);
	
	

}
