package services.utilities;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import persistence.Agent;
import persistence.Gender;
import persistence.Hobby;
import persistence.Member;
import persistence.Room;
import persistence.User;
import services.BasicOpsLocal;

/**
 * Session Bean implementation class AppUtilities
 */
@Singleton
@LocalBean
@Startup
public class AppUtilities {
	@EJB
	private BasicOpsLocal basicOpsLocal;

	/**
	 * Default constructor.
	 */
	public AppUtilities() {
	}

	@PostConstruct
	public void init() {
		Map<Hobby, Integer> hobbiesValues = new HashMap<>();
		hobbiesValues.put(Hobby.MUSIC, 9);
		hobbiesValues.put(Hobby.SPORT, 3);
		hobbiesValues.put(Hobby.TRAVEL, 1);
		Member member = new Member("daly", "d", "d", Gender.MALE, hobbiesValues);

		Map<Hobby, Integer> hobbiesValues2 = new HashMap<>();
		hobbiesValues2.put(Hobby.MUSIC, 8);
		hobbiesValues2.put(Hobby.SPORT, 9);
		hobbiesValues2.put(Hobby.TRAVEL, 2);
		Member member2 = new Member("salma", "s", "s", Gender.FEMALE, hobbiesValues2);

		Map<Hobby, Integer> hobbiesValues3 = new HashMap<>();
		hobbiesValues3.put(Hobby.MUSIC, 5);
		hobbiesValues3.put(Hobby.SPORT, 6);
		hobbiesValues3.put(Hobby.TRAVEL, 9);
		Member member3 = new Member("frere", "f", "f", Gender.MALE, hobbiesValues3);

		Agent agent = new Agent("samir", "sa", "sa", "PRO");

		List<User> members = new ArrayList<>();
		members.add(member);
		members.add(member2);

		Room room = new Room(37, new Color(0, 255, 0));
		room.linkUsersToThisRoom(members);

		Room room2 = new Room(12, new Color(0, 255, 0));
		Room room3 = new Room(15, new Color(255, 255, 0));
		Room room4 = new Room(68, new Color(255, 255, 255));
		basicOpsLocal.addUser(agent);
		basicOpsLocal.addUser(member);
		basicOpsLocal.addUser(member2);
		basicOpsLocal.addUser(member3);

		basicOpsLocal.addRoom(room);
		basicOpsLocal.addRoom(room2);
		basicOpsLocal.addRoom(room3);
		basicOpsLocal.addRoom(room4);

	}

}
