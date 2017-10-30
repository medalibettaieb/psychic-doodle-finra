package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Student;
import entities.User;
import services.BasicOpsServiceLocal;

@ManagedBean
@SessionScoped
public class Identity {
	private User user = new User();
	private Boolean isLogged = false;
	private Boolean loggedInAsTeacher = false;
	private Boolean loggedInAsStudent = false;
	@EJB
	private BasicOpsServiceLocal basicOpsServiceLocal;

	public String doLogin() {
		String navigateTo = null;
		User userLoggedIn = basicOpsServiceLocal.login(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			isLogged = true;
			if (userLoggedIn instanceof Student) {
				loggedInAsStudent = true;
				navigateTo = "/pages/home?faces-redirect=true";
			}
		} else {
			navigateTo = "/fail?faces-redirect=true";
		}
		return navigateTo;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedInAsTeacher() {
		return loggedInAsTeacher;
	}

	public void setLoggedInAsTeacher(Boolean loggedInAsTeacher) {
		this.loggedInAsTeacher = loggedInAsTeacher;
	}

	public Boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}

	public Boolean getLoggedInAsStudent() {
		return loggedInAsStudent;
	}

	public void setLoggedInAsStudent(Boolean loggedInAsStudent) {
		this.loggedInAsStudent = loggedInAsStudent;
	}

}
