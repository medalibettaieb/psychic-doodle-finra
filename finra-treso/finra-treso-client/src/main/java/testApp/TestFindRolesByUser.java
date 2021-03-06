package testApp;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.RoleApp;
import entities.User;
import services.BasicOpsServiceRemote;
import services.UserServiceRemote;

public class TestFindRolesByUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsServiceRemote basicOpsServiceRemote = (BasicOpsServiceRemote) context
				.lookup("finra-treso-ear/finra-treso-ejb/BasicOpsService!services.BasicOpsServiceRemote");
		UserServiceRemote userServiceRemote = (UserServiceRemote) context
				.lookup("finra-treso-ear/finra-treso-ejb/UserService!services.UserServiceRemote");
		User user = userServiceRemote.find(1);
		List<RoleApp> roleApps = basicOpsServiceRemote.findRolesByUser(user);

		for (RoleApp r : roleApps) {
			System.out.println(r.getName());
		}
	}

}
