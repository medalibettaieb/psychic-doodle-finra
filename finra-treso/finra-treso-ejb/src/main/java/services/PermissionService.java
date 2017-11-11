package services;

import javax.ejb.Stateless;

import entities.PermissionApp;
import services.utilities.GenericDAO;

/**
 * Session Bean implementation class PermissionService
 */
@Stateless
public class PermissionService extends GenericDAO<PermissionApp>
		implements PermissionServiceRemote, PermissionServiceLocal {

	/**
	 * Default constructor.
	 */
	public PermissionService() {
		super(PermissionApp.class);
	}

}
