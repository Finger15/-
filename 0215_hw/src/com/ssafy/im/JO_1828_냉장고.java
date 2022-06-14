package com.ssafy.im;

import java.util.*;
import java.io.*;

public class JO_1828_냉장고 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(arr[i][1] > arr[j][1]) {
					int tmp1 = arr[i][0];
					int tmp2 = arr[i][1];
					
					arr[i][1] = arr[j][1];
					arr[i][0] = arr[j][0];
					
					arr[j][0] = tmp1;
					arr[j][1] = tmp2;
				}
			}
		}
		
		int cnt = 1;				// 냉장고는 어차피 1대는 필요하다
		int max_value = arr[0][1];	// 최고온도의 값을 배열의 0번째 값으로 설정
		
		for(int i=1; i<N; i++) {	
			if(max_value < arr[i][0]) {	// 최고온도의 값보다 최저온도의 값이 크면
				cnt++;					// 냉자고를 추가하고
				max_value = arr[i][1];	// 최고온도의 값 변경
			}
		}
		
		System.out.println(cnt);
		
	}

}
