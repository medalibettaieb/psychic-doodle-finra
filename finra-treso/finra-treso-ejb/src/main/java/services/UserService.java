package services;

import javax.ejb.Stateless;

import entities.User;
import services.utilities.GenericDAO;

/**
 * Session Bean implementation class UserService
 */
@Stateless
public class UserService extends GenericDAO<User> implements UserServiceRemote, UserServiceLocal {

	public UserService() {
		super(User.class);
	}

}
