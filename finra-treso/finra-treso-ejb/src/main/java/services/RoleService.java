package services;

import javax.ejb.Stateless;

import entities.RoleApp;
import services.utilities.GenericDAO;

/**
 * Session Bean implementation class RoleService
 */
@Stateless
public class RoleService extends GenericDAO<RoleApp> implements RoleServiceRemote, RoleServiceLocal {

	/**
	 * Default constructor.
	 */
	public RoleService() {
		super(RoleApp.class);
	}

}
