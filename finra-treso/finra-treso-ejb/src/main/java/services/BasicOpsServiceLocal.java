package services;

import javax.ejb.Local;

import entities.User;

@Local
public interface BasicOpsServiceLocal<T> {
	void saveOrUpdateUser(User user);

	User findUserById(int id);

	User login(String login, String password);

	void saveOrUpdateOnject(T t);
}
