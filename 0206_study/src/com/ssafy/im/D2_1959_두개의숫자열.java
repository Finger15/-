package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1959_두개의숫자열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_D2_1959_두개의숫자열.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		for(int tc = 1; tc<=T; tc++) {
			
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int [] a = new int[n];
			int [] b = new int[m];
			
			int max_sum = 0;
			int tmp = 0;
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<n; i++) {
				a[i]=Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				b[j]=Integer.parseInt(st.nextToken());
			}
			
			if(n<m){
				for(int i=0; i<m-n+1; i++) {
					for(int j=0; j<n; j++) {
						
						tmp += a[j] * b[i+j];
						
					}
					
					if(max_sum < tmp ) {
						max_sum = tmp;
						
					}
					tmp =0;
				}
			}
			else if(n>m) {
				for(int i=0; i<n-m+1; i++) {
					for(int j =0; j<m; j++) {
						tmp += a[i+j] * b[j];
					}
					
					if(max_sum < tmp ) {
						max_sum = tmp;
					}
					tmp =0;
				}
			}
			else {
				for(int i=0; i<n; i++) {
					tmp += a[i]*b[i];	
				}
				
				max_sum = tmp;
				
				tmp = 0;
			}
			
			sb.append(max_sum).append("\n");
		}
		System.out.println(sb);
		
	}

}
