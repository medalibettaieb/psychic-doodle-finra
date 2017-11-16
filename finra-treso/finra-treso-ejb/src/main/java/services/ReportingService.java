package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import persistence.Gender;
import persistence.Member;
import persistence.ResquestStatus;
import persistence.Room;
import persistence.SubscriptionRequest;
import persistence.User;

/**
 * Session Bean implementation class ReportingService
 */
@Stateless
public class ReportingService implements ReportingServiceRemote, ReportingServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private BasicOpsLocal basicOpsLocal;

	/**
	 * Default constructor.
	 */
	public ReportingService() {
	}

	@Override
	public List<User> findAllMembersByRoom(int idRoom) {
		String jpql = "SELECT u FROM User u WHERE u.roomSubscribedIn.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", idRoom);
		return query.getResultList();
	}

	@Override
	public List<Member> findAllMembersByGender(Gender gender) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		return  (List<Member>) criteriaQuery.select(root);

	}

	@Override
	public Room findMostPopularRoom() {
		String jpql = "SELECT sr from SubscriptionRequest sr  GROUP BY sr.room.id ORDER BY COUNT(sr.room.id) desc ";
		Query query = entityManager.createQuery(jpql);
		return basicOpsLocal.findRoomById(query.getFirstResult());
	}

	@Override
	public List<User> findMembersRequestingThisRoom(Room room) {
		String jpql = "SELECT u FROM User u INNER JOIN u.subscriptionRequests usr WHERE usr.room=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", room);
		return query.getResultList();
	}

	@Override
	public List<SubscriptionRequest> findSubscriptionRequestsByStatus(ResquestStatus status) {
		String jpql = "SELECT u FROM SubscriptionRequest u WHERE u.stateOfTheRequest=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", status);
		return query.getResultList();
	}
}
