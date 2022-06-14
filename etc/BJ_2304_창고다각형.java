package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_2304_창고다각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int max_index =0;
		int max_value = Integer.MIN_VALUE;
		int[][] map = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			
			if(max_value < map[i][1]) {
				max_value = map[i][1];
				max_index = map[i][0];
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j = i+1; j<N; j++) {
				if(map[i][0] > map[j][0]) {
					int tmp1 = map[i][0];
					int tmp2 = map[i][1];
					
					map[i][0] = map[j][0];
					map[i][1] = map[j][1];
					map[j][0] = tmp1;
					map[j][1] = tmp2;
				}
			}
		}
		
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			if(map[i][1] == max_value) {
				max_index = i;
				break;
			}
		}
		
		for(int i=0; i<max_index; i++) {
			for(int j= i+1; j<=max_index; j++) {
				if(map[i][1] <= map[j][1]) {
					sum += (map[j][0] - map[i][0]) * map[i][1];
					i=j;
				}
			}
		}
		
		for(int i= N-1; i>max_index; i--) {
			
			for(int j=i-1; j>=max_index; j--) {
				if(map[i][1] <= map[j][1]) {
					sum += (map[i][0] - map[j][0]) * map[i][1];
					i = j;
				}
			}
		}
		
		sum += max_value;
		System.out.print(sum);

	}

}
