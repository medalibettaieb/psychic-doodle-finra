package services;

import java.util.List;

import javax.ejb.Remote;

import entities.PermissionApp;
import entities.RoleApp;
import entities.User;
import entities.UserRoleDetail;

@Remote
public interface BasicOpsServiceRemote<T> {

	User findUserById(int id);

	User login(String login, String password);

	void saveOrUpdateOnject(T t);

	void saveOrUpdateUser(User user);

	void assignRoleToUser(User user, RoleApp roleApp, PermissionApp permissionApp, boolean status);

	RoleApp findRoleById(int id);

	PermissionApp findPermissionAppById(int id);

	List<UserRoleDetail> findRolesDetailsByUser(int id);

	List<PermissionApp> findAllPermissionByUserAndRole(User user, RoleApp roleApp);

	List<RoleApp> findRolesByUser(User user);
}
