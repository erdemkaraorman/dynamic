package com.dynamic.program;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Knapsack {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Knapsack knapSack=new Knapsack();
		System.out.println("result is:"+knapSack.go());
	}
	
	public Integer  go() {		
		Integer retVal=0;
		Integer WeightLimit=9;
		TreeMap<Integer,Integer> _hash=new TreeMap<Integer,Integer>();
		_hash.put(1,1);
		_hash.put(2,4 );
		_hash.put(5,7 );
		_hash.put(3,4 );
		_hash.put(4,5 );

		int i=0;
		
		Integer[] weightArray=new Integer[WeightLimit+1];
		for (int k=0;k<weightArray.length;k++) {
			weightArray[k]=k;
		}
		
		Integer [][] dp=new Integer[_hash.size()][weightArray.length];
		
		for (Entry<Integer, Integer> entry : _hash.entrySet()) {
		    System.out.println("i:"+ "," + i + "," + entry.getKey() + "/" + entry.getValue());
		    
			for (int j=0;j<=WeightLimit;j++) {
				if (j==0) {
					dp[i][j]=0;
				}else if(i==0) {
					dp[i][j]=entry.getValue();
				}else if ((entry.getKey() )>weightArray[j]) {
					dp[i][j]=dp[i-1][j];
				}else {
					//max (dp[i-1][j],_hash.get(i)+dp[i-1][j-i]))
					Integer i1=dp[i-1][j];
					Integer i2=entry.getValue()+dp[i-1][j-i-1];
					if (i1>i2) {
						dp[i][j]=i1;
					}else {
						dp[i][j]=i2;
					}
				}
			}	
			i++;
		}		
		retVal=dp[_hash.size()-1][weightArray.length-1];		
		return retVal;
	}	

}
