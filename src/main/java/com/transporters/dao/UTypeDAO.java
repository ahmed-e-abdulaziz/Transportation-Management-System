package com.transporters.dao;

import com.transporters.domain.UType;

public interface UTypeDAO extends CRUDDAO<UType> {
	
	UType getByName(String type);
}
