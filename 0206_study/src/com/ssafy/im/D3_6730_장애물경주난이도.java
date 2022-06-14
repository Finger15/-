package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_6730_장애물경주난이도 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_D3_6730_장애물경주난이도.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int size = Integer.parseInt(br.readLine());
			int[] arr = new int[size];
			int up_max = 0;
			int down_max = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<size; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				
				if(i>0) {
					int tmp = arr[i] - arr[i-1];
					
					if(tmp >=0) {
						up_max = (up_max < tmp) ? tmp : up_max;
					}
					else {
						down_max = (down_max > tmp) ? tmp : down_max;
					}
				}
			}
			sb.append(up_max).append(" ").append(-1*down_max).append("\n");
		}
		System.out.println(sb);

	}

}
