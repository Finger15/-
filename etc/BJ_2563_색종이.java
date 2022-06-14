package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_2563_색종이 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[100][100];	// 도화지
		int size = 10;	// 색종이의 길이
		
		for(int i=0; i<N;i++) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			
			for(int j=row-1; j<row+size-1; j++) {
				for(int k=col-1; k<col+size-1; k++) {
					arr[k][j] = 1;
				}
			}
			
		}
		
		int black = 0;
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j] == 1) {
					black++;
				}	
			}

		}
		System.out.print(black);
	
	}
}
