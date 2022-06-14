package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_9299_한빈이와SpotMart2 {
	
	static int size, weight;
	static int [][] arr;
	static int max_weight = 1;
	static int cnt=0;
	
	public static void main(String[] args) throws NumberFormatException,IOException {
		System.setIn(new FileInputStream("input_D3_9299_한빈이와SpotMart.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
for(int tc= 1; tc<=T;  tc++) {
			
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			 size = Integer.parseInt(st.nextToken());
			 weight = Integer.parseInt(st.nextToken());
			 max_weight = -1;
			 arr = new int[size][1];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<size; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
			}
			
			search(0,0);
			
			sb.append(max_weight).append("\n");
			max_weight = -1;
			cnt = 0;
		}
		System.out.println(sb);

	}

	 static void search(int num, int tmp_weight) {
		if(tmp_weight > weight) {
			return;
		}
		if(num==size) {
			if(tmp_weight > max_weight) max_weight = tmp_weight;
			
			return;
		}
		search(num+1, tmp_weight+arr[num][0]);
		search(num+1, tmp_weight);
	}

}
