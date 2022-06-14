package com.ssafy.im;

import java.io.*;
import java.util.*;

public class D4_1210_Ladder1 {

	static int arr[][];
	static int end[];
	static int number;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("input_D4_1210_Ladder1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <=10; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			int T = Integer.parseInt(br.readLine());		// 문제 번호 받아오기
			arr = new int [100][100];
			end = new int [2];
		
			for(int i =0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 2) {		// 도착점에서 시작 따라서 도착점 좌표 저장
						end[0] = i;
						end[1] = j;
					}
				}
			}
			
			int tmp_row = end[0], tmp_col = end[1];
            boolean check = false;
            
            while (tmp_row >= 0) { 		// 왼이동
 
                while (tmp_col - 1 >= 0 && arr[tmp_row][tmp_col - 1] == 1) {
                    tmp_col--;
                    check = true;
                }
 
                if (check) {
                    tmp_row--;
                    check = false;
                    continue;
                }
 
                while (tmp_col + 1 < 100 && arr[tmp_row][tmp_col + 1] == 1) {
                    tmp_col++;		// 오이동
                }	
 
                tmp_row--;
            }
            
			
			sb.append(tmp_col);
			System.out.println(sb);
			
		}
		
	}
	

}
