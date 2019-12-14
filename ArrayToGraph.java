package com.dynamic.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;



public class ArrayToGraph {
	
	class Edge implements Comparable<Edge>{
		int src;
		int dest;
		int weight;
		Edge(){
			src=-1;
			dest=-1;
			weight=-1;
		}
		/*public int compareTo(Edge edge) {
	        return this.weight-edge.weight;
	    }*/
		public int compareTo(Edge edge) {
	        return this.weight-edge.weight;
	    }
	}
	
	
	
	
	class Graph{ 
		
		int V,E;
		
		Edge edge[];
	
		Graph(int v,int e){
			V=v;
			E=e;
			edge=new Edge[e];
			for (int i=0;i<e;i++) {
				edge[i]=new Edge();
			}
		}
		
		public void printAll() {
			for(int i=0;i<edge.length;i++) {
				System.out.print("graph.edge["+i+"].src="+edge[i].src);
				System.out.println(",graph.edge["+i+"].dest="+edge[i].dest);
			}
		}
	}
	
	class Coordinate { 
		
		int x,y;
			
		Coordinate(int newX,int newY){
			x=newX;
			y=newY;
		}
		 		
		public Integer getX() {
			return x;
		}
		
		public Integer getY() {
			return y;
		}
		
		  //Depends only on account number
	    @Override
	    public int hashCode() {
	         
	        return this.getX()*this.getX()+this.getY()*this.getY();
	    }
	 
	    //Compare only account numbers
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Coordinate other = (Coordinate) obj;
	        if (this.getX() != other.getX())
	            return false;
	        if (this.getY() != other.getY())
	            return false;
	        return true;
	    }
	    public String toString() {
	    	return "("+this.getX()+","+this.getY()+")";
	    }
	}
	
	public Coordinate getKeyByValue(Map<Coordinate,Integer> map, Integer value) {
	    for (Entry<Coordinate,Integer> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr= {{1,2,3},{4,5,6},{7,8,9}};
		ArrayToGraph _try=new ArrayToGraph();
		int numberOfVertices=arr.length*arr[0].length;
		int maxNumbOfEdges=(numberOfVertices-1)*(numberOfVertices)/2;
		HashMap<Coordinate,Integer> map=new HashMap<Coordinate,Integer>();
		Integer counter=0;
		for (int i=0;i<arr.length;i++) {		
			for (int k=0;k<arr[i].length;k++) {
				Coordinate c=_try.new Coordinate(i,k);
				map.put(c, counter++);
			}
		}

		
		Graph graph=_try.new Graph(numberOfVertices,maxNumbOfEdges);
		int edgeCounter=0;
		for (int i=0;i<arr.length;i++) {		
			for (int k=0;k<arr[i].length;k++) {
				
				if (k+1<arr[i].length) {
					graph.edge[edgeCounter].weight=arr[i][k+1];
					Coordinate c=_try.new Coordinate(i,k);
					Integer src=map.get(c);
					graph.edge[edgeCounter].src=src;
					Coordinate cDest=_try.new Coordinate(i,k+1);
					Integer dest=map.get(cDest);
					graph.edge[edgeCounter++].dest=dest;	
					
				}
				
				if (i+1<arr.length) {
					graph.edge[edgeCounter].weight=arr[i+1][k];
					Coordinate c=_try.new Coordinate(i,k);
					Integer src=map.get(c);
					graph.edge[edgeCounter].src=src;
					Coordinate cDest=_try.new Coordinate(i+1,k);
					Integer dest=map.get(cDest);
					graph.edge[edgeCounter++].dest=dest;
					
				}
			}
		}		
	
		for(int i=0;i<graph.edge.length;i++) {
			if (graph.edge[i].src==-1) {
				graph.edge=Arrays.copyOf(graph.edge, i);
			}
		}
		
		//graph.printAll();
		for(int i=0;i<graph.edge.length;i++) {			
			System.out.print("graph.edge["+i+"].src="+_try.getKeyByValue(map,graph.edge[i].src));
			System.out.print(",graph.edge["+i+"].dest="+_try.getKeyByValue(map,graph.edge[i].dest));			
			System.out.println(",graph.edge["+i+"].weight="+graph.edge[i].weight);			
		}
		
	}
	


}
