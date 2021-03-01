package com.app.service;

import com.app.pojos.Customer;

public interface ICustomerService {
	Customer authenticateCustomer(String email, String pwd);

}
