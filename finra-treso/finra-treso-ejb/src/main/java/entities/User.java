package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "t_user")
@NamedQuery(name = "User.findUserByName", query = "select u from User u where u.name = :name")
public class User implements Serializable {
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1226029415726623271L;

	/**
	 * 
	 */

	public static final String FIND_BY_NAME = "User.findUserByName";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String login;
	private String password;

	@OneToMany(mappedBy = "user")
	private List<UserRoleDetail> userRoleDetails;

	public User() {
		super();
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public User(String name, String login, String password) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserRoleDetail> getUserRoleDetails() {
		return userRoleDetails;
	}

	public void setUserRoleDetails(List<UserRoleDetail> userRoleDetails) {
		this.userRoleDetails = userRoleDetails;
	}

}
