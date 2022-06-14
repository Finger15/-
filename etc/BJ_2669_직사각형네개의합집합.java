package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_2669_직사각형네개의합집합 {
	public static void main(String[] args) throws IOException {
		int[][] map = new int[100][100];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			int row1 = Integer.parseInt(st.nextToken()) -1;
			int col1 = Integer.parseInt(st.nextToken()) -1;
			int row2 = Integer.parseInt(st.nextToken()) -1;
			int col2 = Integer.parseInt(st.nextToken()) -1;
			
			for(int k= row1; k<row2; k++) {
				for( int j = col1; j<col2; j++) {
					map[k][j] = 1;
				}
			}
		}
		int cnt = 0;
		
		for(int i=0; i<100; i++) {
			for (int j=0; j<100; j++) {
				if(map[i][j]==1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
