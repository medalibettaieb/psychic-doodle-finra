package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Room;
import persistence.User;

/**
 * Session Bean implementation class BasicOps
 */
@Stateless
public class BasicOps implements BasicOpsRemote, BasicOpsLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public BasicOps() {
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(user);
	}

	@Override
	public User findUserById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public void deleteUserById(int id) {
		entityManager.remove(findUserById(id));
	}

	@Override
	public List<User> findAllUsers() {
		String jpql = "SELECT u FROM User u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public void addRoom(Room room) {
		entityManager.persist(room);
	}

	@Override
	public void deleteRoom(Room room) {
		entityManager.remove(entityManager.merge(room));
	}

	@Override
	public void updateRoom(Room room) {
		entityManager.merge(room);
	}

	@Override
	public Room findRoomById(int id) {
		return entityManager.find(Room.class, id);
	}

	@Override
	public List<Room> findAllRooms() {
		return entityManager.createQuery("SELECT z FROM Room z", Room.class).getResultList();
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.login=:param1 AND u.password=:param2");
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("user not found");
		}
		return user;
	}

	@Override
	public void saveOrUpdateUser(User user) {
		entityManager.merge(user);

	}
}
