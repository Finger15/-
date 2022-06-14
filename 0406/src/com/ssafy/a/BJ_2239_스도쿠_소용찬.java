package com.ssafy.a;

import java.util.*;
import java.io.*;

public class BJ_2239_스도쿠_소용찬 {
	
	static int[][] arr = new int[9][9];
	static ArrayList<int[]> list = new ArrayList<int[]>();
	static boolean end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			String str = br.readLine();
			for(int j=0; j<9; j++) {
				arr[i][j] = str.charAt(j) - '0';
				if(arr[i][j]==0) {
					list.add(new int[] {i,j});
				}
			}
		}
		
		sudoku(0);

	}

	private static void sudoku(int blank) {

		if(list.size() == blank) {			// 모든 빈 칸을 채웠을때 - 기저조건
			
			for(int[] a: arr) {				// 배열을 출력하고
				for(int b : a) {
					System.out.print(b);
				}
				System.out.println();
			}
			
			end = true;						// 스도쿠 완성
			return;
		}
		
		
		boolean[] visited = new boolean[9];	// 중복검사를 위한 배열
		int r = list.get(blank)[0];			// 해당 원소의 r,c값
		int c = list.get(blank)[1];
		
		for(int i=0; i<9; i++) {			
			if(arr[i][c] !=0) {				// 행 중복 검사
				visited[arr[i][c]-1] = true;
			}
			
			if(arr[r][i] != 0) {			// 열 중복 검사
				visited[arr[r][i]-1] = true;
			}
		}
		
		int tmpr = (r/3) *3;
		int tmpc = (c/3) *3;
		
		for(int i= tmpr; i<= tmpr+2; i++) {		// 같은 3*3 구역 중복 검사
			for(int j= tmpc; j<=tmpc+2; j++) {
				if(arr[i][j] != 0) {
					visited[arr[i][j]-1] = true;
				}
			}
		}
		
		for(int i= 0; i<9; i++) {
			if(!visited[i]) {					// 유효한 숫자만
				arr[r][c] = i+1;				// 빈 칸에 채운다
				sudoku(blank+1);				// 다음 빈 칸을 채우러
				if(end) return;					// 스도쿠가 완성 되었는가?
				arr[r][c] = 0;					// 오답이므로 빈 칸으로 만든다
			}
		}
		
	}

}
