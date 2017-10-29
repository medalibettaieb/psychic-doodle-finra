package services.utilities;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entities.PermissionApp;
import entities.RoleApp;
import entities.Student;
import entities.Teacher;
import services.BasicOpsServiceLocal;

/**
 * Session Bean implementation class AppUtilities
 */
@Singleton
@LocalBean
@Startup
public class AppUtilities {
	@EJB
	private BasicOpsServiceLocal basicOpsServiceLocal;

	/**
	 * Default constructor.
	 */
	public AppUtilities() {
	}

	@PostConstruct
	public void initDb() {
		Student student = new Student("maissen", "m", "m", "123MT");
		Student student2 = new Student("hamma", "h", "h", "124MT");
		Student student3 = new Student("olfa", "o", "o", "178FT");

		Teacher teacher = new Teacher("sawsen", "s", "s", 5);
		Teacher teacher2 = new Teacher("amal", "a", "a", 1);

		RoleApp roleApp = new RoleApp("financier");
		RoleApp roleApp2 = new RoleApp("anlyste");
		RoleApp roleApp3 = new RoleApp("reporter");
		RoleApp roleApp4 = new RoleApp("dev");

		PermissionApp permissionApp = new PermissionApp("ecran1");
		PermissionApp permissionApp2 = new PermissionApp("ecran2");
		PermissionApp permissionApp3 = new PermissionApp("ecran3");
		PermissionApp permissionApp4 = new PermissionApp("ecran4");

		basicOpsServiceLocal.saveOrUpdateUser(student);
		basicOpsServiceLocal.saveOrUpdateUser(student2);
		basicOpsServiceLocal.saveOrUpdateUser(student3);
		basicOpsServiceLocal.saveOrUpdateUser(teacher);
		basicOpsServiceLocal.saveOrUpdateUser(teacher2);

		basicOpsServiceLocal.saveOrUpdateOnject(roleApp);
		basicOpsServiceLocal.saveOrUpdateOnject(roleApp2);
		basicOpsServiceLocal.saveOrUpdateOnject(roleApp3);
		basicOpsServiceLocal.saveOrUpdateOnject(roleApp4);

		basicOpsServiceLocal.saveOrUpdateOnject(permissionApp);
		basicOpsServiceLocal.saveOrUpdateOnject(permissionApp2);
		basicOpsServiceLocal.saveOrUpdateOnject(permissionApp3);
		basicOpsServiceLocal.saveOrUpdateOnject(permissionApp4);

	}
}
