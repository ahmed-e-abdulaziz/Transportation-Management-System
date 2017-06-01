package com.transporters.services;


import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.*;

import com.transporters.domain.Address;
import com.transporters.domain.Branch;
import com.transporters.domain.Employee;


/**
 * A simple introduction to using JGraphT.
 *
 * @author Barak Naveh
 * @since Jul 27, 2003
 */
public final class JGraphT
{
    private JGraphT()
    {
    } // ensure non-instantiability.

    /**
     * The starting point for the demo.
     *
     * @param args ignored.
     */
    static Branch v1 = new Branch();

	
	static Branch v5 = new Branch();
    public static void main(String[] args)
    {
    	SimpleWeightedGraph<Branch, DefaultWeightedEdge> stringGraph = createStringGraph();
        
        // note undirected edges are printed as: {<v1>,<v2>}
        System.out.println(stringGraph.toString());

    	
        System.out.println("Shortest path from vertex1 to vertex5:");
        
        GraphPath<Branch, DefaultWeightedEdge> shortest_path =  DijkstraShortestPath.findPathBetween(stringGraph, v1,v5);
        List<DefaultWeightedEdge> edges = shortest_path.getEdgeList();
        for(DefaultWeightedEdge edge: edges){
        	Branch branchSource = stringGraph.getEdgeSource(edge);
        	Branch branchDest = stringGraph.getEdgeTarget(edge);
            System.out.println(branchSource.getName()+" "+branchSource.getId()+" : "+branchDest.getName()+" "+branchDest.getId()+" Distance "+stringGraph.getEdgeWeight(edge)); 
        }

    }


    /**
     * Create a toy graph based on String objects.
     *
     * @return a graph based on String objects.
     */
    private static SimpleWeightedGraph<Branch, DefaultWeightedEdge> createStringGraph()
    {
    	SimpleWeightedGraph<Branch, DefaultWeightedEdge> g = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
    	Address address = new Address();
    	address.setCountry("City");
    	address.setCity("City");
    	address.setStreet("City");

    	v1.setAddress(address);
    	v1.setId(1);
    	v1.setLatitude(41.3f);
    	v1.setLongitude(44.7f);
    	v1.setManager(new Employee());
    	v1.setMaxOrdersPerDay(3);
    	v1.setPhoneLandline("33333333");
    	v1.setPhoneMobile("01114734723");
    	v1.setName("b1");
    	Branch v2 = new Branch();
    	v2.setAddress(address);
    	v2.setId(2);
    	v2.setLatitude(41.3f);
    	v2.setLongitude(44.7f);
    	v2.setManager(new Employee());
    	v2.setMaxOrdersPerDay(3);
    	v2.setPhoneLandline("33333333");
    	v2.setPhoneMobile("01114734723");
    	v2.setName("b2");
    	Branch v3 = new Branch();
    	v3.setAddress(address);
    	v3.setId(3);
    	v3.setLatitude(44.3f);
    	v3.setLongitude(46.7f);
    	v3.setManager(new Employee());
    	v3.setMaxOrdersPerDay(3);
    	v3.setPhoneLandline("33333333");
    	v3.setPhoneMobile("01114734723");
    	v3.setName("b3");
    	Branch v4 = new Branch();
    	v4.setAddress(address);
    	v4.setId(4);
    	v4.setLatitude(41.3f);
    	v4.setLongitude(44.7f);
    	v4.setManager(new Employee());
    	v4.setMaxOrdersPerDay(3);
    	v4.setPhoneLandline("33333333");
    	v4.setPhoneMobile("01114734723");
    	v4.setName("b4");

    	v5.setAddress(address);
    	v5.setId(5);
    	v5.setLatitude(41.3f);
    	v5.setLongitude(44.7f);
    	v5.setManager(new Employee());
    	v5.setMaxOrdersPerDay(3);
    	v5.setPhoneLandline("33333333");
    	v5.setPhoneMobile("01114734723");
    	v5.setName("b5");
    	
        // add the vertices
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);

        // add edges to create a circuit
        DefaultWeightedEdge e1 = g.addEdge(v1, v2);
        g.setEdgeWeight(e1, 3.3);
        DefaultWeightedEdge e2 = g.addEdge(v2, v3);
        g.setEdgeWeight(e2, 14.3);
        DefaultWeightedEdge e3 = g.addEdge(v3, v4);
        g.setEdgeWeight(e3, 12.3);
        DefaultWeightedEdge e4 = g.addEdge(v4, v5);
        g.setEdgeWeight(e4, 7.3);

        return g;
    }
}

// End HelloJGraphT.java
