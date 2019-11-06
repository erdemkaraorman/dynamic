package com.dynamic.program;

import java.util.Arrays;

public class MinEditDistance {
	public static void main(String[] args) {
		MinEditDistance min=new MinEditDistance();
		String str1="abcde";
		String str2="abcde";
		System.out.println("min edit distance is:"+min.calculate(str1,str2));
	}
	
	public int calculate(String str1,String str2) {
		int[][] dp=new int[str1.length()+1][str2.length()+1];
		
		for (int i=0;i<=str1.length();i++) {
			for (int k=0;k<=str2.length();k++) {
				if (i==0 && k==0) {
					dp[i][k]=0;							
				}else if (k==0) {
					dp[i][k]=dp[i-1][k]+1;
				}else if (i==0) {
					dp[i][k]=dp[i][k-1]+1;
				}else if (str1.charAt(i-1)==str2.charAt(k-1)) {
					dp[i][k]=dp[i-1][k-1];
				}else {
					dp[i][k]=min (dp[i-1][k-1],dp[i][k-1],dp[i-1][k])+1;
				}
			}
		}
		Arrays.deepToString(dp);
		
		return dp[str1.length()][str2.length()];
	}
	public int min (int i1,int i2,int i3) {
		int retVal=i1;
		if (retVal>i2){
			retVal=i2;
		}
		if (retVal>i3) {
			retVal=i3;
		}		
		return retVal;
	}
}
