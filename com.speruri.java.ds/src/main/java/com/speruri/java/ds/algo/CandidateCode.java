package com.speruri.java.ds.algo;

import java.util.Scanner;

public class CandidateCode {
	public static void main(String args[] ) throws Exception {

    	//Scanner scanner = new Scanner(System.in);
        int number = 34567892;//scanner.nextInt();
        
        int total = 0;
        int remainder = number;
        
        
        while(remainder > 0){
            remainder = remainder/10;
            total++;
        }
        
        System.out.println(total);
        System.out.println("Using recursion : " + divideAndcount(number, 0));
   }
	
	public static int divideAndcount(int remainder, int count){
		if(remainder < 1){
			return count;
		}
		
		remainder = remainder/10;
		count++;
		return divideAndcount(remainder, count);
	}
}
