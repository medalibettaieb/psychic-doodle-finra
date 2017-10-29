package testApp;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.PermissionApp;
import entities.RoleApp;
import entities.User;
import services.BasicOpsServiceRemote;

public class TestFindRolesByUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsServiceRemote basicOpsServiceRemote = (BasicOpsServiceRemote) context
				.lookup("finra-treso-ear/finra-treso-ejb/BasicOpsService!services.BasicOpsServiceRemote");

		User user=basicOpsServiceRemote.findUserById(1);
		List<RoleApp> roleApps=basicOpsServiceRemote.findRolesByUser(user);
		for (RoleApp r : roleApps) {
			List<PermissionApp> permissionApps=basicOpsServiceRemote.findAllPermissionByUserAndRole(user, r);
			for (PermissionApp p : permissionApps) {
				System.out.println(p.getId());
			}
		}
	}

}
