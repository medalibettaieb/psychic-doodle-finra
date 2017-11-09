package services;

import javax.ejb.Remote;

import entities.User;
import services.utilities.IGenericDAO;

@Remote
public interface UserServiceRemote extends IGenericDAO<User>{

}
