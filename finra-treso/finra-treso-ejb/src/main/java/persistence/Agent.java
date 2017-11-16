package persistence;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Agent
 *
 */
@Entity

public class Agent extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2388871171581922161L;
	private String level;

	public Agent() {
		super();
	}

	public Agent(String name, String login, String password, String level) {
		super(name, login, password);
		this.level = level;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
