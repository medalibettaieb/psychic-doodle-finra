package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.User;
import services.UserServiceLocal;

@ManagedBean
@ViewScoped
public class UserBean {
	@EJB
	private UserServiceLocal userServiceLocal;
	private List<User> users = new ArrayList<>();
	private boolean showListUsers = true;
	private User userSelected = new User();

	@PostConstruct
	private void init() {
		users = userServiceLocal.findAll();
	}

	public void selectUser() {
		showListUsers = false;

	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public boolean isShowListUsers() {
		return showListUsers;
	}

	public void setShowListUsers(boolean showListUsers) {
		this.showListUsers = showListUsers;
	}

	public User getUserSelected() {
		return userSelected;
	}

	public void setUserSelected(User userSelected) {
		this.userSelected = userSelected;
	}

}
