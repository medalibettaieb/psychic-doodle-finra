package services;

import java.util.List;

import javax.ejb.Local;

import entities.PermissionApp;
import entities.RoleApp;
import entities.User;
import entities.UserRoleDetail;

@Local
public interface BasicOpsServiceLocal<T> {

	User findUserById(int id);

	User login(String login, String password);

	void saveOrUpdateOnject(T t);

	void saveOrUpdateUser(User user);

	void assignRoleToUser(User user, RoleApp roleApp, PermissionApp permissionApp, boolean status);

	RoleApp findRoleById(int id);

	PermissionApp findPermissionAppById(int id);

	List<UserRoleDetail> findRolesByUser(int id);
}
