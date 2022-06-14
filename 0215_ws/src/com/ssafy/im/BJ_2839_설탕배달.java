package com.ssafy.im;

import java.io.*;
import java.util.*;

public class BJ_2839_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int cnt = Integer.MAX_VALUE;
		
		for(int i=0; i<= N/5; i++) {		
			for(int j=0; j<= N/3; j++) {
				if(N == 5*i + 3*j) {
					cnt = Math.min(cnt, i+j);
				}
			}
		}
		
		if(cnt == Integer.MAX_VALUE) {
			sb.append(-1);
			System.out.println(sb);
		}
		
		else {
			sb.append(cnt);
			System.out.println(sb);
		}
		
	}

}
