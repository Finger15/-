package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_13300_방배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[6][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			
			arr[age-1][sex]++;
		}
		
		int sum =0;
		
		for(int i=0; i<6; i++) {
			sum += arr[i][0] / K;
			sum += arr[i][1] / K;
			
			if(arr[i][0] != 0 && arr[i][0] %K !=0) {
				sum++;
			}
			if(arr[i][1] != 0 && arr[i][1] %K !=0) {
				sum++;
			}
		}
		
		System.out.println(sum);
	}

}
