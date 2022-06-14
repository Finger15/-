package com.ssafy.a;

import java.util.*;
import java.io.*;

public class 연습문제1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		int[] arr = new int[9];
		
		arr[1] = 2;		
		arr[2] = 3;		
		
		for(int i=3; i<=8; i++) {
			arr[i] = arr[i-1] +arr[i-2];		
		}											
		System.out.println(arr[8]);					
	
	}
	
}
