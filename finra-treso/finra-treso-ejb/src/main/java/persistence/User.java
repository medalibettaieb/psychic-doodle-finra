package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "t_user")
public class User implements Serializable {
	private static final long serialVersionUID = -558553967080513790L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String login;
	private String password;

	@OneToOne(mappedBy = "superviser")
	private Room roomSupervised;

	@ManyToOne
	private Room roomSubscribedIn;

	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
	private List<SubscriptionRequest> subscriptionRequests;

	public User() {
		super();
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
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Room getRoomSupervised() {
		return roomSupervised;
	}

	public void setRoomSupervised(Room roomSupervised) {
		this.roomSupervised = roomSupervised;
	}

	public Room getRoomSubscribedIn() {
		return roomSubscribedIn;
	}

	public void setRoomSubscribedIn(Room roomSubscribedIn) {
		this.roomSubscribedIn = roomSubscribedIn;
	}

	public List<SubscriptionRequest> getSubscriptionRequests() {
		return subscriptionRequests;
	}

	public void setSubscriptionRequests(List<SubscriptionRequest> subscriptionRequests) {
		this.subscriptionRequests = subscriptionRequests;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
