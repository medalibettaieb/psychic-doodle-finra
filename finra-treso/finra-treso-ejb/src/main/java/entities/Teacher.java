package entities;

import entities.User;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Teacher
 *
 */
@Entity

public class Teacher extends User implements Serializable {

	private int experience;
	private static final long serialVersionUID = 1L;

	public Teacher() {
		super();
	}

	public Teacher(String name, String login, String password, int experience) {
		super(name, login, password);
		this.experience = experience;
	}

	public Teacher(String name, int experience) {
		super(name);
		this.experience = experience;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
   
}
