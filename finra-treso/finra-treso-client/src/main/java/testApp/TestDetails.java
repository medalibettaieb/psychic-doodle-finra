package testApp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.RoleApp;
import entities.User;
import entities.UserRoleDetail;
import services.BasicOpsServiceRemote;
import services.DetailsRemote;
import services.PermissionServiceRemote;
import services.RoleServiceRemote;
import services.UserServiceRemote;

public class TestDetails {

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
		DetailsRemote detailsRemote = (DetailsRemote) context
				.lookup("finra-treso-ear/finra-treso-ejb/Details!services.DetailsRemote");

		User user = userServiceRemote.find(1);
		RoleApp roleApp = roleServiceRemote.find(6);
		UserRoleDetail entity = new UserRoleDetail(false, user, roleApp);
		detailsRemote.save(entity);
	}

}
