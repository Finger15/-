package com.ssafy.a;

import java.util.*;
import java.io.*;

public class BJ_1929_소수구하기_소용찬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] prime = new boolean[N+1];
		
		prime[0] = prime[1] = false;
		
		for(int i=2; i<=N; i++) {
			prime[i] = true;
		}
		
		for(int i=2; i*i <=N; i+=1) {
			for(int j=i*i; j<=N; j+=i) {
				prime[j] =false;
			}
		}
		
		for(int i=M; i<=N; i++) {
			if(prime[i]) {
				System.out.println(i);
			}
		}
		
	}

}
