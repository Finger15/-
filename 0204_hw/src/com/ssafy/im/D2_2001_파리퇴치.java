package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_2001_파리퇴치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		System.setIn(new FileInputStream("input_D2_2001_파리퇴치.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int[][] arr = new int[size][size];
			
			for(int i =0; i<size; i++) {
				st =new StringTokenizer(br.readLine());
				for(int j =0; j<size; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int sum = 0;
			int max = 0;
			
			for(int i = 0; i < size-num+1; i++) {
				for(int j = 0; j<size-num+1; j++) {
					for(int k =0; k<num;k++) {
						for(int p =0; p<num;p++) {
							sum += arr[i+k][j+p];
						}
					}
					
					if(max < sum) {
						max = sum;
						sum = 0;
					}
					sum =0;
				}
			}
			
			sb.append(max);
			sb.append("\n");
			
		}		
		System.out.println(sb.toString());
		
	}

}
