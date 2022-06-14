package com.ssafy.im;

import java.util.*;
import java.io.*;

public class Bj_16935_배열돌리기3 {
	
	static	int[][] arr;
	static int[][] arr2;
	static int row ;
	static int col ;
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			switch(Integer.parseInt(st.nextToken())) {
			case 1:
				reversRow();
				break;
			case 2:
				reversCol();
				break;
			case 3:
				moveRight();
				break;
			case 4:
				moveLeft();
				break;
			case 5:
				moveRight2();
				break;
			case 6:
				moveLeft2();
				break;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.setLength(sb.length() -1);		// 마지막 공백제거
			sb.append("\n");
		}
		sb.setLength(sb.length() -1);
		System.out.print(sb);
		
	}
	
	public static void reversRow () {	// 상하반전
		int tmp =0;
		
		for(int i=0; i<row/2; i++) {
			for(int j=0; j<col;j++) {
				tmp = arr[i][j];
				arr[i][j] = arr[row-i-1][j];
				arr[row-i-1][j] = tmp;
			}
		}
	}
	
	public static void reversCol() {	// 좌우반전
		int tmp = 0;
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col/2;j++) {
				tmp = arr[i][j];
				arr[i][j] = arr[i][col-j-1];
				arr[i][col-j-1] = tmp;
			}
		}
	}
	
	public static void moveRight () {  // 오른쪽 90도 회전
		arr2 = new int[col][row];
		
		for(int i=0; i<row;i++) {
			for( int j=0; j<col; j++) {
				arr2[j][row-i-1] = arr[i][j]; 
			}
		}
		
		arr = new int [col][row];
		
		for(int i=0; i<col;i++) {
			for(int j=0; j<row; j++) {
				arr[i][j] = arr2[i][j];
			}
		}
		
		int tmp = row;
		row = col;
		col = tmp;
	}
	
	public static void moveLeft () {  // 왼쪽 90도 회전
		arr2 = new int[col][row];
		
		for(int i=0; i<row;i++) {
			for( int j=0; j<col; j++) {
				arr2[col-j-1][i] = arr[i][j]; 
			}
		}
		
		arr = new int [col][row];
		
		for(int i=0; i<col;i++) {
			for(int j=0; j<row; j++) {
				arr[i][j] = arr2[i][j];
			}
		}
		int tmp = row;
		row = col;
		col = tmp;
	}
	
	public static void moveRight2() {	// 십자기준 오른쪽 회전
		arr2 = new int [row][col];
		
		for(int i =0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(i<row/2 && j<col/2) arr2[i][col/2+j] = arr[i][j];
				else if(i<row/2 && j>=col/2) arr2[row/2+i][j] = arr[i][j];
				else if(i>=row/2 && j>=col/2) arr2[i][j-col/2] = arr[i][j];
				else if(i>=row/2 && j<col/2) arr2[i-row/2][j] = arr[i][j];
			}
		}
		
		for(int i=0; i<row;i++) {
			for(int j=0; j<col; j++) {
				arr[i][j] = arr2[i][j];
			}
		}
	}
	
	public static void moveLeft2() {	// 십자기준 왼쪽 회전
		arr2 = new int [row][col];
		
		for(int i =0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(i<row/2 && j<col/2) arr2[row/2+i][j] = arr[i][j];
				else if(i<row/2 && j>=col/2) arr2[i][j-col/2] = arr[i][j];
				else if(i>=row/2 && j>=col/2) arr2[i-row/2][j] = arr[i][j];
				else if(i>=row/2 && j<col/2) arr2[i][col/2+j] = arr[i][j];
			}
		}
		
		for(int i=0; i<row;i++) {
			for(int j=0; j<col; j++) {
				arr[i][j] = arr2[i][j];
			}
		}
	}
}

