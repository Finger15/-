package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_1074 {
	static int callCnt =  0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		int size = (int) Math.pow(2, N);
		search(size,row,col);
		System.out.println(callCnt);
		
		
	}
	
	public static void search(int size, int row, int col) {
		if(size == 1) {
			return;
		}
		
		if(row < size/2 && col < size/2 ) {			// 제2사분면, 왼위
			search(size/2, row, col);
		}
		
		else if(row < size/2 && col >= size/2) {	// 제 1사분면, 왼오
			callCnt += size * size / 4;				// 제 2사분면을 통과함
			search(size/2, row, col - size/2);  	
		}
		
		else if(row>= size/2 && col<size/2) {		// 제 3사분면, 왼아
			callCnt += (size * size /4) * 2;		// 제 1,2사분면 통과
			search(size/2, row - size/2, col);
		}
		else {										// 제 4사분면, 오아
			callCnt += (size*size /4) *3;			// 제 1,2,3사분면 통과
			search(size/2, row-size/2, col-size/2);	
		}
		
	}

}
