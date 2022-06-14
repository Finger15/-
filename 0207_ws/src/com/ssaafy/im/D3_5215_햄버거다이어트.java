package com.ssaafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_5215_햄버거다이어트 {
	
	static int N, L;
	static int[][] arr;
	static int score, cal;
	static int max_score = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input_D3_5215_햄버거다이어트.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			 N = Integer.parseInt(st.nextToken());
			 L = Integer.parseInt(st.nextToken());
			arr = new int [N][2];
			
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0;j<2;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			search(0,0,0);
			sb.append(max_score).append("\n");
			max_score = 0;

		}
		System.out.println(sb);
	}
	
	static void search(int num, int score, int cal) {
		if(cal > L) {
			return;
		}
		if(num == N) {
			if(score>max_score) max_score = score;
			return;
		}
		search(num+1,score+arr[num][0],cal+arr[num][1]);	
		search(num+1,score,cal);							
	}

}
