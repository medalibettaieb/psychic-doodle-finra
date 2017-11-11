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
public class BasicOpsService implements BasicOpsServiceRemote, BasicOpsServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public BasicOpsService() {
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
	public RoleApp findRoleById(int id) {
		return entityManager.find(RoleApp.class, id);
	}

	@Override
	public PermissionApp findPermissionAppById(int id) {
		return entityManager.find(PermissionApp.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRoleDetail> findRolesDetailsByUser(int id) {
		String jpql = "SELECT DISTINCT r FROM  UserRoleDetail r WHERE r.user.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PermissionApp> findAllPermissionByUserAndRole(User user, RoleApp roleApp) {
		String jpql = "SELECT DISTINCT p FROM  PermissionApp p INNER JOIN p.userRoleDetails pds WHERE pds.user=:param1 AND pds.roleApp=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", user);
		query.setParameter("param2", roleApp);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleApp> findRolesByUser(User user) {
		String jpql = "SELECT  p FROM  RoleApp p  JOIN p.userRoleDetails pds WHERE pds.user=:param ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", entityManager.merge(user));
		return query.getResultList();
	}

	@Override
	public void assignRolesToUser(User user, List<RoleApp> roleApps) {
		for (RoleApp r : roleApps) {
			UserRoleDetail userRoleDetail = new UserRoleDetail(true, user, r);

			entityManager.merge(userRoleDetail);
		}

	}

}
