package testApp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.PermissionApp;
import entities.RoleApp;
import entities.Student;
import services.BasicOpsServiceRemote;

public class TestAssignRoleAndPermissionToUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsServiceRemote basicOpsServiceRemote = (BasicOpsServiceRemote) context
				.lookup("finra-treso-ear/finra-treso-ejb/BasicOpsService!services.BasicOpsServiceRemote");

		Student student = (Student) basicOpsServiceRemote.findUserById(1);

		RoleApp roleApp = (RoleApp) basicOpsServiceRemote.findRoleById(1);
		RoleApp roleApp2 = (RoleApp) basicOpsServiceRemote.findRoleById(2);
		RoleApp roleApp3 = (RoleApp) basicOpsServiceRemote.findRoleById(3);

		PermissionApp permissionApp = new PermissionApp("ecron9");
		PermissionApp permissionApp2= new PermissionApp("ecron10");
		PermissionApp permissionApp3= new PermissionApp("ecron11");
		basicOpsServiceRemote.assignRoleToUser(student, roleApp, permissionApp, false);
		
		basicOpsServiceRemote.assignRoleToUser(student, roleApp, permissionApp2, false);
	
		basicOpsServiceRemote.assignRoleToUser(student, roleApp2, permissionApp2, false);
	
		basicOpsServiceRemote.assignRoleToUser(student, roleApp3, permissionApp3, false);
		
	}

}
