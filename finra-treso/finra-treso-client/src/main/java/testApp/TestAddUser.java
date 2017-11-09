package testApp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Student;
import services.BasicOpsServiceRemote;

public class TestAddUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsServiceRemote basicOpsServiceRemote = (BasicOpsServiceRemote) context
				.lookup("finra-treso-ear/finra-treso-ejb/BasicOpsService!services.BasicOpsServiceRemote");

		Student student = new Student("dal", "vip");

		basicOpsServiceRemote.saveOrUpdateOnject(student);

	}

}
