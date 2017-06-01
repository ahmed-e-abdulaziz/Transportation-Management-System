package com.transporters.services;

import java.util.List;

import com.transporters.domain.Branch;

public interface BranchGraphService {
	public double distance(double lat1, double lat2, double lon1, double lon2);

	List<Branch> createGraph();
}
 