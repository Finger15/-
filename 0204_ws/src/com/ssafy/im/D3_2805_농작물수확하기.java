package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		System.setIn(new FileInputStream("input_D3_2805_농작물수확하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T; tc++) {
			
			int size = Integer.parseInt(br.readLine());
			int [][] arr = new int[size][size];
			int sum = 0;
			
			for(int i=0; i<size; i++) {
				String st = br.readLine();
				for(int j =0; j<size; j++) {
					arr[i][j] = st.charAt(j)- '0' ;
				}
			}
			
			for(int i=0; i<size; i++) {
				for(int j =0; j<size; j++) {
					sum += arr[i][j];
				}
			}
		
			
			int col_left = 0;
			int col_right =0;
			int k = (size-1)/2;
			
			for(int i=0; i<(size-1)/2; i++) {		// 왼위
				for(int j =0; j<k; j++ ) {
					sum -= arr[col_left][j];
				}
				col_left++;
				k--;
				
				if(i==(size-1)/2-1) {
					col_left = size-1;
					k = (size-1)/2;
				}
			}
			
		
			
			for(int i=0; i<(size-1)/2; i++) {		// 왼아래
				for(int j =0; j<k; j++ ) {
					sum -= arr[col_left][j];
				}
				col_left--;
				k--;
				
				if(i==(size-1)/2-1) {
					k = (size-1)/2;
				}
			}
		
			
			for(int i=0; i<(size-1)/2; i++) {		// 오위
				for(int j =size-1; j>k; j-- ) {
					sum -= arr[col_right][j];
				}
				col_right++;
				k++;
				
				if(i==(size-1)/2-1) {
					col_right = size-1;
					k = (size-1)/2;
				}
			}
			
			
			for(int i=0; i<(size-1)/2; i++) {		// 오아래
				for(int j =size-1; j>k; j-- ) {
					sum -= arr[col_right][j];
				}
				col_right--;
				k++;
				
				if(i==(size-1)/2-1) {
					k = (size-1)/2;
				}
			}
			;
			
			System.out.println("#"+tc+" "+sum);

		}

	}

}
