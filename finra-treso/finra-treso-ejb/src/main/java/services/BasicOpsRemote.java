package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Room;
import persistence.User;

@Remote
public interface BasicOpsRemote {
	void saveOrUpdateUser(User user);

	void addUser(User user);

	void deleteUser(User user);

	User findUserById(int id);

	void updateUser(User user);

	void deleteUserById(int id);

	List<User> findAllUsers();

	void addRoom(Room room);

	void deleteRoom(Room room);

	void updateRoom(Room room);

	Room findRoomById(int id);

	List<Room> findAllRooms();

	User login(String login, String password);

}
