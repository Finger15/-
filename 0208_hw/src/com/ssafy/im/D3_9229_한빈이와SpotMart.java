package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_9229_한빈이와SpotMart {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_D3_9299_한빈이와SpotMart.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc= 1; tc<=T;  tc++) {
			
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int size = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			int max_weight = -1;
			int[] arr = new int[size];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<size; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<arr.length-1; i++) {
				for(int  j=i+1; j<arr.length; j++) {
					if(max_weight < arr[i]+arr[j] && weight >= arr[i]+arr[j]) {
						max_weight = arr[i]+arr[j];
					}
				}
			}
			
			sb.append(max_weight).append("\n");
		}
		System.out.println(sb);
	}

}
