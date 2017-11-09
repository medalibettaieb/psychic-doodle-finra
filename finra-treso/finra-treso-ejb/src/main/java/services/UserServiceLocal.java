package services;

import javax.ejb.Local;

import entities.User;
import services.utilities.IGenericDAO;

@Local
public interface UserServiceLocal extends IGenericDAO<User> {

}
