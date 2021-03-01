package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPassengerDao;
import com.app.pojos.Passenger;

@Service
@Transactional
public class PassengerServiceImpl implements IPassengerService {
	@Autowired
	private IPassengerDao passDao;
	
	@Override
	public String registerPassenger(Passenger transientPassenger) {
		return passDao.registerPassenger(transientPassenger);
	}

}
