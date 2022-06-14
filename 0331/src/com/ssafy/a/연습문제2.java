package com.ssafy.a;

import java.util.*;
import java.io.*;

public class 연습문제2 {
	
	/**
	 * f(n) = f(n-1) * 2 + f(n-2)
	 *
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] arr = new int[7];
		
		arr[1] = 2;
		arr[2] = 5;
	
		for(int i=3; i<=6; i++) {
			arr[i] = arr[i-1] *2 + arr[i-2];
		}	
		
		System.out.println(arr[6]);					
		
	}

}
