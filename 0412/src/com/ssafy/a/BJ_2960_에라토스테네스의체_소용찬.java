package com.ssafy.a;

import java.util.*;
import java.io.*;

public class BJ_2960_에라토스테네스의체_소용찬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		boolean[] prime = new boolean[N+1];
		
		prime[0] = prime[1] = false;
		int cnt  = 0;
		
		for(int i=2; i<=N; i++) {
			prime[i] = true;
		}
		
		for(int i=2; i*i <=N; i+=1) {
			for(int j=i*i; j<=N; j+=i) {
				prime[j] =false;
				cnt++;
				
				if(cnt == k) {
					System.out.println(j);
				}
			}
		}

	}

}
