package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "passengers")
public class Passenger extends BaseEntity {
	
	@Column(length = 20)
	@NotBlank(message = "Name is required")
	@Length(min = 3,max=15,message = "Invalid len of Name")
	private String name;
	
	@Column(length = 50,unique =true)
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;
	
	//ONE TO MANY mapping between Entity(passenger) ----> String (phone numbers)
	@ElementCollection //MANDATORY
	@CollectionTable(name="passenger_phones",joinColumns = @JoinColumn(name="passenger_id"))
	@Column(name="phone_no",length = 10,unique = true)
	private List<String> phoneNos=new ArrayList<>();
	
	//ONE TO ONE mapping between Entity (Passenger)  ----> Value Type (CardDetails)
	@Embedded //Optional
	@Valid
	private CardDetails details;
	
	public Passenger() {
		System.out.println("In passenger's Constructor");
	}

	public Passenger(
			@NotBlank(message = "Name is required") @Length(min = 3, max = 15, message = "Invalid len of Name") String name,
			@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,
			List<String> phoneNos, @Valid CardDetails details) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNos = phoneNos;
		this.details = details;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNos() {
		return phoneNos;
	}

	public void setPhoneNos(List<String> phoneNos) {
		this.phoneNos = phoneNos;
	}

	public CardDetails getDetails() {
		return details;
	}

	public void setDetails(CardDetails details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Passenger [name=" + name + ", email=" + email + ", phoneNos=" + phoneNos + "ID= "+getId()+ "]";
	}
	
	
}
