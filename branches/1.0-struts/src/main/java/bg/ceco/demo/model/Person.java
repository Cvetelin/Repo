package bg.ceco.demo.model;

import java.util.Date;

public class Person {
	private long id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String email;
	private String password;
	private Role role;
	private Permission permission = null;
	

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Person() {}
	
	public Person(String first, String last, Date birth,
			String email, String pass, Role role, Permission permission) {
		firstName = first;
		lastName = last;
		birthDate = birth;
		this.email = email;
		password = pass;
		this.role = role;
		this.permission = permission;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
//	public Permission getPermission() {
//		return permission;
//	}
//
//	public void setPermission(Permission permission) {
//		this.permission = permission;
//	}
}
