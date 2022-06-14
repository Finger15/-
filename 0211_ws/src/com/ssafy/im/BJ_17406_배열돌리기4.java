package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_17406_배열돌리기4 {
	
	static int row;
	static int col;	
	static int[][] arr;
	static int[][] rotation;
	static boolean[] visited;
	static int[] result;
	static int N; 
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
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
		
		rotation = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			rotation[i][0] = Integer.parseInt(st.nextToken());
			rotation[i][1] = Integer.parseInt(st.nextToken());
			rotation[i][2] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[N];
		result = new int[N];
		permutation(0, N);
		
		sb.append(min);
		System.out.print(sb);
	}
	
	private static void permutation(int index, int k) {
		if(index == k) {
			int[][] copy = new int[row][col];
			for(int i =0; i<row; i++) {
				for (int j=0; j<col; j++) {
					copy[i][j] = arr[i][j];
				}
			}
			findMin(copy);
			return;
		}
		
		for(int i=0; i<k; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				result[index] =i;
				permutation(index+1, k);
				visited[i] = false;	
			}
		}
	}
	
	public static void findMin(int[][] copy) {
		for(int i=0; i < result.length;i++) {
			int rs = rotation[result[i]][0] - rotation[result[i]][2]-1;
			int cs = rotation[result[i]][1] - rotation[result[i]][2]-1;
			int re = rotation[result[i]][0] + rotation[result[i]][2]-1;
			int ce = rotation[result[i]][1] + rotation[result[i]][2]-1;
			
			while(true) {
				rotate(rs,re,cs,ce,1);
				rs +=1;
				re -=1;
				cs +=1;
				ce -=1;
				
				if(re < rs || cs > ce) break;
			}
		}
		rowcal(copy);
	}
	
	private static void rowcal(int[][] copy) {
		for(int i =0; i<copy.length; i++) {
			int sum =0;
			for(int j=0; j<copy[i].length; j++) {
				sum += copy[i][j];
			}
			min = Math.min(min, sum);
		}
	}

	public static void rotate(int rs, int re, int cs, int ce, int rotate_number) {
		// 회전함수
		
		for(int i=0; i< rotate_number; i++) {
			int tmp = arr[rs][cs];		// 초기값을 저장해준다
			
			for(int j=rs; j<re; j++) {		// 좌
				arr[j][cs] = arr[j+1][cs];
			}
			
			for(int j=cs; j < ce; j++) {		// 하
				arr[re][j] = arr[re][j+1];
			}	
			
			for(int j=re; j>rs; j--) {		// 우
				arr[j][ce] = arr[j-1][ce];
			}	
			
			for(int j = ce; j>cs; j--) {		// 상
				arr[rs][j] = arr[rs][j-1];
			}	
			
			arr[rs][cs+1] = tmp;
		}
		
	}
}
