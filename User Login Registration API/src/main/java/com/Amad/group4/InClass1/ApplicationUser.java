package com.Amad.group4.InClass1;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class ApplicationUser{

	@Id
	@Column(name="username")
	@Size(min=6, message = "username should be altleast 6 characters long")
	@NotNull
	private String userId;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private Integer age;
	@Column(name="weight")
	private String weight;
	@Column(name="address")
	private String address;
	@Column(name="passw")
	@NotNull
	private String password;
	
	public ApplicationUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ApplicationUser(String userId, String name, Integer age, String weight, String address, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.address = address;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", age=" + age + ", weight=" + weight + ", address="
				+ address + ", password=" + password + "]";
	}
	
}
