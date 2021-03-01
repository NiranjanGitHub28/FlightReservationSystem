package com.app.dao;

import javax.persistence.EntityManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
	private EntityManager mgr;

	@Override
	public Customer authenticateCustomer(String email, String pwd) {
		String jpql = "select c from Customer c where c.email=:em and c.password=:pass";
		return mgr.createQuery(jpql, Customer.class).setParameter("em", email).setParameter("pass", pwd)
				.getSingleResult();

	}

}
