package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_3431_준환이의운동관리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_D3_3431_준환이의운동관리.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append("#").append(tc).append(" ");
			
			int l = Integer.parseInt(st.nextToken());	// 최소운동값
			int u = Integer.parseInt(st.nextToken());	// 최대운동값
			int x = Integer.parseInt(st.nextToken());	// 실제운동값
			int state = 0;								// 현재상황
			
			if(x<l) {
				state = l-x;
			}
			else if (x>u) {
				state = -1;
			}
			else {
				state = 0;
			}
			
			sb.append(state).append("\n");
		}
		System.out.println(sb);
		
	}

}
