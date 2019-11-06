package com.codechef.program;

import java.util.Scanner;

public class LifeUniverseEverything {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		long startTime = System.nanoTime();				
		Scanner sc =new Scanner(System.in);
		boolean cont=true;
        while(cont)                 
        {
            int _num=sc.nextInt();    
            if(_num == 42)            
                cont=false;
            System.out.println(_num); 
        }
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
        System.out.println("Bye,time in ms:" +totalTime/1000000);

	}

}
