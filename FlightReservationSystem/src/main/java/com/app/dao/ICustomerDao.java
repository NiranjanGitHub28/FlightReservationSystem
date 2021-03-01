package com.app.dao;

import com.app.pojos.Customer;

public interface ICustomerDao {

	Customer authenticateCustomer(String email, String pwd);

}
