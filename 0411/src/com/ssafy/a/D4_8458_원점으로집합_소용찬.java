package com.ssafy.a;

import java.util.*;
import java.io.*;

public class D4_8458_원점으로집합_소용찬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int [] number = new int[N];
			int max = Integer.MIN_VALUE;
			boolean go = true;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				number[i] = Math.abs(r) + Math.abs(c);
				max = Math.max(max, number[i]);
				
				if(i > 0 && number[i] % 2 != number[i-1] %2) go = false;
			}
			
			if(!go) {
				System.out.println("#"+tc+" -1");
				continue;
			}
			
			int sum = 0;
			int cnt = 0;
			
			while(true) {
				if(sum >= max && (sum-max) %2 ==0) break;
				sum += ++cnt;
			}
			
			System.out.println("#"+tc+" "+cnt);

		}
		
	}
}
