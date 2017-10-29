package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.PermissionApp;
import entities.RoleApp;
import entities.User;
import entities.UserRoleDetail;

/**
 * Session Bean implementation class BasicOpsService
 */
@Stateless
public class BasicOpsService implements BasicOpsServiceRemote<Object>, BasicOpsServiceLocal<Object> {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public BasicOpsService() {
	}

	@Override
	public void saveOrUpdateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public User findUserById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		try {
			user = (User) entityManager.createQuery("select u from User u where u.login=:param1 and u.password=:param2")
					.setParameter("param1", login).setParameter("param2", password).getSingleResult();
		} catch (Exception e) {
		}

		return user;
	}

	@Override
	public void saveOrUpdateOnject(Object t) {
		entityManager.merge(t);
	}

	@Override
	public void assignRoleToUser(User user, RoleApp roleApp, PermissionApp permissionApp, boolean status) {
		UserRoleDetail userRoleDetail = new UserRoleDetail(status, entityManager.merge(user),
				entityManager.merge(roleApp), entityManager.merge(permissionApp));
		entityManager.merge(userRoleDetail);
	}

	@Override
	public RoleApp findRoleById(int id) {
		return entityManager.find(RoleApp.class, id);
	}

	@Override
	public PermissionApp findPermissionAppById(int id) {
		return entityManager.find(PermissionApp.class, id);
	}

	@Override
	public List<UserRoleDetail> findRolesByUser(int id) {
		String jpql = "SELECT r FROM  UserRoleDetail r WHERE r.user.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		return query.getResultList();
	}

}
