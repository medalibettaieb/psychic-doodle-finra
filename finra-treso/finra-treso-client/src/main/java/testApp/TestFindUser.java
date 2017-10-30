package testApp;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Student;
import entities.User;
import services.BasicOpsServiceRemote;

public class TestFindUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsServiceRemote basicOpsServiceRemote = (BasicOpsServiceRemote) context
				.lookup("finra-treso-ear/finra-treso-ejb/BasicOpsService!services.BasicOpsServiceRemote");
		Student student = (Student) basicOpsServiceRemote.findUserById(0);

		System.out.println(student.getName());
		
	}

}
