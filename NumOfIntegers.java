package com.codechef.program;

import java.util.Arrays;
import java.util.Scanner;

public class NumOfIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		Scanner sc =new Scanner(System.in);
		int[] array= new int[1];
		boolean cont=true;
		NumOfIntegers f=new NumOfIntegers();

		while(cont)                 
        {			
			System.out.print("Number to be followed:");
			int follow=sc.nextInt();;
			System.out.print("Number to be analyzed:");
			int _num=sc.nextInt();
            array[0]=_num;
            long startTime = System.nanoTime();				
    		f.factorial2(follow, array);
    		long endTime = System.nanoTime();
    		long totalTime = endTime - startTime;
            System.out.println("Bye,time in ms:" +totalTime/1000000);

    		if(_num == -1)            
                cont=false;
            //System.out.println(_num); 
        }

		//System.out.println("number of follow:"+f.numberOfCharacters(6,100)); 

	}
	
	public int [] factorial2(int follow,int[] array) {
		int[] retVal=new int[array.length];
				
		for (int i=0;i<array.length;i++) {			
			String number = String.valueOf(array[i]);			
			char[] digits1 = number.toCharArray();
			int [] digits=new int[digits1.length];
			for (int z=0;z<digits.length;z++) {
				digits[z]=Character.getNumericValue(digits1[z]);
			}	
		
			int sum=0;
			boolean followFound=false;
			for (int k=0;k<digits.length;k++) {
				int n=digits.length-k-1;
				int temp=0;									
				temp=n*digits[k]*(int) (Math.pow(10, n-1));
				
				if (digits[k]>follow) {
					temp=temp+(int) (Math.pow(10, n));
				}else if (digits[k]==follow) {
					String tempNum="0";
					for (int l=k+1;l<digits.length;l++) {
						tempNum=tempNum+digits[l];
					}
					Integer remNumber=Integer.valueOf(tempNum);
					temp=temp+remNumber+1;
				}
				sum=sum+temp;
			}
			
			System.out.println("follow:"+follow+",number:"+number +",sum:"+sum+",verify:"/*+this.numberOfCharacters(follow, Integer.valueOf(number))*/);
			
		}
			
		return retVal;
	}

	
	public int [] factorial(int follow,int[] array,int maxNumber) {
		int[] retVal=new int[array.length];
				
		for (int i=0;i<array.length;i++) {			
			String number = String.valueOf(array[i]);			
			char[] digits1 = number.toCharArray();
			int [] digits=new int[digits1.length];
			for (int z=0;z<digits.length;z++) {
				digits[z]=Character.getNumericValue(digits1[digits.length-z-1]);
			}
			
			int[] dp=new int[digits1.length];
			
			for (int k=0;k<digits1.length;k++) {
				int digit= digits[k];
				if (k==0) {
					if (digit<follow) {
						dp[k]=0;
					}else {
						dp[k]=1;
					}
				}else {
					dp[k]=digit * (int) (Math.pow(10, k-1));
					
					if (digit==follow) {
						dp[k]=(digits[k-1]+1)*(int) (Math.pow(10, k-1))+dp[k];
					}else if (digit>follow && digits.length-1 ==k) {
						dp[k]=dp[k]+(int) (Math.pow(10, k));
					}							
					else if (digits.length-1 >k ) {
						//dp[k]=dp[k]+(int) (Math.pow(10, k))+(int) (Math.pow(10, k))*digits[k+1];
						dp[k]=dp[k]+(int) (Math.pow(10, k))*digits[k+1];
					}
				}
			}
			
			int sum=0;
			for (int t=0;t<dp.length;t++)
				sum=sum+dp[t];
			System.out.println("follow:"+follow+",number:"+number +",array:"+ Arrays.toString(dp)+",sum:"+sum+",verify:"+this.numberOfCharacters(follow, Integer.valueOf(number)));
			
		}
			
		return retVal;
	}
	
	public int numberOfCharacters(int follow,int number) {
		int retVal=0;
		String str="";
		for (int i=0;i<=number;i++) {
			str=str+i;
		}
		
		for (int i=0;i<str.length();i++) {
			if (Character.getNumericValue(str.charAt(i))==follow) {
				retVal=retVal+1;
			}
		}
		
		return retVal;
	}
	

}
