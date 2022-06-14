package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_2564_경비원 {
	
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1][2];
		
		for(int i=0;i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			mapping(i,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),row,col);
			
		}
		int sum = 0;
		
		if(arr[N-1][0] == 0) {
			for(int i=0; i<N; i++) {
				sum += getD1(i,row,col);
			}
		}
		else if(arr[N-1][0] == row) {
			for(int i=0; i<N; i++) {
				sum += getD1(i,row,col);
			}
		}
		
		else if(arr[N-1][1]==0) {
			for(int i=0; i<N; i++) {
				sum += getD2(i,row,col);	
			}
		}
		
		else if(arr[N-1][1]==col) {
			for(int i=0; i<N; i++) {
				sum += getD2(i,row,col);	
			}
		}
		System.out.print(sum);
		
	}

	public static void mapping(int N,int mod, int number, int row, int col) {	
		if(mod == 1) {			// 상점의 위치 맵핑
			arr[N][0] = 0;
			arr[N][1] = number;
		}
		
		else if (mod == 2) {
			arr[N][0] = row;
			arr[N][1] = number;
		}
		
		else  if (mod == 3) {
			arr[N][0] = number;
			arr[N][1] = 0;
		}
		
		else {
			arr[N][0] = col;
			arr[N][1] = number;
		}
	}
	
	public static int getD1(int n, int row, int col ) {
		int min_value = Integer.MAX_VALUE;
		int idx = arr.length -1;
		
		if(arr[n][0] == arr[idx][0]) {
			min_value = Math.min(min_value, Math.abs(arr[idx][1]-arr[n][1]));
		}
		else if(arr[n][0] + arr[idx][0] == row) {
			min_value = Math.min(min_value, Math.min(row+arr[idx][1]+arr[n][1], row+(col-arr[idx][1])+(col-arr[n][1])));
		}
		
		else if(arr[n][1] < arr[idx][1]) {
			min_value = Math.min(min_value, arr[idx][1]+ (row-arr[n][0]));
		}
		else {
			min_value = Math.min(min_value, (col-arr[idx][1]) + (row-arr[n][0]));
		}
		
		return min_value;
	}
	
	public static int getD2(int n, int row, int col ) {
		int min_value = Integer.MAX_VALUE;
		int idx = arr.length -1;
		
		if(arr[n][1] == arr[idx][1]) {
			min_value = Math.min(min_value, Math.abs(arr[idx][0]-arr[n][0]));
		}
		else if(arr[n][1] + arr[idx][1] == col) {
			min_value = Math.min(min_value, Math.min(col+arr[idx][0]+arr[n][0], col+(row-arr[idx][0])+(row-arr[n][0])));
		}
		
		else if(arr[n][0] < arr[idx][0]) {
			min_value = Math.min(min_value, arr[idx][0]+ arr[n][1]);
		}
		else {
			min_value = Math.min(min_value, (row-arr[idx][0]) + arr[n][1]);
		}
		
		return min_value;
	}
}
