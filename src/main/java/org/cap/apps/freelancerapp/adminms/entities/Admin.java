package org.cap.apps.freelancerapp.adminms.entities;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "admin")
@Entity
public class Admin {
	@GeneratedValue
	@Id
	private Long id;

	@Column(nullable = false)
	private String firstName, lastName; 
	
	@Column(nullable = false)
	private String password;

	public Admin() {

	}

	/* Parameterized constructor */

	public Admin(String firstName, String lastName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	/* Getter and Setter */

	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Admin admin = (Admin) o;
		return Objects.equals(id, admin.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
