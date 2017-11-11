package services;

import javax.ejb.Stateless;

import entities.UserRoleDetail;
import services.utilities.GenericDAO;

/**
 * Session Bean implementation class Details
 */
@Stateless
public class Details extends GenericDAO<UserRoleDetail> implements DetailsRemote {

	/**
	 * Default constructor.
	 */
	public Details() {
		super(UserRoleDetail.class);
	}

}
