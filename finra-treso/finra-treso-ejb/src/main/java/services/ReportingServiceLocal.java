package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Gender;
import persistence.Member;
import persistence.ResquestStatus;
import persistence.Room;
import persistence.SubscriptionRequest;
import persistence.User;

@Local
public interface ReportingServiceLocal {
	List<User> findAllMembersByRoom(int idRoom);

	List<Member> findAllMembersByGender(Gender gender);

	Room findMostPopularRoom();

	List<User> findMembersRequestingThisRoom(Room room);

	List<SubscriptionRequest> findSubscriptionRequestsByStatus(ResquestStatus status);
}
