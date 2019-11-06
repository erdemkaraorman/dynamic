package com.dynamic.program;

public class Dynamic {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Dynamic rec=new Dynamic();
		int n=6;
		long startTime = System.nanoTime();
		int _sum=rec.go(n);
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("dynamic fibonacci n:" + n +",result:"+ _sum + ",totaltime:"+totalTime/1000000+ " ms");
	}
	
	public int  go(int n) {
		return fibonacci(n);
	}
	
	public int fibonacci(int n) {
		int[] f=new int [n];
		f[0]=0;
		f[1]=1;
		for (int i=2;i<n;i++) {
			f[i]=f[i-1]+f[i-2];
		}
		return f[n-1];
		
	}
	

}
