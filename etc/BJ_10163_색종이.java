package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_10163_색종이 {
	
	static class square{
		int row;
		int col;
		int x_length;
		int y_length;
		int cnt;
		
		public square(int row, int col, int x_length, int y_length, int cnt) {
		
			this.row = row;
			this.col = col;
			this.x_length = x_length;
			this.y_length = y_length;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][] map = new int[1001][1001];
		int N = Integer.parseInt(br.readLine());
		square[] arr = new square[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			
			for(int j = arr[i].row; j<arr[i].x_length+arr[i].row; j++) {
				for(int k = arr[i].col; k< arr[i].y_length+arr[i].col; k++) {
					map[j][k] = i+1;
				}
			}
		}
		
		for(int i=0; i<1001; i++) {
			for(int j = 0; j<1001; j++) {
				for(int k=0; k<N; k++) {
					if(map[i][j] == k+1) {
						arr[k].cnt++;
					}
				}
				
			}
		}
		
		for(square i : arr) {
			System.out.println(i.cnt);
		}
	}

}
