package com.ssafy.im;

import java.io.*;
import java.util.*;

public class BJ_2309_일곱난쟁이 {
	
	static int N = 9;
	static int[] numbers = new int[N];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for(int i=0; i<9; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		int sum = getSum(numbers);
		
		Loop1 :
		for(int i=0; i<N-1; i++) {
			for( int j=i+1 ; j<N; j++) {
				if(sum - numbers[i] - numbers[j] == 100) {
					numbers[i]=0;
					numbers[j]=0;
					break Loop1;
				}
			}
		}
	
		Arrays.sort(numbers);
		
		for(int i=2; i<9; i++) {
			System.out.println(numbers[i]);
		}
	}
	
	public static int getSum(int[] arr) {
		int sum =0;
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		
		return sum;
	}
	
}
