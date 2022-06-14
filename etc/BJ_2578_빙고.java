package com.ssafy.im;

import java.io.*;
import java.util.*;

public class BJ_2578_빙고 {
	static int size = 5;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[size][size];		// 원래 빙고
		int[][] arr2 = new int [size][size];	// 사회자가 부르는 수
		int cnt =1;
		
		for(int i=0; i<size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<size; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		for(int i=0; i<size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<size; j++) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				for(int k=0; k<size; k++) {
					for(int p=0; p<size; p++) {
						if(arr[k][p] == arr2[i][j]) {
							arr[k][p] = 0;
						}
					}
				}
				if(checkBingo(arr)) {
					System.out.println(cnt);
					return;
				}
				cnt++;
			}
		}
		
	}
	
	public static boolean checkBingo(int[][] bingo ) {
		int cnt = 0;
		int cnt2 =0;

		for(int i=0; i<size; i++) {			// 가로빙고
			if(bingo[i][0] == 0 && bingo[i][1] == 0 && bingo[i][2] == 0 && bingo[i][3] == 0 && bingo[i][4] == 0) cnt++;
		}
		
		for(int i=0; i<size; i++) {			// 세로빙고
			if(bingo[0][i] == 0 && bingo[1][i] == 0 && bingo[2][i] == 0 && bingo[3][i] == 0 && bingo[4][i] == 0) cnt++;
		}
		
		for(int i=0, j=0; i<size; i++,j++) {	// 대각선1
			if(bingo[i][j]==0) cnt2++;
			if(cnt2==5) cnt++;
		}
		 cnt2 = 0;
		
		
		for(int i=size-1, j=0; i>=0; i--,j++) {	// 대각선2
			if(bingo[i][j]==0) cnt2++;
			if(cnt2==5) cnt++;
		}
		
		
		if(cnt >=3) {
			return true;
		}
		
		return false;
	}
}
