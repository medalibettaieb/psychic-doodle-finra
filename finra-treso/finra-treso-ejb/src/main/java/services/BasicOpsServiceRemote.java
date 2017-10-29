package services;

import javax.ejb.Remote;

import entities.PermissionApp;
import entities.RoleApp;
import entities.User;

@Remote
public interface BasicOpsServiceRemote<T> {
	void saveOrUpdateUser(User user);

	User findUserById(int id);

	User login(String login, String password);

	void saveOrUpdateOnject(T t);

	void assignRoleToUser(User user, RoleApp roleApp, PermissionApp permissionApp, boolean status);

	RoleApp findRoleById(int id);

	PermissionApp findPermissionAppById(int id);
}
