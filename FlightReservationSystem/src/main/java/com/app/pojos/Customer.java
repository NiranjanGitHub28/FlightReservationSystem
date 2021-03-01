package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
	@Column(length = 20)
	@NotBlank(message = "Name is required")
	@Length(min = 3, max = 15, message = "Invalid name length")
	private String name = "abc";

	@Column(length = 20, unique = true)
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid Email Format ")
	private String email = "abc@gmail.com";

	@Column(length = 20, nullable = false)
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Blank or Invalid password")
	private String password;

	public Customer() {
		System.out.println("in Customer ctor");
	}

	public Customer(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [email=" + email + ", password=" + password + "]";
	}

}
