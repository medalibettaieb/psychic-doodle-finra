package testApp;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.RoleApp;
import entities.User;
import services.BasicOpsServiceRemote;
import services.PermissionServiceRemote;
import services.RoleServiceRemote;
import services.UserServiceRemote;

public class TestAssignRolesToUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsServiceRemote basicOpsServiceRemote = (BasicOpsServiceRemote) context
				.lookup("finra-treso-ear/finra-treso-ejb/BasicOpsService!services.BasicOpsServiceRemote");
		UserServiceRemote userServiceRemote = (UserServiceRemote) context
				.lookup("finra-treso-ear/finra-treso-ejb/UserService!services.UserServiceRemote");
		RoleServiceRemote roleServiceRemote = (RoleServiceRemote) context
				.lookup("finra-treso-ear/finra-treso-ejb/RoleService!services.RoleServiceRemote");
		PermissionServiceRemote permissionServiceRemote = (PermissionServiceRemote) context
				.lookup("finra-treso-ear/finra-treso-ejb/PermissionService!services.PermissionServiceRemote");

		User user = userServiceRemote.find(1);
		
		List<RoleApp> roleApps = new ArrayList<>();
		RoleApp e = roleServiceRemote.find(4);
		roleApps.add(e);
		
		basicOpsServiceRemote.assignRolesToUser(user, roleApps);
	}

}
