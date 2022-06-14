package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class D3_swbasic_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		System.setIn(new FileInputStream("input_D3_swbasic_Flatten.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;	// 카운터
		int [] boxes = new int[100];	// 박스
		
		for(int tc =1; tc<=10; tc++) {
			
			cnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<100; i++) {
				boxes[i] = Integer.parseInt(st.nextToken());	// 입력값 배열에 매핑
			}
			
			for(int j=0; j<cnt; j++) {
				Arrays.sort(boxes);
				boxes[99]--;
				boxes[0]++;
				
				if(j== cnt-1) {
					Arrays.sort(boxes);
				}
			}
			
			System.out.println("#"+tc+" "+(boxes[99]-boxes[0]));
			
		}

	}

}
