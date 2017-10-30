package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
public class Student extends User implements Serializable {

	private String studentCard;

	public Student() {
		super();
	}

	public Student(String name, String login, String password, String studentCard) {
		super(name, login, password);
		this.studentCard = studentCard;
	}

	public Student(String name, String studentCard) {
		super(name);
		this.studentCard = studentCard;
	}

	public String getStudentCard() {
		return this.studentCard;
	}

	public void setStudentCard(String studentCard) {
		this.studentCard = studentCard;
	}

}
