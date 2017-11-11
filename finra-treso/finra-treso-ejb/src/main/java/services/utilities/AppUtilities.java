package services.utilities;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entities.PermissionApp;
import entities.RoleApp;
import entities.User;
import services.BasicOpsServiceLocal;
import services.PermissionServiceLocal;
import services.RoleServiceLocal;
import services.UserServiceLocal;

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
	private UserServiceLocal userServiceLocal;
	@EJB
	private PermissionServiceLocal permissionServiceLocal;
	@EJB
	private RoleServiceLocal roleServiceLocal;

	/**
	 * Default constructor.
	 */
	public AppUtilities() {
	}

	@PostConstruct
	public void initDb() {
		User user = new User("daly", "da", "da");
		User user2 = new User("ahmed", "ah", "ah");
		User user3 = new User("arafet", "ar", "ar");

		RoleApp roleApp = new RoleApp("financier");
		RoleApp roleApp2 = new RoleApp("anlyste");
		RoleApp roleApp3 = new RoleApp("reporter");
		RoleApp roleApp4 = new RoleApp("dev");

		PermissionApp permissionApp = new PermissionApp("ecran1");
		PermissionApp permissionApp2 = new PermissionApp("ecran2");
		PermissionApp permissionApp3 = new PermissionApp("ecran3");
		PermissionApp permissionApp4 = new PermissionApp("ecran4");

		userServiceLocal.save(user);
		userServiceLocal.save(user2);
		userServiceLocal.save(user3);

		roleServiceLocal.save(roleApp);
		roleServiceLocal.save(roleApp2);
		roleServiceLocal.save(roleApp3);
		roleServiceLocal.save(roleApp4);

		permissionServiceLocal.save(permissionApp);
		permissionServiceLocal.save(permissionApp2);
		permissionServiceLocal.save(permissionApp3);
		permissionServiceLocal.save(permissionApp4);
	}
}
