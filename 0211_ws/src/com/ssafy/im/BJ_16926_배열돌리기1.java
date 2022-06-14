package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_16926_배열돌리기1 {
	
	static int row;		// 행
	static int col;		// 열
	static int N;		// 회전수
	static int[][] arr;	// 숫자를 저장할 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		
		for(int i=0; i<row; i++) {
		 st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int rs = 0;		 
		int re = row-1;
		int cs = 0;
		int ce = col-1;
		
		while(true) {
			int size = (re - rs +1)*2 + (ce-cs+1)*2 -4; // 상하좌우 - 중복 꼭지점 갯수
			rotate(rs,re,cs,ce,N%size);
			rs +=1;
			re -=1;
			cs +=1;
			ce -=1;
			
			if(re < rs || cs > ce) break;
		}
		
		for(int i=0; i<row; i++) {				// 출력
			for(int j=0; j<col; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void rotate(int rs, int re, int cs, int ce, int rotate_number) {
		// 회전함수
		
		for(int i=0; i< rotate_number; i++) {
			int tmp = arr[rs][cs];		// 초기값을 저장해준다
			
			for(int j=cs; j<ce; j++) {		// 상
				arr[rs][j] = arr[rs][j+1];
			}
			
			for(int j=rs; j<re; j++) {		// 우
				arr[j][ce] = arr[j+1][ce];
			}
			
			
			for(int j=ce; j > cs; j--) {	// 하
				arr[re][j] = arr[re][j-1];
			}
			
			for(int j=re; j>rs; j--) {
				arr[j][cs] = arr[j-1][cs];	// 좌
			}
			
			arr[rs+1][cs] = tmp;
		}
		
	}

}
