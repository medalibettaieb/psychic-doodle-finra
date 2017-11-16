package persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: SubscriptionRequest
 *
 */
@Entity

public class SubscriptionRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9014758666282776054L;
	@EmbeddedId
	private SubscriptionId subscriptionId;
	@Enumerated(EnumType.STRING)
	private ResquestStatus stateOfTheRequest;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "idMember", referencedColumnName = "id", insertable = false, updatable = false)
	private User member;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "idRoom", referencedColumnName = "id", insertable = false, updatable = false)
	private Room room;

	public SubscriptionRequest() {
		super();
	}

	public SubscriptionRequest(User member, Room room) {
		super();
		this.subscriptionId = new SubscriptionId(room.getId(), member.getId());
		this.stateOfTheRequest = ResquestStatus.NEW;
		this.member = member;
		this.room = room;
	}

	public ResquestStatus getStateOfTheRequest() {
		return stateOfTheRequest;
	}

	public void setStateOfTheRequest(ResquestStatus stateOfTheRequest) {
		this.stateOfTheRequest = stateOfTheRequest;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SubscriptionId getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(SubscriptionId subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public User getMember() {
		return member;
	}

	public void setMember(User member) {
		this.member = member;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
