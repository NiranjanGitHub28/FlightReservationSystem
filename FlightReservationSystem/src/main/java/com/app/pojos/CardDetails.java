package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class CardDetails {
	@Column(name = "card_number",length = 16,unique = true,nullable = false)
	@NotBlank(message = "Card Number is required")
	@Length(min = 16,max=16,message = "Invalid len of Card Number")
	private String cardNumber;
	
	@Column(length = 20,nullable = false)
	@NotBlank(message = "Name is required")
	private String holderName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future
	@Column(name="expiry_date")
	private LocalDate expiryDate;
	
	@Column(length = 5,nullable = false)
	@NotBlank(message = "CVV is required")
	private String cvv;
	
	public CardDetails() {
		System.out.println("In Constructor of Card Details");
	}
	
	
	public CardDetails(
			@NotBlank(message = "Card Number is required") @Length(min = 16, max = 16, message = "Invalid len of Card Number") String cardNumber,
			@NotBlank(message = "Name is required") String holderName, @Future LocalDate expiryDate,
			@NotBlank(message = "CVV is required") String cvv) {
		super();
		this.cardNumber = cardNumber;
		this.holderName = holderName;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}


	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "CardDetails [cardNumber=" + cardNumber + ", name=" + holderName + ", expiryDate=" + expiryDate + ", cvv="
				+ cvv + "]";
	}
	
	
}
