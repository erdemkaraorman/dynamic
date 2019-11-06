package com.dynamic.program;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Knapsack2 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Knapsack2 knapSack=new Knapsack2();
		System.out.println("result is:"+knapSack.go());
	}
	
	public Integer  go() {
			
	    TreeMap<Integer, Integer> data = new TreeMap<Integer, Integer>();
	    data.put(1,1); data.put(2,4);data.put(3,4);data.put(4,5);data.put(5,7);
	    int maxValue=9;
	    int [][] dp=new int[data.size()][maxValue+1];
	    
	    int i=0;
	    
	    for(Map.Entry<Integer,Integer> entry : data.entrySet()) {
	    	  Integer key = entry.getKey();
	    	  Integer value = entry.getValue();

	    	  for (int k=0;k<=maxValue;k++) {
	    		  if (i==0 ) {
	    			  if (key<=k) {
	    			   dp[i][k]=value;
	    			  }else {
	    				  dp[i][k]=0;
	    			  }
	    		  }else if(key>k)
	    		  {
	    			  dp[i][k]=dp[i-1][k];
	    		  }else {
	    			  int exclude=dp[i-1][k];
	    			  int include=value+dp[i-1][k-i-1];/*+dp[i-1][k]*/
	    			  dp[i][k]=Math.max(exclude, include);
	    		  }
			  }
	    	  i=i+1;

	    	  System.out.println(key + " => " + value);
	    	}
	    
	    return dp[data.size()-1][maxValue];
	}	

}
