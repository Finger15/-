package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_1954_달팽이숫자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_D2_1954_달팽이숫자.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());		
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			int cnt = 1;
			int col =-1, row=0;
			int sign = 1;
			int tmp = N;
			
			while(N>0) {
				for(int i = 0; i<N;i++) {
					col += sign;
					arr[row][col] = cnt;
					cnt++;
				}
				N--;
				if(N ==0)break;
				
				for(int i = 0; i<N;i++) {
					row += sign;
					arr[row][col]=cnt;
					cnt++;
				}
				sign *= -1;
			}
			N = tmp;
			
			
			System.out.println("#"+tc);
			for(int i=0;i<N; i++) {
				for(int j =0; j<N; j++) {
					System.out.printf("%d ",arr[i][j]);
				}
				System.out.println("");
			}
		}
	}

}
