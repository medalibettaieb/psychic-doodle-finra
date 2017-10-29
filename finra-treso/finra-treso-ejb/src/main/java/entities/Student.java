package entities;

import entities.User;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity

public class Student extends User implements Serializable {

	
	private String studentCard;
	private static final long serialVersionUID = 1L;

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
