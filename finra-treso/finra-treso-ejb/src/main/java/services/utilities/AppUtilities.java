package services.utilities;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entities.Course;
import entities.Student;
import entities.Teacher;
import services.BasicOpsServiceLocal;
import services.ReportingServiceLocal;
import services.SubscriptionServiceLocal;

/**
 * Session Bean implementation class AppUtilities
 */
@Singleton
@LocalBean
@Startup
public class AppUtilities {
	@EJB
	private BasicOpsServiceLocal basicOpsServiceLocal;
	@EJB
	private SubscriptionServiceLocal subscriptionServiceLocal;

	@EJB
	private ReportingServiceLocal reportingServiceLocal;

	/**
	 * Default constructor.
	 */
	public AppUtilities() {
	}

	@PostConstruct
	public void initDb() {
		Student student = new Student("maissen", "m", "m", "123MT");
		Student student2 = new Student("hamma",  "h", "h","124MT");
		Student student3 = new Student("olfa", "o", "o", "178FT");

		Teacher teacher = new Teacher("sawsen", "s", "s", 5);
		Teacher teacher2 = new Teacher("amal", "a", "a", 1);

		Course course = new Course("Java EE 7");
		Course course2 = new Course("R&B");

		basicOpsServiceLocal.saveOrUpdateUser(student);
		basicOpsServiceLocal.saveOrUpdateUser(student2);
		basicOpsServiceLocal.saveOrUpdateUser(student3);
		basicOpsServiceLocal.saveOrUpdateUser(teacher);
		basicOpsServiceLocal.saveOrUpdateUser(teacher2);

		basicOpsServiceLocal.saveOrUpdateCourse(course);
		basicOpsServiceLocal.saveOrUpdateCourse(course2);

	}
}
