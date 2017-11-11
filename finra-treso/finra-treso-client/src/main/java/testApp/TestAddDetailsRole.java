package testApp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.BasicOpsServiceRemote;
import services.PermissionServiceRemote;
import services.RoleServiceRemote;
import services.UserServiceRemote;

public class TestAddDetailsRole {

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
		
		
	}

}
