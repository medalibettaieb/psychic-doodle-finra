package persistence;

import java.awt.Color;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Room
 *
 */
@Entity
@Table(name = "t_room")
public class Room implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6068987072761990560L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int number;
	private Color color;

	@OneToOne
	private User superviser;

	@OneToMany(mappedBy = "roomSubscribedIn", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<User> members;

	@OneToMany(mappedBy = "room")
	private List<SubscriptionRequest> subscriptionRequests;

	public Room() {
		super();
	}

	public Room(int number, Color color) {
		super();
		this.number = number;
		this.color = color;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public User getSuperviser() {
		return superviser;
	}

	public void setSuperviser(User superviser) {
		this.superviser = superviser;
	}

	public void linkUsersToThisRoom(List<User> users) {
		this.members = users;
		for (User u : users) {
			u.setRoomSubscribedIn(this);
		}
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
