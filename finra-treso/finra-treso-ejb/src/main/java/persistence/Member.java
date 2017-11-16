package persistence;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;

/**
 * Entity implementation class for Entity: Member
 *
 */
@Entity

public class Member extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4783105460979854630L;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@ElementCollection(fetch=FetchType.EAGER)
	private Map<Hobby, Integer> hobbiesValues;

	public Member() {
		super();
	}

	public Member(String name, String login, String password, Gender gender, Map<Hobby, Integer> hobbiesValues) {
		super(name, login, password);
		this.gender = gender;
		this.hobbiesValues = hobbiesValues;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Map<Hobby, Integer> getHobbiesValues() {
		return hobbiesValues;
	}

	public void setHobbiesValues(Map<Hobby, Integer> hobbiesValues) {
		this.hobbiesValues = hobbiesValues;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
