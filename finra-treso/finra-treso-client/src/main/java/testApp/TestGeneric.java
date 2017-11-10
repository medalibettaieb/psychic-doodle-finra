package testApp;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Student;
import services.UserServiceRemote;

public class TestGeneric {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServiceRemote userServiceRemote = (UserServiceRemote) context
				.lookup("finra-treso-ear/finra-treso-ejb/UserService!services.UserServiceRemote");
		String namedQuery = "User.findUserByName";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", "hamma");
		Student student = (Student) userServiceRemote.findOneResult(namedQuery, parameters);
		System.out.println(student.getName());
	}

}
