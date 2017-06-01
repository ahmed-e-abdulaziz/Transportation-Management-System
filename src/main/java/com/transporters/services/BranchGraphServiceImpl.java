package com.transporters.services;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.springframework.beans.factory.annotation.Autowired;

import com.transporters.domain.Branch;

public class BranchGraphServiceImpl implements BranchGraphService {

	@Autowired
	BranchService branchService;
	
	public BranchService getBranchService() {
		return branchService;
	}

	public void setBranchService(BranchService branchService) {
		this.branchService = branchService;
	}

	/**
	 * Calculate distance between two points in latitude and longitude
	 * @returns Distance in Meters
	 */
	@Override

	public double distance(double lat1, double lat2, double lon1,double lon2) {

	    final int earthRadius = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = earthRadius * c * 1000; // convert to meters


	    distance = Math.pow(distance, 2);

	    return Math.sqrt(distance);
	}

	@Override
	public List<Branch> createGraph(){

		@SuppressWarnings("unchecked")
		List<Branch> branches = (List<Branch>) branchService.listAll();
		SimpleWeightedGraph<Integer, DefaultWeightedEdge> branchesGraph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		for(Branch branch: branches){
			branchesGraph.addVertex(branch.getId());
		}
		for(Branch branch: branches){
			for(Branch otherBranch:branches){
				if(branch!=otherBranch && !branchesGraph.containsEdge(otherBranch.getId(),branch.getId())){
					double distance = this.distance(branch.getLatitude(), otherBranch.getLatitude(), branch.getLongitude(), otherBranch.getLongitude());
					if(distance<230000){
						DefaultWeightedEdge edge = branchesGraph.addEdge(branch.getId(), otherBranch.getId());
						System.out.println("S: "+branch.getName()+" D: "+otherBranch.getName()+" --Distance: "+distance);
						branchesGraph.setEdgeWeight(edge, distance);
					}
					
				}
			}
		}
		Branch portSaidBranch = branchService.getById(2);
		Branch meniaBranch = branchService.getById(14);
		GraphPath<Integer, DefaultWeightedEdge> shortestPath =  
				DijkstraShortestPath.findPathBetween(branchesGraph,portSaidBranch.getId(),meniaBranch.getId());
        List<DefaultWeightedEdge> edges = shortestPath.getEdgeList();
        List<Branch> pathBranches= new ArrayList<Branch>();
        boolean once = true;
        for(DefaultWeightedEdge edge: edges){
        	Branch branchSource = branchService.getById(branchesGraph.getEdgeSource(edge));
        	Branch branchDest = branchService.getById(branchesGraph.getEdgeTarget(edge));
        	if(once){
        		pathBranches.add(branchSource);
        		pathBranches.add(branchDest);
        		once=false;
        	}else{
        		pathBranches.add(branchDest);
        	}
        }
        for(Branch branch: pathBranches){
            System.out.println(branch.getName()+" "+branch.getId()); 
        }

        return pathBranches;
        
		//2)Make sure Order, Schedule - or if needed - ActualSchedule are well designed both in database and as classes
		//3)Implement OrderService using BranchGraphServiceImpl
		//4)Continue
	}	

	
}
