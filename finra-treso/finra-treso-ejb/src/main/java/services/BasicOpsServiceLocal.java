package services;

import java.util.List;

import javax.ejb.Local;

import entities.PermissionApp;
import entities.RoleApp;
import entities.User;
import entities.UserRoleDetail;

@Local
public interface BasicOpsServiceLocal {
	User login(String login, String password);

	RoleApp findRoleById(int id);

	PermissionApp findPermissionAppById(int id);

	List<UserRoleDetail> findRolesDetailsByUser(int id);

	List<PermissionApp> findAllPermissionByUserAndRole(User user, RoleApp roleApp);

	List<RoleApp> findRolesByUser(User user);

	void assignRolesToUser(User user, List<RoleApp> roleApps);
}
