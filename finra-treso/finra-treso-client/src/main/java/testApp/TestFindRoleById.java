package testApp;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.PermissionApp;
import entities.RoleApp;
import entities.User;
import services.BasicOpsServiceRemote;

public class TestFindRoleById {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsServiceRemote basicOpsServiceRemote = (BasicOpsServiceRemote) context
				.lookup("finra-treso-ear/finra-treso-ejb/BasicOpsService!services.BasicOpsServiceRemote");

		RoleApp app=basicOpsServiceRemote.findRoleById(1);
		
		System.out.println(app.getName());
	}

}
