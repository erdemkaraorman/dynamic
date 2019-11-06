package com.dynamic.program;

import java.util.Arrays;
import java.util.HashSet;

public class Graph {

	class Edge{
		int src;
		int dest;
		int weight;
		Edge(){
			src=0;
			dest=0;
			weight=0;
		}
	}
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
	
	public void BellmanFord(Graph g,int pos) {
		int[] vertex=new int[g.V];
		
		for (int l=0;l<vertex.length;l++) {
			vertex[l]=Integer.MAX_VALUE;
		}
		
		vertex[pos]=0;
		System.out.println(Arrays.toString(vertex));
		for (int i=0;i<g.V;i++) {			
			for (int k=pos;k<g.edge.length+pos-1;k++) {
				Edge edge=g.edge[k];
				if (vertex[edge.dest]>edge.weight+vertex[edge.src]) {
					vertex[edge.dest]=edge.weight+vertex[edge.src];
				}			
				//System.out.println(k +":"+Arrays.toString(vertex));

			}
			System.out.println(i+":"+Arrays.toString(vertex));
		}
		
		/*for (int z=0;z<vertex.length;z++) {
			System.out.print( vertex[z] +",");
		}*/
	}
	
	public void Dijkstra(Graph g,int pos) {
		int[] vertex=new int[g.V];
		
		for (int l=0;l<vertex.length;l++) {
			vertex[l]=Integer.MAX_VALUE;
		}
		
		int[] history=new int[g.V];
		
		for (int l=0;l<vertex.length;l++) {
			history[l]=0;
		}
		
		vertex[pos]=0;
		System.out.println(Arrays.toString(vertex));
		
		while ( (pos=this.findMinunumVertexIndex(vertex, history))!=-1) {			
			
			Object[] _arr= findVertecesStartingWith( g, pos);
			for (int k=0;k<_arr.length;k++) {
				Integer z=(Integer) _arr[k];
				Edge edge=g.edge[z]; 
				if (vertex[edge.dest]>edge.weight+vertex[edge.src]) {
					vertex[edge.dest]=edge.weight+vertex[edge.src];
				}			
				//System.out.println(k +":"+Arrays.toString(vertex));

			}
			System.out.println(pos+":"+Arrays.toString(vertex));
		}

		
		
	}
	
	public int findMinunumVertexIndex(int[] vertex,int[] history){
		int minValue=Integer.MAX_VALUE;
		int retIndex=-1;
		for (int i=0;i<vertex.length;i++) {
			if (history[i]==0) {
				if (vertex[i]<minValue) {
					minValue=vertex[i];
					retIndex=i;
				}
			}
		}
		if (retIndex!=-1)
			history[retIndex]=1;
		return retIndex;
	}
	
	public Object[] findVertecesStartingWith(Graph g,int src){
		HashSet<Integer> hash=new HashSet<Integer>();
		
		for (int k=0;k<g.edge.length;k++) {
			Edge edge=g.edge[k];
			if (edge.src==src) {
				hash.add(k);
			}
		}
		return  hash.toArray();
	}

	
	public static void main(String[] args){
		int V = 7; // Number of vertices in graph 
        int E = 10; // Number of edges in graph 
  
        Graph graph = new Graph(V, E); 
  
        // add edge 0-1 (or A-B in above figure) 
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
        graph.edge[0].weight = 6; 
  
        // add edge 0-2 (or A-C in above figure) 
        graph.edge[1].src = 0; 
        graph.edge[1].dest = 2; 
        graph.edge[1].weight = 5; 
  
        // add edge 1-2 (or B-C in above figure) 
        graph.edge[2].src = 0; 
        graph.edge[2].dest = 3; 
        graph.edge[2].weight = 5; 
  
        // add edge 1-3 (or B-D in above figure) 
        graph.edge[3].src = 1; 
        graph.edge[3].dest = 4; 
        graph.edge[3].weight = -1;
        //graph.edge[3].weight = 1;
  
        // add edge 1-4 (or A-E in above figure) 
        graph.edge[4].src = 2; 
        graph.edge[4].dest = 1; 
        graph.edge[4].weight = -2;
        //graph.edge[4].weight = 2;
  
        // add edge 3-2 (or D-C in above figure) 
        graph.edge[5].src = 2; 
        graph.edge[5].dest = 4; 
        graph.edge[5].weight = 1; 
  
        // add edge 3-1 (or D-B in above figure) 
        graph.edge[6].src = 3; 
        graph.edge[6].dest = 2; 
        graph.edge[6].weight = -2;
        //graph.edge[6].weight = 2;
  
        // add edge 4-3 (or E-D in above figure) 
        graph.edge[7].src = 3; 
        graph.edge[7].dest = 5; 
        graph.edge[7].weight = -1;
        //graph.edge[7].weight = 1;
  
        graph.edge[8].src = 4; 
        graph.edge[8].dest = 6; 
        graph.edge[8].weight = 3;
        
        graph.edge[9].src = 5; 
        graph.edge[9].dest = 6; 
        graph.edge[9].weight = 3;
		System.out.println("Bellmann starts");
        graph.BellmanFord(graph, 0);
		System.out.println("Dijkstra starts");
        graph.Dijkstra(graph, 0);
	}
	
}
